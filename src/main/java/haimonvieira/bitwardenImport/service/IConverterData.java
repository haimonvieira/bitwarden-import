package haimonvieira.bitwardenImport.service;

import haimonvieira.bitwardenImport.dto.ImportationData;
import java.io.File;

public interface IConverterData {

    <T> T getData(String json, Class<T> classe);
    void writeData(File file, ImportationData importationData);
}
