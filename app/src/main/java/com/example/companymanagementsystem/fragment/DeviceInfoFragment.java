package com.example.companymanagementsystem.fragment;
/**
 * @author Swati Khobragade
 */

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.companymanagementsystem.R;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * to handle interaction events.
 * Use the {@link DeviceInfoFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DeviceInfoFragment extends Fragment {
    View view;
    private TextView mTextViewSerial;
    private TextView mTextViewModel;
    private TextView mTextViewId;
    private TextView mTextViewManufacturer;
    private TextView mTextViewBrand;
    private TextView mTextViewType;
    private TextView mTextViewUser;
    private TextView mTextViewFingerPrint;
    private TextView mTextViewVersionCode;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment DeviceInfoFragment.
     */
    public static DeviceInfoFragment newInstance() {
        DeviceInfoFragment fragment = new DeviceInfoFragment();
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
        view = inflater.inflate(R.layout.fragment_device_info, container, false);
        initViews();
        setValuesToViews();
        return view;
    }

    private void setValuesToViews() {
        mTextViewSerial.setText(Build.SERIAL);
        mTextViewModel.setText(Build.MODEL);
        mTextViewId.setText(Build.ID);
        mTextViewManufacturer.setText(Build.MANUFACTURER);
        mTextViewBrand.setText(Build.BRAND);
        mTextViewType.setText(Build.TYPE);
        mTextViewUser.setText(Build.USER);
        mTextViewFingerPrint.setText(Build.FINGERPRINT);
        mTextViewVersionCode.setText(String.valueOf(Build.VERSION_CODES.BASE));
    }

    private void initViews() {
        mTextViewSerial = view.findViewById(R.id.textViewSerialVal);
        mTextViewModel = view.findViewById(R.id.textViewModelVal);
        mTextViewId = view.findViewById(R.id.textViewIdVal);
        mTextViewManufacturer = view.findViewById(R.id.textViewManVal);
        mTextViewBrand = view.findViewById(R.id.textViewBrandVal);
        mTextViewType = view.findViewById(R.id.textViewTypeVal);
        mTextViewUser = view.findViewById(R.id.textViewUserVal);
        mTextViewFingerPrint = view.findViewById(R.id.textViewFingerprintVal);
        mTextViewVersionCode = view.findViewById(R.id.textViewVersionCodeVal);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }
}
