package com.example.convertisseur;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.ArrayList;

public class CustomSpinnerAdapter extends ArrayAdapter<SpinnerItem> {
    public CustomSpinnerAdapter(Context context, ArrayList<SpinnerItem> items) {
        super(context, 0, items);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {
        return createCustomView(position, convertView, parent);
    }

    @Override
    // position= indice de l'élément sélectionnée dans l'array
    // View = élément sélectionnée
    // View Group = ensemble des options/ spinner
    public View getDropDownView(int position, View convertView, @NonNull ViewGroup parent) {
        return createCustomView(position, convertView, parent);
    }
    private View createCustomView(int position, View convertView, ViewGroup parent) {
        // Inflation de la mise en page personnalisée et remplissage des données
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.custom_spinner_item, parent, false);
        }

        SpinnerItem item = getItem(position);
        if (item != null) {
            ImageView imageView = convertView.findViewById(R.id.spinner_image);
            TextView textView = convertView.findViewById(R.id.spinner_text);

            imageView.setImageResource(item.getImageResId());
            textView.setText(item.getText());
        }
        return convertView;
    }
}

