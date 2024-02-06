package login;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatMaterialLighterIJTheme;

import menu.GuiMenuTienda;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Cursor;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.*;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class GuiLoginTienda extends JFrame implements ActionListener {

  private JPanel contentPane;
  private JLabel lblImagenLogin;
  private JLabel lblTitulo;
  private JPanel panel;
  private JLabel lblLogo;
  private JLabel lblUsuario;
  private JTextField txtUser;
  private JLabel lblContrasea;
  private JLabel lblMensaje;
  private JButton btnIngresar;
  private JButton btnCerrar;
  private JPasswordField txtPass;

  private static int intentos = 3;

  /**
   * Launch the application.
   */
  public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
      public void run() {
        try {
          GuiLoginTienda frame = new GuiLoginTienda();
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
  public GuiLoginTienda() {
    setTitle("Tienda Cer\u00E1mico");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setBounds(100, 100, 780, 459);
    setResizable(false);
    FlatMaterialLighterIJTheme.setup();
    UIManager.put( "Button.arc", 10);
    setLocationRelativeTo(null);
    setIconImage(new ImageIcon(getClass().getResource("/images/icono.png")).getImage());

    contentPane = new JPanel();
    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
    setContentPane(contentPane);
    contentPane.setLayout(null);

    lblImagenLogin = new JLabel("");
    lblImagenLogin.setVerticalAlignment(SwingConstants.TOP);
    lblImagenLogin.setIcon(new ImageIcon(GuiLoginTienda.class.getResource("/images/imgLogin.png")));
    lblImagenLogin.setBounds(0, 0, 385, 432);
    contentPane.add(lblImagenLogin);

    panel = new JPanel();
    panel.setBounds(386, 0, 388, 432);
    contentPane.add(panel);
    panel.setLayout(null);

    lblTitulo = new JLabel("INICIAR SESI\u00D3N");
    lblTitulo.setForeground(Color.decode("#181818"));
    lblTitulo.setBounds(73, 79, 241, 42);
    panel.add(lblTitulo);
    lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 28));

    lblLogo = new JLabel("");
    lblLogo.setIcon(new ImageIcon(GuiLoginTienda.class.getResource("/images/logoLogin.png")));
    lblLogo.setBounds(40, 11, 127, 57);
    panel.add(lblLogo);

    lblUsuario = new JLabel("USUARIO:");
    lblUsuario.setFont(new Font("Tahoma", Font.BOLD, 14));
    lblUsuario.setBounds(40, 149, 92, 20);
    panel.add(lblUsuario);

    txtUser = new JTextField();
    txtUser.setBackground(Color.WHITE);
    txtUser.setBounds(40, 180, 305, 30);
    panel.add(txtUser);
    txtUser.setColumns(10);

    lblContrasea = new JLabel("CONTRASE\u00D1A:");
    lblContrasea.setFont(new Font("Tahoma", Font.BOLD, 14));
    lblContrasea.setBounds(40, 230, 127, 20);
    panel.add(lblContrasea);

    lblMensaje = new JLabel("");
    lblMensaje.setFont(new Font("Tahoma", Font.BOLD, 14));
    lblMensaje.setHorizontalAlignment(SwingConstants.CENTER);
    lblMensaje.setForeground(Color.decode("#ae0d36"));
    lblMensaje.setBounds(42, 309, 303, 42);
    panel.add(lblMensaje);

    btnIngresar = new JButton("Ingresar");
    btnIngresar.addActionListener(this);
    btnIngresar.setForeground(Color.WHITE);
    btnIngresar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    btnIngresar.setBorderPainted(false);
    btnIngresar.setBackground(Color.decode("#03071E"));
    btnIngresar.setBounds(65, 362, 110, 30);
    panel.add(btnIngresar);

    btnCerrar = new JButton("Salir");
    btnCerrar.addActionListener(this);
    btnCerrar.setForeground(Color.WHITE);
    btnCerrar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    btnCerrar.setBorderPainted(false);
    btnCerrar.setBackground(Color.decode("#370617"));
    btnCerrar.setBounds(214, 362, 110, 30);
    panel.add(btnCerrar);

    txtPass = new JPasswordField();
    txtPass.setBackground(Color.WHITE);
    txtPass.setBounds(40, 261, 305, 30);
    panel.add(txtPass);

    rootPane.setDefaultButton(btnIngresar);
  }
  public void actionPerformed(ActionEvent arg0) {
    if (arg0.getSource() == btnCerrar) {
      actionPerformedBtnCerrar(arg0);
    }
    if (arg0.getSource() == btnIngresar) {
      actionPerformedBtnIngresar(arg0);
    }
  }
  protected void actionPerformedBtnIngresar(ActionEvent arg0) {
    ingresar();
  }
  protected void actionPerformedBtnCerrar(ActionEvent arg0) {
    System.exit(0);
  }

  //Metodo del btnIngresar
  void ingresar(){
    if(validarCampos()){
      try{
        ArrayList<Usuarios> usuarios = new ArrayList<Usuarios>();
        String linea;

        File f = new File("src/usuario/usuarios.txt");
        BufferedReader br = new BufferedReader (new FileReader (f));

        while((linea = br.readLine())!= null){
          StringTokenizer mitokens = new StringTokenizer(linea, "\t");
          String user = mitokens.nextToken();
          String pass = mitokens.nextToken();

          usuarios.add(new Usuarios(user, pass));
        }

        validarUsuario(usuarios, txtUser.getText(), txtPass.getText());

      }catch(IOException e){
        e.printStackTrace();
      }
    }

  }

  //Metodo para validar usuarios
  void validarUsuario(ArrayList<Usuarios> usuarios, String user, String pass){
    boolean encontrado=false;
    String s;

    for(int i=0; i<usuarios.size(); i+=1){
      if(usuarios.get(i).getUser().equals(user)&&usuarios.get(i).getPass().equals(pass)){
        s="Bienvenido "+user;
        encontrado=true;
        JOptionPane.showMessageDialog(this, s, "Inicio de Sesion", JOptionPane.INFORMATION_MESSAGE);
        intentos = 3;

        setVisible(false);
        GuiMenuTienda gcc = new GuiMenuTienda(user, validarSuperUser(usuarios));
        gcc.setLocationRelativeTo(this);
        gcc.setVisible(true);
        return;
      }
    }

    intentos--;

    if(encontrado==false&&intentos>=1){
      if(intentos==1)
        s="Usuario y/o contraseña erróneos, te queda "+intentos+ " intento";
      else
        s="Usuario y/o contraseña erróneos, te quedan "+intentos+ " intentos";

      JOptionPane.showMessageDialog(this, s, "Inicio de Sesion", JOptionPane.ERROR_MESSAGE);
    }

    if(intentos<1){
      s=" No te quedan más intentos, el programa se cerrará";
      JOptionPane.showMessageDialog(this, s, "Inicio de Sesion", JOptionPane.ERROR_MESSAGE);
      System.exit(0);
    }
  }

  //Metodo para validar si los campos están vacíos
  boolean validarCampos(){
    String s;
    if(txtUser.getText().isEmpty() || txtPass.getText().isEmpty()){
      s="Los campos de usuario y/o contraseña están vacíos";
      JOptionPane.showMessageDialog(this, s, "Inicio de Sesion", JOptionPane.ERROR_MESSAGE);
      return false;
    }
    else{
      return true;
    }
  }

  //Metodo para validar si es superusuario
  boolean validarSuperUser(ArrayList<Usuarios> usuarios){
    if(txtUser.getText().equals(usuarios.get(0).getUser())&&txtPass.getText().equals(usuarios.get(0).getPass())){
      return true;
    }
    else{
      return false;
    }
  }
}
