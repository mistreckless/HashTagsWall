package com.upreckless.support.hashtagswall.util;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.support.annotation.IdRes;
import android.support.annotation.RequiresApi;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.jakewharton.rxbinding2.view.RxView;
import com.upreckless.support.hashtagswall.R;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by @mistreckless on 11.05.2017. !
 */

public class CustomTextView extends RelativeLayout {
    private int mWidth;
    private int tagMargin;
    private int textPaddingLeft;
    private int textPaddingRight;


    private List<Word> words=new ArrayList<>();
    private LayoutInflater inflater;
    private OnWordClickListener listener;
    public CustomTextView(Context context) {
        super(context);
        init(context,null,0,0);
    }

    public CustomTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context,attrs,0,0);
    }

    public CustomTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context,attrs,defStyleAttr,0);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public CustomTextView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(context,attrs,defStyleAttr,defStyleRes);
    }

    public void setListenerOnWordClickListener(OnWordClickListener listener){
        this.listener=listener;
    }

    private void init(Context context,AttributeSet attrs, int defStyle, int defStyleRes) {
        inflater=(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        TypedArray typeArray = context.obtainStyledAttributes(attrs, R.styleable.TextAppearance, defStyle, defStyleRes);
        this.tagMargin = (int) typeArray.getDimension(R.styleable.TagsView_tagMargin, ResolutionUtil.dpToPx(this.getContext(), Constants.DEFAULT_TAG_MARGIN));
        this.textPaddingLeft = (int) typeArray.getDimension(R.styleable.TagsView_textPaddingLeft, ResolutionUtil.dpToPx(this.getContext(), Constants.DEFAULT_TAG_TEXT_PADDING_LEFT));
        this.textPaddingRight = (int) typeArray.getDimension(R.styleable.TagsView_textPaddingRight, ResolutionUtil.dpToPx(this.getContext(), Constants.DEFAULT_TAG_TEXT_PADDING_RIGHT));
        typeArray.recycle();
        mWidth = ResolutionUtil.getScreenWidth(context);
    }

    public void setWords(List<String> list){
        for (String line :
                list) {
            if(!line.isEmpty() && line.length()>1 && line.charAt(0)=='#' && line.substring(1).matches("\\w+"))
                words.add(new Word(line, R.color.tagColorPrimary));
            else words.add(new Word(line, R.color.textColorPrimary));
        }
        drawText();
    }

    private void drawText() {
        if (getVisibility()!=VISIBLE)
            return;
        removeAllViews();
        @IdRes int listIndex=1;
        float total = getPaddingLeft() + getPaddingRight();
        int index_bottom = 1;// The Tag to add below
        int index_header = 1;// The header tag of this line
        for (Word word :
                words) {
            View tagView=inflater.inflate(R.layout.custom_text_view,null);
            tagView.setId(listIndex);
            TextView textView=(TextView)tagView.findViewById(R.id.txt_word);
            textView.setText(word.getText());
            textView.setTextColor(ContextCompat.getColor(getContext(),word.getColor()));
            RxView.clicks(tagView)
                    .debounce(200, TimeUnit.MILLISECONDS)
                    .subscribe(v->listener.onWordClick(word));
            float tagWidth = textView.getPaint().measureText(word.getText()) + textPaddingLeft + textPaddingRight;
            LayoutParams tagParams = new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            //add margin of each line
            if (mWidth <= total + tagMargin + tagWidth + ResolutionUtil.dpToPx(this.getContext(), Constants.LAYOUT_WIDTH_OFFSET)) {
                //need to add in new line
                tagParams.addRule(RelativeLayout.BELOW, index_bottom);
                // initialize total param (layout padding left & layout padding right)
                total = getPaddingLeft() + getPaddingRight();
                index_bottom = listIndex;
                index_header = listIndex;
            } else {
                //no need to new line
                tagParams.addRule(RelativeLayout.ALIGN_TOP, index_header);
                //not header of the line
                if (listIndex != index_header) {
                    tagParams.addRule(RelativeLayout.RIGHT_OF, listIndex - 1);
                    tagParams.leftMargin = tagMargin;
                    total += tagMargin;

                }
            }
            total += tagWidth;
            addView(tagView,tagParams);
            listIndex++;
        }
    }

    public List<Word> getWords(){return words;}

    public void removeAllTags() {
        words.clear();
        drawText();
    }
}
