package com.afollestad.appthemeengine.prefs.supportv7;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.v7.preference.ListPreference;
import android.support.v7.preference.PreferenceViewHolder;
import android.util.AttributeSet;

import com.afollestad.appthemeengine.ATE;
import com.afollestad.appthemeengine.R;


/**
 * @author Aidan Follestad (afollestad)
 */
public class ATEListPreference extends ListPreference {

    private String mKey;

    public ATEListPreference(Context context) {
        super(context);
        init(context, null);
    }

    public ATEListPreference(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public ATEListPreference(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    public ATEListPreference(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        setLayoutResource(R.layout.ate_preference);
        if (getSummary() == null || getSummary().toString().trim().isEmpty())
            setSummary("%s");

        if (attrs != null) {
            TypedArray a = context.getTheme().obtainStyledAttributes(attrs, R.styleable.ATEListPreference, 0, 0);
            try {
                mKey = a.getString(R.styleable.ATEListPreference_ateKey_pref_list);
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
