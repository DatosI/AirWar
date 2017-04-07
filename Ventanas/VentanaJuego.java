package Ventanas;

import Dibujos.Coordenadas;
import Dibujos.NaveGrafica;
import Dibujos.Panel;
import Dibujos.Ventana;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;

public class VentanaJuego{
    public Image imagennave;
    public Image imagenfondo;
    public String nombre;
    public int puntaje;
    JLabel fondo=new javax.swing.JLabel();
    JLabel nombrej=new javax.swing.JLabel();
    
    
    int ancho=java.awt.Toolkit.getDefaultToolkit().getScreenSize().width;
    int alto= java.awt.Toolkit.getDefaultToolkit().getScreenSize().height;
    
    

    public VentanaJuego(String nombre) {
        this.nombre=nombre;
        
    }
    
    
    
    
    
    public void run(){
        
    
    Ventana nueva_ventana=new Ventana("AirWar");										//Coordenadas necesarias para la bala y el triangulo
		Coordenadas cor1=new Coordenadas(250,250);
		Coordenadas cor2= new Coordenadas(100,300);
		Coordenadas cor3= new Coordenadas(125,100);  //PUNTA
		Coordenadas cor4= new Coordenadas(100,200);	 //ESQUINA IZQ
		Coordenadas cor5= new Coordenadas(150,200);	 //ESQUINA DER
		NaveGrafica nave= new NaveGrafica(cor3,cor4,cor5,Color.RED);							//Dibujo de la Nave
		//BalaGrafica Bala=new BalaGrafica(cor2,50,Color.BLUE);									//Dibujo de la bala
		NaveGrafica ifondo= new NaveGrafica(cor3,cor4,cor5,Color.RED);
		ArrayList arreglodeobjetos= new ArrayList();											//Arreglo de los objetos que aparecen en pantalla
		Panel nuevopanel=new Panel(arreglodeobjetos);    										//Panel le damos listo de arreglos 
		 ImageIcon img=new ImageIcon(this.getClass().getResource("Usuario.png")); /*Ponemos la imagen*/
                imagennave=img.getImage();
                ImageIcon img2=new ImageIcon(this.getClass().getResource("FondoGif.gif")); /*Ponemos la imagen*/
                imagenfondo=img2.getImage();
		nuevopanel.refNave(nave);																//Obtenemos la ref de la nave para moverla
               /*
		//arreglodeobjetos.add(Bala);																//A�adimos la bala al arreglo
		arreglodeobjetos.add(nave);																//A�adimos la nave al arreglo
		arreglodeobjetos.add(ifondo);
                nuevopanel.add(imagennave);
                nuevopanel.setContentPane(imagenfondo);
                */
                int ancho=java.awt.Toolkit.getDefaultToolkit().getScreenSize().width;
                int alto= java.awt.Toolkit.getDefaultToolkit().getScreenSize().height;
                
                fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("FondoGif.gif"))); 
                fondo.setVisible(true);
              
                nombrej.setText(nave.Nombre);
                nombrej.setVisible(true);
                nuevopanel.add(fondo);
                fondo.setVisible(true);
                nuevopanel.add(nombrej);
                
                 
            
                nueva_ventana.add(fondo);
                //nueva_ventana.add(nombrej);
                nueva_ventana.add(nuevopanel);	
                nueva_ventana.setSize(ancho,alto);
                nueva_ventana.setBounds((ancho / 2) - ( nueva_ventana.getWidth() / 2), (alto / 2) - ( nueva_ventana.getHeight() / 2),ancho, alto);
		nueva_ventana.setVisible(true);	
                
		nuevopanel.iniciar();
               // nueva_ventana.setVisible(true);
		
	}
}