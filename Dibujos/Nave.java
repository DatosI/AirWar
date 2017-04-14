package Dibujos;

import java.awt.Image;
import java.util.ArrayList;
import javax.swing.ImageIcon;

public class Nave extends Coordenadas {
        public String Nombre;
        public int puntaje;
        public boolean estado=true;
        public Coordenadas cor1= new Coordenadas();				//Coordenada de la izquierda													
	public Coordenadas cor2=new Coordenadas();				//Coordenada de la derecha
	public Image imagennave;
        public Image imagenfondo;
        public Image imagenbala;
        ArrayList Bala= new ArrayList();
	
    public Nave(){								//Constructores de la Nave
	super();
	this.cor1.setX(0);                                                      //Entrada Coordenadas de la izquierda y derecha
	this.cor1.setY(0);
	this.cor2.setX(0);
	this.cor2.setY(0);
        ImageIcon img=new ImageIcon(this.getClass().getResource("Usuario.png"));//Ponemos la imagen
        imagennave=img.getImage();
        ImageIcon img2=new ImageIcon(this.getClass().getResource("FondoGif.gif")); 
        imagenfondo=img2.getImage();
        ImageIcon img3=new ImageIcon(this.getClass().getResource("disparo1.jpg")); 
        imagenbala=img3.getImage();
        int ancho=java.awt.Toolkit.getDefaultToolkit().getScreenSize().width;
        int alto= java.awt.Toolkit.getDefaultToolkit().getScreenSize().height;           
    }
    
    public Nave(Coordenadas a, Coordenadas b, Coordenadas c){                   //Entrada de Coordenadas de nave
	super(a.getX(),a.getY());
		
	this.cor1.setX(b.getX());
	this.cor1.setY(b.getY());
	this.cor2.setX(b.getY());
	this.cor2.setY(b.getY());
    }
    
    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }    
    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public int getPuntaje() {
        return puntaje;
    }

    public void setPuntaje(int puntaje) {
        this.puntaje = puntaje;
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

    public Image getImagennave() {
        return imagennave;
    }

    public void setImagennave(Image imagennave) {
        this.imagennave = imagennave;
    }

    public Image getImagenfondo() {
        return imagenfondo;
    }

    public void setImagenfondo(Image imagenfondo) {
        this.imagenfondo = imagenfondo;
    }
	
    public Nave(Nave c){							//Entrada nuevas coordenadas
	super(c.getX(),c.getY());
	
	this.cor1.setX(c.getX());
	this.cor1.setY(c.getY());
	
	this.cor2.setX(c.getX());
	this.cor2.setY(c.getY());
		
    }
	
	
    public void SetVertice(Coordenadas nuevVertice,int lado){                   //Constructor del triangulo
	if (lado==1){
            this.setX(nuevVertice.getX());
            this.setY(nuevVertice.getY());
	}
	if (lado==2){
            
            this.cor1.setX(nuevVertice.getX());
            this.cor1.setY(nuevVertice.getY());
	}
	if (lado==3){
            this.cor2.setX(nuevVertice.getX());
            this.cor2.setY(nuevVertice.getY());
	}
    }
    
    public void mover(Coordenadas nuevacor){ 					//Funcion para mover el triangulo
	SetVertice(this.Sumas(nuevacor),1);
	SetVertice(this.cor1.Sumas(nuevacor),2);
	SetVertice(this.cor2.Sumas(nuevacor),3);
    }
	
}
