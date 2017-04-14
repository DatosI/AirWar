package Dibujos;

import java.awt.Image;
import javax.swing.ImageIcon;

public class Bala extends Coordenadas{
    public boolean estado=false;

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
	private float radio;
        public Coordenadas cor1= new Coordenadas();				//Coordenada de la izquierda													
	public Coordenadas cor2=new Coordenadas();
	public Image imagenbala;
        
//Coordenadas de la bala
    public Bala(){
	super();								
	this.radio=0;
        ImageIcon img3=new ImageIcon(this.getClass().getResource("disparo1.jpg")); //Ponemos la imagen
        imagenbala=img3.getImage();
        int ancho=java.awt.Toolkit.getDefaultToolkit().getScreenSize().width;
        int alto= java.awt.Toolkit.getDefaultToolkit().getScreenSize().height;
    }
    
    
    public Bala(Coordenadas nueva,float r){                                     //Constructores de bala
	super(nueva);
	this.radio=r;
    }

    public Coordenadas getCor1() {
        return cor1;
    }

    public void setCor1(Coordenadas cor1) {
        this.cor1 = cor1;
    }

    public Coordenadas getCor2() {
        return cor2;
    }

    public void setCor2(Coordenadas cor2) {
        this.cor2 = cor2;
    }

    public Image getImagenbala() {
        return imagenbala;
    }

    public void setImagenbala(Image imagenbala) {
        this.imagenbala = imagenbala;
    }
	
    public Bala(Bala ba){
	super(ba);
	this.radio=ba.radio;
    }
    
    public float getRadio(){							//Metodos para manipular la variable
	return this.radio;
    }
    
    public void setRadio(float r){						//Cambiar radio de la bala
	this.radio=r;
    }

    public Coordenadas getCentro(){						//Coordenadas de la bala
	Coordenadas nueva=new Coordenadas(this.getX(),this.getY());
	return nueva;
    }
}

