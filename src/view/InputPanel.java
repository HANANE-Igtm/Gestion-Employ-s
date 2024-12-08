package view;

import javax.swing.*;
import java.awt.*;
import enums.Role; 
import enums.Poste; 

public class InputPanel extends JPanel {

    JTextField firstNameField, lastNameField, emailField, telephoneNumberField, salaryField;
    JComboBox<Role> roleField;
    JComboBox<Poste> posteField;

    public InputPanel() {
        setLayout(new GridLayout(7, 2, 5, 5));
        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        firstNameField = new JTextField(15);
        lastNameField = new JTextField(15);
        emailField = new JTextField(15);
        telephoneNumberField = new JTextField(15);
        salaryField = new JTextField(15);
        roleField = new JComboBox<>(Role.values());
        posteField = new JComboBox<>(Poste.values());

        add(new JLabel("First Name"));
        add(firstNameField);

        add(new JLabel("Last Name"));
        add(lastNameField);

        add(new JLabel("Email"));
        add(emailField);

        add(new JLabel("Telephone Number"));
        add(telephoneNumberField);

        add(new JLabel("Salary"));
        add(salaryField);

        add(new JLabel("Role"));
        add(roleField);

        add(new JLabel("Poste"));
        add(posteField);
    }

    public JTextField getFirstNameField() {
        return firstNameField;
    }

    public JTextField getLastNameField() {
        return lastNameField;
    }

    public JTextField getEmailField() {
        return emailField;
    }

    public JTextField getTelephoneNumberField() {
        return telephoneNumberField;
    }

    public JTextField getSalaryField() {
        return salaryField;
    }

    public Role getSelectedRole() {
        return (Role) roleField.getSelectedItem();
    }

    public Poste getSelectedPoste() {
        return (Poste) posteField.getSelectedItem();
    }
}
