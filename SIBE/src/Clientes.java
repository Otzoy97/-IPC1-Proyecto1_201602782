import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.ImageIcon;
import javax.swing.border.*;
import java.util.Date;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.text.*;
import org.jfree.chart.*;
import org.jfree.chart.plot.*;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

public class Clientes extends JFrame{

    void Retiros (JFrame frame, Usuario[] usuarios ,Usuario[][] transacciones,int indice, Usuario[] billetes){
        int cuenta = 0;        
        //
        frame.setLayout(new GridBagLayout());
        Container cp = frame.getContentPane();
        GridBagConstraints bag = new GridBagConstraints();
        //
        JPanel pnl01 = new JPanel();
        if (usuarios[indice].getEmpresa() == "Pro-Pisto"){
            Color color = new Color(167,168,169);
            pnl01.setBackground(color);
        } else {
            Color color = new Color(143,194,58);
            pnl01.setBackground(color);
        }
        //
        for (int i = 0; i < billetes.length ; i ++ ){
            if (billetes[i] != null) {
                JButton j = new JButton("Q. "+billetes[i].getDenominacion()+".00");
                j.setFont(new Font("Letter Gothic Std", Font.BOLD, 16));
                j.addActionListener((ActionEvent e)->{
                    JButton obj = (JButton)e.getSource();
                    String monto = obj.getText();
                    System.out.println(monto);
                    int opcion = JOptionPane.showConfirmDialog(null, "Confirme Transacción","Retiros", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);
                    switch (opcion){
                        case 0:
                            int total = Integer.parseInt(monto.substring(3, monto.length() - 3));
                            for (int k = 0 ; k < billetes.length ; k++){;
                                if (billetes[k].getDenominacion() == total){ 
                                    if (billetes[k].getMonto()>= 1){
                                    //Billetes suficientes dentro del cajero
                                        if (usuarios[indice].getActual() >= total) {
                                        //Saldo actual suficiente para completar operación
                                            billetes[k].setMonto(billetes[k].getMonto()-1);//Se modifca la cantidad de billetes del cajero
                                            usuarios[indice].setActual(usuarios[indice].getActual() - total);//Se modifica el saldo actual del clientes
                                            for (int l = 0 ; l < transacciones[l].length; l++){
                                                if (transacciones[indice][l]==null){
                                                    transacciones[indice][l] = new Usuario(usuarios[indice].getUsuario(),usuarios[indice].getUsuario(),total,new Date(),"RTR");    
                                                    JOptionPane.showMessageDialog(null, "Transacción exitosa","Retiros",JOptionPane.INFORMATION_MESSAGE);
                                                    //Imprimir(nombre,emisor,receptor,monto,fecha,transaccion,index,j);
                                                    Imprimir(usuarios[indice].getNombre(),
                                                            usuarios[indice].getUsuario(),
                                                            usuarios[indice].getUsuario(),
                                                            total,transacciones[indice][l].getFecha(),"RTR",indice,l);
                                                    k = 0;
                                                    l = 0;
                                                    break;
                                                }
                                            }
                                            k = 0;
                                            break;
                                        } else {
                                        //Saldo actual insuficiente para completar operación
                                            JOptionPane.showMessageDialog(null, "<html><body>Tu saldo es insuficiente para completar la transacción</html></body>","Retiros",JOptionPane.INFORMATION_MESSAGE);
                                            k = 0;
                                            break;
                                        }
                                    } else {
                                        //Billetes insuficientes dentro del cajero
                                        JOptionPane.showMessageDialog(null, "<html><body>El saldo del cajero en Q. " + billetes[k].getDenominacion()+ ".00 es insuficiente para completar la transacción</html></body>","Retiros",JOptionPane.WARNING_MESSAGE);
                                        k = 0;
                                        break;
                                    }
                                }
                            }
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
            } else {
                cuenta = i;
                break;
            }
        }
        //
        pnl01.setLayout(new GridLayout((cuenta+1)/2,2));
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
                TitledBorder.TOP,new Font("Letter Gothic Std", Font.PLAIN, 14), Color.black));
        //
        frame.setSize(400, 400);
        frame.setLocationRelativeTo(null);
        cp.validate();
    }
    
    void Transferencias (JFrame frame, Usuario[] usuarios ,Usuario[][] transacciones, Usuario[][] listados, Usuario[] billetes, int indice){
        //
        int enabled = 1;
        DefaultComboBoxModel modelo = new DefaultComboBoxModel();
        JComboBox cbx = new JComboBox(modelo);
        //
        for (int l = 0 ; l < listados[indice].length; l++){
            if (listados[indice][l]!=null){
                modelo.addElement(listados[indice][l].getUsuario());
            } else {
                enabled = l;
                break;
            }
        }
        //
        frame.setLayout(new GridBagLayout());
        Container cp = frame.getContentPane();
        GridBagConstraints bag = new GridBagConstraints();
        //
        JPanel pnl01 = new JPanel(new GridLayout(1,1));
        JPanel pnl02 = new JPanel(new GridLayout(1,2));
        //
        Color color;
        Color color0;
        
        
        
        if (usuarios[indice].getEmpresa() == "Pro-Pisto"){
            color = new Color(167,168,169);
            color0 = new Color(156,157,160);
            pnl02.setBackground(color0);
            cbx.setBackground(Color.white);
        } else {
            color = new Color(87,203,58);
            color0 = new Color(143,194,58);
            cbx.setBackground(new Color(197,223,151));
        }
        pnl01.setBackground(color);
        pnl02.setBackground(color0);
        //
        JButton btn01 = new JButton("Monto Fijo");
        JButton btn02 = new JButton("Monto Libre");
        //
        cbx.setFont(new Font("Letter Gothic Std", Font.PLAIN, 13));
        btn01.setFont(new Font("Letter Gothic Std", Font.BOLD, 14));
        btn02.setFont(new Font("Letter Gothic Std", Font.BOLD, 14));
        //
        pnl01.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(),"Usuario a Acreeditar",TitledBorder.LEFT, 
                TitledBorder.TOP,new Font("Letter Gothic Std", Font.BOLD, 16), Color.black));
        //
        
        //
        pnl01.add(cbx);
        pnl02.add(btn01);
        pnl02.add(btn02);
        btn01.setEnabled(false);
        btn02.setEnabled(false);
        if (enabled != 0){
            btn01.setEnabled(true);
            btn02.setEnabled(true);
        }
        //
        btn01.addActionListener((ActionEvent e) -> {
            String receptor = (String)cbx.getSelectedItem();
            //JLabel nombre = new JLabel("Transferir a "+ receptor, JLabel.CENTER);
            int cuenta = 0;
            //
            frame.setVisible(false);
            //
            JFrame fijo = new JFrame();
            //
            fijo.setResizable(false);
            //
            fijo.setTitle("Transferencia Fija");
            Container cp01 =fijo.getContentPane();
            if (usuarios[indice].getEmpresa() == "Pro-Pisto"){
                cp01.setBackground(new Color(139,140,143));
                fijo.setIconImage(new ImageIcon(getClass().getResource("Imagenes/intercambio.png")).getImage());
            } else {
                cp01.setBackground(new Color(176,213,116));
                fijo.setIconImage(new ImageIcon(getClass().getResource("Imagenes/intercambio (2).png")).getImage());
            }           
            fijo.setLayout(new GridBagLayout());
            GridBagConstraints bag01 = new GridBagConstraints();
            //
            JPanel pnl03 = new JPanel();
            pnl03.setBackground(color0);
            for (int i = 0; i < billetes.length ; i ++ ){
                if (billetes[i] != null){
                    JButton j = new JButton("Q. "+billetes[i].getDenominacion()+".00");
                    j.setFont(new Font("Letter Gothic Std", Font.BOLD, 16));
                    //
                    j.addActionListener((ActionEvent ee)->{
                        int index = 0;
                        //
                        for (int p = 0 ; p < usuarios.length ; p ++){
                            if (usuarios[p]!=null){
                                if (usuarios[p].getUsuario().equals(receptor)){
                                    index = p;
                                }
                            }
                        }
                        JButton obj = (JButton)ee.getSource();
                        int monto = Integer.parseInt(obj.getText().substring(3, obj.getText().length()-3));
                        int subtotal = usuarios[index].getActual()+monto;
                        //
                        int aux = 0;
                        if (usuarios[index].getMaximo() < subtotal){
                            JOptionPane.showMessageDialog(null, "El «Usuario receptor» ha alcanzado el límite de su cuenta","Transferencia Fija",JOptionPane.INFORMATION_MESSAGE);
                        } else if (usuarios[indice].getActual() >= monto){
                            for (int k = 0 ; k < transacciones[indice].length ; k++){
                                if (transacciones[indice][k] == null){
                                    usuarios[indice].setActual(usuarios[indice].getActual()-monto);
                                    transacciones[indice][k] = new Usuario(usuarios[indice].getUsuario(),usuarios[index].getUsuario(),monto,new Date(),"TRFSD");
                                    aux = k;
                                    break;
                                }
                            }
                            for (int t = 0 ; t < transacciones[index].length ; t++){
                                if (transacciones[index][t] == null){
                                    transacciones[index][t] = new Usuario(usuarios[indice].getUsuario(),usuarios[index].getUsuario(),monto,new Date(),"TRFSD");
                                    usuarios[index].setActual(usuarios[index].getActual()+monto);
                                    JOptionPane.showMessageDialog(null, ("Transferencia Exitosa"),"Transferencia Fija",JOptionPane.INFORMATION_MESSAGE);
                                    Imprimir(usuarios[indice].getNombre(),
                                    usuarios[indice].getUsuario(),
                                    usuarios[index].getUsuario(),monto,
                                    transacciones[indice][aux].getFecha(),"TRFSD",index,aux);
                                    break;
                                }
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "Tu saldo es insuficiente para completar esta transferencia","Transferencia Fija",JOptionPane.INFORMATION_MESSAGE);                               
                        }
                        fijo.dispose();
                        cp.validate();
                        frame.setVisible(true);
                        });
                    
                    //
                    pnl03.add(j);
                    //cuenta = i;
                } else {
                    cuenta = i;
                    break;
                }
            }
            System.out.println("esta es la cuenta" +  cuenta);
            pnl03.setLayout(new GridLayout((cuenta+1)/2,2));
            pnl03.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(),"Selecciona el Monto a Transferir a:\n" + receptor,TitledBorder.LEFT, 
                TitledBorder.TOP,new Font("Letter Gothic Std", Font.BOLD, 12), Color.black));
            //
            bag01.gridx = 0;
            bag01.gridy = 0;
            bag01.gridheight = cuenta;
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
            String receptor = (String)cbx.getSelectedItem();
            frame.setVisible(false);
            //
            JFrame fijo = new JFrame();
            fijo.setResizable(false);
            fijo.setTitle("Transferencia Libre");
            Container cp01 = fijo.getContentPane();
            if (usuarios[indice].getEmpresa() == "Pro-Pisto"){
                cp01.setBackground(new Color(139,140,143));
                fijo.setIconImage(new ImageIcon(getClass().getResource("Imagenes/intercambio.png")).getImage());
            } else {
                cp01.setBackground(new Color(176,213,116));
                fijo.setIconImage(new ImageIcon(getClass().getResource("Imagenes/intercambio (2).png")).getImage());
            }           
            fijo.setLayout(new GridBagLayout());
            GridBagConstraints bag01 = new GridBagConstraints();
            //
            JPanel pnl03 = new JPanel();
            //
            pnl03.setBackground(color);
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
            pnl03.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(),"Ingresa el Monto a Transferir a: " + receptor,TitledBorder.LEFT, 
                TitledBorder.TOP,new Font("Letter Gothic Std", Font.BOLD, 12), Color.black));
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
                int aux = 0;
                try{
                    int monto = Integer.parseInt(txt01.getText());
                    int index = 0;
                    for (int p = 0 ; p < usuarios.length ; p ++){
                        if (usuarios[p]!=null){
                            if (usuarios[p].getUsuario().equals(receptor)){
                                index = p;
                            }
                        }
                    }
                    int max = (usuarios[index].getActual()+monto);
                    if (usuarios[indice].getActual() >= monto){//saldo suficiente
                        if (max <= usuarios[index].getMaximo()){//monto maximo no alcanzado
                            for (int k = 0; k < transacciones[indice].length ; k++){
                                if (transacciones[indice][k] == null){
                                    usuarios[indice].setActual(usuarios[indice].getActual()-monto);
                                    transacciones[indice][k] = new Usuario(usuarios[indice].getUsuario(),usuarios[index].getUsuario(),monto,new Date(),"TRFSL");
                                    break;
                                }
                            }
                            for (int t = 0 ; t < transacciones[index].length ; t++){
                                if (transacciones[index][t] == null){
                                    usuarios[index].setActual(usuarios[index].getActual()+monto);
                                    transacciones[index][t] = new Usuario(usuarios[indice].getUsuario(),usuarios[index].getUsuario(),monto,new Date(),"TRFSL");
                                    Imprimir(usuarios[indice].getNombre(),
                                    usuarios[indice].getUsuario(),
                                    usuarios[index].getUsuario(),monto,
                                    transacciones[indice][aux].getFecha(),"TRFSL",index,aux);
                                    
                                    JOptionPane.showMessageDialog(null, ("Transferencia Exitosa"),"Transferencia Libre",JOptionPane.INFORMATION_MESSAGE);
                                    txt01.setText("");
                                    break;
                                }
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "El saldo a transferir desborda el salario maximo del receptor","Transferencia Fija",JOptionPane.INFORMATION_MESSAGE);                               
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Tu saldo es insuficiente para completar la transferencia","Transferencia Fija",JOptionPane.INFORMATION_MESSAGE);                               
                    }
                    //
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
        frame.setSize(400, 400);
        frame.setLocationRelativeTo(null);
        cp.validate();
    }
    
    void SaldoActual (JFrame frame, Usuario[] usuarios, Usuario[][] transacciones, int indice){
        frame.setLayout(new GridBagLayout());
        Container cp = frame.getContentPane();
        GridBagConstraints bag = new GridBagConstraints();
        //
        DateFormat hourdate = new SimpleDateFormat("HH:mm:ss dd/MM/yyyy");
        //
        JPanel pnl01 = new JPanel();
        if (usuarios[indice].getEmpresa() == "Pro-Pisto"){
            Color color = new Color(167,168,169);
            pnl01.setBackground(color);
        } else {
            Color color = new Color(87,203,58);
            pnl01.setBackground(color);
        }
        //        
        JLabel lbl01 = new JLabel("Usuario:");
        JLabel lbl02 = new JLabel(usuarios[indice].getUsuario());
        JLabel lbl03 = new JLabel("Nombre:");
        JLabel lbl04 = new JLabel(usuarios[indice].getNombre());
        JLabel lbl05 = new JLabel("Saldo Actual:");
        JLabel lbl06 = new JLabel("Q. "+String.valueOf(usuarios[indice].getActual())+".00");
        JLabel lbl07 = new JLabel("Afiliado a:");
        JLabel lbl08 = new JLabel(usuarios[indice].getEmpresa());
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
        lbl09.setForeground(Color.black);
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
                TitledBorder.TOP,new Font("Letter Gothic Std", Font.BOLD, 14), Color.black));
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
        //
        frame.setSize(400, 400);
        frame.setLocationRelativeTo(null);
        cp.validate();
    }
    
    void Reimpresion (JFrame frame,Usuario[] usuarios ,Usuario[][] transacciones,int indice){
        int cuenta = 0;
        frame.setLayout(new GridBagLayout());
        Container cp = frame.getContentPane();
        GridBagConstraints bag = new GridBagConstraints();
        DateFormat hourdate = new SimpleDateFormat("dd/MM/yyyy");
        //
        JPanel pnl01 = new JPanel();
        if (usuarios[indice].getEmpresa() == "Pro-Pisto"){
            Color color0 = new Color(156,157,160);
            pnl01.setBackground(color0);
        } else {
            Color color0 = new Color(143,194,58);
            pnl01.setBackground(color0);
        }
        //
        for (int i = 0 ; i < transacciones[indice].length ;  i++){
            if (transacciones[indice][i]!=null){
                if (transacciones[indice][i].getEmisor().equals(usuarios[indice].getUsuario()) ||
                        transacciones[indice][i].getReceptor().equals(usuarios[indice].getUsuario())){
                    JButton btn = new JButton();
                    int index = indice;
                    int j = i;
                    String emisor = transacciones[indice][i].getEmisor();
                    String receptor = transacciones[indice][i].getReceptor();
                    int monto = transacciones[indice][i].getMonto();
                    String transaccion = transacciones[indice][i].getTransaccion();
                    String nombre = usuarios[indice].getNombre();
                    Date fecha = transacciones[indice][i].getFecha();
                    //
                    btn.setText("<html>"+indice+"@"+i+"#"+transaccion+" "+hourdate.format(fecha)+";"+emisor
                            +"►"+receptor+" Q. " + monto+".00</html>");
                    btn.setFont(new Font("Letter Gothic Std", Font.PLAIN, 10));
                    pnl01.add(btn);
                    //cuenta = i;
                    btn.addActionListener((ActionEvent e) -> {
                        Imprimir(nombre,emisor,receptor,monto,fecha,transaccion,index,j);
                    });
                }
            } else {
                cuenta = i;
                break;
            }
        }
        JLabel lbl01 = new JLabel("----Última Linea----", JLabel.CENTER);
        lbl01.setFont(new Font("Letter Gothic Std", Font.PLAIN, 11));
        pnl01.add(lbl01);
        System.out.println(cuenta+1);
        pnl01.setLayout(new GridLayout(cuenta+1,1));
        pnl01.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(),"Movimientos de Usuario",TitledBorder.LEFT, 
                TitledBorder.TOP,new Font("Letter Gothic Std", Font.BOLD, 13), Color.black));
        bag.gridx = 0;
        bag.gridy = 0;
        bag.gridheight = cuenta+1;
        bag.gridwidth = 1;
        bag.weightx = 1;
        bag.fill = GridBagConstraints.BOTH;
        bag.anchor = GridBagConstraints.CENTER;
        cp.add(pnl01,bag);
        frame.setLocationRelativeTo(null);
        frame.setSize(400, 400);
        cp.validate();
    }
    
    void GraficaPie (JFrame frame, Usuario[] usuarios,Usuario[][] transacciones,int indice){
        Container cp = frame.getContentPane();
        frame.setLayout(new GridLayout(1,1));
        DefaultPieDataset data = new DefaultPieDataset();
        String arr[] = new String[transacciones[indice].length];
        int ent[] = new int[transacciones[indice].length];
        //
        try {
        for (int i = 0; i < transacciones[indice].length ; i++) {
            if (transacciones[indice][i]!=null) {
                if (transacciones[indice][i].getReceptor()!=usuarios[indice].getUsuario()) {
                    for (int p = 0 ; p < arr.length ; p++) {
                        if (arr[p]!=null){
                            if (arr[p].equals(transacciones[indice][i].getReceptor())){
                                System.out.println(arr[p]);
                                ent[p] = (ent[p]+ transacciones[indice][i].getMonto());
                                break;
                            }
                        } else {
                            arr[p] = transacciones[indice][i].getReceptor();
                            ent[p] = transacciones[indice][i].getMonto();
                            break;
                        }
                    }
                }
            } else {
                break;
            }
        }
        for (int i = 0 ; i < arr.length; i++){
            if (arr[i]!=null) {
                data.setValue((arr[i]+"Q. "+ent[i]+".00"),ent[i]);
            } else {
                break;
            }
        }
        JFreeChart chart = ChartFactory.createPieChart(
                "Transferencias por usuario",
                data,
                true,
                true,
                true
        );
        ChartPanel frame1 = new ChartPanel(chart);
        //panel.add(frame1);
        cp.add(frame1);
        } catch (Exception e){
            JLabel lbl = new JLabel("--Ocurrio un error. Contacte al Administrador--",JLabel.CENTER);
            lbl.setFont(new Font("Letter Gothic Std", Font.BOLD, 16));
            cp.add(lbl);
        }
        cp.validate();
        frame.pack();
        frame.setLocationRelativeTo(null);
    }
    
    void GraficaBarras (JFrame frame, Usuario[] usuarios,Usuario[][] transacciones,int indice){
        Container cp = frame.getContentPane();
        frame.setLayout(new GridLayout(1,1));
        SimpleDateFormat getMes = new SimpleDateFormat("MM");
        int Mes = Integer.parseInt(getMes.format(new Date()));
        int[] transferencias = {0,0,0,0,0,0,0,0,0,0,0,0};
        int[] retiros = {0,0,0,0,0,0,0,0,0,0,0,0};
        int[] Meses = {1,2,3,4,5,6,7,8,9,10,11,12};
        String[] meses = {"Enero","Febrero","Marzo","Abril","Mayo","Junio","Julio","Agosto","Septiembre","Octubre","Noviembre","Deciembre"};
        DefaultCategoryDataset data = new DefaultCategoryDataset();
        //for
        for (int i = 0; i < transacciones[indice].length ; i++) {
            if (transacciones[indice][i]!=null) {
                if (transacciones[indice][i].getTransaccion().equals("TRFSD")||transacciones[indice][i].getTransaccion().equals("TRFSL")) {
                    for (int j = 0 ; j < 12 ; j++){
                        if (Meses[j]==Integer.parseInt( getMes.format( transacciones[indice][i].getFecha() ) ) ){
                            transferencias[j] = (transferencias[j]+transacciones[indice][i].getMonto());
                            break;
                        }
                    }
                } else if (transacciones[indice][i].getTransaccion().equals("RTR")){
                    for (int j = 0 ; j < 12 ; j++){
                        if (Meses[j]==Integer.parseInt( getMes.format( transacciones[indice][i].getFecha() ) ) ){
                            retiros[j] = (retiros[j]+transacciones[indice][i].getMonto());
                            break;
                        }
                    }
                }
            } else {
                break;
            }
        }
        for (int i = 0 ; i < 12; i++){
            if (retiros[i]!=0) {
                data.setValue(retiros[i],"Retiros",meses[i]);
            } 
            if(transferencias[i]!=0){
                data.setValue(transferencias[i],"Transferencias",meses[i]);
            }
        }
        //
        JFreeChart chart = ChartFactory.createBarChart("Transacciones por Mes"/*Titulo superior*/,
            "Meses"/*Titulo-xx*/, "Monto total"/*Titulo-yy*/, 
            data, PlotOrientation.VERTICAL/*Barras verticales*/, true,
            true, false);
        ChartPanel frame1 = new ChartPanel(chart);
        cp.add(frame1);
        //frame.pack();
        cp.validate();
        frame.pack();
        frame.setLocationRelativeTo(null);
    }
    
    void Imprimir(String nombre, String emisor, String receptor, int monto, Date fecha, String transaccion, int indice, int i){
        int option = JOptionPane.showConfirmDialog(null, "¿Desea imprimir su recibo?","Clientes - SIBE",JOptionPane.YES_NO_OPTION,JOptionPane.INFORMATION_MESSAGE);    
        if (option == 0){      
            String ruta = "C:\\Users\\"+System.getProperty("user.name")+"\\Desktop\\"+"REF"+indice+"X"+i+"X"+transaccion+".html";
            DateFormat hourdate = new SimpleDateFormat("dd/MM/yyyy");
            String acceso = "Propio";
            String clave = "------";
            if (emisor!=(receptor)){
                clave = receptor;
                acceso = "A Terceros";
            }
            try{
                File html = new File(ruta);
                BufferedWriter f = new BufferedWriter(new FileWriter(html));
                f.write("<!DOCTYPE html>\n" +
                        "<html>\n" +
                        "  <style type=\"text/css\">\n" +
                        "    .tg  {border-collapse:collapse;border-spacing:0;margin:0px auto;}\n" +
                        "    .tg td{font-family:Letter Gothic Std, sans-serif;font-size:14px;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;}\n" +
                        "  </style>\n" +
                        "<head> \n" +
                        "  <meta http-equiv=\"Content-Type\" content=\"text/html; charset=windows-1252\"> \n" +
                        "  <title>"+"TRANSXXXX"+indice+"@"+i+"#"+transaccion+"</title> \n" +
                        "</head> \n" +
                        "<body topmargin=\"10\" leftmargin=\"10\" marginwidth=\"20\" marginheight=\"20\" scroll=\"no\" style=\"overflow:hidden\">\n" +
                        "  <table class=\"tg\" border=\"4\" cellspacing=\"1\" style=\"border-collapse: collapse\" bordercolor=\"#111111\" height=\"100%\" width = \"100%\">\n" +
                        "      <tr>\n" +
                        "        <td rowspan=\"3\" class=\"tg-031e\" align=\"center\" valign=\"middle\" ><img src=\"Cash-Money-02.png\" height=8% alt=\"Cash-Money\"/></td>\n" +
                        "	<td class=\"tg-031e\">Ref. "+indice+"@"+i+"#"+transaccion+"</td>\n" +
                        "      	<td class=\"tg-031e\">"+hourdate.format(fecha)+"</td>\n" +
                        "      	<td class=\"tg-031e\"><div align=right>Q. "+monto+".00</div></td>\n" +
                        "      </tr>\n" +
                        "    <tr>\n" +
                        "      <td class=\"tg-031e\" colspan=\"3\">Usuario:  "+emisor+"\n" +
                        "        <br/><br/>Nombre:  "+nombre+"</td>\n" +
                        "    </tr>\n" +
                        "    <tr>\n" +
                        "      <td class=\"tg-031e\" colspan=\"3\">Acceso:  "+acceso+"<br/><br/>Usuario: "+clave+"</td>\n" +
                        "    </tr>\n" +
                        "  </table>\n" +
                        "</body>\n" +
                        "</html>");
                f.close();               
                JOptionPane.showMessageDialog(null, "Tome su recibo","Clientes - SIBE",JOptionPane.INFORMATION_MESSAGE);
                Desktop.getDesktop().open(html);
            }catch (Exception e){
                JOptionPane.showMessageDialog(null, "Ocurrio un error. Contacte al Administrador","Clientes - SIBE",JOptionPane.ERROR_MESSAGE);    
            }//JOptionPane.showMessageDialog(null, "Tome su recibo","Clientes - SIBE",JOptionPane.INFORMATION_MESSAGE);    
        }
    }
}
