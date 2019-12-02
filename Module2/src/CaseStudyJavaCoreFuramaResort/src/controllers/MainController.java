package CaseStudyJavaCoreFuramaResort.src.controllers;

import CaseStudyJavaCoreFuramaResort.src.commons.ComparatorNameCustomer;
import CaseStudyJavaCoreFuramaResort.src.commons.FuncValidate;
import CaseStudyJavaCoreFuramaResort.src.commons.FuncWriteFileCSV;
import CaseStudyJavaCoreFuramaResort.src.models.Customer;
import CaseStudyJavaCoreFuramaResort.src.models.Villa;
import CaseStudyJavaCoreFuramaResort.src.models.House;
import models.Room;
import CaseStudyJavaCoreFuramaResort.src.models.Services;

import java.util.*;

public class MainController {
    public static void displayMainMenu(){
        System.out.println( "1.Add New Service.\n"+
                            "2.Show Service\n"+
                            "3.Add Customer\n"+
                            "4.Show Customer\n"+
                            "5.Add New Booking Resort\n"+
                            "6. Back Main Menue\n"+
                            "7. Exit\n");
        Scanner input =new Scanner(System.in);
        int selection1=input.nextInt();
        switch (selection1){
            case 1:
                addNewServices();
                backMainMenu();
                break;
            case 2:
                showInfoService();
                backMainMenu();
                break;
            case 3:AddNewCustomer();
                 backMainMenu();
                break;
            case 4:
                showInfoCustomer();
                backMainMenu();
                break;
            case 5:addNewBookingResort();
                backMainMenu();
                break;
            case 6:
                backMainMenu();
                break;
            case 7:System.exit(0);
                break;
            default:
                System.out.println("Enter try Again");
                backMainMenu();

        }
    }
    private static void backMainMenu()  {
        displayMainMenu();
    }
    ////////////////////////////////////////////////////
    private static void addNewServices()  {
        System.out.println( "1. Add New Villa\n"+
                            "2. Add New House\n"+
                            "3. Add New Room\n" +
                            "4. Back to menu\n"+
                            "5. Exit"
                            );
        Scanner input =new Scanner(System.in);
        int selection2=input.nextInt();
        switch (selection2){
            case 1:
                System.out.println("1. Add New Villa\n");
                        addNewVilla();
                    backMainMenu();
                    break;
            case 2:
                System.out.println("2. Add New House\n");
                    addNewHouse();
                    backMainMenu();
                    break;
            case 3: System.out.println("2. Add New Room\n");
                    addNewRoom();
                    backMainMenu();
                    break;
            case 4: backMainMenu();
                    break;
            case 5: System.exit(0);
            default:
                backMainMenu();
        }
    }

    private static void showInfoService(){
        System.out.println( "1. Show All Villa\n"+
                "2. Show All House\n"+
                "3. Show All Room\n" +
                "4. Show All Name Villa Not Duplicate\n" +
                "5. Show All Name House Not Duplicate\n" +
                "6. Show All Name Name Not Duplicate\n"+
                "7. Back to menu\n"+
                "8. Exit");
        Scanner input =new Scanner(System.in);
        int selection3=input.nextInt();
        switch (selection3){
            case 1:
                showAllVilla();
                backMainMenu();
                break;
            case 2:
                showAllHouse();
                backMainMenu();
                break;
            case 3:
                showAllRoom();
                backMainMenu();
            break;
            case 4:
                showAllNameVillaNotDuplicate();
                backMainMenu();
                break;
            case 5:
                showAllNameHouseNotDuplicate();
                backMainMenu();
                break;
            case 6:
                showAllNameRoomNotDuplicate();
                backMainMenu();
                break;
            case 7: System.exit(0);
            default:
                System.out.println("Enter try Again");
               backMainMenu();
        }
    }

    private static void AddNewCustomer(){
        Scanner input=new Scanner(System.in);
        Customer customer=new Customer();
        /////Automatic Enter ID
        customer.setID(UUID.randomUUID().toString().replace("-",""));
        /// Enter Name Customer
        System.out.println("Enter name of customer");
        customer.setCustomerName(input.nextLine());
        while (!FuncValidate.checkNameCustomer(customer.getCustomerName())){
            System.out.println(" Try Again");
            System.out.println("Enter name of customer");
            customer.setCustomerName(input.nextLine());
        }
        ///Enter Birthday of Customer
        System.out.println("Enter Birthday of customer (dd/mm/yyyy)");
        customer.setBirthdayOfCustomer(input.nextLine());
        while (!FuncValidate.checkBirthday(customer.getBirthdayOfCustomer())){
            System.out.println("Erro: try again!!!");
            System.out.println("Enter Birthday of customer (dd/mm/yyyy) and Age >18");
            customer.setBirthdayOfCustomer(input.nextLine());
        }
        //Enter Gender
        System.out.println("Enter Gender of customer");
        customer.setGender(input.nextLine());
        while (!FuncValidate.checkGender(customer.getGender())){
            System.out.println( "Gender is inval!!!");
            System.out.println("Enter try Again Gender of customer(Male, Female, Unknow");
            customer.setGender(input.nextLine());
        }
        customer.setGender(FuncValidate.formatGender(customer.getGender()));
        // Enter SetCutowmer ID
        System.out.println(" Enter ID of customer");
        customer.setCustomerId(input.nextLine());
        while (!FuncValidate.checkID(customer.getCustomerId())){
            System.out.println(" Enter ID of customer must has 9 numbers.Format (XXX XXX XXX)");
            customer.setCustomerId(input.nextLine());
        }
        // Enter phone number
        System.out.println("Enter phone of customer");
        customer.setCustomerPhone(input.nextLine());
        // Enter Email
        System.out.println("Enter Email of customer");
        input=new Scanner(System.in);
        customer.setCustomerEmail(input.nextLine());
        while (!FuncValidate.checkEmail(customer.getCustomerEmail())){
            System.out.println(" Email is invalue!!!!!");
            System.out.println("Enter Email of customer (abc@abc.abc(.abc))");
            customer.setCustomerEmail(input.nextLine());
        }
        System.out.println("Enter Type of customer");
        customer.setCustomerType(input.nextLine());
        System.out.println("Enter Address of customer");
        customer.setCustomerAddress(input.nextLine());
        ///Write Customer to file CSV
//        ArrayList<Customer> listCustomer=new ArrayList<Customer>();
//        listCustomer.add(customer);
//        FuncWriteFileCSV.writeCustomerToFileSCV(listCustomer);
        ArrayList<Customer> listCustomer=FuncWriteFileCSV.getCustomerFromCSV();
        listCustomer.add(customer);
        FuncWriteFileCSV.writeCustomerToFileSCV(listCustomer);
    }

    private static void addNewBookingResort(){
        ArrayList<Customer>customerList=FuncWriteFileCSV.getCustomerFromCSV();
        ///Show customer name
        System.out.println("Display Customer list");
        displayCustomerList(customerList);
        Scanner input =new Scanner(System.in);
        System.out.println("Select customer to booking");
        // get customer in customerlist
        Customer customer=customerList.get(input.nextInt()-1);
        System.out.println(
                "1. Booking Villa\n"+
                "2. Booking House\n"+
                "3. Booking Room\n" +
                "4. Back \n"+
                "5. Exit"
                );
        System.out.println("Selec type service booking for customer");
        switch (input.nextInt()){
            case 1:
                System.out.println("1.Booking  Villa\n");
                bookingVilla(customer);
                backMainMenu();
                break;
            case 2:
                System.out.println("2.Booking  House\n");
                bookingHouse(customer);
                backMainMenu();
                break;
            case 3:
                System.out.println("2.Booking  Room\n");
                bookingRoom(customer);
                backMainMenu();
                break;
            case 4: backMainMenu();
                break;
            case 5: System.exit(0);
            default:
                backMainMenu();
        }

    }

    private static Services AddNewService(Services services){
        Scanner input=new Scanner(System.in);
        /////Automatic Enter ID
        services.setIDService(UUID.randomUUID().toString().replace("-",""));
        //// Enter Service Name;
            System.out.println("Enter Service Name");
            services.setNameService(input.nextLine());
            while (!FuncValidate.checkNameService(services.getNameService())){
                System.out.println("Try again");
                System.out.println("Enter Service Name");
                services.setNameService(input.nextLine());
            }
            /////////////Enter Area
            String content ="Enter Area >30";
            String errMess="Erro: try again";
            services.setArea(FuncValidate.checkValidNumberDouble(content,errMess));
            while (services.getArea()<30){
                services.setArea(FuncValidate.checkValidNumberDouble(content,errMess));
            }
        /// Enter rental Cost;
        content ="Enter rental Cost >0 ";
        errMess="Erro: try again";
        services.setRentCost(FuncValidate.checkValidNumberDouble(content,errMess));
        while (services.getRentCost()<0) {
            services.setRentCost(FuncValidate.checkValidNumberDouble(content, errMess));
        }
// Enter the limited  number of person;
        content ="Enter number of person ";
        errMess="Erro: try again";
        services.setPersonLimit(FuncValidate.checkValidNumberInt(content,errMess));
        while (services.getPersonLimit()<0) {
            services.setPersonLimit(FuncValidate.checkValidNumberInt(content, errMess));
        }
        // Enter rental type;
        System.out.println("Enter Service Type");
        services.setRentType(input.nextLine());
        while (!FuncValidate.checkNameService(services.getRentType())){
            System.out.println("Try again");
            System.out.println("Enter Service Type");
            services.setRentType(input.nextLine());
        }
        return services;
    }

    private static void addNewVilla(){
        Scanner input=new Scanner(System.in);
        Services villa=new Villa();
        AddNewService(villa);
        // Enter room standard
        System.out.println("Enter Room standard");
        ((Villa)villa).setRoomStandard(input.nextLine());
        while (!FuncValidate.checkNameService(((Villa)villa).getRoomStandard())) {
            System.out.println("Try again");
            System.out.println("Enter Room standard");
            ((Villa)villa).setRoomStandard(input.nextLine());
            }
        ///// Enter convenient
            System.out.println("Enter convenient");
        ((Villa)villa).setConvenient(input.nextLine());
            while (!FuncValidate.checkConveninent(((Villa)villa).getConvenient())){
                System.out.println("Try again");
                System.out.println("Enter convenient (massage)|(karaoke)|(food)|(drink)|(car)");
                ((Villa)villa).setConvenient(input.nextLine());
            }
        ////Enter the number of Floor;
               String content ="Enter number of floor ";
               String errMess="Erro: try again";
        ((Villa)villa).setFloorNumber(FuncValidate.checkValidNumberInt(content,errMess));
                while (((Villa)villa).getFloorNumber()<0) {
                    ((Villa)villa).setFloorNumber(FuncValidate.checkValidNumberInt(content, errMess));
                }
        // Enter pool area
            content ="Enter Pool Area >30";
            errMess="Erro: try again";
        ((Villa)villa).setPoolArea(FuncValidate.checkValidNumberDouble(content,errMess));
        while (((Villa)villa).getPoolArea()<30){
            ((Villa)villa).setPoolArea(FuncValidate.checkValidNumberDouble(content,errMess));
        }
        ///Writer CSV Villa
        ArrayList<Villa> listVilla=FuncWriteFileCSV.getVillaFromCSV();
        listVilla.add(((Villa)villa));
        FuncWriteFileCSV.writeVillaToFileSCV(listVilla);
    }

    private static void addNewHouse(){
       Scanner input=new Scanner(System.in);
        Services house=new House();
        AddNewService(house);
        // Enter room standard
        System.out.println("Enter Room standard");
        ((House)house).setRoomStandard(input.nextLine());
        while (!FuncValidate.checkNameService(((House)house).getRoomStandard())) {
            System.out.println("Try again");
            System.out.println("Enter Room standard");
            ((House)house).setRoomStandard(input.nextLine());
        }
        ///// Enter convenient
        System.out.println("Enter convenient");
        ((House)house).setConvenient(input.nextLine());
        while (!FuncValidate.checkConveninent(((House)house).getConvenient())){
            System.out.println("Try again");
            System.out.println("Enter convenient (massage)|(karaoke)|(food)|(drink)|(car)");
            ((House)house).setConvenient(input.nextLine());
        }
        ////Enter the number of Floor;
        String content ="Enter number of floor ";
        String errMess="Erro: try again";
        ((House)house).setFloorNumber(FuncValidate.checkValidNumberInt(content,errMess));
        while (((House)house).getFloorNumber()<0) {
            ((House)house).setFloorNumber(FuncValidate.checkValidNumberInt(content, errMess));
        }

        /////Writer CSV House.
        ArrayList<House> listHouse=FuncWriteFileCSV.getHouseFromCSV();
        listHouse.add(((House)house));
        FuncWriteFileCSV.writeHouseToFileSCV(listHouse);
    }

    private static void addNewRoom(){
        Scanner input=new Scanner(System.in);
        Services room=new Room();
        AddNewService(room);
        System.out.println("Enter free service:");
        ((Room)room).setFreeServices(input.nextLine());
        while (!FuncValidate.checkNameService(((Room)room).getFreeServices())) {
            System.out.println("Try again");
            System.out.println("Enter free service");
            ((Room)room).setFreeServices(input.nextLine());
        }
        /// Writer CSV file Room
        ArrayList<Room> listRoom=FuncWriteFileCSV.getRoomFromCSV();
        listRoom.add(((Room)room));
        FuncWriteFileCSV.writeRoomToFileSCV(listRoom);
    }

    private static void showAllVilla() {
        ArrayList<Villa> listvilla=FuncWriteFileCSV.getVillaFromCSV();
        for (Villa villa:listvilla){
            System.out.println("----------------------");
           System.out.println(villa.ShowInfo());
            System.out.println("----------------------");
        }
    }

    private static void showAllHouse() {
        ArrayList<House> listHouse=FuncWriteFileCSV.getHouseFromCSV();
        for (House house:listHouse){
            System.out.println("----------------------");
            System.out.println(house.ShowInfo());
            System.out.println("----------------------");
        }
    }

    private static void showAllRoom() {
        ArrayList<Room> listRoom=FuncWriteFileCSV.getRoomFromCSV();
        for (Room room:listRoom){
            System.out.println("----------------------");
            System.out.println(room.ShowInfo());
            System.out.println("----------------------");
        }
    }

    private static void showInfoCustomer(){
        System.out.println("----------------------------------------------");
        ArrayList<Customer> listCustomer=FuncWriteFileCSV.getCustomerFromCSV();
        Collections.sort(listCustomer,new ComparatorNameCustomer());
        for (Customer customer: listCustomer) {
            System.out.println(customer.ShowInFo());
        };
        System.out.println("----------------------------------------------");
    }

    private static void displayCustomerList(ArrayList<Customer>arrayList){
        int i=1;
        String content="";
        for (Customer customer:arrayList){
            content+= i++ +". "+customer.getCustomerName()+"\n";
        }
        System.out.println(content);
    }

    private static void bookingVilla(Customer customer){
    ArrayList<Villa> villaList =FuncWriteFileCSV.getVillaFromCSV();
        int i=1;
        String content="";
        for (Villa villa:villaList){
            content+= i++ +". "+villa.getNameService()+"\n";
        }
        System.out.println(content);
        System.out.println(" Select Villa type for customer");
        Scanner input =new Scanner(System.in);
        Villa villa= villaList.get(input.nextInt()-1);
        customer.setCustomerUseServieceType(villa);
        //Writer Boking to file CSV booking
        ArrayList<Customer> listBooking=new ArrayList<Customer>();
        listBooking.add(customer);
        FuncWriteFileCSV.writeBookingToFileSCV(listBooking);
    }

    private static void bookingHouse(Customer customer){
        ArrayList<House> houseList =FuncWriteFileCSV.getHouseFromCSV();
        int i=1;
        String content="";
        for (House house:houseList){
            content+= i++ +". "+house.getNameService()+"\n";
        }
        System.out.println(content);
        System.out.println(" Select House type for customer");
        Scanner input =new Scanner(System.in);
        House house= houseList.get(input.nextInt()-1);
        customer.setCustomerUseServieceType(house);
    }

    private static void bookingRoom(Customer customer){
        ArrayList<Room> roomList =FuncWriteFileCSV.getRoomFromCSV();
        int i=1;
        String content="";
        for (Room room:roomList){
            content+= i++ +". "+room.getNameService()+"\n";
        }
        System.out.println(content);
        System.out.println(" Select Room type for customer");
        Scanner input =new Scanner(System.in);
        Room room= roomList.get(input.nextInt()-1);
        customer.setCustomerUseServieceType(room);
    }

    private static void showAllNameVillaNotDuplicate(){

    }
    private static void showAllNameHouseNotDuplicate(){

    }
    private static void showAllNameRoomNotDuplicate(){

    }

}
