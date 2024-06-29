package haimonvieira.bitwardenImport.models;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

public class JsonFile {

    private final JFileChooser fileChooser = new JFileChooser();

    public JFileChooser setFile(){

        fileChooser.setDialogTitle("Choose the JSON file");
        fileChooser
                .setFileFilter(new FileNameExtensionFilter("JSON files", "json"));

        return fileChooser;
    }

}
