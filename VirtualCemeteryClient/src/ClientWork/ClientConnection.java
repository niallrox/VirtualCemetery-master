package ClientWork;

import java.io.IOException;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.util.Scanner;

public class ClientConnection {
    private ClientHandler clientHandler = new ClientHandler();
    private Scanner scanner = new Scanner(System.in);

    public void connection() {
        System.out.println("Введите порт");
        SocketAddress socketAddress = new InetSocketAddress("localhost", Integer.parseInt(scanner.nextLine()));
        try (DatagramSocket datagramSocket = new DatagramSocket()) {
            datagramSocket.connect(socketAddress);
            while (true) {
                clientHandler.handle(scanner.nextLine(), datagramSocket, socketAddress);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}