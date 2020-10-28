package Foundation;

import java.io.Serializable;
import java.util.Date;

public class Grave implements Serializable {
    public static long serialVersionUID = 1L;
    private int id;
    private String name;
    private String surname;
    private String reasonOfDeath;
    private Date date;
    private long likes;
    private byte condition;

    public Grave(int id, String name, String surname, String reasonOfDeath, Date date, long likes, byte condition) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.reasonOfDeath = reasonOfDeath;
        this.date = date;
        this.likes = likes;
        this.condition = condition;
    }

    @Override
    public int hashCode() {
        return id;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getReasonOfDeath() {
        return reasonOfDeath;
    }

    public Date getDate() {
        return date;
    }

    public long getLikes() {
        return likes;
    }

    public byte getCondition() {
        return condition;
    }
}