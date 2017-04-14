package enemy.test;




import java.awt.Image;
import java.util.Random;
import javax.swing.ImageIcon;

public class EnemyTest {
    private int attack;
    private int life;
    private int move;
    private String image;
    private int x=500;
    private int y=0;
    private Image photo;
    public Image imagenjet;


   

    public EnemyTest(int atk, int def, int mov, String imagen) throws InterruptedException{
        this.attack = atk;
        this.life = def;
        this.move = mov;
        this.image = imagen;
        ImageIcon img = new ImageIcon(this.getClass().getResource(this.image));
        Image photo = img.getImage();
        ImageIcon img2=new ImageIcon(this.getClass().getResource("Jet.png"));//Ponemos la imagen
        imagenjet=img2.getImage();
        //this.Move();
        //this.Damage();
     
        
                

    }

    public void show() {
        this.x = 1400;
        this.y = 500;
    }

    public int GetAttack() {
        return this.attack;
    }

    public int GetLife() {
        return this.life;
    }

    public int GetMove() {
        return this.move;
    }

    public void Move() throws InterruptedException {
        if(this.move == 0) {
            ;
        }
        Random random = new Random();
        if(random.nextInt(2)==1){
            x = x- random.nextInt(10);
        }
        if(random.nextInt(2)==2){
            x = x+ random.nextInt(10);
        }
        //x = x- random.nextInt(this.GetMove());
        //x = x+ random.nextInt(10);
        y = y+ random.nextInt(10);
        Thread.sleep(20);
        //this.Move();
    }

    public Image GetImagen() {
        throw new RuntimeException("Uncompilable source code - incompatible types: java.lang.String cannot be converted to java.awt.Image");
    }

    public void powerUp() {
        Random random = new Random();
        if(random.nextInt(4) == 0) {
            ;
        }

    }

    public void Hurt() {
        --this.life;
        if(this.life == 0) {
            ;
        }

    }

    private void Damage() throws InterruptedException {
        Thread.sleep(2L);
        //this.Damage();
    }

    public Image getPhoto() {
        return photo;
    }

    public void setPhoto(Image photo) {
        this.photo = photo;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
    
    
    
}

