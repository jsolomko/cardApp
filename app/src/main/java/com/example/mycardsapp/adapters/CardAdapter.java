package com.example.mycardsapp.adapters;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mycardsapp.data.Card;

import java.util.List;

public class CardAdapter extends ListAdapter<Card, CardAdapter.CardVH> {

    protected CardAdapter(@NonNull DiffUtil.ItemCallback<Card> diffCallback) {
        super(diffCallback);
    }

    class CardVH extends RecyclerView.ViewHolder {
        public CardVH(@NonNull View itemView) {
            super(itemView);
        }
    }

    @NonNull
    @Override
    public CardVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull CardVH holder, int position) {

    }


    class CardDiff extends DiffUtil.ItemCallback<Card>{
        @Override
        public boolean areItemsTheSame(@NonNull Card oldItem, @NonNull Card newItem) {
            return false;
        }

        @Override
        public boolean areContentsTheSame(@NonNull Card oldItem, @NonNull Card newItem) {
            return false;
        }
    }

}
