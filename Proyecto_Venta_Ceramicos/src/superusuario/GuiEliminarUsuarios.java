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

public class GuiEliminarUsuarios extends JDialog implements ActionListener {

  private final JPanel contentPanel = new JPanel();
  private JTextField txtUser;
  private JLabel lblNombreUsuario;
  private JTextField txtPass;
  private JButton btnEliminar;
  private JButton btnCerrar;
  private JLabel label;

  /**
   * Launch the application.
   */
  public static void main(String[] args) {
    try {
      GuiEliminarUsuarios dialog = new GuiEliminarUsuarios(null, true);
      dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
      dialog.setVisible(true);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * Create the dialog.
   */
  public GuiEliminarUsuarios(GuiMenuTienda menu, boolean b) {
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
      JLabel lblNewLabel = new JLabel("ELIMINAR USUARIO");
      lblNewLabel.setForeground(Color.BLACK);
      lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
      lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
      lblNewLabel.setBounds(100, 30, 254, 33);
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

    btnEliminar = new JButton("Eliminar");
    btnEliminar.addActionListener(this);
    btnEliminar.setForeground(Color.WHITE);
    btnEliminar.setBorderPainted(false);
    btnEliminar.setBackground(new Color(3, 7, 30));
    btnEliminar.setBounds(81, 267, 110, 30);
    contentPanel.add(btnEliminar);

    btnCerrar = new JButton("Cerrar");
    btnCerrar.addActionListener(this);
    btnCerrar.setForeground(Color.WHITE);
    btnCerrar.setBorderPainted(false);
    btnCerrar.setBackground(new Color(55, 6, 23));
    btnCerrar.setBounds(214, 267, 110, 30);
    contentPanel.add(btnCerrar);

    label = new JLabel("");
    label.setIcon(new ImageIcon(GuiEliminarUsuarios.class.getResource("/images/imgDelete.png")));
    label.setBounds(40, 22, 50, 51);
    contentPanel.add(label);
  }
  public void actionPerformed(ActionEvent arg0) {
    if (arg0.getSource() == btnCerrar) {
      actionPerformedBtnCerrar(arg0);
    }
    if (arg0.getSource() == btnEliminar) {
      actionPerformedBtnAnadir(arg0);
    }
  }
  protected void actionPerformedBtnAnadir(ActionEvent arg0) {
    eliminarUsuarios();
  }
  protected void actionPerformedBtnCerrar(ActionEvent arg0) {
    dispose();
  }

  //Metodo para eliminar usuarios
  void eliminarUsuarios(){
    String user = txtUser.getText();
    String pass = txtPass.getText();
    if(validarCampos()&&validarUsuario(leerArchivo(), user, pass)&&!(validarSuperUser(leerArchivo(), user, pass))){
      nuevaListaUsuarios(leerArchivo(), user, pass);
      limpiarTextField();
    }
  }

  //Metodo para escribir la nueva lista de usuarios
  void nuevaListaUsuarios(ArrayList<Usuarios> usuarios, String dUser, String dPass){
    try {
      FileWriter br = new FileWriter("src/usuario/usuarios.txt");
      for(Usuarios us: usuarios){
        if(!(us.getUser().equals(dUser))){
          br.write(us.getUser()+"\t"+us.getPass()+"\r\n");
        }
      }
      br.close();
      String s = "Usuario eliminado con éxito";
      JOptionPane.showMessageDialog(this, s, "MENSAJE INFORMATIVO", JOptionPane.INFORMATION_MESSAGE);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  //Metodo para validar si el usuario y contraseña existen
  boolean validarUsuario(ArrayList<Usuarios> usuarios, String user, String pass){
    String s;
    for(int i=0; i<usuarios.size(); i+=1){
      if(usuarios.get(i).getUser().equals(user)&&usuarios.get(i).getPass().equals(pass)){
        return true;
      }
    }
    s="Usuario no encontrado.\nVerificar que el nombre y la contraseña sean correctos";
    JOptionPane.showMessageDialog(this, s, "MENSAJE DE ERROR", JOptionPane.ERROR_MESSAGE);
    return false;
  }

  //Metodo para leer el archivo
  ArrayList<Usuarios> leerArchivo(){
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

    return usuarios;
  }

  //Metodo para validar si los campos 
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

  //Metodo para validar que no elimine al superusuario
  boolean validarSuperUser(ArrayList<Usuarios> usuarios, String user, String pass){
    if(user.equals(usuarios.get(0).getUser())&&pass.equals(usuarios.get(0).getPass())){
      JOptionPane.showMessageDialog(this, "No está permitido eliminar esta cuenta", "MENSAJE DE ERROR", JOptionPane.ERROR_MESSAGE);
      return true;
    }
    else{
      return false;
    }
  }
}
