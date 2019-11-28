package giaithuat;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class bai10 {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        System.out.println("thuc hien cong viec cua mot chuoi");
        System.out.println("enter String");
        String  string= input.nextLine();
        //toPrintWord(string);
        //toCountWord(string);
        toCountFrequecyWord(string);
    }
    private static void toPrintWord(String string){
        String[]arr=string.split("[\\s]+");
            for (String word :arr)
            System.out.println(word);
    }
    private static void toCountWord(String string){
        String str=string.trim();
        String[] arr=str.split("[\\s]+");
        int wordNumber=arr.length;
        System.out.println("The Number of word: "+wordNumber);
    }
    private static void toCountFrequecyWord(String string){
        String str=string.trim();
        String[] arr=str.split("[\\s]+");
        System.out.println(Arrays.toString(arr));
        for (int i=0;i<arr.length;i++){
            int count = 1;
            int k;
            for (k=i+1;k<arr.length;k++)
                if (arr[i].equals(arr[k])) {
                    count++;
                }
            System.out.println(arr[i] + " : " + count + " times");
            for (int n=i+1;n<arr.length;n++){
                if (arr[i].equals(arr[n])) {
                    int m;
                    for (m=n; m < arr.length - 1; m++) {
                        arr[m] = arr[m + 1];
                    }
                    arr[m] = null;
                }
            }
        }
    }
}
