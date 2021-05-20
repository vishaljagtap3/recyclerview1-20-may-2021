package in.bitcode.recyclerview1;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CitiesAdapter extends RecyclerView.Adapter<CitiesAdapter.CityViewHolder> {

    private Context mContext;
    private String[] mArrCities;

    class CityViewHolder extends RecyclerView.ViewHolder {

        public TextView mTxtCity;

        public CityViewHolder(@NonNull View itemView) {
            super(itemView);
            mTxtCity = (TextView) itemView;
        }
    }

    public CitiesAdapter(Context context, String[] arrCities) {
        mContext = context;
        mArrCities = arrCities;
    }

    @Override
    public int getItemCount() {
        //Log.e("tag", "getItemCount " + mArrCities.length);
        if (mArrCities == null) {
            return 0;
        }

        return mArrCities.length;
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
        holder.mTxtCity.setText(mArrCities[position]);
    }
}
