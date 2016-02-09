package com.brianfitzgerald.iconselectorpreference;

import android.app.AlertDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.ListPreference;
import android.preference.PreferenceManager;
import android.support.annotation.ArrayRes;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by brianfitzgerald on 2/8/16.
 */
public class IconListPreference extends ListPreference {
    private static final String TAG = IconListPreference.class.getSimpleName();

    @ArrayRes
    private int iconFileNamesArray;
    private CharSequence[] iconNames;
    private CharSequence[] iconValues;
    private String iconKey;

    private SharedPreferences preferences;
    private TextView summaryTextView;

    private ArrayList<Boolean> checkedStatuses = new ArrayList<>();

    IconListPreferenceAdapter iconListPreferenceAdapter;

    public IconListPreference(Context context, AttributeSet attrs) {
        super(context, attrs);
        iconKey = getKey();
        preferences = PreferenceManager.getDefaultSharedPreferences(context);
    }

    @Override
    protected void onBindView(View view) {
        super.onBindView(view);
        summaryTextView = (TextView) view.findViewById(android.R.id.summary);
    }

    @Override
    protected void onDialogClosed(boolean positiveResult) {
        super.onDialogClosed(positiveResult);

        if (iconNames != null) {
            for (int i = 0; i < iconNames.length; i++) {
                if (checkedStatuses.get(i)) {

                    SharedPreferences.Editor editor = preferences.edit();
                    editor.putString(iconKey, iconValues[i].toString());
                    summaryTextView.setText(iconValues[i]);
                    editor.apply();

                    break;
                }
            }
        }


    }

    @Override
    protected void onPrepareDialogBuilder(AlertDialog.Builder builder) {

        builder.setNegativeButton("Cancel", null);
        builder.setPositiveButton(null, null);

        iconNames = getEntries();
        iconValues = getEntryValues();


        CharSequence[] fileNames = getContext().getResources().getStringArray(iconFileNamesArray);

        String selectedIcon = PreferenceManager.getDefaultSharedPreferences(getContext()).getString(iconKey, "Undefined");

        if (checkedStatuses.size() != 27) {
            for (int i = 0; i < iconNames.length; i++) {
                boolean isSelected = selectedIcon.equals(fileNames[i]);
                checkedStatuses.add(isSelected);
            }
        }


        iconListPreferenceAdapter = new IconListPreferenceAdapter(getContext(), getEntries(), getEntryValues(), fileNames, this.checkedStatuses);
        builder.setAdapter(iconListPreferenceAdapter, null);
    }

    @Override
    protected void showDialog(Bundle state) {
        super.showDialog(state);
        iconListPreferenceAdapter.setDialogReference(getDialog());
    }
}
