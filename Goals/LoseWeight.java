package Goals;

public class LoseWeight implements GoalsState {
    private Goal context;

    public LoseWeight(Goal context) {
        this.context = context;
    }

    @Override
    public void handleSetCalories() {

    }
}
