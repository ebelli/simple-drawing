package com.ebelli.simpledrawing.presenter;

import android.app.DialogFragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;

import com.ebelli.simpledrawing.R;
import com.ebelli.simpledrawing.dialogs.DeleteDrawingDialog;

/**
 * Created by ebelli on 05/10/15.
 */
public class MainActionBarCallBack implements ActionMode.Callback {
    private final FragmentManager mFragmentManager;
    private String mPath;
    private ActionMode mActionMode;

    public MainActionBarCallBack(FragmentManager fragmentManager) {
        mFragmentManager = fragmentManager;
    }

    @Override
    public boolean onCreateActionMode(ActionMode mode, Menu menu) {
        mode.getMenuInflater().inflate(R.menu.menu_main_cab,menu);
        mActionMode = mode;
        return true;
    }

    @Override
    public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
        return false;
    }

    @Override
    public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_delete:
                DialogFragment dialog = new DeleteDrawingDialog();
                Bundle b = new Bundle();
                b.putString("drawing",mPath);
                dialog.setArguments(b);
                dialog.show(mFragmentManager, "DeleteDrawing");
                break;
        }
        return true;
    }

    @Override
    public void onDestroyActionMode(ActionMode mode) {

    }

    public String getPath() {
        return mPath;
    }

    public void setPath(String mPath) {
        this.mPath = mPath;
    }

    public ActionMode getActionMode() {
        return mActionMode;
    }
}
