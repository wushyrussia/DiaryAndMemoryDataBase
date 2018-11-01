package com.mycompany.DiaryAndMemoryDataBase;

import java.io.*;

/**
 * This class printing list of  the files
 * Created by Packard Bell on 20.09.2018.
 */
public class ListEntry {
		String pathAndroid = "/storage/64D6-1231/Diary/Data/";
    int lengthArray = 3; //number of Entry
	String[] namesFiles;
    ListEntry() {
    getList();
		}


    void getList() {
        File filesOnDir = new File(pathAndroid);
        namesFiles = filesOnDir.list();
            for (String list : namesFiles) {
                lengthArray++;
                }
           lengthArray = lengthArray-3;
            }

}
