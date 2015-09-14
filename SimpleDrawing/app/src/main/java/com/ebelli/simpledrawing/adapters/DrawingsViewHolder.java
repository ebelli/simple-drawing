package com.ebelli.simpledrawing.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.ebelli.simpledrawing.R;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by ebelli on 11/09/15.
 */
public class DrawingsViewHolder extends RecyclerView.ViewHolder {
    @InjectView(R.id.ivDrawing)  ImageView ivDrawing;
//    @InjectView(R.id.tvTitle) TextView tvTitle;

    public DrawingsViewHolder(View itemView) {
        super(itemView);
        ButterKnife.inject(this,itemView);
    }



}
