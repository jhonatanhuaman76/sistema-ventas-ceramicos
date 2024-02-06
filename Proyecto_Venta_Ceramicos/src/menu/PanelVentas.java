package menu;

import javax.swing.JPanel;
import javax.swing.UIManager;

import com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatMaterialLighterIJTheme;

import ventas.GuiGenerarReportes;
import ventas.GuiVender;

import java.awt.Color;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JSeparator;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.Cursor;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.awt.event.ActionEvent;

public class PanelVentas extends JPanel implements ActionListener {
  private JPanel bg;
  private JPanel PanelSuperior;
  private JLabel lblVentas;
  private JSeparator separator;
  private JLabel lblLeft;
  private JButton btnVender;
  private JButton btnReportes;
  private JLabel lblRight;
  private JLabel lblFecha;
  private JLabel lblManual;
  private GuiMenuTienda menu;

  /**
   * Create the panel.
   */
  public PanelVentas(GuiMenuTienda menu) {
    this.menu = menu;
    setBorder(null);
    setBounds(0, 0, 689, 546);
    UIManager.put( "Button.arc", 90);
    FlatMaterialLighterIJTheme.setup();

    bg = new JPanel();
    bg.setBackground(Color.WHITE);

    PanelSuperior = new JPanel();
    PanelSuperior.setBackground(new Color(213, 197, 220));

    lblVentas = new JLabel("Ventas");
    lblVentas.setIcon(new ImageIcon(PanelVentas.class.getResource("/images/iconVentasT.png")));
    lblVentas.setForeground(new Color(43, 45, 66));
    lblVentas.setFont(new Font("Tahoma", Font.BOLD, 36));

    separator = new JSeparator();
    separator.setForeground(Color.BLACK);
    separator.setBackground(Color.BLACK);

    lblLeft = new JLabel("");

    btnVender = new JButton();
    btnVender.addActionListener(this);
    btnVender.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    btnVender.setIcon(new ImageIcon(PanelVentas.class.getResource("/images/iconVender.png")));
    btnVender.setVerticalTextPosition(SwingConstants.BOTTOM);
    btnVender.setText("<html><center>VENDER<html>");
    btnVender.setIconTextGap(40);
    btnVender.setHorizontalTextPosition(SwingConstants.CENTER);
    btnVender.setFont(new Font("Tahoma", Font.BOLD, 24));
    btnVender.setBorderPainted(false);
    btnVender.setBackground(new Color(202, 240, 248));

    btnReportes = new JButton();
    btnReportes.addActionListener(this);
    btnReportes.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    btnReportes.setIcon(new ImageIcon(PanelVentas.class.getResource("/images/iconReporte.png")));
    btnReportes.setVerticalTextPosition(SwingConstants.BOTTOM);
    btnReportes.setText("<html><center>GENERAR<br>REPORTES<html>");
    btnReportes.setIconTextGap(40);
    btnReportes.setHorizontalTextPosition(SwingConstants.CENTER);
    btnReportes.setFont(new Font("Tahoma", Font.BOLD, 24));
    btnReportes.setBorderPainted(false);
    btnReportes.setBackground(new Color(202, 240, 248));

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
        .addComponent(bg, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    groupLayout.setVerticalGroup(
        groupLayout.createParallelGroup(Alignment.LEADING)
        .addComponent(bg, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    GroupLayout gl_PanelSuperior = new GroupLayout(PanelSuperior);
    gl_PanelSuperior.setHorizontalGroup(
        gl_PanelSuperior.createParallelGroup(Alignment.LEADING)
        .addGroup(gl_PanelSuperior.createSequentialGroup()
            .addGap(24)
            .addComponent(lblVentas)
            .addGap(18)
            .addComponent(separator, GroupLayout.DEFAULT_SIZE, 438, Short.MAX_VALUE)
            .addGap(26))
        );
    gl_PanelSuperior.setVerticalGroup(
        gl_PanelSuperior.createParallelGroup(Alignment.LEADING)
        .addComponent(lblVentas, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)
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
            .addComponent(lblLeft, GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
            .addGap(10)
            .addComponent(btnVender, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
            .addGap(109)
            .addGroup(gl_bg.createParallelGroup(Alignment.LEADING)
                .addGroup(Alignment.TRAILING, gl_bg.createSequentialGroup()
                    .addComponent(lblFecha, GroupLayout.PREFERRED_SIZE, 273, GroupLayout.PREFERRED_SIZE)
                    .addGap(22))
                .addGroup(gl_bg.createSequentialGroup()
                    .addGap(6)
                    .addComponent(btnReportes, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
                    .addGap(15)
                    .addComponent(lblRight, GroupLayout.DEFAULT_SIZE, 74, Short.MAX_VALUE))
                .addGroup(Alignment.TRAILING, gl_bg.createSequentialGroup()
                    .addGap(159)
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
                    .addComponent(btnVender, GroupLayout.PREFERRED_SIZE, 265, GroupLayout.PREFERRED_SIZE))
                .addGroup(gl_bg.createSequentialGroup()
                    .addGap(5)
                    .addComponent(lblFecha, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
                    .addGap(14)
                    .addGroup(gl_bg.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_bg.createSequentialGroup()
                            .addGap(65)
                            .addComponent(btnReportes, GroupLayout.PREFERRED_SIZE, 265, GroupLayout.PREFERRED_SIZE))
                        .addComponent(lblRight, GroupLayout.DEFAULT_SIZE, 357, Short.MAX_VALUE))
                    .addGap(20)
                    .addComponent(lblManual, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))))
        );
    bg.setLayout(gl_bg);
    setLayout(groupLayout);
    UIManager.put( "Button.arc", 90);
    FlatMaterialLighterIJTheme.setup();

    setDate();
  }

  public void actionPerformed(ActionEvent e) {
    if (e.getSource() == btnReportes) {
      actionPerformedBtnReportes(e);
    }
    if (e.getSource() == btnVender) {
      actionPerformedBtnVender(e);
    }
  }
  protected void actionPerformedBtnVender(ActionEvent e) {
    GuiVender gcc = new GuiVender(menu, true);
    gcc.setLocationRelativeTo(this);
    gcc.setVisible(true);
  }
  protected void actionPerformedBtnReportes(ActionEvent e) {
    GuiGenerarReportes gcc = new GuiGenerarReportes(menu, true);
    gcc.setLocationRelativeTo(this);
    gcc.setVisible(true);
  }
  void setDate(){
    LocalDate now = LocalDate.now();
    Locale spanishLocale = new Locale("es", "ES");

    lblFecha.setText(now.format(DateTimeFormatter.ofPattern("'Hoy es' EEEE dd 'de' MMMM 'de' yyyy", spanishLocale)));
  }
}
