package vn.edu.hcmuaf.fit.fragmenttestapp;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements DataUpdateListener {

    FragmentBottom fragmentBottom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentBottom = (FragmentBottom) getSupportFragmentManager().findFragmentByTag("fragment_bottom");

        if (fragmentBottom == null) {
            fragmentBottom = new FragmentBottom();
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.fragment_bottom_container, fragmentBottom)
                    .commit();
        }
        else {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_bottom_container, fragmentBottom)
                    .commit();
        }
    }

    @Override
    public void onDataUpdate(Bundle data) {
        fragmentBottom.updateData(data);
    }
}