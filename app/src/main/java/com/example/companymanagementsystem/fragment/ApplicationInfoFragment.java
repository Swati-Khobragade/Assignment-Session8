package com.example.companymanagementsystem.fragment;
/**
 * @author Swati Khobragade
 */

import android.content.pm.ApplicationInfo;
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
 * Use the {@link ApplicationInfoFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ApplicationInfoFragment extends Fragment {
    TextView mTextViewAppPackName;
    TextView mTextViewAppMinSdk;
    TextView mTextViewTargetSdk;
    View view;
    PackageManager packageManager;


    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment ApplicationInfoFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ApplicationInfoFragment newInstance() {
        ApplicationInfoFragment fragment = new ApplicationInfoFragment();
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
        view = inflater.inflate(R.layout.fragment_application, container, false);
        Log.d("view", view.toString());
        initViews();
        return view;
    }

    /**
     * Initialize the views
     */
    private void initViews() {
        mTextViewAppPackName = view.findViewById(R.id.editTextAppPackName);
        mTextViewAppMinSdk = view.findViewById(R.id.editTextMinSdk);
        mTextViewTargetSdk = view.findViewById(R.id.editTextTargetSdk);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setApplicationInfo();
    }

    /**
     * Set CMSApplication Information to Fields
     */
    private void setApplicationInfo() {
        packageManager = getActivity().getPackageManager();
        ApplicationInfo applicationInfo = null;
        try {
            applicationInfo = packageManager.getApplicationInfo(getActivity().getPackageName(), packageManager.GET_META_DATA);
        } catch (PackageManager.NameNotFoundException e) {
            Log.e("Error ::", e.getMessage());
        }
        Log.d("applicationInfo", String.valueOf(applicationInfo));
        Log.d("applicationInfo1", applicationInfo.packageName);
        Log.d("applicationInfo3", String.valueOf(applicationInfo.minSdkVersion));
        Log.d("applicationInfo4", String.valueOf(applicationInfo.targetSdkVersion));
        mTextViewAppPackName.setText(applicationInfo.packageName);
        mTextViewAppMinSdk.setText(String.valueOf(applicationInfo.minSdkVersion));
        mTextViewTargetSdk.setText(String.valueOf(applicationInfo.targetSdkVersion));
    }
}
