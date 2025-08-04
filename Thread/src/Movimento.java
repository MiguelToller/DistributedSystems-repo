
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JFrame;

/***
 * classe responsavel por movimentar componentes botoes para cima, baixo, esquerda e direita
 * @author Miguel
 */
public class Movimento {
    
    public static void cima(JButton btn) {
        if (btn.getY() > 0)
            btn.setBounds(btn.getX(), btn.getY() - 10, btn.getWidth(), btn.getHeight());
    }
    public static void baixo(JButton btn, JFrame frame) {
        int limiteInferior = frame.getContentPane().getHeight() - btn.getHeight();
        if (btn.getY() < limiteInferior)
            btn.setBounds(btn.getX(), btn.getY() + 10, btn.getWidth(), btn.getHeight());
    }
    public static void esquerda(JButton btn) {
        if (btn.getX() > 0)
            btn.setBounds(btn.getX() - 10, btn.getY(), btn.getWidth(), btn.getHeight());
    }
    public static void direita(JButton btn, JFrame frame) {
        int limiteDireita = frame.getContentPane().getWidth() - btn.getWidth();
        if (btn.getX() < limiteDireita)
            btn.setBounds(btn.getX() + 10, btn.getY(), btn.getWidth(), btn.getHeight());
    }
    
    public static void sorteiaPosicao(JButton btn, JFrame frame) {
        Random generator = new Random();
        int limiteInferior = frame.getContentPane().getHeight() - btn.getHeight();
        int limiteDireita = frame.getContentPane().getWidth() - btn.getWidth();
        int x = generator.nextInt(10, limiteDireita);
        int y = generator.nextInt(10, limiteInferior);
        
        btn.setBounds(x, y, btn.getWidth(), btn.getHeight());
    }
    
}
