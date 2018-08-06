package br.com.aluraviagens.gustavo.aluraviagens.ui.activity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.Serializable;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import br.com.aluraviagens.gustavo.aluraviagens.R;
import br.com.aluraviagens.gustavo.aluraviagens.model.Pacote;
import br.com.aluraviagens.gustavo.aluraviagens.util.DataUtil;
import br.com.aluraviagens.gustavo.aluraviagens.util.DiasUtil;
import br.com.aluraviagens.gustavo.aluraviagens.util.MoedaUtil;
import br.com.aluraviagens.gustavo.aluraviagens.util.ResourcesUtil;

import static br.com.aluraviagens.gustavo.aluraviagens.ui.activity.interfaces.PacotesConstantes.CHAVE_PACOTE;

public class ResumoPacoteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resumo_pacote);

        setTitle("Resumo do pacote");
        carregaPacoteRecebido();
    }

    private void carregaPacoteRecebido() {
        Intent intent = getIntent();
        if (intent.hasExtra(CHAVE_PACOTE)){
            final Pacote pacote = (Pacote) intent.getSerializableExtra(CHAVE_PACOTE);

            inicializarCampos(pacote);
            configurarBotao(pacote);
        }
    }

    private void configurarBotao(final Pacote pacote) {
        Button realizarCompra = findViewById(R.id.resumo_pacote_btn_realizar_compra);
        realizarCompra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vaiParaPagamento(pacote);
            }
        });
    }

    private void vaiParaPagamento(Pacote pacote) {
        Intent intent = new Intent(ResumoPacoteActivity.this,
                PagamentoActivity.class);
        intent.putExtra(CHAVE_PACOTE, pacote);
        startActivity(intent);
    }

    private void inicializarCampos(Pacote pacote) {
        mostraLocal(pacote);
        mostraImagem(pacote);
        mostraDias(pacote);
        mostraPreco(pacote);
        mostraData(pacote);
    }

    private void mostraData(Pacote pacote) {
        TextView data = findViewById(R.id.resumo_pacote_data);
        String dataFormatadaPacote = DataUtil.formataData(pacote.getDias());
        data.setText(dataFormatadaPacote);
    }

    private void mostraPreco(Pacote pacote) {
        TextView preco = findViewById(R.id.resumo_pacote_preco);
        String moedaFormatada = MoedaUtil.formatarParaBRL(pacote.getPreco());
        preco.setText(moedaFormatada);
    }

    private void mostraDias(Pacote pacote) {
        TextView dias = findViewById(R.id.resumo_pacote_dias);
        String diasEmTexto = DiasUtil.formatarEmTexto(pacote.getDias());
        dias.setText(diasEmTexto);
    }

    private void mostraImagem(Pacote pacote) {
        ImageView imagem = findViewById(R.id.resumo_pacote_foto);
        Drawable drawableDoLocal = ResourcesUtil.devolverDrawable(this, pacote.getImagem());
        imagem.setImageDrawable(drawableDoLocal);
    }

    private void mostraLocal(Pacote pacote) {
        TextView local = findViewById(R.id.resumo_pacote_local);
        local.setText(pacote.getLocal());
    }
}
