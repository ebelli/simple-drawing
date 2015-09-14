package com.ebelli.simpledrawing.adapters;

import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ebelli.simpledrawing.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ebelli on 11/09/15.
 */
public class DrawingsAdapter extends RecyclerView.Adapter<DrawingsViewHolder> {
    private List<String> drawings;

    public DrawingsAdapter() {
        this.drawings = new ArrayList<String>();
    }

    @Override
    public DrawingsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View drawingView = LayoutInflater.from(parent.getContext()).inflate(R.layout.drawing,parent,false);
        return new DrawingsViewHolder(drawingView);
    }

    @Override
    public void onBindViewHolder(DrawingsViewHolder holder, int i) {
        String drawing = drawings.get(i);
      //  holder.tvTitle.setText(drawing);
        holder.ivDrawing.setImageURI(Uri.parse(drawing));
       // Picasso.with(holder.ivDrawing.getContext()).load(drawing).into(holder.ivDrawing);
    }

    @Override
    public int getItemCount() {
        return drawings.size();
    }

    public int add(String drawing){
        drawings.add(drawing);
        return drawings.size();
    }
}
