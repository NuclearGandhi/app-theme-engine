package com.afollestad.appthemeengine.prefs.supportv7;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.support.v7.preference.PreferenceCategory;
import android.support.v7.preference.PreferenceViewHolder;
import android.util.AttributeSet;
import android.widget.TextView;

import com.afollestad.appthemeengine.ATE;
import com.afollestad.appthemeengine.Config;
import com.afollestad.appthemeengine.R;

public class ATEPreferenceCategory extends PreferenceCategory {

    private String mAteKey;

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public ATEPreferenceCategory(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
        mAteKey = context.getTheme().obtainStyledAttributes(attrs, R.styleable.ATEPreferenceCategory, 0, 0).getString(R.styleable.ATEPreferenceCategory_ateKey_prefCategory_textColor);
    }

    public ATEPreferenceCategory(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
        mAteKey = context.getTheme().obtainStyledAttributes(attrs, R.styleable.ATEPreferenceCategory, 0, 0).getString(R.styleable.ATEPreferenceCategory_ateKey_prefCategory_textColor);

    }

    public ATEPreferenceCategory(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
        mAteKey = context.getTheme().obtainStyledAttributes(attrs, R.styleable.ATEPreferenceCategory, 0, 0).getString(R.styleable.ATEPreferenceCategory_ateKey_prefCategory_textColor);

    }

    private void init() {
        setLayoutResource(R.layout.ate_preference_category);
    }

    @Override
    public void onBindViewHolder(PreferenceViewHolder holder) {
        super.onBindViewHolder(holder);
        TextView mTitle = (TextView) holder.itemView;
        mTitle.setTextColor(Config.accentColor(getContext(), null));
        ATE.themeView(holder.itemView, mAteKey);
    }
}
