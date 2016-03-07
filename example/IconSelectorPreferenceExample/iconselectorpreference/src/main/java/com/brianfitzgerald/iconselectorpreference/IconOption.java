package com.brianfitzgerald.iconselectorpreference;

import android.support.annotation.DrawableRes;

/**
 * Created by brianfitzgerald on 3/6/16.
 */
public enum IconOption {
    HAPPY(R.drawable.happy, "Happy"),
    SAD(R.drawable.sad, "Sad"),
    CONFUSED(R.drawable.confused, "Confused");

    @DrawableRes private int iconDrawable;
    private String name;

    IconOption(int iconDrawable, String name) {
        this.iconDrawable = iconDrawable;
        this.name = name;
    }

    public int getIconDrawable() {
        return iconDrawable;
    }

    public void setIconDrawable(int iconDrawable) {
        this.iconDrawable = iconDrawable;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
