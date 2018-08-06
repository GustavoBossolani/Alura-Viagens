package br.com.aluraviagens.gustavo.aluraviagens.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import java.util.List;
import br.com.aluraviagens.gustavo.aluraviagens.R;
import br.com.aluraviagens.gustavo.aluraviagens.adapter.ListaPacotesAdapter;
import br.com.aluraviagens.gustavo.aluraviagens.dao.PacoteDAO;
import br.com.aluraviagens.gustavo.aluraviagens.model.Pacote;

import static br.com.aluraviagens.gustavo.aluraviagens.ui.activity.interfaces.PacotesConstantes.CHAVE_PACOTE;

public class ListaPacoteActivity extends AppCompatActivity {

    public static final String TITULO_APP_BAR = "Pacotes";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
       super.onCreate(savedInstanceState);
       setContentView(R.layout.activity_lista_pacote);

        setTitle(TITULO_APP_BAR);
        configurarLista();

    }

    private void configurarLista() {
        ListView listaPacotes = findViewById(R.id.lista_pacotes_lista);
        final List<Pacote> pacotes = new PacoteDAO().lista();
        listaPacotes.setAdapter(new ListaPacotesAdapter(pacotes, this));

          // Lambda!
//        listaPacotes.setOnItemClickListener((parent, view, position, id) ->
//                startActivity(new Intent(ListaPacoteActivity.this, ResumoPacoteActivity.class)));

        listaPacotes.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Pacote pacoteClicado = pacotes.get(position);
                vaiParaResumoPacote(pacoteClicado);
            }
        });
    }

    private void vaiParaResumoPacote(Pacote pacote) {
        Intent intent = new Intent(ListaPacoteActivity.this,
                ResumoPacoteActivity.class);
        intent.putExtra(CHAVE_PACOTE, pacote);
        startActivity(new Intent(intent));
    }
}
