package com.ebelli.stripespike.presenter;

/**
 * Created by ebelli on 15/10/15.
 */
public interface PayPresenter {

    /**
     * Get the {@code cardNumber},{@code expMonth},{@code expYear},{@code expCVC}, from the view
     * and call the Stripe Service
     */
    void sendPayment(String cardNumber, int expMonth, int expYear, String CVC);

}
