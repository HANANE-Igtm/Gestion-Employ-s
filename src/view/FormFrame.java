package view;

import javax.swing.*;
import java.awt.*;

public class FormFrame extends JFrame {

    private InputPanel inPanel;
    private BtnPanel btnPanel;
    private ListPanel listPanel;

    public FormFrame() {
        setTitle("Person Form");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        inPanel = new InputPanel();
        btnPanel = new BtnPanel();
        listPanel = new ListPanel();

        add(inPanel, BorderLayout.NORTH);
        add(btnPanel, BorderLayout.SOUTH);

        JScrollPane scrollPane = new JScrollPane(listPanel);
        add(scrollPane, BorderLayout.CENTER);

        setVisible(true);
    }

    public InputPanel getInPanel() {
        return inPanel;
    }

    public BtnPanel getBtnPanel() {
        return btnPanel;
    }

    public ListPanel getListPanel() {
        return listPanel;
    }
}
