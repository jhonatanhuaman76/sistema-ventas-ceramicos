package ventas;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatArcDarkContrastIJTheme;
import com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatMaterialLighterIJTheme;

import menu.GuiMenuTienda;
import personalizar.CustomCeldasRenderer;
import personalizar.CustomHeaderRenderer;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.awt.event.KeyEvent;
import java.awt.Color;
import javax.swing.border.LineBorder;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.JTable;

public class GuiVender extends JDialog implements ActionListener, KeyListener {

  private final JPanel contentPanel = new JPanel();
  private JTextField txtPre;
  private JTextField txtCant;
  private JComboBox cboMod;
  private JButton btnVender;
  private JButton btnCerrar;
  private JTextField txtStock;
  private JLabel lblStock;
  private JButton btnActualizar;
  private JButton btnAnadir;
  private JButton btnEliminar;
  private JButton btnNuevo;
  private JPanel panel_1;
  private JPanel panel;
  private JLabel label_3;
  private JLabel lblRuc;
  private JLabel lblNumVent;
  private JLabel lblSeores;
  private JTextField txtCliente;
  private JLabel lblDe;
  private JLabel lblJr;
  private JLabel lblDireccin;
  private JTextField txtDireccion;
  private JLabel lblDocumento;
  private JTextField txtDocumento;
  private JLabel lblFecha;
  private JTextField txtFecha;
  private JTable table;
  private JScrollPane scrollPane;
  private DefaultTableModel mt;
  private JLabel label;
  private JPanel panel_2;
  private JLabel lblTotalAPagar;
  private JTextField txtTotal;
  private DecimalFormat df = new DecimalFormat("#.##");


  /**
   * Launch the application.
   */
  public static void main(String[] args) {
    try {
      GuiVender dialog = new GuiVender(null, true);
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
  public GuiVender(GuiMenuTienda menu, boolean b) {
    super(menu, b); //Bloquea la ventana hasta que la cierren
    setTitle("Vender");
    setBounds(100, 100, 924, 620);
    setIconImage(new ImageIcon(getClass().getResource("/images/icono.png")).getImage());
    setResizable(false);
    UIManager.put( "Button.arc", 10);
    UIManager.put("Component.focusColor", Color.decode("#9499B4"));
    UIManager.put("Table.rowHeight", 30);
    UIManager.put("Table.intercellSpacing", new Dimension(1,0));
    UIManager.put("TableHeader.background", new Color(13, 27, 42));
    UIManager.put("TableHeader.foreground", new Color(241, 250, 238));
    UIManager.put("TableHeader.hoverForeground", new Color(241, 250, 238));
    UIManager.put("TableHeader.hoverBackground",new Color(13, 27, 42));
    UIManager.put("Table.gridColor", new Color(0,0,0));
    UIManager.put("Table.showHorizontalLines", true);
    UIManager.put("Table.showVerticalLines", false);

    FlatMaterialLighterIJTheme.setup();


    getContentPane().setLayout(new BorderLayout());
    contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
    getContentPane().add(contentPanel, BorderLayout.CENTER);
    contentPanel.setLayout(null);
    {
      JLabel lblModelo = new JLabel("Modelo");
      lblModelo.setBounds(16, 27, 87, 14);
      contentPanel.add(lblModelo);
    }
    {
      JLabel lblPrecios = new JLabel("Precio (S/)");
      lblPrecios.setBounds(237, 27, 87, 14);
      contentPanel.add(lblPrecios);
    }
    {
      JLabel lblCantidad = new JLabel("Cantidad");
      lblCantidad.setBounds(16, 60, 87, 14);
      contentPanel.add(lblCantidad);
    }
    {
      cboMod = new JComboBox();
      cboMod.setBounds(77, 20, 140, 25);
      cboMod.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
      cboMod.setBorder(new LineBorder(new Color(171, 173, 179)));
      cboMod.addActionListener(this);
      cboMod.setModel(new DefaultComboBoxModel(new String[] {GuiMenuTienda.modelo0, GuiMenuTienda.modelo1, GuiMenuTienda.modelo2, GuiMenuTienda.modelo3, GuiMenuTienda.modelo4}));
      contentPanel.add(cboMod);
    }
    {
      txtPre = new JTextField();
      txtPre.setFocusable(false);
      txtPre.setBounds(302, 20, 140, 25);
      txtPre.setEditable(false);
      txtPre.setColumns(10);
      contentPanel.add(txtPre);
    }
    {
      txtCant = new JTextField();
      txtCant.setBounds(77, 55, 140, 25);
      txtCant.setBackground(Color.WHITE);
      txtCant.addKeyListener(this);
      txtCant.setColumns(10);
      contentPanel.add(txtCant);
    }
    {
      btnVender = new JButton("Vender");
      btnVender.setBounds(778, 126, 110, 30);
      btnVender.setForeground(Color.WHITE);
      btnVender.setBackground(Color.decode("#03071E"));
      btnVender.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
      btnVender.setBorderPainted(false);
      btnVender.addActionListener(this);
      contentPanel.add(btnVender);
    }
    {
      btnCerrar = new JButton("Cerrar");
      btnCerrar.setBounds(778, 208, 110, 30);
      btnCerrar.setForeground(Color.WHITE);
      btnCerrar.setBackground(Color.decode("#370617"));
      btnCerrar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
      btnCerrar.setBorderPainted(false);
      btnCerrar.addActionListener(this);
      contentPanel.add(btnCerrar);
    }

    {
      txtStock = new JTextField();
      txtStock.setFocusable(false);
      txtStock.setBounds(302, 55, 140, 25);
      txtStock.setText("");
      txtStock.setEditable(false);
      txtStock.setColumns(10);
      contentPanel.add(txtStock);
    }
    {
      lblStock = new JLabel("Stock:");
      lblStock.setBounds(237, 60, 87, 14);
      contentPanel.add(lblStock);
    }
    {
      btnActualizar = new JButton("<html><center>Actualizar<br>Producto<html>");
      btnActualizar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
      btnActualizar.addActionListener(this);
      btnActualizar.setForeground(Color.WHITE);
      btnActualizar.setBorderPainted(false);
      btnActualizar.setBackground(Color.decode("#104353"));
      btnActualizar.setBounds(569, 28, 89, 44);
      contentPanel.add(btnActualizar);
    }
    {
      btnAnadir = new JButton("<html><center>A\u00F1adir<br>Producto<html>");
      btnAnadir.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
      btnAnadir.addActionListener(this);
      btnAnadir.setForeground(Color.WHITE);
      btnAnadir.setBorderPainted(false);
      btnAnadir.setBackground(Color.decode("#104353"));
      btnAnadir.setBounds(470, 28, 89, 44);
      contentPanel.add(btnAnadir);
    }
    {
      btnEliminar = new JButton("<html><center>Eliminar<br>Producto<html>");
      btnEliminar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
      btnEliminar.addActionListener(this);
      btnEliminar.setForeground(Color.WHITE);
      btnEliminar.setBorderPainted(false);
      btnEliminar.setBackground(Color.decode("#531010"));
      btnEliminar.setBounds(668, 28, 89, 44);
      contentPanel.add(btnEliminar);
    }
    {
      btnNuevo = new JButton("Nuevo");
      btnNuevo.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
      btnNuevo.addActionListener(this);
      btnNuevo.setForeground(Color.WHITE);
      btnNuevo.setBorderPainted(false);
      btnNuevo.setBackground(new Color(3, 7, 30));
      btnNuevo.setBounds(778, 167, 110, 30);
      contentPanel.add(btnNuevo);
    }
    {
      panel_1 = new JPanel();
      panel_1.setBackground(Color.WHITE);
      panel_1.setBounds(17, 95, 740, 475);
      contentPanel.add(panel_1);
      panel_1.setLayout(null);
      {
        panel = new JPanel();
        panel.setBorder(new LineBorder(new Color(0, 0, 0)));
        panel.setLayout(null);
        panel.setBackground(Color.WHITE);
        panel.setBounds(450, 37, 267, 87);
        panel_1.add(panel);
        {
          label_3 = new JLabel("BOLETA DE VENTA");
          label_3.setForeground(Color.WHITE);
          label_3.setHorizontalAlignment(SwingConstants.CENTER);
          label_3.setFont(new Font("Tahoma", Font.BOLD, 16));
          label_3.setBounds(22, 31, 222, 26);
          panel.add(label_3);
        }
        {
          lblRuc = new JLabel("R.U.C.  20345621456");
          lblRuc.setHorizontalAlignment(SwingConstants.CENTER);
          lblRuc.setFont(new Font("Tahoma", Font.PLAIN, 16));
          lblRuc.setBounds(22, 8, 222, 22);
          panel.add(lblRuc);
        }
        {
          lblNumVent = new JLabel("N\u00B0 "+(GuiMenuTienda.cantVentG+1));
          lblNumVent.setHorizontalAlignment(SwingConstants.CENTER);
          lblNumVent.setFont(new Font("Tahoma", Font.PLAIN, 16));
          lblNumVent.setBounds(32, 56, 212, 25);
          panel.add(lblNumVent);
        }
        {
          panel_2 = new JPanel();
          panel_2.setBounds(0, 31, 267, 26);
          panel_2.setBackground(Color.decode("#03071E"));
          panel.add(panel_2);
        }
      }

      lblSeores = new JLabel("Se\u00F1or (es): ");
      lblSeores.setBounds(25, 140, 62, 20);
      panel_1.add(lblSeores);

      txtCliente = new JTextField();
      txtCliente.setBackground(Color.WHITE);
      txtCliente.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
      txtCliente.setColumns(10);
      txtCliente.setBounds(107, 140, 610, 20);
      panel_1.add(txtCliente);
      {
        lblDe = new JLabel("DE:  SANTIAGO JESUS TORRES VASQUEZ");
        lblDe.setFont(new Font("Tahoma", Font.PLAIN, 9));
        lblDe.setHorizontalAlignment(SwingConstants.CENTER);
        lblDe.setBounds(31, 100, 242, 14);
        panel_1.add(lblDe);
      }
      {
        lblJr = new JLabel("Calle Primavera 123, Ciudad del Sol, Lima");
        lblJr.setFont(new Font("Tahoma", Font.PLAIN, 9));
        lblJr.setHorizontalAlignment(SwingConstants.CENTER);
        lblJr.setBounds(31, 115, 242, 14);
        panel_1.add(lblJr);
      }
      {
        lblDireccin = new JLabel("Direcci\u00F3n: ");
        lblDireccin.setBounds(25, 171, 62, 20);
        panel_1.add(lblDireccin);
      }
      {
        txtDireccion = new JTextField();
        txtDireccion.setBackground(Color.WHITE);
        txtDireccion.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
        txtDireccion.setColumns(10);
        txtDireccion.setBounds(107, 171, 610, 20);
        panel_1.add(txtDireccion);
      }
      {
        lblDocumento = new JLabel("Documento: ");
        lblDocumento.setBounds(25, 202, 73, 20);
        panel_1.add(lblDocumento);
      }
      {
        txtDocumento = new JTextField();
        txtDocumento.setBackground(Color.WHITE);
        txtDocumento.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
        txtDocumento.setColumns(10);
        txtDocumento.setBounds(107, 202, 284, 20);
        panel_1.add(txtDocumento);
      }
      {
        lblFecha = new JLabel("Fecha: ");
        lblFecha.setBounds(418, 202, 62, 20);
        panel_1.add(lblFecha);
      }
      {
        txtFecha = new JTextField();
        txtFecha.setFocusable(false);
        txtFecha.setEditable(false);
        txtFecha.setBackground(Color.WHITE);
        txtFecha.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
        txtFecha.setColumns(10);
        txtFecha.setBounds(475, 202, 242, 20);
        panel_1.add(txtFecha);
      }
      {
        scrollPane = new JScrollPane();
        scrollPane.setBounds(25, 233, 695, 201);
        panel_1.add(scrollPane);

        table = new JTable(){
          public boolean isCellEditable(int rowIndex, int colIndex){
            return false;
          }
        };
        table.setBorder(new LineBorder(new Color(0, 0, 0)));

        //Deshabilitamos el mover las columnas y el cambiar su tamaño
        JTableHeader tableHeader = table.getTableHeader();
        tableHeader.setReorderingAllowed(false);
        tableHeader.setResizingAllowed(false);

        //Añadimos las columnas
        mt = new DefaultTableModel();
        String ids[] = {"Modelo", "Precio", "<html><center>Cantidad<br>adquirida<html>", "<html>Importe<br>compra<html>", "<html><center>Importe<br>descuento<html>", "<html><center>Importe<br>pagar<html>", "<html><center>Tipo de<br>obsequio<html>", "<html><center>Unidades <br> obsequiadas<html>"};
        mt.setColumnIdentifiers(ids);
        table.setModel(mt);

        //Definir un estilo personzalizado a las celas
        for(int i=0; i< table.getColumnCount(); i++){
          table.getColumnModel().getColumn(i).setCellRenderer(new CustomCeldasRenderer());
        }

        //Aplicamos un estilo personalizado al encabezado
        tableHeader.setDefaultRenderer(new CustomHeaderRenderer());
        tableHeader.setPreferredSize( new Dimension(0,35));


        scrollPane.setViewportView(table);
      }
      {
        label = new JLabel("");
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setIcon(new ImageIcon(GuiVender.class.getResource("/images/logoBoleta90.png")));
        label.setBounds(43, 11, 230, 90);
        panel_1.add(label);
      }
      {
        lblTotalAPagar = new JLabel("Total a pagar: ");
        lblTotalAPagar.setBounds(450, 447, 87, 20);
        panel_1.add(lblTotalAPagar);
      }
      {
        txtTotal = new JTextField();
        txtTotal.setEditable(false);
        txtTotal.setFocusable(false);
        txtTotal.setBounds(536, 445, 150, 25);
        panel_1.add(txtTotal);
        txtTotal.setColumns(10);
      }

      //Valores al iniciar la ventana
      txtPre.setText(""+GuiMenuTienda.precio0);
      txtStock.setText(""+GuiMenuTienda.stock0);
      txtCant.requestFocus();
      setDate();
    }
  }

  public void actionPerformed(ActionEvent e) {
    if (e.getSource() == btnEliminar) {
      actionPerformedBtnEliminar(e);
    }
    if (e.getSource() == btnActualizar) {
      actionPerformedBtnActualizar(e);
    }
    if (e.getSource() == btnAnadir) {
      actionPerformedBtnAnadir(e);
    }
    if (e.getSource() == btnNuevo) {
      actionPerformedBtnNuevo(e);
    }
    if (e.getSource() == btnCerrar) {
      actionPerformedBtnCerrar(e);
    }
    if (e.getSource() == btnVender) {
      actionPerformedBtnVender(e);
    }
    if (e.getSource() == cboMod) {
      actionPerformedCboMod(e);
    }
  }
  public void keyPressed(KeyEvent arg0) {
  }

  public void keyReleased(KeyEvent arg0) {
  }

  public void keyTyped(KeyEvent arg0) {
    if (arg0.getSource() == txtCant) {
      keyTypedTxtCant(arg0);
    }
  }

  //Controlando caracteres
  protected void keyTypedTxtCant(KeyEvent arg0) {
    char c = arg0.getKeyChar();
    if(c<'0' || c>'9') arg0.consume();
  }

  protected void actionPerformedBtnAnadir(ActionEvent e) {
    anadirProducto(txtCant.getText(), "\\d+");
  }

  protected void actionPerformedBtnActualizar(ActionEvent e) {
    actualizarProducto(txtCant.getText(), "\\d+");
  }

  protected void actionPerformedBtnEliminar(ActionEvent e) {
    eliminarProducto();
  }

  protected void actionPerformedCboMod(ActionEvent e) {
    seleccionarPrecioStock();
  }

  protected void actionPerformedBtnVender(ActionEvent e) {
    generarVenta();
  }

  protected void actionPerformedBtnCerrar(ActionEvent e) {
    dispose();
  }

  protected void actionPerformedBtnNuevo(ActionEvent e) {
    limpiarBoletaVenta();
  }

  //METODOS

  // Leer indice del modelo
  int leerModelo() {
    return cboMod.getSelectedIndex();
  }

  //Seleccionar precio y stock a mostrar
  void seleccionarPrecioStock(){
    switch(leerModelo()){
    case 0:
      txtPre.setText(""+GuiMenuTienda.precio0);
      txtStock.setText(""+GuiMenuTienda.stock0);
      break;
    case 1:
      txtPre.setText(""+GuiMenuTienda.precio1);
      txtStock.setText(""+GuiMenuTienda.stock1);
      break;
    case 2:
      txtPre.setText(""+GuiMenuTienda.precio2);
      txtStock.setText(""+GuiMenuTienda.stock2);
      break;
    case 3:
      txtPre.setText(""+GuiMenuTienda.precio3);
      txtStock.setText(""+GuiMenuTienda.stock3);
      break;
    default:
      txtPre.setText(""+GuiMenuTienda.precio4);
      txtStock.setText(""+GuiMenuTienda.stock4);
    }

    txtCant.requestFocus(true);
  }

  //Metodo de btnAñadir
  void anadirProducto(String cajaCant, String exr){
    if(validarCantidad(cajaCant, exr)){
      efectuarCalculos(0);
    }
    txtCant.requestFocus(true);
  }

  //Metodo pde btnActualizar
  void actualizarProducto(String cajaCant, String exr){
    if(validarTabla()&&validarSeleccion("Seleccione un producto para actualizarlo")&&validarCantidad(cajaCant, exr)){
      efectuarCalculos(1);
      txtTotal.setText(""+df.format(totalPagar()));
      txtCant.setText("");
      JOptionPane.showMessageDialog(this, "Producto actualizado" , "MENSAJE INFORMATIVO", JOptionPane.INFORMATION_MESSAGE);
    }
    txtCant.requestFocus(true);
  }

  //Metodo para el btnEliminar
  void eliminarProducto(){
    if(validarTabla()&&validarSeleccion("Seleccione un producto para eliminarlo")){
      mt.removeRow(table.getSelectedRow());
      txtTotal.setText(""+df.format(totalPagar()));
      txtCant.setText("");
      JOptionPane.showMessageDialog(this, "Producto eliminado", "MENSAJE INFORMATIVO", JOptionPane.INFORMATION_MESSAGE);
    }
    txtCant.requestFocus(true);
  }

  //Metodo de btnVender
  void generarVenta(){
    if(validarTabla()&&validarCamposTextos()&&validarVentaStock()){
      efectuarIncrementosDecrementos();
      seleccionarPrecioStock();
      contarVentas();
      txtTotal.setText(""+df.format(totalPagar()));
      txtCant.setText("");
      JOptionPane.showMessageDialog(this, "Venta realizada", "MENSAJE INFORMATIVO", JOptionPane.INFORMATION_MESSAGE);
      mostrarMensaje();
      setNumVent();
    }
    txtCant.requestFocus(true);
  }

  //Metodo para limpiar las cajas de texto y la tabla - btnNuevo
  void limpiarBoletaVenta(){
    txtCant.setText("");
    txtCliente.setText("");
    txtDireccion.setText("");
    txtDocumento.setText("");
    txtTotal.setText("");

    int rows= table.getRowCount()-1;
    for(int i= rows; i>=0; i--){
      mt.removeRow(i);
    }
    txtCant.requestFocus(true);

    JOptionPane.showMessageDialog(this, "Boleta de venta limpiada", "MENSAJE INFORMATIVO", JOptionPane.INFORMATION_MESSAGE);
  }

  //Metodo para realizar calculos
  void efectuarCalculos(int result){
    double pre, ic, des, ip;
    int canti, obs;
    String mod, pro;

    //Entrada de datos
    pre=Double.parseDouble(txtPre.getText());
    canti=Integer.parseInt(txtCant.getText());
    mod=cboMod.getSelectedItem().toString();

    //Proceso
    ic=calcularImporteCompra(pre, canti);
    des=calcularDescuento(ic, canti);
    ip=calcularImportePargar(ic, des);
    obs=asignarObsequio(canti);

    switch(result){
    case 0:
      //Validar si la tabla está vacía para añadir el producto
      if(table.getRowCount()==0){
        mostrarResultadosTable(mod, pre, ic, des, ip, canti, GuiMenuTienda.tipoObsequio, obs);
        txtTotal.setText(""+df.format(totalPagar()));
        txtCant.setText("");
        JOptionPane.showMessageDialog(this, "Producto añadido", "MENSAJE INFORMATIVO", JOptionPane.INFORMATION_MESSAGE);
      }
      //Validar si existe el producto en la tabla
      else if(validarProducto(mod)==true){
        JOptionPane.showMessageDialog(this, "El producto ya existe. Actualícelo", "MENSAJE DE ERROR", JOptionPane.ERROR_MESSAGE);
      } else{
        mostrarResultadosTable(mod, pre, ic, des, ip, canti, GuiMenuTienda.tipoObsequio, obs);
        txtTotal.setText(""+df.format(totalPagar()));
        txtCant.setText("");
        JOptionPane.showMessageDialog(this, "Producto añadido", "MENSAJE INFORMATIVO", JOptionPane.INFORMATION_MESSAGE);
      }
      break;
    case 1:
      pro = (String) table.getValueAt(table.getSelectedRow(), 0);

      //Actualizar datos de la fila
      mt.setValueAt(txtCant.getText(), table.getSelectedRow(), 2);
      mt.setValueAt(df.format(ic), table.getSelectedRow(), 3);
      mt.setValueAt(df.format(des), table.getSelectedRow(), 4);
      mt.setValueAt(df.format(ip), table.getSelectedRow(), 5);
      mt.setValueAt(obs, table.getSelectedRow(), 7);
      break;
    }
  }

  //Calcular Importe de Compra
  double calcularImporteCompra(double pre, int canti){
    return pre*canti;
  }

  //Calcular Descuento
  double calcularDescuento(double ic, int canti){
    if(canti>=1&&canti<=5){
      return ic*GuiMenuTienda.porcentaje1/100;
    } else if (canti>6&&canti<=10) {
      return ic*GuiMenuTienda.porcentaje2/100;
    } else if(canti>=11&&canti<=15) {
      return ic*GuiMenuTienda.porcentaje3/100;
    } else{
      return ic*GuiMenuTienda.porcentaje4/100;
    }
  }

  //Calcular importe a pagar
  double calcularImportePargar( double ic, double des){
    return ic-des;
  }

  //Asignar obsequio
  int asignarObsequio(int canti){
    if(canti>=1&&canti<=5){
      return canti*GuiMenuTienda.obsequioCantidad1;
    }else if(canti>6&&canti<=10){
      return canti*GuiMenuTienda.obsequioCantidad2;
    }else{
      return canti*GuiMenuTienda.obsequioCantidad3;
    }
  }

  //Metodo para mostrar resultados en la tabla
  void mostrarResultadosTable(String mod, double pre, double ic, double des, double ip,  int cant, String tipoObs, int obs){
    mt.addRow(new Object[] {mod, pre, cant, df.format(ic), df.format(des), df.format(ip), tipoObs, obs}); 
  }

  //Metodo para efectuar incrementos y Decrementos
  void efectuarIncrementosDecrementos(){
    for(int i=0; i<table.getRowCount(); i++){
      String pro = (String) table.getValueAt(i, 0);
      int cant = Integer.parseInt(table.getValueAt(i, 2).toString());
      double ip = Double.parseDouble(table.getValueAt(i, 5).toString());;


      if(pro.equals(GuiMenuTienda.modelo0)){
        GuiMenuTienda.cantVent0++;
        GuiMenuTienda.impT0+=ip;
        GuiMenuTienda.cajasVend0+=cant;
        GuiMenuTienda.stock0-=cant;
      }
      else if(pro.equals(GuiMenuTienda.modelo1)){
        GuiMenuTienda.cantVent1++;
        GuiMenuTienda.impT1+=ip;
        GuiMenuTienda.cajasVend1+=cant;
        GuiMenuTienda.stock1-=cant;
      }
      else if(pro.equals(GuiMenuTienda.modelo2)){
        GuiMenuTienda.cantVent2++;
        GuiMenuTienda.impT2+=ip;
        GuiMenuTienda.cajasVend2+=cant;
        GuiMenuTienda.stock2-=cant;
      }
      else if(pro.equals(GuiMenuTienda.modelo3)){
        GuiMenuTienda.cantVent3++;
        GuiMenuTienda.impT3+=ip;
        GuiMenuTienda.cajasVend3+=cant;
        GuiMenuTienda.stock3-=cant;
      }
      else{
        GuiMenuTienda.cantVent4++;
        GuiMenuTienda.impT4+=ip;
        GuiMenuTienda.cajasVend4+=cant;
        GuiMenuTienda.stock4-=cant;
      }
    }
  }

  //Metodo para sacar el total a pagar cuando se hace cambios
  double totalPagar(){
    double totalPagar=0;
    for(int i=0; i<table.getRowCount(); i++){
      double ip = Double.parseDouble(table.getValueAt(i, 5).toString());;
      totalPagar+=ip;
    }
    return totalPagar;
  }

  //Metodo para contar ventas
  void contarVentas(){
    GuiMenuTienda.cantVentG++;
    GuiMenuTienda.impTG= GuiMenuTienda.impT0 + GuiMenuTienda.impT1 + GuiMenuTienda.impT2 + GuiMenuTienda.impT3 + GuiMenuTienda.impT4;
    GuiMenuTienda.pcuoDiaG = GuiMenuTienda.impTG / GuiMenuTienda.cuotaDiaria * 100;
  }

  //Metodo para mostrar mensaje cada 5 ventas
  void mostrarMensaje(){
    if(GuiMenuTienda.cantVentG%5==0){
      JOptionPane.showMessageDialog(this, "Venta Nro. "+GuiMenuTienda.cantVentG+"\n"+"Importe total general acumulado: S/" + df.format(GuiMenuTienda.impTG)+"\n"+"Porcentaje de la cuota diaria "+df.format(GuiMenuTienda.pcuoDiaG)+"%", "AVANCE DE VENTAS", JOptionPane.INFORMATION_MESSAGE);
    }
  }

  //Metodo para validar si el producto existe
  boolean validarProducto(String mod){
    for(int i=0; i<table.getRowCount(); i++){
      if(table.getValueAt(i, 0).equals(mod)){
        return true;
      }
    }
    return false;
  }

  //Validando la caja de texto de cantidad
  boolean validarCantidad(String cajaCant, String exr){
    //Validar si está vacío
    if(cajaCant.isEmpty()){
      JOptionPane.showMessageDialog(this, "Ingrese una cantidad", "MENSAJE DE ERROR", JOptionPane.ERROR_MESSAGE);
      return false;
    }
    //Validar si puede ser convertido a numero entero positivo
    else if(!(cajaCant.matches(exr))){
      JOptionPane.showMessageDialog(this, "La cantidad no es válida", "MENSAJE DE ERROR", JOptionPane.ERROR_MESSAGE);
      return false;
    }
    //Validar si es mayor a 0
    else if( !(Double.parseDouble(cajaCant) > 0)){
      JOptionPane.showMessageDialog(this, "La cantidad debe ser mayor a 0","MENSAJE DE ERROR", JOptionPane.ERROR_MESSAGE);
      return false;
    }
    else if(Double.parseDouble(cajaCant) > Integer.parseInt(txtStock.getText())){
      JOptionPane.showMessageDialog(this, "La cantidad supera el Stock", "MENSAJE DE ERROR", JOptionPane.ERROR_MESSAGE);
      return false;
    }else{
      return true;
    }
  }

  //Metodo para validar si existen datos en la tabla
  boolean validarTabla(){
    if(table.getRowCount()==0){
      JOptionPane.showMessageDialog(this, "No hay productos en la tabla", "MENSAJE DE ERROR", JOptionPane.ERROR_MESSAGE);
      return false;
    } else{
      return true;
    }
  }

  //Metodo para validar si ha seleccionado un producto
  boolean validarSeleccion(String s){
    if(table.getSelectedRow()==-1){
      JOptionPane.showMessageDialog(this, s, "MENSAJE DE ERROR" ,JOptionPane.ERROR_MESSAGE);
      return false;
    } else{
      return true;
    }
  }

  //Metodo para validar si los demás campos están vacíos
  boolean validarCamposTextos(){
    String cliente, direccion, documento;
    cliente = txtCliente.getText();
    direccion = txtDireccion.getText();
    documento = txtDocumento.getText();

    if(cliente.isEmpty()||direccion.isEmpty()||documento.isEmpty()){
      JOptionPane.showMessageDialog(this, "Hay campos vacíos.\n Compruebe los campos de cliente, direccion y documento", "MENSAJE DE ERROR", JOptionPane.ERROR_MESSAGE);
      return false;
    }
    else{
      return true;
    }
  }

  //Metodo para establecer fecha
  void setDate(){
    LocalDate now = LocalDate.now();
    Locale spanishLocale = new Locale("es", "ES");

    txtFecha.setText(now.format(DateTimeFormatter.ofPattern("dd / MM / yyyy", spanishLocale)));
  }

  //Metodo para establecer numero de venta
  void setNumVent(){
    lblNumVent.setText("N\u00B0 "+(GuiMenuTienda.cantVentG+1));
  }

  //Metodo para validar stock al momento de vender
  boolean validarVentaStock(){
    for(int i=0; i<table.getRowCount(); i++){
      String pro = (String) table.getValueAt(i, 0);
      int cant = Integer.parseInt(table.getValueAt(i, 2).toString());
      String s="La cantidad del producto "+pro+" supera el stock";;

      if(pro.equals(GuiMenuTienda.modelo0)&&cant>GuiMenuTienda.stock0){
        JOptionPane.showMessageDialog(this, s, "MENSAJE DE ERROR", JOptionPane.ERROR_MESSAGE);
        return false;
      }
      else if(pro.equals(GuiMenuTienda.modelo1)&&cant>GuiMenuTienda.stock1){
        JOptionPane.showMessageDialog(this, s, "MENSAJE DE ERROR", JOptionPane.ERROR_MESSAGE);
        return false;
      }
      else if(pro.equals(GuiMenuTienda.modelo2)&&cant>GuiMenuTienda.stock2){
        JOptionPane.showMessageDialog(this, s, "MENSAJE DE ERROR", JOptionPane.ERROR_MESSAGE);
        return false;
      }
      else if(pro.equals(GuiMenuTienda.modelo3)&&cant>GuiMenuTienda.stock3){
        JOptionPane.showMessageDialog(this, s, "MENSAJE DE ERROR", JOptionPane.ERROR_MESSAGE);
        return false;
      }
      else if(pro.equals(GuiMenuTienda.modelo4)&&cant>GuiMenuTienda.stock4){
        JOptionPane.showMessageDialog(this, s, "MENSAJE DE ERROR", JOptionPane.ERROR_MESSAGE);
        return false;
      }
    }

    return true;
  }
}

