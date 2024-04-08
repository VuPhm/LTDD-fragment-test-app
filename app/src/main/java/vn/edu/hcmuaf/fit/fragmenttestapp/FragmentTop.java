package vn.edu.hcmuaf.fit.fragmenttestapp;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

public class FragmentTop extends Fragment {

    String name, year;
    Bundle data;
    EditText inputName, inputYear;
    Button btn;
    DataUpdateListener dataUpdateListener;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof DataUpdateListener) {
            dataUpdateListener = (DataUpdateListener) context;
        } else {
            throw new RuntimeException(context.toString() + "must implement DUL");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_top, container, false);
        inputName = view.findViewById(R.id.input_name);
        inputYear = view.findViewById(R.id.input_year);
        btn = view.findViewById(R.id.btn);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data = new Bundle();
                name = String.valueOf(inputName.getText());
                year = String.valueOf(inputYear.getText());
                data.putString("name", name);
                data.putString("year", year);

                // send
                ((MainActivity) requireActivity()).onDataUpdate(data);
            }
        });
        return view;
    }

}