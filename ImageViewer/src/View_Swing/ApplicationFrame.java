package View_Swing;

import UI.ImageViewer;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JPanel;

public class ApplicationFrame extends JFrame {

    private ImageViewer viewer;
    private ActionListenerFactory factory;

    public ApplicationFrame(ActionListenerFactory factory) {
        super("Image Viewer");
        this.factory = factory;
        this.setSize(1024, 700);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.createComponents();
        this.setVisible(true);
    }

    public ImageViewer getViewer() {
        return viewer;
    }

    private void createComponents() {
        this.add(createImagePanel());
        this.add(createToolbar(), BorderLayout.SOUTH);
    }

    private JPanel createImagePanel() {
        ImagePanel panel = new ImagePanel();
        viewer = panel;
        return panel;
    }

    private JPanel createToolbar() {
        JPanel panel = new JPanel();
        panel.add(createButton("Prev"));
        panel.add(createButton("Next"));
        return panel;
    }

    private JButton createButton(String label) {
        JButton button = new JButton(label);
        button.addActionListener(factory.addAction(label));
        return button;
    }
}
