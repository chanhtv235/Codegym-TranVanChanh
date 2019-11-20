package kethua.circle_cylinder;

public class Cylinders extends Circles {

    private double height;
    public Cylinders() {

   }
    public Cylinders(double radius, String color, double height) {
        super(radius, color);
        this.height = height;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }
    public double getVulome(){
        return getArea()*this.height;
    }
    @Override
    public String toString() {
        return "Cylinders{" +
                "height=" + height +"vulome"+getVulome()+
                '}'+super.toString();
    }
}
