package com.ebelli.simpledrawing;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import com.ebelli.simpledrawing.adapters.DrawingsAdapter;

import java.io.File;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;


public class MainActivity extends AppCompatActivity {

    private static final int NEW_DRAWING = 101;
    @InjectView(R.id.fabNew) FloatingActionButton fabNew;
    @InjectView(R.id.rvDrawings) RecyclerView rvDrawings;
    private GridLayoutManager mLayoutManager;
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

        mLayoutManager = new GridLayoutManager(this,2);
        rvDrawings.setLayoutManager(mLayoutManager);

        mAdapterDrawings = new DrawingsAdapter();
        File[] drawings = Utilities.getDir().listFiles();
        for (File drawing: drawings) {
            mAdapterDrawings.add(drawing.getAbsolutePath());
        }
        rvDrawings.setAdapter(mAdapterDrawings);
    }

    @Override
    protected void onResume() {

        super.onResume();
    }

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
    }
}
