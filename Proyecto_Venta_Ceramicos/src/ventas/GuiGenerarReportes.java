package ventas;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatArcDarkContrastIJTheme;
import com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatMaterialLighterIJTheme;

import menu.GuiMenuTienda;
import menu.GuiMenuTienda;

import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Cursor;

public class GuiGenerarReportes extends JDialog implements ActionListener {

  private final JPanel contentPanel = new JPanel();
  private JLabel lblTipoDeReporte;
  private JComboBox cboReporte;
  private JButton btnCerrar;
  private JPanel panel;

  /**
   * Launch the application.
   */
  public static void main(String[] args) {
    try {
      GuiGenerarReportes dialog = new GuiGenerarReportes(null, true);
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
  public GuiGenerarReportes(GuiMenuTienda menu, boolean b) {
    super(menu, b); //Bloquea la ventana hasta que la cierren
    setTitle("Generar Reporte");
    setBounds(100, 100, 1000, 539);
    setResizable(false);
    FlatMaterialLighterIJTheme.setup();
    UIManager.put( "Button.arc", 10);
    getContentPane().setLayout(new BorderLayout());
    contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
    getContentPane().add(contentPanel, BorderLayout.CENTER);
    contentPanel.setLayout(null);

    lblTipoDeReporte = new JLabel("Tipo de reporte");
    lblTipoDeReporte.setBounds(12, 24, 91, 16);
    contentPanel.add(lblTipoDeReporte);

    cboReporte = new JComboBox();
    cboReporte.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    cboReporte.setBorder(new LineBorder(new Color(171, 173, 179)));
    cboReporte.addActionListener(this);
    cboReporte.setModel(new DefaultComboBoxModel(new String[] {"Ventas por modelo", "Comparaci\u00F3n de precios con el precio promedio", "Comparaci\u00F3n de cajas vendidas con la cantidad \u00F3ptima", "Estad\u00EDstica sobre el precio"}));
    cboReporte.setBounds(106, 21, 736, 25);
    contentPanel.add(cboReporte);

    btnCerrar = new JButton("Cerrar");
    btnCerrar.setForeground(Color.WHITE);
    btnCerrar.setBackground(Color.decode("#370617"));
    btnCerrar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    btnCerrar.setBorderPainted(false);
    btnCerrar.addActionListener(this);
    btnCerrar.setBounds(864, 17, 110, 30);
    contentPanel.add(btnCerrar);

    panel = new PanelVentasxModelo();
    panel.setBounds(10, 69, 964, 420);
    contentPanel.add(panel);
    panel.setLayout(null);
    setIconImage(new ImageIcon(getClass().getResource("/images/icono.png")).getImage());
  }
  public void actionPerformed(ActionEvent arg0) {
    if (arg0.getSource() == btnCerrar) {
      actionPerformedBtnCerrar(arg0);
    }
    if (arg0.getSource() == cboReporte) {
      actionPerformedCboReporte(arg0);
    }
  }

  protected void actionPerformedBtnCerrar(ActionEvent arg0) {
    dispose();
  }

  protected void actionPerformedCboReporte(ActionEvent arg0) {	
    seleccionarReporte();
  }

  //METODOS

  //Metodo para seleccionar el tpo de reporte
  void seleccionarReporte(){
    switch(leerTipoReporte()){
    case 0: 
      PanelVentasxModelo p0 = new PanelVentasxModelo();
      nuevaTabla(p0);
      break;
    case 1: 
      PanelComparacionPrecios p1 = new PanelComparacionPrecios();
      nuevaTabla(p1);
      break;
    case 2: 
      PanelComparacionCajas p2 = new PanelComparacionCajas();
      nuevaTabla(p2);
      break;
    default: 
      PanelEstadisticas p3 = new PanelEstadisticas();
      nuevaTabla(p3);
    }
  }

  //Metodo para leer el indice de tipo reporte
  int leerTipoReporte(){
    return cboReporte.getSelectedIndex();
  }

  //cambiarTablas
  void nuevaTabla(JPanel tablaActual){
    panel.removeAll();
    panel.add(tablaActual);
    panel.repaint();
    panel.revalidate();
  }
}
