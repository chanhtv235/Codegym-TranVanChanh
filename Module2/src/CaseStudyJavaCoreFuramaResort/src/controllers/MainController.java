package controllers;

import commons.FuncValidate;
import commons.FuncWriteFileCSV;
import models.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.UUID;

public class MainController {
    public static void DisplayMainMenu(){
        System.out.println( "1.Add New Service.\n"+
                            "2.Show Service\n"+
                            "3.Exit");
        Scanner input =new Scanner(System.in);
        int selection1=input.nextInt();
        switch (selection1){
            case 1:AddNewServices();
                    break;
            case 2:ShowInfo();
                    break;
            case 3: System.exit(0);
            default:
                System.out.println("Enter try Again");
                BackMainMenu();

        }
    }
    private static void BackMainMenu()  {
        DisplayMainMenu();
    }
    private static void AddNewServices()  {
        System.out.println( "1. Add New Villa\n"+
                            "2. Add New House\n"+
                            "3. Add New Room\n" +
                            "4. Back to menu\n"+
                            "5. Exit");
        Scanner input =new Scanner(System.in);
        int selection2=input.nextInt();
        switch (selection2){
            case 1:
                System.out.println("1. Add New Villa\n");
                    Villa villa=AddNewVilla();
                    ArrayList<Villa> listVilla =new ArrayList<>();
                    listVilla.add(villa);
                     FuncWriteFileCSV.writeVillaToFileSCV(listVilla);
                    BackMainMenu();
                    break;
            case 2:
                System.out.println("2. Add New House");
                    House house=AddNewHouse();
                    ArrayList<House>listHouse=new ArrayList<>();
                    listHouse.add(house);
                    FuncWriteFileCSV.writeHouseToFileSCV(listHouse);
                    BackMainMenu();
                    break;
            case 3: Room room=AddNewRoom();
                    ArrayList<Room>listRoom=new ArrayList<>();
                    listRoom.add(room);
                    FuncWriteFileCSV.writeRoomToFileSCV(listRoom);
                    BackMainMenu();
                    break;
            case 4: BackMainMenu();
                    break;
            case 5: System.exit(0);
            default:
                BackMainMenu();
        }
    }
    private static void ShowInfo(){
        System.out.println( "1. Show All Villa\n"+
                "2. Show All House\n"+
                "3. Show All Room\n" +
                "4. Back to menu\n"+
                "5. Exit");
        Scanner input =new Scanner(System.in);
        int selection3=input.nextInt();
        switch (selection3){
            case 1:ShowAllVilla();
                BackMainMenu();
                break;
            case 2:ShowAllHouse();
                BackMainMenu();
                break;
            case 3:ShowAllRoom();
                BackMainMenu();
            break;
            case 4:BackMainMenu();
                break;
            case 5: System.exit(0);
            default:
                System.out.println("Enter try Again");
               BackMainMenu();
        }
    }

    private static Services AddNewService(Services services){
        Scanner input;
        input=new Scanner(System.in);

        //// Enter Service Name;
        boolean check=false;
        String name;
        do {
            System.out.println("Enter Service Name");
            name=input.nextLine();
            check= FuncValidate.checkName(name);
        }while (!check);
        services.setName(name);
        /////Automatic Enter ID
        services.setId(UUID.randomUUID().toString().replace("-",""));
        ////Enter user area
        float area;
        do {
            check=false;
            System.out.println("Enter Area");
            area=input.nextFloat();
            if (area<30&&area>0){
                check=true;
            }
        }while (!check);
        services.setArea(area);
        /// Enter rental Cost;
        float rentCost;
        do {
            check=false;
            System.out.println("Enter rental Cost");
            input=new Scanner(System.in);
            rentCost=input.nextFloat();
            if (rentCost>0){
                check=true;
            }
        }while (!check);
        services.setRentCost(rentCost);
// Enter the limited  number of person;
        int personLimitNumber;
        do {
            check=false;
            System.out.println("Enter number person limit");
            personLimitNumber=input.nextInt();
            if (personLimitNumber>0&&personLimitNumber<20){
                check=true;
            }
        }while (!check);
        services.setPersonLimit(personLimitNumber);
        // Enter rental type;
        String rentType;
        do {
            System.out.println("Enter rental Type");
            input=new Scanner(System.in);
            rentType=input.nextLine();
            check= FuncValidate.checkName(rentType);
        }while (!check);
        services.setRentType(rentType);
        ///// finish enter information of Service;
        return services;
    }

    private static Villa AddNewVilla(){
        Scanner input=new Scanner(System.in);
        Villa villa=new Villa();
        AddNewService(villa);
        // Enter room standard
        boolean check=false;
        String roomStandard;
        do {
            check=false;
            System.out.println("Enter room standard");
            roomStandard=input.nextLine();
            check= FuncValidate.checkName(roomStandard);
        }while (!check);
        villa.setRoomStandard(roomStandard);
        // Enter pool area
        float poolArea;
        do {
            check=false;
            System.out.println("Enter pool area");
            poolArea=input.nextFloat();

            if (poolArea<30&&poolArea>0){
                check=true;
            }
        }while (!check);
        villa.setPoolArea(poolArea);

        ///// Enter convenient
        String convenient;
        do {
            check=false;
            System.out.println("Enter convenient");
            input=new Scanner(System.in);
            convenient=input.nextLine();
            check=FuncValidate.checkConveninent(convenient);
        }while (!check);
        villa.setConvenient(convenient);

        ////Enter the number of Floor;
        int floorNumber;
        do {
            check=false;
            System.out.println("Enter the number of floor");
            floorNumber=input.nextInt();
            if (floorNumber>0){
                check=true;
            }
        }while (!check);
        villa.setFloorNumber(floorNumber);

        //////////////////Finish Enter information of Villa
        return villa;
    }
    private static House AddNewHouse(){
        Scanner input=new Scanner(System.in);
        House house=new House();
        AddNewService(house);
        /// Enter Room standard
        String roomStandard;
        boolean check=false;
        do {
            check=false;
            System.out.println("Enter room standard");
            roomStandard=input.nextLine();
            check= FuncValidate.checkName(roomStandard);
        }while (!check);
        house.setRoomStandard(roomStandard);

       /// Enter convenient House
        String convenient;
        do {
            check=false;
            System.out.println("Enter convenient");
            input=new Scanner(System.in);
            convenient=input.nextLine();
            check=FuncValidate.checkConveninent(convenient);
        }while (!check);
        house.setConvenient(convenient);

        // Enter the number of floor
        int floorNumber;
        do {
            check=false;
            System.out.println("Enter the number of floor");
            floorNumber=input.nextInt();
            if (floorNumber>0){
                check=true;
            }
        }while (!check);
        house.setFloorNumber(floorNumber);

        // finsh enter information of House
        return house;
    }

    private static Room AddNewRoom(){
        Scanner input=new Scanner(System.in);
        Room room=new Room();
        AddNewService(room);
        System.out.println("Enter free service:");
        room.setFreeServices(input.nextLine());
        return room;
    }

    private static void ShowAllVilla() {
        ArrayList<Villa> listvilla=FuncWriteFileCSV.getVillaFromCSV();
        for (Villa villa:listvilla){
            System.out.println("----------------------");
           System.out.println(villa.ShowInfo());
            System.out.println("----------------------");
        }
    }

    private static void ShowAllHouse() {
        ArrayList<House> listvilla=FuncWriteFileCSV.getHouseFromCSV();
        for (House house:listvilla){
            System.out.println("----------------------");
            System.out.println(house.ShowInfo());
            System.out.println("----------------------");
        }
    }

    private static void ShowAllRoom() {
        ArrayList<Room> listvilla=FuncWriteFileCSV.getRoomFromCSV();
        for (Room room:listvilla){
            System.out.println("----------------------");
            System.out.println(room.ShowInfo());
            System.out.println("----------------------");
        }
    }


}
