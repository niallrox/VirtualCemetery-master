package ClientWork;

import Foundation.Command;

import java.net.DatagramSocket;
import java.net.SocketAddress;
import java.util.Scanner;

public class ClientHandler {
    private Scanner scanner = new Scanner(System.in);
    private ClientSender clientSender = new ClientSender();
    private ClientReceiver clientReceive = new ClientReceiver();

    public void handle(String command, DatagramSocket datagramSocket, SocketAddress inetSocketAddress) {
        switch (command) {
            case "auth":
            case "reg":
                System.out.println("Введите логин");
                String login = scanner.nextLine();
                System.out.println("Введите пароль");
                String password = scanner.nextLine();
                clientSender.sendCommand(datagramSocket, inetSocketAddress, new Command(command, login, password));
                System.out.println(clientReceive.receiveCommand(datagramSocket).getCommand());
                break;
            default:
                System.out.println("Че за хуйню ты ввел?");
        }
    }
}