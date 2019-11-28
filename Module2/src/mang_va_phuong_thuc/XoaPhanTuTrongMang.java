package mang_va_phuong_thuc;

import java.util.Scanner;

public class XoaPhanTuTrongMang {
    public static void main(String[] args) {
        int[]array=new int[5];
        int delElement=0;
        int delIndex=0;
        Scanner input = new Scanner(System.in);
        for (int i=0;i<array.length;i++){
            System.out.println("Enter element"+i);
            array[i]=input.nextInt();
        }
        for (int element:array){
            System.out.print(element+"\t");
        }
        System.out.println("\nEnter new Element want to del");
        delElement=input.nextInt();
        //Delete element
        for (int i=0;i<array.length;i++){
            if (array[i]==delElement){
                delIndex=i;
            }
        }
        System.out.println(delIndex);
        int i;
        for (i=delIndex;i<array.length-1;i++){
               array[i]=array[i+1];
        }
        array[i]=0;
        // Display
        System.out.println("\nArray after delete element"+delElement);
        for (int element:array){
            System.out.print(element+"\t");
        }
    }
}
