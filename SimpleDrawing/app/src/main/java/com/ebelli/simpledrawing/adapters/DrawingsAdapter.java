package com.ebelli.simpledrawing.adapters;

import android.app.FragmentManager;
import android.support.v7.widget.RecyclerView;
import android.view.ActionMode;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.ebelli.simpledrawing.R;
import com.ebelli.simpledrawing.presenter.MainActionBarCallBack;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ebelli on 11/09/15.
 */
public class DrawingsAdapter extends RecyclerView.Adapter<DrawingsViewHolder> {
    private FragmentManager mFragmentManager;
    private List<String> drawings;
    private DrawingsViewHolder mDrawingsViewHolder;
    private MainActionBarCallBack mMainActionBarCallBack;

    public DrawingsAdapter(FragmentManager fragmentManager) {
        mFragmentManager = fragmentManager;
        this.drawings = new ArrayList<String>();
        mMainActionBarCallBack = new MainActionBarCallBack(fragmentManager);
    }

    @Override
    public DrawingsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View drawingView = LayoutInflater.from(parent.getContext()).inflate(R.layout.drawing,parent,false);
        mDrawingsViewHolder = new DrawingsViewHolder(drawingView,mFragmentManager,mMainActionBarCallBack);
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
        ActionMode actionMode =mMainActionBarCallBack.getActionMode();
        if (actionMode != null) {
            actionMode.finish();
        }
    }

}
