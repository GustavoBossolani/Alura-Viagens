package br.com.aluraviagens.gustavo.aluraviagens.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

import br.com.aluraviagens.gustavo.aluraviagens.R;
import br.com.aluraviagens.gustavo.aluraviagens.model.Pacote;
import br.com.aluraviagens.gustavo.aluraviagens.util.DiasUtil;
import br.com.aluraviagens.gustavo.aluraviagens.util.MoedaUtil;
import br.com.aluraviagens.gustavo.aluraviagens.util.ResourcesUtil;

public class ListaPacotesAdapter extends BaseAdapter {


    private final List<Pacote> pacotes;
    private final Context context;


    public ListaPacotesAdapter(List<Pacote> pacotes, Context context){
        this.pacotes = pacotes;
        this.context = context;
    }

    @Override
    public int getCount() {
        return this.pacotes.size();
    }

    @Override
    public Pacote getItem(int position) {
        return this.pacotes.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View novaView = LayoutInflater.from(this.context)
                .inflate(R.layout.item_pacote,parent, false);

        Pacote pacote = this.pacotes.get(position);

        //Populando local
        populandoLocal(novaView, pacote);
        //Populando imagens
        populandoImagens(novaView, pacote);
        //Populando dias
        populandoDias(novaView, pacote);
        //Populando preço
        populandoPreco(novaView, pacote);

        return novaView;
    }

    private void populandoPreco(View novaView, Pacote pacote) {
        TextView preco = novaView.findViewById(R.id.item_pacote_preco);
        String precoEmBrl = MoedaUtil.formatarParaBRL(pacote.getPreco());
        preco.setText(precoEmBrl);
    }
    private void populandoDias(View novaView, Pacote pacote) {
        TextView dias = novaView.findViewById(R.id.item_pacote_dias);
        String diasEmTexto = DiasUtil.formatarEmTexto(pacote.getDias());
        dias.setText(diasEmTexto);
    }
    private void populandoImagens(View novaView, Pacote pacote) {
        ImageView foto = novaView.findViewById(R.id.item_pacote_imagem);
        Drawable fotoLocal = ResourcesUtil.devolverDrawable(this.context,pacote.getImagem());
        foto.setImageDrawable(fotoLocal);
    }
    private void populandoLocal(View novaView, Pacote pacote) {
        TextView local = novaView.findViewById(R.id.item_pacote_local);
        local.setText(pacote.getLocal());
    }
}
