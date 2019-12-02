package Case_Study.JavaCore.SaveToFile.Commons;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.TreeSet;


import Case_Study.JavaCore.SaveToFile.Models.Customer;
import Case_Study.JavaCore.SaveToFile.Models.House;
import Case_Study.JavaCore.SaveToFile.Models.Room;
import Case_Study.JavaCore.SaveToFile.Models.Villa;
import com.opencsv.CSVParser;
import com.opencsv.CSVWriter;
import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import org.apache.commons.lang3.StringUtils;

public class FuncWriteAndReadFileCSV {
    // the delimiter to use for separating entries
    private static final char DEFAULT_SEPARATOR = ',';
    // the character to use for quoted elements
    private static final char DEFAULT_QUOTE = '"';

    // the line number to skip for start reading
    private static final int NUM_OF_LINE_SKIP = 1;

    // path file Villa.csv
    private static final String pathVilla = "src/Case_Study/JavaCore/SaveToFile/DataVilla.csv";

    // path file Room.csv
    private static final String pathRoom = "src/Case_Study/JavaCore/SaveToFile/Data/Room.csv";

    // path file House.csv
    private static final String pathHouse = "src/Case_Study/JavaCore/SaveToFile/Data/House.csv";

    // path file House.csv
    private static final String pathCustomer = "src/Case_Study/JavaCore/SaveToFile/Data/Customer.csv";

    // path file Booking.csv
    private static final String pathBooking = "src/Case_Study/JavaCore/SaveToFile/Data/Booking.csv";

    // header Villa.csv
    private static String[] headerRecordVilla = new String[]{"id", "nameService", "areaUsed", "rentalCosts", "maxNumberOfPeople", "typeRent", "roomStandard", "convenientDescription", "areaPool", "numberOfFloors"};

    // header Room.csv
    private static String[] headerRecordRoom = new String[]{"id", "nameService", "areaUsed", "rentalCosts", "maxNumberOfPeople", "typeRent", "freeService"};

    // header House.csv
    private static String[] headerRecordHouse = new String[]{"id", "nameService", "areaUsed", "rentalCosts", "maxNumberOfPeople", "typeRent", "roomStandard", "convenientDescription", "numberOfFloors"};

    // header House.csv
    private static String[] headerRecordCustomer = new String[]{"idCus", "nameCus", "genderCus", "idCardCus", "phoneNumber", "emailCus", "typeCus", "addressCus","birthday"};

    //header Booking.csv
    private static String[] headerRecordBooking = new String[]{"idCus", "nameCus", "genderCus", "idCardCus", "phoneNumber", "emailCus", "typeCus", "addressCus","birthday",
            "id", "nameService", "areaUsed", "rentalCosts", "maxNumberOfPeople", "typeRent"};

    //function write Villa to File CSV
    public static void writeVillaToFileCsv(ArrayList<Villa> arrayList) {
        try (Writer writer = new FileWriter(pathVilla);
             CSVWriter csvWriter = new CSVWriter(writer,
                     CSVWriter.DEFAULT_SEPARATOR,
                     CSVWriter.NO_QUOTE_CHARACTER,
                     CSVWriter.DEFAULT_ESCAPE_CHARACTER,
                     CSVWriter.DEFAULT_LINE_END);) {
            csvWriter.writeNext(headerRecordVilla);
            for (Villa villa : arrayList) {
                csvWriter.writeNext(new String[]
                        {villa.getId(), villa.getNameService(), String.valueOf(villa.getAreaUsed()), String.valueOf(villa.getRentalCosts()), String.valueOf(villa.getMaxNumberOfPeople()),
                                villa.getTypeRent(), villa.getRoomStandard(), villa.getConvenientDescription(), String.valueOf(villa.getAreaPool()), String.valueOf(villa.getNumberOfFloors())});
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    //function write Room to File CSV

    public static void writeRoomToFileCsv(ArrayList<Room> arrayList) {
        try (Writer writer = new FileWriter(pathRoom);
             CSVWriter csvWriter = new CSVWriter(writer,
                     CSVWriter.DEFAULT_SEPARATOR,
                     CSVWriter.NO_QUOTE_CHARACTER,
                     CSVWriter.DEFAULT_ESCAPE_CHARACTER,
                     CSVWriter.DEFAULT_LINE_END);) {
            //add Header of File
            csvWriter.writeNext(headerRecordRoom);
            for (Room room : arrayList) {
                csvWriter.writeNext(new String[]
                        {room.getId(), room.getNameService(), String.valueOf(room.getAreaUsed()), String.valueOf(room.getRentalCosts()), String.valueOf(room.getMaxNumberOfPeople()),
                                room.getTypeRent(), room.getFreeService()});
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    //function write House to File CSV

    public static void writeHouseToFileCsv(ArrayList<House> arrayList) {
        try (Writer writer = new FileWriter(pathHouse);
             CSVWriter csvWriter = new CSVWriter(writer,
                     CSVWriter.DEFAULT_SEPARATOR,
                     CSVWriter.NO_QUOTE_CHARACTER,
                     CSVWriter.DEFAULT_ESCAPE_CHARACTER,
                     CSVWriter.DEFAULT_LINE_END);) {
            //add Header of File
            csvWriter.writeNext(headerRecordHouse);
            for (House house : arrayList) {
                csvWriter.writeNext(new String[]
                        {house.getId(), house.getNameService(), String.valueOf(house.getAreaUsed()), String.valueOf(house.getRentalCosts()), String.valueOf(house.getMaxNumberOfPeople()),
                                house.getTypeRent(), house.getRoomStandard(), house.getConvenientDescription(), String.valueOf(house.getNumberOfFloors())});
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    //function write Customer to File CSV

    public static void writeCustomerToFileCsv(ArrayList<Customer> arrayList) {
        try (Writer writer = new FileWriter(pathCustomer);
             CSVWriter csvWriter = new CSVWriter(writer,
                     CSVWriter.DEFAULT_SEPARATOR,
                     CSVWriter.NO_QUOTE_CHARACTER,
                     CSVWriter.DEFAULT_ESCAPE_CHARACTER,
                     CSVWriter.DEFAULT_LINE_END);) {

            //add Header of File
            csvWriter.writeNext(headerRecordCustomer);
            for (Customer customer : arrayList) {
                csvWriter.writeNext(new String[]
                        {customer.getIdCus(), customer.getNameCus(), customer.getGenderCus(), String.valueOf(customer.getIdCardCus()),
                                customer.getPhoneNumber(), customer.getEmailCus(), customer.getTypeCus(), customer.getAddressCus(), customer.getBirthday()
                        });
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    //write Booking to File CSV
    public static void writeBookingToFileCsv(ArrayList<Customer> arrayList) {
        try (Writer writer = new FileWriter(pathBooking);
             CSVWriter csvWriter = new CSVWriter(writer,
                     CSVWriter.DEFAULT_SEPARATOR,
                     CSVWriter.NO_QUOTE_CHARACTER,
                     CSVWriter.DEFAULT_ESCAPE_CHARACTER,
                     CSVWriter.DEFAULT_LINE_END);) {

            //add Header of File
            csvWriter.writeNext(headerRecordBooking);
            for (Customer customer : arrayList) {
                csvWriter.writeNext(new String[]
                        {customer.getIdCus(), customer.getNameCus(), customer.getGenderCus(), String.valueOf(customer.getIdCardCus()),
                                customer.getPhoneNumber(), customer.getEmailCus(), customer.getTypeCus(), customer.getAddressCus(), customer.getBirthday(),
                                customer.getServices().getId(), customer.getServices().getNameService(), String.valueOf(customer.getServices().getAreaUsed()), String.valueOf(customer.getServices().getRentalCosts()),
                                String.valueOf(customer.getServices().getMaxNumberOfPeople()),
                                customer.getServices().getTypeRent()
                        });
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    //get list Booking from CSV
    public static ArrayList<Customer> getBookingFromCSV() {
        Path path = Paths.get(pathBooking);
        if (!Files.exists(path)) {
            try {
                Writer writer = new FileWriter(pathBooking);
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
        ColumnPositionMappingStrategy<Customer> strategy = new ColumnPositionMappingStrategy<>();
        strategy.setType(Customer.class);
        strategy.setColumnMapping(headerRecordBooking);

        CsvToBean<Customer> csvToBean = null;
        try {
            csvToBean = new CsvToBeanBuilder<Customer>(new FileReader(pathBooking))
                    .withMappingStrategy(strategy)
                    .withSeparator(DEFAULT_SEPARATOR)
                    .withQuoteChar(DEFAULT_QUOTE)
                    .withSkipLines(NUM_OF_LINE_SKIP)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
        return (ArrayList<Customer>) csvToBean.parse();
    }

    //get List Villa From File CSV

    public static ArrayList<Villa> getVillaFromCSV() {
        Path path = Paths.get(pathVilla);
        if (!Files.exists(path)) {
            try {
                Writer writer = new FileWriter(pathVilla);
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
        ColumnPositionMappingStrategy<Villa> strategy = new ColumnPositionMappingStrategy<>();
        strategy.setType(Villa.class);
        strategy.setColumnMapping(headerRecordVilla);

        CsvToBean<Villa> csvToBean = null;
        try {
            csvToBean = new CsvToBeanBuilder<Villa>(new FileReader(pathVilla))
                    .withMappingStrategy(strategy)
                    .withSeparator(DEFAULT_SEPARATOR)
                    .withQuoteChar(DEFAULT_QUOTE)
                    .withSkipLines(NUM_OF_LINE_SKIP)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
        return (ArrayList<Villa>) csvToBean.parse();
    }

    //get List House From File CSV

    public static ArrayList<House> getHouseFromCSV() {
        Path path = Paths.get(pathHouse);
        if (!Files.exists(path)) {
            try {
                Writer writer = new FileWriter(pathHouse);
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
        ColumnPositionMappingStrategy<House> strategy = new ColumnPositionMappingStrategy<>();
        strategy.setType(House.class);
        strategy.setColumnMapping(headerRecordHouse);

        CsvToBean<House> csvToBean = null;
        try {
            csvToBean = new CsvToBeanBuilder<House>(new FileReader(pathHouse))
                    .withMappingStrategy(strategy)
                    .withSeparator(DEFAULT_SEPARATOR)
                    .withQuoteChar(DEFAULT_QUOTE)
                    .withSkipLines(NUM_OF_LINE_SKIP)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
        return (ArrayList<House>) csvToBean.parse();
    }

    //get List Room From File CSV

    public static ArrayList<Room> getRoomFromCSV() {
        Path path = Paths.get(pathRoom);
        if (!Files.exists(path)) {
            try {
                Writer writer = new FileWriter(pathRoom);
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
        ColumnPositionMappingStrategy<Room> strategy = new ColumnPositionMappingStrategy<>();
        strategy.setType(Room.class);
        strategy.setColumnMapping(headerRecordRoom);

        CsvToBean<Room> csvToBean = null;
        try {
            csvToBean = new CsvToBeanBuilder<Room>(new FileReader(pathRoom))
                    .withMappingStrategy(strategy)
                    .withSeparator(DEFAULT_SEPARATOR)
                    .withQuoteChar(DEFAULT_QUOTE)
                    .withSkipLines(NUM_OF_LINE_SKIP)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
        return (ArrayList<Room>) csvToBean.parse();
    }

    //get List Customer From File CSV

    public static ArrayList<Customer> getCustomerFromCSV() {
        Path path = Paths.get(pathCustomer);
        if (!Files.exists(path)) {
            try {
                Writer writer = new FileWriter(pathCustomer);
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
        ColumnPositionMappingStrategy<Customer> strategy = new ColumnPositionMappingStrategy<>();
        strategy.setType(Customer.class);
        strategy.setColumnMapping(headerRecordCustomer);

        CsvToBean<Customer> csvToBean = null;
        try {
            csvToBean = new CsvToBeanBuilder<Customer>(new FileReader(pathCustomer))
                    .withMappingStrategy(strategy)
                    .withSeparator(DEFAULT_SEPARATOR)
                    .withQuoteChar(DEFAULT_QUOTE)
                    .withSkipLines(NUM_OF_LINE_SKIP)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
        return (ArrayList<Customer>) csvToBean.parse();
    }


    //get List Villa From File CSV By TreeSet

    public static TreeSet<String> getAllNameServiceFromCSV(String path) {
        BufferedReader br = null;
        TreeSet<String> result = new TreeSet();
        try {
            String line;
            br = new BufferedReader(new FileReader(path));

            while ((line = br.readLine()) != null) {
                if(getNameServicesFromFile(line).equals("nameService")){
                    continue;
                }
                result.add(getNameServicesFromFile(line));
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null)
                    br.close();
            } catch (IOException crunchifyException) {
                crunchifyException.printStackTrace();
            }
        }
        return result;
    }

    public static String getNameServicesFromFile(String csvLine) {
        String name = "";
        if (csvLine != null) {
            String[] splitData = csvLine.split(",");
            name = splitData[1];
        }
        return name;
    }
}
