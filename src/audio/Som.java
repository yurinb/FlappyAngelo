package audio;

import GameScreen.Bird;
import java.applet.Applet;
import java.applet.AudioClip;
import java.net.URL;

public class Som {
    
    AudioClip audioClick;
    AudioClip audioFundo;
    AudioClip audioColisao;
    AudioClip audioBaterAsa;
    
    public Som(){
        URL url = Bird.class.getResource("/audio/Click.wav"); // concatena o nome do audio com o formato dele
        audioClick = Applet.newAudioClip(url);
        URL url2 = Bird.class.getResource("/audio/Fundo.wav"); // concatena o nome do audio com o formato dele
        audioFundo = Applet.newAudioClip(url2);
        URL url3 = Bird.class.getResource("/audio/Colisao.wav"); // concatena o nome do audio com o formato dele
        audioColisao = Applet.newAudioClip(url3);
    }
    
    public void play(String nomeDoAudio){
        if (nomeDoAudio.equals("Click")) {
            audioClick.play();
        }
        if (nomeDoAudio.equals("Music")) {
            audioFundo.loop();
        }
        if (nomeDoAudio.equals("Colisao")) {
            audioColisao.play();
        }
        
    }
}


//    private static Sound musica;
//    
//    public static void play(String audio){
//        musica = new Sound(URL.audio(audio));
//        stop();  //começa com o metodo stop pra poder executar uma nova musica e não intercalar elas
//        Som.musica.play();          //som não pode parar até o final do jogo
//        Som.musica.setRepeat(true); // quando acabar o som ele repete até o boneco morrer
//      
//    }
//    
//    public static void stop(){      //metodo para parar a musica
//        if (Som.musica != null) {
//            musica.stop();
//        }
//    }
    


