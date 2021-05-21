package in.bitcode.recyclerview1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerCities;
    /*
    private String [] mArrCities = {
            "Pune1", "Mumbai1", "Chennai1", "Delhi1", "Kolkata1", "Benguluru1", "Jaipur1", "Nagpur1", "Nashik1", "Kolhapur1",
            "Pune2", "Mumbai2", "Chennai2", "Delhi2", "Kolkata2", "Benguluru2", "Jaipur2", "Nagpur2", "Nashik2", "Kolhapur2",
            "Pune3", "Mumbai3", "Chennai3", "Delhi3", "Kolkata3", "Benguluru3", "Jaipur3", "Nagpur3", "Nashik3", "Kolhapur3",
    };
     */
    ArrayList<String> mListCities;
    private CitiesAdapter mCitiesAdapter;

    private EditText mEdtCity;
    private Button mBtnAdd, mBtnDelete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

        mBtnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListCities.add(0,mEdtCity.getText().toString());
                //mCitiesAdapter.notifyDataSetChanged();
                //mCitiesAdapter.notifyItemInserted(mListCities.size());
                mCitiesAdapter.notifyItemInserted(0);
            }
        });

        mBtnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = mListCities.indexOf(mEdtCity.getText().toString());
                mListCities.remove(mEdtCity.getText().toString());
                mCitiesAdapter.notifyItemRemoved(position);
            }
        });
    }

    private void init() {
        mRecyclerCities = findViewById(R.id.recyclerCities);
        LinearLayoutManager linearLayoutManager =
                new LinearLayoutManager(
                        this,
                        LinearLayoutManager.VERTICAL,
                        false
                        );
        mRecyclerCities.setLayoutManager(linearLayoutManager);

        mListCities = new ArrayList<String>();
        for(int i = 1; i<= 5; i++) {
            mListCities.add("Pune"+i);
            mListCities.add("Mumbai"+i);
            mListCities.add("Chennai" + i);
            mListCities.add("Delhi" + i);
            mListCities.add("Kolkata" + i);
            mListCities.add("Jaipur" + i);
            mListCities.add("Nagpur" + i);
        }


        //mCitiesAdapter = new CitiesAdapter(this, mArrCities);
        mCitiesAdapter = new CitiesAdapter(this, mListCities);
        mRecyclerCities.setAdapter(mCitiesAdapter);

        mEdtCity = findViewById(R.id.edtCity);
        mBtnAdd = findViewById(R.id.btnAdd);
        mBtnDelete = findViewById(R.id.btnDelete);
    }
}