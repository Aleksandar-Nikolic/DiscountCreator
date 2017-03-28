
import javax.swing.*;

// making a thread for showing tips
public class ThreadTips extends JPanel implements Runnable {

    String tip1 = "51% of people view the discount of 24% as significant.";
    String tip2 = "People prefer rounded discounts.";
    String tip3 = "Every discount over 50% is viewed as significant by more than 90% of people.";
    String tip4 = "Discounts are more significant if the discounted item is expensive.";

    private JLabel tip = new JLabel(tip1);

    private String[] tips = {tip1, tip2, tip3, tip4};

    public ThreadTips() {
        add(tip);
        new Thread(this).start();
    }

    @Override
    public void run() {

        while (true) {

            try {
                for (int k = 0; k < tips.length; k++) {
                    tip.setText(tips[k]);
                    Thread.sleep(7000);
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

    }

}
