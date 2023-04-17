package source;

import java.util.ArrayList;

public class ShoppingList {
    private ArrayList<String> shoppingList;
    private User owner;

    public ShoppingList(User owner){
        this.shoppingList = new ArrayList<>();
        this.owner = owner;
    }

    public ArrayList<String> getShoppingList(){
        return this.shoppingList;
    }

    public User getOwner(){
        return this.owner;
    }

    public void add(String s){
        this.shoppingList.add(s);
    }

    public void remove(String s){
        this.shoppingList.remove(s);
    }
}
