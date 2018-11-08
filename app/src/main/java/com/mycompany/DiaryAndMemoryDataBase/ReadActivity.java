package com.mycompany.DiaryAndMemoryDataBase;
import android.app.*;
import android.content.*;
import android.os.*;
import android.widget.*;
import java.util.concurrent.*;

public class ReadActivity extends Activity
{
		TextView entryEditText;
		@Override
		public void onCreate(Bundle savedInstanceState)
			{
				super.onCreate(savedInstanceState);
				setContentView(R.layout.read_activity);
				entryEditText = (TextView)findViewById(R.id.myEntryView);
				entryEditText.setText("loading entry");
					tryConnectToWatch();
				}
				
				void tryConnectToWatch(){
						entryEditText = (TextView)findViewById(R.id.myEntryView);
						Intent intent = getIntent();
						String path = intent.getStringExtra("path");
						String document;
						document = Entry.readEntry((path));
						
						new ElemsDiary(document,entryEditText);
				}
				

}
