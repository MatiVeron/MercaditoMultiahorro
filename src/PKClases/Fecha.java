/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PKClases;

import java.text.SimpleDateFormat;
import java.util.Date;




public class Fecha {

    public String fechaActual(){
    Date fecha = new Date();
    SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/YYYY");
    return formatoFecha.format(fecha);


}     

}


