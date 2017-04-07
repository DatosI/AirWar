package Dibujos;

import java.awt.*;
import javax.swing.ImageIcon;

public class NaveGrafica extends Nave implements Dibujable {
	Color color;
        public Image imagennave;
        public Image imagenfondo;
        public Image imagenbala;
        public String Nombre;
        public int puntaje;
	
	public NaveGrafica(Coordenadas a,Coordenadas b, Coordenadas c, Color uncolor){						//Coordenadas del triangulo
		super(a,b,c);
		this.color=uncolor;
                ImageIcon img=new ImageIcon(this.getClass().getResource("Usuario.png")); /*Ponemos la imagen*/
                imagennave=img.getImage();
                ImageIcon img2=new ImageIcon(this.getClass().getResource("FondoGif.gif")); /*Ponemos la imagen*/
                imagenfondo=img2.getImage();
                ImageIcon img3=new ImageIcon(this.getClass().getResource("disparo1.jpg")); /*Ponemos la imagen*/
                imagenbala=img3.getImage();
               
        
	}

    public Image getImagenbala() {
        return imagenbala;
    }

    public void setImagenbala(Image imagenbala) {
        this.imagenbala = imagenbala;
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

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
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
	@Override																							//Porque ya esta en la interfaz
	public void dibujar(Graphics darreglo){                                 //Entrada dibujar el arreglo con las coordenadas 
		
		darreglo.setColor(color);
		int x[]={(int)this.getX(),(int)this.cor1.getX(),(int)this.cor2.getX()};											
		int y[]={(int)this.getY(),(int)this.cor1.getY(),(int)this.cor2.getY()};
		
		Polygon p= new Polygon(x,y,3);
		
		darreglo.fillPolygon(p);
		
	}
	public void pintar(Graphics darreglo, Color uncolor){			//Entrada para pintar el arreglo en las coordenadas
			
			darreglo.setColor(uncolor);
			int x[]={(int)this.getX(),(int)this.cor1.getX(),(int)this.cor2.getX()};
			int y[]={(int)this.getY(),(int)this.cor1.getY(),(int)this.cor2.getY()};
			
			Polygon p= new Polygon(x,y,3);				//Pinta el triangulo
			darreglo.fillPolygon(p);																		
		}
	public BalaGrafica Bala(){
		Coordenadas salida=new Coordenadas(this.getX()+65,this.getY());										//Coordenadas de la punta de la nave
		BalaGrafica bala=new BalaGrafica(salida,10,Color.GREEN,imagenbala);											//Creacion de la bala
                
		return bala;
	}
	public void Ciclo(){
		for(int i=0; i<this.Bala.size();i++){																//Que se mueve mientras sea menor a la cantidad de elementos a observar
			BalaGrafica y=(BalaGrafica)this.Bala.get(i);													//Traemos del arreglo el cual este en la pos i
			int x=y.getY();
			y.setY(x-=5);																					//Velocidad de la Bala
		}
	}
}
