package kethua.circle_cylinder;

public class Circles {
    private double radius;
    private String color;

    public Circles(){

    }
    public Circles(double radius, String color) {
        this.radius = radius;
        this.color = color;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
    public double getArea(){
        return this.radius*this.radius*Math.PI;
    }
    @Override
    public String toString() {
        return "Circles{" +
                "radius=" + radius +
                ", color='" + color + '\'' +
                '}';
    }


}
