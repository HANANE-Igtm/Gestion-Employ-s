package view;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import model.Employer;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ListPanel extends JPanel {

    private JPanel contentPanel;
    private int selectedRowId = -1;
    private List<JPanel> rowPanels = new ArrayList<>();

    public ListPanel() {
        setLayout(new BorderLayout());

        JPanel titlePanel = new JPanel();
        titlePanel.setLayout(new GridLayout(1, 5));
        titlePanel.add(new JLabel("Id", SwingConstants.CENTER));
        titlePanel.add(new JLabel("Nom", SwingConstants.CENTER));
        titlePanel.add(new JLabel("Prenom", SwingConstants.CENTER));
        titlePanel.add(new JLabel("Email", SwingConstants.CENTER));
        titlePanel.add(new JLabel("Salaire", SwingConstants.CENTER));
        titlePanel.setBorder(new LineBorder(Color.BLACK));
        add(titlePanel, BorderLayout.NORTH);

        contentPanel = new JPanel();
        contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));
        JScrollPane scrollPane = new JScrollPane(contentPanel);
        add(scrollPane, BorderLayout.CENTER);
    }

    public void updateEmployerList(List<Employer> employers) {
        contentPanel.removeAll();
        rowPanels.clear();

        for (Employer employer : employers) {
            JPanel rowPanel = new JPanel(new GridLayout(1, 5));
            rowPanel.setBorder(new LineBorder(Color.GRAY));
            rowPanel.setMaximumSize(new Dimension(Integer.MAX_VALUE, 30));

            JLabel idLabel = new JLabel(String.valueOf(employer.getId()), SwingConstants.CENTER);
            JLabel lastNameLabel = new JLabel(employer.getLastName(), SwingConstants.CENTER);
            JLabel firstNameLabel = new JLabel(employer.getFirstName(), SwingConstants.CENTER);
            JLabel emailLabel = new JLabel(employer.getEmail(), SwingConstants.CENTER);
            JLabel salaryLabel = new JLabel(String.valueOf(employer.getSalary()), SwingConstants.CENTER);

            rowPanel.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    highlightRow(rowPanel, employer.getId());
                }
            });

            rowPanel.add(idLabel);
            rowPanel.add(lastNameLabel);
            rowPanel.add(firstNameLabel);
            rowPanel.add(emailLabel);
            rowPanel.add(salaryLabel);

            contentPanel.add(rowPanel);
            rowPanels.add(rowPanel);
        }

        contentPanel.revalidate();
        contentPanel.repaint();
    }

    private void highlightRow(JPanel selectedRow, int employerId) {
        for (JPanel row : rowPanels) {
            row.setBackground(Color.WHITE);
        }

        selectedRow.setBackground(Color.LIGHT_GRAY);
        selectedRowId = employerId;
    }

    public int getSelectedRowId() {
        return selectedRowId;
    }
}
