package huong_huong_doi_tuong;

import java.util.Scanner;

public class Account {
    public static void main(String[] args) {
        System.out.println("Giai Phuong Trinh Bac 2");
        Account phuongTrinh1 =new Account();
        Scanner input =new Scanner(System.in);
        System.out.println("Nhap a");
        phuongTrinh1.setA(input.nextInt());
        System.out.println("Nhap b");
        phuongTrinh1.setB(input.nextInt());
        System.out.println("Nhap c");
        phuongTrinh1.setC(input.nextInt());
        double x1;
        double x2;
      if (phuongTrinh1.getDelta()==0){
          System.out.println("Phuong trinh co nghiem kep x1=x2="+phuongTrinh1.getRoot1());
      }else if (phuongTrinh1.getDelta()>0){
          System.out.printf("Phuong trinh co 2 nghiem x1=%f va x2 =%f", phuongTrinh1.getRoot1(),phuongTrinh1.getRoot2());
      }else {
          System.out.println("Phuong trinh vo nghiem");
      }
    }
    private int a;
    private int b;
    private int c;
    public Account(){

    }
    public void setA(int a){
        this.a=a;
    }
    public int getA(){
        return this.a;
    }
    public void setB(int b){
        this.b=b;
    }
    public int getB(){
        return this.b;
    }
    public void setC(int c){
        this.c=c;
    }
    public int getC(){
        return this.c;
    }
    public double getDelta(){
        return Math.pow(this.b,2)-4*this.a*this.c;
    }
    public double getRoot1(){
        return (-this.b+Math.pow(this.getDelta(),0.5))/(2*this.a);
    }
    public double getRoot2(){
        return (-this.b-Math.pow(this.getDelta(),0.5))/(2*this.a);
    }
}
