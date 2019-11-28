package interface_sbstract.animals_edible;

public class Chicken extends Animal implements Edible  {
    @Override
    public String makeSound() {
        return "checken O O O";
    }

  //  @Override
    public String howToEat() {
        return "could be fried";
    }
}
