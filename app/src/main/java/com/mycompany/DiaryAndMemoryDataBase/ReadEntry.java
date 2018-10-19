package com.mycompany.DiaryAndMemoryDataBase;

//import com.sun.org.apache.regexp.internal.RE;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by Packard Bell on 22.09.2018.
 */
public class ReadEntry {

    void pathReader(String path) throws IOException {
        FileReader entry = new FileReader(path);
        int simbol;
        while((simbol=entry.read())!=-1){
           System.out.print((char)simbol);
        }
    }


    }

