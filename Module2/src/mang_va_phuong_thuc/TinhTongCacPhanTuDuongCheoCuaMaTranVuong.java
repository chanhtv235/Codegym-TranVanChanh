package MangVaPhuongThuc;

public class TinhTongCacPhanTuDuongCheoCuaMaTranVuong {
    public static void main(String[] args) {
        int[][]array={  {11,12,13,14},
                        {21,22,23,24},
                        {31,32,33,34},
                        {31,32,33,34}};
        int row=array.length;
        int col=array[0].length;
        int sum=0;
        for (int i=0;i<row;i++){
            for (int k=0;k<col;k++){
                System.out.print(array[i][k]+"\t");
                if (i==k){
                sum+=array[i][k];
                }
            }
            System.out.println();
        }

        System.out.printf("Sum =%d",sum);
    }
}
