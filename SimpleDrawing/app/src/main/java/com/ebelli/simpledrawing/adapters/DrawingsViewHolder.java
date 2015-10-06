package com.ebelli.simpledrawing.adapters;

import android.app.FragmentManager;
import android.support.v7.widget.RecyclerView;
import android.view.ActionMode;
import android.view.View;
import android.widget.ImageView;

import com.ebelli.simpledrawing.R;
import com.ebelli.simpledrawing.presenter.MainActionBarCallBack;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnLongClick;

/**
 * Created by ebelli on 11/09/15.
 */
public class DrawingsViewHolder extends RecyclerView.ViewHolder{
    @InjectView(R.id.ivDrawing)  ImageView ivDrawing;
    String path;
    private FragmentManager mFragmentManager;
    private View mItemView;
    public ActionMode mActionMode;

//    @InjectView(R.id.tvTitle) TextView tvTitle;

    @OnLongClick(R.id.ivDrawing)
    public boolean deleteDrawing(){
        mActionMode = itemView.startActionMode(new MainActionBarCallBack(mFragmentManager,path));
        return true;
    }

    public DrawingsViewHolder(View itemView, FragmentManager fragmentManager) {
        super(itemView);
        mItemView = itemView;
        mFragmentManager = fragmentManager;
        ButterKnife.inject(this,itemView);
    }



}
