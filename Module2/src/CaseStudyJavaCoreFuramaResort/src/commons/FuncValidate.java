package commons;

import java.util.Scanner;

public class FuncValidate {
    private static String regex="";
    private static Scanner input;
    public static boolean checkName(String name){
        regex="^[A-Z][\\w]+([\\s][A-Z][\\w]+)*$";

     return name.matches(regex);
    }
    public static boolean checkConveninent(String name){
        regex="^(massage)|(karaoke)|(food)|(drink)|(car)$";
        return name.matches(regex);
    }
    public static boolean checkNumber(String str){
        regex="^[\\d]+$";
        return str.matches(regex);
    }
}
