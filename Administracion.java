import javax.swing.*;
import javax.swing.border.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.ImageIcon;

public class Administracion{
    
    public void Nuevo(JFrame frame, Usuario[] usuarios){
        frame.setLayout(new GridBagLayout());
        Container cp = frame.getContentPane();
        GridBagConstraints bag = new GridBagConstraints();
        String [] empresa = {"Cash-Money","Pro-Pisto"};
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
        //
        JPanel pnl02 = new JPanel(new GridLayout(2,2));
        bag.gridy = 4;
        bag.gridheight = 2;
        cp.add(pnl02,bag);
        //
        JPanel pnl03 = new JPanel(new GridLayout(1,1));
        bag.gridy = 6;
        bag.gridheight = 1;
        cp.add(pnl03,bag);
        //
        JPanel pnl04 = new JPanel(new GridLayout(1,1));
        bag.gridy = 7;
        cp.add(pnl04,bag);
        //
        JLabel lbl01 = new JLabel("Nombre");
        JLabel lbl02 = new JLabel("Contraseña");
        JLabel lbl03 = new JLabel("Confirme Contraseña");
        JLabel lbl04 = new JLabel("Usuario");
        JLabel lbl05 = new JLabel("Saldo Inicial");
        JLabel lbl06 = new JLabel("Saldo Máximo");
        JLabel lbl07 = new JLabel("Empresa a Afiliar");
        JPasswordField pass01 = new JPasswordField();//Contraseña       
        JPasswordField pass02 = new JPasswordField();//Confirme Contraseña
        JTextField txt01 = new JTextField();//Nombre
        JTextField txt02 = new JTextField();//Usuario
        JTextField txt03 = new JTextField();//Saldo Inicial
        JTextField txt04 = new JTextField();//Saldo Máximo
        JComboBox cbx =new JComboBox(empresa);//Empresa
        JButton btn01 = new JButton();
        JButton btn02 = new JButton();
        //
        pnl01.add(lbl01);
        pnl01.add(txt01);
        pnl01.add(lbl02);
        pnl01.add(pass01);
        pnl01.add(lbl03);
        pnl01.add(pass02);
        pnl01.add(lbl04);
        pnl01.add(txt02);
        //
        pnl02.add(lbl05);
        pnl02.add(txt03);
        pnl02.add(lbl06);
        pnl02.add(txt04);
        //
        pnl03.add(lbl07);
        pnl03.add(cbx);
        bag.ipadx = 0;
        //
        pnl04.add(btn01);
        pnl04.add(btn02);
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
        btn01.addActionListener((ActionEvent a)->{
            char pass1[] = pass01.getPassword(); 
            char pass2[] = pass02.getPassword(); 
            String pass_1 = new String(pass1);
            String pass_2 = new String(pass2);
            if (txt01.getText().equals("")||txt02.getText().equals("")||
                    txt03.getText().equals("")||txt04.getText().equals("")
                    ||pass_1.equals("")||pass_2.equals("")){
                JOptionPane.showMessageDialog(null, "Debe llenar todos los campos","Administración - SIBE",JOptionPane.WARNING_MESSAGE);
            }else {
                if(pass_1.equals(pass_2)){
                    //Contraseñas iguales
                    if (txt02.getText().equals("ipc1Admin") || pass_1.equals("aux1")){
                        //Verifca si las credenciales son iguales a Admón
                        JOptionPane.showMessageDialog(null, "Usuario o contraseña inválidos","Administración - SIBE",JOptionPane.WARNING_MESSAGE);
                    } else if ( txt02.getText() == txt02.getText().replace(" ","") ){
                        //Verifica si el Usuario tiene espacios en blanco
                        JOptionPane.showMessageDialog(null, "Escriba el Usuario sin espacios","Administración - SIBE",JOptionPane.WARNING_MESSAGE);
                    } else if (pass_1.length() < 8 ){
                        JOptionPane.showMessageDialog(null, "La contraseña debe poseer al menos 8 caracteres","Administración - SIBE",JOptionPane.WARNING_MESSAGE);
                    } else {
                        boolean verificar = false;
                        for (int h = 0 ; h < usuarios.length; h++){
                            if (usuarios[h]!=null){
                                if (usuarios[h].getUsuario().equals(txt02.getText())){
                                    JOptionPane.showMessageDialog(null, "Usuario ya existe","Administración - SIBE",JOptionPane.WARNING_MESSAGE);
                                    verificar = true;
                                    break;
                                } else {
                                    verificar = false;
                                }
                            } else {
                                break;
                            }
                        }
                        if (verificar == false){
                            int c = 0;
                            String empresa1 = (String)cbx.getSelectedItem();
                            while (c < usuarios.length){
                                if (usuarios[c]==null){
                                    try {
                                        int min = Integer.parseInt(txt03.getText());
                                        int max = Integer.parseInt(txt04.getText());
                                        if (min < max){
                                            usuarios[c] = new Usuario(txt01.getText(),pass_1,
                                            txt02.getText(),min,max,empresa1);
                                            JOptionPane.showMessageDialog(null, "Registro completado exitosamente","Administración - SIBE",JOptionPane.INFORMATION_MESSAGE);    
                                            txt01.setText("");
                                            pass01.setText("");
                                            pass02.setText("");
                                            txt02.setText("");
                                            txt03.setText("");
                                            txt04.setText("");
                                            break;
                                        } else {
                                            JOptionPane.showMessageDialog(null, "El «Saldo incial» debe ser menor al «Saldo máximo»","Administración - SIBE",JOptionPane.WARNING_MESSAGE);    
                                            break;
                                        }
                                    } catch (Exception d){
                                        //Devuelve error si no son enteros
                                        JOptionPane.showMessageDialog(null, "El «Saldo inicial» y el «Saldo máximo» deben ser enteros","Administración - SIBE",JOptionPane.WARNING_MESSAGE);    
                                        break;
                                    }
                                    
                                } else {
                                    c++;//Sigue sumando hasta que encuentra un lugar en blanco
                                }
                            }
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Las contraseñas no coinciden","Administración - SIBE",JOptionPane.WARNING_MESSAGE);    
                }
            }
        });
        btn02.addActionListener((ActionEvent b)->{
            txt01.setText("");
            pass01.setText("");
            pass02.setText("");
            txt02.setText("");
            txt03.setText("");
            txt04.setText("");
        });
        //
        cp.validate();
    }
    public void Transferencia(JFrame frame, Usuario[] usuarios, Usuario[][] listado){
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
        //
        JPanel pnl02 = new JPanel(new GridLayout(1,2));
        bag.gridy = 2;
        cp.add(pnl02,bag);
        //
        JPanel pnl03 = new JPanel(new GridLayout(1,2));
        bag.gridy = 3;
        cp.add(pnl03,bag);
        //
        JLabel lbl01 = new JLabel("Usuario");
        JLabel lbl02 = new JLabel("Usuario");
        //
        JTextField txt01 = new JTextField();//Emisor
        JTextField txt02 = new JTextField();//Receptor
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
        btn01.addActionListener((ActionEvent a)->{
            String emisor = txt01.getText();
            String receptor = txt02.getText();
            boolean emisor_E = false;
            boolean receptor_E = false;
            int indice_e = 0;
            int indice_r = 0;
            if (emisor.length() > 0 && receptor.length() > 0){
                for (int i = 0 ; i < usuarios.length; i++ ) {
                    if (usuarios[i] != null) {
                        if (usuarios[i].getUsuario().equals(emisor)) {
                            emisor_E = true;
                            indice_e = i;
                            break;
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "«Usuario emisor» no existe","Administración - SIBE",JOptionPane.WARNING_MESSAGE);    
                        emisor_E = false;
                        break;
                    }
                }
                for (int i = 0 ; i < usuarios.length; i++) {
                    if (usuarios[i] != null) {
                        if (usuarios[i].getUsuario().equals(receptor)) {
                            receptor_E = true;
                            indice_r = i;
                            break;
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "«Usuario receptor» no existe","Administración - SIBE",JOptionPane.WARNING_MESSAGE);    
                        receptor_E = false;
                        break;
                    }
                }
                if (emisor_E == true && receptor_E == true){
                    if(emisor.equals(receptor)){
                        JOptionPane.showMessageDialog(null, "El «Usuario emisor» no puede ser el «Usuario receptor»","Administración - SIBE",JOptionPane.WARNING_MESSAGE);    
                    } else {
                        try {
                            listado[indice_e][indice_r].getActual();
                            JOptionPane.showMessageDialog(null, "La asignación ya existe","Administración - SIBE",JOptionPane.INFORMATION_MESSAGE);    
                        } catch (Exception e){
                            listado[indice_e][indice_r] = new Usuario(0);
                            JOptionPane.showMessageDialog(null, "Asignación completada exitosamente","Administración - SIBE",JOptionPane.INFORMATION_MESSAGE);    
                            txt01.setText("");
                            txt02.setText("");
                        }
                    }
                }
                    
            } else {
                JOptionPane.showMessageDialog(null, "Debe llenar todos los campos","Administración - SIBE",JOptionPane.INFORMATION_MESSAGE);    
            }
        });
        btn02.addActionListener((ActionEvent b)->{
            txt01.setText("");
            txt02.setText("");
        });
        //
        cp.validate();
    }
    public void Llenar(JFrame frame, Usuario[] billetes){
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
        btn01.addActionListener((ActionEvent e)->{
            String denominacion = txt01.getText();
            String cantidad = txt02.getText();
            boolean bool01 = false;
            boolean bool02 = false;
            int deno = 0;
            int mont = 0;
            
            try {
                
                deno = Integer.parseInt(txt01.getText());
                mont = Integer.parseInt(txt02.getText());
                System.out.println(deno);
                System.out.println(mont);
                
                bool01 = true;
            } catch (Exception ee){
                JOptionPane.showMessageDialog(null, "Denominación o Monto inválidos","Administración - SIBE",JOptionPane.WARNING_MESSAGE);    
                bool01 = false;            
            }
            if (bool01 == true){
                for (int i = 0 ; i < billetes.length; i++){
                    if (billetes[i] != null){
                        if (billetes[i].getDenominacion() == deno){
                            int option = JOptionPane.showConfirmDialog(null, "La denominación ya existe, ¿desea modificar el monto?","Administración - SIBE",JOptionPane.YES_NO_OPTION,JOptionPane.INFORMATION_MESSAGE);    
                            switch (option){
                                case 0:
                                    billetes[i].setMonto(billetes[i].getMonto()+mont);
                                    JOptionPane.showMessageDialog(null, "El cajero se ha llenado exitosamente","Administración - SIBE",JOptionPane.INFORMATION_MESSAGE);    
                                    break;
                                case -1:
                                case 2:
                                    JOptionPane.showMessageDialog(null, "Operación interrumpida","Administración - SIBRE",JOptionPane.INFORMATION_MESSAGE);
                                    break;  
                                default:
                                    JOptionPane.showMessageDialog(null, "Ocurrió un error. Operación interrumpida","Administración - SIBE",JOptionPane.WARNING_MESSAGE);
                                     break;
                            }
                            break;
                        } 
                    } else {
                        bool02 = true;
                    }
                }
            }
            if (bool02 == true){
                if (mont <= 0){
                    for (int i = 0 ; i < billetes.length ; i++){
                        if (billetes[i] == null){
                            billetes[i] = new Usuario(deno,mont);
                            JOptionPane.showMessageDialog(null, "El cajero se ha llenado exitosamente","Administración - SIBE",JOptionPane.INFORMATION_MESSAGE);    
                            txt01.setText("");
                            txt02.setText("");
                            break;
                        }
                    }     
                } else {
                    JOptionPane.showMessageDialog(null, "Monto inválido","Administración - SIBE",JOptionPane.WARNING_MESSAGE);    
                }
            }
            Ordenar(billetes);
        });
        //
        btn02.addActionListener((ActionEvent d)-> {
            txt01.setText("");
            txt02.setText("");
        });
        //
        cp.validate();
    }
    public void Verificar(JFrame frame, Usuario[] billetes){
        int cuenta = 0;
        boolean bool = false;
        //
        frame.setLayout(new GridBagLayout());
        Container cp = frame.getContentPane();
        GridBagConstraints bag = new GridBagConstraints();
        //
        JPanel pnl01 = new JPanel();
        //
        for (int i = 0 ; i < billetes.length ; i++){
            if (billetes[i] != null){
                JLabel j = new JLabel(String.valueOf(i+1)+".- "+"Q. "+billetes[i].getDenominacion()+".00 × "+ 
                billetes[i].getMonto(),JLabel.CENTER);
                j.setFont(new Font("Letter Gothic Std", Font.BOLD, 13));
                pnl01.add(j);
            } else {
                JLabel j = new JLabel("------Última Linea------", JLabel.CENTER);
                j.setFont(new Font("Letter Gothic Std", Font.BOLD, 13));
                pnl01.add(j);
                cuenta = i;
                break;
            }
        }
        //
        pnl01.setLayout(new GridLayout(cuenta+1,1));
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
    void Ordenar(Usuario billetes[]){
        for(int i = 0; i < billetes.length ; i++){
            if (billetes [i] != null){
                for (int j = 1; j < (billetes.length-i);j++){
                    if (billetes [j] !=null){
                        if (billetes[j-1].getDenominacion()>billetes[j].getDenominacion()){
                            int tempd = billetes[j].getDenominacion();
                            int tempc = billetes[j].getMonto();
                            billetes[j].setDenominacion(billetes[j-1].getDenominacion());// = array [j-1];
                            billetes[j].setMonto(billetes[j-1].getMonto());
                            billetes[j-1].setDenominacion(tempd);    
                            billetes[j-1].setMonto(tempc);    
                        }
                    } else {
                        break;
                    }
                }
            } else {
                break;
            }
        }
    }       
}
