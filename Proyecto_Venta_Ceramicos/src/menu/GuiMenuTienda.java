package menu;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatMaterialLighterIJTheme;

import ayuda.GuiAcercaDeTienda;
import superusuario.GuiAgregarUsuarios;
import superusuario.GuiEliminarUsuarios;
import ventas.PanelVentasxModelo;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Dimension;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import java.awt.Cursor;
import java.awt.Font;
import javax.swing.border.MatteBorder;

public class GuiMenuTienda extends JFrame implements ActionListener, MouseListener {

  private JPanel contentPane;
  private JPanel PanelMenu;
  private JLabel lblLogoMenu;
  private JLabel lblLineMenu;
  private JButton btnInicio;
  private JButton btnArchivo;
  private JButton btnMantenimiento;
  private JButton btnVentas;
  private JButton btnConfiguracin;
  private JButton btnAyuda;
  private JLabel blMensaje;
  private JButton btnnombreusuario;
  private JLabel lblLineSuperior;
  private JLabel lblIconNoti;
  private JPanel superior;
  private JPanel panel;
  private JPanel Content;

  // Datos mínimos del primer producto
  public static String modelo0 = "Cinza Plus";
  public static double precio0 = 92.56;
  public static double ancho0 = 62.0;
  public static double largo0 = 62.0;
  public static double espesor0 = 8;
  public static int contenido0 = 6;
  public static int stock0 = 10000;
  // Datos mínimos del segundo producto
  public static String modelo1 = "Luxury";
  public static double precio1 = 42.77;
  public static double ancho1 = 60;
  public static double largo1 = 60;
  public static double espesor1 = 8.5;
  public static int contenido1 = 4;
  public static int stock1 = 8000;
  // Datos mínimos del tercer producto
  public static String modelo2 = "Austria";
  public static double precio2 = 52.45;
  public static double ancho2 = 45;
  public static double largo2 = 45;
  public static double espesor2 = 6.5;
  public static int contenido2 = 12;
  public static int stock2= 9000;
  // Datos mínimos del cuarto producto
  public static String modelo3 = "Yungay Mix";
  public static double precio3 = 55.89;
  public static double ancho3 = 80;
  public static double largo3 = 120;
  public static double espesor3 = 6.8;
  public static int contenido3 = 9;
  public static int stock3 = 11000;
  // Datos mínimos del quinto producto
  public static String modelo4 = "Thal\u00EDa";
  public static double precio4 = 45;
  public static double ancho4 = 45;
  public static double largo4 = 11.8;
  public static double espesor4 = 7.2;
  public static int contenido4 = 10;
  public static int stock4 = 7000;
  // Porcentajes de descuento
  public static double porcentaje1 = 7.5;
  public static double porcentaje2 = 10.0;
  public static double porcentaje3 = 12.5;
  public static double porcentaje4 = 15.0;
  // Obsequio
  public static String tipoObsequio = "Lapicero";
  public static int obsequioCantidad1 = 2;
  public static int obsequioCantidad2 = 3;
  public static int obsequioCantidad3 = 4;
  // Cantidad óptima de unidades vendidas por día
  public static int cantidadOptima = 10;
  // Cuota diaria
  public static double cuotaDiaria = 30000;
  //Variables alerta contadores
  public static int cantVent0, cantVent1, cantVent2, cantVent3, cantVent4, cantVentG, cajasVend0, cajasVend1, cajasVend2, cajasVend3, cajasVend4;
  public static double impT0, impT1, impT2, impT3, impT4, impTG, pcuoDia0, pcuoDia1, pcuoDia2, pcuoDia3, pcuoDia4, pcuoDiaG ;

  private String nombreUser;
  private JPanel panelSuperUser;
  private JLabel lblAddUser;
  private JLabel lblDeleteUser;

  /**
   * Launch the application.
   */
  public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
      public void run() {
        try {
          GuiMenuTienda frame = new GuiMenuTienda(null, false);
          frame.setExtendedState(MAXIMIZED_BOTH);
          frame.setVisible(true);
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
    });
  }


  /**
   * Create the frame.
   */
  public GuiMenuTienda(String nombreUser, boolean superUser) {
    this.nombreUser = (nombreUser ==null)?"User": nombreUser;

    setTitle("Tienda Cer\u00E1micos");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setBounds(0, 0, 1000, 640);
    setMinimumSize(new Dimension(1000, 640));
    setLocationRelativeTo(null);
    FlatMaterialLighterIJTheme.setup();
    setExtendedState(MAXIMIZED_BOTH);
    setIconImage(new ImageIcon(getClass().getResource("/images/icono.png")).getImage());

    contentPane = new JPanel();
    contentPane.setBackground(Color.WHITE);
    contentPane.setBorder(null);
    setContentPane(contentPane);

    PanelMenu = new JPanel(){ //Metodo para definir degradado
      @Override
      public void paint(Graphics g){
        Graphics2D G2D = (Graphics2D) g;
        int w = getWidth();
        int h = getHeight();

        GradientPaint gp = new GradientPaint(0, 0, Color.decode("#370617"), 0, h, Color.decode("#03071E"));

        G2D.setPaint(gp);
        G2D.fillRect(0, 0, w, h);
        super.paint(g);
      }
    };
    PanelMenu.setOpaque(false);
    PanelMenu.setPreferredSize(new Dimension(303, 10));

    lblLogoMenu = new JLabel("");
    lblLogoMenu.setHorizontalAlignment(SwingConstants.CENTER);
    lblLogoMenu.setIcon(new ImageIcon(GuiMenuTienda.class.getResource("/images/LogoMenu .png")));

    lblLineMenu = new JLabel("");
    lblLineMenu.setIcon(new ImageIcon(GuiMenuTienda.class.getResource("/images/LineMenu.png")));

    btnInicio = new JButton("Inicio");
    btnInicio.setIconTextGap(10);
    btnInicio.setHorizontalAlignment(SwingConstants.LEFT);
    btnInicio.setIcon(new ImageIcon(GuiMenuTienda.class.getResource("/images/iconInicio.png")));
    btnInicio.setForeground(Color.WHITE);
    btnInicio.setFont(new Font("Tahoma", Font.PLAIN, 20));
    btnInicio.addActionListener(this);
    btnInicio.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    btnInicio.setBackground(Color.decode("#260B20"));
    btnInicio.setBorderPainted(false);
    btnInicio.setBorder(new MatteBorder(1, 30, 1, 1, (Color) null));

    btnArchivo = new JButton("Archivo");
    btnArchivo.addActionListener(this);
    btnArchivo.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    btnArchivo.setIcon(new ImageIcon(GuiMenuTienda.class.getResource("/images/iconArchivo.png")));
    btnArchivo.setIconTextGap(10);
    btnArchivo.setHorizontalAlignment(SwingConstants.LEFT);
    btnArchivo.setForeground(Color.WHITE);
    btnArchivo.setFont(new Font("Tahoma", Font.PLAIN, 20));
    btnArchivo.setBorderPainted(false);
    btnArchivo.setBorder(new MatteBorder(1, 30, 1, 1, (Color) null));
    btnArchivo.setBackground(new Color(38, 11, 32));

    btnMantenimiento = new JButton("Mantenimiento");
    btnMantenimiento.addActionListener(this);
    btnMantenimiento.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    btnMantenimiento.setIcon(new ImageIcon(GuiMenuTienda.class.getResource("/images/iconManteni.png")));
    btnMantenimiento.setIconTextGap(10);
    btnMantenimiento.setHorizontalAlignment(SwingConstants.LEFT);
    btnMantenimiento.setForeground(Color.WHITE);
    btnMantenimiento.setFont(new Font("Tahoma", Font.PLAIN, 20));
    btnMantenimiento.setBorderPainted(false);
    btnMantenimiento.setBorder(new MatteBorder(1, 30, 1, 1, (Color) null));
    btnMantenimiento.setBackground(new Color(38, 11, 32));

    btnVentas = new JButton("Ventas");
    btnVentas.addActionListener(this);
    btnVentas.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    btnVentas.setIcon(new ImageIcon(GuiMenuTienda.class.getResource("/images/iconVentas.png")));
    btnVentas.setIconTextGap(10);
    btnVentas.setHorizontalAlignment(SwingConstants.LEFT);
    btnVentas.setForeground(Color.WHITE);
    btnVentas.setFont(new Font("Tahoma", Font.PLAIN, 20));
    btnVentas.setBorderPainted(false);
    btnVentas.setBorder(new MatteBorder(1, 30, 1, 1, (Color) null));
    btnVentas.setBackground(new Color(38, 11, 32));

    btnConfiguracin = new JButton("Configuraci\u00F3n");
    btnConfiguracin.addActionListener(this);
    btnConfiguracin.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    btnConfiguracin.setIcon(new ImageIcon(GuiMenuTienda.class.getResource("/images/iconConfi.png")));
    btnConfiguracin.setIconTextGap(10);
    btnConfiguracin.setHorizontalAlignment(SwingConstants.LEFT);
    btnConfiguracin.setForeground(Color.WHITE);
    btnConfiguracin.setFont(new Font("Tahoma", Font.PLAIN, 20));
    btnConfiguracin.setBorderPainted(false);
    btnConfiguracin.setBorder(new MatteBorder(1, 30, 1, 1, (Color) null));
    btnConfiguracin.setBackground(new Color(38, 11, 32));

    btnAyuda = new JButton("Ayuda");
    btnAyuda.addActionListener(this);
    btnAyuda.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    btnAyuda.setIcon(new ImageIcon(GuiMenuTienda.class.getResource("/images/iconAyuda.png")));
    btnAyuda.setIconTextGap(10);
    btnAyuda.setHorizontalAlignment(SwingConstants.LEFT);
    btnAyuda.setForeground(Color.WHITE);
    btnAyuda.setFont(new Font("Tahoma", Font.PLAIN, 20));
    btnAyuda.setBorderPainted(false);
    btnAyuda.setBorder(new MatteBorder(1, 30, 1, 1, (Color) null));
    btnAyuda.setBackground(new Color(38, 11, 32));
    GroupLayout gl_PanelMenu = new GroupLayout(PanelMenu);
    gl_PanelMenu.setHorizontalGroup(
        gl_PanelMenu.createParallelGroup(Alignment.LEADING)
        .addGroup(gl_PanelMenu.createSequentialGroup()
            .addContainerGap()
            .addGroup(gl_PanelMenu.createParallelGroup(Alignment.TRAILING)
                .addComponent(lblLineMenu, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblLogoMenu, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 277, Short.MAX_VALUE))
            .addContainerGap())
        .addComponent(btnArchivo, GroupLayout.DEFAULT_SIZE, 297, Short.MAX_VALUE)
        .addComponent(btnInicio, GroupLayout.DEFAULT_SIZE, 297, Short.MAX_VALUE)
        .addComponent(btnMantenimiento, GroupLayout.DEFAULT_SIZE, 297, Short.MAX_VALUE)
        .addComponent(btnVentas, GroupLayout.DEFAULT_SIZE, 297, Short.MAX_VALUE)
        .addComponent(btnConfiguracin, GroupLayout.DEFAULT_SIZE, 297, Short.MAX_VALUE)
        .addComponent(btnAyuda, GroupLayout.DEFAULT_SIZE, 297, Short.MAX_VALUE)
        );
    gl_PanelMenu.setVerticalGroup(
        gl_PanelMenu.createParallelGroup(Alignment.LEADING)
        .addGroup(gl_PanelMenu.createSequentialGroup()
            .addContainerGap()
            .addComponent(lblLogoMenu, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(ComponentPlacement.RELATED)
            .addComponent(lblLineMenu)
            .addGap(37)
            .addComponent(btnInicio, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(ComponentPlacement.RELATED)
            .addComponent(btnArchivo, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(ComponentPlacement.RELATED)
            .addComponent(btnMantenimiento, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(ComponentPlacement.RELATED)
            .addComponent(btnVentas, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(ComponentPlacement.RELATED)
            .addComponent(btnConfiguracin, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(ComponentPlacement.RELATED)
            .addComponent(btnAyuda, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE)
            .addContainerGap(20, Short.MAX_VALUE))
        );
    PanelMenu.setLayout(gl_PanelMenu);
    PanelMenu.repaint();
    PanelMenu.revalidate();

    blMensaje = new JLabel("\u00A1Dise\u00F1o y calidad en cada paso!");
    blMensaje.setFont(new Font("Tahoma", Font.BOLD, 13));

    superior = new JPanel();
    superior.setBackground(Color.WHITE);

    panel = new JPanel();
    Content = new PanelInicio(this.nombreUser);
    Content.setBackground(Color.WHITE);
    btnnombreusuario = new JButton(this.nombreUser);
    btnnombreusuario.setBounds(64, 0, 140, 34);
    btnnombreusuario.setHorizontalAlignment(SwingConstants.RIGHT);
    btnnombreusuario.setFont(new Font("Tahoma", Font.PLAIN, 16));
    btnnombreusuario.addActionListener(this);
    btnnombreusuario.setIconTextGap(10);
    btnnombreusuario.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    btnnombreusuario.setBackground(new Color(0,0,0,0));
    btnnombreusuario.setHorizontalTextPosition(SwingConstants.LEFT);
    btnnombreusuario.setIcon(new ImageIcon(GuiMenuTienda.class.getResource("/images/iconUser.png")));
    btnnombreusuario.setBorder(null);
    btnnombreusuario.setBorderPainted(false);

    lblLineSuperior = new JLabel("");
    lblLineSuperior.setBounds(54, 0, 10, 34);
    lblLineSuperior.setHorizontalAlignment(SwingConstants.CENTER);
    lblLineSuperior.setIcon(new ImageIcon(GuiMenuTienda.class.getResource("/images/lineSuperior.png")));
    superior.setLayout(null);

    lblIconNoti = new JLabel("");
    lblIconNoti.setBounds(6, 0, 24, 34);
    lblIconNoti.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    lblIconNoti.setIcon(new ImageIcon(GuiMenuTienda.class.getResource("/images/iconNoti.png")));
    superior.add(lblIconNoti);
    superior.add(lblLineSuperior);
    superior.add(btnnombreusuario);

    panelSuperUser = new JPanel();
    panelSuperUser.setBackground(Color.WHITE);
    panelSuperUser.setVisible(false);
    panelSuperUser.setLayout(null);

    lblDeleteUser = new JLabel("");
    lblDeleteUser.addMouseListener(this);
    lblDeleteUser.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    lblDeleteUser.setIcon(new ImageIcon(GuiMenuTienda.class.getResource("/images/DeleteUser.png")));
    lblDeleteUser.setBounds(62, 0, 26, 34);
    panelSuperUser.add(lblDeleteUser);

    lblAddUser = new JLabel("");
    lblAddUser.addMouseListener(this);
    lblAddUser.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    lblAddUser.setIcon(new ImageIcon(GuiMenuTienda.class.getResource("/images/AddUser.png")));
    lblAddUser.setBounds(6, 0, 26, 34);
    panelSuperUser.add(lblAddUser);
    GroupLayout gl_contentPane = new GroupLayout(contentPane);
    gl_contentPane.setHorizontalGroup(
        gl_contentPane.createParallelGroup(Alignment.LEADING)
        .addGroup(gl_contentPane.createSequentialGroup()
            .addComponent(PanelMenu, GroupLayout.PREFERRED_SIZE, 295, GroupLayout.PREFERRED_SIZE)
            .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                .addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
                    .addGap(18)
                    .addComponent(blMensaje)
                    .addPreferredGap(ComponentPlacement.RELATED, 120, Short.MAX_VALUE)
                    .addComponent(panelSuperUser, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
                    .addGap(12)
                    .addComponent(superior, GroupLayout.PREFERRED_SIZE, 210, GroupLayout.PREFERRED_SIZE)
                    .addGap(25))
                .addComponent(Content, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
    gl_contentPane.setVerticalGroup(
        gl_contentPane.createParallelGroup(Alignment.LEADING)
        .addComponent(PanelMenu, GroupLayout.DEFAULT_SIZE, 601, Short.MAX_VALUE)
        .addGroup(gl_contentPane.createSequentialGroup()
            .addGap(9)
            .addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
                .addGroup(gl_contentPane.createSequentialGroup()
                    .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                        .addComponent(panelSuperUser, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
                        .addComponent(superior, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE))
                    .addGap(12))
                .addGroup(gl_contentPane.createSequentialGroup()
                    .addComponent(blMensaje)
                    .addGap(18)))
            .addComponent(Content, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    contentPane.setLayout(gl_contentPane);

    superUsuario(superUser);
  }


  @Override
  public void actionPerformed(ActionEvent arg0) {
    if (arg0.getSource() == btnAyuda) {
      actionPerformedBtnAyuda(arg0);
    }
    if (arg0.getSource() == btnConfiguracin) {
      actionPerformedBtnConfiguracin(arg0);
    }
    if (arg0.getSource() == btnVentas) {
      actionPerformedBtnVentas(arg0);
    }
    if (arg0.getSource() == btnMantenimiento) {
      actionPerformedBtnMantenimiento(arg0);
    }
    if (arg0.getSource() == btnArchivo) {
      actionPerformedBtnArchivo(arg0);
    }
    if (arg0.getSource() == btnInicio) {
      actionPerformedBtnInicio(arg0);
    }
    // TODO Auto-generated method stub

  }
  protected void actionPerformedBtnInicio(ActionEvent arg0) {
    PanelInicio p = new PanelInicio(nombreUser);
    cambiarPanel(p);
  }
  protected void actionPerformedBtnArchivo(ActionEvent arg0) {
    PanelArchivo p = new PanelArchivo(this);
    cambiarPanel(p);
  }

  protected void actionPerformedBtnMantenimiento(ActionEvent arg0) {
    PanelMantenimiento p = new PanelMantenimiento(this);
    cambiarPanel(p);
  }

  protected void actionPerformedBtnVentas(ActionEvent arg0) {
    PanelVentas p = new PanelVentas(this);
    cambiarPanel(p);
  }

  protected void actionPerformedBtnConfiguracin(ActionEvent arg0) {
    PanelConfiguracion p = new PanelConfiguracion(this);
    cambiarPanel(p);
  }

  protected void actionPerformedBtnAyuda(ActionEvent arg0) {
    PanelAyuda p = new PanelAyuda(this);
    cambiarPanel(p);
  }

  //Metodo para cambiar paneles
  void cambiarPanel(JPanel panelActual){
    Content.removeAll();
    Content.setLayout(new java.awt.BorderLayout());
    Content.add(panelActual, BorderLayout.CENTER);
    Content.revalidate();
    Content.repaint();
  }
  //Metodo para mostrar controles de superusuario
  void superUsuario(boolean superUser){
    if(superUser){
      panelSuperUser.setVisible(true);
    }
  }

  public void mouseClicked(MouseEvent e) {
    if (e.getSource() == lblDeleteUser) {
      mouseClickedLblDeleteUser(e);
    }
    if (e.getSource() == lblAddUser) {
      mouseClickedLblAddUser(e);
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
  protected void mouseClickedLblAddUser(MouseEvent e) {
    GuiAgregarUsuarios gcc = new GuiAgregarUsuarios(this, true);
    gcc.setLocationRelativeTo(this);
    gcc.setVisible(true);
  }
  protected void mouseClickedLblDeleteUser(MouseEvent e) {
    GuiEliminarUsuarios gcc = new GuiEliminarUsuarios(this, true);
    gcc.setLocationRelativeTo(this);
    gcc.setVisible(true);
  }
}
