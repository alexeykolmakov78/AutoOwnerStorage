package it.source.buisiness.model;

import java.sql.Date;

/**
 * Created by Kolmakov Alexey on 16.06.2015.
 */
public class Licence {
    private Long id;
    private String serialID;
    private Category category;
    private Date registrationDate;
    private String registeredBy;

    public Licence(Long id, String serialID, Category category, Date registrationDate, String registeredBy) {
        this.id = id;
        this.serialID = serialID;
        this.category = category;
        this.registrationDate = registrationDate;
        this.registeredBy = registeredBy;

    }

    public Long getId() {
        return id;
    }

    public String getSerialID() {
        return serialID;
    }

    public Category getCategory() {
        return category;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public String getRegisteredBy() {
        return registeredBy;
    }

    public static enum Category {
        A, B, C, D;
    }

    @Override
    public String toString() {
        return "\nLicence{" +
                "serialID='" + serialID + '\'' +
                ", category=" + category +
                ", registrationDate=" + registrationDate +
                ", registeredBy='" + registeredBy + '\'' +
                '}';
    }
}
