package com.manoelcampos.retornoboleto;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.net.URI;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 * Define um contrato para implementação de estratégias
 * de leitura de arquivos de retorno de bancos brasileiros (como Banco do Brasil e Bradesco).
 *
 * @author Manoel Campos da Silva Filho
 */
public interface LeituraRetorno {
    DateTimeFormatter FORMATO_DATA = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    DateTimeFormatter FORMATO_DATA_HORA = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");


    /**
     * Lê um arquivo de retorno de boleto bancário.
     *
     * @param caminhoArquivo Caminho (URI) do arquivo a ser lido
     */
    List<Boleto> lerArquivo(URI caminhoArquivo);


    static LeituraRetorno newInstance(String caminhoArquivo) {

        String sufixoNomeBanco = new File(caminhoArquivo).getName().split("\\.")[0];

        try {
            String interfaceName = LeituraRetorno.class.getName();
            Class<?> aClass = Class.forName(interfaceName + sufixoNomeBanco);
           return  (LeituraRetorno) aClass.getDeclaredConstructor().newInstance();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Banco não suportado "+e);
        } catch (InvocationTargetException | InstantiationException | IllegalAccessException | NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }


}
