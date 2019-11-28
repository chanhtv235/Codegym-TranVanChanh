package interface_sbstract.animals_edible;

public class AbstractAndInterfaceTests {
    public static void main(String[] args) {
        Animal[]animals=new Animal[2];
        animals[0]=new Tiger();
        animals[1]=new Chicken();
       for (Animal animal:animals){
            System.out.println(animal.makeSound());
            if (animal instanceof Chicken){
                Edible edibler = (Chicken) animal;
               // Edible edible=new Chicken();
                System.out.println(edibler.howToEat());
            }
        }
       Fruit[]fruits=new Fruit[2];
       fruits[0]=new Apple();
       fruits[1]=new Orange();
       for (Fruit fruit:fruits){
           System.out.println(fruit.howToEat());
       }
    }
}
