package com.example.gabrielepanarello.fragments.ui.activity;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.gabrielepanarello.fragments.R;
import com.example.gabrielepanarello.fragments.logic.Utils;
import com.example.gabrielepanarello.fragments.ui.fragments.DetailFragment;
import com.example.gabrielepanarello.fragments.ui.fragments.PizzaFragment;
import com.example.gabrielepanarello.fragments.ui.fragments.SelectedListener;

public class MainActivity extends Activity implements SelectedListener {
    private int position = 0;
    private Bundle bundle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Utils.init();

        PizzaFragment pizzaFragment = new PizzaFragment();
        DetailFragment detailFragment = new DetailFragment();

        FragmentManager fragmentManager = getFragmentManager();

        if(savedInstanceState != null){
            position = savedInstanceState.getInt("posi",0);
            bundle = savedInstanceState.getBundle("pos");

            bundle.putString("detail", Utils.getPizzaList().get(position).getDescrizione());
            bundle.putString("title", Utils.getPizzaList().get(position).getNome());

            detailFragment.setArguments(bundle);
        }

        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {

            if (savedInstanceState == null) {
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.add(R.id.fragmentContainer, pizzaFragment);
                fragmentTransaction.commit();
            }
            else{
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragmentContainer, pizzaFragment);
                fragmentTransaction.commit();
            }

        } else {

            if(savedInstanceState == null) {

                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.add(R.id.fragmentContainer, pizzaFragment);
                fragmentTransaction.commit();

                FragmentTransaction fragmentTransaction2 = fragmentManager.beginTransaction();
                fragmentTransaction2.add(R.id.detailContainer, detailFragment);
                fragmentTransaction2.commit();
            }
            else{
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragmentContainer, pizzaFragment);
                fragmentTransaction.commit();

                FragmentTransaction fragmentTransaction2 = fragmentManager.beginTransaction();
                fragmentTransaction2.replace(R.id.detailContainer, detailFragment);
                fragmentTransaction2.commit();
            }

        }

    }


    @Override
    public void onSaveInstanceState(Bundle outState) {
        outState.putBundle("pos",this.bundle);
        outState.putInt("posi",this.position);
        super.onSaveInstanceState(outState);
    }

    public void onArticleSelected(int position) {
        // Create new fragment and transaction
        this.position = position;
        DetailFragment detailFragment = new DetailFragment();
        bundle = new Bundle();

        bundle.putString("detail", Utils.getPizzaList().get(position).getDescrizione());
        bundle.putString("title", Utils.getPizzaList().get(position).getNome());
        detailFragment.setArguments(bundle);

        if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE){
            getFragmentManager()
                    .beginTransaction()
                    .replace(R.id.detailContainer, detailFragment)
                    .addToBackStack(null)
                    .commit();
        }else{
            getFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragmentContainer, detailFragment)
                    .addToBackStack(null)
                    .commit();
        }

    }
}
