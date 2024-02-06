package ventas;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import menu.GuiMenuTienda;
import personalizar.CustomCeldasRenderer;
import personalizar.CustomHeaderRenderer;

import java.awt.Font;
import java.text.DecimalFormat;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.Color;
import java.awt.Dimension;

public class PanelComparacionCajas extends JPanel {
  private JLabel lblNewLabel;
  private JTable table;
  private JScrollPane scrollPane;
  DefaultTableModel mt;

  /**
   * Create the panel.
   */
  public PanelComparacionCajas() {
    setLayout(null);
    setBounds(0, 0, 964,420);

    UIManager.put("Table.rowHeight", 60);
    UIManager.put("Table.intercellSpacing", new Dimension(1,0));
    UIManager.put("TableHeader.background", new Color(13, 27, 42));
    UIManager.put("TableHeader.foreground", new Color(241, 250, 238));
    UIManager.put("TableHeader.hoverForeground", new Color(241, 250, 238));
    UIManager.put("TableHeader.hoverBackground",new Color(13, 27, 42));
    UIManager.put("Table.gridColor", new Color(0,0,0));
    UIManager.put("Table.showHorizontalLines", true);
    UIManager.put("Table.showVerticalLines", false);

    lblNewLabel = new JLabel("COMPARACI\u00D3N DE CAJAS VENDIDAS CON LA CANTIDAD \u00D3PTIMA");
    lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
    lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
    lblNewLabel.setBounds(10, 23, 944, 25);
    add(lblNewLabel);

    scrollPane = new JScrollPane();
    scrollPane.setBounds(10, 59, 944, 326);
    add(scrollPane);

    //Deshabilitamos las celdas
    table = new JTable(){
      public boolean isCellEditable(int rowIndex, int colIndex){
        return false;
      }
    };
    table.setBorder(new LineBorder(new Color(0, 0, 0)));

    //Deshabilitamos el mover las columnas y el cambiar su tama�o
    JTableHeader tableHeader = table.getTableHeader();
    tableHeader.setReorderingAllowed(false);
    tableHeader.setResizingAllowed(false);

    //Deshabilitamos el color al seleccionar
    table.setFocusable(false);
    table.setRowSelectionAllowed(false);

    //A�adimos las columnas
    mt = new DefaultTableModel();
    String[] ids = {"Modelo", "Cantidad de cajas vendidas", "Cantidad \u00F3ptima", "Comparaci\u00F3n"};
    mt.setColumnIdentifiers(ids);
    table.setModel(mt);

    //Definimos el ancho de la 4ta columna
    table.getColumnModel().getColumn(3).setPreferredWidth(300);

    //Definir un estilo personalizado a las celdas
    for(int i=0; i < table.getColumnCount();i++ ){
      table.getColumnModel().getColumn(i).setCellRenderer(new CustomCeldasRenderer());
    }

    //Aplicamos un estilo personalizado al encabezado
    tableHeader.setDefaultRenderer(new CustomHeaderRenderer());
    tableHeader.setPreferredSize( new Dimension(0,20));

    table.setFillsViewportHeight(true);
    scrollPane.setViewportView(table);

    comparacionCajasVendidas();
  }


  //Metodo principal de reporte compararcion de cajas vendidas con la cantidad optima
  void comparacionCajasVendidas(){
    compararCajasVendidas(GuiMenuTienda.modelo0, GuiMenuTienda.cajasVend0);
    compararCajasVendidas(GuiMenuTienda.modelo1, GuiMenuTienda.cajasVend1);
    compararCajasVendidas(GuiMenuTienda.modelo2, GuiMenuTienda.cajasVend2);
    compararCajasVendidas(GuiMenuTienda.modelo3, GuiMenuTienda.cajasVend3);
    compararCajasVendidas(GuiMenuTienda.modelo4, GuiMenuTienda.cajasVend4);
  }

  void compararCajasVendidas(String mod, int cajaV){
    String co;
    int dif, cantOp;

    cantOp=GuiMenuTienda.cantidadOptima;

    if(cajaV==cantOp){
      co="igual que la cantidad \u00F3ptima";
    } else if(cajaV>cantOp){
      dif=cajaV-cantOp;
      co=dif+" m\u00E1s que la cantidad \u00F3ptima";
    } else {
      dif=cantOp-cajaV;
      co=dif+" menos que la cantidad \u00F3ptima";
    }

    mostrarComparaconCajasVendidas(mod, cajaV, cantOp, co);
  }

  void mostrarComparaconCajasVendidas(String mod, int cajaV, int cantOp, String co){
    mt.addRow(new Object[] {mod, cajaV, cantOp, co});
  }
}
