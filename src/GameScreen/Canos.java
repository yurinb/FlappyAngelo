package GameScreen;

import java.awt.Image;
import java.awt.Rectangle;
import java.util.Random;
import javax.swing.ImageIcon;

public class Canos {

    int x, y;
    int vel;
    int numCano;
    
    boolean birdPassed;
    
    Image imagem;

    Random r;

    Rectangle retangulo;

    public Canos(int numCano) {
        // CRIA RETANGULO USADO PARA COLISAO
        r = new Random();
        retangulo = new Rectangle();
        if (numCano == 1) {
            ImageIcon tempImageCano = new ImageIcon(getClass().getResource("/res/gameObstacle.png"));
            imagem = tempImageCano.getImage();
            this.numCano = 1;
            this.y = 285 + r.nextInt(50);
            this.x = 600;
            this.vel = 2;
            // SETA POSICAO E TAMANHO DO RETANGULO
            retangulo.setBounds(this.x, this.y, imagem.getWidth(null), imagem.getHeight(null));
        }
        if (numCano == 2) {
            ImageIcon tempImageCano = new ImageIcon(getClass().getResource("/res/gameObstacleInvert.png"));
            imagem = tempImageCano.getImage();
            this.numCano = 2;
            this.x = 600;
            this.y = -360 + r.nextInt(50);
            this.vel = 2;
            // SETA POSICAO E TAMANHO DO RETANGULO
            retangulo.setBounds(this.x, this.y, imagem.getWidth(null), imagem.getHeight(null));
        }
    }

    public void move() {
        this.x -= 1;
        retangulo.setBounds(this.x, this.y, imagem.getWidth(null), imagem.getHeight(null));
    }

}
