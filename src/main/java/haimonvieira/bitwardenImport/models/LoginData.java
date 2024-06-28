package haimonvieira.bitwardenImport.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record LoginData(
        String totp
) {

}
