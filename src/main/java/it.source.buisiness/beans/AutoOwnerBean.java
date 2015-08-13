package it.source.buisiness.beans;

import it.source.buisiness.model.AutoOwner;
import it.source.buisiness.model.Offence;
import it.source.buisiness.model.Vehicle;

/**
 * Created by Kolmakov Alexey on 06.08.2015.
 */
public class AutoOwnerBean {
    private Long id;
    private String address;
    private String passport;
    private String licence;
    private String vehicles;
    private String offences;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPassport() {
        return passport;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }

    public String getLicence() {
        return licence;
    }

    public void setLicence(String licence) {
        this.licence = licence;
    }

    public String getVehicles() {
        return vehicles;
    }

    public void setVehicles(String vehicles) {
        this.vehicles = vehicles;
    }

    public String getOffences() {
        return offences;
    }

    public void setOffences(String offences) {
        this.offences = offences;
    }

    public AutoOwnerBean(AutoOwner owner) {
        this.id = owner.getId();
        this.address = owner.getAddress().toString();
        this.passport = owner.getPassport().toString();
        this.licence = owner.getLicence().toString();

        this.vehicles = getVehicles(owner);
        this.offences = getOwners(owner);

    }


    @Override
    public String toString() {
        return "\n  #" + id + address + passport + licence + vehicles + offences;
    }

    private String getVehicles(AutoOwner owner) {
        StringBuilder sb = new StringBuilder();
        for (Vehicle v : owner.getVehicles()) {
            sb.append(v.toString());
        }
        return sb.toString();
    }

    private String getOwners(AutoOwner owner) {
        StringBuilder sb = new StringBuilder();
        for (Offence o : owner.getOffences()) {
            sb.append(o.toString());
        }
        return sb.toString();
    }
}
