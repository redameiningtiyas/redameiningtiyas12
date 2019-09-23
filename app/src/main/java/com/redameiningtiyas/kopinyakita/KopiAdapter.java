package com.redameiningtiyas.kopinyakita;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class KopiAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<Kopi> kopinyakita;

    public void setKopinyakita(ArrayList<Kopi> kopinyakita) {
        this.kopinyakita = kopinyakita;
    }

    public KopiAdapter(Context context) {
        this.context = context;
        kopinyakita=new ArrayList<>();
    }

    @Override
    public int getCount() {
        return kopinyakita.size();
    }

    @Override
    public Object getItem(int i) {
        return kopinyakita.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.item_kopi, viewGroup, false);
        }
        ViewHolder viewHolder = new ViewHolder(view);
        Kopi kopi = (Kopi) getItem(i);
        viewHolder.bind(kopi);
        return view;
    }
    private class ViewHolder {
        private TextView txtName;
        private TextView txtDescription;
        private ImageView imgPhoto;

        ViewHolder(View view) {
            txtName = view.findViewById(R.id.txt_name);
            txtDescription = view.findViewById(R.id.txt_description);
            imgPhoto = view.findViewById(R.id.img_photo);
        }
        void bind(Kopi kopi) {
            txtName.setText(kopi.getName());
            txtDescription.setText(kopi.getDescription());
            imgPhoto.setImageResource(kopi.getPhoto());
        }
    }
}


