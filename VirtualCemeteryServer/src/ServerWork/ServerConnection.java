package ServerWork;

import Foundation.Command;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.DatagramChannel;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ServerConnection {
    private ExecutorService poolReceive = Executors.newCachedThreadPool();
    private ExecutorService poolHandle = Executors.newCachedThreadPool();

    /**
     * Метод реализует подключение клиентов к серверу и к БД
     * В цикле while чтение блокируется до тех пор пока не появятся данные
     */
    public void connection() {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Введите порт");
            int port = Integer.parseInt(scanner.nextLine());
            InetSocketAddress socketAddress = new InetSocketAddress(port);
            System.out.println("Сервер запущен");
            DatagramChannel datagramChannel = DatagramChannel.open();
            datagramChannel.bind(socketAddress);
            datagramChannel.configureBlocking(false);
//            Database.getDatabase().connectToBD();
            while (true) {
                ServerReceiver receiver = new ServerReceiver(datagramChannel);
                Future<Command> future = poolReceive.submit(receiver);
                poolHandle.execute(new ServerHandler(future.get(), receiver.getSocketAddress(), datagramChannel));
            }
        } catch (IOException | ExecutionException | InterruptedException e) {
            // Исключение не мешает логике исполнения программы
            // Можно вписать логи
            e.printStackTrace();
        }
    }
}