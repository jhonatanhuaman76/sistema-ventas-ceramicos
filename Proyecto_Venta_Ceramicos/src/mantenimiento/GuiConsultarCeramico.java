package mantenimiento;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.formdev.flatlaf.FlatIntelliJLaf;
import com.formdev.flatlaf.FlatLightLaf;
import com.formdev.flatlaf.intellijthemes.FlatMonocaiIJTheme;
import com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatArcDarkContrastIJTheme;
import com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatMaterialDeepOceanIJTheme;
import com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatMaterialLighterIJTheme;
import com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatMaterialPalenightContrastIJTheme;
import com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatMonokaiProContrastIJTheme;
import com.formdev.flatlaf.ui.FlatCaret;

import menu.GuiMenuTienda;
import menu.GuiMenuTienda;

import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.UIManager;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Cursor;
import javax.swing.border.LineBorder;
import java.awt.Rectangle;

public class GuiConsultarCeramico extends JDialog implements ActionListener {

  private final JPanel contentPanel = new JPanel();
  private JLabel lblModelo;
  private JLabel lblPrecios;
  private JLabel lblAnchocm;
  private JLabel lblLargocm;
  private JLabel lblEspesormm;
  private JLabel lblContenido;
  private JComboBox cboMod;
  private JTextField txtPre;
  private JTextField txtAn;
  private JTextField txtL;
  private JTextField txtEs;
  private JTextField txtCont;
  private JButton btnCerrar;
  private JLabel lblStock;
  private JTextField txtStock;

  /**
   * Launch the application.
   */
  public static void main(String[] args) {
    try {
      GuiConsultarCeramico dialog = new GuiConsultarCeramico(null, true);
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
  public GuiConsultarCeramico(GuiMenuTienda menu, boolean b) {
    super(menu, b); //Bloquea la ventana hasta que la cierren
    setTitle("Consultar Cer\u00E1mico");
    setBounds(100, 100, 500, 338);
    setResizable(false);//Bloquea el cambiar de tamaño la ventana
    FlatMaterialLighterIJTheme.setup();
    UIManager.put( "Button.arc", 10);
    getContentPane().setLayout(new BorderLayout());
    contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
    getContentPane().add(contentPanel, BorderLayout.CENTER);
    contentPanel.setLayout(null);
    contentPanel.setBackground(Color.decode("#F8F9FA"));

    lblModelo = new JLabel("Modelo");
    lblModelo.setBounds(15, 20, 87, 14);
    contentPanel.add(lblModelo);

    lblPrecios = new JLabel("Precio (S/)");
    lblPrecios.setBounds(15, 60, 87, 14);
    contentPanel.add(lblPrecios);

    lblAnchocm = new JLabel("Ancho (cm)");
    lblAnchocm.setBounds(15, 100, 87, 14);
    contentPanel.add(lblAnchocm);

    lblLargocm = new JLabel("Largo (cm)");
    lblLargocm.setBounds(15, 140, 87, 14);
    contentPanel.add(lblLargocm);

    lblEspesormm = new JLabel("Espesor (mm)");
    lblEspesormm.setBounds(15, 180, 87, 14);
    contentPanel.add(lblEspesormm);

    lblContenido = new JLabel("Contenido");
    lblContenido.setBounds(15, 220, 87, 14);
    contentPanel.add(lblContenido);

    cboMod = new JComboBox();
    cboMod.setBorder(new LineBorder(new Color(171, 173, 179)));
    cboMod.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    cboMod.addActionListener(this);
    cboMod.setModel(new DefaultComboBoxModel(new String[] {GuiMenuTienda.modelo0, GuiMenuTienda.modelo1, GuiMenuTienda.modelo2, GuiMenuTienda.modelo3, GuiMenuTienda.modelo4}));
    cboMod.setBounds(112, 15, 196, 25);
    contentPanel.add(cboMod);

    txtPre = new JTextField();
    txtPre.setFocusable(false);
    txtPre.setEditable(false);
    txtPre.setBounds(112, 55, 196, 25);
    contentPanel.add(txtPre);
    txtPre.setColumns(10);

    txtAn = new JTextField();
    txtAn.setFocusable(false);
    txtAn.setEditable(false);
    txtAn.setColumns(10);
    txtAn.setBounds(112, 95, 196, 25);
    contentPanel.add(txtAn);

    txtL = new JTextField();
    txtL.setFocusable(false);
    txtL.setEditable(false);
    txtL.setColumns(10);
    txtL.setBounds(112, 135, 196, 25);
    contentPanel.add(txtL);

    txtEs = new JTextField();
    txtEs.setFocusable(false);
    txtEs.setEditable(false);
    txtEs.setColumns(10);
    txtEs.setBounds(112, 175, 196, 25);
    contentPanel.add(txtEs);

    txtCont = new JTextField();
    txtCont.setFocusable(false);
    txtCont.setEditable(false);
    txtCont.setColumns(10);
    txtCont.setBounds(112, 215, 196, 25);
    contentPanel.add(txtCont);

    btnCerrar = new JButton("Cerrar");
    btnCerrar.setForeground(Color.WHITE);
    btnCerrar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    btnCerrar.setBorderPainted(false);
    btnCerrar.addActionListener(this);
    btnCerrar.setBounds(362, 12, 110, 30);
    btnCerrar.setBackground(Color.decode("#370617"));
    contentPanel.add(btnCerrar);

    lblStock = new JLabel("Stock");
    lblStock.setBounds(15, 260, 87, 14);
    contentPanel.add(lblStock);

    txtStock = new JTextField();
    txtStock.setText("6");
    txtStock.setFocusable(false);
    txtStock.setEditable(false);
    txtStock.setColumns(10);
    txtStock.setBounds(112, 255, 196, 25);
    contentPanel.add(txtStock);

    setIconImage(new ImageIcon(getClass().getResource("/images/icono.png")).getImage());

    //Valores al iniciar la ventana
    mostrarDatos(GuiMenuTienda.precio0, GuiMenuTienda.ancho0, GuiMenuTienda.largo0, GuiMenuTienda.espesor0, GuiMenuTienda.contenido0, GuiMenuTienda.stock0);
  }

  public void actionPerformed(ActionEvent arg0) {
    if (arg0.getSource() == cboMod) {
      actionPerformedCboMod(arg0);
    }
    if (arg0.getSource() == btnCerrar) {
      actionPerformedBtnCerrar(arg0);
    }
  }

  protected void actionPerformedBtnCerrar(ActionEvent arg0) {
    dispose();
  }

  protected void actionPerformedCboMod(ActionEvent arg0) {
    selecccionarDatos(leerModelo());
  }

  //Metodo para leer el modelo
  int leerModelo(){
    return cboMod.getSelectedIndex();
  }

  //Metodo para seleccionar el contenido a mostrar en los casilleros
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
  void mostrarDatos (double pre, double an, double la, double esp, int co, int st) {
    txtPre.setText(""+pre);
    txtAn.setText(""+an);
    txtL.setText(""+la);
    txtEs.setText(""+esp);
    txtCont.setText(""+co);
    txtStock.setText(""+st);
  }
}
