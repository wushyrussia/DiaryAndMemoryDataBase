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
	//setArticle(setTag(text),tvContent);
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
				entr = entr+docArray[i];
			}
			Spannable entry = new SpannableString(entr);
			entry.setSpan(new RelativeSizeSpan(1.1f), 0, entry.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
			entry.setSpan(new ForegroundColorSpan(Color.BLACK), 0, entry.length(),  Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
			//Spannable entry = new SpannableString
			tv.setText((Spanned) TextUtils.concat(header,dateTime,entry));
		//return  doc;
	}
	public void setArticle(String text,TextView tvContent) {
				if (text == null) text = "Article not found";

			Spanned spannedText = Html.fromHtml(text, htmlImageGetter, htmlTagHandler);
				Spannable reversedText = revertSpanned(spannedText);

				tvContent.setText(reversedText);
			}

		final Spannable revertSpanned(Spanned stext) {
				Object[] spans = stext.getSpans(0, stext.length(), Object.class);
				Spannable ret = Spannable.Factory.getInstance().newSpannable(stext.toString());
				if (spans != null && spans.length > 0) {
						for(int i = spans.length - 1; i >= 0; --i) {
								ret.setSpan(spans[i], stext.getSpanStart(spans[i]), stext.getSpanEnd(spans[i]), stext.getSpanFlags(spans[i]));
							}
					}

				return ret;
			}

		Html.ImageGetter htmlImageGetter = null; /*new Html.ImageGetter() {
				public Drawable getDrawable(String source) {
						int resId = getResources().getIdentifier(source, "drawable", getPackageName());
						Drawable ret = ReadActivity.class.getResources().getDrawable(resId);
						ret.setBounds(0, 0, ret.getIntrinsicWidth(), ret.getIntrinsicHeight());
						return ret;
					}
			};*/

		Html.TagHandler htmlTagHandler = new Html.TagHandler() {
				public void handleTag(boolean opening, String tag, Editable output,	XMLReader xmlReader) {
						Object span = null;
						//if (tag.startsWith("article_")) span = new ArticleSpan(ReadActivity.class, tag);
					//	else if ("title".equalsIgnoreCase(tag)) span = new AppearanceSpan(0xffff2020, AppearanceSpan.NONE, 20, true, true, false, false);
					//	else if (tag.startsWith("color_")) span = new ParameterizedSpan(tag.substring(6));
						if (span != null) processSpan(opening, output, span);
					}
			};

		void processSpan(boolean opening, Editable output, Object span) {
				int len = output.length();
				if (opening) {
						output.setSpan(span, len, len, Spannable.SPAN_MARK_MARK);
					} else {
						Object[] objs = output.getSpans(0, len, span.getClass());
						int where = len;
						if (objs.length > 0) {
								for(int i = objs.length - 1; i >= 0; --i) {
										if (output.getSpanFlags(objs[i]) == Spannable.SPAN_MARK_MARK) {
												where = output.getSpanStart(objs[i]);
												output.removeSpan(objs[i]);
												break;
											}
									}
							}

						if (where != len) {
								output.setSpan(span, where, len, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
							}
					}
			} 

 /*class ArticleSpan extends ClickableSpan {

		final ReadActivity activity ;
		final String articleId;

		public ArticleSpan(Activity activity, String articleId) {
				super();
				activity = activity;
				this.articleId = articleId;
			}

		@Override
		public void onClick(View arg0) {
				activity.setArticle(articleId);
			}*/

	}
