package ndevuzagolidecafe;

import java.util.Scanner;

public class NdevuzagolideCafe {
    Scanner keyboard = new Scanner(System.in);
    Attendants attendant= new Attendants();
    GymMember gymember= new GymMember();
    String cafeteria_name="Ndevuzagolide Cafeteria";
    public  void WelcomeMessage(){
        System.out.println(cafeteria_name);
        System.out.println("----------------------------------------------------------------------------");
        while(true){
           System.out.println("Enter your mobile number starting with 265: ");
           attendant.setPhone(keyboard.next());
           if(attendant.validateAttendant()){
              System.out.println("Welcome "+attendant.getName()+" to "+cafeteria_name);
              gymember.menu();
              break;
            }else{
              System.out.println("Invalid Number!");
             } 
        }
    }
    
    public static void main(String[] args) {
        NdevuzagolideCafe ndevuzagolide= new NdevuzagolideCafe();
        ndevuzagolide.WelcomeMessage();
    }
}
