package com.brianfitzgerald.iconselectorpreference;

import android.content.Context;
import android.support.annotation.DrawableRes;
import android.support.annotation.IdRes;
import android.support.annotation.LayoutRes;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

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

    public IconListCell(Context context) {
        super(context);
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
        LayoutInflater.from(getContext()).inflate(cellResource, this);
    }

    public void setLayoutReferences(@IdRes int nameTextViewId, @IdRes int iconImageViewId, @IdRes int radioButtonViewId) {
        nameTextView = (TextView) findViewById(nameTextViewId);
        iconImageView = (ImageView) findViewById(iconImageViewId);
        radioButton = (RadioButton) findViewById(radioButtonViewId);
    }

    public void setViewData(CharSequence name, @DrawableRes int iconResource, boolean isChecked) {
        nameTextView.setText(name);
        iconImageView.setImageResource(iconResource);
        radioButton.setChecked(isChecked);
    }
}