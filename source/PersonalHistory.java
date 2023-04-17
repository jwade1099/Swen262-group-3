package source;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Date;

public class PersonalHistory {
    private HashMap<Date, DailyInfo> history;
    
    public PersonalHistory(){
        this.history = new HashMap<>();
    }

    public void addNewData(Date date, DailyInfo info){
        this.history.put(date, info);
    }

    public HashMap<Date, DailyInfo> getHistory(){
        return this.history;
    }

}
