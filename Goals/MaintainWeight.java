package Goals;

public class MaintainWeight implements GoalsState {
    private Goal context;

    public MaintainWeight(Goal context) {
        this.context = context;
    }

    @Override
    public void handleSetCalories() {

    }
}
