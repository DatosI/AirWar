package Ejecuciones;

import Dibujos.*;																				//Poder acceder a las clases dentro de dibujos
import Dibujos.Panel;
import Servidor.MainServer;
import Ventanas.Interfaz;
import Ventanas.Interfaz_Juego;
import Ventanas.Interfaz_Opciones;
import Ventanas.Interfaz_Records;
import Ventanas.NewJPanel;
import Ventanas.VentanaJuego;
import enemy.test.ColaEnemigos;

import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;



public class Main {
    

	public static void main(String[] args) throws IOException, InterruptedException {
            
            
            new Partida().run();
         /*   
            Interfaz VentanaPrincipal = new Interfaz();
            Interfaz_Opciones VentanaOpciones = new Interfaz_Opciones(VentanaPrincipal);
            Interfaz_Records VentanaRecords = new Interfaz_Records(VentanaPrincipal);
            Interfaz_Juego VentanaNombre = new  Interfaz_Juego();
            VentanaJuego Juego = new VentanaJuego("nombre");
            MainServer Servidor= new  MainServer();
            
           
            VentanaRecords.Records();
            
            VentanaPrincipal.setVisible(true);
            //new NewJPanel().setVisible(true);
            ColaEnemigos cola=new ColaEnemigos();
           // cola.filled();
            
            while(Juego.isEstado()){
                VentanaPrincipal.setEstado(true);
               
                
                while(VentanaPrincipal.isEstado()){
                    VentanaNombre.setVisible(false);
                    
                    if (!VentanaNombre.isEstado2()){
                        VentanaNombre.setEstado2(true);
                        VentanaPrincipal.setVisible(true);                       
                    }
                    while (!VentanaPrincipal.isEstado2()){
                        VentanaOpciones.setVisible(true);
                        if (VentanaOpciones.isEstado()){
                         //System.out.print("ss");
                            Servidor.run();
                            if (Servidor.isEstado()){
                                VentanaOpciones.avisar(); 
                            }
                        VentanaOpciones.setEstado(false);
                        }
                    }
                }
                while(VentanaNombre.isEstado()){
                    VentanaNombre.setVisible(true);
                }
                if (VentanaNombre.isEstado2()){
                    
                        
                    //Juego.setNombre(VentanaNombre.getNombre());
                     
                    Juego.run();
                }
            Juego.setEstado(true);
   
            }

*/
        }   
   
}

