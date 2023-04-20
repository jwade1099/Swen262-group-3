package Goals;

public class MaintainWeight implements GoalsState {
    private final Goal context;

    public MaintainWeight(Goal context) {
        this.context = context;
    }

    @Override
    public void handleSetCalories() {
        double baseCalories = context.setBaseCalories();
        double weightDifference = context.getWeightDifference();
        if (weightDifference <= -2.27) {
            context.setState(new LoseWeight(context));
            context.setCalories();
            return;
        } else if (weightDifference >= 2.27) {
            context.setState(new GainWeight(context));
            context.setCalories();
            return;
        }
        context.setTargetCalories(baseCalories);
    }

    @Override
    public String toString() {
        return "maintain weight around " + (int) context.getWeightGoal();
    }
}
