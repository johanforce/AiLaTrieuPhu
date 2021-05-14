package com.example.uiailatreuphu.dialog_fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import androidx.fragment.app.DialogFragment;

import com.example.uiailatreuphu.R;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;

import java.util.ArrayList;
import java.util.Random;

public class M002_Audience_Fragment extends DialogFragment implements View.OnClickListener {
    public static final String TAG= M002_Audience_Fragment.class.getName();
    private BarChart barChart;
     private ImageView ia,ib,ic,id;
     private Button bt_returnAudience;
     private int trueCase=3;

    public M002_Audience_Fragment(int trueCase) {
        this.trueCase = trueCase;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.item_audience, container, false);
        getDialog().setTitle("Seyirci Joker");

//        ia=view.findViewById(R.id.iv_auA);
//        ib=view.findViewById(R.id.iv_auB);
//        ic=view.findViewById(R.id.iv_auC);
//        id=view.findViewById(R.id.iv_auD);
        view.findViewById(R.id.bt_return_audience).setOnClickListener(this);
//
//       if(trueCase==1){
//           LinearLayout.LayoutParams paramsA = (LinearLayout.LayoutParams) ia.getLayoutParams();
//           paramsA.weight = 5;
//           ia.setLayoutParams(paramsA);
//           LinearLayout.LayoutParams paramsB = (LinearLayout.LayoutParams) ib.getLayoutParams();
//           paramsB.weight = 1;
//           ib.setLayoutParams(paramsB);
//           LinearLayout.LayoutParams paramsC = (LinearLayout.LayoutParams) ic.getLayoutParams();
//           paramsC.weight = 2;
//           ic.setLayoutParams(paramsC);
//           LinearLayout.LayoutParams paramsD = (LinearLayout.LayoutParams) id.getLayoutParams();
//           paramsD.weight = 2;
//           id.setLayoutParams(paramsD);
//       }
//        if(trueCase==2){
//            LinearLayout.LayoutParams paramsA = (LinearLayout.LayoutParams) ia.getLayoutParams();
//            paramsA.weight = 2;
//            ia.setLayoutParams(paramsA);
//            LinearLayout.LayoutParams paramsB = (LinearLayout.LayoutParams) ib.getLayoutParams();
//            paramsB.weight = 4;
//            ib.setLayoutParams(paramsB);
//            LinearLayout.LayoutParams paramsC = (LinearLayout.LayoutParams) ic.getLayoutParams();
//            paramsC.weight = 1;
//            ic.setLayoutParams(paramsC);
//            LinearLayout.LayoutParams paramsD = (LinearLayout.LayoutParams) id.getLayoutParams();
//            paramsD.weight = 3;
//            id.setLayoutParams(paramsD);
//        }
//        if(trueCase==3){
//            LinearLayout.LayoutParams paramsA = (LinearLayout.LayoutParams) ia.getLayoutParams();
//            paramsA.weight = 1;
//            ia.setLayoutParams(paramsA);
//            LinearLayout.LayoutParams paramsB = (LinearLayout.LayoutParams) ib.getLayoutParams();
//            paramsB.weight = 1;
//            ib.setLayoutParams(paramsB);
//            LinearLayout.LayoutParams paramsC = (LinearLayout.LayoutParams) ic.getLayoutParams();
//            paramsC.weight = 7;
//            ic.setLayoutParams(paramsC);
//            LinearLayout.LayoutParams paramsD = (LinearLayout.LayoutParams) id.getLayoutParams();
//            paramsD.weight = 1;
//            id.setLayoutParams(paramsD);
//        }
//        if(trueCase==1){
//            LinearLayout.LayoutParams paramsA = (LinearLayout.LayoutParams) ia.getLayoutParams();
//            paramsA.weight = 2;
//            ia.setLayoutParams(paramsA);
//            LinearLayout.LayoutParams paramsB = (LinearLayout.LayoutParams) ib.getLayoutParams();
//            paramsB.weight = 2;
//            ib.setLayoutParams(paramsB);
//            LinearLayout.LayoutParams paramsC = (LinearLayout.LayoutParams) ic.getLayoutParams();
//            paramsC.weight = 0;
//            ic.setLayoutParams(paramsC);
//            LinearLayout.LayoutParams paramsD = (LinearLayout.LayoutParams) id.getLayoutParams();
//            paramsD.weight = 6;
//            id.setLayoutParams(paramsD);
//        }


        barChart = view.findViewById(R.id.ch_barchart);

        ArrayList<BarEntry> year = new ArrayList();
        Random rd = new Random();

        int rd1 = rd.nextInt(20);
        int rd2 = rd.nextInt(40 - rd1);
        int rd3 = rd.nextInt(40 - rd1 - rd2);
        int rd4 = 40 - rd1 - rd2 - rd3;
        int arrCase[] = new int[]{rd1 + 10, rd2 + 10, rd3 + 10, rd4 + 10};
        final int addTrueCase = 20;
        for (int i = 0; i < arrCase.length; i++) {
            if ((i + 1) == trueCase) {
                arrCase[i] += addTrueCase;
            }
        }

        year.add(new BarEntry(0, arrCase[0]));
        year.add(new BarEntry(1, arrCase[1]));
        year.add(new BarEntry(2, arrCase[2]));
        year.add(new BarEntry(3, arrCase[3]));

        BarDataSet barDataSet = new BarDataSet(year, "Contracts");
        barDataSet.setAxisDependency(YAxis.AxisDependency.LEFT);
        barDataSet.setColor(Color.rgb(51,15,79));
        barDataSet.setHighlightEnabled(true);
        barDataSet.setHighLightColor(Color.RED);
        barDataSet.setValueTextSize(20);
        barDataSet.setValueTextColor(Color.BLACK);  

        BarData barData = new BarData(barDataSet);

        barChart.getDescription().setTextSize(10);
        barChart.setDrawMarkers(true);
        barChart.getAxisLeft().setAxisMinimum(0);
        barChart.getXAxis().setPosition(XAxis.XAxisPosition.BOTH_SIDED);

        ArrayList<String> labels = new ArrayList<String> ();

        labels.add( "A");
        labels.add( "B");
        labels.add( "C");
        labels.add( "D");

        barChart.getXAxis().setValueFormatter(new IndexAxisValueFormatter(labels));
        barChart.animateY(3000);

        barChart.getXAxis().setGranularityEnabled(true);
        barChart.getXAxis().setGranularity(1.0f);
        barChart.getXAxis().setLabelCount(barDataSet.getEntryCount());

        barChart.setData(barData);
        return view;
    }

    @Override
    public void onClick(View view) {
        if(view.getId()==R.id.bt_return_audience){
            getDialog().dismiss();
        }
    }
}
