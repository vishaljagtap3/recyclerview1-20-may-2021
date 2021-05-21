package in.bitcode.recyclerview1;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CitiesAdapter extends RecyclerView.Adapter<CitiesAdapter.CityViewHolder> {

    private Context mContext;
    //private String[] mArrCities;
    private ArrayList<String> mListCities;

    class CityViewHolder extends RecyclerView.ViewHolder {

        public TextView mTxtCity;

        public CityViewHolder(@NonNull View itemView) {
            super(itemView);
            mTxtCity = (TextView) itemView;

            mTxtCity.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(
                            mContext,
                            "City clicked - " + mListCities.get(getAdapterPosition()),
                            Toast.LENGTH_LONG
                    ).show();
                }
            });
        }
    }

    public CitiesAdapter(Context context, /*String[] arrCities*/ ArrayList<String> listCities) {
        mContext = context;
        //mArrCities = arrCities;
        mListCities = listCities;
    }

    @Override
    public int getItemCount() {
        //Log.e("tag", "getItemCount " + mArrCities.length);
       /* if (mArrCities == null) {
            return 0;
        }
        return mArrCities.length;*/

        if (mListCities == null) {
            return 0;
        }

        return mListCities.size();
    }

    @NonNull
    @Override
    public CityViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        Log.e("tag", "onCreateViewHolder");

        TextView txtCity = new TextView(mContext);
        txtCity.setTextSize(30);
        txtCity.setPadding(20, 10, 20, 10);

        return new CityViewHolder(txtCity);
    }

    @Override
    public void onBindViewHolder(@NonNull CitiesAdapter.CityViewHolder holder, int position) {
        Log.e("tag", "onBindViewHolder -- " + position);
        //holder.mTxtCity.setText(mArrCities[position]);
        holder.mTxtCity.setText(mListCities.get(position));

        //not the right place to setup listener to the view
        /*holder.mTxtCity.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext, "City Clicked! " + mListCities.get(position), Toast.LENGTH_LONG).show();
            }
        });*/
    }
}
