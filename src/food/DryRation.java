package food;

import travel.Item;
import travel.Typeable;

public class DryRation extends Food{
    public enum Type implements Typeable {
        BREAD, ORANGE
    }

    public DryRation(Type type, double weight, double calories) {
        super(weight, calories);
        name = type.toString();
    }

    @Override
    public void eat(double weightToEat) {
        weight = weight - weightToEat;
    }

    @Override
    public String toString() {
        return "Dry ration: " + name + "," + weight + "," + calories + ".";
    }

    @Override
    public boolean equals(Object object) { // override equals
        if (object == this) {
            return true;
        }
        if (object == null || object.getClass() != this.getClass()) {
            return false;
        }

        DryRation dryRation = (DryRation) object;
        if (dryRation.name.equals(name) && dryRation.weight == weight && dryRation.calories == calories) {
            return  true;
        }
        return false;
    }

    @Override
    public void sumItem(Item item) {
        DryRation dryRation = (DryRation) item;
        this.weight += dryRation.weight;
        this.calories += dryRation.calories;
    }


}
