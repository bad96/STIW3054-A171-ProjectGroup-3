package assignment1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;


public class CountIssues{
	
	private final String word = "public static void main";
    private String theFile = "";
    private int count;
    
    public int getIssue() {
        return count;
    }
    
    public void setIssue(int c) {
        c = count;
    }

    public int calIssue(final File folder, String[] w) {

        int noIssue = 0;
        for (int i = 0; i < w.length; i++) {
            theFile = folder + "/" + w[i];

            try (BufferedReader br = new BufferedReader(new FileReader(theFile))) {
                String readLine;
                while ((readLine = br.readLine()) != null) {
                    if (readLine.contains(word)) {
                        noIssue++;
                    }
                }
            } catch (IOException e) {

            }
        }
        setIssue(noIssue);
        return count;
    }

}
