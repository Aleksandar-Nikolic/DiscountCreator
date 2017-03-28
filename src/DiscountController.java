
import java.awt.event.*;
import java.io.*;

import javax.swing.JFileChooser;

public class DiscountController {

    private DiscountView view;
    private DiscountModel model;

    public DiscountController(DiscountView view, DiscountModel model) {

        this.view = view;
        this.model = model;

        // adding listeners for buttons
        this.view.addCalculateListener(new CalculateListener());
        this.view.addOutputListener(new OutputListener());
        this.view.addSaveListener(new SaveListener());
    }

    // action that happens on pressing Calculate button
    public class CalculateListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {

            try {
                view.setDiscountSignificance(
                        model.discountSignificance(view.getOriginalPrice(), view.getDiscountedPrice()));
            } catch (InputException ex) {
                view.displayErrorMessage(ex.getMessage());
            } catch (Exception ex) {
                view.displayErrorMessage("Type correct values!");
            }

        }
    }

    // action that happens on pressing output (Put in report) button
    public class OutputListener implements ActionListener {

        public void actionPerformed(ActionEvent ae) {

            try {

                if (!view.getProductName().getText().isEmpty()) {
                    view.getSavedDiscounts().append(" " + view.getProductName().getText() + ": ");
                }

                view.getSavedDiscounts().append(view.getOriginalPrice()
                        + " to " + view.getDiscountedPrice());

                if (!view.getStartingDate().getText().isEmpty() && !view.getEndingDate().getText().isEmpty()) {
                    view.getSavedDiscounts().append(" (" + view.getStartingDate().getText() + " - "
                            + view.getEndingDate().getText() + ")");

                } else if (!view.getStartingDate().getText().isEmpty()) {
                    view.getSavedDiscounts().append(" (from " + view.getStartingDate().getText()
                            + ")");

                } else if (!view.getEndingDate().getText().isEmpty()) {
                    view.getSavedDiscounts().append(" (until "
                            + view.getEndingDate().getText() + ")");
                }

                view.getSavedDiscounts().append(" ---> " + view.getDiscountSignificance().getText() + "\n");

            } catch (Exception ex) {
                view.displayErrorMessage("Type correct values!");
            }
        }

    }

    // action that happens on pressing Save button
    public class SaveListener implements ActionListener {

        public void actionPerformed(ActionEvent ae) {

            String textReport = view.getSavedDiscounts().getText();

            JFileChooser fileChooser = new JFileChooser();
            if (fileChooser.showSaveDialog(view) == JFileChooser.APPROVE_OPTION) {
                File file = fileChooser.getSelectedFile();
                BufferedWriter out;
                try {
                    out = new BufferedWriter(new FileWriter(file));
                    view.getSavedDiscounts().write(out);
                    out.flush();
                    out.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }

        }

    }

}
