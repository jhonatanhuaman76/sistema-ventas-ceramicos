package ventas;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.text.DecimalFormat;

import javax.swing.JLabel;
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

public class PanelVentasxModelo extends JPanel {
  private JLabel lblNewLabel;
  private JTable table;
  private JScrollPane scrollPane;
  private DecimalFormat df = new DecimalFormat("#.##");
  DefaultTableModel mt;

  /**
   * Create the panel.
   */
  public PanelVentasxModelo() {
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

    lblNewLabel = new JLabel("VENTAS POR MODELO");
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
    String[] ids = {"Modelo", "Cantidad de ventas", "Cantidad de cajas vendidas", "Importe total vendido (S/.)", "Aporte a la cuota diaria (%)"};
    mt.setColumnIdentifiers(ids);
    table.setModel(mt);

    //Definir un estilo personzalizado a las celas
    for(int i=0; i< table.getColumnCount(); i++){
      table.getColumnModel().getColumn(i).setCellRenderer(new CustomCeldasRenderer());
    }

    //Aplicamos un estilo personalizado al encabezado
    tableHeader.setDefaultRenderer(new CustomHeaderRenderer());
    tableHeader.setPreferredSize( new Dimension(0,20));

    table.setFillsViewportHeight(true);
    scrollPane.setViewportView(table);

    ventasModelo();
  }

  //Metodo principal de reporte ventas por mmodelo
  void ventasModelo(){
    double pcuoDia0, pcuoDia1, pcuoDia2, pcuoDia3, pcuoDia4;

    pcuoDia0=calcularAporteCuotaDiaria(GuiMenuTienda.impT0);
    pcuoDia1=calcularAporteCuotaDiaria(GuiMenuTienda.impT1);
    pcuoDia2=calcularAporteCuotaDiaria(GuiMenuTienda.impT2);
    pcuoDia3=calcularAporteCuotaDiaria(GuiMenuTienda.impT3);
    pcuoDia4=calcularAporteCuotaDiaria(GuiMenuTienda.impT4);

    mt.setRowCount(0);
    mostrarVentas(GuiMenuTienda.modelo0, GuiMenuTienda.cantVent0, GuiMenuTienda.cajasVend0, GuiMenuTienda.impT0, pcuoDia0);
    mostrarVentas(GuiMenuTienda.modelo1, GuiMenuTienda.cantVent1, GuiMenuTienda.cajasVend1, GuiMenuTienda.impT1, pcuoDia1);
    mostrarVentas(GuiMenuTienda.modelo2, GuiMenuTienda.cantVent2, GuiMenuTienda.cajasVend2, GuiMenuTienda.impT2, pcuoDia2);
    mostrarVentas(GuiMenuTienda.modelo3, GuiMenuTienda.cantVent3, GuiMenuTienda.cajasVend3, GuiMenuTienda.impT3, pcuoDia3);
    mostrarVentas(GuiMenuTienda.modelo4, GuiMenuTienda.cantVent4, GuiMenuTienda.cajasVend4, GuiMenuTienda.impT4, pcuoDia4);
  }

  //Metodo para mostrar ventas por modelo en la tabla
  void mostrarVentas(String mod, int cant, int cajas, double impT, double pcuoDia){
    mt.addRow(new Object[] {mod, cant, cajas, df.format(impT), df.format(pcuoDia)});
  }

  //Metodo para calcular porcentaje de aporte a la cuota diaria de cada modelo
  double calcularAporteCuotaDiaria( double imptT){
    return imptT / GuiMenuTienda.cuotaDiaria * 100;
  }

}
