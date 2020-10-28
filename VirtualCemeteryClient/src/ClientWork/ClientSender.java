package ClientWork;

import Foundation.Command;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketAddress;

public class ClientSender {

    public void sendCommand(DatagramSocket datagramSocket, SocketAddress inetSocketAddress, Command response) {
        try (ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream)) {
            objectOutputStream.writeObject(response);
            objectOutputStream.flush();
            byte[] sendBuf = byteArrayOutputStream.toByteArray();
            DatagramPacket datagramPacket = new DatagramPacket(sendBuf, sendBuf.length, inetSocketAddress);
            datagramSocket.send(datagramPacket);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
