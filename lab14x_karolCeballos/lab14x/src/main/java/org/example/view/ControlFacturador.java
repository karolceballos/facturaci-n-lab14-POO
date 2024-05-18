package org.example.view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import org.example.controller.ControladorItems;
import org.example.model.Item;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ControlFacturador  {  //<Spinner fx:id="cantidad" layoutX="24.0" layoutY="47.0" />
private ControladorItems controlItems=new ControladorItems();
    ArrayList<String>nombrelist=new ArrayList<>();
    @FXML private TextField nombreProducto;

    @FXML private TextField precioUnitario;

    @FXML private Spinner<Integer> cantidad=new Spinner<Integer>();

    @FXML private Button agregar;

    @FXML private Button borrar;

    @FXML private ChoiceBox<String> listaProductos;
    @FXML private TableView<Item> tablaVista;

    @FXML private TableColumn<Item, String> articulo=new TableColumn<Item, String>("Nombre");

    @FXML private TableColumn<Item, Integer> cantidad2=new TableColumn<Item, Integer>("Cantidad");

    @FXML private TableColumn<Item, Integer> preciounitario2=new TableColumn<Item, Integer>("Precio_unitario");
    @FXML private TableColumn<Item, Float> precio2=new TableColumn<Item, Float>("Precio");
    @FXML
    private AnchorPane tablaDatos;

    @FXML
    private Label subtotl2;

    @FXML
    private Label iva2;

    @FXML
    private Label total2;


    @FXML
    void agregarProducto(ActionEvent event) {

       try{
          if(controlItems.buscarItem(nombreProducto.getText())!=null){//verifico si el nombre no esta en el maps
              controlItems.buscarItem(nombreProducto.getText()).setCantidad(cantidad.getValue());
              controlItems.buscarItem(nombreProducto.getText()).setPrecio_unitario(Integer.parseInt(precioUnitario.getText()));//lo convierto a integer
               controlItems.buscarItem(nombreProducto.getText()).setPrecio(controlItems.precio(Integer.parseInt(precioUnitario.getText()),cantidad.getValue()));//lo llevo a la funcion donde retorna float y ese lo guarda en el precio del objeto
             controlItems.agregarItem(nombreProducto.getText());//lo lleva a la funcion

              System.out.println("cuenta modificada");
          }
          else{
              System.out.println("nombre producto "+nombreProducto.getText()+" precio unitario "+ Integer.parseInt(precioUnitario.getText()));
              Item obj=new Item(nombreProducto.getText(),cantidad.getValue(),Integer.parseInt(precioUnitario.getText()));
              obj.setPrecio(controlItems.precio(Integer.parseInt(precioUnitario.getText()),cantidad.getValue()));//lo llevo a la funcion donde retorna float y ese lo guarda en el precio del objeto
              controlItems.agregarItem(nombreProducto.getText());//lo lleva a la funcion para mostrar aviso
              controlItems.getItems().put(nombreProducto.getText(),obj);//ya se agrego el objeto
             // listaProductos.getItems().add(nombreProducto.getText()); //lista box

              System.out.println("cuenta agregada");
          }
       }catch(Exception ex){//mira que error bota genericamente
            ex.printStackTrace();
        }

       renderWindow();// llama la funcion para que se muestre en la interfaz


    }

    @FXML
    void borrarItem(ActionEvent event) {

        if(controlItems.borrarItem(this.listaProductos.getValue())==true){
            Alert alert1=new Alert (Alert.AlertType.CONFIRMATION);
            crearAlerta1(alert1.getAlertType(),"alerta "," elemento borrado "+listaProductos.getValue(),"fin");

        }else{
            Alert alert2=new Alert (Alert.AlertType.ERROR);
            crearAlerta1(alert2.getAlertType(),"alerta ","no se pudo borrar el elemento","fin");


        }
        renderWindow();


    }

   public void llenarDatos(){

        this.subtotl2.setText("subtotal: "+Float.toString(controlItems.calcularSubtotal()));

        this.iva2.setText("IVA(16%): "+Float.toString(controlItems.calcularIVA()));
       this.total2.setText("Total: "+Float.toString(controlItems.calcularTotal()));

   }


    public void renderWindow(){  //pinta la ventana de las columnas
       cleanWindow();
        this.tablaVista.getItems().addAll(controlItems.getItems().values());
        llenarDatos();
   for(Item it:controlItems.getItems().values()){

      this.listaProductos.getItems().add(it.getNombre());


   }


    }

    public void cleanWindow(){
        tablaVista.getItems().clear();
        this.nombreProducto.clear();
        this.precioUnitario.clear();
        this.listaProductos.getItems().clear();

        //list_ids.getItems().clear();
    }

    private void crearAlerta1(Alert.AlertType tipo, String titulo, String tituloInterno, String mensaje ){
        Alert alert = new Alert(tipo);
        alert.setTitle(titulo);
        alert.setHeaderText(tituloInterno);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }

}

