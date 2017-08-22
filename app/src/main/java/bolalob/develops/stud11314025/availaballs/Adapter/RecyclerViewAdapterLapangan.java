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

public class RecyclerViewAdapterLapangan extends RecyclerView.Adapter<RecyclerViewAdapterLapangan.ViewHolder> {

    private List<Lapangan> lapangan;
    int i=1;

    public void setLapangan(List<Lapangan> lapangan) {
        this.lapangan = lapangan;
    }

    public void clear() {
        int size = this.lapangan.size();
        this.lapangan.clear();
        notifyItemRangeRemoved(0, size);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_lapangan_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final Context context = holder.itemView.getContext();
        final int IdLapangan = lapangan.get(position).getIdFutsalField();
        final String NamaLap = lapangan.get(position).getFieldName().toString();
        final String Location = lapangan.get(position).getLocation().toString();
        holder.tvNo.setText(Integer.toString(i++));
        holder.tvNamaLapangan.setText(lapangan.get(position).getFieldName().toString());
        holder.tvLokasi.setText(lapangan.get(position).getLocation().toString());
        holder.setItemClickListener(new ItemClickListener() {
            @Override
            public void onItemClick(View v, int pos) {
                Intent i = new Intent(context, DetailLapanganActivity.class);
                i.putExtra("ID_LAPANGAN_KEY", IdLapangan);
                i.putExtra("NAMALAP_KEY", NamaLap);
                i.putExtra("LOKASI_KEY", Location);
                context.startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return lapangan.size();
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
}