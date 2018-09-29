package com.company.backend;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * This class printing list of  the files
 * Created by Packard Bell on 20.09.2018.
 */
public class ListEntry {
    String pathWindows = "/Program Files/Diary/Data/";
    String nameFile; //the name of the selected file
    String nameFileArray[];
    String fullPath; //full path to the file
    int lengthArray = 3; //number of Entry
    int numbCell = 3;  //cell number with filename
    int ch = 0;
    int border = 0;
    String[] namesFiles;

    ListEntry() throws IOException {
        getList();
        System.out.println(lengthArray+" размер массива 27 или нет?");
        selectFiles();
        openEntry();

    }

    void getList() {

        File filesOnDir = new File(pathWindows);
        namesFiles = filesOnDir.list();
        // count the files
            int count = 0;
            for (String list : namesFiles) {
                lengthArray++;
                }
                nameFileArray = new String[lengthArray-3];
        for (String list : namesFiles) {
            nameFileArray[count]=list;
            count++;
        }


            }


    void openEntry() throws IOException {

        fullPath = pathWindows + nameFile;
        ReadEntry reader = new ReadEntry();
        reader.pathReader(fullPath);
    }

    void selectFiles() {
        Scanner in = new Scanner(System.in);
        System.out.println("*1* - to the next 10 Entry ");
        System.out.println("*2* - to the back 10 Entry ");
        printFiles();
        numbCell = in.nextInt();
        selectNext10th(numbCell);
        nameFile = namesFiles[numbCell];
    }

    void selectNext10th(int in) {
        if(lengthArray>10){
            if(border+10<lengthArray) {
                System.out.println("*1* - to the next 10 Entry ");
        if( (in == 1)) {
            border = border + 10;
            ch = border;
            selectFiles();
        }
        }
        }
        if(border>10) {
            if(border-10>0) {
                System.out.println("*1* - to the back 10 Entry ");
                if ((in == 2)) {
                    border = border - 10;
                    ch = border;
                    selectFiles();
                }
            }
        }
        }
        void printFiles(){
        if(border+10>lengthArray-2){
            border = lengthArray-border;
            for(;ch!=border;ch++,numbCell++){
                System.out.println("*" + numbCell + "*" + " - " + nameFileArray[ch]);
                System.out.println("Размер массивов"+"*" +ch);
            }
        }else {
            for (; ch != border + 10; ch++, numbCell++) {
                System.out.println("*" + numbCell + "*" + " - " + nameFileArray[ch]);
            }
        }
        }
}
