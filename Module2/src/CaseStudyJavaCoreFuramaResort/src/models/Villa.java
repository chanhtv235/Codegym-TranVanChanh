package CaseStudyJavaCoreFuramaResort.src.models;

import java.util.Scanner;

public class Villa extends CaseStudyJavaCoreFuramaResort.src.models.VipServices {
    private double poolArea;

    public double getPoolArea() {
        return poolArea;
    }

    public void setPoolArea(double poolArea) {
        this.poolArea = poolArea;
    }
    public Villa(){

    }

    public Villa(String nameService, String iDService , double area, double rentCost, int personLimit, String rentType, String roomStandard, String convenient, int floorNumber, double poolArea) {
        super(nameService, iDService, area, rentCost, personLimit, rentType, roomStandard, convenient, floorNumber);
        this.poolArea = poolArea;
    }

    @Override
    public String ShowInfo() {
        return super.ShowInfo()+
                "\nPool area: "+getPoolArea();
    }

}
