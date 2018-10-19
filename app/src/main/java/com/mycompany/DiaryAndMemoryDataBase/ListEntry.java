package com.mycompany.DiaryAndMemoryDataBase;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * This class printing list of  the files
 * Created by Packard Bell on 20.09.2018.
 */
public class ListEntry {
		String pathAndroid = "/storage/64D6-1231/Diary/Data/";
    String nameFile; //the name of the selected file
    String nameFileArray[];
    String fullPath; //full path to the file
    int lengthArray = 3; //number of Entry
    int numbCell = 3;  //cell number with filename
    int ch = 0;
    int border = 0;
		String[] namesFiles;

    ListEntry() {
    getList();
      //  selectFiles();
       // openEntry();

    }

    void getList() {

        File filesOnDir = new File(pathAndroid);
        namesFiles = filesOnDir.list();
            for (String list : namesFiles) {
                lengthArray++;
                }
           lengthArray = lengthArray-3;
            }


    void openEntry() throws IOException {

        fullPath = pathAndroid + nameFile;
        ReadEntry reader = new ReadEntry();
        reader.pathReader(fullPath);
    }

  /*  void selectFiles() {
        Scanner in = new Scanner(System.in);
    //    System.out.println("*1* - to the next 10 Entry ");
    //    System.out.println("*2* - to the back 10 Entry ");
        printFiles();
        numbCell = in.nextInt();
        selectNext10th(numbCell);
        nameFile = namesFiles[numbCell];
    }*/

    int selectNext10th() {
            if(border+10<lengthArray) {
            border = border + 10;
                                      }
        
        /* if(border>10) {
            if(border-10>0) {
                    border = border - 10;//back to 10th elems
            }
         }*/
		return border;
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
