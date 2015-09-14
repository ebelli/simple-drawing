package com.ebelli.simpledrawing;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import butterknife.ButterKnife;
import butterknife.InjectView;
import yuku.ambilwarna.AmbilWarnaDialog;

public class DrawActivity extends AppCompatActivity {

    @InjectView(R.id.drawView) DrawView drawView;
    AmbilWarnaDialog colorPicker;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_draw);
        ButterKnife.inject(this);
        colorPicker = new AmbilWarnaDialog(this, Color.BLACK, new AmbilWarnaDialog.OnAmbilWarnaListener() {
            @Override
            public void onOk(AmbilWarnaDialog dialog, int color) {
                drawView.setColor(color);
            }

            @Override
            public void onCancel(AmbilWarnaDialog dialog) {
                // do nothing
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_draw, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_colorpicker) {
            colorPicker.show();
            return true;
        } else if (id == R.id.action_save) {
            drawView.setDrawingCacheEnabled(true);
            Bitmap b = Bitmap.createBitmap(drawView.getDrawingCache());
            drawView.setDrawingCacheEnabled(false);
            try {
                String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
                if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)){
                    File file = new File(Environment.getExternalStoragePublicDirectory(
                            Environment.DIRECTORY_PICTURES), Utilities.STORAGE_DIR);
                    if (!file.exists()){
                        if (!file.mkdirs()) {
                            Log.e("SimpleDrawning", "Directory not created");
                        }
                    }
                    FileOutputStream fos = new FileOutputStream(file.getAbsolutePath() + "/" + timeStamp + ".jpg");
                    if (!b.compress(Bitmap.CompressFormat.JPEG, 85, fos)){
                        Log.e("SimpleDrawning", "Compress failed");
                    }
                    fos.flush();
                    fos.close();
                    finish();
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else if (id == R.id.action_clear) {
            drawView.clear();
        }

        return super.onOptionsItemSelected(item);
    }
}
