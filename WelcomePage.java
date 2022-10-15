import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class WelcomePage extends Frame{
    private JLabel welcomeLabel, pictureLabel, informationLabel, firstNameLabel, lastNameLabel, emailLabel, passwordLabel;
    private JPanel inputPanel;
    private JTextField firstNameTextFiled, lastNameTextFiled, emailTextField;
    private JPasswordField passwordField;
    private JButton nextButton, darkThemeButton;
    private boolean darkMode;
    private  ImageIcon img1, img2;

    public WelcomePage(boolean darkMode) {
        this.darkMode = darkMode;
        img1 = new ImageIcon(getClass().getResource("image01.png"));
        img2 = new ImageIcon(getClass().getResource("image02.png"));
        setComponentPanel();
        setActionListeners();
    }

    @Override
    void setFrameSize() {
        setSize(575, 550);
    }

    public void setComponentPanel() {
        welcomeLabel = new JLabel("Welcome to RIMWASY WALLET");
        welcomeLabel.setBounds(0, 0, 500, 30);
        welcomeLabel.setOpaque(true);
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 20));
        welcomeLabel.setHorizontalAlignment(JLabel.CENTER);
        getComponentPanel().add(welcomeLabel);

        darkThemeButton = new JButton("Dark");
        darkThemeButton.setBounds(430, 0, 70, 30);
        darkThemeButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        darkThemeButton.setFocusPainted(false);
        getComponentPanel().add(darkThemeButton);

        pictureLabel = new JLabel(img1);
        pictureLabel.setBorder(new LineBorder(Color.BLACK, 2));
        pictureLabel.setBounds(0, 50, img1.getIconWidth(), img1.getIconHeight());
        getComponentPanel().add(pictureLabel);

        inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(0, 1, 0, 5));
        inputPanel.setBounds(290, 50, 200, 400);
        setInputPanel();
        getComponentPanel().add(inputPanel);
    }

    public void setInputPanel() {
        informationLabel = new JLabel("Enter Your Information");
        informationLabel.setFont(new Font("Arial", Font.BOLD, 16));
        informationLabel.setHorizontalAlignment(JLabel.CENTER);
        inputPanel.add(informationLabel);

        firstNameLabel = new JLabel("First Name");
        firstNameLabel.setFont(new Font("Arial", Font.BOLD, 16));
        inputPanel.add(firstNameLabel);

        firstNameTextFiled = new JTextField();
        firstNameTextFiled.setFont(new Font("Arial", Font.BOLD, 16));
        inputPanel.add(firstNameTextFiled);

        lastNameLabel = new JLabel("Last Name");
        lastNameLabel.setFont(new Font("Arial", Font.BOLD, 16));
        inputPanel.add(lastNameLabel);

        lastNameTextFiled = new JTextField();
        lastNameTextFiled.setFont(new Font("Arial", Font.BOLD, 16));
        inputPanel.add(lastNameTextFiled);

        emailLabel = new JLabel("Email");
        emailLabel.setFont(new Font("Arial", Font.BOLD, 16));
        inputPanel.add(emailLabel);

        emailTextField = new JTextField();
        emailTextField.setFont(new Font("Arial", Font.BOLD, 16));
        inputPanel.add(emailTextField);

        passwordLabel = new JLabel("Password");
        passwordLabel.setFont(new Font("Arial", Font.BOLD, 16));
        inputPanel.add(passwordLabel);

        passwordField = new JPasswordField();
        passwordField.setFont(new Font("Arial", Font.BOLD, 16));
        inputPanel.add(passwordField);

        nextButton = new JButton("Next");
        nextButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        nextButton.setFocusPainted(false);
        nextButton.setFont(new Font("Arial", Font.BOLD, 16));
        inputPanel.add(nextButton);

        if (darkMode) {
            setDark();
        } else {
            setLight();
        }
    }

    public boolean isValidCharacter(char ch) {
        if ((ch >= (char) 65 && ch <= (char) 90)
                || (ch >= (char) 97 && ch <= (char) 122)
                || ch == (char) 8
                || ch == (char) 10
                || ch == (char) 32
                || ch == (char) 65535) {
            return true;
        } return false;
    }

    public void setDark() {
        welcomeLabel.setBackground(Color.BLACK);
        welcomeLabel.setForeground(Color.WHITE);

        darkThemeButton.setText("Light");
        darkThemeButton.setBackground(Color.WHITE);
        darkThemeButton.setForeground(Color.BLACK);

        pictureLabel.setIcon(img2);
        pictureLabel.setBorder(new LineBorder(Color.WHITE, 2));
        pictureLabel.setBounds(0, 50, img2.getIconWidth(), img2.getIconHeight());

        inputPanel.setBackground(Color.BLACK);

        informationLabel.setForeground(Color.WHITE);
        firstNameLabel.setForeground(Color.WHITE);
        lastNameLabel.setForeground(Color.WHITE);
        emailLabel.setForeground(Color.WHITE);
        passwordLabel.setForeground(Color.WHITE);

        nextButton.setBackground(Color.WHITE);
        nextButton.setForeground(Color.BLACK);

        getComponentPanel().setBackground(Color.BLACK);

        getContainer().setBackground(Color.BLACK);

        darkMode = true;
    }

    public void setLight() {
        welcomeLabel.setBackground(Color.WHITE);
        welcomeLabel.setForeground(Color.BLACK);

        darkThemeButton.setText("Dark");
        darkThemeButton.setBackground(Color.BLACK);
        darkThemeButton.setForeground(Color.WHITE);

        pictureLabel.setIcon(img1);
        pictureLabel.setBorder(new LineBorder(Color.BLACK, 2));
        pictureLabel.setBounds(0, 50, img1.getIconWidth(), img1.getIconHeight());

        inputPanel.setBackground(Color.WHITE);

        informationLabel.setForeground(Color.BLACK);
        firstNameLabel.setForeground(Color.BLACK);
        lastNameLabel.setForeground(Color.BLACK);
        emailLabel.setForeground(Color.BLACK);
        passwordLabel.setForeground(Color.BLACK);

        nextButton.setBackground(Color.BLACK);
        nextButton.setForeground(Color.WHITE);

        getComponentPanel().setBackground(Color.WHITE);

        getContainer().setBackground(Color.WHITE);

        darkMode = false;
    }

    public void setActionListeners() {
        firstNameTextFiled.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent keyEvent) {
                try{
                    if (!isValidCharacter(keyEvent.getKeyChar())) {
                        throw new Exception();
                    }
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Please Enter Valid First Name");
                    firstNameTextFiled.setText("");
                }
            }
        });

        lastNameTextFiled.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent keyEvent) {
                try{
                    if (!isValidCharacter(keyEvent.getKeyChar())) {
                        throw new Exception();
                    }
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Please Enter Valid Last Name");
                    lastNameTextFiled.setText("");
                }
            }
        });


        nextButton.addActionListener(e->{
            String firstName, lastName, email, password;

            try {
                firstName = firstNameTextFiled.getText();
                if (firstName.equals("")) {
                    throw new Exception();
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "First Name Can Not be empty");
                return;
            }

            try {
                lastName = lastNameTextFiled.getText();
                if (lastName.equals("")) {
                    throw new Exception();
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Last Name Can Not be empty");
                return;
            }

            try {
                email = emailTextField.getText();
                if (email.equals("")) {
                    throw new Exception("Email Can Not Be Empty");
                }

                if (!(email.endsWith("@gmail.com") || email.endsWith("@yahoo.com") || email.endsWith("@hotmail.com") || email.endsWith("@uj.edu.sa"))) {
                    throw new Exception("Please Enter A Valid Email Address");
                } else {
                    if (email.substring(0, email.indexOf("@")).equals("")) {
                        throw new Exception("Please Enter A Valid Email Address");
                    }
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
                return;
            }

            try {
                password = passwordField.getText();
                if (password.equals("")) {
                    throw new Exception("Password Can Not Be Empty");
                }

                if (!(password.contains("@") || password.contains("_") || password.contains("/") || password.contains("!"))) {
                    throw new Exception("Please Enter A Strong Password (Must Use @ or _ or / or !)");
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
                return;
            }

            this.dispose();
            new OptionChooser(firstName, lastName, darkMode).setVisible(true);
        });

        darkThemeButton.addActionListener(e->{
            if (darkMode) {
                setLight();
            } else {
                setDark();
            }
        });
    }

    public static void main(String[] args) {
        new WelcomePage(false).setVisible(true);
    }
}
