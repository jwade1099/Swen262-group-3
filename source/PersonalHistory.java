package source;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
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

    public void printHistory(){
        for(Map.Entry<Date, DailyInfo> element : history.entrySet()){
            Date key = element.getKey();
            DailyInfo val = element.getValue();

            System.out.println("{" + key + " : {" + val.toString() + "}}");
            System.out.println("");
        }
    }

}
