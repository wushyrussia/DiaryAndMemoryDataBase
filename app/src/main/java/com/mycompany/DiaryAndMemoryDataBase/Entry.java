package com.mycompany.DiaryAndMemoryDataBase;

/**
 * This Class have
 * Created by Packard Bell on 18.09.2018.
 */
import java.io.File;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.Date;



import java.io.*;
public class Entry {
    private String entry = null;
    private String fullDocument = null;
    private String header = "header";
    private String tag = "someone tag";
    private String date = null;


    public void createDocument(String header, String tag, String entry) throws IOException {
        this.header = header;
		this.tag = tag;
		this.entry = entry;
        setDate();
        fullDocument = header+"\n"+"\n"+date+"\n"+"\n"+entry+"\n"+"\n"+tag;
        createEntry(fullDocument,header);
    }
    
    public void setDate(){
        Date entryDate = new Date();
        SimpleDateFormat dateForm = new SimpleDateFormat("dd.MM.yy HH:mm");
        this.date = dateForm.format(entryDate);
    }
   public String toString() {
    return fullDocument;
    }

   public void createEntry(String documentEntry, String headerEntry) throws IOException {

		   File fileEntry = new File("/storage/64D6-1231/Diary/Data/" +headerEntry+".dbd");

        FileWriter writerEntry = new FileWriter(fileEntry);
        writerEntry.write(documentEntry);
		
        writerEntry.flush();
        writerEntry.close();
    }
	
   public static  String readEntry(String path) {
		 String entryDoc = "";
		 String line = "";
		 File entryFile = new File(path);
		   try
			   {
				   FileInputStream inputStream = new FileInputStream(entryFile);
				   BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
				   try
					   {
						   while ((line = bufferedReader.readLine()) != null)
							   {
                                entryDoc = entryDoc+line+"\n";
							   }
					   }
				   catch (IOException e)
					   {}
			   }
		   catch (FileNotFoundException e)
			   {}


		 
		 return entryDoc;
	 }
}
