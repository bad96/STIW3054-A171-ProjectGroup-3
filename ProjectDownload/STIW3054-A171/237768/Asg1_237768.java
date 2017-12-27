package assignment1;

import java.io.FileNotFoundException;
import assignment1.CountJavaFile;
import assignment1.CountIssues;

public class Asg1_237768 {
	
	static CountJavaFile file;
	//Replace folder = "Your Directory"
	static final String folder ="/Users/Lim/Documents/UUM/Sem 5/Real Time Programming/Real Time Example/src/Week_01/";
	
	static CountIssues countingIssue = new CountIssues();
	
	public static void main(String[] args) throws FileNotFoundException {
		file = new CountJavaFile(folder);
        int nOfFiles = file.numberFile();
        int nOfIssues = file.i.getIssue();
        
        System.out.println("Number of Java Files = " + nOfFiles);
        System.out.println("Number of Issues = " + nOfIssues);
	}
}
