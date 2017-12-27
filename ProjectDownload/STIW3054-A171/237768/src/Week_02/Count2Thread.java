package Week_02;

public class Count2Thread extends Thread {
 public static void main(String[] args) {
     new Thread(new Count2Thread()).start();
     new Thread(new print()).start();
 }

 @Override
 public void run() {
     try {
         for (int x = 1; x <= 10; x++) {
             System.out.println(x);
             if(x == 5){
             sleep(1000);
             System.out.println("");
             }
         }
     } catch (Exception e) {
         e.printStackTrace();
     }
 }
 
 
}

class print extends Thread{
	 @Override
	 public void run() {
	     
	     for (int x = 0; x <= 10; x++) {
	         System.out.print("A" + "  ");
	   }
	 }
}


