package com.example.uiailatreuphu.dialog_fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.DialogFragment;

import com.example.uiailatreuphu.R;

public class M002_Help_DapAn_Fragment extends DialogFragment implements View.OnClickListener {
    public static final String TAG= M002_Help_DapAn_Fragment.class.getName();
    private TextView tv_resutl;
    private int trueCase;

    public M002_Help_DapAn_Fragment(int trueCase) {
        this.trueCase = trueCase;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.m002_frg_dapan, container, false);
        getDialog().setTitle("Seyirci Joker");

       tv_resutl= view.findViewById(R.id.tv_dapandung);
       if(trueCase==1){
           tv_resutl.setText("A");
       }
       else if(trueCase==2){
            tv_resutl.setText("B");
        }
        else if(trueCase==3){
            tv_resutl.setText("C");
        }
        if(trueCase==4){
            tv_resutl.setText("D");
        }
       view.findViewById(R.id.bt_return).setOnClickListener(this);
       return view;
    }


    @Override
    public void onClick(View view) {
        if(view.getId()==R.id.bt_return){
            getDialog().dismiss();
        }
    }
}
