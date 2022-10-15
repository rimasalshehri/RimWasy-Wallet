import javax.swing.*;
import java.awt.*;

public abstract class Frame extends JFrame {
    private Container container;
    private JPanel componentPanel;

    public Frame() {
        setFrameProperties();
        setContainerProperties();
    }

    public void setFrameProperties() {
        setFrameSize();
        setLocationRelativeTo(null);
        setTitle("RIMWASY WALLET");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void setContainerProperties() {
        container = this.getContentPane();
        container.setBackground(Color.WHITE);

        container.setLayout(new BorderLayout(30, 30));
        container.add(new JLabel(), BorderLayout.EAST);
        container.add(new JLabel(), BorderLayout.WEST);
        container.add(new JLabel(), BorderLayout.NORTH);
        container.add(new JLabel(), BorderLayout.SOUTH);

        componentPanel = new JPanel();
        componentPanel.setLayout(null);
        componentPanel.setBackground(Color.WHITE);
        container.add(componentPanel, BorderLayout.CENTER);
    }

    abstract void setFrameSize();

    public JPanel getComponentPanel() {
        return componentPanel;
    }

    public Container getContainer() {
        return container;
    }
}
