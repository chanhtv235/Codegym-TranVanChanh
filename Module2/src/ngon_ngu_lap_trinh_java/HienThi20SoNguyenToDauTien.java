package ngon_ngu_lap_trinh_java;

public class HienThi20SoNguyenToDauTien {
    public static void main(String[] args) {
       int Number=2;
       int count=0;
       while (count<20){
           boolean check=true;
           for (int j=2;j<=Math.sqrt(Number);j++){
               if(Number%j ==0){
                  check=false;
                  break;
               }
           }
           if(check){
               System.out.print(Number+",");
               count++;
           }
           Number++;
        }

    }
}
