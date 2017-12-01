package com.cjava.example.contacts.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.cjava.example.R;
import com.cjava.example.contacts.ContacsEntity;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by junior on 30/11/17.
 */

public class ContactsAdapter extends RecyclerView.Adapter<ContactsAdapter.ViewHolder> implements  OnClickContactListener {


    private ArrayList<ContacsEntity> mListContacts;
    private Context mContext;


    public ContactsAdapter(ArrayList<ContacsEntity> mListContacts, Context mContext) {
        this.mListContacts = mListContacts;
        this.mContext = mContext;
    }


    @Override
    public ContactsAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View root = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_contact, parent, false);
        return new ViewHolder(root,this);
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

    @Override
    public void clickContact(int position) {

        Log.d("ADAPTER","click al elemento " +position);
        Log.e("ADAPTER","click al elemento " +position);
    }

    static class ViewHolder extends RecyclerView.ViewHolder  implements View.OnClickListener{

        @BindView(R.id.iv_picture)
        ImageView ivPicture;
        @BindView(R.id.tv_full_name)
        TextView tvFullName;
        @BindView(R.id.tv_company)
        TextView tvCompany;
        @BindView(R.id.tv_phone)
        TextView tvPhone;

        @BindView(R.id.item_click)
        LinearLayout itemClickContact;


        OnClickContactListener onClickContactListener;

        ViewHolder(View itemView, OnClickContactListener onClickContactListener) {
            super(itemView);
            ButterKnife.bind(this, itemView );
            this.onClickContactListener =  onClickContactListener;
            itemClickContact.setOnClickListener(this);

        }

        @Override
        public void onClick(View view) {
            onClickContactListener.clickContact(getAdapterPosition());
        }
    }

}
