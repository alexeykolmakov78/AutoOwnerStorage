package it.source.buisiness.model;

import java.util.Date;

/**
 * Created by Kolmakov Alexey on 16.06.2015.
 */
public class RTA {
    private Long id;
    private Date date;
    private int code;

    public RTA(Long id, Date date, int code) {
        this.id = id;
        this.date = date;
        this.code = code;
    }

    public Long getId() {
        return id;
    }

    public Date getDate() {
        return date;
    }

    public int getCode() {
        return code;
    }

    @Override
    public String toString() {
        return "\nRTA{" +
                " id: " + id +
                " date: " + date +
                " code: " + code +
                '}';
    }
}
