package Case_Study.JavaCore.SaveToFile.Commons;

import Case_Study.JavaCore.SaveToFile.CustomException.NameException;

import java.util.Scanner;

public class FuncValidation {
    public static final String EMPTY = "";
    private static String regex = "";
    private static Scanner sc;


    public static boolean isValidNameServices(String str) {
        regex = "^([\\p{Lu}]|([\\p{Lu}][\\p{Ll}]{1,}))([\\s]([\\p{Lu}]|[\\p{Lu}][\\p{Ll}]{1,10})){0,6}$";
        return str.matches(regex);
    }

    public static String getValidName(String strDisplay, String errMes) throws NameException {
        // input gia tri dau vao
        System.out.println(strDisplay);
        String input = ScannerUtils.scanner.nextLine();
        if (!isValidNameServices(input)) {
            throw new NameException(errMes);
//            System.out.println(errMes);
//            getValidName(strDisplay, errMes);
        }
        return input;
    }

    public static double checkValidNumberDouble(String strDisplay, String errMes) {
        double result = 0.0;
        // input gia tri dau vao
        System.out.println(strDisplay);
        try {
            result = ScannerUtils.scanner.nextDouble();
        } catch (Exception e) {
            System.out.println(errMes);
            ScannerUtils.scanner.nextLine();
            checkValidNumberDouble(strDisplay, errMes);
        }
        return result;
    }


    //check Integer
    public static Integer checkValidNumberInteger(String content, String errMes) {
        boolean err = false;
        while (!err) {
            try {
                System.out.println(content);
                err = true;
                return ScannerUtils.scanner.nextInt();
            } catch (Exception ex) {
                err = false;
                System.out.println(errMes);
            }
        }
        return 0;
    }

    //check Email
    public static boolean checkEmail(String str) {
        regex = "^[a-z0-9._-]+@[a-z0-9.-]+\\.[a-z]{2,3}";
        return str.matches(regex);
    }

    //check birthday
    public static boolean checkBirthday(String str) {
        regex = "^([0-2][0-9]|(3)[0-1])(\\/)(((0)[0-9])|((1)[0-2]))(\\/)\\d{4}$";
        return str.matches(regex);
    }
}
