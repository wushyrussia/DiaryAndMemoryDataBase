package com.mycompany.DiaryAndMemoryDataBase;

import android.app.*;
import android.content.*;
import android.os.*;
import android.view.*;
import android.view.View.*;
import android.widget.*;


public class MainActivity extends Activity 
{
		Button writeButton;
		EditText editTextWr;
		LinearLayout readLayout;
		LinearLayout layoutEntryView;
		
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
		String path ="/storage/64D6-1231/Diary/Data/";
		String entry="";
		
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
						Intent intent = new Intent (MainActivity.this, WriteActivity.class);
                        startActivity(intent);
					
						
						
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
						
					    readInterface();
					}
			};
			
       void onVisibleWriter(){
	     writeButton = (Button) findViewById(R.id.writerButton);
		
		 readButton =(Button)findViewById(R.id.readButton);
		 readLayout =(LinearLayout) findViewById(R.id.menuLayoutRead);
		 nextElems = (Button)findViewById(R.id.nextButton);
	     backElems = (Button)findViewById(R.id.backButton);
		 
			  
			  layoutEntryView  = (LinearLayout) findViewById(R.id.layoutEntryView);
			   
			   writeButton.setOnClickListener(onClWrite);
			
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
					findViewById(R.id.layoutRead).setVisibility(View.VISIBLE);
				createButtonList(numbElems,menuEntry.namesFiles,border);
				
		}
		
		void readInterface(int next) {
				numbElems = menuEntry.lengthArray;
				borderMin=border;
				        if(next==1){
							if (border+numbElems%10 ==numbElems){
								border=border+numbElems%10;
							}else{
				if(border+10<=numbElems){
					border = border+10;
				}else{
					border = numbElems-border;	
				}
						}
						}
				if(next==2){
						int x=0;
						int x2 = 10;
						int x3 =20;
				if(numbElems == borderMin){
						x = numbElems%10;
						x2=0;
						x3 =10;
					}
				borderMin = borderMin-(x3+x);
				border=border-(x2+x);
				x=0;
				
				}
				createButtonList(numbElems,menuEntry.namesFiles,border);
				}
		
		void checkAvailableButton(int numbElems, int border){
			  int countFiles = numbElems%10;
				if(numbElems<border+10){
						
						nextElems.setVisibility(View.GONE);
					}else{
							nextElems.setVisibility(View.VISIBLE);		 
					}
					if (numbElems==border+countFiles){
							nextElems.setVisibility(View.VISIBLE);	
					}
			    if(border-10>=10){
					backElems.setVisibility(View.VISIBLE);
				}else{
						backElems.setVisibility(View.GONE);
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
						openEntry[borderMin].setTag(path+menuEntry.namesFiles[borderMin]);
						openEntry[borderMin].setGravity(Gravity.LEFT);
						openEntry[borderMin].setText(namesFiles[borderMin]);
                        
						openEntry[borderMin].setOnClickListener(new View.OnClickListener() {
									@Override
									public void onClick(View v) {
											
										String paths = (String) v.getTag();
										entry=Entry.readEntry((paths));
										
									    
		
											Intent intent = new Intent (MainActivity.this, ReadActivity.class);
											intent.putExtra("path",paths);
											startActivity(intent);
											
											
										}
								});
						//messToast(borderMin+"_"+border);
						RelativeLayout.LayoutParams buttonParams = new RelativeLayout.LayoutParams(
							RelativeLayout.LayoutParams.MATCH_PARENT,
							RelativeLayout.LayoutParams.WRAP_CONTENT
						);
					
						readLayout.addView(openEntry[borderMin],buttonParams);
						readLayout.setVisibility(1);

					}
		}
		void messToast(String mess){
				
				Toast tast = Toast.makeText(getApplicationContext(), 
											mess, Toast.LENGTH_SHORT); 
				tast.show(); 
		}
	
}
