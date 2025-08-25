/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import java.util.Random;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * Classe utilitaria que contem metodos estaticos para movimentacao
 * dos elementos do jogo (bola e goleiro).
 * @author Miguel
 */
public class Movimenta {
    
    /**
     * Move o botao para cima.
     * @param botao
     * @return 
     */
    public static boolean irCima(JButton botao) {
        if (botao.getY() > 0) {
            botao.setBounds(botao.getX(), botao.getY() - 5, botao.getWidth(), botao.getHeight());
            return true;
        }
        return false;
    }

    /**
     * Move o botao para esquerda.
     * @param botao
     * @return 
     */
    public static boolean irEsquerda(JButton botao) {
        if (botao.getX() > 0) {
            botao.setBounds(botao.getX() - 5, botao.getY(), botao.getWidth(), botao.getHeight());
            return true;
        }
        return false;
    }

    /**
     * Move o botao para baixo.
     * @param botao
     * @param alturaPanel
     * @return 
     */
    public static boolean irBaixo(JButton botao, int alturaPanel) {
        if (botao.getY() < alturaPanel - botao.getHeight()) {
            botao.setBounds(botao.getX(), botao.getY() + 5, botao.getWidth(), botao.getHeight());
            return true;
        }
        return false;
    }

    /**
     * Move o botao para direita.
     * @param botao
     * @param largura
     * @return 
     */
    public static boolean irDireita(JButton botao, int largura) {
        if (botao.getX() < largura - botao.getWidth()) {
            botao.setBounds(botao.getX() + 5, botao.getY(), botao.getWidth(), botao.getHeight());
            return true;
        }
        return false;
    }
    
    /**
     * Reposiciona a bola no centro do campo apos um gol.
     * @param bola
     * @param frame 
     */
    private static void resetBola(JButton bola, JFrame frame) {
        bola.setLocation(
            frame.getWidth() / 2 - bola.getWidth() / 2,
            frame.getHeight() / 2 - bola.getHeight() / 2
        );
    }
    
    /**
     * Movimenta a bola em diagonal, com rebotes nas paredes
     * e colisao com os goleiros.
     * Contabiliza gols.
     * @param bola
     * @param frame
     * @param goleiro1
     * @param goleiro2
     * @param gols1
     * @param gols2 
     */
    public static void movimentaBola(JButton bola, JFrame frame, JButton goleiro1, JButton goleiro2, JTextField gols1, JTextField gols2) {
        int velX = 5; // velocidade no eixo X
        int velY = 5; // velocidade no eixo Y
        
        int limiteDireita = frame.getContentPane().getWidth() - bola.getWidth();
        int limiteBaixo = frame.getContentPane().getHeight() - bola.getHeight();

        while (true) {
            try {
                Thread.sleep(15); // controla a velocidade do jogo
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            // Move a bola
            bola.setLocation(bola.getX() + velX, bola.getY() + velY);

            // Colisao com borda superior/inferior
            if (bola.getY() <= 0) {
                velY = -velY;
                bola.setLocation(bola.getX(), 0);
            } else if (bola.getY() >= limiteBaixo) {
                velY = -velY;
                bola.setLocation(bola.getX(), limiteBaixo);
            }

            // Colisao com goleiros
            if (bola.getBounds().intersects(goleiro1.getBounds())) {
                velX = Math.abs(velX); // garante que a bola vai pra direita
                bola.setLocation(goleiro1.getX() + goleiro1.getWidth(), bola.getY());
            }
            if (bola.getBounds().intersects(goleiro2.getBounds())) {
                velX = -Math.abs(velX); // garante que a bola vai pra esquerda
                bola.setLocation(goleiro2.getX() - bola.getWidth(), bola.getY());
            }

            // Gol na direita
            if (bola.getX() >= frame.getWidth() - bola.getWidth()) {
                int gol1 = Integer.parseInt(gols1.getText().isEmpty() ? "0" : gols1.getText()) + 1;
                gols1.setText(String.valueOf(gol1));
                resetBola(bola, frame);
                velX = -Math.abs(velX);
                velY = (Math.random() > 0.5) ? Math.abs(velY) : -Math.abs(velY);
            }

            // Gol na esquerda
            if (bola.getX() <= 0) {
                int gol2 = Integer.parseInt(gols2.getText().isEmpty() ? "0" : gols2.getText()) + 1;
                gols2.setText(String.valueOf(gol2));
                resetBola(bola, frame);
                velX = Math.abs(velX);
                velY = (Math.random() > 0.5) ? Math.abs(velY) : -Math.abs(velY);
            }
        }
    }
    
}
