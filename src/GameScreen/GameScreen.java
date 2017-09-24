package GameScreen;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.AffineTransform;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;
import view.GameOver;
import view.MenuLauncher;

public class GameScreen extends JPanel implements KeyListener, ActionListener {

    Timer timer;
    int delay = 8;
    List<Canos> canosList;
    int canosDelay;
    int birdPuloCount;
    
    int explosaoTimer;
    int explosaoCount;
    
    double birdCaiVel;
    public static int score;
    
    Graphics2D tela;

    Bird playerBird;
    Explosao explosao;
    private boolean gameOver;
    
    public GameScreen(int birdNumero) {
        explosao = new Explosao();
        // ATRIBUTOS NECESSARIOS DO JPANEL PRA PEGAR O TECLADO E outros
        addKeyListener(this);
        setFocusable(true);
        setDoubleBuffered(true);
        setFocusTraversalKeysEnabled(false); //??
        

        // CRIA BIRD
        if (birdNumero == 1) {
            ImageIcon tempImageBird = new ImageIcon(getClass().getResource("/Birds/PatrickBird.png"));
            playerBird = new Bird(tempImageBird.getImage());
            playerBird.retangulo.setBounds(playerBird.x + playerBird.imagem.getHeight(null) / 2 + 11, playerBird.y, 35, 50);
        }
        if (birdNumero == 2) {
            ImageIcon tempImageBird = new ImageIcon(getClass().getResource("/Birds/AngeloBird.png"));
            playerBird = new Bird(tempImageBird.getImage());
            playerBird.retangulo.setBounds(playerBird.x + playerBird.imagem.getHeight(null) / 2 + 8, playerBird.y, 35, 50);
        }
        if (birdNumero == 3) {
            ImageIcon tempImageBird = new ImageIcon(getClass().getResource("/Birds/MarcosBird_1.png"));
            playerBird = new Bird(tempImageBird.getImage());
            playerBird.retangulo.setBounds(playerBird.x + playerBird.imagem.getHeight(null) / 2 + 5, playerBird.y, 35, 50);
        }
        if (birdNumero == 4) {
            ImageIcon tempImageBird = new ImageIcon(getClass().getResource("/Birds/YuriBird.png"));
            playerBird = new Bird(tempImageBird.getImage());
            playerBird.retangulo.setBounds(playerBird.x + playerBird.imagem.getHeight(null) / 2 + 4, playerBird.y, 35, 50);
        }
        if (birdNumero == 5) {
            ImageIcon tempImageBird = new ImageIcon(getClass().getResource("/Birds/FrancineBird.png"));
            playerBird = new Bird(tempImageBird.getImage());
            playerBird.retangulo.setBounds(playerBird.x + playerBird.imagem.getHeight(null) / 2 + 7, playerBird.y, 35, 50);
        }
        if (birdNumero == 6) {
            ImageIcon tempImageBird = new ImageIcon(getClass().getResource("/Birds/SergioBird.png"));
            playerBird = new Bird(tempImageBird.getImage());
            playerBird.retangulo.setBounds(playerBird.x + playerBird.imagem.getHeight(null) / 2 + 8, playerBird.y, 35, 50);
        }

        // CRIA LISTA DE CANOS
        canosList = new ArrayList<Canos>();

        // SETA O TIMER QUE VAI ATUALIZAR A TELA E AS AÇOES
        timer = new Timer(delay, this);

        // STARTA O TIMER
        timer.start();

    }

    public void paint(Graphics g) {
        tela = (Graphics2D) g;
        if (GameInit.gameRunning) {
            // PRINTA FUNDO
            ImageIcon tempImageFundo = new ImageIcon(getClass().getResource("/res/gameBackground.png"));
            tela.drawImage(tempImageFundo.getImage(), 0, 0, this);
            // PRINTA CANOS E MOVE
            for (int i = 0; i < canosList.size(); i++) {
                tela.drawImage(canosList.get(i).imagem, canosList.get(i).x, canosList.get(i).y, this);
                canosList.get(i).move();
                if (canosList.get(i).x <= playerBird.x && canosList.get(i).birdPassed == false) {
                    score += 1;
                    canosList.get(i).birdPassed = true;
                }
                //remove cano quando passa da tela pra nao laggar
                if (canosList.get(i).x < -75) {
                    canosList.remove(i);
                }
            }
            //PRINTA BIRD
             //-------------movimento giratorio-------------
            if (playerBird.pulando) {
                AffineTransform birdAngulo = new AffineTransform();
                birdAngulo.translate(playerBird.x , playerBird.y );
                birdAngulo.rotate(Math.toRadians(45), playerBird.imagem.getWidth(null) / 2, playerBird.imagem.getHeight(null) / 2);
                tela.drawImage(playerBird.imagem, birdAngulo, this);
            } else {
                AffineTransform birdAngulo = new AffineTransform();
                birdAngulo.translate(playerBird.x, playerBird.y);
                birdAngulo.rotate(Math.toRadians(135), playerBird.imagem.getWidth(null) / 2, playerBird.imagem.getHeight(null) / 2);
                tela.drawImage(playerBird.imagem, birdAngulo, this);
            }
            //tela.drawRect(playerBird.retangulo.x, playerBird.retangulo.y, playerBird.retangulo.width, playerBird.retangulo.height);
            //-----------------------------------------------
            
// PRITA BIRD ESTATICO
            //tela.drawImage(playerBird.imagem, playerBird.x, playerBird.y, this);
//--------------------
            //libera ram liberando as antigas imagens.. alguma coisa asism, sei la na real
            tela.dispose();
        } else {
            explosaoTimer += 8;
            System.out.println("tic");
            if (explosaoTimer >= 40) {
                explosaoCount += 1;
                System.out.println("BOOM");
                tela.drawImage(explosao.img[explosaoCount], playerBird.x - playerBird.imagem.getWidth(null) / 2 - 40, playerBird.y - playerBird.imagem.getWidth(null) / 2 - 40, this);
                tela.dispose();
                explosaoTimer = 0;
                if (explosaoCount == 8) {
                        timer.stop();
                        this.gameOver = true;
                        repaint();
                                    if (gameOver) {
                                        GameOver gameOverScreen = new GameOver(this);
                                        gameOverScreen.setVisible(true);
                                        this.gameOver = false;
                                        GameInit.gameFrame.dispose();
                                    }
                    }
                }

        }
    }

    public void actionPerformed(ActionEvent e) {
        if (GameInit.gameRunning) {
            canosDelay += 5;
            if (canosDelay >= 1000) {
                canosList.add(new Canos(1));
                canosList.add(new Canos(2));

                canosDelay = 0;
            }
            //BIRD PULO
            if (playerBird.pulando == true) {
                birdCaiVel = 0;
                birdPuloCount += 5;
                // BIRD COMEÇA A SUBIR
                playerBird.y = playerBird.y - 3;
                // MOVE RETANGULO JUNTO
                playerBird.retangulo.y = playerBird.y;
                if (birdPuloCount >= 85) {// TEMPO DE SUBIDA
                    playerBird.pulando = false;
                    birdPuloCount = 0;
                }
            } else {
                // BIRD COMEÇA A CAIR
                birdCaiVel += 0.10;
                playerBird.y = (int) (playerBird.y + birdCaiVel);
                // MOVE RETANGULO JUNTO
                playerBird.retangulo.y = playerBird.y;
            }
            
            //============================================= COLISAO ==============
            // PAREDE
            if (playerBird.y >= 600 || playerBird.y <= 0) {
                
                this.gameOver = true;
                GameInit.gameRunning = false;
            }
            //============================================= COLISAO ==============
            // CANOS
            for (int i = 0; i < canosList.size(); i++) {
                if (playerBird.retangulo.intersects(canosList.get(i).retangulo)) {
                    
                    MenuLauncher.som.play("Colisao");
                    GameInit.gameRunning = false;
                }

            }

            //REPAINT
            repaint();
        } else {
            repaint();
        }
    }

//-----------------------------------------------COMANDOS DO TECLADO-----------------------------------
    public void keyTyped(KeyEvent e) {
    }

    public void keyPressed(KeyEvent e) {
        int x = e.getKeyCode();
        if (x == KeyEvent.VK_SPACE) {
            playerBird.pular();
        }
        if (x == KeyEvent.VK_ESCAPE) {
            System.exit(0);
        }

    }

    public void keyReleased(KeyEvent e) {
    }

}
