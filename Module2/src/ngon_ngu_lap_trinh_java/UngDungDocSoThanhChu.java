package ngon_ngu_lap_trinh_java;

import java.net.SocketOption;
import java.util.Scanner;

public class UngDungDocSoThanhChu {
    public static void main(String args[]){
        Scanner input =new Scanner(System.in);
        System.out.println("Enter a Number");
        int number= input.nextInt();
        if (number<20){
           switch (number) {
               case 0:
                   System.out.println("Zero");
                   break;
               case 10:
                   System.out.println("ten");
                   break;
               case 11:
                   System.out.println("eleven");
                   break;
               case 12:
                   System.out.println("twele");
                   break;
               case 13:
                   System.out.println("thirteen");
                   break;
               case 14:
                   System.out.println("fourteen");
                   break;
               case 15:
                   System.out.println("Fifteen");
                   break;
               case 16:
                   System.out.println("sixteen");
                   break;
               case 17:
                   System.out.println("seventeen");
                   break;
               case 18:
                   System.out.println("eighteen");
                   break;
               case 19:
                   System.out.println("nineteen");
                   break;
               default:
                   System.out.println(DoVi(number));

           }
        }else if (number<100){
                int doVi=number%10;
                int truc= (int)(Math.floor(number/10));
            System.out.println(truc);
                if (doVi==0){
                    System.out.println(Truc(truc));
                }else {
                    System.out.println(Truc(truc)+"-"+DoVi(doVi));
                }
        }else  {

        }
    }
    public static String DoVi(int i) {
        String string="";
        switch (i) {
            case 1:
                string= "one";
                 break;
            case 2:
                string= "two";
                 break;
            case 3:
                string= "three";
                break;
            case 4:
                string= "four";
                 break;
            case 5:
                string= "five";
                break;
            case 6:
                string= "six";
                break;
            case 7:
                string= "seven";
                break;
            case 8:
                string= "eight";
                break;
            case 9:
                string= "nine";
            break;
        }
        return string;

    }
    public static String Truc(int i) {
        String string="";
        switch (i) {

            case 2:
                string= "Twenty";
                break;
            case 3:
                string= "thirty";
                break;
            case 4:
                string= "fourty";
                break;
            case 5:
                string= "fifty";
                break;
            case 6:
                string= "sixty";
                break;
            case 7:
                string= "seventy";
                break;
            case 8:
                string= "eighty";
                break;
            case 9:
                string= "ninety";
                break;
        }
        return string;
    }
}
