package Goals;

public class GainWeight implements GoalsState {
    private Goal context;
    // Todo find formula for determining target calories from current weight and weight goal.
    int calories = 100;

    public GainWeight(Goal context) {
        this.context = context;
    }

    @Override
    public void handleSetCalories() {
        context.targetCalories = calories;
    }
}
