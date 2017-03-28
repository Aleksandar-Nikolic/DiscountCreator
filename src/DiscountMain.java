
public class DiscountMain {

    public static void main(String[] args) {

        DiscountView view = new DiscountView();
        DiscountModel model = new DiscountModel();
        DiscountController controller = new DiscountController(view, model);

    }

}
