package com.brianfitzgerald.iconselectorpreference;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by brianfitzgerald on 2/8/16.
 */
public class IconListCell extends RelativeLayout {
    private static final String TAG = IconListCell.class.getSimpleName();

    private TextView nameTextView;
    private ImageView iconImageView;
    private RadioButton radioButton;

    int position;

    @LayoutRes
    int cellResource;


    CharSequence[] fileNames;
    CharSequence[] iconNames;
    ArrayList<Boolean> checkedStatuses = new ArrayList<>();

    public IconListCell(Context context, int position, CharSequence[] fileNames, CharSequence[] iconNames, ArrayList<Boolean> checkedStatuses) {
        super(context);

        this.position = position;
        this.fileNames = fileNames;
        this.iconNames = iconNames;
        this.checkedStatuses = checkedStatuses;

        initialize();
    }

    public IconListCell(Context context, AttributeSet attrs) {
        super(context, attrs);
        initialize();
    }

    public IconListCell(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initialize();
    }

    private void initialize() {
        LayoutInflater.from(getContext()).inflate(getResources().getIdentifier("icon_list_cell", "layout", getContext().getApplicationContext().getPackageName()), this);

        nameTextView = (TextView) findViewById(getResources().getIdentifier("iconName", "id", getContext().getApplicationContext().getPackageName()));
        iconImageView = (ImageView) findViewById(getResources().getIdentifier("iconImage", "id", getContext().getApplicationContext().getPackageName()));
        radioButton = (RadioButton) findViewById(getResources().getIdentifier("iconRadio", "id", getContext().getApplicationContext().getPackageName()));

        nameTextView.setText(iconNames[position].toString());

        int identifier = getContext().getResources().getIdentifier(fileNames[position].toString(), "drawable", getContext().getPackageName());
        iconImageView.setImageResource(identifier);

        radioButton.setChecked(checkedStatuses.get(position));


    }
}