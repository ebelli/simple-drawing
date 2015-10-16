package com.ebelli.stripespike;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.ebelli.stripespike.presenter.MainView;
import com.ebelli.stripespike.presenter.PayPresenterImpl;
import com.stripe.android.*;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements MainView{

    PayPresenterImpl mPayPresenter;

    @InjectView(R.id.etNumber) EditText etNumber;
    @InjectView(R.id.etExpYear) EditText etExpYear;
    @InjectView(R.id.etExpMonth) EditText etExpMonth;
    @InjectView(R.id.etCVC) EditText etCVC;
    @InjectView(R.id.btnPay) Button btnPay;

    @OnClick(R.id.btnPay)
    public void pay(){
        mPayPresenter.sendPayment(etNumber.getText().toString(),
                Integer.valueOf(etExpMonth.getText().toString()),
                Integer.valueOf(etExpYear.getText().toString()),
                etCVC.getText().toString());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);
        mPayPresenter = new PayPresenterImpl(this);
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

    @Override
    public void showError(Exception error) {
        Toast.makeText(getApplicationContext(),
                error.getLocalizedMessage(),
                Toast.LENGTH_LONG
        ).show();
    }
}
