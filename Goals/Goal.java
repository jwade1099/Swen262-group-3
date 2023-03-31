package Goals;

public class Goal {
    private GoalsState state;
    private int initialWeight;
    private int weightGoal;
    public int targetCalories;

    public Goal(source.User user, int weightGoal, GoalsState state) {
        this.state = state;
        this.initialWeight = user.getWeight();
        this.weightGoal = weightGoal;
    }

    public void setTargetCalories(int targetCalories) {
        state.handleSetCalories();
    }

    public void setState(GoalsState state){
        this.state = state;
    }
}