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

public class GuiCantidadOptima extends JDialog implements ActionListener, KeyListener, MouseListener {

  private final JPanel contentPanel = new JPanel();
  private JTextField txtCantOp;
  private JButton btnAceptar;
  private JButton btnCancelar;
  private JLabel label;

  /**
   * Launch the application.
   */
  public static void main(String[] args) {
    try {
      GuiCantidadOptima dialog = new GuiCantidadOptima(null, true);
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
  public GuiCantidadOptima(GuiMenuTienda menu, boolean b) {
    super(menu, b); //Bloquea la ventana hasta que la cierren
    setTitle("Configurar Cantidad \u00D3ptima");
    setBounds(100, 100, 497, 139);
    setResizable(false);
    FlatMaterialLighterIJTheme.setup();
    UIManager.put( "Button.arc", 10);
    UIManager.put("Component.focusColor", Color.decode("#9499B4"));
    getContentPane().setLayout(new BorderLayout());
    contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
    getContentPane().add(contentPanel, BorderLayout.CENTER);
    contentPanel.setLayout(null);
    {
      JLabel lblCantidadptimaDe = new JLabel("Cantidad \u00F3ptima de unidades vendidas");
      lblCantidadptimaDe.setBounds(10, 35, 221, 14);
      contentPanel.add(lblCantidadptimaDe);
    }
    {
      txtCantOp = new JTextField();
      txtCantOp.setBackground(Color.WHITE);
      txtCantOp.addKeyListener(this);
      txtCantOp.setColumns(10);
      txtCantOp.setBounds(220, 30, 67, 25);
      contentPanel.add(txtCantOp);
    }
    {
      btnAceptar = new JButton("Aceptar");
      btnAceptar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
      btnAceptar.setForeground(Color.WHITE);
      btnAceptar.setBackground(Color.decode("#03071E"));
      btnAceptar.setBorderPainted(false);
      btnAceptar.addActionListener(this);
      btnAceptar.setBounds(350, 15, 110, 30);
      contentPanel.add(btnAceptar);
    }
    {
      btnCancelar = new JButton("Cancelar");
      btnCancelar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
      btnCancelar.setForeground(Color.WHITE);
      btnCancelar.setBackground(Color.decode("#370617"));
      btnCancelar.setBorderPainted(false);
      btnCancelar.addActionListener(this);
      btnCancelar.setBounds(350, 57, 110, 30);
      contentPanel.add(btnCancelar);
    }
    setIconImage(new ImageIcon(getClass().getResource("/images/icono.png")).getImage());

    //Mostrar dato cantidad optima por defecto
    txtCantOp.setText(""+GuiMenuTienda.cantidadOptima);

    label = new JLabel("");
    label.addMouseListener(this);
    label.setIcon(new ImageIcon(GuiCantidadOptima.class.getResource("/images/editar.png")));
    label.setBounds(303, 30, 25, 25);
    contentPanel.add(label);
  }

  public void keyPressed(KeyEvent e) {
  }
  public void keyReleased(KeyEvent e) {
  }
  public void keyTyped(KeyEvent e) {
    if (e.getSource() == txtCantOp) {
      keyTypedTxtCantOp(e);
    }
  }
  protected void keyTypedTxtCantOp(KeyEvent e) {
    char c = e.getKeyChar();
    if(c<'0' || c>'9' ) e.consume();
  }
  
  public void mouseClicked(MouseEvent arg0) {
    if (arg0.getSource() == label) {
      mouseClickedLabel(arg0);
    }
  }
  
  public void mouseEntered(MouseEvent arg0) {
  }
  public void mouseExited(MouseEvent arg0) {
  }
  public void mousePressed(MouseEvent arg0) {
  }
  public void mouseReleased(MouseEvent arg0) {
  }
  protected void mouseClickedLabel(MouseEvent arg0) {
    editarCampo(txtCantOp);
  }

  public void actionPerformed(ActionEvent e) {
    if (e.getSource() == btnCancelar) {
      actionPerformedBtnCancelar(e);
    }
    if (e.getSource() == btnAceptar) {
      actionPerformedBtnAceptar(e);
    }
  }

  protected void actionPerformedBtnAceptar(ActionEvent e) {
    configurar(txtCantOp.getText(), "\\d+");
  }

  protected void actionPerformedBtnCancelar(ActionEvent e) {
    setVisible(false);
  }

  //METODOS

  //Metodo para aceptar configuracion
  void configurar(String cantOp, String exr){
    String s;
    if(validarCampos(cantOp, exr)){
      GuiMenuTienda.cantidadOptima=Integer.parseInt(cantOp); 
      s="Cambios guardados";
      JOptionPane.showMessageDialog(this, s, "MENSAJE DE INFORMACION", JOptionPane.INFORMATION_MESSAGE);
      setVisible(false);
    }
  }
  
  //Metodo para validar campos
  boolean validarCampos(String cantOP, String exr){
    String s;

    //Validando si tiene espacios vacíos
    if(cantOP.isEmpty()){
      s="Complete los campos vacíos";
      JOptionPane.showMessageDialog(this, s, "MENSAJE DE ERROR", JOptionPane.ERROR_MESSAGE);
      return false;

      //Validando si puede ser convertido a numero entero 
    }else if(!(cantOP.matches(exr))){
      s="Los datos ingresados no son válidos";
      JOptionPane.showMessageDialog(this, s, "MENSAJE DE ERROR", JOptionPane.ERROR_MESSAGE);
      return false;

      //Validando si el numero es extremadamente grande
    }else if(numGrande(cantOP)){
      s="La cantidad es extremadamente grande";
      JOptionPane.showMessageDialog(this, s, "MENSAJE DE ERROR", JOptionPane.ERROR_MESSAGE);
      return false;

    }else{
      return true;
    }
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
