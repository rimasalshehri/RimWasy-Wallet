import javax.swing.*;
import java.awt.*;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Charity extends Frame {
    private JTextField yearTextField, percentageTable;
    private JButton calculateButton, backButton;

    public Charity(String firstName, String lastName, boolean darkMode) {
        setComponentPanel(darkMode);
        setActionListeners(firstName, lastName, darkMode);
    }

    @Override
    void setFrameSize() {
        setSize(400, 420);
    }

    public void setComponentPanel(boolean darkMode) {
        getComponentPanel().setLayout(new GridLayout(0, 1, 0, 5));

        JLabel yearLabel = new JLabel("Enter number of years to calculate charity");
        yearLabel.setFont(new Font("Arial", Font.BOLD, 16));
        yearLabel.setHorizontalAlignment(JLabel.CENTER);
        getComponentPanel().add(yearLabel);

        yearTextField = new JTextField();
        yearTextField.setFont(new Font("Arial", Font.BOLD, 16));
        getComponentPanel().add(yearTextField);

        JLabel percentageLabel = new JLabel("Enter percentage to calculate charity");
        percentageLabel.setFont(new Font("Arial", Font.BOLD, 16));
        percentageLabel.setHorizontalAlignment(JLabel.CENTER);
        getComponentPanel().add(percentageLabel);

        percentageTable = new JTextField();
        percentageTable.setFont(new Font("Arial", Font.BOLD, 16));
        getComponentPanel().add(percentageTable);

        getComponentPanel().add(new JLabel());

        calculateButton = new JButton("Calculate");
        calculateButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        calculateButton.setFocusPainted(false);
        calculateButton.setFont(new Font("Arial", Font.BOLD, 16));
        calculateButton.setBackground(Color.BLACK);
        calculateButton.setForeground(Color.WHITE);
        getComponentPanel().add(calculateButton);

        backButton = new JButton("Back");
        backButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        backButton.setFocusPainted(false);
        backButton.setFont(new Font("Arial", Font.BOLD, 16));
        backButton.setBackground(Color.BLACK);
        backButton.setForeground(Color.WHITE);
        getComponentPanel().add(backButton);

        if (darkMode) {
            yearLabel.setBackground(Color.BLACK);
            yearLabel.setForeground(Color.WHITE);

            percentageLabel.setBackground(Color.BLACK);
            percentageLabel.setForeground(Color.WHITE);

            calculateButton.setBackground(Color.WHITE);
            calculateButton.setForeground(Color.BLACK);

            backButton.setBackground(Color.WHITE);
            backButton.setForeground(Color.BLACK);

            getComponentPanel().setBackground(Color.BLACK);

            getContainer().setBackground(Color.BLACK);
        }
    }

    public void setActionListeners(String firstName, String lastName, boolean darkMode) {
        backButton.addActionListener(e->{
            this.dispose();
            new OptionChooser(firstName, lastName, darkMode).setVisible(true);
        });

        calculateButton.addActionListener(e->{
            try {
                int year = Integer.parseInt(yearTextField.getText());
                int percentage = Integer.parseInt(percentageTable.getText());

                if (year <= 0 || percentage <= 0 || percentage > 100) {
                    throw new Exception();
                } else {
                    double totalSalary = 0;
                    for (int i = 0; i < year; i++) {
                        totalSalary += Double.parseDouble(JOptionPane.showInputDialog(null, "Please Enter Monthly Salary for Year " + (i+1))) * 12;
                    }
                    String message="Your Charity as " + percentage + "% of your total salary which is " + totalSalary +
                            " during " + year + " years should equal to = " + (totalSalary * percentage / 100);
                    JOptionPane.showMessageDialog(null, message);

                    int option = JOptionPane.showConfirmDialog(null, "Do you want to write data to file?", "Writing Data", JOptionPane.YES_NO_OPTION);

                    if (option == JOptionPane.YES_OPTION) {
                        try{
                            FileWriter fileWriter = new FileWriter("charity.txt");
                            fileWriter.write(message);
                            fileWriter.close();
                            JOptionPane.showMessageDialog(null, "Information Written to File Successfully");
                        } catch (IOException ex) {

                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Information Not Written to File");
                    }
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Please Enter A Valid Input");
            }
        });
    }
}
