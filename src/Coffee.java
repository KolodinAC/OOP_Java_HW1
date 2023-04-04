public class Coffee extends Product{

    private String type;

    public Coffee(String name, double price, int value, String type) {
        super(name, price, value);
        this.type = type;
    }

    @Override
    public String toString() {

        return String.format("%s кофе %s", type, super.toString());
    }
}
