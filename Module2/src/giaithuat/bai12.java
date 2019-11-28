package giaithuat;

import java.util.Arrays;
import java.util.Scanner;

public class bai12 {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        int row;
        int col;
        do {
            System.out.println("Enter row");
            row=input.nextInt();
        }while (row<=0);
        do {
            System.out.println("Enter colum:");
            col=input.nextInt();
        }while (col<=0);
        int [][]array=new int[row][col];
        for (int i=0;i<row;i++){
            for (int k=0;k<col;k++){
                System.out.println("enter element ["+i+"]["+k+"]");
                array[i][k]=input.nextInt();
            }
        }
        displayArray2(array);
        System.out.println("Tich cua cac so la boi cua 3 hang dau tien  la: "+multiple(array));
       int[]array1=mang1Chieu(array);
        System.out.println("Mang 1 chiều tạo ra từ các phần tử lớn nhất của hàng trong mảng 2 chiều"+Arrays.toString(array1));
        System.out.println("Xóa đi phần tử đầu tiên của mảng 1 chiều"+Arrays.toString(deletFirstElementOfArray(array1)));

    }
    public static void displayArray2(int [][]array){
        StringBuilder str= new StringBuilder();
        for (int i=0;i<array.length;i++) {
            for (int k = 0; k < array[0].length; k++) {
                str.append(array[i][k]).append("\t");
            }
            str.append("\n");
        }
        System.out.println(str);
    }
    public static int multiple(int [][]array) {
        //b.	Tính tích các số là bội số của 3 nằm trên dòng đầu tiên của ma trận a.
        int multi=1;
        for (int k = 0; k < array[0].length; k++) {
            if (array[0][k] % 3 == 0) {
                multi*=array[0][k];
            }
        }
        return multi;
    }
    public static int[] mang1Chieu(int[][]array){
        //c.	Tạo ra mảng một chiều X[i] với X[i] là các giá trị lớn nhất trên dòng i của ma trận a
        int []arrayTemp=new int[array.length];

        for (int i=0;i<array.length;i++) {
            int max=array[i][0];
            for (int k = 1; k < array[0].length; k++) {
               if (max<array[i][k]){
                   max=array[i][k];
               }
            }
            arrayTemp[i]=max;
        }
        return arrayTemp;
    }
    public static int[] deletFirstElementOfArray(int []array){
        //d.	Xoá đi phần tử đầu tiên của mảng X[i], xuất lại mảng X[i].
        for (int i=0;i<array.length-1;i++){
            array[i]=array[i+1];
        }
        array[array.length-1]=0;
        return array;
    }

}
