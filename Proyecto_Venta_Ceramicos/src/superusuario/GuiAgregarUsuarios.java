package superusuario;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatMaterialLighterIJTheme;

import login.Usuarios;
import menu.GuiMenuTienda;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.awt.event.ActionEvent;

public class GuiAgregarUsuarios extends JDialog implements ActionListener {

  private final JPanel contentPanel = new JPanel();
  private JTextField txtUser;
  private JLabel lblNombreUsuario;
  private JTextField txtPass;
  private JButton btnAnadir;
  private JButton btnCerrar;
  private JLabel label;

  /**
   * Launch the application.
   */
  public static void main(String[] args) {
    try {
      GuiAgregarUsuarios dialog = new GuiAgregarUsuarios(null, true);
      dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
      dialog.setVisible(true);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * Create the dialog.
   */
  public GuiAgregarUsuarios(GuiMenuTienda menu, boolean b) {
    super(menu, b); //Bloquea la ventana hasta que la cierren
    setBounds(100, 100, 411, 365);
    setResizable(false);
    FlatMaterialLighterIJTheme.setup();
    UIManager.put( "Button.arc", 10);
    setLocationRelativeTo(null);
    setIconImage(new ImageIcon(getClass().getResource("/images/icono.png")).getImage());

    getContentPane().setLayout(new BorderLayout());		
    contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
    getContentPane().add(contentPanel, BorderLayout.CENTER);
    contentPanel.setLayout(null);
    {
      JLabel lblNewLabel = new JLabel("NUEVO USUARIO");
      lblNewLabel.setForeground(Color.BLACK);
      lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
      lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
      lblNewLabel.setBounds(115, 30, 227, 33);
      contentPanel.add(lblNewLabel);
    }
    {
      JLabel lblUser = new JLabel("Nombre Usuario: ");
      lblUser.setBounds(36, 95, 111, 14);
      contentPanel.add(lblUser);
    }

    txtUser = new JTextField();
    txtUser.setBackground(Color.WHITE);
    txtUser.setBounds(36, 120, 333, 30);
    contentPanel.add(txtUser);
    txtUser.setColumns(10);

    lblNombreUsuario = new JLabel("Contrase\u00F1a: ");
    lblNombreUsuario.setBounds(36, 177, 111, 14);
    contentPanel.add(lblNombreUsuario);

    txtPass = new JTextField();
    txtPass.setBackground(Color.WHITE);
    txtPass.setColumns(10);
    txtPass.setBounds(36, 202, 333, 30);
    contentPanel.add(txtPass);

    btnAnadir = new JButton("A\u00F1adir");
    btnAnadir.addActionListener(this);
    btnAnadir.setForeground(Color.WHITE);
    btnAnadir.setBorderPainted(false);
    btnAnadir.setBackground(new Color(3, 7, 30));
    btnAnadir.setBounds(81, 267, 110, 30);
    contentPanel.add(btnAnadir);

    btnCerrar = new JButton("Cerrar");
    btnCerrar.addActionListener(this);
    btnCerrar.setForeground(Color.WHITE);
    btnCerrar.setBorderPainted(false);
    btnCerrar.setBackground(new Color(55, 6, 23));
    btnCerrar.setBounds(214, 267, 110, 30);
    contentPanel.add(btnCerrar);

    label = new JLabel("");
    label.setIcon(new ImageIcon(GuiAgregarUsuarios.class.getResource("/images/imgAdd.png")));
    label.setBounds(70, 21, 50, 51);
    contentPanel.add(label);
  }
  public void actionPerformed(ActionEvent arg0) {
    if (arg0.getSource() == btnCerrar) {
      actionPerformedBtnCerrar(arg0);
    }
    if (arg0.getSource() == btnAnadir) {
      actionPerformedBtnAnadir(arg0);
    }
  }
  protected void actionPerformedBtnAnadir(ActionEvent arg0) {
    anadirUsuarios();
  }
  protected void actionPerformedBtnCerrar(ActionEvent arg0) {
    dispose();
  }

  //Metodo para añadir usuarios
  void anadirUsuarios(){
    if(validarCampos()&&!(usuarioRepetido())){
      try{
        FileWriter wr = new FileWriter("src/usuario/usuarios.txt", true);
        wr.write(txtUser.getText()+"\t"+txtPass.getText()+"\r\n");
        wr.close();
        String s="Usuario agregado";
        JOptionPane.showMessageDialog(this, s, "MENSAJE INFORMATIVO", JOptionPane.INFORMATION_MESSAGE);
        limpiarTextField();
      }catch(IOException ex){
        ex.printStackTrace();
      }
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
    else if(txtUser.getText().contains(" ") || txtPass.getText().contains(" ")){
      s="No se permite espacios en el usuario y/o contraseña";
      JOptionPane.showMessageDialog(this, s, "Inicio de Sesion", JOptionPane.ERROR_MESSAGE);
      return false;
    }
    else{
      return true;
    }
  }

  void limpiarTextField(){
    txtUser.setText("");
    txtPass.setText("");
  }

  //Metodo para validar si se repite el usuario
  boolean usuarioRepetido(){
    ArrayList<Usuarios> usuarios = new ArrayList<Usuarios>();
    String linea;

    try{
      File f = new File("src/usuario/usuarios.txt");
      BufferedReader br = new BufferedReader (new FileReader (f));


      while((linea = br.readLine())!= null){
        StringTokenizer mitokens = new StringTokenizer(linea, "\t");
        String user = mitokens.nextToken();
        String pass = mitokens.nextToken();

        usuarios.add(new Usuarios(user, pass));
      }
    }catch(IOException ex){
      ex.printStackTrace();
    }
    return validarUsuario(usuarios, txtUser.getText(), txtPass.getText());
  }


  boolean validarUsuario(ArrayList<Usuarios> usuarios, String user, String pass){
    String s;
    for(int i=0; i<usuarios.size(); i+=1){
      if(usuarios.get(i).getUser().equals(user)){
        s="El usuario ya existe, ingrese otro.";
        JOptionPane.showMessageDialog(this, s, "Inicio de Sesion", JOptionPane.ERROR_MESSAGE);
        return true;
      }
    }
    return false;
  }
}
