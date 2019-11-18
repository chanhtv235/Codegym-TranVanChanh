package MangVaPhuongThuc;

import java.util.Scanner;

public class ThemPhanTuVaoMang {
    public static void main(String[] args) {
        int[]array=new int[10];
        int insertElement;
        int insertIndex;
        Scanner input = new Scanner(System.in);
        for (int i=0;i<array.length/2;i++){
            System.out.println("Enter element"+i);
            array[i]=input.nextInt();
        }
        for (int element:array){
            System.out.print(element+"\t");
        }
        System.out.println("\nEnter new Element want to insert");
        insertElement=input.nextInt();
        System.out.println("Enter Position  want to insert");
        insertIndex=input.nextInt();
        //Insert new element
        if (insertIndex<0|insertIndex>array.length-1){
            System.out.println("Can not inssert element in array.");
        }else if(array[array.length-1]!=0){
            System.out.println("Can not inssert element in array.Because Array is full");
        }
        else {
            for (int i=array.length-1;i>=insertIndex;i--){
               array[i]=array[i-1];
            }
            array[insertIndex]=insertElement;
        }
        // Display
        System.out.println("\nArray after inserting new element");
        for (int element:array){
            System.out.print(element+"\t");
        }
    }
}
