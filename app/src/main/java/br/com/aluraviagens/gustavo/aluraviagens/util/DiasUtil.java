package br.com.aluraviagens.gustavo.aluraviagens.util;

public class DiasUtil {

    public static final String SINGULAR = " dia";
    public static final String PLURAL = " dias";

    public static String formatarEmTexto(int quantidadeDias){

        String diasEmTexto = "";
        if (quantidadeDias > 1){
            return diasEmTexto + quantidadeDias + PLURAL;
        }
        return diasEmTexto + quantidadeDias + SINGULAR;
    }
}
