package source;

import java.util.ArrayList;

public class Teams {
    private ArrayList<User> members;

    public Teams(){
        this.members = new ArrayList<>();
    }

    public void addMember(User user){
        this.members.add(user);
    }

    public void removeUser(User user){
        int index = members.indexOf(user);
        members.remove(index);
    }

    public ArrayList<User> getUsers(){
        return this.members;
    }
}
