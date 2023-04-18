package Goals;

public class GainWeight implements GoalsState {
    private final Goal context;
    int surplus = 500;

    public GainWeight(Goal context) {
        this.context = context;
    }


    @Override
    public void handleSetCalories() {
        double baseCalories = context.setBaseCalories();
        if (context.getCurrentWeight() >= context.getWeightGoal()) {
            context.setState(new MaintainWeight(context));
            context.setCalories();
        }
        context.setTargetCalories(baseCalories + surplus);
    }
}
