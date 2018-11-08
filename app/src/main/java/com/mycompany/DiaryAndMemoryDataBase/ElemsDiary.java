package com.mycompany.DiaryAndMemoryDataBase;

import android.graphics.*;
import android.text.*;
import android.text.style.*;
import android.widget.*;
import org.xml.sax.*;

public class ElemsDiary
{
	ElemsDiary(String text, TextView tvContent){
		setTag(text,tvContent);
	}
	private void setTag(String doc, TextView tv){
		String docArray[];
		int ch=0;
			for (String retval : doc.split("\n", doc.length())) {
				ch++;
				}
				docArray = new String[ch];
				ch=0;
			for (String retval : doc.split("\n", doc.length())) {
				   docArray[ch] = retval;
					ch++;
				}
				
			Spannable header = new SpannableString(docArray[0]+"\n");
			header.setSpan(new StyleSpan(Typeface.BOLD), 0, docArray[0].length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
			header.setSpan(new AlignmentSpan.Standard(Layout.Alignment.ALIGN_CENTER),0 ,header.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
			header.setSpan(new RelativeSizeSpan(1.4f), 0, header.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
			header.setSpan(new ForegroundColorSpan(Color.BLACK), 0, header.length(),  Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
			
			Spannable dateTime = new SpannableString("created "+docArray[1]+docArray[2]+"\n\n");
		    dateTime.setSpan(new ForegroundColorSpan(Color.GRAY), 0, docArray[1].length()+docArray[2].length(),  Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
			dateTime.setSpan(new AlignmentSpan.Standard(Layout.Alignment.ALIGN_OPPOSITE),0 ,docArray[2].length()+docArray[1].length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
			
			String entr = "";
			for(int i=3;i!=docArray.length;i++){
				entr = entr+docArray[i]+"\n";
			}
			Spannable entry = new SpannableString(entr);
			entry.setSpan(new RelativeSizeSpan(1.1f), 0, entry.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
			entry.setSpan(new ForegroundColorSpan(Color.BLACK), 0, entry.length(),  Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
			tv.setText((Spanned) TextUtils.concat(header,dateTime,entry));
			tv.clearAnimation();
	}


	}
