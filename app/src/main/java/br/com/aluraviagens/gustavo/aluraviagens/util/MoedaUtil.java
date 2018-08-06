package br.com.aluraviagens.gustavo.aluraviagens.util;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

public class MoedaUtil {

    public static final String PORTUGUES = "pt";
    public static final String BRASIL = "br";
    public static final String FORMATO_PADRAO = "R$";
    public static final String FORMATO_REFATORADO = "R$ ";

    public static String formatarParaBRL(BigDecimal valor){

        NumberFormat formatoBrasileiro = DecimalFormat
                .getCurrencyInstance(new Locale(PORTUGUES, BRASIL));

        String moedaBR = formatoBrasileiro
                .format(valor)
                .replace(FORMATO_PADRAO, FORMATO_REFATORADO);

        return moedaBR;
    }
}
