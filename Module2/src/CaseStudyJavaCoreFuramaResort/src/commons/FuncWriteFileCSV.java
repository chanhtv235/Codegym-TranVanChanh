package commons;

import com.opencsv.CSVWriter;
import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import models.House;
import models.Room;
import models.Villa;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class FuncWriteFileCSV{
    private static final char DEFAULT_SEPRATOR=',';
    private static final char DEFAULT_QUOTE='"';
    private static final String pathVilla="src/data/Villa.csv";
    private static final String pathHouse="src/data/House.csv";
    private static final String pathRoom="src/data/Room.csv";
    private static String[] headerRecordVilla=new String[]{"name","id","area","rentCost","personLimit","rentType",
                                                            "roomStandard", "convenient","floorNumber","poolArea"};
    private static String[] headerRecordHouse=new String[]{"name", "id","area","rentCost",
            "personLimit","rentType","roomStandard",
            "convenient","floorNumber"};
    private static String[] headerRecordRoom=new String[]{"name", "id","area","rentCost",
            "personLimit","rentType","freeServices"};
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
                        villa.getName(),
                        villa.getId(),
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
                        house.getName(),house.getId(),String.valueOf(house.getArea()),
                        String.valueOf(house.getRentCost()),String.valueOf(house.getPersonLimit()),
                        house.getRentType(),house.getRoomStandard(),house.getConvenient(),
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
                        room.getName(),room.getId(),String.valueOf(room.getArea()),
                        String.valueOf(room.getRentCost()),String.valueOf(room.getPersonLimit()),
                        room.getRentType(),room.getFreeServices()
                });
            }
        } catch (IOException ex)
        {
            System.out.println(ex.getMessage());
        }
    }
    // funcion get Villa from file Villa.csv
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
        strategy.setColumnMapping(headerRecordVilla);
        CsvToBean<Room> csvToBean =null;
        try {
            csvToBean = new CsvToBeanBuilder<Room>(new FileReader(pathHouse))
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
}
