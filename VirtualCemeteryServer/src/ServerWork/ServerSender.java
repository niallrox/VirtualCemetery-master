package ServerWork;

import Foundation.Command;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;

public class ServerSender implements Runnable {
    private Command command;
    private SocketAddress address;
    private DatagramChannel datagramChannel;


    public ServerSender(Command command, SocketAddress address, DatagramChannel datagramChannel) {
        this.command = command;
        this.address = address;
        this.datagramChannel = datagramChannel;
    }


    /**
     * Метод отправляет результат на клиент
     * Тут все вроде четко
     */
    @Override
    public void run() {
        try (ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream)) {
            objectOutputStream.writeObject(command);
            objectOutputStream.flush();
            byte[] sendBuf = byteArrayOutputStream.toByteArray();
            ByteBuffer byteBuffer = ByteBuffer.wrap(sendBuf);
            datagramChannel.send(byteBuffer, address);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}