package ndevuzagolidecafe;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Attendants {
    private String phone;
    private String name;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Attendants{" + "phone=" + phone + ", name=" + name + '}';
    }
    
    public boolean validateAttendant(){
        return phone.length()==12 && phone.substring(0, 3).equals("265") && checkPhone();
    }
    public boolean checkPhone(){
        boolean status=false;
        try( Scanner sc = new Scanner(new File("attendants.csv"))){
            sc.useDelimiter("\n");
            while (sc.hasNext()){
                String[] details=sc.next().split(",");
                if(phone.equals(details[1].replaceAll("\\s+",""))){
                    status=true;
                    this.name=details[0];
                    break;
                }
            } 
            sc.close();
        }catch(FileNotFoundException e){
            System.out.println(e);
        }
        return status;
    }
}
