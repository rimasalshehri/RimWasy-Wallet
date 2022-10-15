import javax.swing.*;
import java.awt.*;
import java.io.FileWriter;
import java.io.IOException;

public class Savings extends Frame {
    private JTextField yearTextField;
    private JButton calculateButton, backButton;

    public Savings(String firstName, String lastName, boolean darkMode) {
        setComponentPanel(darkMode);
        setActionListeners(firstName, lastName, darkMode);
    }

    @Override
    void setFrameSize() {
        setSize(420, 320);
    }

    public void setComponentPanel(boolean darkMode) {
        getComponentPanel().setLayout(new GridLayout(0, 1, 0, 5));

        JLabel label = new JLabel("Enter number of years to calculate savings");
        label.setFont(new Font("Arial", Font.BOLD, 16));
        label.setHorizontalAlignment(JLabel.CENTER);
        getComponentPanel().add(label);

        yearTextField = new JTextField();
        yearTextField.setFont(new Font("Arial", Font.BOLD, 16));
        getComponentPanel().add(yearTextField);

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
            label.setBackground(Color.BLACK);
            label.setForeground(Color.WHITE);

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

                if (year <= 0) {
                    throw new Exception();
                } else {
                    double totalSalary = 0, totalSavings = 0, totalEntertainment = 0,totalNecessity = 0;
                    for (int i = 0; i < year; i++) {
                        totalSalary += Double.parseDouble(JOptionPane.showInputDialog(null, "Please Enter Monthly Salary for Year " + (i+1))) * 12;
                    }
                    totalSavings = totalSalary * 0.2;
                    totalEntertainment = totalSalary * 0.3;
                    totalNecessity = totalSalary * 0.5;

                    String message="This Distribution is based on,\n" +
                            "Taking 20% of your monthly Salary for Savings\n" +
                            "Taking 30% of your Salary for monthly Entertainment\n" +
                            "Taking 50% of your Salary for Monthly Necessities\n"
                            +"\nyour total salary for " + year + " years is= " + totalSalary + "\n"
                            +"your total savings for " + year + " years is= " + totalSavings + "\n"+"your total entertainment for "
                            + year +" years is= " + totalEntertainment + "\n"+
                            "your total necessity for " + year + " years is= " + totalNecessity;
                    JOptionPane.showMessageDialog(null, message);

                    int option = JOptionPane.showConfirmDialog(null, "Do you want to write data to file?", "Writing Data", JOptionPane.YES_NO_OPTION);

                    if (option == JOptionPane.YES_OPTION) {
                        try{
                            FileWriter fileWriter = new FileWriter("savings.txt");
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
