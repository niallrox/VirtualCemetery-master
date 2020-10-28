package ClientWork;

import java.io.IOException;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.util.Scanner;

public class ClientConnection {
    private ClientSender clientSender = new ClientSender();
    private ClientReceiver clientReceive = new ClientReceiver();
    private ClientHandler clientHandler = new ClientHandler();

    public void connection() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите портик");
        int port = Integer.parseInt(scanner.nextLine());
        SocketAddress socketAddress = new InetSocketAddress("localhost", port);
        try (DatagramSocket datagramSocket = new DatagramSocket()) {
            datagramSocket.connect(socketAddress);
            while (true) {
                String command = scanner.nextLine();
                clientSender.sendCommand(datagramSocket, socketAddress, clientHandler.handle(command));
                System.out.println(clientReceive.receiveCommand(datagramSocket));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
