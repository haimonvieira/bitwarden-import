package br.com.alura.bitwardenImport.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DadosItems(
        boolean favorite,
        String id,
        DadosLogin login,
        String name,
        Integer type
) {
    @Override
    public String toString() {
        return "DadosItems{" +
                "favorite=" + favorite +
                ", id='" + id + '\'' +
                ", login=" + login +
                ", name='" + name + '\'' +
                ", type=" + type +
                '}';
    }
}
