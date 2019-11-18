package MangVaPhuongThuc;

public class TimPhanTuLonNhatTrongMang2Chieu {
    public static void main(String[] args) {
        int[][]array={{11,120,13,14},{21,22,23,24},{31,32,33,34}};
        int row=array.length;
        int col=array[0].length;
        int max=array[0][0];
        int rowIndex=0;
        int colIndex=0;
        for (int i=0;i<row;i++){
            for (int k=0;k<col;k++){
                if (max<array[i][k]){
                    max=array[i][k];
                    rowIndex=i;
                    colIndex=k;
                }
            }
        }
        System.out.printf("Max =%d and position array[%d][%d]",max,rowIndex,colIndex);
    }
}
