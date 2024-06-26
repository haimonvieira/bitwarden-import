package haimonvieira.bitwardenImport.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record ImportationData(
        boolean encrypted,
        List<ItemsData> items
){

}
