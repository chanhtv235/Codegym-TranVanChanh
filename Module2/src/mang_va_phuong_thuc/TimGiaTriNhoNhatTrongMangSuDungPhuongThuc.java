package MangVaPhuongThuc;

public class TimGiaTriNhoNhatTrongMangSuDungPhuongThuc {
    public static void main(String[] args) {
        int []arr={89,13,25,26,11,22,56,78};
        for (int element:arr){
            System.out.print(element+"\t");
        }
        System.out.println("\nMin of array:"+min(arr));
    }
    public static int min(int[]array){
        int min=array[0];
        for (int i=0;i<array.length;i++){
            if (min>array[i]){
                min=array[i];
            }
        }
        return min;
    }

}
