package vn.edu.hcmuaf.fit.fragmenttestapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class FragmentBottom extends Fragment {

    TextView txtName, txtYear;
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_bottom, container, false);
        // link view
        txtName = view.findViewById(R.id.name);
        txtYear = view.findViewById(R.id.year);
        return view;
    }

    public void updateData(Bundle data) {
        // set
        txtName.setText(data.getString("name"));
        txtYear.setText(data.getString("year"));
    }
}