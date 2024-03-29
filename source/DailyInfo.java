package source;

import Workouts.Workout;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class DailyInfo {
    private HashMap<String, Object> dailyInfo;
    private int weight;

    public DailyInfo(int weight){
        this.dailyInfo = new HashMap<>();
        this.weight = weight;
        this.dailyInfo.put("Weight", weight);
        this.dailyInfo.put("Calories Consumed", 0);
        this.dailyInfo.put("Target Calories", 0);
        this.dailyInfo.put("Meals", new ArrayList<Object>());
        this.dailyInfo.put("Workouts", new ArrayList<Object>());
    }

    public HashMap<String, Object> getDailyInfo(){
        return this.dailyInfo;
    }

    public void reset(int weight){
        this.dailyInfo = new HashMap<>();
        this.dailyInfo.put("Weight", weight);
        this.dailyInfo.put("Calories Consumed", 0);
        this.dailyInfo.put("Target Calories", 0);
        this.dailyInfo.put("Meals", new ArrayList<Object>());
        this.dailyInfo.put("Workouts", new ArrayList<Workout>());
    }

    public int getTargetCalories(){
        return (int)dailyInfo.get("Target Calories");
    }

    public void getWorkoutHistory(){
        ArrayList<Workout> workouts = (ArrayList<Workout>)this.dailyInfo.get("Workouts");
        for(int i = 0; i < workouts.size(); i++){
            System.out.println(workouts.get(i).toString());
        }
    }

    public void setWeight(Double weight){
        this.dailyInfo.put("Weight", weight);
    }

    public void addCalories(double calories){
        int prevCal = (int) dailyInfo.get("Calories Consumed");
        this.dailyInfo.put("Calories Consumed", prevCal + calories);
    }

    public void setTarget(int target){
        this.dailyInfo.put("Target Calories", target);
    }

    public void addMeal(String meal){
        ArrayList<Object> meals = (ArrayList<Object>) this.dailyInfo.get("Meals");
        meals.add(meal);
        this.dailyInfo.put("Meals", meals);
    }

    public void addWorkout(Object workout){
        if(this.dailyInfo.get("Workouts") instanceof ArrayList){
            ArrayList<Object> workouts = (ArrayList<Object>)this.dailyInfo.get("Workouts");
            workouts.add(workout);
            this.dailyInfo.put("Workouts", workouts);
        }
    }

    public String toString(){
        String s = "";
        for(Map.Entry<String, Object> mapElement : dailyInfo.entrySet()){
            String key = mapElement.getKey();
            String val = mapElement.getValue().toString();
            if(!key.equals("Weight")){
                s = s + (key + " : " + val + ", ");
            }
            else{
                s = s + (key + " : " + val);
            }
        }

        return s;
    }

}
