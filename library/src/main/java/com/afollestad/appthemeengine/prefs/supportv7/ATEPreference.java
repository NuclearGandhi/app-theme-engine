package com.afollestad.appthemeengine.prefs.supportv7;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.support.v7.preference.Preference;
import android.support.v7.preference.PreferenceViewHolder;
import android.util.AttributeSet;

import com.afollestad.appthemeengine.ATE;
import com.afollestad.appthemeengine.R;


/**
 * @author Aidan Follestad (afollestad)
 */
public class ATEPreference extends Preference {

    private String mKey;

    public ATEPreference(Context context) {
        super(context);
        init(context, null);
    }

    public ATEPreference(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public ATEPreference(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public ATEPreference(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        setLayoutResource(R.layout.ate_preference);

        if (attrs != null) {
            TypedArray a = context.getTheme().obtainStyledAttributes(attrs, R.styleable.ATEPreference, 0, 0);
            try {
                mKey = a.getString(R.styleable.ATEPreference_ateKey_pref);
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