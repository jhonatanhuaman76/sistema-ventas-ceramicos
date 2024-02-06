package personalizar;

import javax.swing.table.DefaultTableCellRenderer;import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;

//Con ayuda de esta clase establecemos un TableCellRenderer predeterminado para mejorar la apariencia visual de las celdas
public class CustomCeldasRenderer extends DefaultTableCellRenderer {

  @Override
  public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column){
    Component component = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

    setHorizontalAlignment(SwingConstants.CENTER);
    return component;
  }
}
