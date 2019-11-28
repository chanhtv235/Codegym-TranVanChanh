package models;

public class House extends VipServices {
    private String roomStandard;
    private String convenient;
    private int floorNumber;

    public House() {
    }

    public House(String name,String id, float area, float rentCost, int personLimit, String rentType, String roomStandard, String convenient, int floorNumber) {
        super(name,id, area, rentCost, personLimit, rentType, roomStandard, convenient, floorNumber);
    }

    @Override
    public String ShowInfo() {
       return super.ShowInfo();
    }

//    @Override
//    public void AddService() {
//        super.AddService();
//    }

    @Override
    public String toString() {
        return super.toString();
    }
}
