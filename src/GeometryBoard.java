import java.awt.*;
import javax.swing.*;

public class GeometryBoard extends JPanel {
    private JButton btnCalculate;
    private JLabel lblRadius, lblHeight, lblExplanation, lblShape, lblFilePath;
    private JComboBox<String> cmbShapes;
    private JTextArea textArea;
    private JTextField userInputRadius, userInputHeight;
    private static final String[] shapes = {"Kera", "Silinder"};
    private ComboBoxListener comboBoxListener;

    public GeometryBoard() {
        setPreferredSize(new Dimension(600,400));
        setLayout(new BorderLayout());
        createComponents();

        // vaikimisi valik
        cmbShapes.setSelectedItem("Kera"); 
        userInputHeight.setVisible(false);
        lblHeight.setVisible(false);
        System.out.println("Default Selected Shape: " + cmbShapes.getSelectedItem());
}

private void createComponents() {
    Color background = new Color(196, 232, 003);
    Color resultBackground = new Color(196, 223, 003);

    JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
    JPanel inputPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
    JPanel resultPanel = new JPanel();

    // toppaneel 
    topPanel.setBackground(background);
    topPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

    // inputpaneeli omadused
    inputPanel.setBorder(BorderFactory.createEmptyBorder(25, 10, 10, 5));

    // resultpaneeli omadused
    resultPanel.setBackground(resultBackground);
    resultPanel.setBorder(BorderFactory.createEmptyBorder(5, 10, 10, 5));

    // komponendid
    lblExplanation = new JLabel("See rakendus arvutab kera ja silindri ümbermõõte, pindala ja ruumala.");
    lblShape = new JLabel("Vali kujund");
    lblRadius = new JLabel("Raadius");
    lblHeight = new JLabel("Kõrgus");

    userInputRadius = new JTextField(10);
    userInputHeight = new JTextField(10);
    btnCalculate = new JButton("Arvuta");
    textArea = new JTextArea(15, 40);
    textArea.setEditable(false);
    cmbShapes = new JComboBox<>(shapes);
    lblFilePath = new JLabel("Faili asukoht: ");

    // komboboksi listener
    comboBoxListener = new ComboBoxListener(this); 
    cmbShapes.addActionListener(comboBoxListener);

    topPanel.add(lblExplanation);
    topPanel.add(lblShape);

    inputPanel.add(cmbShapes);
    inputPanel.add(lblRadius);
    inputPanel.add(userInputRadius);
    inputPanel.add(lblHeight);
    inputPanel.add(userInputHeight);
    inputPanel.add(btnCalculate);

    // resultpaneeli sisu koos tekstiga
    resultPanel.add(new JScrollPane(textArea));
    resultPanel.add(lblFilePath);

    // String resultText = "Raadius: " + calculatedRadius + "\n";
    // String radiusText = userInputRadius.getText();  // kasutaja sisestatud raadius
    // String heightText = userInputRadius.getText();  // kasutaja sisestatud kõrgus

    add(topPanel, BorderLayout.NORTH);
    add(inputPanel, BorderLayout.CENTER);
    add(resultPanel, BorderLayout.SOUTH);

    }
    // lisab teksti textareasse
    public void appendText(String text) {
        textArea.append(text + "\n");
    }

    public JTextField getUserInputRadius() {
        return userInputRadius;
    }

    public JTextField getUserInputHeight() {
        return userInputHeight;
    }

    public JButton getBtnCalculate() {
        return btnCalculate; 
    }

    public JTextArea getTextArea() {
        return textArea; 
    }

    public JComboBox<String> getCmbShapes() {
        return cmbShapes;
    }

    public JLabel getLblRadius() {
        return lblRadius;
    }

    public JLabel getLblHeight() {
        return lblHeight;
    }

    public GeometryBoard getGeometryBoard() {
        return this;
    }

    public void setFilePath(String filePath) {
        textArea.append("Faili asukoht: " + filePath + "\n");
    }
}