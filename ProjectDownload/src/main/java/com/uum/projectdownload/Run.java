package com.uum.projectdownload;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import static java.lang.Thread.sleep;

public class Run {

    public String firstCommand;
    public String secondCommand;
    public String test, test2;
    public boolean pakej;

    public void Run(String[] list) throws IOException {
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
                        int dotjava = dirXPackage.lastIndexOf(".java");
                        String namaClass = dirXPackage.substring(slashLast + 1, dotjava);
                        String namaFile = dirXPackage.substring(slashLast + 1);

                        firstCommand = dirXPackage.replace(namaFile, "");;
                        secondCommand = packageDir + File.separator + namaFile;
                        test = packagename;
                        test2 = namaClass;

                        pakej = true;
                    }
                    pakej = false;
                }

                int slashLast = list[i].lastIndexOf(File.separator);
                String namaFile = list[i].substring(slashLast + 1); // Command 2
                String path = list[i].replace(namaFile, "");
                
                String workingDirectory = System.getProperty("user.dir");
                String folder = workingDirectory + File.separator + "Output.txt";

                Process p = null;
                try {
                    System.out.println(path);
                    ProcessBuilder builder = new ProcessBuilder(
                            "cmd.exe", "/c", "cd \"" + firstCommand + "\" && " + "java" + " " + test + "." + test2);
                    builder.redirectErrorStream(true);
                    p = builder.start();
                    BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()));
                    String line1;
                    String simpanLine = "";

                    while (true) {
                        line1 = r.readLine();

                        if (line1 == null) {
                            break;
                        } else {
                            simpanLine += line1;
                            System.out.println(simpanLine);
                            
                        }
                    }
                    PrintStream log = new PrintStream(new File(folder));
                    System.setOut(log);
                    log.print(simpanLine);
                    sleep(3000);
                    //System.out.println("abc");
                    p.destroyForcibly();
                    //p.destroy();
                } catch (Exception e) {
                    System.out.println("abcd");
                    //e.printStackTrace();
                    //p.destroyForcibly();
                }

            }
            //System.exit(0);
        }
    }
}
