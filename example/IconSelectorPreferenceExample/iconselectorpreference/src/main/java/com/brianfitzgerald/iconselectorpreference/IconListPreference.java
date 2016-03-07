package com.brianfitzgerald.iconselectorpreference;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.preference.ListPreference;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by brianfitzgerald on 2/8/16.
 */
public class IconListPreference extends ListPreference {
    private static final String TAG = IconListPreference.class.getSimpleName();

    private TextView summaryTextView;
    IconListPreferenceAdapter iconListPreferenceAdapter;

    private ArrayList<IconOption> selectedOptions;

    public void setIconEnums(IconOption[] enums) {
        selectedOptions = new ArrayList<>(Arrays.asList(enums));
    }

    public IconListPreference(Context context) {
        super(context);
    }

    public IconListPreference(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public IconListPreference(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public IconListPreference(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    protected void onBindView(View view) {
        super.onBindView(view);
        summaryTextView = (TextView) view.findViewById(android.R.id.summary);
    }

    @Override
    protected void onDialogClosed(boolean positiveResult) {
        super.onDialogClosed(positiveResult);
//        summaryTextView.setText();
    }

    @Override
    protected void onPrepareDialogBuilder(AlertDialog.Builder builder) {
        super.onPrepareDialogBuilder(builder);

        builder.setNegativeButton("Cancel", null);
        builder.setPositiveButton(null, null);


        iconListPreferenceAdapter = new IconListPreferenceAdapter(getContext(), selectedOptions, "Icon");
        builder.setAdapter(iconListPreferenceAdapter, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Log.d(TAG, String.valueOf(which));
            }
        });

    }

    @Override
    public void onDismiss(DialogInterface dialog) {
        super.onDismiss(dialog);
        iconListPreferenceAdapter.setDialogReference(getDialog());
    }

}
