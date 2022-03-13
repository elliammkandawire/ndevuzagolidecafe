package ndevuzagolidecafe;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MealCard {
    private String gym_number;
    private String date;
    public String getGym_number() {
        return gym_number;
    }

    public void setGym_number(String gym_number) {
        this.gym_number = gym_number;
    }

    public String getDate() {
        return date;
    }

    public void setDate(Date date) {
        String pattern = "yyyy-MM-dd";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        this.date=simpleDateFormat.format(date);
    }
    
    public void print(){
        String dataToWrite=this.gym_number+","+this.date;
        FileOperatiions fileoperation= new FileOperatiions("meal_cards.csv",dataToWrite);
        if(fileoperation.appendToFiles()){
           System.out.println("Take out the meal card on the printer");
           System.out.println();
        }
    }
}
