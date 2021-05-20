package in.bitcode.recyclerview1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerCities;
    private String [] mArrCities = {
            "Pune1", "Mumbai1", "Chennai1", "Delhi1", "Kolkata1", "Benguluru1", "Jaipur1", "Nagpur1", "Nashik1", "Kolhapur1",
            "Pune2", "Mumbai2", "Chennai2", "Delhi2", "Kolkata2", "Benguluru2", "Jaipur2", "Nagpur2", "Nashik2", "Kolhapur2",
            "Pune3", "Mumbai3", "Chennai3", "Delhi3", "Kolkata3", "Benguluru3", "Jaipur3", "Nagpur3", "Nashik3", "Kolhapur3",
    };
    private CitiesAdapter mCitiesAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    }

    private void init() {
        mRecyclerCities = findViewById(R.id.recyclerCities);
        LinearLayoutManager linearLayoutManager =
                new LinearLayoutManager(
                        this,
                        LinearLayoutManager.HORIZONTAL,
                        false
                        );
        mRecyclerCities.setLayoutManager(linearLayoutManager);

        mCitiesAdapter = new CitiesAdapter(this, mArrCities);
        mRecyclerCities.setAdapter(mCitiesAdapter);
    }
}