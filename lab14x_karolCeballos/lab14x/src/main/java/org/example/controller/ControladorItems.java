package org.example.controller;

import javafx.scene.control.Alert;
import org.example.model.Item;

import java.util.HashMap;
import java.util.Map;

public class ControladorItems {
    private Map<String, Item> Items= new HashMap<>();

    public Map<String, Item> getItems() {
        return Items;
    }

    public void setItems(Map<String, Item> items) {
        Items = items;
    }


    public void agregarItem(String nombre){

        if(buscarItem(nombre)!=null){
            System.out.println("holaaaaaaaaa");
         Alert alert1=new Alert (Alert.AlertType.WARNING);                 //modificar
            crearAlerta(alert1.getAlertType(),"alerta","el item ha sido actualizado","brutal");

        }else{
            Alert alert=new Alert (Alert.AlertType.CONFIRMATION);
            crearAlerta(alert.getAlertType(),"alerta","el item ha sido creado ","brutal2");

        }





    }


    public Item buscarItem(String nombre){
        if(this.Items.containsKey(nombre)){  //busca si existe el nombre del objeto
            return this.Items.get(nombre); //retorna el objeto
        } else return null;

    }


    public boolean borrarItem(String nombre){
        Item borrar=buscarItem( nombre);
        if(borrar!=null){
            Items.remove(nombre,borrar);
            return true;
        }
        return false;
    }

    public float calcularSubtotal(){
        float subtotal=0;
        for(Item itm: this.Items.values()){ //recorre objeto en vez de llaves
            subtotal+=itm.getPrecio();
        }
        return subtotal;
    }

    public float calcularIVA(){

        return (this.calcularSubtotal()*0.16f);


    }

    public float calcularTotal(){

        return this.calcularSubtotal()+this.calcularIVA();
    }

   public float precio(Integer precioUnidad,Integer cantidad){

        return (float)(precioUnidad*cantidad);
   }

   private void crearAlerta(Alert.AlertType tipo, String titulo, String tituloInterno, String mensaje ){
        Alert alert = new Alert(tipo);
        alert.setTitle(titulo);
        alert.setHeaderText(tituloInterno);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }




}
