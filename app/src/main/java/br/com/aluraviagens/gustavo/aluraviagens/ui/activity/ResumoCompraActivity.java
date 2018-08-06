package br.com.aluraviagens.gustavo.aluraviagens.ui.activity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import br.com.aluraviagens.gustavo.aluraviagens.R;
import br.com.aluraviagens.gustavo.aluraviagens.model.Pacote;
import br.com.aluraviagens.gustavo.aluraviagens.util.DataUtil;
import br.com.aluraviagens.gustavo.aluraviagens.util.MoedaUtil;
import br.com.aluraviagens.gustavo.aluraviagens.util.ResourcesUtil;

import static br.com.aluraviagens.gustavo.aluraviagens.ui.activity.interfaces.PacotesConstantes.CHAVE_PACOTE;

public class ResumoCompraActivity extends AppCompatActivity {

    public static final String TITULO_APP_BAR = "Resumo da compra";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resumo_compra);

        setTitle(TITULO_APP_BAR);
        carregaPacoteRecebido();
    }

    private void carregaPacoteRecebido() {
        Intent intent = getIntent();
        if (intent.hasExtra(CHAVE_PACOTE)){
            Pacote pacote = (Pacote) intent.getSerializableExtra(CHAVE_PACOTE);
            inicializarCampos(pacote);
        }
    }

    private void inicializarCampos(Pacote pacote) {
        mostraFoto(pacote);
        mostraLocal(pacote);
        mostraData(pacote);
        mostraPreco(pacote);
    }

    private void mostraPreco(Pacote pacote) {
        TextView preco = findViewById(R.id.resumo_compra_preco);
        String precoFormatado = MoedaUtil.formatarParaBRL(pacote.getPreco());
        preco.setText(precoFormatado);
    }

    private void mostraData(Pacote pacote) {
        TextView data = findViewById(R.id.resumo_compra_data);
        String dataConvertida = DataUtil.formataData(pacote.getDias());
        data.setText(dataConvertida);
    }

    private void mostraLocal(Pacote pacote) {
        TextView local = findViewById(R.id.resumo_compra_local);
        local.setText(pacote.getLocal());
    }

    private void mostraFoto(Pacote pacote) {
        ImageView foto = findViewById(R.id.resumo_compra_foto);
        Drawable fotoLocal = ResourcesUtil.devolverDrawable(this, pacote.getImagem());
        foto.setImageDrawable(fotoLocal);
    }
}
