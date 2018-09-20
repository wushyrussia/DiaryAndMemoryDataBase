package com.company;

import java.io.FileWriter;
import java.io.File;
import java.io.IOException;

/**
 * This class for creating new Entry
 * Created by Packard Bell on 20.09.2018.
 */
public class CreateEntry {
    CreateEntry(int numberFile, String documentEntry, String headerEntry) throws IOException {

        File fileEntry = new File("/Program Files/Diary/Data/"+numberFile+" "+headerEntry+".txt");

        FileWriter writerEntry = new FileWriter(fileEntry);
        writerEntry.write(documentEntry);
        writerEntry.flush();
        writerEntry.close();
    }
}
