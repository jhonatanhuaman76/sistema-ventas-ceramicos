package menu;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

import com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatMaterialLighterIJTheme;

import mantenimiento.GuiConsultarCeramico;
import mantenimiento.GuiListarCeramicos;
import mantenimiento.GuiModificarCeramico;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JSeparator;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.awt.event.ActionEvent; 
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ImageIcon;
import java.awt.Cursor;

public class PanelMantenimiento extends JPanel implements ActionListener {
  private JPanel bg;
  private JPanel PanelSuperior;
  private JLabel lblArchivo;
  private JSeparator separator;
  private JLabel lblLeft;
  private JButton btnConsultar;
  private JButton btnListar;
  private JLabel lblRight;
  private JLabel lblFecha;
  private JLabel lblManual;
  private JButton btnModificar;
  private GuiMenuTienda menu;

  /**
   * Create the panel.
   */
  public PanelMantenimiento(GuiMenuTienda menu) {
    this.menu = menu;
    setBorder(null);
    setBounds(0, 0, 689, 546);
    UIManager.put( "Button.arc", 90);
    FlatMaterialLighterIJTheme.setup();

    bg = new JPanel();
    bg.setBackground(Color.WHITE);

    PanelSuperior = new JPanel();
    PanelSuperior.setBackground(new Color(213, 197, 220));

    lblArchivo = new JLabel("Mantenimiento");
    lblArchivo.setIcon(new ImageIcon(PanelMantenimiento.class.getResource("/images/iconManteniT.png")));
    lblArchivo.setForeground(new Color(43, 45, 66));
    lblArchivo.setFont(new Font("Tahoma", Font.BOLD, 36));

    separator = new JSeparator();
    separator.setForeground(Color.BLACK);
    separator.setBackground(Color.BLACK);

    lblLeft = new JLabel("");

    btnConsultar = new JButton();
    btnConsultar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    btnConsultar.setIcon(new ImageIcon(PanelMantenimiento.class.getResource("/images/iconConsultar.png")));
    btnConsultar.setText("<html><center>CONSULTAR<br>CER\u00C1MICO<html>");
    btnConsultar.addActionListener(this);
    btnConsultar.setVerticalTextPosition(SwingConstants.BOTTOM);
    btnConsultar.setIconTextGap(40);
    btnConsultar.setHorizontalTextPosition(SwingConstants.CENTER);
    btnConsultar.setFont(new Font("Tahoma", Font.BOLD, 24));
    btnConsultar.setBorderPainted(false);
    btnConsultar.setBackground(new Color(202, 240, 248));

    btnListar = new JButton();
    btnListar.addActionListener(this);
    btnListar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    btnListar.setIcon(new ImageIcon(PanelMantenimiento.class.getResource("/images/iconListar.png")));
    btnListar.setVerticalTextPosition(SwingConstants.BOTTOM);
    btnListar.setText("<html><center>LISTAR<br>CER\u00C1MICO<html>");
    btnListar.setIconTextGap(40);
    btnListar.setHorizontalTextPosition(SwingConstants.CENTER);
    btnListar.setFont(new Font("Tahoma", Font.BOLD, 24));
    btnListar.setBorderPainted(false);
    btnListar.setBackground(new Color(202, 240, 248));

    lblRight = new JLabel("");

    lblFecha = new JLabel("");
    lblFecha.setHorizontalAlignment(SwingConstants.RIGHT);
    lblFecha.setFont(new Font("Tahoma", Font.PLAIN, 14));

    lblManual = new JLabel("Ver manual de uso >");
    lblManual.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    lblManual.setHorizontalAlignment(SwingConstants.RIGHT);
    GroupLayout groupLayout = new GroupLayout(this);
    groupLayout.setHorizontalGroup(
        groupLayout.createParallelGroup(Alignment.LEADING)
        .addComponent(bg, GroupLayout.PREFERRED_SIZE, 676, Short.MAX_VALUE)
        );
    groupLayout.setVerticalGroup(
        groupLayout.createParallelGroup(Alignment.LEADING)
        .addComponent(bg, GroupLayout.DEFAULT_SIZE, 560, Short.MAX_VALUE)
        );

    btnModificar = new JButton();
    btnModificar.addActionListener(this);
    btnModificar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    btnModificar.setIcon(new ImageIcon(PanelMantenimiento.class.getResource("/images/iconModificar.png")));
    btnModificar.setVerticalTextPosition(SwingConstants.BOTTOM);
    btnModificar.setText("<html><center>MODIFICAR<br>CER\u00C1MICO<html>");
    btnModificar.setIconTextGap(40);
    btnModificar.setHorizontalTextPosition(SwingConstants.CENTER);
    btnModificar.setFont(new Font("Tahoma", Font.BOLD, 24));
    btnModificar.setBorderPainted(false);
    btnModificar.setBackground(new Color(202, 240, 248));
    GroupLayout gl_PanelSuperior = new GroupLayout(PanelSuperior);
    gl_PanelSuperior.setHorizontalGroup(
        gl_PanelSuperior.createParallelGroup(Alignment.LEADING)
        .addGroup(gl_PanelSuperior.createSequentialGroup()
            .addGap(24)
            .addComponent(lblArchivo)
            .addGap(18)
            .addComponent(separator, GroupLayout.DEFAULT_SIZE, 290, Short.MAX_VALUE)
            .addGap(25))
        );
    gl_PanelSuperior.setVerticalGroup(
        gl_PanelSuperior.createParallelGroup(Alignment.LEADING)
        .addComponent(lblArchivo, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)
        .addGroup(gl_PanelSuperior.createSequentialGroup()
            .addGap(37)
            .addComponent(separator, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        );
    PanelSuperior.setLayout(gl_PanelSuperior);
    GroupLayout gl_bg = new GroupLayout(bg);
    gl_bg.setHorizontalGroup(
        gl_bg.createParallelGroup(Alignment.LEADING)
        .addComponent(PanelSuperior, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addGroup(Alignment.TRAILING, gl_bg.createSequentialGroup()
            .addComponent(lblLeft, GroupLayout.DEFAULT_SIZE, 21, Short.MAX_VALUE)
            .addGap(4)
            .addComponent(btnConsultar, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
            .addGap(16)
            .addGroup(gl_bg.createParallelGroup(Alignment.LEADING)
                .addGroup(Alignment.TRAILING, gl_bg.createSequentialGroup()
                    .addGap(153)
                    .addComponent(lblFecha, GroupLayout.PREFERRED_SIZE, 273, GroupLayout.PREFERRED_SIZE)
                    .addGap(22))
                .addGroup(gl_bg.createSequentialGroup()
                    .addComponent(btnModificar, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
                    .addGap(17)
                    .addComponent(btnListar, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblRight, GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE))
                .addGroup(Alignment.TRAILING, gl_bg.createSequentialGroup()
                    .addGap(312)
                    .addComponent(lblManual, GroupLayout.PREFERRED_SIZE, 112, GroupLayout.PREFERRED_SIZE)
                    .addGap(24))))
        );
    gl_bg.setVerticalGroup(
        gl_bg.createParallelGroup(Alignment.LEADING)
        .addGroup(gl_bg.createSequentialGroup()
            .addComponent(PanelSuperior, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
            .addGap(6)
            .addGroup(gl_bg.createParallelGroup(Alignment.LEADING)
                .addComponent(lblLeft, GroupLayout.DEFAULT_SIZE, 472, Short.MAX_VALUE)
                .addGroup(gl_bg.createSequentialGroup()
                    .addGap(120)
                    .addComponent(btnConsultar, GroupLayout.PREFERRED_SIZE, 265, GroupLayout.PREFERRED_SIZE))
                .addGroup(gl_bg.createSequentialGroup()
                    .addGap(5)
                    .addComponent(lblFecha, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
                    .addGap(79)
                    .addGroup(gl_bg.createParallelGroup(Alignment.LEADING)
                        .addComponent(btnModificar, GroupLayout.PREFERRED_SIZE, 265, GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnListar, GroupLayout.PREFERRED_SIZE, 265, GroupLayout.PREFERRED_SIZE)
                        .addGroup(gl_bg.createSequentialGroup()
                            .addGap(2)
                            .addComponent(lblRight, GroupLayout.DEFAULT_SIZE, 265, Short.MAX_VALUE)))
                    .addGap(45)
                    .addComponent(lblManual, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))))
        );
    bg.setLayout(gl_bg);
    setLayout(groupLayout);

    setDate();
  }


  public void actionPerformed(ActionEvent arg0) {
    if (arg0.getSource() == btnListar) {
      actionPerformedBtnListar(arg0);
    }
    if (arg0.getSource() == btnModificar) {
      actionPerformedBtnModificar(arg0);
    }
    if (arg0.getSource() == btnConsultar) {
      actionPerformedBtnConsultar(arg0);
    }
  }
  protected void actionPerformedBtnConsultar(ActionEvent arg0) {
    GuiConsultarCeramico gcc = new GuiConsultarCeramico(menu, true);
    gcc.setLocationRelativeTo(this);
    gcc.setVisible(true);
  }
  protected void actionPerformedBtnModificar(ActionEvent arg0) {
    GuiModificarCeramico gcc = new GuiModificarCeramico(menu, true);
    gcc.setLocationRelativeTo(this);
    gcc.setVisible(true);
  }

  protected void actionPerformedBtnListar(ActionEvent arg0) {
    GuiListarCeramicos gcc = new GuiListarCeramicos(menu, true);
    gcc.setLocationRelativeTo(this);
    gcc.setVisible(true);
  }

  void setDate(){
    LocalDate now = LocalDate.now();
    Locale spanishLocale = new Locale("es", "ES");

    lblFecha.setText(now.format(DateTimeFormatter.ofPattern("'Hoy es' EEEE dd 'de' MMMM 'de' yyyy", spanishLocale)));
  }
}
