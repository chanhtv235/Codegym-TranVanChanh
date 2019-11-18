package MangVaPhuongThuc;

import java.util.Scanner;

public class XoaPhanTuTrongMang {
    public static void main(String[] args) {
        int[]array=new int[10];
        int delElement=0;
        int delIndex=0;
        Scanner input = new Scanner(System.in);
        for (int i=0;i<array.length/2;i++){
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
        for (int i=delIndex;i<=array.length-2;i++){
               array[i]=array[i+1];
        }
        // Display
        System.out.println("\nArray after inserting new element");
        for (int element:array){
            System.out.print(element+"\t");
        }
    }
}
