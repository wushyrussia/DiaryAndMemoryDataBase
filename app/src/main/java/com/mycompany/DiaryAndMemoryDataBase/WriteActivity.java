package com.mycompany.DiaryAndMemoryDataBase;
import android.app.*;
import android.content.*;
import android.os.*;
import android.view.*;
import android.view.View.*;
import android.widget.*;
import com.mycompany.DiaryAndMemoryDataBase.*;
import java.io.*;

public class WriteActivity extends Activity
{
	String paths ="";
    EditText headerText;
//	EditText tagText;
	EditText entryText;
		String path =Environment.getExternalStorageDirectory() + 
		File.separator + "Diary/Data/";;
	EditText entryEditText;
	Button saveButton;
		
		@Override
		public void onCreate(Bundle savedInstanceState)
			{
				super.onCreate(savedInstanceState);
				setContentView(R.layout.write_activity);
				
				 saveButton = (Button) findViewById(R.id.saveButton);
				 headerText = (EditText)findViewById(R.id.header);
			//	 tagText = (EditText)findViewById(R.id.tag);
				 entryText=(EditText)findViewById(R.id.entry);
			  
				 saveButton.setOnClickListener(onClButtonSave);
			}
		OnClickListener onClButtonSave = new OnClickListener() {
				@Override
				public void onClick(View v) {
						writeEntry();
						paths=path+headerText.getText().toString() + ".dbd";
						Intent intent = new Intent (WriteActivity.this, ReadActivity.class);
						intent.putExtra("path",paths);
						startActivity(intent);
						
					
					}
			};
			
		void writeEntry(){

				Entry entr = new Entry();
				try
					{
						entr.createDocument(headerText.getText().toString(),entryText.getText().toString());
		//				entr.createDocument(headerText.getText().toString(),tagText.getText().toString(),entryText.getText().toString());
					
						}
				catch (IOException e)
					{}
			}
}

