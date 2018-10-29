package localizacaoapp.com.br.localizacaoapp.servico;

import java.io.ObjectOutputStream;

public class ConverteMiliSegundos {
    public static long converteDias(int qtdDias){
        return qtdDias * converteHoras(24);
    }

    public static long converteMeses(int qdtMeses){
        return qdtMeses * converteDias(30);
    }

    public static long converteHoras(int qdtHoras){
        return qdtHoras * converteMinutos(60);
    }

    public static long converteMinutos(int qdtMinutos){
        return qdtMinutos * (60 * 1000);
    }


}
