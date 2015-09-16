package com.ebelli.simpledrawing.dialogs;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;

import com.ebelli.simpledrawing.R;

/**
 * Created by ebelli on 15/09/15.
 */
public class DeleteDrawingDialog extends DialogFragment {

    private DeleteDrawingDialogListener mDeleteDrawingDialogListener;

    public interface DeleteDrawingDialogListener {
        public void onDialogPositiveClick(DialogFragment dialog,String drawing);
        public void onDialogNegativeClick(DialogFragment dialog);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        // Verify that the host activity implements the callback interface
        try {
            // Instantiate the NoticeDialogListener so we can send events to the host
            mDeleteDrawingDialogListener = (DeleteDrawingDialogListener) activity;
        } catch (ClassCastException e) {
            // The activity doesn't implement the interface, throw exception
            throw new ClassCastException(activity.toString()
                    + " must implement DeleteDrawingDialogListener");
        }
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        final String drawing = getArguments().getString("drawing");
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setMessage(R.string.dialog_delete_text)
                .setPositiveButton(R.string.dialog_delete, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        mDeleteDrawingDialogListener.onDialogPositiveClick(DeleteDrawingDialog.this, drawing);
                        dismiss();
                    }
                }).setNegativeButton(R.string.dialog_cancel, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                mDeleteDrawingDialogListener.onDialogNegativeClick(DeleteDrawingDialog.this);
                dismiss();
            }
        });

    return builder.create();
    }
}
