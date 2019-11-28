package models;

import java.util.Scanner;

public abstract  class VipServices extends Services {
    private String roomStandard;
    private String convenient;
    private int floorNumber;

    public String getRoomStandard() {
        return roomStandard;
    }
    public VipServices(){

    }
    public VipServices(String name,String id, float area, float rentCost, int personLimit, String rentType, String roomStandard, String convenient, int floorNumber) {
        super(name,id, area, rentCost, personLimit, rentType);
        this.roomStandard = roomStandard;
        this.convenient = convenient;
        this.floorNumber = floorNumber;
    }

    public void setRoomStandard(String roomStandard) {
        this.roomStandard = roomStandard;
    }

    public String getConvenient() {
        return convenient;
    }

    public void setConvenient(String convenient) {
        this.convenient = convenient;
    }

    public int getFloorNumber() {
        return floorNumber;
    }

    public void setFloorNumber(int floorNumber) {
        this.floorNumber = floorNumber;
    }

    @Override
    public String ShowInfo() {
        return super.ShowInfo()+
                "\nRoom standard: " + getRoomStandard() +
                "\nConvenient: " + getConvenient() +
                "\nFloor Number: " + getFloorNumber();

    }

//    @Override
//    public void AddService() {
//        super.AddService();
//        Scanner input=new Scanner(System.in);
//        System.out.println("Enter room standard");
//        this.setRoomStandard(input.nextLine());
//        System.out.println("Enter convenient");
//        this.setConvenient(input.nextLine());
//        System.out.println("Enter floor number");
//        this.setFloorNumber(input.nextInt());
//    }

    @Override
    public String toString() {
        return super.toString()+ "," + roomStandard + "," + convenient + "," + floorNumber+ ",";
    }
}
