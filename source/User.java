package source;

import Goals.Goal;

import java.util.Calendar;
import java.util.Date;

public class User {

    private String name;
    private int height; // inches
    private int weight; //pounds
    private String birthday; // mm/dd/yyyy
    private int age;


    public User(String name, int height, int weight, String birthday) {
        this.name = name;
        this.height = height;
        this.weight = weight;
        this.birthday = birthday;

    }

    private int calculateAge() {
        // String[] elements = birthday.split("/");

        // int day = Integer.parseInt(elements[0]);

        // Date current = new java.util.Date();

        // Calendar cal = new Calendar();


        // current.compareTo(current)


        return 1;

    }

    public int getWeight(){
        return this.weight;
    }

    public static void main(String[] args) {
        
    }


}