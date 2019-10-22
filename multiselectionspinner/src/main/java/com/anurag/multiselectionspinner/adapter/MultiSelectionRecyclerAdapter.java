package com.anurag.multiselectionspinner.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.anurag.multiselectionspinner.R;
import com.anurag.multiselectionspinner.interfaces.OnMultiSelectionListener;
import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Anurag on 22,October,2019
 */
public class MultiSelectionRecyclerAdapter extends RecyclerView.Adapter<MultiSelectionRecyclerAdapter.ViewHolder>{


    private List<String> imageURLList;
    private List<String> contentList;
    private boolean isImageIncluded;
    private OnMultiSelectionListener onMultiSelectionListener;
    private List<String> chosenItemList = new ArrayList<>();

    public MultiSelectionRecyclerAdapter(boolean isImageIncluded, List<String> imageURLList, List<String> contentList) {

        this.isImageIncluded = isImageIncluded;
        this.imageURLList = imageURLList;
        this.contentList = contentList;
    }

    public MultiSelectionRecyclerAdapter(boolean isImageIncluded, List<String> contentList) {

        this.isImageIncluded = isImageIncluded;
        this.contentList = contentList;
    }

    public void setOnMultiSelectionListener(OnMultiSelectionListener onMultiSelectionListener) {

        this.onMultiSelectionListener = onMultiSelectionListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_adapter_multi_selection,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {

        holder.spinnerCheck.setTag(position);
        holder.spinnerImage.setTag(position);
        holder.spinnerText.setTag(position);

        if (isImageIncluded) {

            try{

                if (imageURLList.get(position) != null) {

                    Glide.with(holder.spinnerImage.getContext()).load(imageURLList.get(position)).into(holder.spinnerImage);

                }
            }catch (Exception e){

                holder.spinnerImage.setVisibility(View.GONE);
                e.printStackTrace();
            }
        }

        try {

            if (contentList.get(position) != null) {

                holder.spinnerText.setText(contentList.get(position));
            }
        }catch (Exception e){

            holder.spinnerText.setVisibility(View.GONE);
            e.printStackTrace();
        }

        holder.spinnerCheck.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean checked) {

                if (checked){

                    chosenItemList.add(contentList.get(position));
                    onMultiSelectionListener.OnMultiSpinnerSelected(chosenItemList);
                }else {

                    chosenItemList.remove(contentList.get(position));
                    onMultiSelectionListener.OnMultiSpinnerSelected(chosenItemList);
                }
            }
        });
    }

    @Override
    public int getItemCount() {

        int size = 0;

        if (!isImageIncluded){

            if (contentList.size() >0){

                size = contentList.size();
            }
        }else {

            if (imageURLList.size() > 0 && contentList.size() > 0) {

                if (imageURLList.size() > contentList.size()){

                    size = imageURLList.size();

                }else if (contentList.size() > imageURLList.size()){

                    size = contentList.size();
                }else {

                    size = contentList.size();
                }
            }
        }

        return size;
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView spinnerImage;
        private CheckBox spinnerCheck;
        private TextView spinnerText;

        ViewHolder(@NonNull View itemView) {
            super(itemView);

            spinnerCheck = itemView.findViewById(R.id.checkSpinnerItem);
            spinnerImage = itemView.findViewById(R.id.ivSpinnerImage);
            spinnerText = itemView.findViewById(R.id.tvSpinnerContent);


            if (!isImageIncluded){

                spinnerImage.setVisibility(View.GONE);
            }

        }
    }
}
