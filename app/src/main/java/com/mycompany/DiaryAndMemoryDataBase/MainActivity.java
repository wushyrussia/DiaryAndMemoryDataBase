package com.mycompany.DiaryAndMemoryDataBase;

import android.app.*;
import android.content.*;
import android.os.*;
import android.view.*;
import android.view.ContextMenu.*;
import android.view.View.*;
import android.widget.*;
import java.io.*;


public class MainActivity extends Activity 
{
		Button writeButton;
		EditText editTextWr;
		LinearLayout readLayout;
		LinearLayout layoutEntryView;
		LinearLayout layoutTask;
		
		Button readButton;
		Button taskButton;
		Button addTaskButton;
		Button nextElems;
		Button backElems;
		int border;
		int borderMin=0;
		int numbElems;
		Button[] openEntry;
		String[]namesFiles;
		ListEntry menuEntry;		
		String entry="";	
		EditText newTask;
		
		final String path =Environment.getExternalStorageDirectory() + 
		File.separator + "Diary/Data/";
		 final int CREATE_TASK = 1;
		 final int EDIT_TASK = 2;
		 final String NONE_PATH ="";
		 final int POP_ENTRY = 1;
		 final int POP_TASK = 2;
		 
		
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
		createDir();
		onVisibleWriter();
		
    }
	
		
	
	
		OnClickListener onClWrite = new View.OnClickListener() {
				@Override
				public void onClick(View v) {
						Intent intent = new Intent (MainActivity.this, WriteActivity.class);
                        startActivity(intent);
					}
};
		
		OnClickListener onClButtonTask = new OnClickListener() {
				@Override
				public void onClick(View v) {
					setVisibleElems();
						layoutTask.setVisibility(View.VISIBLE);
					createButtonListT();
					}
			};
		OnClickListener onClButtonAddTask = new OnClickListener() {
				@Override
				public void onClick(View v) {
					showRatingDialog(NONE_PATH,CREATE_TASK);
				}
			};
			
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
				setVisibleElems();
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
		 taskButton = (Button)findViewById(R.id.Task);
		 addTaskButton =(Button)findViewById(R.id.addTask);
		 layoutTask =(LinearLayout)findViewById(R.id.layoutTask);
		layoutEntryView  = (LinearLayout) findViewById(R.id.layoutEntryView);
			   
		       taskButton.setOnClickListener(onClButtonTask);
			   addTaskButton.setOnClickListener(onClButtonAddTask);
			   writeButton.setOnClickListener(onClWrite);
			
			   readButton.setOnClickListener(onClButtonRead);
			   backElems.setOnClickListener(onClButtonBack);
			   nextElems.setOnClickListener(onClButtonNext);
        }
		
		
		void readInterface() {
			menuEntry = new ListEntry();
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
                        
						openEntry[borderMin].setOnLongClickListener(new View.OnLongClickListener() {
									@Override
									public boolean onLongClick(View v) {
									        showPopupMenu(POP_ENTRY,(String)v.getTag(),v);
											return true;
										}
								});
						
						openEntry[borderMin].setOnClickListener(new View.OnClickListener() {
									@Override
									public void onClick(View v) {
											
										String paths = (String) v.getTag();
			
										
									    
		
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
		
	void createDir(){
			File dataDir = new File(Environment.getExternalStorageDirectory() + 
								   File.separator + "Diary/Data/");
			File taskDir = new File(Environment.getExternalStorageDirectory() + 
								   File.separator + "Diary/Data/Task");
			if (!dataDir.exists()) {
					dataDir.mkdir();
				}
			if (!taskDir.exists()) {
					taskDir.mkdir();
				}
	}
	
	
	
	
	    LinearLayout taskLayout;
		Button[] openTask;
		String pathT = path+"Task/";
		String namesFilesT[];
		int lengthArrayT =0;

		

		void createButtonListT(){
				getListT();

				taskLayout = (LinearLayout)findViewById(R.id.layoutTaskScroll);
				taskLayout.removeAllViews();
				openTask=new Button[lengthArrayT];


				for(int borderMinT = 0;borderMinT!=lengthArrayT ;borderMinT++){

						openTask[borderMinT] = new Button(this);
						openTask[borderMinT].setVisibility(1);
						openTask[borderMinT].setId(borderMinT);
						openTask[borderMinT].setTag(pathT+namesFilesT[borderMinT]);
						openTask[borderMinT].setGravity(Gravity.LEFT);
						openTask[borderMinT].setText(namesFilesT[borderMinT]);
						
						openTask[borderMinT].setOnLongClickListener(new View.OnLongClickListener() {
									@Override
									public boolean onLongClick(View v) {
									        showPopupMenu(2,(String)v.getTag(),v);
											messToast("hah");
											return true;
										}
								});
						
						
						openTask[borderMinT].setOnClickListener(new View.OnClickListener() {
									
							
							@Override
									public void onClick(View v) {

											String paths = (String) v.getTag();
											showReadingDialog(paths);

										}
								});
                        
						RelativeLayout.LayoutParams buttonParams = new RelativeLayout.LayoutParams(
							RelativeLayout.LayoutParams.MATCH_PARENT,
							RelativeLayout.LayoutParams.WRAP_CONTENT
						);
                         
					
						
						
						
						taskLayout.addView(openTask[borderMinT],buttonParams);
						
						taskLayout.setVisibility(1);

					}
			lengthArrayT = 0;
			}

		public void showRatingDialog(final String path,int idElems) {
               newTask = new EditText(this);
				newTask.setLines(1);
				final AlertDialog.Builder ratingdialog = new AlertDialog.Builder(this);
				if (idElems ==1){
				ratingdialog.setTitle("new Task");
				}else{
						ratingdialog.setTitle("Edit task");
						String bf =Entry.readEntry(path);
						newTask.setText(bf);
				}
				ratingdialog.setView(newTask); 
				ratingdialog.setPositiveButton("add",
					new DialogInterface.OnClickListener() {
							public void onClick(DialogInterface dialog, int which) {						
									String headerEntryT = "empty";
									String taskTxt="";
									taskTxt = newTask.getText().toString();
									
									if(taskTxt.length() > 15){
											headerEntryT = taskTxt.substring(0,15)+"...";
										}else{
											headerEntryT = taskTxt.substring(0, taskTxt.length()-1);
										}							
									File fileEntry = new File(pathT +headerEntryT+".tsk");
									messToast("/storage/64d6-1231/Diary/Data/Task/очень длиная строка, ну прям пипец длинна, ахуеть можно, блядь");
									try
										{
											FileWriter writerEntry = new FileWriter(fileEntry);
											writerEntry.write(taskTxt);
											
											writerEntry.flush();
											writerEntry.close();
											deleteElemDiary(path);
										}
										
									catch (IOException e)
										{
											
											//messToast(e.getMessage());
										}
									createButtonListT();
								}
								
						})

					.setNegativeButton("cancel",
                    new DialogInterface.OnClickListener() {
							public void onClick(DialogInterface dialog, int id) {
									dialog.cancel();
								}
						});

				ratingdialog.create();
				ratingdialog.show();
			}
		void getListT() {
				File filesOnDir = new File(pathT);
				namesFilesT = filesOnDir.list();
				for (String list : namesFilesT) {
						lengthArrayT++;
					}
            }
			
		public void showReadingDialog(String pathTR) {
			    
				TextView newTaskReader = new TextView(this);
				newTaskReader.setText(Entry.readEntry(pathTR));
				final AlertDialog.Builder ratingdialog = new AlertDialog.Builder(this);
				ratingdialog.setTitle("new Task");
				ratingdialog.setView(newTaskReader); 
				ratingdialog.setNegativeButton("Отмена",
                    new DialogInterface.OnClickListener() {
							public void onClick(DialogInterface dialog, int id) {
									dialog.cancel();
								}
						});

				ratingdialog.create();
				ratingdialog.show();
			}
			
			void showPopupMenu(int id, final String  pathTsk, View v){
					PopupMenu popupMenu = new PopupMenu(this, v);
					//получаем всплывающее меня из xml файла
					popupMenu.inflate(R.menu.popupmenu);
					if (id == POP_TASK){
					popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {					
								@Override
								public boolean onMenuItemClick(MenuItem item) {
										switch (item.getItemId()) {
												case R.id.menu1://read
													showReadingDialog(pathTsk);
													return true;
											
													case R.id.menu2://delete
													deleteElemDiary(pathTsk);
													createButtonListT();
													return true;
												
													case R.id.menu3://edit
													showRatingDialog(pathTsk,EDIT_TASK);
													createButtonListT();
													return true;
		
												default:
													return false;
											}
									}
							});
}
					if (id == POP_ENTRY){
							popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {					
										@Override
										public boolean onMenuItemClick(MenuItem item) {
												switch (item.getItemId()) {
														case R.id.menu1://read
															showReadingDialog(pathTsk);
															return true;

														case R.id.menu2://delete
															deleteElemDiary(pathTsk);
															borderMin=0;
															readInterface();
															messToast("и шо за фигня");
															return true;

														case R.id.menu3://edit
															showRatingDialog(pathTsk,EDIT_TASK);
															borderMin=0;
															readInterface();
															return true;

														default:
															return false;
													}
											}
									});
						}
					/*popupMenu.setOnDismissListener(new PopupMenu.OnDismissListener() {

								@Override
								public void onDismiss(PopupMenu menu) {
										Toast.makeText(getApplicationContext(), "onDismiss",
													   Toast.LENGTH_SHORT).show();
									}
							});*/
					popupMenu.show();
			}
			
          void deleteElemDiary(String path){
				  File file = new File(path);
				  if(file.delete()){
						  messToast(path +" deleted");
					  }else messToast(path+" not found");
		  }
		void setVisibleElems(){
				layoutTask.setVisibility(View.GONE);
				readLayout.setVisibility(View.GONE);
		}
		
			  
}
