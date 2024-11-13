package com.manoelcampos.retornoboleto;

import java.net.URI;
import java.util.List;

public class ProcessadorBoletos {
    public final void processar(URI caminhoArquivo){

        var leituraRetorno = LeituraRetorno.newInstance(caminhoArquivo.toString());

        System.out.println("Boletos");
        System.out.println("----------------------------------------------------------------------------------");
        final List<Boleto> boletos = leituraRetorno.lerArquivo(caminhoArquivo);
        for (Boleto boleto : boletos) {
            System.out.println(boleto);
        }
    }
}
