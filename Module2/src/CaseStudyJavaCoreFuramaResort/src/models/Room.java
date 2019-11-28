package models;

import java.util.Scanner;

public class Room extends Services {
    private String freeServices;

    public String getFreeServices() {
        return freeServices;
    }

    public void setFreeServices(String freeServices) {
        this.freeServices = freeServices;
    }
    public Room(){

    }
    public Room(String name, String id, float area, float rentCost, int personLimit, String rentType, String freeServices) {
        super(name, id, area, rentCost, personLimit, rentType);
        this.freeServices = freeServices;
    }

    @Override
    public String  ShowInfo() {
        return super.ShowInfo()+
                "Free Service:"+freeServices;
    }
//    @Override
//    public void AddService() {
//        Scanner input =new Scanner(System.in);
//        super.AddService();
//        System.out.println("Enter free service");
//        this.setFreeServices(input.nextLine());
//    }
}
