package com.company;

/**
 * This Class have
 * Created by Packard Bell on 18.09.2018.
 */
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.Date;
public class Diary {
    private String entry;
    private String fullDocument;
    private String header;
    private String tag;
    private String date;

    Diary(){
        setDate();
        setHeader();
        setEntry();
        setTag();
    }
    public String createDocument(){

        fullDocument = header+"\n"+date+"\n"+entry+"\n"+tag;
        return fullDocument;
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
    return createDocument();
    }

    public void getFullDocument() {
    System.out.println(toString());
    }

}
