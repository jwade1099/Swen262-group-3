package Goals;

import source.User;

public class Goal {
    private GoalsState state;
    private final User user;

    /**
     * user's initial weight.
     */
    private double initialWeight;

    /**
     * user's current weight.
     */
    private double currentWeight;

    /**
     * user's weight goal.
     */
    private double weightGoal;

    /**
     * user's daily target calories before workout and goal change.
     */
    private double baseCalories;

    /**
     * user's daily target calories.
     */
    private double targetCalories;
//    private double workoutCalories;


    public Goal(source.User user, int age, int weightGoal) {
        this.user = user;
        this.initialWeight = user.getWeight();
        this.currentWeight = user.getWeight();
        this.weightGoal = weightGoal;

        setBaseCalories(age);
        setCalories();
    }


    /**
     * Set the user's current weight as the {@link #currentWeight} and {@link #initialWeight}, and the
     *
     * @param state to set as new {@link #state}.
     */
    public void setState(GoalsState state) {
        this.state = state;
        this.initialWeight = user.getWeight();
        this.currentWeight = user.getWeight();
    }


    /**
     * Set the {@link #targetCalories} based on the current state.
     */
    public void setCalories() {
        state.handleSetCalories(baseCalories);
    }


    /**
     * @param targetCalories to set as the new {@link #targetCalories}.
     */
    public void setTargetCalories(double targetCalories) {
        this.targetCalories = targetCalories;
    }


    /**
     * @param age used to determine the {@link #baseCalories}.
     */
    public void setBaseCalories(int age) {
        this.baseCalories = (9.99 * currentWeight) + (6.25 * user.getHeight()) - (4.92 * age) - 83;
    }


    /**
     * @param weightGoal to set as the new {@link #weightGoal}.
     */
    public void setWeightGoal(double weightGoal) {
        this.weightGoal = weightGoal;
    }


    /**
     * @param currentWeight to set as the new {@link #currentWeight}.
     */
    public void setCurrentWeight(double currentWeight) {
        this.currentWeight = currentWeight;
    }


    /**
     * @return the current {@link #weightGoal}.
     */
    public double getWeightGoal() {
        return weightGoal;
    }


    /**
     * @return the current {@link #targetCalories}.
     */
    public double getTargetCalories() {
        return targetCalories;
    }


    /**
     * @return the user's {@link #currentWeight}
     */
    public double getCurrentWeight() {
        return this.currentWeight;
    }


    /**
     * @return the difference between the {@link #currentWeight} and the {@link #initialWeight}.
     */
    public double getWeightDifference() {
        return currentWeight - initialWeight;
    }
}