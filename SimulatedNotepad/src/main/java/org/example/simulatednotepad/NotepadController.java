package org.example.simulatednotepad;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.*;
import java.util.Scanner;

public class NotepadController {
    @FXML
    private VBox pane;
    @FXML
    private TextArea text;
    private Stage stage;
    private File file;
    @FXML
    public void Newfile(ActionEvent e){
        text.clear();
        stage= (Stage) pane.getScene().getWindow();
        stage.setTitle("Notepad-Untitled");
        this.file=null;
    }
    @FXML
    public void Open(ActionEvent e)  {
        FileChooser fileChooser= new FileChooser();
        fileChooser.setTitle("Open");
        FileChooser.ExtensionFilter stylefile1= new FileChooser.ExtensionFilter("Text documents(*.txt)","*.txt");
        FileChooser.ExtensionFilter stylefile2= new FileChooser.ExtensionFilter("All files", "*.*");
        fileChooser.getExtensionFilters().addAll(stylefile1,stylefile2);
        File fileopen= fileChooser.showOpenDialog(null);
        if(fileopen!=null){
            try {
                BufferedReader read= new BufferedReader(new FileReader(fileopen));
                StringBuilder content= new StringBuilder();
                String line;
                while ((line =read.readLine())!=null){
                    content.append(line).append("\n");
                }
                text.setText(content.toString());
                stage = (Stage) pane.getScene().getWindow();
                stage.setTitle("Notepad-"+fileopen.getName());
                this.file=fileopen;
            }catch (IOException ex){
                ex.printStackTrace();
            }
        }
    }
    @FXML
    public void Save(ActionEvent e) {
        if(file!=null){
            try {
                FileWriter fileWriter = new FileWriter(file);
                fileWriter.write(text.getText());
                fileWriter.close();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }
        else{
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Save");
            FileChooser.ExtensionFilter stylefile1= new FileChooser.ExtensionFilter("Text documents(*.txt)","*.txt");
            FileChooser.ExtensionFilter stylefile2=new FileChooser.ExtensionFilter("All files","*.*");
            fileChooser.getExtensionFilters().addAll(stylefile1,stylefile2);
            stage = (Stage) pane.getScene().getWindow(); // Lấy stage hiện tại

            File filesave = fileChooser.showSaveDialog(stage); // Truyền stage cho hộp thoại lưu

            if(filesave!=null){
                try {
                    FileWriter fileWriter= new FileWriter(filesave);
                    fileWriter.write(String.valueOf(text.getText()));
                    fileWriter.close();
                    stage.setTitle("Notepad-"+filesave.getName());
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        }
    }
    @FXML
    public void Saveas(){
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Save");
        FileChooser.ExtensionFilter stylefile1= new FileChooser.ExtensionFilter("Text documents(*.txt)","*.txt");
        FileChooser.ExtensionFilter stylefile2=new FileChooser.ExtensionFilter("All files","*.*");
        fileChooser.getExtensionFilters().addAll(stylefile1,stylefile2);
        File filesaveas=fileChooser.showSaveDialog(null);
        if(filesaveas!=null){
            try {
                FileWriter fileWriter= new FileWriter(filesaveas);
                fileWriter.write(String.valueOf(text.getText()));
                fileWriter.close();
                stage.setTitle("Notepad-"+filesaveas.getName());
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }
    }
    @FXML
    public void Close(ActionEvent e){
        Platform.exit();
        System.exit(0);
    }
}
