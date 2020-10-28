package ServerWork;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.DatagramChannel;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ServerConnection {
    private ExecutorService poolReceive = Executors.newCachedThreadPool();

    public void connection() {
        try {
        DatagramChannel datagramChannel = DatagramChannel.open();
            System.out.println("Грязный порт");
            Scanner scanner = new Scanner(System.in);
            int port = scanner.nextInt();
            InetSocketAddress socketAddress = new InetSocketAddress(port);
            datagramChannel.bind(socketAddress);
            datagramChannel.configureBlocking(false);
            poolReceive.execute(new ServerReceiver(datagramChannel));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
