package com.afollestad.appthemeengine.prefs.supportv7;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.support.v7.preference.CheckBoxPreference;
import android.support.v7.preference.PreferenceViewHolder;
import android.util.AttributeSet;

import com.afollestad.appthemeengine.ATE;
import com.afollestad.appthemeengine.R;

/**
 * @author Aidan Follestad (afollestad)
 */
public class ATECheckBoxPreference extends CheckBoxPreference {

    private String mKey;

    public ATECheckBoxPreference(Context context) {
        super(context);
        init(context, null);
    }

    public ATECheckBoxPreference(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public ATECheckBoxPreference(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public ATECheckBoxPreference(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        setLayoutResource(R.layout.ate_preference);
        setWidgetLayoutResource(R.layout.ate_preference_checkbox);

        if (attrs != null) {
            TypedArray a = context.getTheme().obtainStyledAttributes(attrs, R.styleable.ATEDialogPreference, 0, 0);
            try {
                mKey = a.getString(R.styleable.ATEDialogPreference_ateKey_pref_dialog);
            } finally {
                a.recycle();
            }
        }
    }

    @Override
    public void onBindViewHolder(PreferenceViewHolder holder) {
        super.onBindViewHolder(holder);
        ATE.themeView(holder.itemView, mKey);
    }
}