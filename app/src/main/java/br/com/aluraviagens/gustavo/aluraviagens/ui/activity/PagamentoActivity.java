package br.com.aluraviagens.gustavo.aluraviagens.ui.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import br.com.aluraviagens.gustavo.aluraviagens.R;
import br.com.aluraviagens.gustavo.aluraviagens.model.Pacote;
import br.com.aluraviagens.gustavo.aluraviagens.util.MoedaUtil;

import static br.com.aluraviagens.gustavo.aluraviagens.ui.activity.interfaces.PacotesConstantes.CHAVE_PACOTE;

public class PagamentoActivity extends AppCompatActivity {

    public static final String TITULO_APP_BAR = "Pagamento";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pagamento);

        setTitle(TITULO_APP_BAR);
        carregaPacoteRecebido();
    }

    private void carregaPacoteRecebido() {
        Intent intent = getIntent();
        if (intent.hasExtra(CHAVE_PACOTE)){
            Pacote pacote = (Pacote) intent.getSerializableExtra(CHAVE_PACOTE);

            mostraPagamento(pacote);
            configuraBotao(pacote);
        }
    }

    private void configuraBotao(final Pacote pacote) {
        Button finalizarCompra = findViewById(R.id.pagamento_botao_finaliza_compra);
        finalizarCompra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vaiParaResumoCompra(pacote);
            }
        });
    }

    private void vaiParaResumoCompra(Pacote pacote) {
        Intent intent = new Intent(PagamentoActivity.this,
                ResumoCompraActivity.class);
        intent.putExtra(CHAVE_PACOTE, pacote);
        startActivity(intent);
    }

    private void mostraPagamento(Pacote pacote) {
        TextView preco = findViewById(R.id.pagamento_preco);
        String moedaConvertida = MoedaUtil.formatarParaBRL(pacote.getPreco());
        preco.setText(moedaConvertida);
    }
}
