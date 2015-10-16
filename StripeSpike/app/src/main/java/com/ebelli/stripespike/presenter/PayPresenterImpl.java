package com.ebelli.stripespike.presenter;

import android.widget.Toast;

import com.stripe.android.Stripe;
import com.stripe.android.TokenCallback;

import com.stripe.android.model.Card;
import com.stripe.exception.AuthenticationException;
import com.stripe.model.Token;

/**
 * Created by ebelli on 15/10/15.
 */
public class PayPresenterImpl implements PayPresenter {

    private MainView mMainView;

    public PayPresenterImpl(MainView mainView) {
        mMainView = mainView;
    }

    @Override
    public void sendPayment(String cardNumber, int expMonth, int expYear, String CVC) {
        Card card = new Card(cardNumber, expMonth, expYear, CVC);

        Stripe stripe = null;
        try {
            stripe = new Stripe("111111111111");
           // stripe = new Stripe("pk_test_6pRNASCoBOKtIshFeQd4XMUh");
        } catch (AuthenticationException e) {
            e.printStackTrace();
        }
        if (stripe != null) {
            stripe.createToken(
                    card,
                    new TokenCallback() {
                        @Override
                        public void onSuccess(com.stripe.android.model.Token token) {

                        }
                        public void onError(Exception error) {
                            mMainView.showError(error);
                        }

                    }
            );
        }

    }
}
