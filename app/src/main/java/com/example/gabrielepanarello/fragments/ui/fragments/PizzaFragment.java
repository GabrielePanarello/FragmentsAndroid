package com.example.gabrielepanarello.fragments.ui.fragments;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.gabrielepanarello.fragments.R;
import com.example.gabrielepanarello.fragments.data.Pizza;
import com.example.gabrielepanarello.fragments.logic.Utils;
import com.example.gabrielepanarello.fragments.ui.adapter.CustomArrayAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gabriele Panarello on 22/02/2018.
 */

public class PizzaFragment extends Fragment {

    SelectedListener mCallback;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_layout, container, false);

    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        List<Pizza> pizzaList = new ArrayList<Pizza>(Utils.getPizzaList());

        CustomArrayAdapter adapter = new CustomArrayAdapter(getActivity(), pizzaList);
        ListView listView = (ListView) view.findViewById(R.id.listView);

        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                mCallback.onArticleSelected(position);
            }
        });

    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        // This makes sure that the container activity hasimplemented
        // the callback interface. If not, it throws an exception
        try {
            mCallback = (SelectedListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString() + " must implement SelectedListener");
        }
    }


}
