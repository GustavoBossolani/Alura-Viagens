package br.com.aluraviagens.gustavo.aluraviagens.util;

import android.support.annotation.NonNull;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DataUtil {

    public static final String DIA_E_MES = "dd/MM";

    @NonNull
    public static String formataData(int dias) {

        Calendar dataIda = Calendar.getInstance();
        Calendar dataVolta = Calendar.getInstance();

        dataVolta.add(Calendar.DATE, dias); //adcionando dias de acordo com a data atual

        SimpleDateFormat formatoBrasileiro = new SimpleDateFormat(DIA_E_MES);
        String dataFormatadaIda = formatoBrasileiro.format(dataIda.getTime());
        String dataFormatadaVolta = formatoBrasileiro.format(dataVolta.getTime());
        return dataFormatadaIda
                + " - "
                + dataFormatadaVolta
                + " de "
                + dataVolta.get(Calendar.YEAR);
    }

}
