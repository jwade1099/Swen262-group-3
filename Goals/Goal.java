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
     * user's weight goal.
     */
    private double weightGoal;

    /**
     * user's daily target calories.
     */
    private double targetCalories;
//    private double workoutCalories;


    public Goal(source.User user, int weightGoal) {
        this.user = user;
        this.initialWeight = user.getWeight();
        this.weightGoal = weightGoal;
        this.state = new MaintainWeight(this);

        setBaseCalories();
        setCalories();
    }


    /**
     * Set the user's current weight as the {@link #initialWeight}, and the
     *
     * @param state to set as new {@link #state}.
     */
    public void setState(GoalsState state) {
        this.state = state;
        this.initialWeight = user.getWeight();
    }


    /**
     * Set the {@link #targetCalories} based on the current state.
     */
    public void setCalories() {
        state.handleSetCalories();
    }


    /**
     * @param targetCalories to set as the new {@link #targetCalories}.
     */
    public void setTargetCalories(double targetCalories) {
        this.targetCalories = targetCalories;
    }


    /**
     * Set the base calories a person has to eat daily based on their weight height and age
     */
    public double setBaseCalories() {
        return (9.99 * user.getWeight()) + (6.25 * user.getHeight()) - (4.92 * user.getAge()) - 83;
    }


    /**
     * @param weightGoal to set as the new {@link #weightGoal}.
     */
    public void setWeightGoal(double weightGoal) {
        this.weightGoal = weightGoal;
    }

    /**
     * @return the user's current weight
     */
    public double getCurrentWeight() {
        return user.getWeight();
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
     * @return the difference between the user's current weight and the {@link #initialWeight}.
     */
    public double getWeightDifference() {
        return user.getWeight() - initialWeight;
    }
}