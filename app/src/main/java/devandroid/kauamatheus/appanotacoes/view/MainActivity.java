package devandroid.kauamatheus.appanotacoes.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.List;

import devandroid.kauamatheus.appanotacoes.R;
import devandroid.kauamatheus.appanotacoes.controller.ControllerAnotacoes;
import devandroid.kauamatheus.appanotacoes.database.Lista_DB;
import devandroid.kauamatheus.appanotacoes.model.Anotacoes;

public class MainActivity extends AppCompatActivity {

    ControllerAnotacoes controller;

    Anotacoes outraAnotacao;

    List<String> nomeCategorias;
    EditText editTitulo;
    EditText editObservacoes;

    Button btnbuton_Finalizar;
    Button btnbuton_Limpar;
    Button btnbuton_Salvar;
    Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        controller = new ControllerAnotacoes(MainActivity.this);
        controller.toString();

        outraAnotacao = new Anotacoes();
        controller.buscar(outraAnotacao);


        nomeCategorias = controller.dadosSpinner();
        controller.getListacategorias();

        editTitulo = findViewById(R.id.editTextTitulo);
        editObservacoes = findViewById(R.id.editTextConteudo);

        editTitulo.setText(outraAnotacao.getTitulo());
        editObservacoes.setText(outraAnotacao.getObservacoes());

        btnbuton_Limpar = findViewById(R.id.button_limpar);
        btnbuton_Salvar = findViewById(R.id.button_salvar);
        btnbuton_Finalizar = findViewById(R.id.button_finalizar);
        spinner = findViewById(R.id.spinner);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, controller.dadosSpinner());

        adapter.setDropDownViewResource(android.R.layout.simple_list_item_1);
        spinner.setAdapter(adapter);

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
                Toast.makeText(MainActivity.this, "Dados salvos", Toast.LENGTH_LONG).show();

                outraAnotacao.setTitulo(editTitulo.getText().toString());
                outraAnotacao.setObservacoes(editObservacoes.getText().toString());
                controller.salvar(outraAnotacao);

                Anotacoes anotacoes = new Anotacoes();
                anotacoes.setTitulo(editTitulo.getText().toString());
                anotacoes.setObservacoes(editObservacoes.getText().toString());

                controller.salvarDb(anotacoes);

                editTitulo.setText("");
                editObservacoes.setText("");
            }
        });

        btnbuton_Limpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                limparBancoDeDados();
                controller.limpar();
            }
        });
        spinner.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, controller.getListacategorias()));
        Log.i("ProgramacaoPOO", outraAnotacao.toString());

    }
    private void limparBancoDeDados() {
        Lista_DB listaDb = new Lista_DB(MainActivity.this);
        listaDb.limparTabela("Lista"); // Chama o método limparTabela() da classe Lista_DB para apagar todos os registros da tabela "Lista"
        listaDb.close();
    }

}