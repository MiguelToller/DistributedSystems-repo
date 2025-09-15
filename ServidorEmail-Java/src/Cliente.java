
import java.awt.HeadlessException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import javax.swing.JOptionPane;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author laboratorio
 */
public class Cliente {
    public static void main(String[] args) {
        try {
          int porta = 50000;      
          String nome = JOptionPane.showInputDialog(null,"Nome completo");

          Socket cliente = new Socket("localhost",porta);   
          // Enviar o nome do cliente

          ObjectOutputStream saida = new ObjectOutputStream(cliente.getOutputStream());
          saida.flush();
          saida.writeObject(nome);

          // Receber o objeto criado
          ObjectInputStream entrada = new ObjectInputStream(cliente.getInputStream());
          Pessoa p = (Pessoa)entrada.readObject();
          if (p == null) {
            JOptionPane.showMessageDialog(null, "Seu nome já está na lista com um email gerado");
          } else {
            JOptionPane.showMessageDialog(null,"Pessoa criada e recebida: " + p);
          }
          entrada.close();
          System.out.println("Conexão encerrada");
        }
        catch(HeadlessException | IOException | ClassNotFoundException e) {
          System.out.println("Erro: " + e.getMessage());
        }
    }
}
