package kethua.he_cac_doi_tuong_hinh_hoc;

public class Square extends Rectangle {

    public Square(){
    }
    public Square(double side){
        super(side,side);
    }
    public Square(String color,boolean filled,double side){
        super(color,filled,side,side);
    }
    public void setSide(double side){
        setWidth(side);
        setHeight(side);
    }
   public double getSide(){
        return getWidth();
   }
   @Override
   public void setWidth(double width){
        setSide(width);
   }
   @Override
   public void setHeight(double heihgt) {
       setSide(heihgt);
   }
    @Override
    public String toString() {
        return "A Square with side="
                + getSide()
                + ", which is a subclass of "
                + super.toString();
    }
}
