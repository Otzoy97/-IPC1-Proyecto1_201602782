import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
//import javax.swing.ImageIcon;

public class Clientes extends JFrame{
    void Retiros (JFrame frame){
        Container cp = frame.getContentPane();
        cp.setBackground(Color.yellow);
    }
    
    void Transferencias (JFrame frame){
        Container cp = frame.getContentPane();
        cp.setBackground(Color.orange);
    }
    
    void SaldoActual (JFrame frame){
        Container cp = frame.getContentPane();
        cp.setBackground(Color.gray);
    }
    
    void Reimpresion (JFrame frame){
        Container cp = frame.getContentPane();
        cp.setBackground(Color.green);
    }
    
    void GraficaPie (JFrame frame){
        Container cp = frame.getContentPane();
        cp.setBackground(Color.red);
    }
    
    void GraficaBarras (JFrame frame){
        Container cp = frame.getContentPane();
        cp.setBackground(Color.blue);
    }
}
