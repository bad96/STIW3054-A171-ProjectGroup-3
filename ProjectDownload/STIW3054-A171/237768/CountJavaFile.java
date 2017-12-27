package assignment1;

import assignment1.CountIssues;
import java.io.File;
import java.util.LinkedList;


public class CountJavaFile{
	
	public CountIssues i = new CountIssues();
    private LinkedList<String> list = new LinkedList();
    private String all = "";
    
    
    public CountJavaFile(String path) {

        final File file = new File(path);
        listFile(file);

    }

    public void listFile(final File folder) {
        for (final File fileEntry : folder.listFiles()) {
            if (fileEntry.isDirectory()) {
                this.listFile(fileEntry);
            } else {
                String list[] = {fileEntry.getName()};
                for (int i = 0; i < list.length; i++) {
                    addFile(list[i]);
                }
            }
        }
        i.calIssue(folder, getFileList());
    }

    public void addFile(String fileExt) {
        if (javaExt(fileExt)) {
            list.add(fileExt);
        }
    }

    public boolean javaExt(String ext) {
        if (ext.substring(ext.length() - 4).equalsIgnoreCase("Java")) {
            return true;
        }
        return false;
    }

    public String[] getFileList() {
        String arrayFile[] = new String[list.size()];

        for (int i = 0; i < list.size(); i++) {
            arrayFile[i] = list.get(i);
        }
        return arrayFile;
    }

    public String dispFile() {

        for (int i = 0; i < list.size(); i++) {
            all += list.get(i);
        }
        return all;
    }

    public int numberFile() {
        int noFile = list.size();
        return noFile;
}
	
}
