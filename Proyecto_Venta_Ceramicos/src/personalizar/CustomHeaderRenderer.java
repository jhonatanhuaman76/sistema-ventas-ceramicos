package personalizar;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

//Con ayuda de esta clase establecemos un TableCellRenderer predeterminado para mejorar la apariencia visual de los encabezados
public class CustomHeaderRenderer extends DefaultTableCellRenderer {

  @Override
  public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
    Component component = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
    setHorizontalAlignment(SwingConstants.CENTER); // Alineación horizontal central
    component.setFont(new Font("Segoe UI", Font.BOLD, 12));
    setBackground(UIManager.getColor("TableHeader.background")); 
    setForeground(UIManager.getColor("TableHeader.foreground"));
    ((JComponent) component).setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 1, new java.awt.Color(255, 255, 255)));
    return component;
  }
}