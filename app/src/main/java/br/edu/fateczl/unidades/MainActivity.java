package br.edu.fateczl.unidades;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
/*
 *@author:<Gustavo de Paula>
 */
public class MainActivity extends AppCompatActivity {

    private EditText etNum;
    private TextView tvCent,tvDez,tvUni;
    private Button btnVer;


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
        etNum = findViewById(R.id.etNumero);
        btnVer = findViewById(R.id.btnVer);
        btnVer.setOnClickListener(op -> ver());
        tvCent = findViewById(R.id.tvCentenas);
        tvDez = findViewById(R.id.tvDezenas);
        tvUni = findViewById(R.id.tvUnidades);


    }
    private void ver(){

        int num = Integer.parseInt(etNum.getText().toString());
        if(num <100 || num > 999) {
            String numeroInvalido = getString(R.string.numInvalido);
            tvCent.setText(numeroInvalido);
            etNum.setText("");
            return;
        }
        int cent = num / 100;
        int dez = (num % 100) / 10;
        int uni = (num % 100) % 10;
        String centenas = getString(R.string.tvCent);
        String dezenas = getString(R.string.tvDez);
        String unidades = getString(R.string.tvUni);
        tvCent.setText(centenas + cent);
        tvDez.setText(dezenas + dez);
        tvUni.setText(unidades+uni);
        etNum.setText("");

    }
}