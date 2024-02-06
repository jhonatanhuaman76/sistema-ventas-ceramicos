package configuracion;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatMaterialLighterIJTheme;

import menu.GuiMenuTienda;
import menu.GuiMenuTienda;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.UIManager;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

public class GuiConfigurarObsequios extends JDialog implements ActionListener, KeyListener, MouseListener {

  private final JPanel contentPanel = new JPanel();
  private JLabel lblTipoDeObsequio;
  private JTextField txtObs;
  private JLabel lblA;
  private JTextField txtCantObs1;
  private JLabel lblA_1;
  private JTextField txtCantObs2;
  private JLabel lblAMs;
  private JTextField txtCantObs3;
  private JButton btnAceptar;
  private JButton btnCancelar;
  private JLabel lblEdit1;
  private JLabel lblEdit2;
  private JLabel lblEdit3;
  private JLabel lblEdit4;

  /**
   * Launch the application.
   */
  public static void main(String[] args) {
    try {
      GuiConfigurarObsequios dialog = new GuiConfigurarObsequios(null, true);
      dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
      dialog.setVisible(true);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * Create the dialog.
   * @param b 
   * @param menu 
   */
  public GuiConfigurarObsequios(GuiMenuTienda menu, boolean b) {
    super(menu, b); //Bloquea la ventana hasta que la cierren
    setTitle("Configurar Obsequios");
    setBounds(100, 100, 445, 206);
    setResizable(false);
    FlatMaterialLighterIJTheme.setup();
    UIManager.put( "Button.arc", 10);
    UIManager.put("Component.focusColor", Color.decode("#9499B4"));
    getContentPane().setLayout(new BorderLayout());
    contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
    getContentPane().add(contentPanel, BorderLayout.CENTER);
    contentPanel.setLayout(null);

    lblTipoDeObsequio = new JLabel("TIpo de obsequio");
    lblTipoDeObsequio.setBounds(15, 20, 146, 14);
    contentPanel.add(lblTipoDeObsequio);

    txtObs = new JTextField();
    txtObs.setBackground(Color.WHITE);
    txtObs.addKeyListener(this);
    txtObs.setColumns(10);
    txtObs.setBounds(130, 17, 110, 25);
    contentPanel.add(txtObs);

    lblA = new JLabel("1 a 5 unidades");
    lblA.setBounds(15, 60, 146, 14);
    contentPanel.add(lblA);

    txtCantObs1 = new JTextField();
    txtCantObs1.setBackground(Color.WHITE);
    txtCantObs1.addKeyListener(this);
    txtCantObs1.setColumns(10);
    txtCantObs1.setBounds(130, 55, 110, 25);
    contentPanel.add(txtCantObs1);

    lblA_1 = new JLabel("6 a 10 unidades");
    lblA_1.setBounds(15, 100, 146, 14);
    contentPanel.add(lblA_1);

    txtCantObs2 = new JTextField();
    txtCantObs2.setBackground(Color.WHITE);
    txtCantObs2.addKeyListener(this);
    txtCantObs2.setColumns(10);
    txtCantObs2.setBounds(130, 95, 110, 25);
    contentPanel.add(txtCantObs2);

    lblAMs = new JLabel("11 a m\u00E1s unidades");
    lblAMs.setBounds(15, 140, 146, 14);
    contentPanel.add(lblAMs);

    txtCantObs3 = new JTextField();
    txtCantObs3.setBackground(Color.WHITE);
    txtCantObs3.addKeyListener(this);
    txtCantObs3.setColumns(10);
    txtCantObs3.setBounds(130, 135, 110, 25);
    contentPanel.add(txtCantObs3);

    btnAceptar = new JButton("Aceptar");
    btnAceptar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    btnAceptar.setForeground(Color.WHITE);
    btnAceptar.setBackground(Color.decode("#03071E"));
    btnAceptar.setBorderPainted(false);
    btnAceptar.addActionListener(this);
    btnAceptar.setBounds(300, 16, 110, 30);
    contentPanel.add(btnAceptar);

    btnCancelar = new JButton("Cancelar");
    btnCancelar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    btnCancelar.setForeground(Color.WHITE);
    btnCancelar.setBackground(Color.decode("#370617"));
    btnCancelar.setBorderPainted(false);
    btnCancelar.addActionListener(this);
    btnCancelar.setBounds(300, 56, 110, 30);
    contentPanel.add(btnCancelar);

    lblEdit1 = new JLabel("");
    lblEdit1.addMouseListener(this);
    lblEdit1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    lblEdit1.setIcon(new ImageIcon(GuiConfigurarObsequios.class.getResource("/images/editar.png")));
    lblEdit1.setBounds(250, 17, 25, 25);
    contentPanel.add(lblEdit1);

    lblEdit2 = new JLabel("");
    lblEdit2.addMouseListener(this);
    lblEdit2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    lblEdit2.setIcon(new ImageIcon(GuiConfigurarObsequios.class.getResource("/images/editar.png")));
    lblEdit2.setBounds(250, 55, 25, 25);
    contentPanel.add(lblEdit2);

    lblEdit3 = new JLabel("");
    lblEdit3.addMouseListener(this);
    lblEdit3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    lblEdit3.setIcon(new ImageIcon(GuiConfigurarObsequios.class.getResource("/images/editar.png")));
    lblEdit3.setBounds(250, 95, 25, 25);
    contentPanel.add(lblEdit3);

    lblEdit4 = new JLabel("");
    lblEdit4.addMouseListener(this);
    lblEdit4.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    lblEdit4.setIcon(new ImageIcon(GuiConfigurarObsequios.class.getResource("/images/editar.png")));
    lblEdit4.setBounds(250, 135, 25, 25);
    contentPanel.add(lblEdit4);

    setIconImage(new ImageIcon(getClass().getResource("/images/icono.png")).getImage());

    //Muestra los valores por defecto al iniciar la ventana
    mostrarObsequios();
  }

  public void actionPerformed(ActionEvent arg0) {
    if (arg0.getSource() == btnCancelar) {
      actionPerformedBtnCancelar(arg0);
    }
    if (arg0.getSource() == btnAceptar) {
      actionPerformedBtnAceptar(arg0);
    }
  }

  //Accion del boton aceptar
  protected void actionPerformedBtnAceptar(ActionEvent arg0) {
    configurar(txtObs.getText(), txtCantObs1.getText(), txtCantObs2.getText(), txtCantObs3.getText(), "\\d+");
  }

  //Accion del boton cancelar
  protected void actionPerformedBtnCancelar(ActionEvent arg0) {
    setVisible(false);
  }

  public void keyPressed(KeyEvent e) {
  }

  public void keyReleased(KeyEvent e) {
  }

  public void keyTyped(KeyEvent e) {
    if (e.getSource() == txtCantObs3) {
      keyTypedTxtCantObs3(e);
    }
    if (e.getSource() == txtCantObs2) {
      keyTypedTxtCantObs2(e);
    }
    if (e.getSource() == txtCantObs1) {
      keyTypedTxtCantObs1(e);
    }
    if (e.getSource() == txtObs) {
      keyTypedTxtObs(e);
    }
  }

  //Controla los caracteres de la cajas

  protected void keyTypedTxtObs(KeyEvent e) {
    char c = e.getKeyChar();
    if((c<'a' || c>'z') && (c<'A' || c>'Z')) e.consume();
  }

  protected void keyTypedTxtCantObs1(KeyEvent e) {
    char c = e.getKeyChar();
    if(c<'0' || c>'9' ) e.consume();
  }

  protected void keyTypedTxtCantObs2(KeyEvent e) {
    char c = e.getKeyChar();
    if(c<'0' || c>'9' ) e.consume();
  }

  protected void keyTypedTxtCantObs3(KeyEvent e) {
    char c = e.getKeyChar();
    if(c<'0' || c>'9' ) e.consume();
  }
  
  public void mouseClicked(MouseEvent e) {
    if (e.getSource() == lblEdit3) {
      mouseClickedLblEdit3(e);
    }
    if (e.getSource() == lblEdit1) {
      mouseClickedLblEdit1(e);
    }
    if (e.getSource() == lblEdit2) {
      mouseClickedLblEdit2(e);
    }
    if (e.getSource() == lblEdit4) {
      mouseClickedLblEdit4(e);
    }
  }
  
  public void mouseEntered(MouseEvent e) {
  }
  public void mouseExited(MouseEvent e) {
  }
  public void mousePressed(MouseEvent e) {
  }
  public void mouseReleased(MouseEvent e) {
  }
  protected void mouseClickedLblEdit4(MouseEvent e) {
    editarCampo(txtCantObs3);
  }
  protected void mouseClickedLblEdit2(MouseEvent e) {
    editarCampo(txtCantObs1);
  }
  protected void mouseClickedLblEdit1(MouseEvent e) {
    editarCampo(txtObs);
  }
  protected void mouseClickedLblEdit3(MouseEvent e) {
    editarCampo(txtCantObs2);
  }

  //METODOS

  //Metodos para aceptar configuracion
  void configurar(String obs, String cantObs1, String cantObs2, String cantObs3, String exr){
    String s;
    if(validarCampos(obs, cantObs1, cantObs2, cantObs3, exr)){
      GuiMenuTienda.tipoObsequio=obs;
      GuiMenuTienda.obsequioCantidad1=Integer.parseInt(cantObs1);
      GuiMenuTienda.obsequioCantidad2=Integer.parseInt(cantObs2);
      GuiMenuTienda.obsequioCantidad3=Integer.parseInt(cantObs3);
      s="Cambios guardados";
      JOptionPane.showMessageDialog(this, s, "MENSAJE DE INFORMACION", JOptionPane.INFORMATION_MESSAGE);
      
      setVisible(false);
    }
  }
  
  //Metodo para validar campos
  boolean validarCampos(String obs, String cantObs1, String cantObs2, String cantObs3, String exr){
    String s;

    //Validando si tiene espacios vac�os
    if(obs.isEmpty()||cantObs1.isEmpty()||cantObs2.isEmpty()||cantObs3.isEmpty()){
      s="Complete los campos vac�os";
      JOptionPane.showMessageDialog(this, s, "MENSAJE DE ERROR", JOptionPane.ERROR_MESSAGE);
      return false;

      //Validando si puede ser convertido a numero entero 
    }else if(!(cantObs1.matches(exr)&&cantObs2.matches(exr)&&cantObs3.matches(exr))){
      s="Los datos ingresados no son v�lidos";
      JOptionPane.showMessageDialog(this, s, "MENSAJE DE ERROR", JOptionPane.ERROR_MESSAGE);
      return false;

      //Validando si el numero es extremadamente grande
    }else if(numGrande(cantObs1)||numGrande(cantObs2)||numGrande(cantObs3)){
      s="La cantidad es extremadamente grande";
      JOptionPane.showMessageDialog(this, s, "MENSAJE DE ERROR", JOptionPane.ERROR_MESSAGE);
      return false;

    }else{
      return true;
    }
  }

  //Metodo para mostrar datos de obsequios
  void mostrarObsequios () {
    txtObs.setText(GuiMenuTienda.tipoObsequio);
    txtCantObs1.setText(""+GuiMenuTienda.obsequioCantidad1);
    txtCantObs2.setText(""+GuiMenuTienda.obsequioCantidad2);
    txtCantObs3.setText(""+GuiMenuTienda.obsequioCantidad3);
  }
  
  //Metodo para validar si el numero es extremadamente grande
  boolean numGrande(String num){
    if(Double.parseDouble(num) > 2147483647 ){
      return true;
    }else{
      return false;
    }
  }
  
  //Metodo para editar campo
  void editarCampo(JTextField campo){
    campo.setText("");
    campo.requestFocus();
  }
}
