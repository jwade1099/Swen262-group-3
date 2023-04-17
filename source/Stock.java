package source;

import java.util.HashMap;

public class Stock {
    private HashMap<String, Integer> stock;
    private ShoppingList list;
    private User user;

    public Stock(ShoppingList list, User user){
        this.stock = new HashMap<>();
        this.list = list;
        this.user = user;
    }

    public HashMap<String, Integer> getStock(){
        return this.stock;
    }

    public void addToStock(String food, int num){
        if(this.stock.containsKey(food)){
            this.stock.put(food, stock.get(food) + num);
        }else{
            this.stock.put(food, num);
        }
    }

    public void remove(String food, int num){
        this.stock.put(food, stock.get(food)-num);
    }

    public void addToList(String food){
        if(this.stock.get(food) < 5){
            this.list.add(food);
        }
    }
}
