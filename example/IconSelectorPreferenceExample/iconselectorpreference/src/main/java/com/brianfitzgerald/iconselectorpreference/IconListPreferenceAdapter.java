package com.brianfitzgerald.iconselectorpreference;

import android.app.Dialog;
import android.content.Context;
import android.preference.PreferenceManager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;

/**
 * Created by brianfitzgerald on 2/8/16.
 */
class IconListPreferenceAdapter extends BaseAdapter {
    private static final String TAG = IconListPreferenceAdapter.class.getSimpleName();

    public Dialog dialog;


    String selectedIcon;

    private Context context;
    private ArrayList<IconOption> iconOptions;
    private String preferenceKey;

    public IconListPreferenceAdapter(Context context, ArrayList<IconOption> iconOptions, String preferenceKey) {
        this.iconOptions = iconOptions;
        this.context = context;
        this.preferenceKey = preferenceKey;
        selectedIcon = this.getSelectedIconInPreferences();
    }


    @Override
    public int getCount() {
        return iconOptions.size();
    }

    @Override
    public Object getItem(int position) {
        return iconOptions.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }


    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        final IconListCell iconListCell;

        if (convertView == null) {
            iconListCell = new IconListCell(parent.getContext());
        } else {
            iconListCell = (IconListCell) convertView;
        }

        iconListCell.setViewData(iconOptions.get(position), iconOptions.get(position).getName().equals(selectedIcon));

        View.OnClickListener dialogItemClickListener = new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }

        };

        iconListCell.setOnClickListener(dialogItemClickListener);

        return iconListCell;

    }

    public void setDialogReference(Dialog dialog) {
    }

    public String getSelectedIconInPreferences() {
        PreferenceManager.getDefaultSharedPreferences(context).getString(preferenceKey, "Happy");
        return selectedIcon;
    }
}

