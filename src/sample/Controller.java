package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;


import java.io.IOException;
import java.io.*;
import java.util.Scanner;

public class Controller {
    @FXML private TextField user;
    @FXML private PasswordField password;

public void sesion(ActionEvent event){
 archivo();
acceso(user.getText(),password.getText());




}

    public  void  archivo (){

        File login=new File("Seguridad");
        try{
            if (!login.exists()){
                login.createNewFile();
                contrasena();
            }

        }
        catch (IOException e){
            System.out.println("Error: "+e);
        }
    }
    public void acceso(String nom,String pass){
    boolean r=false;
    archivo();
    File datos=new File("Seguridad");
        try {
            Scanner entrada=new Scanner(datos);
            while(entrada.hasNextLine()){
                String informacion=entrada.nextLine();
                String d[]=informacion.split(" ");

                if (nom.equals(d[0])&& pass.equals(d[1])){
                    Alert mensaje=new Alert(Alert.AlertType.INFORMATION);
                    mensaje.setTitle("Informacion");
                    mensaje.setHeaderText("Acceso Concedido");
                    mensaje.setContentText(" Bienvenido "+ user.getText());
                    mensaje.showAndWait();

                        cargar("Votar.fxml");
                    }
                else{
                    Alert mensaje=new Alert(Alert.AlertType.INFORMATION);
                    mensaje.setTitle("Informacion");
                    mensaje.setHeaderText("Acceso Denegado");
                    mensaje.setContentText(" Usuario o contrasena incorrectos ");
                    mensaje.showAndWait();

                }


            }
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public void contrasena(){
        try {
            FileWriter ingresar=new FileWriter("Seguridad");
            ingresar.write("admin password");
            ingresar.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void cargar(String formulario) throws IOException {
        FXMLLoader frm=new FXMLLoader(getClass().getResource(formulario));
        Parent root=frm.load();
        Controller controlador=frm.getController();
        Scene t=new Scene(root);
        Stage u=new Stage();
        u.initModality(Modality.APPLICATION_MODAL);
        u.setScene(t);
        u.showAndWait();
    }
    /*
    public void Crear(){
        File login=new File("Seguridad");
        try{
            if (!login.exists()){
                login.createNewFile();
                contrasena();
            }


        }
        catch (IOException e){
            System.out.println("Error: "+e);
        }
    }

     */
    }


