package com.ebelli.simpledrawing;

import android.app.DialogFragment;
import android.content.Intent;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.ebelli.simpledrawing.adapters.DrawingsAdapter;
import com.ebelli.simpledrawing.dialogs.DeleteDrawingDialog;

import java.io.File;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;


public class MainActivity extends AppCompatActivity implements DeleteDrawingDialog.DeleteDrawingDialogListener{

    private static final int NEW_DRAWING = 1;
    @InjectView(R.id.fabNew) FloatingActionButton fabNew;
    @InjectView(R.id.rvDrawings) RecyclerView rvDrawings;
    @InjectView(R.id.coordinatolayout) CoordinatorLayout coordinatolayout;

    private DrawingsAdapter mAdapterDrawings;

    @OnClick(R.id.fabNew)
    public void newDraw(){
        Intent i = new Intent(this,DrawActivity.class);
        startActivityForResult(i, NEW_DRAWING);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);

        GridLayoutManager mLayoutManager = new GridLayoutManager(this, 2);
        rvDrawings.setLayoutManager(mLayoutManager);

        mAdapterDrawings = new DrawingsAdapter(getFragmentManager());
        File[] drawings = Utilities.getDir().listFiles();
        if (Utilities.getDir().exists()) {
            for (File drawing : drawings) {
                mAdapterDrawings.add(drawing.getAbsolutePath());
            }
        }
        rvDrawings.setAdapter(mAdapterDrawings);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == NEW_DRAWING) {
            // Make sure the request was successful
            if (resultCode == RESULT_OK) {
                //Update Gallery
                mAdapterDrawings.add(data.getStringExtra("file_name"));
                mAdapterDrawings.notifyDataSetChanged();
            }
        }
    }

    @Override
    protected void onResume() {

        super.onResume();
    }

    @Override
    public void onDialogPositiveClick(DialogFragment dialog, String drawing) {
        //Delete the Drawing
        Log.d("Drawing",drawing);
        if (new File(drawing).delete()){
            mAdapterDrawings.remove(drawing);
            Snackbar.make(coordinatolayout,R.string.snackbar_delete_text,Snackbar.LENGTH_SHORT).show();
        } else{
            Snackbar.make(coordinatolayout,R.string.snackbar_delete_failed_text,Snackbar.LENGTH_SHORT).show();
        }
        mAdapterDrawings.notifyDataSetChanged();

    }

    @Override
    public void onDialogNegativeClick(DialogFragment dialog) {
        // Do nothing
    }
/*
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }*/
}
