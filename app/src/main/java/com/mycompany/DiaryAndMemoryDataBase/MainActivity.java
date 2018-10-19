package com.mycompany.DiaryAndMemoryDataBase;

import android.app.*;
import android.os.*;
import android.view.*;
import android.view.View.*;
import android.widget.*;
import android.text.*;
import java.io.*;

public class MainActivity extends Activity 
{
		Button writeButton;
		EditText editTextWr;
		Button saveButton;
		LinearLayout writeLayout;
		LinearLayout readLayout;
		Button readButton;
		Button nextElems;
		Button backElems;
		int border;
		int borderMin=0;
		int numbElems;
		Button[] openEntry;
		int entryId = 1;
		String[]namesFiles;
		ListEntry menuEntry = new ListEntry();
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
		onVisibleWriter();
		
		
    }
	
	
		OnClickListener onClWrite = new View.OnClickListener() {
				@Override
				public void onClick(View v) {
						writeLayout.setVisibility(0);
						
						
}
};
		OnClickListener onClButtonSave = new OnClickListener() {
				@Override
				public void onClick(View v) {
						editTextWr.setEnabled(false);
					}
			};
			//gggggggg
			
		OnClickListener onClButtonBack = new OnClickListener() {
				@Override
				public void onClick(View v) {
						readInterface(2);
					}
			};
			
		OnClickListener onClButtonNext = new OnClickListener() {
				@Override
				public void onClick(View v) {
					
					readInterface(1);
					}
			};
			//gggggggggggg
			
		OnClickListener onClButtonRead = new OnClickListener() {
				@Override
				public void onClick(View v) {
					    borderMin =0;
						writeLayout.setVisibility(View.GONE);
					    readInterface();
					}
			};
			
       void onVisibleWriter(){
	     writeButton = (Button) findViewById(R.id.writerButton);
		 editTextWr = (EditText) findViewById(R.id.editTextWriter);
		 saveButton = (Button) findViewById(R.id.saveButton);
		 writeLayout = (LinearLayout)findViewById(R.id.writeLayout);
		 readButton =(Button)findViewById(R.id.readButton);
		 readLayout =(LinearLayout) findViewById(R.id.menuLayoutRead);
		 nextElems = (Button)findViewById(R.id.nextButton);
	     backElems = (Button)findViewById(R.id.backButton);
			//   openEntry = (Button)findViewById(R.id.openEntry.);
		 
		 
			   writeButton.setOnClickListener(onClWrite);
			   saveButton.setOnClickListener(onClButtonSave);
			   readButton.setOnClickListener(onClButtonRead);
			   backElems.setOnClickListener(onClButtonBack);
			   nextElems.setOnClickListener(onClButtonNext);
        }
		
		
		
		void readInterface() {
				 numbElems = menuEntry.lengthArray;
				if (numbElems>10){ 
						border=10;
					}else{
						border=numbElems;
					}			
				createButtonList(numbElems,menuEntry.namesFiles,border);			
		}
		void readInterface(int next) {
				numbElems = menuEntry.lengthArray;
				borderMin=border;
				if(next==1){
				if(border+10<=numbElems){
					border = border+10;
				}else{
					border = numbElems-border;
					
				}
						
								
				}
				if(next==2){
						
								borderMin = borderMin-20;
								border=border-10;
						Toast toast = Toast.makeText(getApplicationContext(), 
													 "back", Toast.LENGTH_SHORT); 
						toast.show(); 
							
					
				}
				createButtonList(numbElems,menuEntry.namesFiles,border);	
				
			}
		
		void checkAvailableButton(int numbElems, int border){
				if(numbElems<border+10){
						
						nextElems.setVisibility(View.INVISIBLE);
					}else{
							nextElems.setVisibility(View.VISIBLE);
							 
					}
			    if(border-10>=10){
					backElems.setVisibility(View.VISIBLE);
				}else{
						backElems.setVisibility(View.INVISIBLE);
				}
						
		}
		
		void createButtonList(int numbElems, String[]namesFiles,int border){
				readLayout.removeAllViews();
				openEntry=new Button[numbElems];
				checkAvailableButton(numbElems,border);
				for(; borderMin!=border;borderMin++){
						openEntry[borderMin] = new Button(this);
						openEntry[borderMin].setVisibility(1);
						openEntry[borderMin].setText("button "+borderMin);
						openEntry[borderMin].setId(borderMin);
						openEntry[borderMin].setTag("/storage/64D6-1231/Diary/Data/"+menuEntry.namesFiles[borderMin]);
						openEntry[borderMin].setGravity(Gravity.LEFT);
						openEntry[borderMin].setText(namesFiles[borderMin]);
                        
						openEntry[borderMin].setOnClickListener(new View.OnClickListener() {
									@Override
									public void onClick(View v) {
											// do something when the corky2 is clicke
											Toast tast = Toast.makeText(getApplicationContext(), 
																		v.getTag()+"", Toast.LENGTH_SHORT); 
											tast.show(); 
										}
								});
						
						RelativeLayout.LayoutParams buttonParams = new RelativeLayout.LayoutParams(
							RelativeLayout.LayoutParams.MATCH_PARENT,
							RelativeLayout.LayoutParams.WRAP_CONTENT
						);
					Toast tast = Toast.makeText(getApplicationContext(), 
													openEntry[borderMin].getTag()+ "-- bMin-border "+border, Toast.LENGTH_SHORT); 
						tast.show(); 
						readLayout.addView(openEntry[borderMin],buttonParams);
						readLayout.setVisibility(1);

					}
		}
		void getEntry(){
				ListEntry menuEntry = new ListEntry();
				numbElems = menuEntry.lengthArray;
				
		}
}
