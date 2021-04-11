/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exer01.view;

import exer01.classes.Usuario;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

/**
 *
 * @author Guilherme Bruenning
 */
public class FXMLMainController implements Initializable {
    public Usuario usuario = new Usuario();
    
    @FXML
    private TextField inputUsers;

    @FXML
    private PasswordField inputPassword;


    @FXML
    private Label LabeTest;
   
    @FXML
    private void handleButtonAction(ActionEvent event) {
        
        usuario.setUsuario(inputUsers.getText());
        usuario.setSenha(inputPassword.getText());
        
        LabeTest.setText("Usuário: "+usuario.getUsuario()+"\n Senha: "+usuario.getSenha());
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         
    }    
}
