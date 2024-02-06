package menu;

import javax.swing.JPanel;
import javax.swing.UIManager;

import com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatMaterialLighterIJTheme;

import configuracion.GuiCantidadOptima;
import configuracion.GuiConfigurarCuotaDiaria;
import configuracion.GuiConfigurarDescuentos;
import configuracion.GuiConfigurarObsequios;

import java.awt.Color;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JSeparator;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.awt.event.ActionEvent;
import java.awt.Cursor;

public class PanelConfiguracion extends JPanel implements ActionListener {
  private JPanel bg;
  private JPanel PanelSuperior;
  private JLabel lblConfiguracin;
  private JSeparator separator;
  private JLabel lblLeft;
  private JButton btnDescuento;
  private JLabel lblRight;
  private JLabel lblFecha;
  private JLabel lblManual;
  private JButton btnCantidad;
  private JButton btnObsequios;
  private JButton btnCuota;
  private GuiMenuTienda menu;

  /**
   * Create the panel.
   */
  public PanelConfiguracion(GuiMenuTienda menu) {
    this.menu = menu;
    setBorder(null);
    setBounds(0, 0, 689, 546);
    UIManager.put( "Button.arc", 90);
    FlatMaterialLighterIJTheme.setup();

    bg = new JPanel();
    bg.setBackground(Color.WHITE);

    PanelSuperior = new JPanel();
    PanelSuperior.setBackground(new Color(213, 197, 220));

    lblConfiguracin = new JLabel("Configuraci\u00F3n");
    lblConfiguracin.setIcon(new ImageIcon(PanelConfiguracion.class.getResource("/images/iconConfiT.png")));
    lblConfiguracin.setForeground(new Color(43, 45, 66));
    lblConfiguracin.setFont(new Font("Tahoma", Font.BOLD, 36));

    separator = new JSeparator();
    separator.setForeground(Color.BLACK);
    separator.setBackground(Color.BLACK);

    lblLeft = new JLabel("");

    btnDescuento = new JButton();
    btnDescuento.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    btnDescuento.setIcon(new ImageIcon(PanelConfiguracion.class.getResource("/images/iconDescuento.png")));
    btnDescuento.addActionListener(this);
    btnDescuento.setVerticalTextPosition(SwingConstants.BOTTOM);
    btnDescuento.setText("<html><center>CONFIGURAR<br>DESCUENTOS<html>");
    btnDescuento.setIconTextGap(20);
    btnDescuento.setHorizontalTextPosition(SwingConstants.CENTER);
    btnDescuento.setFont(new Font("Tahoma", Font.BOLD, 18));
    btnDescuento.setBorderPainted(false);
    btnDescuento.setBackground(new Color(202, 240, 248));

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
        .addComponent(bg, GroupLayout.DEFAULT_SIZE, 689, Short.MAX_VALUE)
        );
    groupLayout.setVerticalGroup(
        groupLayout.createParallelGroup(Alignment.LEADING)
        .addComponent(bg, GroupLayout.DEFAULT_SIZE, 546, Short.MAX_VALUE)
        );

    btnCantidad = new JButton();
    btnCantidad.addActionListener(this);
    btnCantidad.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    btnCantidad.setIcon(new ImageIcon(PanelConfiguracion.class.getResource("/images/iconCantidad.png")));
    btnCantidad.setVerticalTextPosition(SwingConstants.BOTTOM);
    btnCantidad.setText("<html><center>CONFIGURAR<br>CANTIDAD<br>\u00D3PTIMA<html>");
    btnCantidad.setIconTextGap(20);
    btnCantidad.setHorizontalTextPosition(SwingConstants.CENTER);
    btnCantidad.setFont(new Font("Tahoma", Font.BOLD, 18));
    btnCantidad.setBorderPainted(false);
    btnCantidad.setBackground(new Color(202, 240, 248));

    btnObsequios = new JButton();
    btnObsequios.addActionListener(this);
    btnObsequios.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    btnObsequios.setIcon(new ImageIcon(PanelConfiguracion.class.getResource("/images/iconObsequios.png")));
    btnObsequios.setVerticalTextPosition(SwingConstants.BOTTOM);
    btnObsequios.setText("<html><center>CONFIGURAR<br>OBSEQUIOS<html>");
    btnObsequios.setIconTextGap(20);
    btnObsequios.setHorizontalTextPosition(SwingConstants.CENTER);
    btnObsequios.setFont(new Font("Tahoma", Font.BOLD, 18));
    btnObsequios.setBorderPainted(false);
    btnObsequios.setBackground(new Color(202, 240, 248));

    btnCuota = new JButton();
    btnCuota.addActionListener(this);
    btnCuota.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    btnCuota.setIcon(new ImageIcon(PanelConfiguracion.class.getResource("/images/iconCuota.png")));
    btnCuota.setVerticalTextPosition(SwingConstants.BOTTOM);
    btnCuota.setText("<html><center>CONFIGURAR<br>CUOTA<br>DIARIA<html>");
    btnCuota.setIconTextGap(20);
    btnCuota.setHorizontalTextPosition(SwingConstants.CENTER);
    btnCuota.setFont(new Font("Tahoma", Font.BOLD, 18));
    btnCuota.setBorderPainted(false);
    btnCuota.setBackground(new Color(202, 240, 248));
    GroupLayout gl_PanelSuperior = new GroupLayout(PanelSuperior);
    gl_PanelSuperior.setHorizontalGroup(
        gl_PanelSuperior.createParallelGroup(Alignment.LEADING)
        .addGroup(gl_PanelSuperior.createSequentialGroup()
            .addGap(24)
            .addComponent(lblConfiguracin)
            .addGap(18)
            .addComponent(separator, GroupLayout.DEFAULT_SIZE, 309, Short.MAX_VALUE)
            .addGap(26))
        );
    gl_PanelSuperior.setVerticalGroup(
        gl_PanelSuperior.createParallelGroup(Alignment.LEADING)
        .addComponent(lblConfiguracin, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)
        .addGroup(gl_PanelSuperior.createSequentialGroup()
            .addGap(37)
            .addComponent(separator, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        );
    PanelSuperior.setLayout(gl_PanelSuperior);
    GroupLayout gl_bg = new GroupLayout(bg);
    gl_bg.setHorizontalGroup(
        gl_bg.createParallelGroup(Alignment.LEADING)
        .addComponent(PanelSuperior, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addGroup(gl_bg.createSequentialGroup()
            .addComponent(lblLeft, GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
            .addGap(34)
            .addGroup(gl_bg.createParallelGroup(Alignment.LEADING)
                .addGroup(Alignment.TRAILING, gl_bg.createSequentialGroup()
                    .addGap(285)
                    .addComponent(lblFecha, GroupLayout.PREFERRED_SIZE, 273, GroupLayout.PREFERRED_SIZE)
                    .addGap(22))
                .addGroup(gl_bg.createSequentialGroup()
                    .addGroup(gl_bg.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_bg.createSequentialGroup()
                            .addComponent(btnDescuento, GroupLayout.PREFERRED_SIZE, 197, GroupLayout.PREFERRED_SIZE)
                            .addGap(44)
                            .addComponent(btnObsequios, GroupLayout.PREFERRED_SIZE, 197, GroupLayout.PREFERRED_SIZE))
                        .addGroup(gl_bg.createSequentialGroup()
                            .addComponent(btnCantidad, GroupLayout.PREFERRED_SIZE, 197, GroupLayout.PREFERRED_SIZE)
                            .addGap(44)
                            .addComponent(btnCuota, GroupLayout.PREFERRED_SIZE, 197, GroupLayout.PREFERRED_SIZE)))
                    .addGap(68)
                    .addComponent(lblRight, GroupLayout.DEFAULT_SIZE, 74, Short.MAX_VALUE))
                .addGroup(Alignment.TRAILING, gl_bg.createSequentialGroup()
                    .addComponent(lblManual, GroupLayout.PREFERRED_SIZE, 112, GroupLayout.PREFERRED_SIZE)
                    .addGap(24))))
        );
    gl_bg.setVerticalGroup(
        gl_bg.createParallelGroup(Alignment.LEADING)
        .addGroup(gl_bg.createSequentialGroup()
            .addComponent(PanelSuperior, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
            .addGap(6)
            .addGroup(gl_bg.createParallelGroup(Alignment.LEADING)
                .addGroup(gl_bg.createSequentialGroup()
                    .addComponent(lblLeft, GroupLayout.DEFAULT_SIZE, 461, Short.MAX_VALUE)
                    .addGap(11))
                .addGroup(gl_bg.createSequentialGroup()
                    .addGap(5)
                    .addComponent(lblFecha, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
                    .addGap(7)
                    .addGroup(gl_bg.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_bg.createSequentialGroup()
                            .addGroup(gl_bg.createParallelGroup(Alignment.LEADING)
                                .addComponent(btnDescuento, GroupLayout.DEFAULT_SIZE, 183, Short.MAX_VALUE)
                                .addComponent(btnObsequios, GroupLayout.DEFAULT_SIZE, 183, Short.MAX_VALUE))
                            .addGap(14)
                            .addGroup(gl_bg.createParallelGroup(Alignment.LEADING)
                                .addComponent(btnCantidad, GroupLayout.DEFAULT_SIZE, 183, Short.MAX_VALUE)
                                .addComponent(btnCuota, GroupLayout.DEFAULT_SIZE, 183, Short.MAX_VALUE)))
                        .addGroup(gl_bg.createSequentialGroup()
                            .addGap(7)
                            .addComponent(lblRight, GroupLayout.DEFAULT_SIZE, 373, Short.MAX_VALUE)))
                    .addGap(4)
                    .addComponent(lblManual, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))))
        );
    bg.setLayout(gl_bg);
    setLayout(groupLayout);	

    setDate();
  }

  public void actionPerformed(ActionEvent e) {
    if (e.getSource() == btnCuota) {
      actionPerformedBtnCuota(e);
    }
    if (e.getSource() == btnCantidad) {
      actionPerformedBtnCantidad(e);
    }
    if (e.getSource() == btnObsequios) {
      actionPerformedBtnObsequios(e);
    }
    if (e.getSource() == btnDescuento) {
      actionPerformedBtnDescuento(e);
    }

    setDate();
  }
  protected void actionPerformedBtnDescuento(ActionEvent e) {
    GuiConfigurarDescuentos gcc = new GuiConfigurarDescuentos(menu, true);
    gcc.setLocationRelativeTo(this);
    gcc.setVisible(true);
  }
  protected void actionPerformedBtnObsequios(ActionEvent e) {
    GuiConfigurarObsequios gcc = new GuiConfigurarObsequios(menu, true);
    gcc.setLocationRelativeTo(this);
    gcc.setVisible(true);
  }
  protected void actionPerformedBtnCantidad(ActionEvent e) {
    GuiCantidadOptima gcc = new GuiCantidadOptima(menu, true);
    gcc.setLocationRelativeTo(this);
    gcc.setVisible(true);
  }
  protected void actionPerformedBtnCuota(ActionEvent e) {
    GuiConfigurarCuotaDiaria gcc = new GuiConfigurarCuotaDiaria(menu, true);
    gcc.setLocationRelativeTo(this);
    gcc.setVisible(true);
  }
  void setDate(){
    LocalDate now = LocalDate.now();
    Locale spanishLocale = new Locale("es", "ES");

    lblFecha.setText(now.format(DateTimeFormatter.ofPattern("'Hoy es' EEEE dd 'de' MMMM 'de' yyyy", spanishLocale)));
  }
}
