package source;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Date;

public class PersonalHistory {
    private HashMap<Date, HashMap<String, Object>> history;
    
    public PersonalHistory(){
        this.history = new HashMap<>();
    }

    public void addNewData(Date date, HashMap<String, Object> info){
        this.history.put(date, info);
    }

    public HashMap<Date, HashMap<String, Object>> getHistory(){
        return this.history;
    }

}
