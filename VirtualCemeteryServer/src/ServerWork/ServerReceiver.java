package ServerWork;

import Foundation.Command;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;
import java.util.concurrent.Callable;

public class ServerReceiver implements Callable<Command> {
    private DatagramChannel dc;
    private byte[] sendBuf = new byte[4096];
    private ByteBuffer byteBuffer = ByteBuffer.wrap(sendBuf);
    private SocketAddress socketAddress;

    public ServerReceiver(DatagramChannel dc) {
        this.dc = dc;
    }

    public SocketAddress getSocketAddress() {
        return socketAddress;
    }

    /**
     * Метод получает сапрос от сервера
     * с null возможны ошибки пока не ебу))
     *
     * @return
     */
    @Override
    public Command call() {
        try {
            byteBuffer.clear();
            do {
                socketAddress = dc.receive(byteBuffer);
            } while (socketAddress == null);
            try (ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(sendBuf);
                 ObjectInputStream fromServer = new ObjectInputStream(byteArrayInputStream)) {
                return (Command) fromServer.readObject();
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }
}