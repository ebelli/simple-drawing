package com.ebelli.simpledrawing.adapters;

import android.app.DialogFragment;
import android.app.FragmentManager;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.ebelli.simpledrawing.R;
import com.ebelli.simpledrawing.dialogs.DeleteDrawingDialog;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnLongClick;

/**
 * Created by ebelli on 11/09/15.
 */
public class DrawingsViewHolder extends RecyclerView.ViewHolder {
    @InjectView(R.id.ivDrawing)  ImageView ivDrawing;
    String path;
    private FragmentManager mFragmentManager;

//    @InjectView(R.id.tvTitle) TextView tvTitle;

    @OnLongClick(R.id.ivDrawing)
    public boolean deleteDrawing(){
        DialogFragment dialog = new DeleteDrawingDialog();
        Bundle b = new Bundle();
        b.putString("drawing",path);
        dialog.setArguments(b);
        dialog.show(mFragmentManager, "DeleteDrawing");
        return true;
    }

    public DrawingsViewHolder(View itemView, FragmentManager fragmentManager) {
        super(itemView);
        mFragmentManager = fragmentManager;
        ButterKnife.inject(this,itemView);
    }



}
