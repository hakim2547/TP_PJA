package Dev_TP2;

import java.io.*;
import java.util.Scanner;
 
public class SerializeDeserializeDemo
{
   public static void main(String [] args) throws IOException, ClassNotFoundException {
	   
	   int nbr, nbrChosen,j, SNN, number;
	   String name, address;
	   Scanner Sc = new Scanner(System.in) ;
	   
	   System.out.println("please select the number of employee do you want to create ... \n");
	   nbr = Sc.nextInt();
	   employee e[] =new employee[nbr];   
   
   //serialisation
   ObjectOutputStream objout= new ObjectOutputStream(new FileOutputStream("emp.dat"));
   for(j=0; j<e.length;j++ ){
	   	System.out.println("set the name");
	       name = Sc.next();
	      
	      System.out.println("set the adress");
	       address = Sc.next();
	      
	      System.out.println("set the SNN");
	       SNN = Sc.nextInt();
	      
	      System.out.println("set the number");
	       number = Sc.nextInt();
	       
	     e[j] = new employee(name, address, SNN, number);
	     objout.writeObject(e[j]);
   }
   
   	objout.writeObject(new endoffile() );
   	objout.close();
   	System.out.printf("data serialized are saved in emp.ser ! \n");

  //deserialisation
   	System.out.printf("Do you want to deserialize all the data ? [y/n] \n");
   	String answer;
   	answer= Sc.next();
   	Object obj = null;
    
   	if(answer.equals("y")) {
    ObjectInputStream objin = new ObjectInputStream (new FileInputStream("emp.dat"));
    while((obj = objin.readObject()) instanceof endoffile == false) {
    
    	System.out.println("Employee deserialise...");
    	System.out.println("Nom: " +((employee)obj).name);
    	System.out.println("Adresse: " + ((employee)obj).address);
    	System.out.println("SSN: " + ((employee)obj).SSN);
    	System.out.println("Number: " +((employee)obj).number);
    }
    objin.close();
   	}
   	
   	else {System.out.println("okay sir.\n");}
   	
   	//RandomAcessFile & Demander à l'utilisateur d'entrer un numéro d'employé au clavier.
    RandomAccessFile file = new RandomAccessFile("emp.dat", "rw");
    System.out.println("please insert a number of an employee...\n");
    nbrChosen= Sc.nextInt();
    
    file.seek(nbrChosen);
	System.out.println(file.readLine());
	file.close();
   	
   }     
}


