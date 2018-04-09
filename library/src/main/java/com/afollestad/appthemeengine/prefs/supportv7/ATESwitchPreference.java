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
import com.afollestad.appthemeengine.inflation.ATESwitch;


/**
 * @author Aidan Follestad (afollestad)
 */
public class ATESwitchPreference extends CheckBoxPreference {

    private String mKey;
    private ATESwitch mSwitch;

    public ATESwitchPreference(Context context) {
        super(context);
        init(context, null);
    }

    public ATESwitchPreference(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public ATESwitchPreference(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public ATESwitchPreference(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        setLayoutResource(R.layout.ate_preference);
        setWidgetLayoutResource(R.layout.ate_preference_switch_support);

        if (attrs != null) {
            TypedArray a = context.getTheme().obtainStyledAttributes(attrs, R.styleable.ATESwitchPreference, 0, 0);
            try {
                mKey = a.getString(R.styleable.ATESwitchPreference_ateKey_pref_switch);
            } finally {
                a.recycle();
            }
        }
    }

    @Override
    public void onBindViewHolder(PreferenceViewHolder holder) {
        super.onBindViewHolder(holder);
        mSwitch = (ATESwitch) holder.findViewById(R.id.switchWidget);
        mSwitch.setChecked(isChecked());
        mSwitch.setKey(mKey);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP)
            mSwitch.setBackground(null);

        ATE.themeView(holder.itemView, mKey);

    }

    @Override
    public void setChecked(boolean checked) {
        super.setChecked(checked);

        if (mSwitch != null) {
            mSwitch.setChecked(checked);
        }
    }
}