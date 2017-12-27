package com.uum.projectdownload;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.errors.GitAPIException;

public class Download implements Runnable {

    
    AccountList url = new AccountList();
    public String[] link = url.accountlist;
    public String[] name = url.foldername;
    
    String workingDirectory = System.getProperty("user.dir");
    String folder = workingDirectory + File.separator + "STIW3054-A171";
    String absolutePath = "";

    public void klon() {
        // prepare a new folder for the cloned repository
        ExecutorService executor = Executors.newFixedThreadPool(link.length);
        for (int i = 0; i < 20; i++) {
            Runnable worker = new Download ();
            executor.execute(worker);
        }
        executor.shutdown();
        while (!executor.isTerminated()) {
        }
        System.out.println("Finished all threads");
    }
     

    @Override
    public void run() {
        
        for(int i = 0; i < link.length; i++) {
            
             absolutePath = folder + File.separator + name[i];
             File localPath = new File(absolutePath);

            System.out.println("Cloning from " + link[i] + " to " + localPath);
            try (Git result = Git.cloneRepository()
                    .setURI(link[i])
                    .setDirectory(localPath)
                    .call()) {
                // Note: the call() returns an opened repository already which needs to be closed to avoid file handle leaks!
                System.out.println("Having repository: " + result.getRepository().getDirectory());
                System.out.print("File path: " + localPath.getAbsolutePath());
            } catch (GitAPIException ex) {
                
                PrintStream log = null;
                 try {
                     String folder1 = workingDirectory + File.separator + "LOG.txt";
                     log = new PrintStream(new File(folder1));
                     System.setOut(log);
                     log.print(ex);
                 } catch (FileNotFoundException ex1) {
                     Logger.getLogger(Download.class.getName()).log(Level.SEVERE, null, ex1);
                 } finally {
                     log.close();
                 }
            }
        }
        
    }
    
   
}
