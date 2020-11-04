package food;

import travel.Item;
import travel.ItemType;

public class Drinks extends Food {
    private double volume;
    public enum Type implements ItemType {
        MILK, TEA, COFFEE, CAPPUCCINO, WATER
    }

    public Drinks(Type type, double weight, double calories, double volume) {
        super(weight, calories);
        name = type.toString();
        this.volume = volume;
    }

    @Override
    public void eat(double weightToEat) {
        weight = weight - weightToEat;
    }

    @Override
    public String toString() {
        return "Drink: " + name + "," + weight + "," + calories + "," + volume + ".";
    }

//    public String toStringForFile() {
//        return getClass().getName() + ";" + name + ";" + weight + ";" + calories + ";" + volume + "\n";
//    }

    @Override
    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (object == null || object.getClass() != this.getClass()) {
            return false;
        }

        Drinks drink = (Drinks) object;
        if (drink.name.equals(name) && drink.weight == weight && drink.calories == calories) {
            return  true;
        }
        return false;
    }

    @Override
    public void sumItem(Item item) {
        Drinks drinks = (Drinks)item;
        this.weight += drinks.weight;
        this.calories += drinks.calories;
    }
}
