package Foundation;

import java.io.Serializable;

public class Command implements Serializable {
    public static long serialVersionUID = 1L;
    private String command;
    private Grave grave;

    public Command(String command, Grave grave) {
        this.command = command;
        this.grave = grave;
    }

    public Command() {
    }

    public String getCommand() {
        return command;
    }

    public Grave getGrave() {
        return grave;
    }
}