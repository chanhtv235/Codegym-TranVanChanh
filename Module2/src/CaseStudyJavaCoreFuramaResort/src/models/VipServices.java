package CaseStudyJavaCoreFuramaResort.src.models;

import CaseStudyJavaCoreFuramaResort.src.models.Services;

public abstract  class VipServices extends Services {
    private String roomStandard;
    private String convenient;
    private int floorNumber;

    public String getRoomStandard() {
        return roomStandard;
    }
    public VipServices(){

    }
    public VipServices(String nameService,String iDService , double area, double rentCost, int personLimit, String rentType, String roomStandard, String convenient, int floorNumber) {
        super(nameService,iDService, area, rentCost, personLimit, rentType);
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

}
