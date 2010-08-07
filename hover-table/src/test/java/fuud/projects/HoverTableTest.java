package fuud.projects;

import org.fest.swing.data.TableCell;
import org.fest.swing.edt.FailOnThreadViolationRepaintManager;
import org.fest.swing.edt.GuiActionRunner;
import org.fest.swing.edt.GuiQuery;
import org.fest.swing.fixture.FrameFixture;
import org.fest.swing.fixture.JTableFixture;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import static junit.framework.Assert.assertEquals;

public class HoverTableTest {
    private JTableFixture table;
    private TableModel model;

    @BeforeClass
    public static void setUpOnce() {
        FailOnThreadViolationRepaintManager.install();
    }

    @Before
    public void setUp() {
        JFrame frame = GuiActionRunner.execute(new GuiQuery<JFrame>() {
            protected JFrame executeInEDT() {
                model = new DefaultTableModel(2, 2);
                for (int row = 0; row < 2; row++) {
                    for (int col = 0; col < 2; col++) {
                        model.setValueAt(row * col, row, col);
                    }
                }

                HoverTable table = new HoverTable(model);
                final JFrame frame = new JFrame();
                final JScrollPane scrollPane = new JScrollPane(table);
                scrollPane.setName("scrollpane");
                frame.getContentPane().add(scrollPane);
                return frame;
            }
        });
        FrameFixture window = new FrameFixture(frame);
        window.show(); // shows the frame to test
        table = window.table();
    }

    @Test
    public void modelWasAccepted() {
        assertEquals(model.getValueAt(0, 0).toString(), table.valueAt(TableCell.row(0).column(0)));
    }
}
