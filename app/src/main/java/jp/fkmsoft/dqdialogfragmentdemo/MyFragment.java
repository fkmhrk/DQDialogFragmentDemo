package jp.fkmsoft.dqdialogfragmentdemo;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

/**
 * Fragment for main page
 */
public class MyFragment extends Fragment {
    private static final int REQUEST_BUY = 1000;

    public static MyFragment newInstance() {
        MyFragment fragment = new MyFragment();

        Bundle args = new Bundle();
        fragment.setArguments(args);

        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_my, container, false);

        root.findViewById(R.id.button_buy).setOnClickListener(mClickListener);
        return root;
    }

    private final View.OnClickListener mClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
            case R.id.button_buy:
                showBuyDialog();
                break;
            }
        }
    };

    private void showBuyDialog() {
        DQDialogFragment dialog = DQDialogFragment.newInstance(this, REQUEST_BUY);
        dialog.show(getFragmentManager(), null);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode) {
        case REQUEST_BUY:
            if (resultCode != Activity.RESULT_OK) { return; }

            Toast.makeText(getActivity(), R.string.bought, Toast.LENGTH_LONG).show();
            return;
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}
