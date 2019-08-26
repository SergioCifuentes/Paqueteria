/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paqueteria.ui.Administracion;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import paqueteria.Ruta.Ruta;

/**
 *
 * @author sergio
 */
public class GeneradorGraphviz {

    private static File carpeta = new File("Reportes");

    public static void generar(Ruta ruta) throws IOException {
        FileOutputStream archivo = crearArchivo("Imagen" + ruta.getCodigo());
        //Inicio del archivo
        String im = "digraph Imagen" + ruta.getCodigo() + " {\n"
                + "\n"
                + "        Bodega -> ";
        archivo.write(im.getBytes());
        String puntos = "";
        //por cada punto de control se mostrara su codigo en el archivo
        for (int i = 0; i < ruta.getPuntos().size(); i++) {
            puntos = puntos + ruta.getPuntos().get(i).getCodigo() + "\n"
                     + ruta.getPuntos().get(i).getCodigo() + " -> ";
        }
        archivo.write(puntos.getBytes());
        String fin =ruta.getDestino().getNombre()+"\n"
                + "}";
        archivo.write(fin.getBytes());
    }

    private static FileOutputStream crearArchivo(String nombre) throws FileNotFoundException, IOException {
        if (carpeta.exists() == false) { //Creacion de carpeta si no existe                
            carpeta.mkdir();
            carpeta.mkdirs();
        }
        int aux = 2;
        String name = nombre;
        while (new File(carpeta.getPath() + "/" + nombre + ".dot").exists()) {
            nombre = name + String.valueOf(aux);
            aux++;
        }
        FileOutputStream guardar = new FileOutputStream(carpeta.getPath() + "/" + nombre + ".dot");
        return guardar;
    }
}
