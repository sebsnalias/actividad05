/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import models.ModelRfc;
import views.ViewRfc;
import java.util.Scanner;
/**
 *llama las variables en modelRFC para su uso 
 * @author Sebastián
 */
public class ControllerRfc implements ActionListener {
    ModelRfc modelRfc;
    ViewRfc viewRfc;
    public ControllerRfc(ViewRfc viewRfc, ModelRfc modelRfc){
        this.viewRfc = viewRfc;
        this.modelRfc = modelRfc;
        viewRfc.jb_rfc.addActionListener(this);
        initComponents();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==viewRfc.jb_rfc){
            rfc();
        }   
    }
    /**
     * realiza el proceso de extraer los caracteres de los textos introducidos
     */
    public void rfc(){
        Scanner leer = new Scanner(System.in);
        
        String nombre, appaterno, apmaterno, anio, mes, dia, rfc;
        
        modelRfc.setNombre(viewRfc.jtf_nombre.getText());
        modelRfc.setAppaterno(viewRfc.jtf_a_peterno.getText());
        modelRfc.setApmaterno(viewRfc.jtf_a_materno.getText());
        modelRfc.setAnio(viewRfc.jtf_anio.getText());
        modelRfc.setMes(viewRfc.jtf_mes.getText());
        modelRfc.setDia(viewRfc.jtf_dia.getText());
        modelRfc.setRfc(viewRfc.jl_rfcMessage.getText());
        
        nombre = String.valueOf(viewRfc.jtf_nombre.getText());
        appaterno = String.valueOf(viewRfc.jtf_a_peterno.getText());
        apmaterno = String.valueOf(viewRfc.jtf_a_materno.getText());
        anio = String.valueOf(viewRfc.jtf_anio.getText());
        mes = String.valueOf(viewRfc.jtf_mes.getText());
        dia = String.valueOf(viewRfc.jtf_dia.getText());
        
        
        switch(mes){
            case "1":mes ="01";break;
            case "2":mes ="02";break;
            case "3":mes ="03";break;
            case "4":mes ="04";break;
            case "5":mes ="05";break;
            case "6":mes ="06";break;
            case "7":mes ="07";break;
            case "8":mes ="08";break;
            case "9":mes ="09";break;
            case "10":mes ="10";break;
            case "11":mes ="11";break;
            case "12":mes ="12";break;
             
            default:
                JOptionPane.showMessageDialog(null, "Error" );
        }
        rfc = appaterno.trim().substring(0, 2);
        rfc = rfc.concat(apmaterno.trim().substring(0, 1));
        rfc = rfc.concat(nombre.trim().substring(0, 1));
        rfc = rfc.concat(anio.substring(2, 4));
        rfc = rfc.concat(mes);
        rfc = rfc.concat(dia);
        
        modelRfc.setRfc(String.valueOf(rfc));
        viewRfc.jl_rfcMessage.setText("Tu RFC es: " +rfc.toLowerCase());
    }
    public final void initComponents(){
        viewRfc.setVisible(true);
        viewRfc.jl_rfcMessage.setText(modelRfc.getRfc());
    }
}
