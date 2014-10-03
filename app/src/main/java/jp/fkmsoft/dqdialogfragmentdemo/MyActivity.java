package jp.fkmsoft.dqdialogfragmentdemo;

import android.app.Activity;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;


public class MyActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);

        if (savedInstanceState == null) {
            FragmentTransaction transaction = getFragmentManager().beginTransaction();

            transaction.replace(R.id.container, MyFragment.newInstance());

            transaction.commit();
        }
    }
}
