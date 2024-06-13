package br.com.alura.bitwardenImport.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DadosLogin(
        String totp
) {

    @Override
    public String toString() {
        return "DadosLogin{" +
                "totp='" + totp + '\'' +
                '}';
    }
}
