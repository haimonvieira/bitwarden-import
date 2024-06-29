package haimonvieira.bitwardenImport.models;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

public class JsonFile {

    public JFileChooser setFile(){

        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Choose the JSON file");
        fileChooser
                .setFileFilter(new FileNameExtensionFilter("JSON files", "json"));

        return fileChooser;
    }

}
