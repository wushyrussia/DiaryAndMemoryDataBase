package com.mycompany.DiaryAndMemoryDataBase;

import android.os.*;
import java.io.*;

/**
 * This class printing list of  the files
 * Created by Packard Bell on 20.09.2018.
 */
public class ListEntry {
		String pathAndroid = Environment.getExternalStorageDirectory() + 
		File.separator + "Diary/Data/";
    int lengthArray = 0; //number of Entry
	String[] namesFiles;
    ListEntry() {
    getList();
		}


    void getList() {
			File folder = new File(pathAndroid);
			File[] listOfFiles = folder.listFiles();
			
			for (File file : listOfFiles) {
					if (file.isFile()) {
							lengthArray++;
						}
									}
			namesFiles = new String [lengthArray];
			lengthArray=0;
			for (File file1 : listOfFiles) {
					if (file1.isFile()) {
							namesFiles[lengthArray] = file1.getName();
							lengthArray++;
						}				
						}
						}
         
			
			
}
