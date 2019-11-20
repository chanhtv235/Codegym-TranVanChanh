package kethua.trien_khai_triagle;

public class Shapes {
    private String color="green";
    private boolean filled=true;;

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isFilled() {
        return filled;
    }

    public void setFilled(boolean filled) {
        this.filled = filled;
    }

    public Shapes(){

    }

    public Shapes(String color, boolean filled) {
        this.color = color;
        this.filled = filled;
    }
    @Override
    public String toString(){
        return "A Shape with color of "+ this.getColor() +" and " + (this.isFilled()?" filled ":" notfilled ");
    }
}
