package haimonvieira.bitwardenImport.models;

import haimonvieira.bitwardenImport.service.ConverterData;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.File;
import java.nio.file.Paths;

public class Bitwarden {

    private ConverterData converterData = new ConverterData();

    public void showMenu(){

        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Choose the JSON file");
        fileChooser.setFileFilter(new FileNameExtensionFilter("JSON files", "json"));

        int opcao = fileChooser.showOpenDialog(null);
        ///Users/haimonvieira/Downloads/bitwarden_export_20240628184844.json

        if(opcao == JFileChooser.APPROVE_OPTION) {

            String path = fileChooser.getSelectedFile().getAbsolutePath();

            try {

                ImportationData importationData = converterData.getData(path, ImportationData.class);

                //Remove the fields that have totp or login null
                importationData.items()
                        .removeIf(d -> d.login() == null || d.login().totp() == null);

                //Getting the username, download folder and creating the file
                String username = System.getProperty("user.home");
                String downloadFolder = Paths.get(username, "Downloads").toString();
                String download = Paths.get(downloadFolder,
                        "bitwardenAuthenticator.json").toString();

                File file = new File(download);
                converterData.writeData(file, importationData);

                JOptionPane.showMessageDialog(null,
                        "File '" + file.getName() + "' created successfully at '" +
                                download + "'");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null,
                        "Error on create JSON file: " + e.getMessage());
            }

        }

    }

}
