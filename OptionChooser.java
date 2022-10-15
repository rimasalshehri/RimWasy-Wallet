import javax.swing.*;
import java.awt.*;

public class OptionChooser extends Frame {
    private JLabel helloLabel, firstLine, secondLine, thirdLine;
    private JButton basicBudgetButton, savingsButton, charityButton, backButton;

    public OptionChooser(String firstName, String lastName, boolean darkMode) {
        setComponentPanel(firstName, lastName, darkMode);
        setActionListeners(firstName, lastName, darkMode);
    }

    @Override
    void setFrameSize() {
        setSize(450, 400);
    }

    public void setComponentPanel(String firstName, String lastName, boolean darkMode) {
        getComponentPanel().setLayout(new GridLayout(0, 1, 0, 5));

        helloLabel = new JLabel("Hello " + firstName + " " + lastName);
        helloLabel.setFont(new Font("Arial", Font.BOLD, 20));
        helloLabel.setHorizontalAlignment(JLabel.CENTER);
        getComponentPanel().add(helloLabel);

        firstLine = new JLabel("RimWasy Wallet serves as a financial guide,");
        firstLine.setFont(new Font("Arial", Font.BOLD, 16));
        firstLine.setHorizontalAlignment(JLabel.CENTER);
        getComponentPanel().add(firstLine);

        secondLine = new JLabel("where you could enter your monthly");
        secondLine.setFont(new Font("Arial", Font.BOLD, 16));
        secondLine.setHorizontalAlignment(JLabel.CENTER);
        getComponentPanel().add(secondLine);

        thirdLine = new JLabel("salary/income to calculate");
        thirdLine.setFont(new Font("Arial", Font.BOLD, 16));
        thirdLine.setHorizontalAlignment(JLabel.CENTER);
        getComponentPanel().add(thirdLine);

        getComponentPanel().add(new JLabel());

        basicBudgetButton = new JButton("Basic Budget");
        basicBudgetButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        basicBudgetButton.setFocusPainted(false);
        basicBudgetButton.setFont(new Font("Arial", Font.BOLD, 16));
        basicBudgetButton.setBackground(Color.BLACK);
        basicBudgetButton.setForeground(Color.WHITE);
        getComponentPanel().add(basicBudgetButton);


        savingsButton = new JButton("Savings");
        savingsButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        savingsButton.setFocusPainted(false);
        savingsButton.setFont(new Font("Arial", Font.BOLD, 16));
        savingsButton.setBackground(Color.BLACK);
        savingsButton.setForeground(Color.WHITE);
        getComponentPanel().add(savingsButton);

        charityButton = new JButton("Charity");
        charityButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        charityButton.setFocusPainted(false);
        charityButton.setFont(new Font("Arial", Font.BOLD, 16));
        charityButton.setBackground(Color.BLACK);
        charityButton.setForeground(Color.WHITE);
        getComponentPanel().add(charityButton);

        backButton = new JButton("Back");
        backButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        backButton.setFocusPainted(false);
        backButton.setFont(new Font("Arial", Font.BOLD, 16));
        backButton.setBackground(Color.BLACK);
        backButton.setForeground(Color.WHITE);
        getComponentPanel().add(backButton);

        if (darkMode) {
            helloLabel.setBackground(Color.BLACK);
            helloLabel.setForeground(Color.WHITE);

            firstLine.setBackground(Color.BLACK);
            firstLine.setForeground(Color.WHITE);

            secondLine.setBackground(Color.BLACK);
            secondLine.setForeground(Color.WHITE);

            thirdLine.setBackground(Color.BLACK);
            thirdLine.setForeground(Color.WHITE);

            basicBudgetButton.setBackground(Color.WHITE);
            basicBudgetButton.setForeground(Color.BLACK);

            savingsButton.setBackground(Color.WHITE);
            savingsButton.setForeground(Color.BLACK);

            charityButton.setBackground(Color.WHITE);
            charityButton.setForeground(Color.BLACK);

            backButton.setBackground(Color.WHITE);
            backButton.setForeground(Color.BLACK);

            getComponentPanel().setBackground(Color.BLACK);

            getContainer().setBackground(Color.BLACK);
        }
    }

    public void setActionListeners(String firstName, String lastName, boolean darkMode) {
        basicBudgetButton.addActionListener(e->{
            this.dispose();
            new BasicBudgeting(firstName, lastName, darkMode).setVisible(true);
        });

        savingsButton.addActionListener(e->{
            this.dispose();
            new Savings(firstName, lastName, darkMode).setVisible(true);
        });

        charityButton.addActionListener(e->{
            this.dispose();
            new Charity(firstName, lastName, darkMode).setVisible(true);
        });

        backButton.addActionListener(e->{
            this.dispose();
            new WelcomePage(darkMode).setVisible(true);
        });
    }
}
