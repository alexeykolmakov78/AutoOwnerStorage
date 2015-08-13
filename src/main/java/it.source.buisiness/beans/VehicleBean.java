package it.source.buisiness.beans;

import it.source.buisiness.model.Vehicle;

/**
 * Created by Kolmakov Alexey on 06.08.2015.
 */
public class VehicleBean {
    private Long id;
    private String brand;
    private String model;
    private String registrationNumber;
    private String productionDate;
    private String lastServiceDate;
    private String rta;
    private String owner;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public String getProductionDate() {
        return productionDate;
    }

    public void setProductionDate(String productionDate) {
        this.productionDate = productionDate;
    }

    public String getLastServiceDate() {
        return lastServiceDate;
    }

    public void setLastServiceDate(String lastServiceDate) {
        this.lastServiceDate = lastServiceDate;
    }

    public String getRta() {
        return rta;
    }

    public void setRta(String rta) {
        this.rta = rta;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public VehicleBean(Vehicle vehicle) {
        this.id = vehicle.getId();
        this.brand = vehicle.getBrand();
        this.model = vehicle.getModel();
        this.registrationNumber = vehicle.getRegistrationNumber();
        this.productionDate = vehicle.getProductionDate().toString();
        this.lastServiceDate = vehicle.getLastServiceDate().toString();
        this.rta = vehicle.getRtaList().toString();
        this.owner = vehicle.getOwnerID().toString();
    }

    @Override
    public String toString() {
        return "id=" + id +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", registrationNumber='" + registrationNumber + '\'' +
                ", productionDate='" + productionDate + '\'' +
                ", lastServiceDate='" + lastServiceDate + '\'' +
                ", rta='" + rta + '\'' +
                ", owner='" + owner ;
    }
}
