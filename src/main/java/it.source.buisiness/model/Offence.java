package it.source.buisiness.model;

import java.util.Date;

/**
 * Created by Kolmakov Alexey on 16.06.2015.
 */
public class Offence {
    private Long id;
    private Date date;
    private Type type;

    public Offence(Long id,Date date, Type type) {
        this.date = date;
        this.type = type;
        this.id =id;
    }

    public Long getId() {
        return id;
    }

    public Date getDate() {
        return date;
    }

    public Type getType() {
        return type;
    }

    // RTA is a road-transport accident
    public enum Type {
        RED_LIGHT, DRUNK, PEDESTRIAN, RTA, SPEED_LIMIT;
    }

    @Override
    public String toString() {
        return "\nOffence{" +
                "date: " + date +
                ", type: " + type +
                '}';
    }
}
