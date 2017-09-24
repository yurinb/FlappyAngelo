package GameScreen;

import java.awt.Image;
import javax.swing.ImageIcon;

public class Explosao {
    
    Image[] img;
    
    public Explosao(){
        img = new Image[9];
        ImageIcon img1 = new ImageIcon(getClass().getResource("/res/explosao1.png"));
        img[1] = img1.getImage();
        ImageIcon img2 = new ImageIcon(getClass().getResource("/res/explosao2.png"));
        img[2] = img2.getImage();
        ImageIcon img3 = new ImageIcon(getClass().getResource("/res/explosao3.png"));
        img[3] = img3.getImage();
        ImageIcon img4 = new ImageIcon(getClass().getResource("/res/explosao4.png"));
        img[4] = img4.getImage();
        ImageIcon img5 = new ImageIcon(getClass().getResource("/res/explosao5.png"));
        img[5] = img5.getImage();
        ImageIcon img6 = new ImageIcon(getClass().getResource("/res/explosao6.png"));
        img[6] = img6.getImage();
        ImageIcon img7 = new ImageIcon(getClass().getResource("/res/explosao7.png"));
        img[7] = img7.getImage();
        ImageIcon img8 = new ImageIcon(getClass().getResource("/res/explosao8.png"));
        img[8] = img8.getImage();
    }
    
}
