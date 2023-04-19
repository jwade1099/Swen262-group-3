package Workouts;

import java.util.Date;
import java.text.SimpleDateFormat;

public class Workout {
    //private WorkoutStrat start;
    private int duration;
    private double intensity;
    public String time_date;

    public Workout(int duration, double intensity){
        this.duration = duration;
        this.intensity = intensity;
        /*for date */
            Date current_date = new Date();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String currentDateTime = dateFormat.format(current_date);
        /*for date */
        this.time_date = currentDateTime;
    }

    public double getIntensity() {
        return intensity;
    }

    public int getDuration() {
        return duration;
    }

    public String getTime_date() {
        return time_date;
    }

    @Override
    public String toString() {
        return "Workout{" +
                "duration=" + duration +
                ", intensity=" + intensity +
                ", time_date='" + time_date + '\'' +
                '}';
    }
}
