package one;

public abstract class WeightedExercise extends Exercise{

    private int weight;

    public WeightedExercise(String name, int weight) {
        super(name);
        this.weight = weight;
    }

    @Override
    public boolean requiresWeight(){
        return true;
    }

    public int getWeight() {
        return weight;
    }
}
