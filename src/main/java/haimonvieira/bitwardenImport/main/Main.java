package haimonvieira.bitwardenImport.main;

import haimonvieira.bitwardenImport.models.ImportationData;
import haimonvieira.bitwardenImport.service.ConverterData;

import java.io.File;

public class Main {

    private ConverterData converterData = new ConverterData();

    public void exibirMenu() {

        String path = "YOUR_LOCAL_FILE_PATH";

        try {

            ImportationData importationData = converterData.getData(path, ImportationData.class);

            //Remove the fields that have totp or login null
            importationData.items()
                    .removeIf(d ->  d.login() == null || d.login().totp() == null);

            File file = new File("authenticator.json");
            converterData.writeData(file, importationData);

            System.out.println("Data filtered: ");
            System.out.println(importationData);

            System.out.println("File '" + file.getName() + "' created successfully.");

        }catch (Exception e) {
            System.err.println("Error on create JSON file: " + e.getMessage());
        }

    }

}
