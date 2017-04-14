package enemy.test;





import enemy.test.EnemyTest;
import java.awt.Image;
import java.util.Random;

public class Boss extends EnemyTest {
    
    private int attack;
    private int life;
    private int move;
    private String image;
    private int x;
    private int y;

    public Boss(int atk, int def, int mov, String image) throws InterruptedException {
        throw new RuntimeException("Uncompilable source code - Erroneous sym type: enemy.test.EnemyTest.<init>");
    }

    Boss(int i, int i0, String boss6png) {
        throw new RuntimeException("Uncompilable source code - Erroneous sym type: enemy.test.EnemyTest.<init>");
    }

    public void show() {
        throw new RuntimeException("Uncompilable source code - Erroneous sym type: random.nextInt");
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
        Random random = new Random();
        this.x -= random.nextInt(this.GetMove());
        this.x += random.nextInt(5);
        Thread.sleep(1L);
        this.Move();
    }

    public Image GetImagen() {
        throw new RuntimeException("Uncompilable source code - incompatible types: java.lang.String cannot be converted to java.awt.Image");
    }

    public void Hurt() {
        --this.life;
        if(this.life == 0) {
            ;
        }

    }

    public void Damage() throws InterruptedException {
        Thread.sleep(2L);
        this.Damage();
    }

    static {
        throw new RuntimeException("Uncompilable source code - constructor Boss(int,int,int,java.lang.String) is already defined in class enemy.test.Boss");
    }

}
