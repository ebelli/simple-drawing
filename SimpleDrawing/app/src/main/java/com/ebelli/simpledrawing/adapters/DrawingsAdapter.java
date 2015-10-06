package com.ebelli.simpledrawing.adapters;

import android.app.FragmentManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.ebelli.simpledrawing.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ebelli on 11/09/15.
 */
public class DrawingsAdapter extends RecyclerView.Adapter<DrawingsViewHolder> {
    private FragmentManager mFragmentManager;
    private List<String> drawings;
    private DrawingsViewHolder mDrawingsViewHolder;

    public DrawingsAdapter(FragmentManager fragmentManager) {
        mFragmentManager = fragmentManager;
        this.drawings = new ArrayList<String>();
    }

    @Override
    public DrawingsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View drawingView = LayoutInflater.from(parent.getContext()).inflate(R.layout.drawing,parent,false);
        mDrawingsViewHolder = new DrawingsViewHolder(drawingView,mFragmentManager);
        return mDrawingsViewHolder;
    }

    @Override
    public void onBindViewHolder(DrawingsViewHolder holder, int i) {
        String drawing = drawings.get(i);
      //  holder.tvTitle.setText(drawing);
        holder.path = drawing;
       Glide.with(holder.ivDrawing.getContext()).load(drawing).into(holder.ivDrawing);
    }

    @Override
    public int getItemCount() {
        return drawings.size();
    }

    public int add(String drawing){
        drawings.add(drawing);
        return drawings.size();
    }

    public boolean remove (String drawing){
        return drawings.remove(drawing);
    }


    public void closeActionBar(){
        mDrawingsViewHolder.mActionMode.finish();
    }

}
