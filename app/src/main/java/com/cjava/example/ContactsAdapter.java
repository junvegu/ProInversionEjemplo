package com.cjava.example;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by junior on 30/11/17.
 */

public class ContactsAdapter extends RecyclerView.Adapter<ContactsAdapter.ViewHolder> {


    private ArrayList<ContacsEntity> mListContacts;
    private Context mContext;


    public ContactsAdapter(ArrayList<ContacsEntity> mListContacts, Context mContext) {
        this.mListContacts = mListContacts;
        this.mContext = mContext;
    }


    @Override
    public ContactsAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View root = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_contact, parent, false);
        return new ViewHolder(root);
    }

    @Override
    public void onBindViewHolder(ContactsAdapter.ViewHolder holder, int position) {

        ContacsEntity contacsEntity = mListContacts.get(position);


        holder.tvFullName.setText(contacsEntity.getFullName());
        holder.tvCompany.setText(contacsEntity.getCompany_name());
        holder.tvPhone.setText(contacsEntity.getPhone());
        Glide.with(mContext).load(contacsEntity.getUrl_picture()).apply(RequestOptions.circleCropTransform()).into(holder.ivPicture);

      /*  Glide.with(mContext).load("http://www.spiritanimal.info/pictures/hawk/Hawk-Spirit-Animal-5.jpg").apply(RequestOptions.circleCropTransform())
                .into(holder.ivPicture);*/
    }

    @Override
    public int getItemCount() {
        return mListContacts.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.iv_picture)
        ImageView ivPicture;
        @BindView(R.id.tv_full_name)
        TextView tvFullName;
        @BindView(R.id.tv_company)
        TextView tvCompany;
        @BindView(R.id.tv_phone)
        TextView tvPhone;


        ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

        }

    }

}
