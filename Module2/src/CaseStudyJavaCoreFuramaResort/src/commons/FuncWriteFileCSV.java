package CaseStudyJavaCoreFuramaResort.src.commons;
import CaseStudyJavaCoreFuramaResort.src.models.Customer;

import CaseStudyJavaCoreFuramaResort.src.models.Villa;
import com.opencsv.CSVWriter;
import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import CaseStudyJavaCoreFuramaResort.src.models.House;
import models.Room;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
public class FuncWriteFileCSV {
    private static final char DEFAULT_SEPRATOR=',';
    private static final char DEFAULT_QUOTE='"';
    private static final String pathVilla="src/CaseStudyJavaCoreFuramaResort/src/data/Villa.csv";
    private static final String pathHouse="src/CaseStudyJavaCoreFuramaResort/src/data/House.csv";
    private static final String pathRoom="src/CaseStudyJavaCoreFuramaResort/src/data/Room.csv";
    private static final String pathCustomer="src/CaseStudyJavaCoreFuramaResort/src/data/Customer.csv";
    private static String[] headerRecordVilla=new String[]{"iDService",
                                                            "nameService",
                                                            "area",
                                                            "rentCost",
                                                            "personLimit",
                                                            "rentType",
                                                            "roomStandard",
                                                            "convenient",
                                                            "floorNumber",
                                                            "poolArea"};
    private static String[] headerRecordHouse=new String[]{"iDService",
                                                            "nameService",
                                                            "area",
                                                            "rentCost",
                                                            "personLimit",
                                                            "rentType",
                                                            "roomStandard",
                                                            "convenient",
                                                            "floorNumber"};
    private static String[] headerRecordRoom=new String[]{ "iDService",
                                                            "nameService",
                                                            "area",
                                                            "rentCost",
                                                            "personLimit",
                                                            "rentType",
                                                            "freeServices"};
    private static String[] headerRecordCustomer=new String[]{  "iD",
                                                                "customerName",
                                                                "birthdayOfCustomer",
                                                                "gender",
                                                                "customerId",
                                                                "customerPhone",
                                                                "customerEmail",
                                                                "customerType",
                                                                "customerAddress",
                                                                };
    // the line number to skip for start reading
    private static final int NUM_OF_LINE_SKIP=1;
    //funcion write Villa...............................................
    public static void writeVillaToFileSCV(ArrayList<Villa>arrayList){
        try(Writer writer =new FileWriter(pathVilla);
            CSVWriter csvWriter=new CSVWriter(writer,
                    CSVWriter.DEFAULT_SEPARATOR,
                    CSVWriter.NO_QUOTE_CHARACTER,
                    CSVWriter.DEFAULT_ESCAPE_CHARACTER,
                    CSVWriter.DEFAULT_LINE_END)) {
            csvWriter.writeNext(headerRecordVilla);
            for (Villa villa:arrayList){
                csvWriter.writeNext(new String[]{
                        villa.getIDService(),
                        villa.getNameService(),
                        String.valueOf(villa.getArea()),
                        String.valueOf(villa.getRentCost()),
                        String.valueOf(villa.getPersonLimit()),
                        villa.getRentType(),
                        villa.getRoomStandard(),
                        villa.getConvenient(),
                        String.valueOf(villa.getFloorNumber()),
                        String.valueOf(villa.getPoolArea())
                });
            }
        } catch (IOException ex)
        {
            System.out.println(ex.getMessage());
        }
    }

    // funcion write House
    public static void writeHouseToFileSCV(ArrayList<House>arrayList){
        try(Writer writer =new FileWriter(pathHouse);
            CSVWriter csvWriter=new CSVWriter(writer,
                    CSVWriter.DEFAULT_SEPARATOR,
                    CSVWriter.NO_QUOTE_CHARACTER,
                    CSVWriter.DEFAULT_ESCAPE_CHARACTER,
                    CSVWriter.DEFAULT_LINE_END)) {
            csvWriter.writeNext(headerRecordHouse);
            for (House house:arrayList){
                csvWriter.writeNext(new String[]{
                        house.getIDService(),
                        house.getNameService(),
                        String.valueOf(house.getArea()),
                        String.valueOf(house.getRentCost()),
                        String.valueOf(house.getPersonLimit()),
                        house.getRentType(),
                        house.getRoomStandard(),
                        house.getConvenient(),
                        String.valueOf(house.getFloorNumber())
                });
            }
        } catch (IOException ex)
        {
            System.out.println(ex.getMessage());
        }
    }

    // funciotn write Room
    public static void writeRoomToFileSCV(ArrayList<Room>arrayList){
        try(Writer writer =new FileWriter(pathRoom);
            CSVWriter csvWriter=new CSVWriter(writer,
                    CSVWriter.DEFAULT_SEPARATOR,
                    CSVWriter.NO_QUOTE_CHARACTER,
                    CSVWriter.DEFAULT_ESCAPE_CHARACTER,
                    CSVWriter.DEFAULT_LINE_END)) {
            csvWriter.writeNext(headerRecordRoom);
            for (Room room:arrayList){
                csvWriter.writeNext(new String[]{
                        room.getIDService(),
                        room.getNameService(),
                        String.valueOf(room.getArea()),
                        String.valueOf(room.getRentCost()),
                        String.valueOf(room.getPersonLimit()),
                        room.getRentType(),
                        room.getFreeServices()
                });
            }
        } catch (IOException ex)
        {
            System.out.println(ex.getMessage());
        }
    }

    //funcion write Customer...............................................
    public static void writeCustomerToFileSCV(ArrayList<Customer> arrayList){
        try(Writer writer =new FileWriter(pathCustomer);
            CSVWriter csvWriter=new CSVWriter(writer,
                    CSVWriter.DEFAULT_SEPARATOR,
                    CSVWriter.NO_QUOTE_CHARACTER,
                    CSVWriter.DEFAULT_ESCAPE_CHARACTER,
                    CSVWriter.DEFAULT_LINE_END)) {
            csvWriter.writeNext(headerRecordCustomer);
            for (Customer customer:arrayList){
                csvWriter.writeNext(new String[]{
                        customer.getID(),
                        customer.getCustomerName(),
                        customer.getBirthdayOfCustomer(),
                        customer.getGender(),
                        customer.getCustomerId(),
                        customer.getCustomerPhone(),
                        customer.getCustomerEmail(),
                        customer.getCustomerType(),
                        customer.getCustomerAddress()
                });
            }
        } catch (IOException ex)
        {
            System.out.println(ex.getMessage());
        }
    }

    // funcion get Villa from file Customer.csv
    public static ArrayList<Villa> getVillaFromCSV(){
        Path path = Paths.get(pathVilla);
        if (!Files.exists(path)){
            try {
                Writer writer =new FileWriter(pathVilla);
            }catch (IOException ex){
                System.out.println(ex.getMessage());
            }
        }
        ColumnPositionMappingStrategy<Villa> strategy = new ColumnPositionMappingStrategy<>();
        strategy.setType(Villa.class);
        strategy.setColumnMapping(headerRecordVilla);
        CsvToBean<Villa> csvToBean =null;
        try {
            csvToBean = new CsvToBeanBuilder<Villa>(new FileReader(pathVilla))
                    .withMappingStrategy(strategy)
                    .withSeparator(DEFAULT_SEPRATOR)
                    .withQuoteChar(DEFAULT_QUOTE)
                    .withSkipLines(NUM_OF_LINE_SKIP)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();
        }catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
        assert csvToBean != null;
        return (ArrayList<Villa>) csvToBean.parse();
    }

    // funcion get House from file House.csv
    public static ArrayList<House> getHouseFromCSV(){
        Path path = Paths.get(pathHouse);
        if (!Files.exists(path)){
            try {
                Writer writer =new FileWriter(pathHouse);
            }catch (IOException ex){
                System.out.println(ex.getMessage());
            }
        }
        ColumnPositionMappingStrategy<House> strategy = new ColumnPositionMappingStrategy<>();
        strategy.setType(House.class);
        strategy.setColumnMapping(headerRecordVilla);
        CsvToBean<House> csvToBean =null;
        try {
            csvToBean = new CsvToBeanBuilder<House>(new FileReader(pathHouse))
                    .withMappingStrategy(strategy)
                    .withSeparator(DEFAULT_SEPRATOR)
                    .withQuoteChar(DEFAULT_QUOTE)
                    .withSkipLines(NUM_OF_LINE_SKIP)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();
        }catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
        assert csvToBean != null;
        return (ArrayList<House>) csvToBean.parse();
    }

    // funcion get Room from file Room.csv
    public static ArrayList<Room> getRoomFromCSV(){
        Path path = Paths.get(pathRoom);
        if (!Files.exists(path)){
            try {
                Writer writer =new FileWriter(pathRoom);
            }catch (IOException ex){
                System.out.println(ex.getMessage());
            }
        }
        ColumnPositionMappingStrategy<Room> strategy = new ColumnPositionMappingStrategy<>();
        strategy.setType(Room.class);
        strategy.setColumnMapping(headerRecordRoom);
        CsvToBean<Room> csvToBean =null;
        try {
            csvToBean = new CsvToBeanBuilder<Room>(new FileReader(pathRoom))
                    .withMappingStrategy(strategy)
                    .withSeparator(DEFAULT_SEPRATOR)
                    .withQuoteChar(DEFAULT_QUOTE)
                    .withSkipLines(NUM_OF_LINE_SKIP)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();
        }catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
        assert csvToBean != null;
        return (ArrayList<Room>) csvToBean.parse();
    }

    // funcion get Customer from file Customer.csv
    public static ArrayList<Customer> getCustomerFromCSV(){
        Path path = Paths.get(pathCustomer);
        if (!Files.exists(path)){
            try {
                Writer writer =new FileWriter(pathHouse);
            }catch (IOException ex){
                System.out.println(ex.getMessage());
            }
        }
        ColumnPositionMappingStrategy<Customer> strategy = new ColumnPositionMappingStrategy<>();
        strategy.setType(Customer.class);
        strategy.setColumnMapping(headerRecordCustomer);
        CsvToBean<Customer> csvToBean =null;
        try {
            csvToBean = new CsvToBeanBuilder<Customer>(new FileReader(pathCustomer))
                    .withMappingStrategy(strategy)
                    .withSeparator(DEFAULT_SEPRATOR)
                    .withQuoteChar(DEFAULT_QUOTE)
                    .withSkipLines(NUM_OF_LINE_SKIP)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();
        }catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
        assert csvToBean != null;
        return (ArrayList<Customer>) csvToBean.parse();
    }
}
