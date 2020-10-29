package Foundation;

import java.io.Serializable;

public class Command implements Serializable {
    public static long serialVersionUID = 1L;
    private String command;
    private Grave grave;
    private String login;
    private String password;

    public Command(String command, Grave grave, String login, String password) {
        this.command = command;
        this.grave = grave;
        this.login = login;
        this.password = password;
    }

    public Command(String command, String login, String password) {
        this.command = command;
        this.login = login;
        this.password = password;
    }

    public Command(String command) {
        this.command = command;
    }

    public String getCommand() {
        return command;
    }

    public Grave getGrave() {
        return grave;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }
}