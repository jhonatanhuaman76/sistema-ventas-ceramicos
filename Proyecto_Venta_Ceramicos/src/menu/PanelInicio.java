package menu;

import javax.swing.JPanel;
import javax.swing.UIManager;

import com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatMaterialLighterIJTheme;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import javax.swing.JSeparator;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ImageIcon;
import java.awt.Cursor;

public class PanelInicio extends JPanel {
  private JPanel bg;
  private JPanel PanelSuperior;
  private JLabel lblArchivo;
  private JSeparator separator;
  private JLabel lblLeft;
  private JLabel lblRight;
  private JLabel lblFecha;
  private JLabel lblManual;
  private JLabel lblBienvenida;
  private JLabel lblParrafo;
  private JLabel lblImagen;

  /**
   * Create the panel.
   */
  public PanelInicio(String nombreUser) {
    setBorder(null);
    setBounds(0, 0, 689, 546);
    FlatMaterialLighterIJTheme.setup();

    bg = new JPanel();
    bg.setBackground(Color.WHITE);

    PanelSuperior = new JPanel();
    PanelSuperior.setBackground(new Color(213, 197, 220));

    lblArchivo = new JLabel("Inicio");
    lblArchivo.setIcon(new ImageIcon(PanelInicio.class.getResource("/images/iconInicioT.png")));
    lblArchivo.setForeground(new Color(43, 45, 66));
    lblArchivo.setFont(new Font("Tahoma", Font.BOLD, 36));

    separator = new JSeparator();
    separator.setForeground(Color.BLACK);
    separator.setBackground(Color.BLACK);

    lblLeft = new JLabel("");

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

    lblBienvenida = new JLabel("Bienvenido, "+nombreUser);
    lblBienvenida.setHorizontalAlignment(SwingConstants.CENTER);
    lblBienvenida.setFont(new Font("Tahoma", Font.PLAIN, 22));

    lblParrafo = new JLabel("Sistema de Ventas para la empresa \u201CCer\u00E1micos del Sol\u201D, dedicada a la venta de cer\u00E1micos para pisos.");
    lblParrafo.setHorizontalAlignment(SwingConstants.CENTER);
    lblParrafo.setFont(new Font("Tahoma", Font.PLAIN, 11));

    lblImagen = new JLabel("");
    lblImagen.setIcon(new ImageIcon(PanelInicio.class.getResource("/images/imgCeramicos.png")));
    GroupLayout gl_PanelSuperior = new GroupLayout(PanelSuperior);
    gl_PanelSuperior.setHorizontalGroup(
        gl_PanelSuperior.createParallelGroup(Alignment.LEADING)
        .addGroup(gl_PanelSuperior.createSequentialGroup()
            .addGap(24)
            .addComponent(lblArchivo)
            .addGap(18)
            .addComponent(separator, GroupLayout.DEFAULT_SIZE, 459, Short.MAX_VALUE)
            .addGap(26))
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
            .addGap(394)
            .addComponent(lblFecha, GroupLayout.PREFERRED_SIZE, 273, GroupLayout.PREFERRED_SIZE)
            .addGap(22))
        .addGroup(gl_bg.createSequentialGroup()
            .addGap(26)
            .addComponent(lblBienvenida, GroupLayout.DEFAULT_SIZE, 641, Short.MAX_VALUE)
            .addGap(22))
        .addGroup(gl_bg.createSequentialGroup()
            .addGap(26)
            .addComponent(lblParrafo, GroupLayout.DEFAULT_SIZE, 641, Short.MAX_VALUE)
            .addGap(22))
        .addGroup(gl_bg.createSequentialGroup()
            .addComponent(lblLeft, GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE)
            .addGap(11)
            .addComponent(lblImagen)
            .addGap(10)
            .addGroup(gl_bg.createParallelGroup(Alignment.LEADING)
                .addComponent(lblRight, GroupLayout.DEFAULT_SIZE, 156, Short.MAX_VALUE)
                .addGroup(Alignment.TRAILING, gl_bg.createSequentialGroup()
                    .addGap(20)
                    .addComponent(lblManual, GroupLayout.PREFERRED_SIZE, 112, GroupLayout.PREFERRED_SIZE)
                    .addGap(24))))
        );
    gl_bg.setVerticalGroup(
        gl_bg.createParallelGroup(Alignment.LEADING)
        .addGroup(gl_bg.createSequentialGroup()
            .addComponent(PanelSuperior, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
            .addGap(11)
            .addComponent(lblFecha, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
            .addGap(7)
            .addComponent(lblBienvenida, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
            .addGap(4)
            .addComponent(lblParrafo, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
            .addGap(33)
            .addGroup(gl_bg.createParallelGroup(Alignment.LEADING)
                .addComponent(lblLeft, GroupLayout.DEFAULT_SIZE, 331, Short.MAX_VALUE)
                .addComponent(lblImagen)
                .addGroup(gl_bg.createSequentialGroup()
                    .addGap(6)
                    .addComponent(lblRight, GroupLayout.DEFAULT_SIZE, 276, Short.MAX_VALUE)
                    .addGap(9)
                    .addComponent(lblManual, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))))
        );
    bg.setLayout(gl_bg);
    setLayout(groupLayout);
    UIManager.put( "Button.arc", 90);
    FlatMaterialLighterIJTheme.setup();

    setDate();
  }

  void setDate(){
    LocalDate now = LocalDate.now();
    Locale spanishLocale = new Locale("es", "ES");

    lblFecha.setText(now.format(DateTimeFormatter.ofPattern("'Hoy es' EEEE dd 'de' MMMM 'de' yyyy", spanishLocale)));
  }

}
