package com.mycompany.DiaryAndMemoryDataBase;
import android.app.*;
import android.content.*;
import android.graphics.*;
import android.graphics.drawable.*;
import android.os.*;
import android.widget.*;

public class ReadActivity extends Activity
{
		TextView entryEditText;
		@Override
		public void onCreate(Bundle savedInstanceState)
			{
				super.onCreate(savedInstanceState);
				setContentView(R.layout.read_activity);
				
				entryEditText = (TextView)findViewById(R.id.myEntryView);
				
				Intent intent = getIntent();
				String path = intent.getStringExtra("path");
				String document = Entry.readEntry((path));
				//document = setTag(document);
				ElemsDiary elemsDiary = new ElemsDiary(document,entryEditText);
				
				//elemsDiary.setArticle(document);
				//entryEditText.setText(document);
				}
				
}
