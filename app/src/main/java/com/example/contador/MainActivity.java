package com.example.contador;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnProcessar;
    private TextView txtContagem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnProcessar = findViewById(R.id.btnProcessar);
        txtContagem = findViewById(R.id.txtContagem);

        btnProcessar.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        ProcessamentoDeContagem task = new ProcessamentoDeContagem(btnProcessar,txtContagem);
        task.setNumber(10);
        task.execute(10);
    }
}