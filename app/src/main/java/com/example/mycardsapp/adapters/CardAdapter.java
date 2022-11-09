package com.example.mycardsapp.adapters;

import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mycardsapp.R;
import com.example.mycardsapp.data.Card;

import java.util.List;

public class CardAdapter extends ListAdapter<Card, CardAdapter.CardVH> {
    LiveData<List<Card>> listCards;

    public CardAdapter(@NonNull DiffUtil.ItemCallback<Card> diffCallback) {
        super(diffCallback);
    }

   static class CardVH extends RecyclerView.ViewHolder {
        TextView cardTitle;
        ImageView cardFrontImage;

        public CardVH(@NonNull View itemView) {
            super(itemView);
            cardTitle = itemView.findViewById(R.id.tv_card_title);
            cardFrontImage = itemView.findViewById(R.id.card_img);
        }
    }

    @NonNull
    @Override
    public CardVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_item, parent, false);
        return new CardVH(v);
    }

    @Override
    public void onBindViewHolder(@NonNull CardVH holder, int position) {
        Card card = getItem(position);
        holder.cardTitle.setText(card.getCardTitle());
        holder.cardFrontImage.setImageBitmap(card.getCard_front());

    }


     static public class  CardDiff extends DiffUtil.ItemCallback<Card> {
        @Override
        public boolean areItemsTheSame(@NonNull Card oldItem, @NonNull Card newItem) {
            return oldItem == newItem;
        }

        @Override
        public boolean areContentsTheSame(@NonNull Card oldItem, @NonNull Card newItem) {
            return oldItem.getCardTitle().equals(newItem.getCardTitle());
        }
    }

}
