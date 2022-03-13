package ndevuzagolidecafe;

import java.util.Date;
import java.util.Scanner;

public class GymMember {
    private String name;
    private String gym_number;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGym_number() {
        return gym_number;
    }

    public void setGym_number(String gym_number) {
        this.gym_number = gym_number;
    }
    
    public void menu(){
        while(true){
         System.out.println("What do you want to do?");
         String[] menuList={"Add new gym members","Delete gym member","Issue meal cards","Print report","Logout"};
         
         for(int k=0; k<menuList.length; k++){
             System.out.println((k+1)+". "+menuList[k]);
         }
        Scanner keyboard = new Scanner(System.in);
        System.out.println();
        System.out.print("Choice: ");
        int input=keyboard.nextInt();
         switch(input){
             case 1:
                 addGymMember();
                 break;
             case 2:
                 break;
                 
             case 3:
                 issueMealCard();
                 break;
                 
             case 4:
                 printReport();
                 break;
             case 5:
                 logOut();
                 break;
                 
             default:
                 System.out.println("Enter valid action number");
                 System.out.println();
                 break;
         }
        }
    }
    
    public void logOut(){
        System.out.println("Bye! Bye!");
        System.exit(0);
    }
    
    public void printReport(){
        MealCard mealcard=new MealCard();
        mealcard.setDate(new Date());
        FileOperatiions.printeReport("meal_cards.csv","meal-card-report-"+mealcard.getDate()+".csv", mealcard.getDate());
        System.out.println("The report has been exported to csv.");
        System.out.println();
    }
    public void addGymMember(){
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Enter name: ");
        this.setName(keyboard.nextLine());
        System.out.println("Enter gym number: ");
         while(true){
            String gym_no=keyboard.next();
             if(!FileOperatiions.checkIfExists(1, gym_no, "gym_members.csv") && gym_no.length()==6){
                  this.setGym_number(gym_no);
                  break;
              }else{
                  System.out.println("Enter A Valid Membership Number");
              }
        }
        String dataToWrite=this.getName()+","+this.getGym_number();
        FileOperatiions fileoperation= new FileOperatiions("gym_members.csv",dataToWrite);
        if(fileoperation.appendToFiles()){
           System.out.println("You have successfully added "+this.getName()+" with gym number\n" +
           this.getGym_number()+".");
        }
    }
    
    public void issueMealCard(){
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Enter gym number: ");
        MealCard mealcard=new MealCard();
         while(true){
            String gym_no=keyboard.next();
            mealcard.setDate(new Date());
             if(!FileOperatiions.checkIfExistsWith2Variables(0, gym_no, "meal_cards.csv",1, mealcard.getDate())){
                  mealcard.setGym_number(gym_no);
                  break;
              }else{
                  String name=FileOperatiions.returnMatch(1, gym_no, "gym_members.csv")[0];
                  System.out.println("Denied! "+name+" has already been issued a free meal card");
              }
        }
        mealcard.print();
    }
    @Override
    public String toString() {
        return "GymMember{" + "name=" + name + ", gym_number=" + gym_number + '}';
    }
}
