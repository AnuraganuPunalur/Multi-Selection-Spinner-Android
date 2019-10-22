package com.anurag.multiselectionspinner;

import android.app.Dialog;
import android.content.Context;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.anurag.multiselectionspinner.adapter.MultiSelectionRecyclerAdapter;
import com.anurag.multiselectionspinner.interfaces.OnMultiSelectionListener;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Anurag on 22,October,2019
 */
public class MultiSelectionSpinnerDialog extends Dialog implements OnMultiSelectionListener {

    static Dialog multiSelectionSpinnerDialog;
    private List<String> chosenList = new ArrayList<>();
    static MultiSpinner multiSpinner;

    void setMultiSelectionAdapterWithImage(final Context context, List<String> imageURLList, List<String> spinnerContentList,
                                           OnMultiSpinnerSelectionListener onMultiSpinnerSelectionListener){

        multiSelectionSpinnerDialog = new Dialog(context);
        multiSelectionSpinnerDialog.setContentView(R.layout.layout_dialog_multi_selection);
        final Window window = multiSelectionSpinnerDialog.getWindow();

        if (window != null) {

            window.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            window.setGravity(Gravity.CENTER);
        }
        multiSelectionSpinnerDialog.setCancelable(false);

        RecyclerView multiSelectionItemRecycler = multiSelectionSpinnerDialog.findViewById(R.id.recyclerMultiSelection);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
        multiSelectionItemRecycler.setLayoutManager(linearLayoutManager);

        MultiSelectionRecyclerAdapter multiSelectionRecyclerAdapter = new MultiSelectionRecyclerAdapter(true,imageURLList,spinnerContentList);
        multiSelectionRecyclerAdapter.setOnMultiSelectionListener(this);
        multiSelectionItemRecycler.setAdapter(multiSelectionRecyclerAdapter);


        TextView cancelDialog = multiSelectionSpinnerDialog.findViewById(R.id.tvCancelMultiSelection);
        TextView chooseSelection = multiSelectionSpinnerDialog.findViewById(R.id.tvOK);

        cancelDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                multiSelectionSpinnerDialog.dismiss();
            }
        });

        final OnMultiSpinnerSelectionListener finalOnMultiSpinnerSelectionListener = onMultiSpinnerSelectionListener;
        chooseSelection.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                finalOnMultiSpinnerSelectionListener.OnMultiSpinnerItemSelected(chosenList);
                multiSelectionSpinnerDialog.dismiss();
            }
        });

    }

    void setMultiSelectionAdapterWithOutImage(final Context context, List<String> spinnerContentList,
                                              OnMultiSpinnerSelectionListener onMultiSpinnerSelectionListener){

        multiSelectionSpinnerDialog = new Dialog(context);
        multiSelectionSpinnerDialog.setContentView(R.layout.layout_dialog_multi_selection);
        final Window window = multiSelectionSpinnerDialog.getWindow();

        if (window != null) {

            window.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            window.setGravity(Gravity.CENTER);
        }
        multiSelectionSpinnerDialog.setCancelable(false);

        RecyclerView multiSelectionItemRecycler = multiSelectionSpinnerDialog.findViewById(R.id.recyclerMultiSelection);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
        multiSelectionItemRecycler.setHasFixedSize(false);
        multiSelectionItemRecycler.setLayoutManager(linearLayoutManager);

        MultiSelectionRecyclerAdapter multiSelectionRecyclerAdapter = new MultiSelectionRecyclerAdapter(false,spinnerContentList);
        multiSelectionRecyclerAdapter.setOnMultiSelectionListener(this);
        multiSelectionItemRecycler.setAdapter(multiSelectionRecyclerAdapter);


        TextView cancelDialog = multiSelectionSpinnerDialog.findViewById(R.id.tvCancelMultiSelection);
        TextView chooseSelection = multiSelectionSpinnerDialog.findViewById(R.id.tvOK);

        cancelDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                multiSelectionSpinnerDialog.dismiss();
            }
        });

        final OnMultiSpinnerSelectionListener finalOnMultiSpinnerSelectionListener = onMultiSpinnerSelectionListener;
        chooseSelection.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                finalOnMultiSpinnerSelectionListener.OnMultiSpinnerItemSelected(chosenList);
                multiSelectionSpinnerDialog.dismiss();
            }
        });
    }

    public MultiSelectionSpinnerDialog(@NonNull Context context) {
        super(context);

    }


    @Override
    public void OnMultiSpinnerSelected(List<String> itemChosenList) {

        chosenList = itemChosenList;
        chosenList.remove("");
        if (multiSpinner != null){

            StringBuilder stringBuilder = new StringBuilder();

            for(int i=0;i<chosenList.size();i++){

                if(i+1 != chosenList.size()){

                    stringBuilder.append(chosenList.get(i));
                    stringBuilder.append(",");
                } else {

                    stringBuilder.append(chosenList.get(i));
                }
            }

            multiSpinner.setText(stringBuilder.toString());
        }

    }


    public interface OnMultiSpinnerSelectionListener{

        void OnMultiSpinnerItemSelected(List<String> chosenItems);

    }
}

