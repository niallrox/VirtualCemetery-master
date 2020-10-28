package ServerWork;

import Foundation.Command;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ServerReceiver implements Runnable {
    private DatagramChannel dc;
    private ExecutorService poolHandle = Executors.newCachedThreadPool();

    public ServerReceiver(DatagramChannel dc) {
        this.dc = dc;
    }

    private SocketAddress socketAddress;

    public SocketAddress getSocketAddress() {
        return socketAddress;
    }

    @Override
    public void run() {
        try {
            byte[] sendBuf = new byte[4096];
            ByteBuffer byteBuffer = ByteBuffer.wrap(sendBuf);
            byteBuffer.clear();
            do {
                socketAddress = dc.receive(byteBuffer);
            } while (socketAddress == null);
            try (ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(sendBuf);
                 ObjectInputStream fromServer = new ObjectInputStream(byteArrayInputStream)) {
                poolHandle.execute(new ServerHandler((Command) fromServer.readObject(), socketAddress, dc));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
