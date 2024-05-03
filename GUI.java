import java.util.Vector;
import javax.swing.*;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.util.Date;
import java.time.LocalDate;
import java.time.ZoneId;

public class GUI {
    static Vector<Vector<Object>> eVector = new Vector<>();
    public static void main(String[] args) {
        // Create sample employee
        Employee sample = new Employee("Last", "First",
                    "Address", "Town", "State", "12345",
                    1234567890, "email@address.com",
                    "none", "none"
        );
        int sampleID = sample.getEmployeeID();
        sample.jobs.add(new Job(sampleID, "Programming", "Programmer", "Jason Owens", Date.from(LocalDate.now().atStartOfDay(ZoneId.systemDefault()).toInstant())));
        sample.skills.add(new Skill(1, sampleID, "Java", 10, "Murray State", "Programming"));
        sample.tasks.add(new Task(1, sampleID, "GUI", true, Date.from(LocalDate.now().atStartOfDay(ZoneId.systemDefault()).toInstant()), Date.from(LocalDate.now().atStartOfDay(ZoneId.systemDefault()).toInstant()), 0.9));
        openMainWindow();
    }

    public static void openMainWindow() {
        // Create window, size, exit operation
        JFrame frame = new JFrame("GUI");
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

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

        // Create a new frame to view employees on when selecting an employee in the table
        employeeTable.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    int selectedRow = employeeTable.getSelectedRow();
                    if (selectedRow != -1) {
                        JFrame employeeInfoFrame = new JFrame("Employee info");
                        employeeInfoFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

                        JPanel employeeInfoPanel = new JPanel(new GridLayout(0, 2, 10, 5));
                        Employee i = Temparrays.employees.get(selectedRow);
                        
                        // Basic employee info
                        employeeInfoPanel.add(new JLabel("Name: " + i.getFullName()));
                        employeeInfoPanel.add(new JLabel("Address: " + i.getFullAddress()));
                        employeeInfoPanel.add(new JLabel("Email: " + i.getEmail()));
                        employeeInfoPanel.add(new JLabel("Phone: " + i.getPhone()));
                        employeeInfoPanel.add(new JLabel("Title: " + i.getTitle()));
                        employeeInfoPanel.add(new JLabel("Supervisor: " + i.getSupervisor()));

                        // Buttons redirect to jobs, skills, tasks, and evaluations
                        JButton jobButton = new JButton("View jobs");
                        JButton skillsButton = new JButton("View skills");
                        JButton tasksButton = new JButton("View tasks");
                        JButton evaluationButton = new JButton("View evaluation");

                        // Create view jobs window
                        jobButton.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                Vector<Vector<Object>> jVector = new Vector<>();
                                for (int j = 0; j < i.jobs.size(); j++) {
                                    Vector<Object> v = new Vector<>();
                                    v.addElement(i.jobs.get(j).getName());
                                    v.addElement(i.jobs.get(j).getTitle());
                                    v.addElement(i.jobs.get(j).getSupervisor());
                                    v.addElement(i.jobs.get(j).getDateHired());
                                    jVector.addElement(v);
                                }

                                Vector<String> jobColumns = new Vector<>();
                                jobColumns.addElement("Name");
                                jobColumns.addElement("Title");
                                jobColumns.addElement("Supervisor");
                                jobColumns.addElement("Date hired");

                                JFrame jobFrame = new JFrame("Jobs");
                                JPanel jobPanel = new JPanel();
                                DefaultTableModel jobModel = new DefaultTableModel(jVector, jobColumns);
                                JTable jobTable = new JTable(jobModel);
                                JScrollPane jobScroll = new JScrollPane(jobTable);
                                jobPanel.add(jobScroll);
                                jobFrame.add(jobPanel);

                                //jobTable.getColumnModel().getColumn(0).setPreferredWidth(125);
                                
                                jobFrame.pack();
                                jobFrame.setVisible(true);
                            }
                        });

                        // Create view skills window
                        skillsButton.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                Vector<Vector<Object>> sVector = new Vector<>();
                                for (int s = 0; s < i.skills.size(); s++) {
                                    Vector<Object> v = new Vector<>();
                                    v.addElement(i.skills.get(s).getName());
                                    v.addElement(i.skills.get(s).getLevel());
                                    v.addElement(i.skills.get(s).getOrigin());
                                    v.addElement(i.skills.get(s).getUse());
                                    sVector.addElement(v);
                                }

                                Vector<String> skillColumns = new Vector<>();
                                skillColumns.addElement("Name");
                                skillColumns.addElement("Level");
                                skillColumns.addElement("Origin");
                                skillColumns.addElement("Use");

                                JFrame skillFrame = new JFrame("Skills");
                                JPanel skillPanel = new JPanel();
                                DefaultTableModel skillModel = new DefaultTableModel(sVector, skillColumns);
                                JTable skillTable = new JTable(skillModel);
                                JScrollPane skillScroll = new JScrollPane(skillTable);
                                skillPanel.add(skillScroll);
                                skillFrame.add(skillPanel);

                                //skillTable.getColumnModel().getColumn(0).setPreferredWidth(125);
                                
                                skillFrame.pack();
                                skillFrame.setVisible(true);
                            }
                        });

                        // Create view tasks window
                        tasksButton.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                Vector<Vector<Object>> tVector = new Vector<>();
                                for (int t = 0; t < i.tasks.size(); t++) {
                                    Vector<Object> v = new Vector<>();
                                    v.addElement(i.tasks.get(t).getName());
                                    v.addElement(i.tasks.get(t).getDateAssigned());
                                    v.addElement(i.tasks.get(t).getDateCompleted());
                                    v.addElement(i.tasks.get(t).getProgress());
                                    tVector.addElement(v);
                                }

                                Vector<String> taskColumns = new Vector<>();
                                taskColumns.addElement("Name");
                                taskColumns.addElement("Date assigned");
                                taskColumns.addElement("Date completed");
                                taskColumns.addElement("Progress");

                                JFrame taskFrame = new JFrame("Tasks");
                                JPanel taskPanel = new JPanel();
                                DefaultTableModel taskModel = new DefaultTableModel(tVector, taskColumns);
                                JTable taskTable = new JTable(taskModel);
                                JScrollPane taskScroll = new JScrollPane(taskTable);
                                taskPanel.add(taskScroll);
                                taskFrame.add(taskPanel);

                                //jobTable.getColumnModel().getColumn(0).setPreferredWidth(125);
                                
                                taskFrame.pack();
                                taskFrame.setVisible(true);
                            }
                        });

                        evaluationButton.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                JFrame evaluationFrame = new JFrame("Evaluation");
                                JPanel evaluationPanel = new JPanel(new GridLayout(0, 1, 10, 5));

                                JLabel employeeState = new JLabel("Employee state: " + i.evaluation.getEmployeeState());
                                JLabel employeeGrade = new JLabel("Employee grade: " + i.evaluation.getGrade());
                                JLabel employeeNotes = new JLabel("Other notes: ");

                                evaluationPanel.add(employeeState);
                                evaluationPanel.add(employeeGrade);
                                evaluationPanel.add(employeeNotes);
                                evaluationFrame.add(evaluationPanel);

                                
                                evaluationFrame.setSize(300, 200);
                                //evaluationFrame.pack();
                                evaluationFrame.setVisible(true);
                            }
                        });

                        employeeInfoPanel.add(jobButton);
                        employeeInfoPanel.add(skillsButton);
                        employeeInfoPanel.add(tasksButton);
                        employeeInfoPanel.add(evaluationButton);

                        // Create editEmployee panel and button
                        JPanel editEmployeePanel = new JPanel();

                        JButton editEmployeeButton = new JButton("Edit employee");
                        editEmployeePanel.add(editEmployeeButton);

                        editEmployeeButton.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                // Create editEmployee frame
                                JFrame editEmployeeFrame = new JFrame("Edit employee");
                                JPanel editEmployeeInfoPanel = new JPanel(new GridLayout(0, 2, 10, 5));

                                // Create labels and text fields for new employee information
                                JLabel firstNameLabel = new JLabel("First name");
                                editEmployeeInfoPanel.add(firstNameLabel);

                                JTextField firstNameField = new JTextField(i.getFirstName());
                                editEmployeeInfoPanel.add(firstNameField);
                                
                                JLabel lastNameLabel = new JLabel("Last name");
                                editEmployeeInfoPanel.add(lastNameLabel);

                                JTextField lastNameField = new JTextField(i.getLastName());
                                editEmployeeInfoPanel.add(lastNameField);

                                JLabel addressLabel = new JLabel("Street address");
                                editEmployeeInfoPanel.add(addressLabel);

                                JTextField addressField = new JTextField(i.getStreetAddress());
                                editEmployeeInfoPanel.add(addressField);

                                JLabel cityLabel = new JLabel("City");
                                editEmployeeInfoPanel.add(cityLabel);

                                JTextField cityField = new JTextField(i.getCity());
                                editEmployeeInfoPanel.add(cityField);

                                JLabel stateLabel = new JLabel("State");
                                editEmployeeInfoPanel.add(stateLabel);

                                JTextField stateField = new JTextField(i.getState());
                                editEmployeeInfoPanel.add(stateField);

                                JLabel zipLabel = new JLabel("Zip code");
                                editEmployeeInfoPanel.add(zipLabel);

                                JTextField zipField = new JTextField(i.getZip());
                                editEmployeeInfoPanel.add(zipField);

                                JLabel emailLabel = new JLabel("Email address");
                                editEmployeeInfoPanel.add(emailLabel);

                                JTextField emailField = new JTextField(i.getEmail());
                                editEmployeeInfoPanel.add(emailField);

                                JLabel phoneLabel = new JLabel("Phone number");
                                editEmployeeInfoPanel.add(phoneLabel);

                                JTextField phoneField = new JTextField(String.valueOf(i.getPhone()));
                                editEmployeeInfoPanel.add(phoneField);

                                JLabel titleLabel = new JLabel("Title");
                                editEmployeeInfoPanel.add(titleLabel);

                                JTextField titleField = new JTextField(i.getTitle());
                                editEmployeeInfoPanel.add(titleField);

                                JLabel supervisorLabel = new JLabel("Supervisor");
                                editEmployeeInfoPanel.add(supervisorLabel);

                                JTextField supervisorField = new JTextField(i.getSupervisor());
                                editEmployeeInfoPanel.add(supervisorField);

                                // Create confirmation panel and dialog
                                JPanel confirmPanel = new JPanel();
                                JButton confirmButton = new JButton("Confirm changes");
                                JButton cancelButton = new JButton("Cancel");
                                cancelButton.addActionListener(new ActionListener() {
                                    @Override
                                    // If clicked, close window
                                    public void actionPerformed(ActionEvent e) {
                                        editEmployeeFrame.dispose();
                                    }
                                });
                                confirmPanel.add(confirmButton);
                                confirmPanel.add(cancelButton);

                                confirmButton.addActionListener(new ActionListener() {
                                    @Override
                                    // Checks for yes option and valid info for fields
                                    public void actionPerformed(ActionEvent e) {
                                        int answer = JOptionPane.showConfirmDialog(editEmployeeFrame,
                                            "Confirm employee changes?", "Confirm changes?",
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
                                                // Edit all attributes for employee
                                                // The original editEmployee method should be changed, but this works for now
                                                int empID = i.getEmployeeID();

                                                Temparrays.editEmployee(empID, "firstName", firstNameField.getText());
                                                Temparrays.editEmployee(empID, "lastName", lastNameField.getText());
                                                Temparrays.editEmployee(empID, "streetAddress", addressField.getText());
                                                Temparrays.editEmployee(empID, "city", cityField.getText());
                                                Temparrays.editEmployee(empID, "state", stateField.getText());
                                                Temparrays.editEmployee(empID, "zip", zipField.getText());
                                                Temparrays.editEmployee(empID, "email", emailField.getText());
                                                Temparrays.editEmployee(empID, "phone", Integer.parseInt(phoneField.getText()));
                                                Temparrays.editEmployee(empID, "title", titleField.getText());
                                                Temparrays.editEmployee(empID, "supervisor", supervisorField.getText());
                                                
                                                ((DefaultTableModel) employeeTable.getModel()).fireTableRowsUpdated(selectedRow, selectedRow);

                                                openMainWindow();
                                                editEmployeeFrame.dispose();
                                                employeeInfoFrame.dispose();
                                                frame.dispose();
                                            }
                                            else {
                                                JOptionPane.showMessageDialog(editEmployeeFrame,
                                                    "A field was given invalid information. Please double check all fields for errors", "Error",
                                                    JOptionPane.ERROR_MESSAGE);
                                            }
                                        }
                                    }
                                });

                                // Display editEmployeeFrame
                                editEmployeeFrame.add(editEmployeeInfoPanel, BorderLayout.CENTER);
                                editEmployeeFrame.add(confirmPanel, BorderLayout.SOUTH);
                                editEmployeeFrame.pack();
                                editEmployeeFrame.setVisible(true);
                            }
                        });

                        // Displays all labels added above
                        employeeInfoFrame.add(employeeInfoPanel, BorderLayout.CENTER);
                        employeeInfoFrame.add(editEmployeePanel, BorderLayout.SOUTH);
                        employeeInfoFrame.pack();
                        employeeInfoFrame.setSize(300, 200);
                        employeeInfoFrame.setVisible(true);
                    }
                }
            }
        });

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

        // Create dialog box to confirm employee deletion
        JButton deleteButton = new JButton("Delete employee");
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = employeeTable.getSelectedRow();
                if (selectedRow != -1) {
                    int answer = JOptionPane.showConfirmDialog(frame,
                    "Permanently delete this employee?", "Confirm deletion?",
                    JOptionPane.YES_NO_OPTION);
                    if (answer == JOptionPane.YES_OPTION) {
                        //System.out.println(TempArrays.employees.get(0).getFullName());
                        int ID = Temparrays.employees.get(selectedRow).getEmployeeID(); // The ID of the employee to be deleted
                        Temparrays.deleteEmployee(ID);
                        openMainWindow();
                        frame.dispose();
                    }
                }
            }
        });
        addPanel.add(deleteButton);
        
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
        for (int i = 0; i < Temparrays.employees.size(); i++) {
            Vector<Object> v = new Vector<>();
            v.addElement(Temparrays.employees.get(i).getFullName());
            v.addElement(Temparrays.employees.get(i).getFullAddress());
            v.addElement(Temparrays.employees.get(i).getEmail());
            v.addElement(Temparrays.employees.get(i).getPhone());
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