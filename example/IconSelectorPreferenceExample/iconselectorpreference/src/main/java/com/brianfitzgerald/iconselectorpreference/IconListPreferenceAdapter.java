package com.brianfitzgerald.iconselectorpreference;

import android.app.Dialog;
import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;

import java.util.ArrayList;

/**
 * Created by brianfitzgerald on 2/8/16.
 */
class IconListPreferenceAdapter extends BaseAdapter {
    private static final String TAG = IconListPreferenceAdapter.class.getSimpleName();

    CharSequence[] iconNames;
    CharSequence[] iconValues;
    CharSequence[] fileNames;

    public Dialog dialog;

    private Context context;

    ArrayList<Boolean> checkedStatuses;

    public IconListPreferenceAdapter(Context context, CharSequence[] iconNames, CharSequence[] iconValues, CharSequence[] fileNames, ArrayList<Boolean> checkedStatuses) {
        this.checkedStatuses = checkedStatuses;
        this.iconNames = iconNames;
        this.iconValues = iconValues;
        this.fileNames = fileNames;
        this.context = context;
        Log.d(TAG, "adapter create");
    }

    @Override
    public int getCount() {
        return checkedStatuses.size();
    }

    @Override
    public Object getItem(int position) {
        return checkedStatuses.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        RelativeLayout layout = new IconListCell(context, position, fileNames, iconNames, checkedStatuses);

        View.OnClickListener dialogItemClickListener = new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                for (int i = 0; i < checkedStatuses.size(); i++) {
                    checkedStatuses.set(i, i == position);
                }
                dialog.dismiss();
            }

        };

        layout.setOnClickListener(dialogItemClickListener);

        return layout;

    }

    public void setDialogReference(Dialog dialog) {
        this.dialog = dialog;
    }

}

