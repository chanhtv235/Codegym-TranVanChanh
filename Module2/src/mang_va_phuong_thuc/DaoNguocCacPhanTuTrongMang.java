package MangVaPhuongThuc;

import java.util.Scanner;

public class DaoNguocCacPhanTuTrongMang {
    public static void main(String[] args) {
        int size=0;

        Scanner input =new Scanner(System.in);
        do {
            System.out.println("Enter size of array");
            size=input.nextInt();
            if (size>10){
                System.out.println("Enter size again. (size <10)");
            }
        }while (size>10);

        int []array=new int[size];
        for (int i=0;i<size;i++){
            System.out.println("Enter element ["+(i+1)+"]");
            array[i]=input.nextInt();
        }
        System.out.println("Array before reverse");
        for (int elment:array){
            System.out.print(elment+"\t");
        }
        for (int i=0;i<size/2;i++){
            int temp=array[i];
            array[i]=array[size-1-i];
            array[size-1-i]=temp;
        }
        System.out.println("\n Array after reverse");
        for (int elment:array) {
            System.out.print(elment + "\t");
        }
    }
}
