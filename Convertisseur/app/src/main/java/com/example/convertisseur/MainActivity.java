package com.example.convertisseur;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{
    private String[] tab_pays;
    private int[] tab_images;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Initialiser les tableaux dans onCreate()
        tab_pays= getResources().getStringArray(R.array.pays);
        tab_images= getResources().getIntArray(R.array.images);

        // Initialiser les spinners
        Spinner spin1 = findViewById(R.id.spinner1);
        Spinner spin2 = findViewById(R.id.spinner2);
        spin1.setOnItemSelectedListener(this);
        spin2.setOnItemSelectedListener(this);

        // Créer une liste d'éléments personnalisés
        ArrayList<SpinnerItem> spinnerItems = new ArrayList<>();
        for (int i=0; i<tab_pays.length;i++){
            spinnerItems.add(new SpinnerItem(tab_pays[i],tab_images[i]));
        }

        // Créer l'adaptateur personnalisé
        CustomSpinnerAdapter adapter = new CustomSpinnerAdapter(this, spinnerItems);

        // Lier l'adaptateur au Spinner
        spin1.setAdapter(adapter);
        spin2.setAdapter(adapter);

    }

    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        TextView textMoney;
        if (parent.getId()==R.id.spinner1) {
            textMoney = findViewById(R.id.textMoney1);
        }
        else{
            textMoney =findViewById(R.id.textMoney2);
        }
        String[] SymArray = getResources().getStringArray(R.array.symbole);
        textMoney.setText(SymArray[position]);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        // No action needed when no selection is made
    }
    public void cliquer(View maVue){
        Button boutonClique = (Button) maVue;
        String texte =boutonClique.getText().toString();

        TextView champ = findViewById(R.id.text1);
        champ.append(texte);
    }

    public void cliquerPoubelle(View maVue){
        TextView champ = findViewById(R.id.text1);
        champ.setText("");
    }

    public void supp(View maVue){
        TextView champ = findViewById(R.id.text1);
        String text= champ.getText().toString();
        if (!text.isEmpty()) {
            champ.setText(text.substring(0, text.length() - 1));
        }
    }

    public void valider(View maVue){
        TextView text1 = findViewById(R.id.text1);
        TextView textTaux = findViewById(R.id.textTaux2);
        String texte =text1.getText().toString();
        double valeur = Double.parseDouble(texte)*Double.parseDouble(textTaux.getText().toString());

        TextView text3 = findViewById(R.id.text3);
        text3.setText(String.valueOf(valeur));
    }

    public void inverser(View maVue){
        // Echange des pays
        Spinner spin1 = findViewById(R.id.spinner1);
        Spinner spin2 = findViewById(R.id.spinner2);

        int position1 = spin1.getSelectedItemPosition();
        spin1.setSelection(spin2.getSelectedItemPosition());
        spin2.setSelection(position1);

        // Echange des valeurs
        TextView text1 = findViewById(R.id.text1);
        TextView text3 = findViewById(R.id.text3);

        CharSequence t=text1.getText();
        text1.setText(text3.getText());
        text3.setText(t);

        //Calcul du nouveau taux
        TextView textTaux2 = findViewById(R.id.textTaux2);
        double new_taux= 1/Double.parseDouble(textTaux2.getText().toString());
        textTaux2.setText(String.valueOf(new_taux));

        //Echange des symboles
        TextView textMoney1 = findViewById(R.id.textMoney1);
        TextView textMoney2 = findViewById(R.id.textMoney2);

        CharSequence sym=textMoney1.getText();
        textMoney1.setText(textMoney2.getText());
        textMoney2.setText(sym);
    }
}