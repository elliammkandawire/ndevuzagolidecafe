package ndevuzagolidecafe;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileOperatiions {
    private String fileLocation;
    private String dataToWrite;

    public FileOperatiions(String fileLocation, String dataToWrite) {
        this.fileLocation = fileLocation;
        this.dataToWrite = dataToWrite;
    }
    
    public String getFileLocation() {
        return fileLocation;
    }

    public void setFileLocation(String fileLocation) {
        this.fileLocation = fileLocation;
    }

    public String getDataToWrite() {
        return dataToWrite;
    }

    public void setDataToWrite(String dataToWrite) {
        this.dataToWrite = dataToWrite;
    }
    public static void printeReport(String fileLocation,String outputFileName, String date){
        try{
            Scanner sc = new Scanner(new File(fileLocation));
            sc.useDelimiter("\n");
            while (sc.hasNext()){
                String[] details=sc.next().split(",");
                if (date.equals(details[1].replaceAll("\\s+", ""))) {
                    String name = FileOperatiions.returnMatch(1, details[0], "gym_members.csv")[0];
                    FileOperatiions fileoperation = new FileOperatiions(outputFileName, name + "," + details[0] + "," + details[1]);
                    fileoperation.appendToFiles();
                }
            } 
            sc.close();
        }catch(Exception e){
        }
    }
    
    public boolean appendToFiles(){
        try {
            String filename = this.fileLocation;
            FileWriter fw = new FileWriter(filename, true); //the true will append the new data
            fw.write(dataToWrite+"\n");//appends the string to the file
            fw.close();
            return true;
        } catch (IOException ioe) {
            //System.err.println("IOException: " + ioe.getMessage());
            return false;
        }
    }
    
    public static boolean checkIfExists(int position, String value, String fileLocation){
       boolean status=false;
        try{
            Scanner sc = new Scanner(new File(fileLocation));
            sc.useDelimiter("\n");
            while (sc.hasNext()){
                String[] details=sc.next().split(",");
                //System.out.println(details[position]);
                if(value.equals(details[position].replaceAll("\\s+",""))){
                    status=true;
                    break;
                }
            } 
            sc.close();
        }catch(Exception e){
            status=false;
        }
        //System.out.println(status);
        return status;
    }
     public static boolean checkIfExistsWith2Variables(int position1, String value1, String fileLocation, int position2, String value2){
       boolean status=false; 
        try{
            Scanner sc = new Scanner(new File(fileLocation));
            sc.useDelimiter("\n");
            while (sc.hasNext()){
                String[] details=sc.next().split(",");
                if(value1.equals(details[position1].replaceAll("\\s+",""))
                && value2.equals(details[position2].replaceAll("\\s+",""))){
                    status=true;
                    break;
                }
            } 
            sc.close();
        }catch(Exception e){
            status=false;
        }
        //System.out.println(status);
        return status;
    }
    
     public static String[] returnMatch(int position, String value, String fileLocation){
       String data[]=null;
        try{
            Scanner sc = new Scanner(new File(fileLocation));
            sc.useDelimiter("\n");
            while (sc.hasNext()){
                String[] details=sc.next().split(",");
                //System.out.println(details[position]);
                if(value.equals(details[position].replaceAll("\\s+",""))){
                    data= details;
                    break;
                }
            } 
            sc.close();
        }catch(Exception e){
        }
        return data;
    }
            
}
