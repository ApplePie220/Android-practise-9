package ru.mirea.survillo.mireaproject.ui.brawlers;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import ru.mirea.survillo.mireaproject.R;

public class BrawlersAdapter extends RecyclerView.Adapter<BrawlersAdapter.BrawlersViewHolder>{
    private List<Brawlers> brawlers;

    public BrawlersAdapter(List<Brawlers> brawlers){
        this.brawlers = brawlers;
    }

    @NonNull
    @Override
    public BrawlersAdapter.BrawlersViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View cardView = LayoutInflater.from(parent.getContext()).inflate(R.layout.brawlers_list, parent, false);

        return new BrawlersAdapter.BrawlersViewHolder(cardView);
    }

    @Override
    public void onBindViewHolder(@NonNull BrawlersAdapter.BrawlersViewHolder holder, int position) {
        Brawlers brawler = brawlers.get(position);
        holder.name.setText(brawler.name);
        holder.type.setText(brawler.type);
        holder.level.setText(brawler.level);
    }

    @Override
    public int getItemCount() {
        return brawlers.size();
    }

    public static class BrawlersViewHolder extends RecyclerView.ViewHolder{
        public final TextView name;
        public final TextView type;
        public final TextView level;

        public BrawlersViewHolder(@NonNull View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.nameBrawler);
            type = (TextView) itemView.findViewById(R.id.typeBrawler);
            level = (TextView) itemView.findViewById(R.id.levelBrawler);
        }
    }
}
