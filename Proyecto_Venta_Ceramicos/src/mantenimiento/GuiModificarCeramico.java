package mantenimiento;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatArcDarkContrastIJTheme;
import com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatMaterialDeepOceanIJTheme;
import com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatMaterialLighterIJTheme;

import menu.GuiMenuTienda;
import menu.GuiMenuTienda;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.UIManager;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;

import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.Color;
import javax.swing.border.LineBorder;
import java.awt.Cursor;
import javax.swing.border.MatteBorder;

public class GuiModificarCeramico extends JDialog implements ActionListener, KeyListener {

  private final JPanel contentPanel = new JPanel();
  private JTextField txtPre;
  private JTextField txtAn;
  private JTextField txtL;
  private JTextField txtEs;
  private JTextField txtCont;
  private JButton btnCerrar;
  private JButton btnGrabar;
  private JComboBox cboMod;
  private JLabel lblStock;
  private JTextField txtStock;

  /**
   * Launch the application.
   */
  public static void main(String[] args) {
    try {
      GuiModificarCeramico dialog = new GuiModificarCeramico(null, true);
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
  public GuiModificarCeramico(GuiMenuTienda menu, boolean b) {
    super(menu, b); //Bloquea la ventana hasta que la cierren
    setTitle("Modificar Cer\u00E1mico");
    setBounds(100, 100, 500, 338);
    setResizable(false);
    UIManager.put("Component.focusColor", Color.decode("#9499B4"));
    UIManager.put( "Button.arc", 10);
    FlatMaterialLighterIJTheme.setup();
    getContentPane().setLayout(new BorderLayout());
    contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
    getContentPane().add(contentPanel, BorderLayout.CENTER);
    contentPanel.setLayout(null);
    {
      JLabel lblModelo = new JLabel("Modelo");
      lblModelo.setBounds(15, 20, 87, 14);
      contentPanel.add(lblModelo);
    }
    {
      JLabel lblPrecios = new JLabel("Precio (S/)");
      lblPrecios.setBounds(15, 60, 87, 14);
      contentPanel.add(lblPrecios);
    }
    {
      JLabel lblAnchocm = new JLabel("Ancho (cm)");
      lblAnchocm.setBounds(15, 100, 87, 14);
      contentPanel.add(lblAnchocm);
    }
    {
      JLabel lblLargocm = new JLabel("Largo (cm)");
      lblLargocm.setBounds(15, 140, 87, 14);
      contentPanel.add(lblLargocm);
    }
    {
      JLabel lblEspesormm = new JLabel("Espesor (mm)");
      lblEspesormm.setBounds(15, 180, 87, 14);
      contentPanel.add(lblEspesormm);
    }
    {
      JLabel lblContenido = new JLabel("Contenido");
      lblContenido.setBounds(15, 220, 87, 14);
      contentPanel.add(lblContenido);
    }
    {
      cboMod = new JComboBox();
      cboMod.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
      cboMod.setBorder(new LineBorder(new Color(171, 173, 179)));
      cboMod.setModel(new DefaultComboBoxModel(new String[] {GuiMenuTienda.modelo0, GuiMenuTienda.modelo1, GuiMenuTienda.modelo2, GuiMenuTienda.modelo3, GuiMenuTienda.modelo4}));
      cboMod.addActionListener(this);
      cboMod.setBounds(112, 15, 196, 25);
      contentPanel.add(cboMod);
    }
    {
      txtPre = new JTextField();
      txtPre.setBackground(Color.WHITE);
      txtPre.addKeyListener(this);
      txtPre.setColumns(10);
      txtPre.setBounds(112, 55, 196, 25);
      contentPanel.add(txtPre);
    }
    {
      txtAn = new JTextField();
      txtAn.setBackground(Color.WHITE);
      txtAn.addKeyListener(this);
      txtAn.setColumns(10);
      txtAn.setBounds(112, 95, 196, 25);
      contentPanel.add(txtAn);
    }
    {
      txtL = new JTextField();
      txtL.setBackground(Color.WHITE);
      txtL.addKeyListener(this);
      txtL.setColumns(10);
      txtL.setBounds(112, 135, 196, 25);
      contentPanel.add(txtL);
    }
    {
      txtEs = new JTextField();
      txtEs.setBackground(Color.WHITE);
      txtEs.addKeyListener(this);
      txtEs.setColumns(10);
      txtEs.setBounds(112, 175, 196, 25);
      contentPanel.add(txtEs);
    }
    {
      txtCont = new JTextField();
      txtCont.setBackground(Color.WHITE);
      txtCont.addKeyListener(this);
      txtCont.setColumns(10);
      txtCont.setBounds(112, 215, 196, 25);
      contentPanel.add(txtCont);
    }
    {
      btnCerrar = new JButton("Cerrar");
      btnCerrar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
      btnCerrar.setForeground(Color.WHITE);
      btnCerrar.setBackground(Color.decode("#370617"));
      btnCerrar.setBorderPainted(false);
      btnCerrar.addActionListener(this);
      btnCerrar.setBounds(362, 52, 110, 30);
      contentPanel.add(btnCerrar);
    }
    {
      btnGrabar = new JButton("Grabar");
      btnGrabar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
      btnGrabar.setForeground(Color.WHITE);
      btnGrabar.setBackground(Color.decode("#03071E"));
      btnGrabar.setBorderPainted(false);
      btnGrabar.addActionListener(this);
      btnGrabar.setBounds(362, 12, 110, 30);
      contentPanel.add(btnGrabar);
    }
    {
      lblStock = new JLabel("Stock");
      lblStock.setBounds(15, 260, 87, 14);
      contentPanel.add(lblStock);
    }
    {
      txtStock = new JTextField();
      txtStock.setBackground(Color.WHITE);
      txtStock.setText("6");
      txtStock.setColumns(10);
      txtStock.setBounds(112, 255, 196, 25);
      contentPanel.add(txtStock);
    }

    setIconImage(new ImageIcon(getClass().getResource("/images/icono.png")).getImage());

    //Datos mostrados al iniciar la ventana
    mostrarDatos(GuiMenuTienda.precio0, GuiMenuTienda.ancho0, GuiMenuTienda.largo0, GuiMenuTienda.espesor0, GuiMenuTienda.contenido0, GuiMenuTienda.stock0);
  }

  public void actionPerformed(ActionEvent e) {
    if (e.getSource() == cboMod) {
      actionPerformedCboMod(e);
    }
    if (e.getSource() == btnGrabar) {
      actionPerformedBtnGrabar(e);
    }
    if (e.getSource() == btnCerrar) {
      actionPerformedBtnCerrar(e);
    }
  }

  public void keyPressed(KeyEvent e) {
  }
  public void keyReleased(KeyEvent e) {
  }
  public void keyTyped(KeyEvent e) {
    if (e.getSource() == txtEs) {
      keyTypedTxtEs(e);
    }
    if (e.getSource() == txtL) {
      keyTypedTxtL(e);
    }
    if (e.getSource() == txtAn) {
      keyTypedTxtAn(e);
    }
    if (e.getSource() == txtCont) {
      keyTypedTxtCont(e);
    }
    if (e.getSource() == txtPre) {
      keyTypedTxtPre(e);
    }
  }
  protected void keyTypedTxtPre(KeyEvent e) {
    char c = e.getKeyChar();
    if((c<'0' || c>'9') && c!='.') e.consume();
  }

  protected void keyTypedTxtCont(KeyEvent e) {
    char c = e.getKeyChar();
    if(c<'0' || c>'9' ) e.consume();
  }


  protected void keyTypedTxtAn(KeyEvent e) {
    char c = e.getKeyChar();
    if((c<'0' || c>'9') && c!='.') e.consume();
  }


  protected void keyTypedTxtL(KeyEvent e) {
    char c = e.getKeyChar();
    if((c<'0' || c>'9') && c!='.') e.consume();
  }


  protected void keyTypedTxtEs(KeyEvent e) {
    char c = e.getKeyChar();
    if((c<'0' || c>'9') && c!='.') e.consume();
  }

  //Accion boton cerrar
  protected void actionPerformedBtnCerrar(ActionEvent e) {
    setVisible(false);
  }

  //Accion boton grabar
  protected void actionPerformedBtnGrabar(ActionEvent e) {
    grabar(txtPre.getText(), txtAn.getText(), txtL.getText(), txtEs.getText(), txtCont.getText(), txtStock.getText(), "\\d+(\\.\\d+)?");
  }

  //Accion cboModelo
  protected void actionPerformedCboMod(ActionEvent e) {
    selecccionarDatos(leerModelo());
  }


  //METODOS

  //Metodo para grabar cambios
  void grabar(String pre, String  an, String l, String es, String cont, String st, String exr){	
    //Validando si tiene campos vacíos
    if(pre.isEmpty() || an.isEmpty() || l.isEmpty() || es.isEmpty() || cont.isEmpty() || st.isEmpty()){
      JOptionPane.showMessageDialog(this, "Complete los campos vacíos", "MENSAJE DE ERROR", JOptionPane.ERROR_MESSAGE);
    } //Validando si puede ser convertido a numero positivo
    else if(pre.matches(exr) && an.matches(exr) && l.matches(exr) && es.matches(exr) && cont.matches(exr)&& st.matches(exr)){
      
    if(validarNumGrande(cont)&&validarNumGrande(st)){
      double nuePre, nueAn, nueL, nueEs;
      int nueCont, nueSt;

      nuePre=Double.parseDouble(pre);
      nueAn=Double.parseDouble(an);
      nueL= Double.parseDouble(l);
      nueEs=Double.parseDouble(es);
      nueCont=Integer.parseInt(cont);
      nueSt=Integer.parseInt(st);

      modificarDatos(nuePre, nueAn, nueL, nueEs, nueCont, nueSt);
    }
    
    } else {
      JOptionPane.showMessageDialog(this, "Los datos ingresados no son válidos", "MENSAJE DE ERROR", JOptionPane.ERROR_MESSAGE);
    }
  }
  
  //Metodo para validar si el numero es extremadamente grande
  boolean validarNumGrande(String num){
    if(Double.parseDouble(num) > 2147483647 ){
      JOptionPane.showMessageDialog(this, "La cantidad es extremadamente grande", "MENSAJE DE ERROR", JOptionPane.ERROR_MESSAGE);
      return false;
    }else{
      return true;
    }
  }

  //Metodo para seleccionar datos a modificar
  void modificarDatos(double nuePre, double nueAn, double nueL, double nueEs, int nueCont, int nueSt){
    switch(leerModelo()){
    case 0:
      GuiMenuTienda.precio0 = nuePre;
      GuiMenuTienda.ancho0 = nueAn;
      GuiMenuTienda.largo0 = nueL;
      GuiMenuTienda.espesor0 = nueEs;
      GuiMenuTienda.contenido0 = nueCont;
      GuiMenuTienda.stock0 = nueSt;
      break;
    case 1:
      GuiMenuTienda.precio1 = nuePre;
      GuiMenuTienda.ancho1 = nueAn;
      GuiMenuTienda.largo1 = nueL;
      GuiMenuTienda.espesor1 = nueEs;
      GuiMenuTienda.contenido1 = nueCont;
      GuiMenuTienda.stock1 = nueSt;
      break;
    case 2:
      GuiMenuTienda.precio2 = nuePre;
      GuiMenuTienda.ancho2 = nueAn;
      GuiMenuTienda.largo2 = nueL;
      GuiMenuTienda.espesor2 = nueEs;
      GuiMenuTienda.contenido2 = nueCont;
      GuiMenuTienda.stock2 = nueSt;
      break;
    case 3:
      GuiMenuTienda.precio3 = nuePre;
      GuiMenuTienda.ancho3 = nueAn;
      GuiMenuTienda.largo3 = nueL;
      GuiMenuTienda.espesor3 = nueEs;
      GuiMenuTienda.contenido3 = nueCont;
      GuiMenuTienda.stock3 = nueSt;
      break;
    default:
      GuiMenuTienda.precio4 = nuePre;
      GuiMenuTienda.ancho4 = nueAn;
      GuiMenuTienda.largo4 = nueL;
      GuiMenuTienda.espesor4 = nueEs;
      GuiMenuTienda.contenido4 = nueCont;
      GuiMenuTienda.stock4 = nueSt;
    }

    JOptionPane.showMessageDialog(this, "Los datos han sido modificados");
    setVisible(false);
  }

  //Metodo para leer el modelo
  int leerModelo(){
    return cboMod.getSelectedIndex();
  }

  //Metodo para seleccionar los datos a mostrar en los casilleros
  void selecccionarDatos(int mod){
    switch(mod){
    case 0: mostrarDatos(GuiMenuTienda.precio0, GuiMenuTienda.ancho0, GuiMenuTienda.largo0, GuiMenuTienda.espesor0, GuiMenuTienda.contenido0, GuiMenuTienda.stock0);break;
    case 1: mostrarDatos(GuiMenuTienda.precio1, GuiMenuTienda.ancho1, GuiMenuTienda.largo1, GuiMenuTienda.espesor1, GuiMenuTienda.contenido1, GuiMenuTienda.stock1);break;
    case 2: mostrarDatos(GuiMenuTienda.precio2, GuiMenuTienda.ancho2, GuiMenuTienda.largo2, GuiMenuTienda.espesor2, GuiMenuTienda.contenido2, GuiMenuTienda.stock2);break;
    case 3: mostrarDatos(GuiMenuTienda.precio3, GuiMenuTienda.ancho3, GuiMenuTienda.largo3, GuiMenuTienda.espesor3, GuiMenuTienda.contenido3, GuiMenuTienda.stock3);break;
    default: mostrarDatos(GuiMenuTienda.precio4, GuiMenuTienda.ancho4, GuiMenuTienda.largo4, GuiMenuTienda.espesor4, GuiMenuTienda.contenido4, GuiMenuTienda.stock4);
    }
  }

  //Metodo para mostrar contenido
  void mostrarDatos(double pre, double an, double la, double esp, int co, int st) {
    txtPre.setText(""+pre);
    txtAn.setText(""+an);
    txtL.setText(""+la);
    txtEs.setText(""+esp);
    txtCont.setText(""+co);
    txtStock.setText(""+st);
  }
}
