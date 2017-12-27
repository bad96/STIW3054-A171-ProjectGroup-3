package Week_02;

public class CountThread extends Thread{
	//Count Thread to 10500
	//Pause 5 seconds between numbers
	//Display String every 50 numbers
	public static void main(String[] args) {
		
		 new Thread(new CountThread()).start();
	}
	
	@Override
    public void run() {
        try {
            for (int x = 0; x < 10500; x++) {
                System.out.println(x);
               if((x % 50 == 0)&&(x != 0)){
            	System.out.println("--Check--"); 
               }
                sleep(5000);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
