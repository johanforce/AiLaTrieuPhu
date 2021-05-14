package com.example.uiailatreuphu.dialog_fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.fragment.app.DialogFragment;

import com.example.uiailatreuphu.R;

public class M002_Help_Call_Fragment extends DialogFragment implements View.OnClickListener{
    public static final String TAG= M002_Help_Call_Fragment.class.getName();
    private ImageView ia,ib,ic,id;
    private int trueCase;

    public M002_Help_Call_Fragment(int trueCase) {
        this.trueCase = trueCase;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.m002_frg_call, container, false);
        getDialog().setTitle("Seyirci Joker");

        ia=view.findViewById(R.id.iv_bacsy);
        ib=view.findViewById(R.id.iv_giaovien);
        ic=view.findViewById(R.id.iv_kysu);
        id=view.findViewById(R.id.iv_tiensy);

        ia.setOnClickListener(this);
        ib.setOnClickListener(this);
        ic.setOnClickListener(this);
        id.setOnClickListener(this);
        return view;
    }


    @Override
    public void onClick(View view) {
        if(view.getId()==R.id.iv_bacsy||view.getId()==R.id.iv_tiensy||view.getId()==R.id.iv_giaovien||view.getId()==R.id.iv_kysu){
            getDialog().dismiss();
        }
    }
}
