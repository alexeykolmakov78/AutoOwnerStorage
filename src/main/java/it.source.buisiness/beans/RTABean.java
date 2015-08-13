package it.source.buisiness.beans;

import it.source.buisiness.model.RTA;

/**
 * Created by Kolmakov Alexey on 07.08.2015.
 */
public class RTABean {

    private Long id;
    private String date;
    private int code;


    public RTABean(RTA rta) {
        this.id = rta.getId();
        this.date = rta.getDate().toString();
        this.code = rta.getCode();

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

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

}
