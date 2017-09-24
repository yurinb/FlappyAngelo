package GameScreen;

import java.awt.Image;
import java.awt.Rectangle;

public class Bird {
    
    Image imagem;
    
    Rectangle retangulo;
    
    boolean pulando;
    
    int velMov;
    
    int velJump;
    
    int x;
    
    int y;
    
    public Bird(Image imagem){
        retangulo = new Rectangle();
        this.imagem = imagem;
        this.x = 150;//posicao HORIZONTAL em que ele vai ficar na tela (fixo)
        this.y = 225;//posicao VERTICAL inicial
        // RETANGULO DE COLISAO
        retangulo.setBounds(this.x, this.y, imagem.getWidth(null), imagem.getHeight(null));
    }
    
    public void pular(){
        pulando = true;
    }
    
}
