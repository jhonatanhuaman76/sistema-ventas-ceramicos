package ventas;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.text.DecimalFormat;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import menu.GuiMenuTienda;
import personalizar.CustomCeldasRenderer;
import personalizar.CustomHeaderRenderer;

public class PanelEstadisticas extends JPanel {
  private JLabel lblNewLabel;
  private JTable table;
  private JScrollPane scrollPane;
  private DecimalFormat df = new DecimalFormat("#.##");
  DefaultTableModel mt;

  /**
   * Create the panel.
   */
  public PanelEstadisticas() {
    setLayout(null);
    setBounds(0, 0, 964, 420);

    UIManager.put("Table.rowHeight", 300);
    UIManager.put("Table.intercellSpacing", new Dimension(1,0));
    UIManager.put("TableHeader.background", new Color(13, 27, 42));
    UIManager.put("TableHeader.foreground", new Color(241, 250, 238));
    UIManager.put("TableHeader.hoverForeground", new Color(241, 250, 238));
    UIManager.put("TableHeader.hoverBackground",new Color(13, 27, 42));
    UIManager.put("Table.gridColor", new Color(0,0,0));
    UIManager.put("Table.showHorizontalLines", true);
    UIManager.put("Table.showVerticalLines", true);

    lblNewLabel = new JLabel("ESTAD\u00CDSTICAS SOBRE EL PRECIO");
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
    table.putClientProperty("Table.showVerticalLines", true);

    //Deshabilitamos el mover las columnas y el cambiar su tama�o
    JTableHeader tableHeader = table.getTableHeader();
    tableHeader.setReorderingAllowed(false);
    tableHeader.setResizingAllowed(false);

    //Deshabilitamos el color al seleccionar
    table.setFocusable(false);
    table.setRowSelectionAllowed(false);

    //A�adimos las columnas
    mt = new DefaultTableModel();
    String[] ids = {"Precio promedio (S/.)", "Precio mayor (S/.)", "Precio menor (S/.)"};
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

    estadisticas();
  }


  //Metodo principal de reporte estadisticas sobre el precio
  void estadisticas(){
    double prom, mayor=0, menor=0, pre;

    //Calcular precio promedio
    prom= calcularPrecioPromedio();;

    //Hallar precio mayor
    for(int i=0; i<5; i++){
      pre=obtenerPrecio(i);
      if(i==0){
        mayor =pre;
      } else if(pre>mayor){
        mayor=pre;
      }
    }

    //Halar el precio menor
    for(int i=0; i<5; i++){
      pre=obtenerPrecio(i);
      if(i==0){
        menor=pre;
      } else if(pre<menor){
        menor=pre;
      }
    }

    mostrarEstadisticas(prom, mayor, menor);
  }

  //Metodo para obtener el precio
  double obtenerPrecio(int i){
    switch(i){
    case 0: return GuiMenuTienda.precio0;
    case 1: return GuiMenuTienda.precio1;
    case 2: return GuiMenuTienda.precio2;
    case 3: return GuiMenuTienda.precio3;
    default: return GuiMenuTienda.precio4;
    }
  }

  //Metodo para calcular el precio promedio
  double calcularPrecioPromedio(){
    return (GuiMenuTienda.precio0+GuiMenuTienda.precio1+GuiMenuTienda.precio2+GuiMenuTienda.precio3+GuiMenuTienda.precio4)/5;
  }

  void mostrarEstadisticas(double prom, double mayor, double menor){
    mt.addRow(new Object[] {df.format(prom), mayor, menor});
  }
}
