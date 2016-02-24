package com.brianfitzgerald.iconselectorpreference;

import android.app.Dialog;
import android.content.Context;
import android.util.Log;
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

    private Context context;

    private CharSequence[] titles;
    private ArrayList<Boolean> checkedStatuses;
    private ArrayList<Integer> drawableResources;

    public IconListPreferenceAdapter(Context context, ArrayList<Boolean> checkedStatuses) {
        this.context = context;
        this.checkedStatuses = checkedStatuses;
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

    public void setTitles(CharSequence[] titles) {
        this.titles = titles;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        final IconListCell iconListCell;

        if (convertView == null) {
            iconListCell = new IconListCell(context);
        } else {
            iconListCell = (IconListCell) convertView;
        }

        iconListCell.setViewData(titles[position], drawableResources.get(position), checkedStatuses.get(position));

        View.OnClickListener dialogItemClickListener = new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Log.d(TAG, "clicked");
                dialog.dismiss();
            }

        };

//        iconListCell.setOnClickListener(dialogItemClickListener);

        return iconListCell;

    }

    public void setDialogReference(Dialog dialog) {
        this.dialog = dialog;
    }

}

