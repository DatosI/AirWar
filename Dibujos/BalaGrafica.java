package Dibujos;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;

public class BalaGrafica extends Bala implements Dibujable{
	
	Color color;
        public Image imagenbala;
	
	public BalaGrafica(Coordenadas ba, float radio, Color Uncolor){		//Recibe la coordenadas de bala con su radio
		super(ba,radio);
		this.color=Uncolor;
                ImageIcon img3=new ImageIcon(this.getClass().getResource("disparo1.jpg")); /*Ponemos la imagen*/
                imagenbala=img3.getImage();
               
	}
	@Override
	public void dibujar(Graphics darreglo){
		darreglo.setColor(color);
		darreglo.fillOval((int)(this.getX()-this.getRadio()),(int)(this.getY()-this.getRadio()),(int)(2*this.getRadio()),(int)(2*this.getRadio())); //Dibujar el ovalo de la bala 
		Coordenadas salida=new Coordenadas(this.getX()+65,this.getY());										//Coordenadas de la punta de la nave
                darreglo.drawImage(imagenbala, (int)(this.getX()-this.getRadio()), (int)(this.getY()-this.getRadio()), 10, 10, null);
                
		BalaGrafica bala=new BalaGrafica(salida,10,Color.YELLOW);
	}

}
