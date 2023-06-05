package devandroid.kauamatheus.appanotacoes.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import devandroid.kauamatheus.appanotacoes.R;
import devandroid.kauamatheus.appanotacoes.controller.ControllerAnotacoes;
import devandroid.kauamatheus.appanotacoes.model.Anotacoes;

public class MainActivity extends AppCompatActivity {

    ControllerAnotacoes controller;

    Anotacoes outraAnotacao;

    EditText editTitulo;
    EditText editObservacoes;

    Button btnbuton_Finalizar;
    Button btnbuton_Limpar;
    Button btnbuton_Salvar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        controller = new ControllerAnotacoes(MainActivity.this);
        controller.toString();

        outraAnotacao = new Anotacoes();
        controller.buscar(outraAnotacao);

        editTitulo = findViewById(R.id.editTextTitulo);
        editObservacoes = findViewById(R.id.editTextConteudo);

        editTitulo.setText(outraAnotacao.getTitulo());
        editObservacoes.setText(outraAnotacao.getObservacoes());

        btnbuton_Limpar = findViewById(R.id.button_limpar);
        btnbuton_Salvar = findViewById(R.id.button_salvar);
        btnbuton_Finalizar = findViewById(R.id.button_finalizar);

        btnbuton_Finalizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Finalizado", Toast.LENGTH_LONG).show();
                finish();
            }
        });

        btnbuton_Salvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Dados salvos" + outraAnotacao.toString(), Toast.LENGTH_LONG).show();

                outraAnotacao.setTitulo(editTitulo.getText().toString());
                outraAnotacao.setObservacoes(editObservacoes.getText().toString());
                controller.salvar(outraAnotacao);

            }
        });

        btnbuton_Limpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editTitulo.setText("");
                editObservacoes.setText("");
                controller.limpar();
            }
        });

        Log.i("ProgramacaoPOO", outraAnotacao.toString());

    }
}