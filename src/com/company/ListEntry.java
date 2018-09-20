package com.company;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * This class index entry, save and updates the entry count
 * Created by Packard Bell on 20.09.2018.
 */
public class ListEntry {
    String files = " ";

    ListEntry() throws IOException {
        getFiles();
        System.out.println(files);
        indexing();
    }

    /**
     *
     * @indexing - write a list of entry to index file
     */
    public void indexing() throws IOException {
        File indexData = new File("/Program Files/Diary/Data/indexData");
        FileWriter indexDat = new FileWriter(indexData);
        indexDat.write(files);
        indexDat.flush();
        indexDat.close();

    }

    /**
     *@getFiles - get a list of entry
     */
    public void getFiles(){
        String [] pathFiles;
        File filesOnDir = new File("/Program Files/Diary/Data");
        pathFiles = filesOnDir.list();
        for(String path:pathFiles){
           files= files+"\n"+path;
        }
    }

}
