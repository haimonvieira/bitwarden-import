package haimonvieira.bitwardenImport.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record ItemsData(
        boolean favorite,
        String id,
        LoginData login,
        String name,
        Integer type
) {

}
