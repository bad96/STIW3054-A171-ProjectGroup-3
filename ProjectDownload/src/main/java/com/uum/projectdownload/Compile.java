/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uum.projectdownload;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.logging.*;

/**
 *
 * @author Badrul
 */
public class Compile {

    //public String pathFile;
    public String firstCommand;
    public String secondCommand;
    public boolean pakej;

    public void GetDir(String[] list) throws FileNotFoundException, IOException {
        for (int i = 0; i < list.length; i++) {
            try (BufferedReader br = new BufferedReader(new FileReader(list[i]))) {
                String line = "";

                while ((line = br.readLine()) != null) {
                    if (line.contains("package ")) {
                        String[] items = line.split(" ");
                        int dotIndex = items[1].lastIndexOf(';');
                        String packagename = items[1].substring(0, dotIndex);
                        String packageDir = packagename.replace(".", File.separator);//Penting

                        String dirXPackage = list[i].replace(packageDir + File.separator, "");

                        int slashLast = dirXPackage.lastIndexOf(File.separator);
                        //int dotjava = dirXPackage.lastIndexOf(".java");
                        String namaFile = dirXPackage.substring(slashLast + 1);

                        firstCommand = dirXPackage.replace(namaFile, "");
                        secondCommand = packageDir + File.separator + namaFile;

                        pakej = true;
                    }
                    pakej = false;
                }

                int slashLast = list[i].lastIndexOf(File.separator);
                String namaFile = list[i].substring(slashLast + 1); // Command 2
                String path = list[i].replace(namaFile, "");
                String workingDirectory = System.getProperty("user.dir");
                String folder = workingDirectory + File.separator + "ERROR_LOG.txt";

                firstCommand = path;
                secondCommand = namaFile;

                try {
                    //if (pakej = true) {
                    ProcessBuilder builder = new ProcessBuilder(
                            "cmd.exe", "/c", "cd \"" + firstCommand + "\" && " + "javac" + " " + secondCommand);
                    builder.redirectErrorStream(true);
                    Process p = builder.start();
                    BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()));
                    String line2;
                    while (true) {
                        line2 = r.readLine();
                        if (line2 == null) {
                            break;
                        }
                        PrintStream error_log = new PrintStream(new File(folder));
                        System.setOut(error_log);
                        error_log.print(line2);
                        //}
                    }
                    /*else {
                        ProcessBuilder builder = new ProcessBuilder(
                                "cmd.exe", "/c", "cd \"" + firstCommand + "\" && " + "javac -d" + " " + secondCommand);
                        builder.redirectErrorStream(true);
                        Process p = builder.start();
                        BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()));
                        String line2;
                        while (true) {
                            line2 = r.readLine();
                            if (line2 == null) {
                                break;
                            }
                        }
                        
                    }*/


                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        }
    }
}
