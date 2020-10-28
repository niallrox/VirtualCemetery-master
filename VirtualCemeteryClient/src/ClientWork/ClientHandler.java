package ClientWork;

import Foundation.Command;
import Foundation.Grave;

import java.util.Date;

public class ClientHandler {

    public Command handle(String command) {
        if (command.equals("add")) {
            return new Command("add", new Grave(1, "Ivan", "Uskov", "Prosto pidor", new Date(), 0, (byte) 0));
        }
        return new Command();
    }
}
