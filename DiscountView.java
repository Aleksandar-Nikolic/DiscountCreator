
import java.awt.*;
import java.awt.event.ActionListener;

import javax.swing.*;

public class DiscountView extends JFrame {

    private JLabel label1 = new JLabel("Insert original price:");
    private JTextField originalPrice = new JTextField(12);
    private JLabel label2 = new JLabel("Insert discounted price:");
    private JTextField discountedPrice = new JTextField(10);
    private JButton calculate = new JButton("Calculate");
    private JLabel discountSignificance = new JLabel();
    private JLabel label3 = new JLabel("Insert the name of the product:");
    private JTextField productName = new JTextField(16);
    private JLabel label4 = new JLabel("Discount will last from:");
    private JTextField startingDate = new JTextField(9);
    private JLabel label5 = new JLabel("to");
    private JTextField endingDate = new JTextField(9);
    private JTextArea savedDiscounts = new JTextArea();
    private JButton output = new JButton("Put in report");
    private JButton save = new JButton("Save the report");

    public DiscountView() {

        this.setTitle("Discount Creator");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(700, 505);
        this.setLocation(100, 150);
        this.setResizable(false);

        JPanel northPanel = new JPanel();

        northPanel.setBorder(BorderFactory.createEmptyBorder(15, 8, 8, 8));
        northPanel.setLayout(new GridLayout(4, 1, 10, 20));

        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();
        JPanel panel3 = new JPanel();
        JPanel panel4 = new JPanel();
        JPanel centerPanel = new JPanel();
        JPanel southPanel = new JPanel();

        panel1.setLayout(new FlowLayout(FlowLayout.LEFT, 8, 3));
        panel2.setLayout(new FlowLayout(FlowLayout.LEFT, 8, 3));
        panel3.setLayout(new FlowLayout(FlowLayout.CENTER, 8, 3));
        panel4.setLayout(new FlowLayout(FlowLayout.CENTER, 8, 3));

        panel1.add(label1);;
        panel1.add(originalPrice);
        panel1.add(Box.createHorizontalStrut(5));
        panel1.add(label3);
        panel1.add(productName);

        panel2.add(label2);
        panel2.add(discountedPrice);
        panel2.add(Box.createHorizontalStrut(5));
        panel2.add(label4);
        panel2.add(startingDate);
        panel2.add(label5);
        panel2.add(endingDate);

        panel3.add(calculate);

        panel4.add(discountSignificance);

        northPanel.add(panel1);
        northPanel.add(panel2);
        northPanel.add(panel3);
        northPanel.add(panel4);

        centerPanel.add(output);
        centerPanel.add(save);

        savedDiscounts.setEditable(false);

        JScrollPane scroll = new JScrollPane(savedDiscounts);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scroll.setPreferredSize(new Dimension(650, 200));

        southPanel.setLayout(new BorderLayout());
        southPanel.add(scroll, BorderLayout.NORTH);
        southPanel.add(new ThreadTips(), BorderLayout.SOUTH);

        this.setLayout(new BorderLayout());
        this.add(northPanel, BorderLayout.NORTH);
        this.add(centerPanel, BorderLayout.CENTER);
        this.add(southPanel, BorderLayout.SOUTH);

        this.setVisible(true);
    }

    public Double getOriginalPrice() {
        return Double.parseDouble(originalPrice.getText());
    }

    public double getDiscountedPrice() {
        return Double.parseDouble(discountedPrice.getText());
    }

    public JTextArea getSavedDiscounts() {
        return savedDiscounts;
    }

    public JLabel getDiscountSignificance() {
        return discountSignificance;
    }

    public JTextField getProductName() {
        return productName;
    }

    public JTextField getStartingDate() {
        return startingDate;
    }

    public JTextField getEndingDate() {
        return endingDate;
    }

    public void setDiscountSignificance(String text) {
        discountSignificance.setText(text);
    }

    // defining methods for adding listeners in Controller part of MVC
    public void addCalculateListener(ActionListener listenForCalculate) {
        calculate.addActionListener(listenForCalculate);
    }

    public void addOutputListener(ActionListener listenForOutput) {
        output.addActionListener(listenForOutput);
    }

    public void addSaveListener(ActionListener listenForSave) {
        save.addActionListener(listenForSave);
    }

    public void displayErrorMessage(String errorMessage) {
        JOptionPane.showMessageDialog(this, errorMessage);
    }

}
