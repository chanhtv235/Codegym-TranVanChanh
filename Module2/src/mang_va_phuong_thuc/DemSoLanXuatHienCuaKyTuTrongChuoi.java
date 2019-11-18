package MangVaPhuongThuc;

import java.util.Scanner;

public class DemSoLanXuatHienCuaKyTuTrongChuoi {
    public static void main(String[] args) {
        int count=0;
        Scanner input=new Scanner(System.in);
        System.out.println("Enter a String");
        String str=input.nextLine();
        System.out.println("Enter a Char that want check");
        char letter=input.next().charAt(0);
        for (int i=0;i<str.length();i++){
           if (letter==str.charAt(i)){
                count++;
           }
        }
        System.out.println("Char ("+letter+") has "+count+" position ");
    }
}
