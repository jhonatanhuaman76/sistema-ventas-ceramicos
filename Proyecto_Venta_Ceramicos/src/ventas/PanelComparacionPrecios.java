package ventas;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.text.DecimalFormat;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;

import menu.GuiMenuTienda;
import personalizar.CustomCeldasRenderer;
import personalizar.CustomHeaderRenderer;

public class PanelComparacionPrecios extends JPanel {
  private JLabel lblNewLabel;
  private JTable table;
  private JScrollPane scrollPane;
  private DecimalFormat df = new DecimalFormat("#.##");
  DefaultTableModel mt;

  /**
   * Create the panel.
   */
  public PanelComparacionPrecios() {
    setLayout(null);
    setBounds(0, 0, 964, 420);

    UIManager.put("Table.rowHeight", 60);
    UIManager.put("Table.intercellSpacing", new Dimension(1,0));
    UIManager.put("TableHeader.background", new Color(13, 27, 42));
    UIManager.put("TableHeader.foreground", new Color(241, 250, 238));
    UIManager.put("TableHeader.hoverForeground", new Color(241, 250, 238));
    UIManager.put("TableHeader.hoverBackground",new Color(13, 27, 42));
    UIManager.put("Table.gridColor", new Color(0,0,0));
    UIManager.put("Table.showHorizontalLines", true);
    UIManager.put("Table.showVerticalLines", false);

    lblNewLabel = new JLabel("COMPARACI\u00D3N DE PRECIOS CON EL PRECIO PROMEDIO");
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

    //Deshabilitamos el mover las columnas y el cambiar su tamaño
    JTableHeader tableHeader = table.getTableHeader();
    tableHeader.setReorderingAllowed(false);
    tableHeader.setResizingAllowed(false);

    //Deshabilitamos el color al seleccionar
    table.setFocusable(false);
    table.setRowSelectionAllowed(false);

    //Añadimos las columnas
    mt = new DefaultTableModel();
    String[] ids = {"Modelo", "Precio (S/.)", "Precio promedio (S/.)", "Comparaci\u00F3n"};
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

    comparacionPrecios();
  }

  //Metodo principal del reporte comparacion de precios con el precio promedio
  void comparacionPrecios(){
    double prom;
    int comp;

    //Calculando precio promedio
    prom= calcularPrecioPromedio();

    compararPrecio(GuiMenuTienda.modelo0, GuiMenuTienda.precio0, prom);
    compararPrecio(GuiMenuTienda.modelo1, GuiMenuTienda.precio1, prom);
    compararPrecio(GuiMenuTienda.modelo2, GuiMenuTienda.precio2, prom);
    compararPrecio(GuiMenuTienda.modelo3, GuiMenuTienda.precio3, prom);
    compararPrecio(GuiMenuTienda.modelo4, GuiMenuTienda.precio4, prom);
  }

  //Metodo para calcular el precio promedio
  double calcularPrecioPromedio(){
    return (GuiMenuTienda.precio0+GuiMenuTienda.precio1+GuiMenuTienda.precio2+GuiMenuTienda.precio3+GuiMenuTienda.precio4)/5;
  }


  //Metodo para comparar precios
  void compararPrecio(String mod, double pre, double prom){
    String co;
    double dif;

    if(pre==prom){
      co="Es igual al promedio";
    } else if(pre>prom){
      dif=pre-prom;
      co="S/."+df.format(dif)+" m\u00E1s que el promedio";
    } else{
      dif=prom-pre;
      co="S/."+df.format(dif)+" menos que el promedio";
    }

    mostrarComparaconPrecios(mod, pre, prom, co);
  }

  void mostrarComparaconPrecios(String mod, double pre, double prom, String co){
    mt.addRow(new Object[] {mod, pre, df.format(prom), co});
  }
}
