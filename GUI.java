import java.util.Vector;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;

public class GUI {
    static Vector<Vector<Object>> eVector = new Vector<>();
    public static void main(String[] args) {
        openMainWindow();
    }

    public static void openMainWindow() {
        // Create window, size, exit operation
        JFrame frame = new JFrame("GUI");
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Create sample employees
        /*new Employee("Last", "First",
                    "Address", "Town", "State", "Zip",
                    1234567890, "email@address",
                    "none", "none"
        );*/

        // Create lists of key information
        refreshEmployeeList(frame);
        
        Vector<String> columnNames = new Vector<>();
        columnNames.addElement("Name");
        columnNames.addElement("Address");
        columnNames.addElement("Email");
        columnNames.addElement("Phone number");

        // Create employee panel with label and table of employees
        JPanel employeePanel = new JPanel();

        DefaultTableModel employeeModel = new DefaultTableModel(eVector, columnNames);

        JTable employeeTable = new JTable(employeeModel);
        employeeTable.getColumnModel().getColumn(0).setPreferredWidth(125);
        employeeTable.getColumnModel().getColumn(1).setPreferredWidth(300);
        employeeTable.getColumnModel().getColumn(2).setPreferredWidth(175);
        employeeTable.getColumnModel().getColumn(3).setPreferredWidth(150);

        JScrollPane scrollPane = new JScrollPane(employeeTable);
        employeePanel.add(scrollPane);

        // Create title panel
        JPanel titlePanel = new JPanel();
        titlePanel.add(new Label("A Human Resource"));

        // Create add employee panel with add employee button
        JPanel addPanel = new JPanel();
        JButton addButton = new JButton("Add employee");

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openNewEmployee(frame);
            }
        });

        addPanel.add(addButton);
        
        // Incorporate elements into main panel and set window to visible
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.add(employeePanel, BorderLayout.CENTER);
        mainPanel.add(titlePanel, BorderLayout.NORTH);
        mainPanel.add(addPanel, BorderLayout.SOUTH);
        
        frame.add(mainPanel);
        frame.pack();
        frame.setVisible(true);
    }

    public static void refreshEmployeeList(JFrame frame) {
        /* Ensures that the Vector of Employee objects to be displayed in the GUI
         * accurately reflects the ArrayList of Employee objects in the backend
         */
        eVector.clear();
        for (int i = 0; i < TempArrays.employees.size(); i++) {
            Vector<Object> v = new Vector<>();
            v.addElement(TempArrays.employees.get(i).getFullName());
            v.addElement(TempArrays.employees.get(i).getFullAddress());
            v.addElement(TempArrays.employees.get(i).getEmail());
            v.addElement(TempArrays.employees.get(i).getPhone());
            eVector.add(v);
        }
        frame.dispose();
    }

    public static void openNewEmployee(JFrame frame) {
        // Opens new employee frame and creates a panel to register new employee info on
        JFrame newEmployeeFrame = new JFrame("Register new employee"); // New window opens
        //newEmployeeFrame.setSize(10000, 10000);
        newEmployeeFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Only closes current window when closed
        
        JPanel newEmployeePanel = new JPanel(new BorderLayout()); // Create panel that will take up the whole frame

        JPanel titlePanel = new JPanel(); // Creates a title subpanel for newEmployeePanel
        titlePanel.add(new JLabel("Enter employee information"));

        JPanel infoPanel = new JPanel(new GridLayout(0, 2, 10, 5)); // Employee info subpanel
        
        // Create labels and text fields for new employee information
        JLabel firstNameLabel = new JLabel("First name");
        infoPanel.add(firstNameLabel);

        JTextField firstNameField = new JTextField();
        infoPanel.add(firstNameField);
        
        JLabel lastNameLabel = new JLabel("Last name");
        infoPanel.add(lastNameLabel);

        JTextField lastNameField = new JTextField();
        infoPanel.add(lastNameField);

        JLabel addressLabel = new JLabel("Street address");
        infoPanel.add(addressLabel);

        JTextField addressField = new JTextField();
        infoPanel.add(addressField);

        JLabel cityLabel = new JLabel("City");
        infoPanel.add(cityLabel);

        JTextField cityField = new JTextField();
        infoPanel.add(cityField);

        JLabel stateLabel = new JLabel("State");
        infoPanel.add(stateLabel);

        JTextField stateField = new JTextField();
        infoPanel.add(stateField);

        JLabel zipLabel = new JLabel("Zip code");
        infoPanel.add(zipLabel);

        JTextField zipField = new JTextField();
        infoPanel.add(zipField);

        JLabel emailLabel = new JLabel("Email address");
        infoPanel.add(emailLabel);

        JTextField emailField = new JTextField();
        infoPanel.add(emailField);

        JLabel phoneLabel = new JLabel("Phone number");
        infoPanel.add(phoneLabel);

        JTextField phoneField = new JTextField();
        infoPanel.add(phoneField);

        // Creates a confirm/cancel subpanel for newEmployeePanel
        JPanel confirmPanel = new JPanel();
        
        JButton confirmButton = new JButton("Confirm");
        confirmPanel.add(confirmButton);
        confirmButton.addActionListener(new ActionListener() {
            @Override
            // Checks for yes option and valid info for fields
            public void actionPerformed(ActionEvent e) {
                int answer = JOptionPane.showConfirmDialog(newEmployeeFrame,
                    "Create new employee?", "Confirm creation?",
                    JOptionPane.YES_NO_OPTION);
                if (answer == JOptionPane.YES_OPTION) {
                    // Run validity tests
                    if (firstNameField.getText() != ""
                    && lastNameField.getText() != ""
                    && addressField.getText() != ""
                    && cityField.getText() != ""
                    && stateField.getText() != ""
                    && !zipField.getText().matches(".*[^0-9].*")
                    && emailField.getText().matches(".*[@].*") && emailField.getText().matches(".*[.].*")
                    && !phoneField.getText().matches(".*[^0-9].*"))
                    {
                        new Employee(lastNameField.getText(), firstNameField.getText(),
                            addressField.getText(), cityField.getText(), stateField.getText(), zipField.getText(),
                            Integer.parseInt(phoneField.getText()), emailField.getText(),
                            "", "");
                        frame.dispose();
                        openMainWindow();
                        newEmployeeFrame.dispose();
                    }
                    else {
                        JOptionPane.showMessageDialog(newEmployeeFrame,
                            "A field was given invalid information. Please double check all fields for errors", "Error",
                            JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });

        JButton cancelButton = new JButton("Cancel");
        confirmPanel.add(cancelButton);
        cancelButton.addActionListener(new ActionListener() {
            @Override
            // If clicked, close window
            public void actionPerformed(ActionEvent e) {
                newEmployeeFrame.dispose();
            }
        });
        
        // Organize new employee subpanels and make visible
        newEmployeePanel.add(infoPanel, BorderLayout.CENTER);
        newEmployeePanel.add(titlePanel, BorderLayout.NORTH);
        newEmployeePanel.add(confirmPanel, BorderLayout.SOUTH);

        newEmployeeFrame.add(newEmployeePanel);
        newEmployeeFrame.pack();
        newEmployeeFrame.setVisible(true);
    }
}