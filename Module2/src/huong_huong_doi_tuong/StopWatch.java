package huong_huong_doi_tuong;


public class StopWatch {
    public static void main(String[] args) {
    StopWatch watch=new StopWatch();
    watch.start();
    int[]arr=new int[100000];
    for (int i=0;i<arr.length;i++){
        for (int k=i+1;k<arr.length;k++)
            if (arr[i]>arr[k]){
                int temp=arr[i];
                arr[i]=arr[k];
                arr[k]=temp;
            }
    }
    watch.stop();
        System.out.println(watch.getElapsedTime());
    }
    private long startTime;
    private long endTime;
    public long getStartTime() {
        return startTime;
    }

    public long getEndTime() {
        return endTime;
    }
    public StopWatch(){
        this.startTime=System.currentTimeMillis();
    }
    public  void start(){
        this.startTime=System.currentTimeMillis();
    }
    public  void stop(){
        this.endTime=System.currentTimeMillis();
    }
    public long getElapsedTime(){
        return this.endTime-this.startTime;
    }
}
