package Hospital_Management;
import java.lang.String;
import java.util.Random;
import java.util.Scanner;

public class Entry implements enter{

   public void reg()
   
    {
       Scanner sc = new Scanner(System.in);
       System.out.print("Pay fee 200rs of form: ");
       int as;
        int fee = sc.nextInt();
      sc.nextLine();
       if(fee==200){
      System.out.println("Fill this form: ");

      System.out.print("Patient Name: ");
      String patientName = sc.nextLine();
      // sc.nextLine();
      
      System.out.print("Age: ");
      int patientAge = sc.nextInt();
      sc.nextLine();
        
      
      
      
      System.out.print("Phone no.: ");
      long phoneNumber = sc.nextLong();
      sc.close();
       
       
        // System.out.println(phoneNumber);
         System.out.print("Verifing your details..");
        try{
          for(int i=0;i<15;i++)
          {
          System.out.print(".");
        Thread.sleep(500);
          }
        }
        catch(Exception e)
        {
          System.out.println("");
        }

        System.out.println("\n----------Verified your details---------");
        Random r = new Random();
        int randNum = r.nextInt(50);
        int roomNum =r.nextInt(12);
        System.out.println("Generated Token \nYour Token no. is "+randNum+"\nRoom no. "+roomNum);
         }
         else if(fee>200 || fee<200)
         {
          System.out.println("Please pay 200rs only ");
         }
           else 
       {
        System.out.println("pay form fee..");
       }

    }


    
}