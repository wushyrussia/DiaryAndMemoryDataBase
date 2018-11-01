package com.mycompany.DiaryAndMemoryDataBase;
import android.app.*;
import android.content.*;
import android.os.*;
import android.view.*;
import android.view.View.*;
import android.widget.*;
import java.io.*;

public class TaskWrite extends Activity
{
	EditText taskEdit;
	String task;
	int numberTask = 0;
		@Override
		public void onCreate(Bundle savedInstanceState)
			{
				super.onCreate(savedInstanceState);
				setContentView(R.layout.write_task_activity);

				Button saveButtonTask = (Button) findViewById(R.id.saveButtonTask);
			    taskEdit = (EditText)findViewById(R.id.taskEdit);
                saveButtonTask.setOnClickListener(onClButtonSave);
			}
		OnClickListener onClButtonSave = new OnClickListener() {
				@Override
				public void onClick(View v) {
						try
							{
								writeTask(taskEdit.getText().toString());
							}
						catch (IOException e)
							{}
							Intent intent = new Intent(TaskWrite.this,MainActivity.class);
							startActivity(intent);

					/*	task=Entry.readEntry(path+numberTask.getText().toString() + ".dbd");
						Intent intent = new Intent (TaskWrite.this, ReadActivity.class);
						intent.putExtra("entry",entry);
						startActivity(intent);
						*/


					}
			};
			
			void writeTask(String task) throws IOException{
				

					File fileTask = new File("/storage/64D6-1231/Diary/Data/" +numberTask+".tsk");

					FileWriter writerEntry = new FileWriter(fileTask);
					writerEntry.write(task);

					writerEntry.flush();
					writerEntry.close();
			}
}
