package ayuda;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
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
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GuiAcercaDeTienda extends JDialog implements ActionListener {

  private final JPanel contentPanel = new JPanel();
  private JSeparator separator;
  private JLabel lblAutores;
  private JLabel lblJhonatanAdrielHuaman;
  private JLabel lblAlessandroDeLuis;
  private JButton btnCerrar;
  private JLabel lblLuisAntonioChacchi;
  private JLabel lblCarlosGabrielSalinas;
  private JLabel lblPauloCesarLaureano;


  /**
   * Launch the application.
   */
  public static void main(String[] args) {
    try {
      GuiAcercaDeTienda dialog = new GuiAcercaDeTienda(null, false);
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
  public GuiAcercaDeTienda(GuiMenuTienda menu, boolean b) {
    super(menu, b); //Bloquea la ventana hasta que la cierren
    setTitle("Acerca de Tienda");
    setBounds(100, 100, 455, 341);
    setResizable(false);
    getContentPane().setLayout(new BorderLayout());
    UIManager.put( "Button.arc", 10);
    FlatMaterialLighterIJTheme.setup();
    contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
    getContentPane().add(contentPanel, BorderLayout.CENTER);
    contentPanel.setLayout(null);
    {
      JLabel lblTienda = new JLabel("Tienda 1.0");
      lblTienda.setHorizontalAlignment(SwingConstants.CENTER);
      lblTienda.setBounds(156, 11, 132, 32);
      lblTienda.setFont(new Font("Tahoma", Font.BOLD, 24));
      contentPanel.add(lblTienda);
    }

    separator = new JSeparator();
    separator.setBounds(10, 53, 414, 2);
    contentPanel.add(separator);

    lblAutores = new JLabel("Autores");
    lblAutores.setHorizontalAlignment(SwingConstants.CENTER);
    lblAutores.setFont(new Font("Tahoma", Font.BOLD, 16));
    lblAutores.setBounds(187, 67, 70, 20);
    contentPanel.add(lblAutores);

    lblJhonatanAdrielHuaman = new JLabel("Jhonatan Adriel Huaman Pintado");
    lblJhonatanAdrielHuaman.setHorizontalAlignment(SwingConstants.CENTER);
    lblJhonatanAdrielHuaman.setBounds(121, 98, 202, 14);
    contentPanel.add(lblJhonatanAdrielHuaman);

    lblAlessandroDeLuis = new JLabel("Alessandro de Luis Curay Almeida");
    lblAlessandroDeLuis.setHorizontalAlignment(SwingConstants.CENTER);
    lblAlessandroDeLuis.setBounds(123, 123, 202, 14);
    contentPanel.add(lblAlessandroDeLuis);

    btnCerrar = new JButton("Cerrar");
    btnCerrar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    btnCerrar.setForeground(Color.WHITE);
    btnCerrar.setBackground(Color.decode("#370617"));
    btnCerrar.setBorderPainted(false);
    btnCerrar.addActionListener(this);
    btnCerrar.setBounds(167, 258, 110, 30);
    contentPanel.add(btnCerrar);

    lblLuisAntonioChacchi = new JLabel("Luis Antonio Chacchi Collazos");
    lblLuisAntonioChacchi.setHorizontalAlignment(SwingConstants.CENTER);
    lblLuisAntonioChacchi.setBounds(121, 148, 202, 14);
    contentPanel.add(lblLuisAntonioChacchi);

    lblCarlosGabrielSalinas = new JLabel("Carlos Gabriel Salinas Conqui");
    lblCarlosGabrielSalinas.setHorizontalAlignment(SwingConstants.CENTER);
    lblCarlosGabrielSalinas.setBounds(121, 175, 202, 14);
    contentPanel.add(lblCarlosGabrielSalinas);

    lblPauloCesarLaureano = new JLabel("Paulo Cesar Laureano Cruzado");
    lblPauloCesarLaureano.setHorizontalAlignment(SwingConstants.CENTER);
    lblPauloCesarLaureano.setBounds(121, 201, 202, 14);
    contentPanel.add(lblPauloCesarLaureano);

    setIconImage(new ImageIcon(getClass().getResource("/images/icono.png")).getImage());
  }
  public void actionPerformed(ActionEvent arg0) {
    if (arg0.getSource() == btnCerrar) {
      actionPerformedBtnCerrar(arg0);
    }
  }
  protected void actionPerformedBtnCerrar(ActionEvent arg0) {
    dispose();
  }
}
