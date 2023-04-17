package Goals;

public class LoseWeight implements GoalsState {
    private final Goal context;
    int deficit = 500;

    public LoseWeight(Goal context) {
        this.context = context;
    }

    @Override
    public void handleSetCalories(double baseCalories) {
        if(context.getCurrentWeight() <= context.getWeightGoal()){
            context.setState(new MaintainWeight(context));
            context.setCalories();
        }
        context.setTargetCalories(baseCalories - deficit);
    }
}
