package ClientWork;

import Foundation.Command;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class ClientReceiver {

    public Command receiveCommand(DatagramSocket datagramSocket) {
        try {
            byte[] buf = new byte[4096];
            DatagramPacket datagramPacket = new DatagramPacket(buf, buf.length);
            datagramSocket.receive(datagramPacket);
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(datagramPacket.getData());
            ObjectInputStream fromServer = new ObjectInputStream(byteArrayInputStream);
            Command command = (Command) fromServer.readObject();
            byteArrayInputStream.close();
            fromServer.close();
            return command;
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        return null;
    }
}
