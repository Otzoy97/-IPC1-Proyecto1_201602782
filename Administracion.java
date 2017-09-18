import javax.swing.*;
import javax.swing.border.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.ImageIcon;

public class Administracion{
    public void Nuevo(JFrame frame){
        frame.setLayout(new GridBagLayout());
        Container cp = frame.getContentPane();
        GridBagConstraints bag = new GridBagConstraints();
        String [] empresa = {"Pro-Pisto","Cash-Money"};
        //
        JPanel pnl01 = new JPanel(new GridLayout(4,2));
        bag.gridx = 0;
        bag.gridy = 0;
        bag.gridwidth = 1;
        bag.gridheight = 4;
        bag.weightx = 1;
        bag.fill = GridBagConstraints.BOTH;
        bag.anchor = GridBagConstraints.CENTER;
        cp.add(pnl01,bag);
        
        JPanel pnl02 = new JPanel(new GridLayout(2,2));
        bag.gridy = 4;
        bag.gridheight = 2;
        cp.add(pnl02,bag);
        
        JPanel pnl03 = new JPanel(new GridLayout(1,1));
        bag.gridy = 6;
        bag.gridheight = 1;
        cp.add(pnl03,bag);
        
        JPanel pnl04 = new JPanel(new GridLayout(1,1));
        bag.gridy = 7;
        cp.add(pnl04,bag);
        //
        //
        JLabel lbl01 = new JLabel("Nombre");
        pnl01.add(lbl01,bag);
        
        JTextField txt01 = new JTextField();//Nombre
        pnl01.add(txt01,bag);
        
        JLabel lbl02 = new JLabel("Contraseña");
        pnl01.add(lbl02,bag);
        
        JPasswordField pass01 = new JPasswordField();//Contraseña
        pnl01.add(pass01,bag);
        
        JLabel lbl03 = new JLabel("Confirme Contraseña");
        pnl01.add(lbl03,bag);
        
        JPasswordField pass02 = new JPasswordField();//Confirme Contraseña
        pnl01.add(pass02,bag);
        
        JLabel lbl04 = new JLabel("Usuario");
        pnl01.add(lbl04,bag);
        
        JTextField txt02 = new JTextField();//Usuario
        pnl01.add(txt02,bag);
        ////
        JLabel lbl05 = new JLabel("Saldo Inicial");
        pnl02.add(lbl05,bag);
        
        JTextField txt03 = new JTextField();//Saldo Inicial
        pnl02.add(txt03,bag);
        
        JLabel lbl06 = new JLabel("Saldo Máximo");
        pnl02.add(lbl06,bag);
        
        JTextField txt04 = new JTextField();
        pnl02.add(txt04,bag);
        ////
        JLabel lbl07 = new JLabel("Empresa a Afiliar");
        pnl03.add(lbl07,bag);
        
        JComboBox cbx =new JComboBox(empresa);//Empresa
        pnl03.add(cbx,bag);
        bag.ipadx = 0;
        //
        JButton btn01 = new JButton();
        pnl04.add(btn01,bag);
        
        JButton btn02 = new JButton();
        pnl04.add(btn02,bag);
        //
        lbl01.setHorizontalAlignment(JLabel.RIGHT);
        lbl02.setHorizontalAlignment(JLabel.RIGHT);
        lbl03.setHorizontalAlignment(JLabel.RIGHT);
        lbl04.setHorizontalAlignment(JLabel.RIGHT);
        lbl05.setHorizontalAlignment(JLabel.RIGHT);
        lbl06.setHorizontalAlignment(JLabel.RIGHT);
        lbl07.setHorizontalAlignment(JLabel.RIGHT);
        //
        lbl01.setFont(new Font("Letter Gothic Std", Font.BOLD, 13));
        lbl02.setFont(new Font("Letter Gothic Std", Font.BOLD, 13));
        lbl03.setFont(new Font("Letter Gothic Std", Font.BOLD, 13));
        lbl04.setFont(new Font("Letter Gothic Std", Font.BOLD, 13));
        lbl05.setFont(new Font("Letter Gothic Std", Font.BOLD, 13));
        lbl06.setFont(new Font("Letter Gothic Std", Font.BOLD, 13));
        lbl07.setFont(new Font("Letter Gothic Std", Font.BOLD, 13));
        //
        txt01.setFont(new Font("Letter Gothic Std", Font.PLAIN, 13));
        txt02.setFont(new Font("Letter Gothic Std", Font.PLAIN, 13));
        txt03.setFont(new Font("Letter Gothic Std", Font.PLAIN, 13));
        txt04.setFont(new Font("Letter Gothic Std", Font.PLAIN, 13));
        //
        cbx.setFont(new Font("Letter Gothic Std", Font.PLAIN, 13));
        //
        btn01.setIcon(new ImageIcon(getClass().getResource("Imagenes/comprobar.png")));
        btn02.setIcon(new ImageIcon(getClass().getResource("Imagenes/cancelar.png")));
        //
        pnl01.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(),"Estudiante",TitledBorder.LEFT, 
                TitledBorder.TOP,new Font("Letter Gothic Std", Font.PLAIN, 12), Color.gray));   
        pnl02.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(),"Cuenta",TitledBorder.LEFT, 
                TitledBorder.TOP,new Font("Letter Gothic Std", Font.PLAIN, 12), Color.gray));
        pnl03.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(),"Proveedor",TitledBorder.LEFT, 
                TitledBorder.TOP,new Font("Letter Gothic Std", Font.PLAIN, 12), Color.gray));
        //
        cp.validate();
    }
    public void Transferencia(JFrame frame){
        frame.setLayout(new GridBagLayout());
        Container cp = frame.getContentPane();
        GridBagConstraints bag = new GridBagConstraints();
        //
        JPanel pnl01 = new JPanel(new GridLayout(1,2));
        bag.gridx = 0;
        bag.gridy = 0;
        bag.gridheight = 1;
        bag.gridwidth = 1; 
        bag.weightx = 1;
        bag.fill = GridBagConstraints.BOTH;
        bag.anchor = GridBagConstraints.CENTER;
        cp.add(pnl01,bag);
        
        JPanel pnl02 = new JPanel(new GridLayout(1,2));
        bag.gridy = 2;
        cp.add(pnl02,bag);
        
        JPanel pnl03 = new JPanel(new GridLayout(1,2));
        bag.gridy = 3;
        cp.add(pnl03,bag);
        //
        JLabel lbl01 = new JLabel("Usuario");
        JLabel lbl02 = new JLabel("Usuario");
        //
        JTextField txt01 = new JTextField();
        JTextField txt02 = new JTextField();
        //
        JButton btn01 = new JButton();
        JButton btn02 = new JButton();
        //
        lbl01.setHorizontalAlignment(JLabel.RIGHT);
        lbl02.setHorizontalAlignment(JLabel.RIGHT);
        lbl01.setFont(new Font("Letter Gothic Std", Font.BOLD, 13));
        lbl02.setFont(new Font("Letter Gothic Std", Font.BOLD, 13));
        //
        txt01.setFont(new Font("Letter Gothic Std", Font.PLAIN, 13));
        txt02.setFont(new Font("Letter Gothic Std", Font.PLAIN, 13));
        //
        btn01.setIcon(new ImageIcon(getClass().getResource("Imagenes/comprobar.png")));
        btn02.setIcon(new ImageIcon(getClass().getResource("Imagenes/cancelar.png")));
        //
        pnl01.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(),"Emisor",TitledBorder.LEFT, 
                TitledBorder.TOP,new Font("Letter Gothic Std", Font.PLAIN, 12), Color.gray));   
        pnl02.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(),"Receptor",TitledBorder.LEFT, 
                TitledBorder.TOP,new Font("Letter Gothic Std", Font.PLAIN, 12), Color.gray));
        //
        pnl01.add(lbl01);
        pnl01.add(txt01);
        //
        pnl02.add(lbl02);
        pnl02.add(txt02);
        //
        pnl03.add(btn01);
        pnl03.add(btn02);
        //
        cp.validate();
    }
    public void Llenar(JFrame frame){
        frame.setLayout(new GridBagLayout());
        Container cp = frame.getContentPane();
        GridBagConstraints bag = new GridBagConstraints();
        //
        JPanel pnl01 = new JPanel(new GridLayout(2,2));
        bag.gridx = 0;
        bag.gridy = 0;
        bag.gridheight = 2;
        bag.gridwidth = 1; 
        bag.weightx = 1;
        bag.fill = GridBagConstraints.BOTH;
        bag.anchor = GridBagConstraints.CENTER;
        cp.add(pnl01,bag);
        
        JPanel pnl02 = new JPanel(new GridLayout(1,2));
        bag.gridy = 2;
        bag.gridheight = 1;
        cp.add(pnl02,bag);
        //
        JLabel lbl01 = new JLabel("Denominación");
        JLabel lbl02 = new JLabel("Cantidad");
        //
        JTextField txt01 = new JTextField();
        JTextField txt02 = new JTextField();
        //
        JButton btn01 = new JButton();
        JButton btn02 = new JButton();
        //
        lbl01.setHorizontalAlignment(JLabel.RIGHT);
        lbl02.setHorizontalAlignment(JLabel.RIGHT);
        lbl01.setFont(new Font("Letter Gothic Std", Font.BOLD, 13));
        lbl02.setFont(new Font("Letter Gothic Std", Font.BOLD, 13));
        //
        txt01.setFont(new Font("Letter Gothic Std", Font.PLAIN, 13));
        txt02.setFont(new Font("Letter Gothic Std", Font.PLAIN, 13));
        //
        btn01.setIcon(new ImageIcon(getClass().getResource("Imagenes/comprobar.png")));
        btn02.setIcon(new ImageIcon(getClass().getResource("Imagenes/cancelar.png")));
        //
        pnl01.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(),"Billetes",TitledBorder.LEFT, 
                TitledBorder.TOP,new Font("Letter Gothic Std", Font.PLAIN, 12), Color.gray));
        //
        pnl01.add(lbl01);
        pnl01.add(txt01);
        pnl01.add(lbl02);
        pnl01.add(txt02);
        //
        pnl02.add(btn01);
        pnl02.add(btn02);
        //
        cp.validate();
    }
    public void Verificar(JFrame frame){
        int cuenta = 0;
        frame.setLayout(new GridBagLayout());
        Container cp = frame.getContentPane();
        GridBagConstraints bag = new GridBagConstraints();
        //
        JPanel pnl01 = new JPanel();
        //
        for (int i = 1; i <= 10 ; i ++ ){
            JLabel j = new JLabel(String.valueOf(i)+"jajaajjajaajajj",JLabel.CENTER);
            j.setFont(new Font("Letter Gothic Std", Font.BOLD, 13));
            pnl01.add(j);
            cuenta = i;
        }
        //
        pnl01.setLayout(new GridLayout(cuenta,1));
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
        pnl01.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(),"Existencias en Cajero",TitledBorder.LEFT, 
                TitledBorder.TOP,new Font("Letter Gothic Std", Font.PLAIN, 12), Color.gray));
        
        cp.validate();
    }
    
}
