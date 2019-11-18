package MangVaPhuongThuc;

import java.util.Scanner;

public class GopMang {
    public static void main(String[] args) {
        int []array1=new int[3];
        int []array2=new int[3];
        Scanner input=new Scanner(System.in);
        for (int i=0;i<array1.length;i++){
            System.out.printf("Enter array1[%d]",i);
            array1[i]=input.nextInt();
        }
        for (int i=0;i<array2.length;i++){
            System.out.printf("Enter array2[%d]",i);
            array2[i]=input.nextInt();
        }
        int []array3=new int[array1.length+array2.length];
        for (int i=0;i<array1.length;i++){
            array3[i]=array1[i];
        }
        for (int elemet:array3){
            System.out.print(elemet+"\t");
        }
        for (int k=0;k<array2.length;k++){
            array3[array1.length+k]=array2[k];
        }
        System.out.println("Array after combine");
        for (int elemet:array3){
            System.out.print(elemet+"\t");
        }
    }
}
