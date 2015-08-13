package it.source.buisiness.beans;

import it.source.buisiness.model.Offence;

/**
 * Created by Kolmakov Alexey on 08.08.2015.
 */
public class OffenceBean {
    private Long id;
    private String date;
    private String type;

    public OffenceBean(Offence offence) {
        this.id = offence.getId();
        this.date = offence.getDate().toString();
        this.type = offence.getType().name();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
