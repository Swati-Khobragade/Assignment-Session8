package com.example.companymanagementsystem.fragment;
/**
 * @author Swati Khobragade
 */

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.companymanagementsystem.R;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * to handle interaction events.
 * Use the {@link OrganisationInfoFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class OrganisationInfoFragment extends Fragment {
    View view;
    ImageView mImageViewIndia;
    ImageView mImageViewUkraine;
    ImageView mImageViewUsa;
    ImageView mImageViewCanada;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment OrganisationInfoFragment.
     */
    public static OrganisationInfoFragment newInstance() {
        OrganisationInfoFragment fragment = new OrganisationInfoFragment();
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
        view = inflater.inflate(R.layout.fragment_organisation_info, container, false);
        initViews();
        return view;
    }

    /**
     * Initialize the views
     */
    private void initViews() {
        mImageViewIndia = view.findViewById(R.id.imageViewIndia);
        mImageViewUkraine = view.findViewById(R.id.imageViewUkraine);
        mImageViewUsa = view.findViewById(R.id.imageViewUSA);
        mImageViewCanada = view.findViewById(R.id.imageViewCanada);

        mImageViewIndia.setImageResource(R.drawable.india);
        mImageViewUkraine.setImageResource(R.drawable.ukraine);
        mImageViewUsa.setImageResource(R.drawable.usa);
        mImageViewCanada.setImageResource(R.drawable.canada);
    }
}
