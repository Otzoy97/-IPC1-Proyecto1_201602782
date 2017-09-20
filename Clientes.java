import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.ImageIcon;
import javax.swing.border.*;
import java.util.Date;
import java.text.*;

public class Clientes extends JFrame{
    private int indice;

    void Retiros (JFrame frame, Usuario[][] transacciones,int indice, Usuario[] billetes){
        this.indice = indice;
        int cuenta = 0;
        frame.setLayout(new GridBagLayout());
        Container cp = frame.getContentPane();
        GridBagConstraints bag = new GridBagConstraints();
        //
        JPanel pnl01 = new JPanel();
        //
        for (int i = 1; i <= 10 ; i ++ ){
            JButton j = new JButton("Q. "+String.valueOf(i)+"");
            j.setFont(new Font("Letter Gothic Std", Font.BOLD, 16));
            j.addActionListener((ActionEvent e)->{
                JButton obj = (JButton)e.getSource();
                String monto = obj.getText();
                int opcion = JOptionPane.showConfirmDialog(null, "Confirme Transacción","Retiros", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);
                switch (opcion){
                    case 0:
                        System.out.println(monto.substring(3, monto.length()));
                        JOptionPane.showMessageDialog(null, "Transacción exitosa","Retiros",JOptionPane.INFORMATION_MESSAGE);
                        break;
                    case -1:
                    case 2:
                        JOptionPane.showMessageDialog(null, "Transacción interrumpida","Retiros",JOptionPane.INFORMATION_MESSAGE);
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Ocurrió un error. Transacción interrumpida","Retiros",JOptionPane.WARNING_MESSAGE);
                        break;
                }
            });
            pnl01.add(j);
            cuenta = i;
        }
        //
        pnl01.setLayout(new GridLayout(cuenta/2,2));
        //
        bag.gridx = 0;
        bag.gridy = 0;
        bag.gridheight = cuenta;
        bag.gridwidth = 1;
        bag.weightx = 1;
        bag.fill = GridBagConstraints.BOTH;
        bag.anchor = GridBagConstraints.CENTER;
        cp.add(pnl01,bag);
        //
        pnl01.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(),"Selecciona el Monto a Retirar",TitledBorder.LEFT, 
                TitledBorder.TOP,new Font("Letter Gothic Std", Font.PLAIN, 14), Color.gray));
        //
        cp.validate();
    }
    
    void Transferencias (JFrame frame, Usuario[][] transacciones, Usuario[][] listados){
        String[] usuarios = new String[5];
        //
        frame.setLayout(new GridBagLayout());
        Container cp = frame.getContentPane();
        GridBagConstraints bag = new GridBagConstraints();
        //
        JPanel pnl01 = new JPanel(new GridLayout(1,1));
        JPanel pnl02 = new JPanel(new GridLayout(1,2));
        //
        JButton btn01 = new JButton("Monto Fijo");
        JButton btn02 = new JButton("Monto Libre");
        JComboBox cbx = new JComboBox(usuarios);
        //
        cbx.setFont(new Font("Letter Gothic Std", Font.PLAIN, 13));
        btn01.setFont(new Font("Letter Gothic Std", Font.BOLD, 14));
        btn02.setFont(new Font("Letter Gothic Std", Font.BOLD, 14));
        //
        pnl01.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(),"Usuario a Acreeditar",TitledBorder.LEFT, 
                TitledBorder.TOP,new Font("Letter Gothic Std", Font.PLAIN, 16), Color.gray));
        //
        pnl01.add(cbx);
        pnl02.add(btn01);
        pnl02.add(btn02);
        //
        btn01.addActionListener((ActionEvent e) -> {
            int cuenta = 0;
            frame.setVisible(false);
            //
            //
            JFrame fijo = new JFrame();
            //
            fijo.setResizable(false);
            //
            fijo.setTitle("Transferencia Fija");
            Container cp01 =fijo.getContentPane();
            fijo.setLayout(new GridBagLayout());
            GridBagConstraints bag01 = new GridBagConstraints();
            //
            JPanel pnl03 = new JPanel();
            for (int i = 1; i <= 10 ; i ++ ){
                JButton j = new JButton("Q. "+String.valueOf(i));
                j.setFont(new Font("Letter Gothic Std", Font.BOLD, 16));
                j.addActionListener((ActionEvent ee)->{
                        JButton obj = (JButton)ee.getSource();
                        String monto = obj.getText();
                        System.out.println(monto.substring(3, monto.length()));   
                        JOptionPane.showMessageDialog(null, ("Transferencia Exitosa"),"Transferencia Fija",JOptionPane.INFORMATION_MESSAGE);
                        fijo.dispose();
                        cp.validate();
                        frame.setVisible(true);
                });
                pnl03.add(j);
                cuenta = i;
            }
            pnl03.setLayout(new GridLayout(cuenta/2,2));
            pnl03.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(),"Selecciona el Monto a Transferir",TitledBorder.LEFT, 
                TitledBorder.TOP,new Font("Letter Gothic Std", Font.PLAIN, 12), Color.gray));
            //
            bag01.gridx = 0;
            bag01.gridy = 0;
            bag01.gridheight = 1;
            bag01.gridwidth = 1;
            bag01.weightx = 1;
            bag01.fill = GridBagConstraints.BOTH;
            bag01.anchor = GridBagConstraints.CENTER;
            //
            cp01.add(pnl03,bag01);
            //
            fijo.setSize(300,300);
            fijo.setLocationRelativeTo(null);
            //
            fijo.show();
            fijo.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
            fijo.addWindowListener( new WindowAdapter(){  
                @Override
                public void windowClosing(WindowEvent e){
                    JOptionPane.showMessageDialog(null, ("Transferencia Interrumpida"),"Transferencia Fija",JOptionPane.INFORMATION_MESSAGE);
                    frame.setVisible(true);
                }
            });
            cp01.validate();
        });
        //
        //
        btn02.addActionListener((ActionEvent e) -> {
            frame.setVisible(false);
            //
            JFrame fijo = new JFrame();
            fijo.setResizable(false);
            fijo.setTitle("Transferencia Libre");
            Container cp01 = fijo.getContentPane();
            fijo.setLayout(new GridBagLayout());
            GridBagConstraints bag01 = new GridBagConstraints();
            //
            JPanel pnl03 = new JPanel();
            //
            JButton btn_01 = new JButton();
            JButton btn_02 = new JButton();
            //
            //
            JTextField txt01 = new JTextField();
            txt01.setFont(new Font("Letter Gothic Std", Font.BOLD, 16));
            txt01.setBorder(null);
            pnl03.add(txt01);
            //
            btn_01.setIcon(new ImageIcon(getClass().getResource("Imagenes/comprobar.png")));
            btn_02.setIcon(new ImageIcon(getClass().getResource("Imagenes/cancelar.png")));
            //
            pnl03.setLayout(new GridLayout(1,1));
            //
            pnl03.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(),"Ingresa el Monto a Transferir",TitledBorder.LEFT, 
                TitledBorder.TOP,new Font("Letter Gothic Std", Font.PLAIN, 12), Color.gray));
            //
            bag01.gridx = 0;
            bag01.gridy = 0;
            bag01.gridheight = 1;
            bag01.gridwidth = 2;
            bag01.weightx = 1;
            bag01.fill = GridBagConstraints.BOTH;
            bag01.anchor = GridBagConstraints.CENTER;
            //
            cp01.add(pnl03,bag01);
            //
            bag01.gridy = 1;
            bag01.gridwidth = 1;
            cp01.add(btn_01,bag01);
            //
            bag01.gridx = 1;
            bag01.gridwidth = 1;
            cp01.add(btn_02,bag01);
            //
            btn_01.addActionListener((ActionEvent a) -> {
                try{
                    int monto = Integer.parseInt(txt01.getText());
                    System.out.println(monto);
                    JOptionPane.showMessageDialog(null, ("Transferencia Exitosa"),"Transferencia Libre",JOptionPane.INFORMATION_MESSAGE);
                    fijo.dispose();
                    cp.validate();
                    frame.setVisible(true);
                }catch (Exception b){
                    JOptionPane.showMessageDialog(null, ("Monto inválido"),"Transferencia Libre",JOptionPane.WARNING_MESSAGE);
                }
            });
            //
            btn_02.addActionListener((ActionEvent d) -> {
                txt01.setText("");
            });
            //
            fijo.setSize(300,150);
            fijo.setLocationRelativeTo(null);
            //
            fijo.show();
            fijo.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
            fijo.addWindowListener( new WindowAdapter(){  
                @Override
                public void windowClosing(WindowEvent e){
                    JOptionPane.showMessageDialog(null, ("Transferencia Interrumpida"),"Transferencia Libre",JOptionPane.INFORMATION_MESSAGE);
                    cp.validate();
                    frame.setVisible(true);
                }
            });
            cp01.validate();
        });
        //
        //
        bag.gridx = 0;
        bag.gridy = 0;
        bag.gridheight = 1;
        bag.gridwidth = 1;
        bag.weightx = 1;
        bag.fill = GridBagConstraints.BOTH;
        bag.anchor = GridBagConstraints.CENTER;
        cp.add(pnl01,bag);
        bag.gridy = 1;
        cp.add(pnl02,bag);
        cp.validate();
    }
    
    void SaldoActual (JFrame frame, Usuario[] usuarios, Usuario[][] transacciones){
        frame.setLayout(new GridBagLayout());
        Container cp = frame.getContentPane();
        GridBagConstraints bag = new GridBagConstraints();
        //
        DateFormat hourdate = new SimpleDateFormat("HH:mm:ss dd/MM/yyyy");
        //
        JPanel pnl01 = new JPanel();
        JLabel lbl01 = new JLabel("Usuario:");
        JLabel lbl02 = new JLabel("-----");
        JLabel lbl03 = new JLabel("Nombre:");
        JLabel lbl04 = new JLabel("-----");
        JLabel lbl05 = new JLabel("Saldo Actual:");
        JLabel lbl06 = new JLabel("-----");
        JLabel lbl07 = new JLabel("Afiliado a:");
        JLabel lbl08 = new JLabel("-----");
        JLabel lbl09 = new JLabel(hourdate.format(new Date()));
        //
        lbl01.setFont(new Font("Letter Gothic Std", Font.BOLD, 14));
        lbl02.setFont(new Font("Letter Gothic Std", Font.BOLD, 14));
        lbl03.setFont(new Font("Letter Gothic Std", Font.BOLD, 14));
        lbl04.setFont(new Font("Letter Gothic Std", Font.BOLD, 14));
        lbl05.setFont(new Font("Letter Gothic Std", Font.BOLD, 14));
        lbl06.setFont(new Font("Letter Gothic Std", Font.BOLD, 14));
        lbl07.setFont(new Font("Letter Gothic Std", Font.BOLD, 14));
        lbl08.setFont(new Font("Letter Gothic Std", Font.BOLD, 14));
        lbl09.setFont(new Font("Letter Gothic Std", Font.BOLD, 14));
        lbl09.setForeground(Color.gray);
        //
        lbl01.setHorizontalAlignment(SwingConstants.LEFT);
        lbl03.setHorizontalAlignment(SwingConstants.LEFT);
        lbl05.setHorizontalAlignment(SwingConstants.LEFT);
        lbl07.setHorizontalAlignment(SwingConstants.LEFT);
        //------///
        lbl02.setHorizontalAlignment(SwingConstants.RIGHT);
        lbl04.setHorizontalAlignment(SwingConstants.RIGHT);
        lbl06.setHorizontalAlignment(SwingConstants.RIGHT);
        lbl08.setHorizontalAlignment(SwingConstants.RIGHT);
        lbl09.setHorizontalAlignment(SwingConstants.RIGHT);
        //
        pnl01.add(lbl01);
        pnl01.add(lbl02);
        pnl01.add(lbl03);
        pnl01.add(lbl04);
        pnl01.add(lbl05);
        pnl01.add(lbl06);
        pnl01.add(lbl07);
        pnl01.add(lbl08);
        //
        pnl01.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(),"Estado de Cuenta",TitledBorder.LEFT, 
                TitledBorder.TOP,new Font("Letter Gothic Std", Font.PLAIN, 14), Color.gray));
        pnl01.setLayout(new GridLayout(4,2));
        //
        bag.gridx = 0;
        bag.gridy = 0;
        bag.gridheight = 4;
        bag.gridwidth = 1; 
        bag.weightx = 1;
        bag.fill = GridBagConstraints.BOTH;
        bag.anchor = GridBagConstraints.CENTER;
        cp.add(pnl01,bag);
        bag.gridy = 4;
        cp.add(lbl09,bag);
        
        
        cp.validate();
    }
    
    void Reimpresion (JFrame frame, Usuario[][] transacciones){
        Container cp = frame.getContentPane();
        cp.validate();
    }
    
    void GraficaPie (JFrame frame, Usuario[][] transacciones){
        Container cp = frame.getContentPane();
        cp.validate();
    }
    
    void GraficaBarras (JFrame frame, Usuario[][] transacciones){
        Container cp = frame.getContentPane();
        cp.validate();
    }
}
