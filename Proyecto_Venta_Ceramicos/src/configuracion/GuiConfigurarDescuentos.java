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

public class GuiConfigurarDescuentos extends JDialog implements ActionListener, KeyListener, MouseListener {

  private final JPanel contentPanel = new JPanel();
  private JLabel lblA;
  private JTextField txtPor1;
  private JLabel lblA_1;
  private JTextField txtPor2;
  private JLabel lblA_2;
  private JTextField txtPor3;
  private JLabel lblMsDe;
  private JTextField txtPor4;
  private JLabel label;
  private JLabel label_1;
  private JLabel label_2;
  private JLabel label_3;
  private JButton btnAceptar;
  private JButton btnCancelar;
  private JLabel label_4;
  private JLabel label_5;
  private JLabel label_6;
  private JLabel label_7;

  /**
   * Launch the application.
   */
  public static void main(String[] args) {
    try {
      GuiConfigurarDescuentos dialog = new GuiConfigurarDescuentos(null, true);
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
  public GuiConfigurarDescuentos(GuiMenuTienda menu, boolean b) {
    super(menu, b); //Bloquea la ventana hasta que la cierren
    setTitle("Configurar porcentajes de descuento");
    setBounds(100, 100, 472, 206);
    setResizable(false);
    FlatMaterialLighterIJTheme.setup();
    UIManager.put( "Button.arc", 10);
    UIManager.put("Component.focusColor", Color.decode("#9499B4"));
    getContentPane().setLayout(new BorderLayout());
    contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
    getContentPane().add(contentPanel, BorderLayout.CENTER);
    contentPanel.setLayout(null);

    lblA = new JLabel("1 a 5 unidades");
    lblA.setBounds(15, 20, 146, 14);
    contentPanel.add(lblA);

    txtPor1 = new JTextField();
    txtPor1.setBackground(Color.WHITE);
    txtPor1.addKeyListener(this);
    txtPor1.setColumns(10);
    txtPor1.setBounds(129, 17, 110, 25);
    contentPanel.add(txtPor1);

    lblA_1 = new JLabel("6 a 10 unidades");
    lblA_1.setBounds(15, 60, 146, 14);
    contentPanel.add(lblA_1);

    txtPor2 = new JTextField();
    txtPor2.setBackground(Color.WHITE);
    txtPor2.addKeyListener(this);
    txtPor2.setColumns(10);
    txtPor2.setBounds(129, 55, 110, 25);
    contentPanel.add(txtPor2);

    lblA_2 = new JLabel("11 a 15 unidades");
    lblA_2.setBounds(15, 100, 146, 14);
    contentPanel.add(lblA_2);

    txtPor3 = new JTextField();
    txtPor3.setBackground(Color.WHITE);
    txtPor3.addKeyListener(this);
    txtPor3.setColumns(10);
    txtPor3.setBounds(129, 95, 110, 25);
    contentPanel.add(txtPor3);

    lblMsDe = new JLabel("M\u00E1s de 15 unidades");
    lblMsDe.setBounds(15, 140, 146, 14);
    contentPanel.add(lblMsDe);

    txtPor4 = new JTextField();
    txtPor4.setBackground(Color.WHITE);
    txtPor4.addKeyListener(this);
    txtPor4.setColumns(10);
    txtPor4.setBounds(129, 135, 110, 25);
    contentPanel.add(txtPor4);

    label = new JLabel("%");
    label.setBounds(249, 20, 25, 14);
    contentPanel.add(label);

    label_1 = new JLabel("%");
    label_1.setBounds(249, 60, 25, 14);
    contentPanel.add(label_1);

    label_2 = new JLabel("%");
    label_2.setBounds(249, 100, 25, 14);
    contentPanel.add(label_2);

    label_3 = new JLabel("%");
    label_3.setBounds(249, 140, 25, 14);
    contentPanel.add(label_3);

    btnAceptar = new JButton("Aceptar");
    btnAceptar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    btnAceptar.setForeground(Color.WHITE);
    btnAceptar.setBackground(Color.decode("#03071E"));
    btnAceptar.setBorderPainted(false);
    btnAceptar.addActionListener(this);
    btnAceptar.setBounds(321, 16, 110, 30);
    contentPanel.add(btnAceptar);

    btnCancelar = new JButton("Cancelar");
    btnCancelar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    btnCancelar.setForeground(Color.WHITE);
    btnCancelar.setBackground(Color.decode("#370617"));
    btnCancelar.setBorderPainted(false);
    btnCancelar.addActionListener(this);
    btnCancelar.setBounds(321, 56, 110, 30);
    contentPanel.add(btnCancelar);

    label_4 = new JLabel("");
    label_4.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    label_4.addMouseListener(this);
    label_4.setIcon(new ImageIcon(GuiConfigurarDescuentos.class.getResource("/images/editar.png")));
    label_4.setBounds(269, 17, 25, 25);
    contentPanel.add(label_4);

    label_5 = new JLabel("");
    label_5.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    label_5.addMouseListener(this);
    label_5.setIcon(new ImageIcon(GuiConfigurarDescuentos.class.getResource("/images/editar.png")));
    label_5.setBounds(269, 55, 25, 25);
    contentPanel.add(label_5);

    label_6 = new JLabel("");
    label_6.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    label_6.addMouseListener(this);
    label_6.setIcon(new ImageIcon(GuiConfigurarDescuentos.class.getResource("/images/editar.png")));
    label_6.setBounds(269, 95, 25, 25);
    contentPanel.add(label_6);

    label_7 = new JLabel("");
    label_7.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    label_7.addMouseListener(this);
    label_7.setIcon(new ImageIcon(GuiConfigurarDescuentos.class.getResource("/images/editar.png")));
    label_7.setBounds(269, 135, 25, 25);
    contentPanel.add(label_7);

    setIconImage(new ImageIcon(getClass().getResource("/images/icono.png")).getImage());

    mostrarPorcentajes();
  }
  public void actionPerformed(ActionEvent arg0) {
    if (arg0.getSource() == btnCancelar) {
      actionPerformedBtnCancelar(arg0);
    }
    if (arg0.getSource() == btnAceptar) {
      actionPerformedBtnAceptar(arg0);
    }
  }

  protected void actionPerformedBtnAceptar(ActionEvent arg0) {
    configurar(txtPor1.getText(), txtPor2.getText(), txtPor3.getText(), txtPor4.getText(), "\\d+(\\.\\d+)?");
  }

  protected void actionPerformedBtnCancelar(ActionEvent arg0) {
    setVisible(false);
  }

  public void keyPressed(KeyEvent arg0) {
  }
  public void keyReleased(KeyEvent arg0) {
  }
  public void keyTyped(KeyEvent arg0) {
    if (arg0.getSource() == txtPor4) {
      keyTypedTxtPor4(arg0);
    }
    if (arg0.getSource() == txtPor3) {
      keyTypedTxtPor3(arg0);
    }
    if (arg0.getSource() == txtPor2) {
      keyTypedTxtPor2(arg0);
    }
    if (arg0.getSource() == txtPor1) {
      keyTypedTxtPor1(arg0);
    }
  }
  protected void keyTypedTxtPor1(KeyEvent arg0) {
    char c = arg0.getKeyChar();
    if((c<'0' || c>'9') && c!='.') arg0.consume();
  }
  protected void keyTypedTxtPor2(KeyEvent arg0) {
    char c = arg0.getKeyChar();
    if((c<'0' || c>'9') && c!='.') arg0.consume();
  }
  protected void keyTypedTxtPor3(KeyEvent arg0) {
    char c = arg0.getKeyChar();
    if((c<'0' || c>'9') && c!='.') arg0.consume();
  }
  protected void keyTypedTxtPor4(KeyEvent arg0) {
    char c = arg0.getKeyChar();
    if((c<'0' || c>'9') && c!='.') arg0.consume();
  }
  
  public void mouseClicked(MouseEvent e) {
    if (e.getSource() == label_7) {
      mouseClickedLabel_7(e);
    }
    if (e.getSource() == label_6) {
      mouseClickedLabel_6(e);
    }
    if (e.getSource() == label_5) {
      mouseClickedLabel_5(e);
    }
    if (e.getSource() == label_4) {
      mouseClickedLabel_4(e);
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
  protected void mouseClickedLabel_4(MouseEvent e) {
    editarCampo(txtPor1);
  }
  protected void mouseClickedLabel_5(MouseEvent e) {
    editarCampo(txtPor2);
  }
  protected void mouseClickedLabel_6(MouseEvent e) {
    editarCampo(txtPor3);
  }
  protected void mouseClickedLabel_7(MouseEvent e) {
    editarCampo(txtPor4);
  }

  //METODOS

  //Metodo para aceptar configuración
  void configurar(String Por1, String Por2, String Por3, String Por4, String exr){
    String s;
    if(validarCampos(Por1, Por2, Por3, Por4, exr)){
      GuiMenuTienda.porcentaje1=Double.parseDouble(Por1);
      GuiMenuTienda.porcentaje2=Double.parseDouble(Por2);
      GuiMenuTienda.porcentaje3=Double.parseDouble(Por3);
      GuiMenuTienda.porcentaje4=Double.parseDouble(Por4);
      s="Cambios guardados";
      JOptionPane.showMessageDialog(this, s, "MENSAJE DE INFORMACION", JOptionPane.INFORMATION_MESSAGE);
      
      setVisible(false);
    }
  }
  
  //Metodo para validar campos
  boolean validarCampos(String Por1, String Por2, String Por3, String Por4, String exr){
    String s;

    //Validando si tiene espacios vacíos
    if(Por1.isEmpty()||Por2.isEmpty()||Por3.isEmpty()||Por4.isEmpty()){
      s="Complete los campos vacíos";
      JOptionPane.showMessageDialog(this, s, "MENSAJE DE ERROR", JOptionPane.ERROR_MESSAGE);
      return false;

      //Validando si puede ser convertido a numero
    }else if(!(Por1.matches(exr)&&Por2.matches(exr)&&Por3.matches(exr)&&Por4.matches(exr))){
      s="Los datos ingresados no son válidos";
      JOptionPane.showMessageDialog(this, s, "MENSAJE DE ERROR", JOptionPane.ERROR_MESSAGE);
      return false;
      
    }else{
      return true;
    }
  }

  //Metodo para mostrar los porcentajes en las cajas
  void mostrarPorcentajes () {
    txtPor1.setText(""+GuiMenuTienda.porcentaje1);
    txtPor2.setText(""+GuiMenuTienda.porcentaje2);
    txtPor3.setText(""+GuiMenuTienda.porcentaje3);
    txtPor4.setText(""+GuiMenuTienda.porcentaje4);
  }

  //Metodo para editar campo
  void editarCampo(JTextField campo){
    campo.setText("");
    campo.requestFocus();
  }
}
