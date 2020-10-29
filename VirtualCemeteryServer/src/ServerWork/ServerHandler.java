package ServerWork;

import Foundation.Command;

import java.net.SocketAddress;
import java.nio.channels.DatagramChannel;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ServerHandler implements Runnable {
    private ExecutorService poolSender = Executors.newCachedThreadPool();
    private Command command;
    private SocketAddress socketAddress;
    private DatagramChannel datagramChannel;

    public ServerHandler(Command command, SocketAddress socketAddress, DatagramChannel datagramChannel) {
        this.command = command;
        this.socketAddress = socketAddress;
        this.datagramChannel = datagramChannel;
    }

    /**
     * Метод обрабаывает запрос согласно команде
     * Пока не понятно будут ли они в отдельных классах или только в бд
     */
    @Override
    public void run() {
        switch (command.getCommand()) {
            case "reg":
//                poolSender.execute(new ServerSender(Database.getDatabase().registration(command), socketAddress, datagramChannel));
                break;
            case "auth":
//                poolSender.execute(new ServerSender(Database.getDatabase().authorization(command), socketAddress, datagramChannel));
        }
    }
}