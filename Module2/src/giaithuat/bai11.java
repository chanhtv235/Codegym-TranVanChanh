package giaithuat;

import java.util.Arrays;
import java.util.Scanner;

public class bai11 {
    public static void main(String[] args) {
        Scanner input =new Scanner(System.in);
        int n;
        do {
            System.out.println("Enter size of Array");
            n =input.nextInt();
        }while (n<=0);
        int []arr=new int[n];
        System.out.println("Enter elements of Array");
        for (int i=0;i<arr.length;i++) {
            System.out.println("Enter element "+i);
            arr[i]=input.nextInt();
        }
        toDisplay(arr);
//        System.out.println("Total of the positive odd number: "+toSumPositiveOddNumber(arr));
//        System.out.println("Enter number to check:");
//        int k=input.nextInt();
//        toFindElementOFArray(arr,k);
        Arrays.sort(arr);
        System.out.println("Array after sort: "+Arrays.toString(arr));
        System.out.println("Enter element want to insert:");
        int elment =input.nextInt();
        int []afterArr=insertElement(arr,elment);
        System.out.println("Array after Insert:"+Arrays.toString(afterArr));

    }
    public static void toDisplay(int[] array){
        System.out.println("Array : "+Arrays.toString(array));
    }
    public static int toSumPositiveOddNumber(int []array){
        int sum=0;
       for (int i=0;i<array.length;i++){
           if (array[i]>0){
               sum+=array[i];
           }
       }
        return sum;
    }
    public static void toFindElementOFArray(int[]array,int k){
        int count=0;
        for (int i=0;i<array.length;i++){
            if (array[i]==k){
                count++;
                break;
            }
        }
        if (count > 0) {
            System.out.println(k+ " has in the Array.\n The first element of Array is: "+array[0]);
        }else {
            System.out.println(" The number that you choose not in the Array");
        }

    }
    public static int[] sortUP(int []array){
        Arrays.sort(array);
        return array;
    }
    public static int[] insertElement(int[]array, int elmentInsert){
        // Chèn phần tử p vào mảng a sao cho mảng a vẫn đảm bảo tăng dần và xuất lại mảng a.
        int indexInsert;
        for (int i=0;i<array.length;i++){
            if (array[i]==elmentInsert){
                indexInsert=i;
                for (int k=array.length-1;k>indexInsert;k--){
                    array[k]=array[k-1];
                }
                array[i]=elmentInsert;
                break;
            }

        }
        return array ;
    }
}
