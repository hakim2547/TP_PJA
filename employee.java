package Dev_TP2;

import java.io.Serializable;

public class employee implements Serializable{
	
   public String name;
   public String address;
   public transient int SSN;
   public int number;
   
   public employee(String name, String address, int ssn ,int num){
	   
	   this.name= name;
	   this.address= address;
	   this.SSN = ssn;
	   this.number= num;
	   }
   
}




