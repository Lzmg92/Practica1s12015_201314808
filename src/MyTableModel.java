import javax.swing.table.DefaultTableModel;

/**
 * Created by Leslie on 24/02/2015.
 */
public class MyTableModel extends DefaultTableModel {

    public MyTableModel(Object[][] data, Object[] columnNames) {
        super(data, columnNames);
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        Class<?> clazz = Object.class;
        Object aux = getValueAt(0, columnIndex);
        if (aux != null) {
            clazz = aux.getClass();
        }

        return clazz;
    }
}
