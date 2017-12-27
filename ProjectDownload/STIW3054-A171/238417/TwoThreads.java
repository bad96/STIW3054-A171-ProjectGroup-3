/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package twothreads;

/**
 *
 * @author User
 */
public class TwoThread extends Thread {

   
    public static void main(String[] args) {
        TwoThread t1 = new TwoThread();
TwoThread t2 = new TwoThread();

try{
    for (int x = 1; x < 11; x++) {
        System.out.print(x + " "); 
        sleep(1000);
   
         if (x==5){
            for(int i=0; i<10; i++)
            System.out.print("A");
            System.out.print(" ");
            
         }
    }
}

catch(Exception e){
e.printStackTrace();
}
    }
    
}
