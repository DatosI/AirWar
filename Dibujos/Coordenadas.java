package Dibujos;

public class Coordenadas {
	
	private int x;
	private int y;
        int ancho=java.awt.Toolkit.getDefaultToolkit().getScreenSize().width;
        int alto= java.awt.Toolkit.getDefaultToolkit().getScreenSize().height;
	
	public Coordenadas(){										//Constructor dando coordenadas
		this.x=0;
		this.y=0;
	}
	public Coordenadas(int x,int y){
		this.x=x;
		this.y=y;
	}
	public Coordenadas(Coordenadas nueva){
		this.x=nueva.x;
		this.y=nueva.y;		
	}
	public int getX(){										//Metodos para poder manipular variables
		return this.x;
	}
	public int getY(){
		return this.y;
	}
	public void setX(int x){
		this.x=x;
	}
	public void setY(int y){
		this.y=y;
	}
	public Coordenadas Sumas(Coordenadas S){					//permite hacer la sumatoria de coordenadas para dpintar y despintar
            int Sumx=this.x;
            int Sumy=this.y;
            
            if(this.x+ S.getX()<ancho-150  &&  this.x+ S.getX()>0){
                Sumx=this.x+ S.getX();
            }
            if (this.y+ S.getY()<alto-150  && this.y+ S.getY()>0 ){
                Sumy=this.y+ S.getY();   
            }
            Coordenadas Cor=new Coordenadas(Sumx,Sumy);
	    return Cor;
		
	}
}

