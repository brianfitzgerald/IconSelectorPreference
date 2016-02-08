package com.brianfitzgerald.iconselectorpreferenceexample;

import android.os.Bundle;
import android.preference.PreferenceFragment;
import android.preference.PreferenceManager;

/**
 * Created by brianfitzgerald on 2/7/16.
 */
public class PreferencesFragment extends PreferenceFragment {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        PreferenceManager.setDefaultValues(getActivity(), R.xml.preferences, false);

        addPreferencesFromResource(R.xml.preferences);
    }
}
