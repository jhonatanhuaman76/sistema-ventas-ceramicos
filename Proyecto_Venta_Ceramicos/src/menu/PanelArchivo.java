package menu;

import javax.swing.JPanel;

import java.awt.Color;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JSeparator;
import javax.swing.LayoutStyle.ComponentPlacement;

import com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatAtomOneDarkIJTheme;
import com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatMaterialLighterIJTheme;
import com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatMaterialOceanicContrastIJTheme;

import login.GuiLoginTienda;

import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.JButton;
import java.awt.Rectangle;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.awt.event.ActionEvent;
import javax.swing.border.MatteBorder;
import java.awt.Cursor;

public class PanelArchivo extends JPanel implements ActionListener {
  private JPanel bg;
  private JPanel PanelSuperior;
  private JLabel lblTitulo;
  private JLabel lblFecha;
  private JSeparator separator;
  private JButton btnSalir;
  private JLabel lblRight;
  private JButton btnCerrarSesin;
  private JLabel lblLeft;
  private JLabel lblManual;
  private GuiMenuTienda menu;

  /**
   * Create the panel.
   */
  public PanelArchivo(GuiMenuTienda menu) {
    this.menu = menu;
    setBorder(null);
    setBounds(0, 0, 689, 546);
    UIManager.put( "Button.arc", 90);
    FlatMaterialLighterIJTheme.setup();

    bg = new JPanel();
    bg.setBackground(Color.WHITE);
    GroupLayout groupLayout = new GroupLayout(this);
    groupLayout.setHorizontalGroup(
        groupLayout.createParallelGroup(Alignment.LEADING)
        .addComponent(bg, GroupLayout.DEFAULT_SIZE, 689, Short.MAX_VALUE)
        );
    groupLayout.setVerticalGroup(
        groupLayout.createParallelGroup(Alignment.LEADING)
        .addComponent(bg, GroupLayout.DEFAULT_SIZE, 546, Short.MAX_VALUE)
        );

    PanelSuperior = new JPanel();
    PanelSuperior.setBackground(new Color(213, 197, 220));

    lblTitulo = new JLabel("Archivo");
    lblTitulo.setIcon(new ImageIcon(PanelArchivo.class.getResource("/images/iconArchivoT.png")));
    lblTitulo.setForeground(new Color(43, 45, 66));
    lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 36));

    separator = new JSeparator();
    separator.setForeground(Color.BLACK);
    separator.setBackground(Color.BLACK);

    lblFecha = new JLabel("");
    lblFecha.setHorizontalAlignment(SwingConstants.RIGHT);
    lblFecha.setFont(new Font("Tahoma", Font.PLAIN, 14));

    btnSalir = new JButton();
    btnSalir.addActionListener(this);
    btnSalir.setText("<html><center>SALIR<html>");
    btnSalir.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    btnSalir.setBackground(Color.decode("#CAF0F8"));
    btnSalir.setFont(new Font("Tahoma", Font.BOLD, 24));
    btnSalir.setIconTextGap(40);
    btnSalir.setHorizontalTextPosition(SwingConstants.CENTER);
    btnSalir.setVerticalTextPosition(SwingConstants.BOTTOM);
    btnSalir.setIcon(new ImageIcon(PanelArchivo.class.getResource("/images/iconSalir.png")));
    btnSalir.setBorderPainted(false);

    lblRight = new JLabel("");

    btnCerrarSesin = new JButton();
    btnCerrarSesin.setBackground(Color.decode("#CAF0F8"));
    btnCerrarSesin.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    btnCerrarSesin.setText("<html><center>CERRAR<br>SESI\u00D3N<html>");
    btnCerrarSesin.addActionListener(this);
    btnCerrarSesin.setFont(new Font("Tahoma", Font.BOLD, 24));
    btnCerrarSesin.setIconTextGap(40);
    btnCerrarSesin.setVerticalTextPosition(SwingConstants.BOTTOM);
    btnCerrarSesin.setHorizontalTextPosition(SwingConstants.CENTER);
    btnCerrarSesin.setIcon(new ImageIcon(PanelArchivo.class.getResource("/images/iconCerrarSesion.png")));
    btnCerrarSesin.setBorderPainted(false);

    lblLeft = new JLabel("");

    lblManual = new JLabel("Ver manual de uso >");
    lblManual.setHorizontalAlignment(SwingConstants.RIGHT);
    lblManual.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    GroupLayout gl_PanelSuperior = new GroupLayout(PanelSuperior);
    gl_PanelSuperior.setHorizontalGroup(
        gl_PanelSuperior.createParallelGroup(Alignment.LEADING)
        .addGroup(gl_PanelSuperior.createSequentialGroup()
            .addGap(24)
            .addComponent(lblTitulo)
            .addGap(18)
            .addComponent(separator, GroupLayout.DEFAULT_SIZE, 425, Short.MAX_VALUE)
            .addGap(26))
        );
    gl_PanelSuperior.setVerticalGroup(
        gl_PanelSuperior.createParallelGroup(Alignment.LEADING)
        .addComponent(lblTitulo, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)
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
            .addComponent(btnSalir, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
            .addGap(109)
            .addGroup(gl_bg.createParallelGroup(Alignment.LEADING)
                .addGroup(Alignment.TRAILING, gl_bg.createSequentialGroup()
                    .addComponent(lblFecha, GroupLayout.PREFERRED_SIZE, 273, GroupLayout.PREFERRED_SIZE)
                    .addGap(22))
                .addGroup(gl_bg.createSequentialGroup()
                    .addGap(6)
                    .addComponent(btnCerrarSesin, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
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
                    .addComponent(btnSalir, GroupLayout.PREFERRED_SIZE, 265, GroupLayout.PREFERRED_SIZE))
                .addGroup(gl_bg.createSequentialGroup()
                    .addGap(5)
                    .addComponent(lblFecha, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
                    .addGap(14)
                    .addGroup(gl_bg.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_bg.createSequentialGroup()
                            .addGap(65)
                            .addComponent(btnCerrarSesin, GroupLayout.PREFERRED_SIZE, 265, GroupLayout.PREFERRED_SIZE))
                        .addComponent(lblRight, GroupLayout.DEFAULT_SIZE, 357, Short.MAX_VALUE))
                    .addGap(20)
                    .addComponent(lblManual, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))))
        );
    bg.setLayout(gl_bg);
    setLayout(groupLayout);
    setDate();
  }
  public void actionPerformed(ActionEvent e) {
    if (e.getSource() == btnSalir) {
      actionPerformedBtnSalir(e);
    }
    if (e.getSource() == btnCerrarSesin) {
      actionPerformedBtnCerrarSesin(e);
    }
  }
  protected void actionPerformedBtnCerrarSesin(ActionEvent e) {
    GuiLoginTienda gcc = new GuiLoginTienda();
    menu.setVisible(false);
    gcc.setLocationRelativeTo(menu);
    gcc.setVisible(true);
  }

  protected void actionPerformedBtnSalir(ActionEvent e) {
    System.exit(0);
  }
  void setDate(){
    LocalDate now = LocalDate.now();
    Locale spanishLocale = new Locale("es", "ES");

    lblFecha.setText(now.format(DateTimeFormatter.ofPattern("'Hoy es' EEEE dd 'de' MMMM 'de' yyyy", spanishLocale)));
  }
}
