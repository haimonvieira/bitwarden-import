package br.com.alura.bitwardenImport.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DadosImportacao(
        boolean encrypted,
        List<DadosItems> items
){

    @Override
    public String toString() {
        return "DadosImportacao{" +
                "encrypted=" + encrypted +
                ", items=" + items +
                '}';
    }
}
