package com.example.companymanagementsystem.fragment;
/**
 * @author Swati Khobragade
 */

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.companymanagementsystem.R;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * to handle interaction events.
 * Use the {@link ApplicationVersionFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ApplicationVersionFragment extends Fragment {
    TextView mTextViewAppVersion;
    private View view;
    private PackageManager packageManager;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment ApplicationVersionFragment.
     */
    public static ApplicationVersionFragment newInstance() {
        ApplicationVersionFragment fragment = new ApplicationVersionFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_application_version, container, false);
        initViews();
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setAppVersion();
    }

    /**
     * Set CMSApplication Version to TextView
     */
    private void setAppVersion() {
        packageManager = getActivity().getPackageManager();
        try {
            PackageInfo pInfo = packageManager.getPackageInfo(getActivity().getPackageName(), 0);
            String version = pInfo.versionName;
            int verCode = pInfo.versionCode;
            Log.d("version", String.valueOf(version));
            Log.d("verCode", String.valueOf(verCode));
            mTextViewAppVersion.setText(version);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }

    }

    private void initViews() {
        mTextViewAppVersion = view.findViewById(R.id.appVersionValue);

    }


}
