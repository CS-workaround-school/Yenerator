import javax.swing.*;
import java.awt.*;
public class Main {
    public static void main(String[] args) {
        // Instanciando
        ImageIcon image = new ImageIcon("icon.jpg");
        ImageIcon ye = new ImageIcon("ye.jpg");
        JTextField textField = new JTextField();
        JFrame frame = new JFrame();
        JLabel label = getLabel(ye);
        JPanel buttonPanel = new JPanel();
        JButton button = new JButton();

        // Settando botão e painel
        button.setSize(new Dimension(200, 40));
        button.setText("Add image");
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));
        buttonPanel.add(textField);
        buttonPanel.add(button);

        // Settando campo de texto
        textField.setPreferredSize(new Dimension(250, 40));
        textField.setOpaque(true);
        textField.setBackground(Color.white);

        // Settando a tela
        frame.setVisible(true);
        frame.setSize(1000, 760);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(true);
        frame.setLayout(new BorderLayout());
        frame.setTitle("TestePainel");
        frame.setIconImage(image.getImage());
        frame.getContentPane().setBackground(Color.black);
        frame.add(label, BorderLayout.CENTER); // BorderLayout fez a boa aq
        frame.add(buttonPanel, BorderLayout.SOUTH);

        // Codigo que faz a ação de ler e escrever o texto
        textField.addActionListener((event) -> {
            String midText = textField.getText();
            label.setText("<HTML><center>" + midText + "</HTML>");
        });

        button.addActionListener((event) -> {
            JFileChooser file = new JFileChooser();
            int result = file.showOpenDialog(frame);
            if (result == file.APPROVE_OPTION) {
                String imagePath = file.getSelectedFile().getAbsolutePath();
                ye.setImage(new ImageIcon(imagePath).getImage());
                label.setIcon(ye);
            }
        });
    }

    // Método da foto e do texto (label)
    private static JLabel getLabel (ImageIcon ye){
        JLabel label = new JLabel();
        label.setText("<HTML><center>I hate being<br> <br>its awesome</HTML>");
        label.setIcon(ye);
        //label.setHorizontalTextPosition(JLabel.CENTER ou JLabel.LEFT ou JLabel.RIGHT);
        //label.setVerticallyTextPosition(JLabel.BOTTOM ou JLabel.TOP ou JLabel.CENTER
        label.setHorizontalTextPosition(JLabel.CENTER);
        label.setVerticalTextPosition(JLabel.CENTER);
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setVerticalAlignment(JLabel.CENTER);
        label.setForeground(Color.green);
        label.setFont(new Font("Yung Jakes New Handwriting", Font.PLAIN, 50));
        label.setIconTextGap(10);
        label.setBackground(Color.black);
        label.setOpaque(true);
        return label;
    }
}