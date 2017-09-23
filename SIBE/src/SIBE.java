import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.Scanner;

public class SIBE extends JFrame{
    private int indice;
    Modulo login = new Modulo();
    Administracion admon = new Administracion();
    Clientes clts = new Clientes();
    private static Usuario[] usuarios = new Usuario[30]; //
    private static Usuario[] billetes = new Usuario[15];//
    private static Usuario[][] listado = new Usuario[30][30];//
    private static Usuario[][] transacciones = new Usuario[30][30];//
    
    public static void main(String[] args) {
        SIBE inicio = new SIBE();
        inicio.show();
    }
    
    private SIBE(){
        setSize(300, 400);
        setTitle("SIBE - Sistema Integrado Bancario Estudiantil");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE/*DO_NOTHING_ON_CLOSE*/);
        setResizable(false);
        setLayout(null);
        setLocationRelativeTo(null);
        this.getContentPane().setBackground(new Color(157,195,230));
        //     
        setIconImage(new ImageIcon(getClass().getResource("Imagenes/favicon.png")).getImage());
        //
        JPanel pnl02 = new JPanel();    
        JLabel lbl01 = new JLabel("Usuario", JLabel.CENTER);
        JLabel lbl02 = new JLabel("Contraseña", JLabel.CENTER);
        JTextField txt01 = new JTextField();
        JPasswordField txt02 = new JPasswordField();
        JButton btn01 = new JButton("Entrar");
        //
        pnl02.setBackground(new Color(189,215,238));
        pnl02.setSize(220,160);
        pnl02.setBorder(null);
        pnl02.setLayout(null);
        pnl02.setLocation(40,120);
        //       
        lbl01.setFont(new Font("Letter Gothic Std", Font.BOLD, 16));
        lbl02.setFont(new Font("Letter Gothic Std", Font.BOLD, 16));
        lbl01.setBounds(60,0,100,30);
        lbl02.setBounds(60,90,100,30);
        //
        txt01.setBounds(10,30,200,30);
        txt01.setFont(new Font("Century Gothic", Font.PLAIN, 14));
        txt01.setBorder(null);
        txt02.setBounds(10,120,200,30);        
        txt02.setFont(new Font("Batang", Font.PLAIN, 14));
        txt02.setBorder(null);
        //
        btn01.setBounds(100,320,100,35);
        btn01.setVisible(true);
        btn01.setBackground(new Color(222,235,247));
        btn01.setBorder(null);
        btn01.addActionListener((ActionEvent e) -> {
            String usuario = txt01.getText();
            char passArray[] = txt02.getPassword(); 
            String pass = new String(passArray);
            
            if (usuario.equals("ipc1Admin") && pass.equals("aux1")){
                JOptionPane.showMessageDialog(null, "Bienvenido - Administrador");
                setVisible(false);
                login.Administracion();
            } else {
                int c = 0;
                while (c < 25){               
                    if (usuarios[c]!=null){
                        if(usuarios[c].getUsuario().equals(usuario) && usuarios[c].getContrasena().equals(pass)){
                            JOptionPane.showMessageDialog(null, "Bienvenido - " + usuarios[c].getNombre());
                            setVisible(false);
                            if (usuarios[c].getEmpresa() == "Pro-Pisto"){
                                login.Clientes(new Color(139,140,143));
                            } else {
                                login.Clientes(new Color(176,213,116));
                            }
                            indice = c;
                            break;
                        } 
                        c++;
                    } else {
                        JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrectos","SIBE",JOptionPane.WARNING_MESSAGE);
                        break;
                    }
                }
            }
        });
        //
        pnl02.add(lbl01);
        pnl02.add(lbl02);
        pnl02.add(txt01);
        pnl02.add(txt02);
        getContentPane().add(btn01);
        getContentPane().add(pnl02);
    }
    
    public class Modulo extends JFrame{
    private JMenuBar menubar;
    private JMenu menu1, menu2, menu5;
    private JMenuItem menuitem1, menuitem2, menuitem3, menuitem4, menuitem5, menuitem6;
    
    public void Clientes(Color color){
        setIconImage(new ImageIcon(getClass().getResource("Imagenes/favicon.png")).getImage());
        menubar = new JMenuBar();
        //
        menu1 = new JMenu("Transacciones");
        menu2 = new JMenu("Consultas");
        //
        menuitem1 = new JMenuItem("Retiros");
        menuitem2 = new JMenuItem("Transferencias");
        //
        menuitem3 = new JMenuItem("Saldo Actual");
        menuitem4 = new JMenuItem("Reimpresión");
        menu5 = new JMenu("Gráficas");
        //
        menuitem5 = new JMenuItem("Transferencias por Estudiantes");
        menuitem6 = new JMenuItem("Transacciones por Mes");
        //
        menubar.add(menu1);
        menubar.add(menu2);
        //
        menu1.add(menuitem1);
        menu1.add(menuitem2);
        //
        menu2.add(menuitem3);
        menu2.add(menuitem4);
        menu2.add(menu5);
        //
        menu5.add(menuitem5);
        menu5.add(menuitem6);
        //
        
        //
        setJMenuBar(menubar);
        setSize(400, 400);
        setTitle("Clientes - Sistema Integrado Bancario Estudiantil");
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        setLayout(null);
        setLocationRelativeTo(null);
        addWindowListener( new WindowAdapter(){
            @Override
            public void windowClosing(WindowEvent e){
                SIBE inicio = new SIBE();
                inicio.setVisible(true);
            }
        });
        show();
        //
        menuitem1.addActionListener((ActionEvent e) ->{
            getContentPane().removeAll();
            getContentPane().repaint();
            getContentPane().setBackground(color);
            clts.Retiros(this,usuarios,transacciones, indice, billetes);
        });
        menuitem2.addActionListener((ActionEvent e) ->{
            getContentPane().removeAll();
            getContentPane().repaint();
            getContentPane().setBackground(color);
            clts.Transferencias(this,usuarios,transacciones, listado,billetes, indice);
        });
        menuitem3.addActionListener((ActionEvent e) ->{
            getContentPane().removeAll();
            getContentPane().repaint();
            getContentPane().setBackground(color);
            clts.SaldoActual(this, usuarios, transacciones, indice);
        });
        menuitem4.addActionListener((ActionEvent e) ->{
            getContentPane().removeAll();
            getContentPane().repaint();
            getContentPane().setBackground(color);
            clts.Reimpresion(this, usuarios, transacciones,indice);
        });
        menuitem5.addActionListener((ActionEvent e) ->{
            getContentPane().removeAll();
            getContentPane().repaint();
            getContentPane().setBackground(color);
            clts.GraficaPie(this,usuarios ,transacciones,indice);
        });
        menuitem6.addActionListener((ActionEvent e) ->{
            getContentPane().removeAll();
            getContentPane().repaint();
            getContentPane().setBackground(color);
            clts.GraficaBarras(this,usuarios ,transacciones,indice);
        });
        menuitem3.doClick();
    }
  
    public void  Administracion(){
        setIconImage(new ImageIcon(getClass().getResource("Imagenes/favicon.png")).getImage());
        menubar = new JMenuBar();
        //
        menu1 = new JMenu("Estudiantes");
        menu2 = new JMenu("Cajero");
        //
        menuitem1 = new JMenuItem("Nuevo Estudiante");
        menuitem2 = new JMenuItem("Transferencias...");
        menuitem3 = new JMenuItem("Llenar Cajero");
        menuitem4 = new JMenuItem("Verificar Cajero");
        //       
        menubar.add(menu1);
        menubar.add(menu2);
        //
        menu1.add(menuitem1);
        menu1.add(menuitem2);
        menu2.add(menuitem3);
        menu2.add(menuitem4);
        //
        setJMenuBar(menubar);
        setSize(400, 350);
        setTitle("Administración - Sistema Integrado Bancario Estudiantil");
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        addWindowListener( new WindowAdapter(){
            @Override
            public void windowClosing(WindowEvent e){
                SIBE inicio = new SIBE();
                inicio.setVisible(true);
            }
        });
        show();
        //
        menuitem1.addActionListener((ActionEvent e)->{
            getContentPane().removeAll();
            getContentPane().repaint();
            admon.Nuevo(this, usuarios);
        });
        menuitem2.addActionListener((ActionEvent e)->{
            getContentPane().removeAll();
            getContentPane().repaint();
            admon.Transferencia(this, usuarios, listado);
        });
        menuitem3.addActionListener((ActionEvent e)->{
            getContentPane().removeAll();
            getContentPane().repaint();
            admon.Llenar(this, billetes);
        });
        menuitem4.addActionListener((ActionEvent e)->{
            getContentPane().removeAll();
            getContentPane().repaint();
            admon.Verificar(this, billetes);
        });
        menuitem1.doClick();
    } 
}
}