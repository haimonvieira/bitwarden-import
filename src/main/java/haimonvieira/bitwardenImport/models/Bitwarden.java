package haimonvieira.bitwardenImport.models;

import haimonvieira.bitwardenImport.service.ConverterData;
import javax.swing.*;
import java.io.File;
import java.nio.file.Paths;

public class Bitwarden {

    private final ConverterData converterData = new ConverterData();
    private final JsonFile jsonFile = new JsonFile();

    public void showMenu(){

        JFileChooser fileChooser = jsonFile.setFile();
        int opcao = fileChooser.showOpenDialog(null);

        if(opcao == JFileChooser.APPROVE_OPTION) {

            String path = fileChooser.getSelectedFile().getAbsolutePath();

            try {

                //Import data from JSON
                ImportationData importationData = converterData.getData(path, ImportationData.class);

                //Remove the fields that have totp or login null
                importationData.items()
                        .removeIf(d -> d.login() == null || d.login().totp() == null);

                //Getting the username, download folder and getting the path for the file 'bitwardenAuthenticator.json'
                String username = System.getProperty("user.home");
                String downloadFolder = Paths.get(username, "Downloads").toString();
                String download = Paths.get(downloadFolder,
                        "bitwardenAuthenticator.json").toString();

                //Creating the file 'bitwardenAuthenticator.json'
                File file = new File(download);
                converterData.writeData(file, importationData);

                JOptionPane.showMessageDialog(null,
                        "File '" + file.getName() + "' created successfully at '" +
                                download + "'");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null,
                        "Error on create JSON file: The file was not selected");
            }

        }

    }

}
