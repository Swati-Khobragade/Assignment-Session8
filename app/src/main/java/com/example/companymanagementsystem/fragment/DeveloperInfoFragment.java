package com.example.companymanagementsystem.fragment;
/**
 * @author Swati Khobragade
 */

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.companymanagementsystem.ManagementApplication;
import com.example.companymanagementsystem.R;
import com.example.companymanagementsystem.adapter.EmployeeListAdapter;
import com.example.companymanagementsystem.model.Employee;
import com.example.companymanagementsystem.model.EmployeeDataHandler;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * to handle interaction events.
 * Use the {@link DeveloperInfoFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DeveloperInfoFragment extends Fragment {
    private ListView empListView;
    private EmployeeListAdapter employeeListAdapter;
    ArrayList<Employee> empData;
    View view;


    /**
     * @return
     */
    public static DeveloperInfoFragment newInstance() {
        DeveloperInfoFragment fragment = new DeveloperInfoFragment();
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
        view = inflater.inflate(R.layout.fragment_developer_info, container, false);
        initViews();
        setAdapter();
        return view;
    }

    /**
     * Initialize the Views
     */
    private void initViews() {
        Log.i("Person List in Frag::", ManagementApplication.personList.toString());
        empListView = view.findViewById(R.id.employeeListview);
    }

    /**
     * Set Adapter to Listview
     */
    private void setAdapter() {
        empData = EmployeeDataHandler.getEmpData();
        Log.d("Employee Data::", empData.toString());
        if (employeeListAdapter == null) {
            employeeListAdapter = new EmployeeListAdapter(getActivity(), empData);
        }
        empListView.setAdapter(employeeListAdapter);
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        Log.i("Low Memory", "Memory too low !!");
    }

}
