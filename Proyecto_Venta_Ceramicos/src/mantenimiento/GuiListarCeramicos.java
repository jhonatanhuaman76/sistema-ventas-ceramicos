package mantenimiento;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatArcDarkContrastIJTheme;
import com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatMaterialLighterIJTheme;

import menu.GuiMenuTienda;
import personalizar.CustomCeldasRenderer;
import personalizar.CustomHeaderRenderer;
import menu.GuiMenuTienda;

import javax.swing.JTextArea;
import javax.swing.UIManager;

import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.ScrollPane;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;

import java.awt.Color;
import java.awt.Cursor;

public class GuiListarCeramicos extends JDialog implements ActionListener {
  private JButton btnCerrar;
  private JButton btnListar;
  private JTable table;
  private JLabel lblListarCermicos;
  private JScrollPane scrollPane;
  DefaultTableModel mt;

  /**
   * Launch the application.
   */
  public static void main(String[] args) {
    try {
      GuiListarCeramicos dialog = new GuiListarCeramicos(null, true);
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
  public GuiListarCeramicos(GuiMenuTienda menu, boolean b) {
    super(menu, b); //Bloquea la ventana hasta que la cierren
    setTitle("Listar Cer\u00E1micos");
    setBounds(100, 100, 624, 485);
    setResizable(false);
    FlatMaterialLighterIJTheme.setup();
    UIManager.put( "Button.arc", 10);
    UIManager.put("Table.rowHeight", 60);
    UIManager.put("Table.intercellSpacing", new Dimension(1,0));
    UIManager.put("TableHeader.background", new Color(13, 27, 42));
    UIManager.put("TableHeader.foreground", new Color(241, 250, 238));
    UIManager.put("TableHeader.hoverForeground", new Color(241, 250, 238));
    UIManager.put("TableHeader.hoverBackground",new Color(13, 27, 42));
    UIManager.put("Table.gridColor", new Color(0,0,0));
    UIManager.put("Table.showHorizontalLines", true);
    UIManager.put("Table.showVerticalLines", false);
    getContentPane().setLayout(null);

    btnCerrar = new JButton("Cerrar");
    btnCerrar.setForeground(Color.WHITE);
    btnCerrar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    btnCerrar.setBorderPainted(false);
    btnCerrar.setBounds(320, 402, 110, 30);
    btnCerrar.setBackground(Color.decode("#370617"));
    getContentPane().add(btnCerrar);

    btnListar = new JButton("Listar");
    btnListar.setForeground(Color.WHITE);
    btnListar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    btnListar.setBorderPainted(false);
    btnListar.setBounds(183, 402, 110, 30);
    btnListar.setBackground(Color.decode("#03071E"));
    getContentPane().add(btnListar);

    scrollPane = new JScrollPane();
    scrollPane.setBounds(20, 65, 578, 326);
    getContentPane().add(scrollPane);

    //Deshabilitamos las celdas
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

    //Deshabilitamos el color al seleccionar
    table.setFocusable(false);
    table.setRowSelectionAllowed(false);

    //Añadimos las columnas
    mt = new DefaultTableModel();
    String ids[] = {"Modelo", "Precio (S/.)", "Ancho (cm)", "Largo (cm)", "Espesor (mm)", "Contenido", "Stock"};
    mt.setColumnIdentifiers(ids);
    table.setModel(mt);

    //Definir un estilo personalizado a las celdas
    for(int i=0; i < table.getColumnCount();i++ ){
      table.getColumnModel().getColumn(i).setCellRenderer(new CustomCeldasRenderer());
    }

    //Aplicamos un estilo personalizado al encabezado  
    tableHeader.setDefaultRenderer(new CustomHeaderRenderer());
    tableHeader.setPreferredSize( new Dimension(0,20));

    table.setFillsViewportHeight(true);
    scrollPane.setViewportView(table);

    lblListarCermicos = new JLabel("LISTAR CER\u00C1MICOS");
    lblListarCermicos.setFont(new Font("Tahoma", Font.BOLD, 24));
    lblListarCermicos.setBounds(188, 24, 242, 29);
    getContentPane().add(lblListarCermicos);
    btnListar.addActionListener(this);
    btnCerrar.addActionListener(this);

    setIconImage(new ImageIcon(getClass().getResource("/images/icono.png")).getImage());

  }

  public void actionPerformed(ActionEvent arg0) {
    if (arg0.getSource() == btnCerrar) {
      actionPerformedBtnCerrar(arg0);
    }
    if (arg0.getSource() == btnListar) {
      actionPerformedBtnListar(arg0);
    }
  }

  protected void actionPerformedBtnCerrar(ActionEvent arg0) {
    dispose();
  }

  protected void actionPerformedBtnListar(ActionEvent arg0) {
    listarCeramicos();
  }

  //METODOS

  //Metodo para imprimir todos los ceramicos
  void listarCeramicos(){
    mt.setRowCount(0);
    mostrarCeramicos(GuiMenuTienda.modelo0, GuiMenuTienda.precio0, GuiMenuTienda.ancho0, GuiMenuTienda.largo0, GuiMenuTienda.espesor0, GuiMenuTienda.contenido0, GuiMenuTienda.stock0);
    mostrarCeramicos(GuiMenuTienda.modelo1, GuiMenuTienda.precio1, GuiMenuTienda.ancho1, GuiMenuTienda.largo1, GuiMenuTienda.espesor1, GuiMenuTienda.contenido1, GuiMenuTienda.stock1);
    mostrarCeramicos(GuiMenuTienda.modelo2, GuiMenuTienda.precio2, GuiMenuTienda.ancho2, GuiMenuTienda.largo2, GuiMenuTienda.espesor2, GuiMenuTienda.contenido2, GuiMenuTienda.stock2);
    mostrarCeramicos(GuiMenuTienda.modelo3, GuiMenuTienda.precio3, GuiMenuTienda.ancho3, GuiMenuTienda.largo3, GuiMenuTienda.espesor3, GuiMenuTienda.contenido3, GuiMenuTienda.stock3);
    mostrarCeramicos(GuiMenuTienda.modelo4, GuiMenuTienda.precio4, GuiMenuTienda.ancho4, GuiMenuTienda.largo4, GuiMenuTienda.espesor4, GuiMenuTienda.contenido4, GuiMenuTienda.stock4);
  }

  //Metodo para mostrar datos de ceramico
  void mostrarCeramicos(String mod, double pre, double an, double la, double esp, int co, int st){
    mt.addRow(new Object[] {mod, pre, an, la, esp, co, st});
  }
}
