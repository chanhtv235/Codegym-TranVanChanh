package models;

import java.util.Scanner;

public class Villa extends VipServices {
    private float poolArea;

    public float getPoolArea() {
        return poolArea;
    }

    public void setPoolArea(float poolArea) {
        this.poolArea = poolArea;
    }
    public Villa(){

    }

    public Villa(String name, String id, float area, float rentCost, int personLimit, String rentType, String roomStandard, String convenient, int floorNumber, float poolArea) {
        super(name, id, area, rentCost, personLimit, rentType, roomStandard, convenient, floorNumber);
        this.poolArea = poolArea;
    }

    @Override
    public String ShowInfo() {
        return super.ShowInfo()+
                "\nPool area: "+getPoolArea();
    }

//    @Override
//    public void AddService() {
//        Scanner input=new Scanner(System.in);
//        super.AddService();
//        System.out.println("Enter pool area");
//        this.setPoolArea(input.nextFloat());
//    }

    @Override
    public String toString() {
        return super.toString()+poolArea;
    }
}
