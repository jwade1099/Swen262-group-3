package Workouts;
import source.User;

public interface WorkoutStrat {
   public int get_duration ();
   public double get_intensity ();
   public String get_time_date ();
   public void add_calories_target (int calories, User user);
}
