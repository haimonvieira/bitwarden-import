package haimonvieira.bitwardenImport.service;

import haimonvieira.bitwardenImport.dto.ImportationData;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;

public class ConverterData implements IConverterData {

    private ObjectMapper mapper = new ObjectMapper();
    @Override
    public <T> T getData(String path, Class<T> classe) {

        File file = new File(path);

        try {
            return mapper.readValue(file, classe);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public void writeData(File file, ImportationData importationData) {

        try {
            mapper.writeValue(file, importationData);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
