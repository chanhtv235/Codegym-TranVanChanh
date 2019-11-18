package MangVaPhuongThuc;

import java.util.Scanner;

public class TinhTongCacPhanTu1CotCuaMang2Chieu {
    public static void main(String[] args) {
        int[][]array=new int[3][3];
        int row=array.length;
        int col=array[0].length;
        Scanner input=new Scanner(System.in);
        for (int i=0;i<row;i++){
            for (int k=0;k<col;k++){
                System.out.printf("Element array[%d][%d]",i,k);
                array[i][k]=input.nextInt();
            }
        }
        System.out.println("Select colume that you want sum");
        int selectCol=input.nextInt();
        int sum=0;
        for (int i=0;i<row;i++){
            for (int k=0;k<col;k++){
                System.out.print(array[i][k]+"\t");
                if (k==selectCol){
                sum+=array[i][k];
                }
            }
            System.out.println();
        }

        System.out.printf("Sum =%d",sum);
    }
}
