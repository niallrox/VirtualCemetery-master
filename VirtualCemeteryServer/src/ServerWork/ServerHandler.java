package ServerWork;

import Foundation.Command;

import java.net.SocketAddress;
import java.nio.channels.DatagramChannel;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ServerHandler implements Runnable {
    private Command command;
    private SocketAddress socketAddress;
    private DatagramChannel datagramChannel;
    private ExecutorService poolSender = Executors.newCachedThreadPool();

    public ServerHandler(Command command, SocketAddress socketAddress, DatagramChannel datagramChannel) {
        this.command = command;
        this.socketAddress = socketAddress;
        this.datagramChannel = datagramChannel;
    }

    @Override
    public void run() {
        System.out.println(command);
        switch (command.getCommand()) {
            case "add":
                poolSender.execute(new ServerSender(new Command("Вы похоронили" + command.getGrave().getName(), command.getGrave()), socketAddress, datagramChannel));
            default:
                poolSender.execute(new ServerSender(new Command("Неизвестная команда", null), socketAddress, datagramChannel));
        }
    }
}
