package source;

import Goals.Goal;

import java.time.LocalDate;
import java.time.Period;

public class User {

    private String name;
    private int height; // inches
    private int weight; //pounds
    private String birthday; // YYYY-MM-DD
    private int age;


    public User(String name, int height, int weight, String birthday) {
        this.name = name;
        this.height = height;
        this.weight = weight;
        this.birthday = birthday;
        this.age = calculateAge(birthday);

    }

    private int calculateAge(String birthday) {
        LocalDate dob = LocalDate.parse(birthday);
        age = calculation(dob);
        return age;
    }

    private int calculation(LocalDate dob){
        int years = 0;
        LocalDate curr = LocalDate.now();
        if ((dob != null) && (curr != null)){
            years = Period.between(dob, curr).getYears();
        }

        return years;
    }

    public int getWeight(){
        return this.weight;
    }

    public String getName(){
        return this.name;
    }

    public int getHeight(){
        return this.height;
    }

    public String getBirthday(){
        return this.birthday;
    }

    public void setWeight(int weight){
        this.weight = weight;
    }

    public void setHeight(int height){
        this.height = height;
    }

    public void setName(String name){
        this.name = name;
    }

    public int getAge(){
        return this.age;
    }

    public static void main(String[] args) {
        User o = new User("Vandoran", 170, 100, "2003-03-27");
        System.out.println(o.getAge());
        
    }


}