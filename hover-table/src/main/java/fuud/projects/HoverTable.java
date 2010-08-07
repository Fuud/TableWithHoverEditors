package fuud.projects;

import org.apache.log4j.Logger;

import javax.swing.*;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;
import java.util.Vector;

public class HoverTable extends JTable {
    private static final Logger logger = Logger.getLogger(HoverTable.class);

    public HoverTable() {
    }

    public HoverTable(TableModel dm) {
        super(dm);
    }

    public HoverTable(TableModel dm, TableColumnModel cm) {
        super(dm, cm);
    }

    public HoverTable(TableModel dm, TableColumnModel cm, ListSelectionModel sm) {
        super(dm, cm, sm);
    }

    public HoverTable(int numRows, int numColumns) {
        super(numRows, numColumns);
    }

    public HoverTable(Object[][] rowData, Object[] columnNames) {
        super(rowData, columnNames);
    }

    public HoverTable(Vector rowData, Vector columnNames) {
        super(rowData, columnNames);
    }

    static{
        logger.trace("class HoverTable loaded");
    }

    public static void main(String[] arguments) {
            
    }
}
