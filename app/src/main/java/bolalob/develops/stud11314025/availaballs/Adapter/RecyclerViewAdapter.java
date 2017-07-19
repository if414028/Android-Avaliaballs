package bolalob.develops.stud11314025.availaballs.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import bolalob.develops.stud11314025.availaballs.Activity.DetailLapanganActivity;
import bolalob.develops.stud11314025.availaballs.Model.Lapangan;
import bolalob.develops.stud11314025.availaballs.R;

/**
 * Created by Okta on 19/06/2017.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
    private List<Lapangan> lapangans;


    Context c;


    public RecyclerViewAdapter(Context c, List<Lapangan> inputdata) {
        this.c = c;
        lapangans = inputdata;
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView tvNo;
        public TextView tvNamaLapangan;
        public TextView tvLokasi;
        private ItemClickListener itemClickListener;

        public ViewHolder(View itemView) {
            super(itemView);
            tvNo = (TextView) itemView.findViewById(R.id.tvNo);
            tvNamaLapangan = (TextView) itemView.findViewById(R.id.tvNamaLapangan);
            tvLokasi = (TextView) itemView.findViewById(R.id.tvLokasi);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            this.itemClickListener.onItemClick(view, getLayoutPosition());
        }

        public void setItemClickListener(ItemClickListener ic) {
            this.itemClickListener = ic;

        }
    }

    @Override
    public RecyclerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // membuat view baru
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.listlapangan_item, parent, false);
        // mengeset ukuran view, margin, padding, dan parameter layout lainnya
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(final RecyclerViewAdapter.ViewHolder holder, int position) {
        final String NamaLap = lapangans.get(position).getFieldName().toString();
        final String Location = lapangans.get(position).getLocation().toString();
        final String Photo = lapangans.get(position).getPhoto().toString();
        final String PhoneNum = lapangans.get(position).getPhoneNumber().toString();
        final String Number = lapangans.get(position).getNumberOfField().toString();
        final String OpeningHour = lapangans.get(position).getOpeningHours().toString();
        final String ClosingHour = lapangans.get(position).getClosingHours().toString();
        final String Price = lapangans.get(position).getPrice().toString();
        holder.tvNo.setText(lapangans.get(position).getIdFutsalField().toString());
        holder.tvNamaLapangan.setText(lapangans.get(position).getFieldName().toString());
        holder.tvLokasi.setText(lapangans.get(position).getLocation().toString());
        holder.setItemClickListener(new ItemClickListener() {
            @Override
            public void onItemClick(View v, int pos) {
                Intent i = new Intent(c, DetailLapanganActivity.class);
                i.putExtra("NAMALAP_KEY", NamaLap);
                i.putExtra("LOKASI_KEY", Location);
                i.putExtra("PHOTO_KEY", Photo);
                i.putExtra("PHONENUM_KEY", PhoneNum);
                i.putExtra("JUMLAHLAP_KEY", Number);
                i.putExtra("OPENHOUR_KEY", OpeningHour);
                i.putExtra("CLOSEHOUR_KEY", ClosingHour);
                i.putExtra("PRICE_KEY", Price);
                c.startActivity(i);
            }
        });


    }


    @Override
    public int getItemCount() {
        return lapangans.size();
    }


}
