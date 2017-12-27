/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uum.projectdownload;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author Badrul
 */
public class Find {

    public JSONObject json = new JSONObject();
    public JSONObject json1 = new JSONObject();
    public JSONObject json2 = new JSONObject();
    public JSONArray array = new JSONArray();
    public JSONArray array1 = new JSONArray(); 
    public JSONArray array2;
    public JSONObject item;
    public JSONObject item1;
    public int totalLine;
    String task;
    String matrik;
    String ni;
    String keyword[] = {"abstract", "assert", "boolean", "break", "byte", "case", "catch", "char", "class", "continue",
        "default", "do", "double", "else", "enum", "extends", "final", "finally", "float", "for",
        "if", "implements", "import", "instanceof", "int", "interface", "long", "native", "new", "package",
        "private", "protected", "public", "return", "short", "static", "strictfp", "super", "switch", "synchronized",
        "this", "throw", "throws", "transient", "try", "void", "volatile", "while", "true", "null",
        "false", "const", "goto"};

    public void CountKeyword(String[] listJavaFile) throws IOException {
        for (int i = 0; i < listJavaFile.length; i++) {
            int kira[] = new int[keyword.length];
            try (BufferedReader br = new BufferedReader(new FileReader(listJavaFile[i]))) {
                String readLine;
                while ((readLine = br.readLine()) != null) {
                    if (readLine.contains("//Task:")) {
                        task = readLine.replaceAll("\\s*//Task:\\s*#", "");
                    } else if (readLine.contains("//Matrik:")) {
                        matrik = readLine.replaceAll("\\s*//Matrik:\\s*#", "");
                    }
                    for (int j = 0; j < keyword.length; j++) {
                        if (readLine.contains(keyword[j])) {
                            kira[j] = kira[j] + 1;
                        }
                    }
                }
            }
            try {
                item = new JSONObject();
                item.put("Task", task);
                item.put("Matrik", matrik);
                for (int l = 0; l < keyword.length; l++) {
                    item.put(keyword[l], kira[l]);
                }
                array.put(item);
                json.put("listKeyword", array);
            } catch (JSONException ex) {
            }
        }
    }

    public void FindLine(String[] listJavaFile) {
        for (int i = 0; i < listJavaFile.length; i++) {
            int command = 0;
            int kosong = 0;
            int code = 0;
            try (BufferedReader br = new BufferedReader(new FileReader(listJavaFile[i]))) {
                String readLine;
                totalLine = 0;
                while ((readLine = br.readLine()) != null) {
                    if (readLine.contains("//Task:")) {
                        task = readLine.replaceAll("\\s*//Task:\\s*#", "");
                    } else if (readLine.contains("//Matrik:")) {
                        matrik = readLine.replaceAll("\\s*//Matrik:\\s*#", "");
                    }
                    if (readLine.contains("//")) {
                        command++;
                    } else if (readLine.isEmpty()) {
                        kosong++;
                    } else {
                        code++;
                    }
                    totalLine++;
                }
            } catch (IOException e) {
            }
            try {
                item1 = new JSONObject();
                item1.put("Task", task);
                item1.put("Matrik", matrik);
                item1.put("Command", command);
                item1.put("Empty", kosong);
                item1.put("Actual", code);
                array.put(item1);
                json1.put("line", array1);
            } catch (JSONException ex) {
            }
        }
    }

    public void combinejson() {
        try {
            array2.put(json);
            array2.put(json1);
            json2.put("INFORMATION",array2);
        } catch (JSONException ex) {
        }
        System.out.println(json2.toString());
    }
}
