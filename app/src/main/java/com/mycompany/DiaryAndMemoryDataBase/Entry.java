package com.mycompany.DiaryAndMemoryDataBase;

/**
 * This Class have
 * Created by Packard Bell on 18.09.2018.
 */
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.Date;
public class Entry {
    private String entry = null;
    private String fullDocument = null;
    private String header = "header";
    private String tag = "someone tag";
    private String date = null;


    public void createDocument() throws IOException {
        setHeader();
        setDate();
        setTag();
        setEntry();
        fullDocument = header+"\n"+date+"\n"+entry+"\n"+tag;
        createEntry(fullDocument,header);
    }
    public void readDocument(){}
    public void getHeader(){
    }
    public void getEntry(){
        System.out.println(entry);
    }
    public void getTag(){
    }
    public void getDate(){
        System.out.println(date);
    }

    public void setHeader(){
        System.out.println("Enter the Header:");
        Scanner enter = new Scanner(System.in);
        this.header = enter.nextLine();
    }
    public void setEntry(){
        System.out.println("Enter the Entry:");
        Scanner enter = new Scanner(System.in);
        this.entry = enter.nextLine();
    }
    public void setTag() {
        System.out.println("Enter the Tags:");
        Scanner enter = new Scanner(System.in);
        this.tag = enter.nextLine();
    }
    public void setDate(){
        Date entryDate = new Date();
        SimpleDateFormat dateForm = new SimpleDateFormat("dd:MM:yy \nHH:mm");
        this.date = dateForm.format(entryDate);
    }
   public String toString() {
    return fullDocument;
    }

   public void createEntry(String documentEntry, String headerEntry) throws IOException {

        File fileEntry = new File("/Program Files/Diary/Data/" +headerEntry+".txt");

        FileWriter writerEntry = new FileWriter(fileEntry);
        writerEntry.write(documentEntry);
        writerEntry.flush();
        writerEntry.close();
    }

}
