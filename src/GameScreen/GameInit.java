package GameScreen;

import javax.swing.JFrame;

public class GameInit {

    static boolean gameRunning;
    
    public static JFrame gameFrame;

    public GameInit(int birdNumero) {

        gameRunning = true;

        gameFrame = new JFrame();

        gameFrame.setBounds(0, 0, 600, 600);
        gameFrame.setResizable(false);
//        jframe.setUndecorated(true);
        gameFrame.setLocationRelativeTo(null);
        gameFrame.setTitle("Flappy Angelo");

        GameScreen gameScreen = new GameScreen(birdNumero);
        gameScreen.setBounds(0, 0, 600, 600);

        gameFrame.add(gameScreen);
        gameFrame.setVisible(true);
    }

}
