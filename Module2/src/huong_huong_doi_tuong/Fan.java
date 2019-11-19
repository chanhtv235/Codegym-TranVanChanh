package huong_huong_doi_tuong;

public class Fan {
    public static void main(String[] args) {
    Fan fan1=new Fan();
    fan1.setSpeed(fan1.FAST);
    fan1.setOn(true);
    fan1.setColor("Yellow");
    fan1.setRadius(10);
    Fan fan2 =new Fan();
    fan2.setSpeed(fan2.getMEDIUM());
    fan2.setColor("blue");
    fan2.setRadius(5);
    fan2.setOn(false);
        System.out.println(fan1.toString());
        System.out.println(fan2.toString());
    }
    private final int SLOW=1;
    private final int MEDIUM=2;
    private final int FAST=3;
    private int speed;
    private boolean on;
    private double radius;
    private String color;

    public int getSLOW() {
        return SLOW;
    }

    public int getMEDIUM() {
        return MEDIUM;
    }

    public int getFAST() {
        return FAST;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public boolean isOn() {
        return on;
    }

    public void setOn(boolean on) {
        this.on = on;
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
    public Fan(){
        this.speed=this.SLOW;
        this.on=false;
        this.radius=5;
        this.color="blue";
    }

    @Override
    public String toString() {
        String display;
        if (this.isOn()){
            display="Fan is on {" +
                    "speed=" + speed +
                    ", radius=" + radius +
                    ", color='" + color + '\'' +
                    '}';
        }else {
            display="Fan is off {" +
                    " speed=" + speed +
                    ", radius=" + radius +
                    ", color='" + color + '\'' +
                    '}';
        }
        return display;
    }
}
