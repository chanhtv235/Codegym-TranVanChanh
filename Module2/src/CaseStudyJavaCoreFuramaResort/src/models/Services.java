package models;

import java.util.Scanner;
import java.util.UUID;

public abstract class Services {
    private String id;
    private String name;
    private float area;
    private float rentCost;
    private int personLimit;
    private String rentType;

    public Services(String name, String id,float area, float rentCost, int personLimit, String rentType) {
        this.name = name;
        this.id=id;
        this.area = area;
        this.rentCost = rentCost;
        this.personLimit = personLimit;
        this.rentType = rentType;
    }
    public Services(){

    }

    public void setId(String id) {
        this.id=id;}

    public String getId() {
        return this.id;}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getArea() {
        return area;
    }

    public void setArea(float area) {
        this.area = area;
    }

    public float getRentCost() {
        return rentCost;
    }

    public void setRentCost(float rentCost) {
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
        return "serviceType "+getName()+
                "\nID "+getId()+
                "\nArea: "+getArea()+
                "\nRental Cost: "+ getRentCost()+
                "\nMaxium person"+getPersonLimit()+
                "\nRent type:"+getRentType();
    };

//    public  void AddService(){
//        Scanner input;
//        input=new Scanner(System.in);
//        System.out.println("Enter Service Name");
//        this.setName(input.nextLine());
//        System.out.println("Enter ID");
//        this.setId(UUID.randomUUID().toString().replace("-","")) ;
//        System.out.println("Enter Area");
//        this.setArea(input.nextFloat());
//        System.out.println("Enter rental Cost");
//        this.setRentCost(input.nextFloat());
//        System.out.println("Enter rental Type");
//        input=new Scanner(System.in);
//        this.setRentType(input.nextLine());
//        System.out.println("Enter number person limit");
//        this.setPersonLimit(input.nextInt());
//    }

    @Override
    public String toString() {
        return ""+ id + ","  + name+ ","  + area+ ","  + rentCost+ ","  + personLimit+ "," + rentType+ "," ;

    }
}
