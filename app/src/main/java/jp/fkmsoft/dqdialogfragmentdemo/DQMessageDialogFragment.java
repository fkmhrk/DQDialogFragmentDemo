package jp.fkmsoft.dqdialogfragmentdemo;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.Fragment;
import android.content.DialogInterface;
import android.os.Bundle;

/**
 * Dialog for displaying message
 */
public class DQMessageDialogFragment extends DialogFragment {
    public static DQMessageDialogFragment newInstance(Fragment target, int requestCode) {
        DQMessageDialogFragment fragment = new DQMessageDialogFragment();
        fragment.setTargetFragment(target, requestCode);

        Bundle args = new Bundle();
        fragment.setArguments(args);

        return fragment;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Activity activity = getActivity();
        if (activity == null) { return null; }

        setCancelable(false);

        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        builder.setMessage(R.string.cannot_cancel);
        builder.setPositiveButton(android.R.string.ok, mClickListener);
        builder.setNegativeButton(android.R.string.cancel, mClickListener);
        return builder.create();
    }

    private final DialogInterface.OnClickListener mClickListener = new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialogInterface, int which) {
            if (which == DialogInterface.BUTTON_POSITIVE) {
                submit();
            } else {
                showCancelDialog();
            }
        }
    };

    private void submit() {
        DQDialogFragment dialog = DQDialogFragment.newInstance(getTargetFragment(), getTargetRequestCode());
        dialog.show(getFragmentManager(), null);
    }

    private void showCancelDialog() {
        DQMessageDialogFragment dialog = DQMessageDialogFragment.newInstance(getTargetFragment(), getTargetRequestCode());
        dialog.show(getFragmentManager(), null);
    }
}
