import java.util.ArrayList;
import java.util.List;


public class VendingMachine {
    private List<Product> products = new ArrayList<>();
    private double money = 0;

    public VendingMachine addProduct(Product product) {
        products.add(product);
        return this;
    }

    public Product searchProduct(String name) {
        for (Product item : products) {
            if (item.getName().equals(name)) {
                return item;
            }
        }
        return null;
    }

    public Product sell(String name) throws Exception {
        Product target = searchProduct(name);
        try {
            if (!target.sellCounter()){
                products.remove(target);

            }
            this.money += target.getPrice();
        } catch (NullPointerException e) {
            throw new Exception("Товар не найден", e);
        }

        return target;
    }

    public static double checkOut(double prodprice, double usermoney) {
        double result = usermoney - prodprice;
        if (result >= 0){
            System.out.println("Благодарим за покупку! На вашем балансе осталось: " + result + " рублей");
        }
        else {
            System.out.println("Недостаточно средств!");
        }
        return result;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        for (Product item : products) {
            res.append(item);
            res.append("\n");
        }
        res.append(String.format("В автомате сейчас %.2f рублей", money));
        return res.toString();
    }
}