/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paqueteria;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.swing.JTable;

/**
 *
 * @author sergio
 */
public class GeneradorHTML {
    
    static File carpeta = new File("Reportes");
    
    public static void generarReprote(JTable tabla, String nombre, LocalDate fechaGenerado) {
        String head = "<!DOCTYPE html>\n"
                + "<html lang=\"en\">\n"
                + "<head>\n"
                + "    <meta charset=\"UTF-8\">\n"
                + "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n"
                + "    <meta http-equiv=\"X-UA-Compatible\" content=\"ie=edge\">\n"
                + "    <title>Reporte " + nombre + "</title>\n"
                + "</head>";
        String body1 = "<body>\n"
                + "    <div class=\"contenedor\">\n"
                + "        <header style=\"background-color: rgb(1, 141, 141);text-align: center\">\n"
                + "            <h1>" + nombre + "</h1>\n"
                + "        </header>";
        String table = "            <article style=\"    border: 4px solid rgb(0, 70, 70);text-align: center;font-family: monospace;font-size: 15px \">\n"
                + "                <h1>Tabla</h1>\n"
                + "                <ul >\n";
        String footer = "</ul>\n"
                + "            </article>\n"
                + "        </section>\n"
                + "        <footer style=\"text-align: right; background-color: aqua\">\n"
                + "            <br>\n"
                + "            Fecha Generado: " + fechaGenerado.format(DateTimeFormatter.ofPattern("dd/MM/YYYY")) + "\n"
                + "        </footer>\n"
                + "    </div>\n"
                + "</body>\n"
                + "\n"
                + "</html>";
        FileOutputStream archivo;
        try {
            
            archivo = crearArchivo(nombre);
            archivo.write(head.getBytes());
            archivo.write(body1.getBytes());
            archivo.write(table.getBytes());
            for (int i = 0; i < tabla.getColumnCount(); i++) {
                String linea = "<div style=\"display: inline-block;margin: auto;border: 1px solid black;font-size: 20px\">" + tabla.getColumnName(i);
                linea = linea + "<br>";
                for (int j = 0; j < tabla.getRowCount(); j++) {
                    linea = linea + tabla.getValueAt(j, i) + "<br>";
                    
                }
                linea = linea + "</div>";
                archivo.write(linea.getBytes());
            }
            archivo.write(footer.getBytes());
            
        } catch (IOException ex) {
            System.out.println("Error Al Generar");
        }
    }
    
    private static FileOutputStream crearArchivo(String nombre) throws FileNotFoundException, IOException {
        if (carpeta.exists() == false) { //Creacion de carpeta si no existe                
            carpeta.mkdir();
            carpeta.mkdirs();
        }
        int aux = 2;
        String name = nombre;
        while (new File(carpeta.getPath() + "/" + nombre + ".html").exists()) {
            nombre = name + String.valueOf(aux);
            aux++;
        }
        FileOutputStream guardar = new FileOutputStream(carpeta.getPath() + "/" + nombre + ".html");
        return guardar;
    }
    
}
