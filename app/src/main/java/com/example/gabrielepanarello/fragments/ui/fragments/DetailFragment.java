package com.example.gabrielepanarello.fragments.ui.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.gabrielepanarello.fragments.R;

/**
 * Created by Gabriele Panarello on 22/02/2018.
 */

public class DetailFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        return inflater.inflate(R.layout.detail_layout, container, false);

    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        TextView title = (TextView) view.findViewById(R.id.detailTitle);
        TextView detail = (TextView) view.findViewById(R.id.detailText);
        Bundle bundle = this.getArguments();

        if(bundle != null){
            title.setText(bundle.getString("title"));
            detail.setText(bundle.getString("detail"));
        }

    }


}
