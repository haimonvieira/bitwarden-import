package br.com.alura.bitwardenImport.service;

import br.com.alura.bitwardenImport.models.DadosImportacao;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;

public class ConverteDados implements IConverteDados {

    /**
     * Está classe converte os dados do arquivo json obtido atráves da API para String.
     * Ambos os métodos são genéricos
     */

    private ObjectMapper mapper = new ObjectMapper();
    @Override
    public <T> T obterDados(String path, Class<T> classe) {

        File file = new File(path);

        try {
            return mapper.readValue(file, classe);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public void escreverDados(File file, DadosImportacao dadosImportacao) {

        try {
            mapper.writeValue(file, dadosImportacao);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
