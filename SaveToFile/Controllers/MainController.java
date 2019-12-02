package Case_Study.JavaCore.SaveToFile.Controllers;

import Case_Study.JavaCore.SaveToFile.Commons.FuncValidation;
import Case_Study.JavaCore.SaveToFile.Commons.FuncWriteAndReadFileCSV;
import Case_Study.JavaCore.SaveToFile.Commons.Menu;
import Case_Study.JavaCore.SaveToFile.Commons.ScannerUtils;
import Case_Study.JavaCore.SaveToFile.CustomException.NameException;
import Case_Study.JavaCore.SaveToFile.Models.*;


import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class MainController {

    public static final String INVALID_NAME_SERVICE = "Name services is invalid. Please try again !!!";
    public static final String ENTER_NAME_SERVICES = "Enter Name Services: ";
    public static final String ENTER_AREA_USED = "Enter Area Used: ";
    public static final String INVALID_DOUBLE_NUMBER = "Area Used is invalid (Area > 30, Area must be a Integer). Please try again!!!";
    public static final String ENTER_RENTAL_COSTS = "Enter Rental Costs: ";
    public static final String INVALID_RENTAL_COSTS = "Rental Costs is invalid (Costs > 0, Costs must be Double). Please try again!!!";
    public static final String ENTER_MAX_NUMBER_OF_PEOPLE = "Enter Max Number Of People: ";
    public static final String INVALID_MAX_PEOPLE = "Max Number Of People is invalid (Number Of People > 0 And Number Of People < 20, Number Of People must be Integer). Please try again!!!";
    public static final String ENTER_TYPE_RENT = "Enter Type Rent: ";
    public static final String INVALID_TYPE_RENT = "Type Rent is invalid. Please try again !!!";
    public static final String ENTER_ROOM_STANDARD = "Enter Room Standard: ";
    public static final String INVALIDE_ROOM_STANDARD = "Room Standard is invalid. Please try again !!!";
    public static final String ENTER_AREA_POOL = "Enter Area Pool: ";
    public static final String INVALIDE_AREA_POOL = "Area Pool is invalid (Area > 30, Area must be a Double). Please try again!!!";
    public static final String ENTER_NUMBER_OF_FLOORS = "Enter Number Of Floors: ";
    public static final String INVALID_NUMBER_FLOORS = "Number Of Floors is invalid (Number Of Floors > 0, Number Of Floors must be a Integer). Please try again!!!";
    private static String nameService;

    public static void processMain() {

        Menu.displayMenuMain();
        processMenuMain();

    }

    public static void processMenuMain() {
        switch (ScannerUtils.scanner.nextInt()) {
            case 1:
                addNewServices();
                break;
            case 2:
                showServices();
                break;
            case 3:
                addNewCustomer();
                break;
            case 4:
                showInformationCustomers();
                // pass enter
                ScannerUtils.scanner.nextLine();
                backMainMenu();
                break;
            case 5:
                addNewBookingResort();
                break;
            case 6:
                showInformationEmployees();
                break;
            case 7:
                System.exit(0);
                break;
            default:
                System.out.println("\nNhập sai hiển thị lại Menu");
                backMainMenu();
                break;
        }
    }


    // show information Employee
    private static void showInformationEmployees() {
        Map<Integer, Employee> map = new HashMap<>();
        map.put(100, new Employee("Nguyễn Thành Kiên", 25, "Đà Nẵng"));
        map.put(101, new Employee("Nguyễn Văn Toàn", 22, "Quảng Nam"));
        map.put(102, new Employee("Lê Văn Hải", 20, "Hà Nội"));
        map.put(103, new Employee("Đoàn Phước Trung", 18, "Vũng Tàu"));
        map.put(104, new Employee("Đoàn Ngọc Sơn", 18, "Tây Nguyên"));
        map.put(105, new Employee("Đoàn Văn Tùng", 28, "Tây Ninh"));
        map.put(106, new Employee("Trần Cường", 24, "Bắc Giang"));
        map.put(107, new Employee("Trần Cường Tú", 24, "Huế"));
        map.put(108, new Employee("Trần Văn Tài", 34, "Quảng Trị"));
        map.put(109, new Employee("Trần Thanh", 32, "Quảng Ninh"));
        // show
        for (Map.Entry m : map.entrySet()) {
            System.out.println("Key: " + m.getKey() + "\n" + m.getValue().toString());
        }
    }

    //add new bookng
    private static void addNewBookingResort() {
        ArrayList<Customer> listCustomers = FuncWriteAndReadFileCSV.getCustomerFromCSV();
        //Sap xep alpha B theo ten
        listCustomers.sort(new SortName());
        int i = 1;
        for (Customer customer : listCustomers) {
            System.out.println("\n---------------------------------------------");
            System.out.println("No: " + i);
            System.out.println(customer.showInfor());
            System.out.println("\n---------------------------------------------");
            i++;
        }
        System.out.println("Choose Customer Booking");
        Customer customer = new Customer();
        customer = listCustomers.get(ScannerUtils.scanner.nextInt() - 1);
        System.out.println("\n1.Booking Villa." +
                "\n2.Booking House." +
                "\n3.Booking Room.");
        System.out.println("Choose Services Booking");
        int choose = ScannerUtils.scanner.nextInt();
        switch (choose) {
            case 1:
                i = 1;
                ArrayList<Villa> listVillas = FuncWriteAndReadFileCSV.getVillaFromCSV();
                for (Villa villa : listVillas) {
                    System.out.println("\n---------------------------------------------");
                    System.out.println("No: " + i);
                    System.out.println(villa.showInfor());
                    System.out.println("\n---------------------------------------------");
                    i++;
                }
                System.out.println("Choose Villa Booking");
                Villa villa = listVillas.get(ScannerUtils.scanner.nextInt() - 1);
                customer.setServices(villa);
                break;
            case 2:
                i = 1;
                ArrayList<House> listHouses = FuncWriteAndReadFileCSV.getHouseFromCSV();
                for (House house : listHouses) {
                    System.out.println("\n---------------------------------------------");
                    System.out.println("No: " + i);
                    System.out.println(house.showInfor());
                    System.out.println("\n---------------------------------------------");
                    i++;
                }
                System.out.println("Choose House Booking");
                House house = listHouses.get(ScannerUtils.scanner.nextInt() - 1);
                customer.setServices(house);
                break;
            case 3:
                i = 1;
                ArrayList<Room> listRooms = FuncWriteAndReadFileCSV.getRoomFromCSV();
                for (Room room : listRooms) {
                    System.out.println("\n---------------------------------------------");
                    System.out.println("No: " + i);
                    System.out.println(room.showInfor());
                    System.out.println("\n---------------------------------------------");
                    i++;
                }
                System.out.println("Choose Room Booking");
                Room room = listRooms.get(ScannerUtils.scanner.nextInt() - 1);
                customer.setServices(room);
                break;
            default:
                backMainMenu();
                break;
        }
        ArrayList<Customer> listBooking = FuncWriteAndReadFileCSV.getBookingFromCSV();
        listBooking.add(customer);
        FuncWriteAndReadFileCSV.writeBookingToFileCsv(listBooking);
        System.out.println("\nAdd Booking for : " + customer.getNameCus() + " Successfully !!!");
        ScannerUtils.scanner.nextLine();
        backMainMenu();
    }

    public static void addNewServices() {
        Menu.displayMenuAddNewService();
        processMenuAddNewService();
    }

    public static void processMenuAddNewService() {
        switch (ScannerUtils.scanner.nextInt()) {
            case 1:
                addNewVilla();
                break;
            case 2:
                addNewHouse();
                break;
            case 3:
                addNewRoom();
                break;
            case 4:
                processMain();
                System.out.println("\n---------------------------------------------");
                break;
            case 5:
                System.exit(0);
                break;
            default:
                System.out.println("\nNhập sai hiển thị lại Menu");
                backMainMenu();
                break;
        }
    }

    public static void showServices() {
        Menu.displayMenuShowServices();
        processMenuShowServices();
    }

    public static void processMenuShowServices() {
        switch (ScannerUtils.scanner.nextInt()) {
            case 1:
                showVilla();
                break;
            case 2:
                showHouse();
                break;
            case 3:
                showRoom();
                break;
            case 4:
                showAllNameVilla();
                break;
            case 5:
                showAllNameHouse();
                break;
            case 6:
                showAllNameRoom();
                break;
            case 7:
                processMain();
                System.out.println("\n---------------------------------------------");
                break;
            case 8:
                System.exit(0);
                break;
            default:
                System.out.println("\nNhập sai hiển thị lại Menu");
                backMainMenu();
                break;
        }
    }

    private static void showAllNameVilla() {
        String pathVilla = "src/data/Villa.csv";
        Path path = Paths.get(pathVilla);
        if (!Files.exists(path)) {
            System.out.println("File Villa does not Exists! ");
            ScannerUtils.scanner.nextLine();
            backMainMenu();
        }
        TreeSet<String> villaTreeSet = FuncWriteAndReadFileCSV.getAllNameServiceFromCSV(pathVilla);
        System.out.println("\nList Name Service Villa Not Duplicate");
        for (String str : villaTreeSet) {
            System.out.println("\n-----------");
            System.out.println(str);
            System.out.println("\n-----------");
        }
        ScannerUtils.scanner.nextLine();
        backMainMenu();
    }

    private static void showAllNameRoom() {
        String pathRoom = "src/data/Room.csv";
        Path path = Paths.get(pathRoom);
        if (!Files.exists(path)) {
            System.out.println("File Room does not Exists! ");
            ScannerUtils.scanner.nextLine();
            backMainMenu();
        }
        TreeSet<String> roomTreeSet = FuncWriteAndReadFileCSV.getAllNameServiceFromCSV(pathRoom);
        System.out.println("\nList Name Service Room Not Duplicate");
        for (String str : roomTreeSet) {
            System.out.println("\n-----------");
            System.out.println(str);
            System.out.println("\n-----------");
        }
        ScannerUtils.scanner.nextLine();
        backMainMenu();
    }

    private static void showAllNameHouse() {
        String pathHouse = "src/data/House.csv";
        Path path = Paths.get(pathHouse);
        if (!Files.exists(path)) {
            System.out.println("File House does not Exists! ");
            ScannerUtils.scanner.nextLine();
            backMainMenu();
        }
        TreeSet<String> houseTreeSet = FuncWriteAndReadFileCSV.getAllNameServiceFromCSV(pathHouse);
        System.out.println("\nList Name Service House Not Duplicate");
        for (String str : houseTreeSet) {
            System.out.println("\n-----------");
            System.out.println(str);
            System.out.println("\n-----------");
        }
        ScannerUtils.scanner.nextLine();
        backMainMenu();
    }

    private static void showVilla() {
        ArrayList<Villa> listVillas = FuncWriteAndReadFileCSV.getVillaFromCSV();
        for (Villa villa : listVillas) {
            System.out.println("\n---------------------------------------------");
            System.out.println(villa.showInfor());
            System.out.println("\n---------------------------------------------");
        }
        ScannerUtils.scanner.nextLine();
        backMainMenu();

    }

    // Method Show List House

    private static void showHouse() {
        ArrayList<House> listHouses = FuncWriteAndReadFileCSV.getHouseFromCSV();
        for (House house : listHouses) {
            System.out.println("\n---------------------------------------------");
            System.out.println(house.showInfor());
            System.out.println("\n---------------------------------------------");
        }
        ScannerUtils.scanner.nextLine();
        backMainMenu();
    }

    private static void showRoom() {
        ArrayList<Room> listRooms = FuncWriteAndReadFileCSV.getRoomFromCSV();
        for (Room room : listRooms) {
            System.out.println("\n---------------------------------------------");
            System.out.println(room.showInfor());
            System.out.println("\n---------------------------------------------");
        }
        ScannerUtils.scanner.nextLine();
        backMainMenu();
    }

    //Add New Customer

//    private static Customer

    //Add New Service

    private static Services addNewService(Services services) {
        String content = "";
        String errMes = "";

        // get UUID
        services.setId(UUID.randomUUID().toString().replace("-", ""));
        ScannerUtils.scanner.nextLine();

        //Enter Name Services
        boolean hasError = false;
        do {
            try {
                services.setNameService(FuncValidation.getValidName(ENTER_NAME_SERVICES, INVALID_NAME_SERVICE));
                hasError = false;
            } catch (NameException e) {
                System.out.println(INVALID_NAME_SERVICE);
                hasError = true;
            }
        } while (hasError);

        //Enter Area Used
        double areaUsed = FuncValidation.checkValidNumberDouble(ENTER_AREA_USED, INVALID_DOUBLE_NUMBER);
        while (areaUsed <= 30) {
            System.out.println(INVALID_DOUBLE_NUMBER);
            areaUsed = FuncValidation.checkValidNumberDouble(ENTER_AREA_USED, INVALID_DOUBLE_NUMBER);
        }
        services.setAreaUsed(areaUsed);


        //Enter Rental Costs.
        double rentalCost = FuncValidation.checkValidNumberDouble(ENTER_RENTAL_COSTS, INVALID_RENTAL_COSTS);
        services.setRentalCosts(rentalCost);

        //Enter Max Number Of People
        int maxNumberOfPeople = FuncValidation.checkValidNumberInteger(ENTER_MAX_NUMBER_OF_PEOPLE, INVALID_MAX_PEOPLE);
        while (maxNumberOfPeople <= 0 || maxNumberOfPeople >= 20) {
            System.out.println(errMes);
            services.setMaxNumberOfPeople(FuncValidation.checkValidNumberInteger(content, errMes));
        }
        services.setMaxNumberOfPeople(maxNumberOfPeople);


        //Enter Type Rent
        boolean hasError_1 = false;
        do {
            try {
                services.setTypeRent(FuncValidation.getValidName(ENTER_TYPE_RENT, INVALID_TYPE_RENT));
                hasError_1 = false;
            } catch (NameException e) {
                System.out.println(errMes);
                hasError_1 = true;
            }
        } while (hasError);

        return services;
    }
    // Add New Villa

    public static void addNewVilla() {
        String content = "";
        String errMes = "";
        Services villa = new Villa();
        villa = addNewService(villa);

        //Enter Room Standard
//        ((Villa) villa).setRoomStandard(FuncValidation.getValidName(ENTER_ROOM_STANDARD, INVALIDE_ROOM_STANDARD));

        // Enter Description
        System.out.println("Enter Convenient Description: ");
        ((Villa) villa).setConvenientDescription(ScannerUtils.scanner.nextLine());

        // Enter Area Pool
        double areaPool = FuncValidation.checkValidNumberDouble(ENTER_AREA_POOL, INVALIDE_AREA_POOL);
        while (areaPool <= 30) {
            System.out.println(errMes);
            areaPool = FuncValidation.checkValidNumberDouble(ENTER_AREA_POOL, INVALIDE_AREA_POOL);
        }
        ((Villa) villa).setAreaPool(areaPool);

        // Enter Number Of Floors
        int numFloors = FuncValidation.checkValidNumberInteger(ENTER_NUMBER_OF_FLOORS, INVALID_NUMBER_FLOORS);
        while (numFloors <= 0) {
            System.out.println(errMes);
            numFloors = FuncValidation.checkValidNumberInteger(ENTER_NUMBER_OF_FLOORS, INVALID_NUMBER_FLOORS);
        }
        ((Villa) villa).setNumberOfFloors(numFloors);

        // Get list Villa from CSV
        ArrayList<Villa> listVilla = FuncWriteAndReadFileCSV.getVillaFromCSV();
        // Add villa to list
        listVilla.add((Villa) villa);
        // write to CSV
        FuncWriteAndReadFileCSV.writeVillaToFileCsv(listVilla);

        System.out.println("\nAdd Villa: " + villa.getNameService() + " Successfully");

        backMainMenu();
    }

    //Add New House

    private static void addNewHouse() {
        String content = "";
        String errMes = "";
        Services house = new House();
        house = addNewService(house);
        //Enter Room Standard

        System.out.println("Enter Room Standard: ");
        ((House) house).setRoomStandard(ScannerUtils.scanner.nextLine());
        while (!FuncValidation.isValidNameServices(((House) house).getRoomStandard())) {
            System.out.println("Room Standard is invalid. Please try again !!!");
            System.out.println("Enter Room Standard: ");
            ((House) house).setRoomStandard(ScannerUtils.scanner.nextLine());
        }

        //Enter Description

        System.out.println("Enter Convenient Description: ");
        ((House) house).setConvenientDescription(ScannerUtils.scanner.nextLine());

        // Enter Number Of Floors

        content = "Number Of Floors: ";
        errMes = "Number Of Floors is invalid (Number Of Floors > 0, Number Of Floors must be a Integer). Please try again!!!";
        ((House) house).setNumberOfFloors(FuncValidation.checkValidNumberInteger(content, errMes));
        while (((House) house).getNumberOfFloors() <= 0) {
            System.out.println(errMes);
            ((House) house).setNumberOfFloors(FuncValidation.checkValidNumberInteger(content, errMes));
        }
        ArrayList<House> listHouse = FuncWriteAndReadFileCSV.getHouseFromCSV();
        listHouse.add((House) house);
        FuncWriteAndReadFileCSV.writeHouseToFileCsv(listHouse);
        System.out.println("\nAdd House: " + house.getNameService() + " Successfully");
        backMainMenu();
    }

    //Add New Room

    private static void addNewRoom() {
        Services room = new Room();
        room = addNewService(room);
        System.out.println("Enter Free Services: ");
        ((Room) room).setFreeService(ScannerUtils.scanner.nextLine().toLowerCase());
        while (true) {
            if (((Room) room).getFreeService().equals("massage") || ((Room) room).getFreeService().equals("karaoke")
                    || ((Room) room).getFreeService().equals("food")
                    || ((Room) room).getFreeService().equals("drink") || ((Room) room).getFreeService().equals("car")) {
                break;
            }
            System.out.println("Free Services must be equal massage, food, karaoke, drink or car. Please try again...");
            System.out.println("Enter Free Services: ");
            ((Room) room).setFreeService(ScannerUtils.scanner.nextLine().toLowerCase());
        }
        ArrayList<Room> listRoom = FuncWriteAndReadFileCSV.getRoomFromCSV();
        listRoom.add((Room) room);
        FuncWriteAndReadFileCSV.writeRoomToFileCsv(listRoom);
        System.out.println("\nAdd Room: " + room.getNameService() + " Successfully");
        backMainMenu();
    }

    //Add New Room

    private static void addNewCustomer() {
        Scanner sc = new Scanner(System.in);

        String content = "";
        String errMes = "";

        Customer customer = new Customer();

        //set id customer
        customer.setIdCus(UUID.randomUUID().toString().replace("-", ""));

        //set Name Customer

        System.out.println("Enter Name Customer: ");
        customer.setNameCus(ScannerUtils.scanner.nextLine());
        while (!FuncValidation.isValidNameServices(customer.getNameCus())) {
            System.out.println("Name Customer is invalid. Please try again !!!");
            System.out.println("Enter Name Customer: ");
            customer.setNameCus(ScannerUtils.scanner.nextLine());
        }


        //set Gender Customer
        while (true) {
            System.out.println("Enter Gender Customer: ( Male / Female / Unknow ) ");
            String gender = ScannerUtils.scanner.nextLine();
            if (gender.toLowerCase().equals("male") || gender.toLowerCase().equals("female")
                    || gender.toLowerCase().equals("unknow")) {
                String temp = "";
                temp += Character.toUpperCase(gender.charAt(0)) + gender.substring(1, gender.length()).toLowerCase();
                customer.setGenderCus(temp);
                break;
            }
            System.out.println("Gender Customer is invalid. Please try again !!!");
        }

        //set Id Card Customer
        content = "Enter Id Card Customer: ";
        errMes = "Id Card Is Invalid. Id Card Mus Be Integer (100.000.000 - 999.999.999) !!!";
        customer.setIdCardCus(FuncValidation.checkValidNumberInteger(content, errMes));
        while (customer.getIdCardCus() <= 100000000 || customer.getIdCardCus() >= 999999999) {
            System.out.println(errMes);
            customer.setIdCardCus(FuncValidation.checkValidNumberInteger(content, errMes));
        }

        //set Phone Number Customer
        System.out.println("Enter Phone Number Customer: ");
        customer.setPhoneNumber(ScannerUtils.scanner.nextLine());

        //set Email Customer
        System.out.println("Enter Email Customer: ");
        customer.setEmailCus(ScannerUtils.scanner.nextLine());
        while (!FuncValidation.checkEmail(customer.getEmailCus())) {
            System.out.println("Email Is Invalid !!! Please Try Again...");
            System.out.println("Enter Email Customer: ");
            customer.setEmailCus(ScannerUtils.scanner.nextLine());
        }

        //set Type Customer
        System.out.println("Enter Type Customer: ");
        customer.setTypeCus(ScannerUtils.scanner.nextLine());

        //set Address Customer
        System.out.println("Enter Address Customer: ");
        customer.setAddressCus(ScannerUtils.scanner.nextLine());

        //set Birthday Customer
        System.out.println("Enter Birthday Customer (dd/MM/yyyy): ");
        customer.setBirthday(ScannerUtils.scanner.nextLine());
        while (!FuncValidation.checkBirthday(customer.getBirthday())) {
            System.out.println("Birthday Is Invalid !!! Please Try Again...");
            System.out.println("Enter Birthday Customer (dd/MM/yyyy): ");
            customer.setBirthday(ScannerUtils.scanner.nextLine());
        }
        //Write File Customer.CSV
        ArrayList<Customer> listCustomer = FuncWriteAndReadFileCSV.getCustomerFromCSV();
        listCustomer.add(customer);
        FuncWriteAndReadFileCSV.writeCustomerToFileCsv(listCustomer);
        System.out.println("\nAdd Customer: " + customer.getNameCus() + " Successfully !!!");
        ScannerUtils.scanner.nextLine();
        backMainMenu();

    }

    //Show Information Customer
    private static void showInformationCustomers() {
        ArrayList<Customer> listCustomers = FuncWriteAndReadFileCSV.getCustomerFromCSV();

        //Sap xep alpha B theo ten
        listCustomers.sort(new SortName());
        for (Customer customer : listCustomers) {
            System.out.println("\n---------------------------------------------");
            System.out.println(customer.showInfor());
            System.out.println("\n---------------------------------------------");
        }
    }

    public static void backMainMenu() {
        Menu.displayMenuBackToMain();
        processMain();
    }


}
