public class Beer extends Product{

    private String grade;

    public Beer(String name, double price, int value, String grade) {
        super(name, price, value);
        this.grade = grade;
    }

    @Override
    public String toString() {

        return String.format("Пиво %s %s", grade, super.toString());
    }
}
