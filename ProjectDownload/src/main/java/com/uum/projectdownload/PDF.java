/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uum.projectdownload;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Image;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfImportedPage;
import com.lowagie.text.pdf.PdfReader;
import com.lowagie.text.pdf.PdfWriter;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class PDF {

    String workingDirectory = System.getProperty("user.dir");
    String folder = workingDirectory + File.separator + "ERROR_LOG.txt";
    String folder2 = workingDirectory + File.separator + "Output.txt";
    String folder3 = workingDirectory + File.separator + "LOG.txt";

    private String INPUTFILE = folder;
    private String OUTPUTFILE = folder2;

    BufferedReader br = null;
    String count;

    public void pdf() throws DocumentException, IOException {
        br = new BufferedReader(new InputStreamReader(new FileInputStream(folder)));
        Document document = new Document(PageSize.A4);
        document.addTitle("Error Log");
        try {
            PdfWriter.getInstance(document, new FileOutputStream("Errorlog.pdf"));

            while ((count = br.readLine()) != null) {
                //System.out.println(count);
                document.open();

                Paragraph para = new Paragraph(count);
                document.add(para);
                document.close();

            }

        } catch (Exception e) {

        }

    }

    public void pdf2() throws DocumentException, IOException {
        br = new BufferedReader(new InputStreamReader(new FileInputStream(folder2)));
        Document document = new Document(PageSize.A4);
        document.addTitle("Output Log");
        try {
            PdfWriter.getInstance(document, new FileOutputStream("RunOutput.pdf"));

            while ((count = br.readLine()) != null) {
                //System.out.println(count);
                document.open();

                Paragraph para = new Paragraph(count);
                document.add(para);
                document.close();

            }

        } catch (Exception e) {

        }

    }
    
    public void pdf3() throws DocumentException, IOException {
        br = new BufferedReader(new InputStreamReader(new FileInputStream(folder3)));
        Document document = new Document(PageSize.A4);
        document.addTitle("Download Log");
        try {
            PdfWriter.getInstance(document, new FileOutputStream("DownloadLog.pdf"));

            while ((count = br.readLine()) != null) {
                //System.out.println(count);
                document.open();

                Paragraph para = new Paragraph(count);
                document.add(para);
                document.close();

            }

        } catch (Exception e) {

        }

    }

}
