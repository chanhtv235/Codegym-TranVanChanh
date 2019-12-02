package CaseStudyJavaCoreFuramaResort.src.models;

import java.util.Scanner;
import java.util.UUID;

public abstract class Services {
    private String iDService;
    private String nameService;
    private double area;
    private double rentCost;
    private int personLimit;
    private String rentType;

    public Services(String nameService, String iDService,double area, double rentCost, int personLimit, String rentType) {
        this.nameService = nameService;
        this.iDService=iDService;
        this.area = area;
        this.rentCost = rentCost;
        this.personLimit = personLimit;
        this.rentType = rentType;
    }
    public Services(){

    }

    public void setIDService(String iDService) {
        this.iDService=iDService;}

    public String getIDService() {
        return this.iDService;}

    public String getNameService() {
        return nameService;
    }

    public void setNameService(String nameService) {
        this.nameService = nameService;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public double getRentCost() {
        return rentCost;
    }

    public void setRentCost(double rentCost) {
        this.rentCost = rentCost;
    }

    public int getPersonLimit() {
        return personLimit;
    }

    public void setPersonLimit(int personLimit) {
        this.personLimit = personLimit;
    }

    public String getRentType() {
        return rentType;
    }

    public void setRentType(String rentType) {
        this.rentType = rentType;
    }

    public String ShowInfo(){
        return "\nId Service: " + getIDService()+
                "\nServiceType: " +getNameService()+
                "\nArea: " + getArea()+
                "\nRental Cost: " + getRentCost()+
                "\nMaxium person: " +getPersonLimit()+
                "\nRent type: " + getRentType();
    };

}
