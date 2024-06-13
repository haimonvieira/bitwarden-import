package br.com.alura.bitwardenImport.main;

import br.com.alura.bitwardenImport.models.DadosImportacao;
import br.com.alura.bitwardenImport.service.ConverteDados;
import java.io.File;

public class Main {

    private ConverteDados converteDados = new ConverteDados();

    public void exibirMenu() {

        String path = "/Users/haimonvieira/Downloads/bitwarden_export_20240613102308.json.txt";

        try {

            DadosImportacao dadosImportacao = converteDados.obterDados(path, DadosImportacao.class);

            //Remove os campos que tiver o totp ou login nulo
            dadosImportacao.items()
                    .removeIf(d ->  d.login() == null || d.login().totp() == null);

            File file = new File("authenticator.json");
            converteDados.escreverDados(file, dadosImportacao);

            System.out.println("Dados filtrados: ");
            System.out.println(dadosImportacao);

            System.out.println("Arquivo '" + file.getName() + "' criado com sucesso.");

        }catch (Exception e) {
            System.err.println("Erro ao processar o arquivo JSON: " + e.getMessage());
        }

    }

}
