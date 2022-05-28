package com.example.contador;

import android.os.AsyncTask;
import android.os.SystemClock;
import android.widget.Button;
import android.widget.TextView;

public class ProcessamentoDeContagem extends AsyncTask<Integer, Integer,Void> {

    Button btnProcessar;
    TextView txtContagem;

    private int number;

    public ProcessamentoDeContagem(Button btnProcessar, TextView txtContagem) {
        this.btnProcessar = btnProcessar;
        this.txtContagem = txtContagem;
    }

    public void setNumber(int number){
        this.number = Math.abs(number);
    }

    @Override
    protected Void doInBackground(Integer... integers) {
        int max = integers[0];

        // Se for colocado " >= 0 ", o app não mostra 0
        for(int i =max; i >= -1; i--){
            SystemClock.sleep(1000);
            publishProgress(i);
        }

        return null;
    }

    @Override
    protected void onPreExecute() {
        btnProcessar.setEnabled(false);
        txtContagem.setText(number+"");
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        int p  = values[0];
        txtContagem.setText(p+"");
    }

    @Override
    protected void onPostExecute(Void unused) {
        btnProcessar.setEnabled(true);
        txtContagem.setText(R.string.acabou);
    }

}
