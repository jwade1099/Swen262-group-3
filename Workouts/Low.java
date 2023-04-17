package Workouts;

public class Low implements WorkoutStrat{
    private int duration;
    private double intensity;
    public String time_date;

    @Override
    public int get_duration() {
        return duration;
    }

    @Override
    public double get_intensity() {
        return intensity;
    }


    @Override
    public String get_time_date() {
        return time_date;
    }

    @Override
    public void add_calories_target(int calories) {
        // source.User.add_calories_target(calories);

    }
    
}