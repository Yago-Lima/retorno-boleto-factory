import com.manoelcampos.retornoboleto.ProcessadorBoletos;

import java.net.URI;
import java.net.URISyntaxException;

/**
 * Classe para ver o funcionamento da leitura de boletos.
 *
 * @author Manoel Campos da Silva Filho
 */
public class Principal {
    public static void main(String[] args) throws URISyntaxException {

        URI caminhoArquivo = Principal.class.getResource("BancoBrasil.csv").toURI();
        final var processador = new ProcessadorBoletos();

        System.out.println("Lendo arquivo " + caminhoArquivo + "\n");

        processador.processar(caminhoArquivo);
    }
}
