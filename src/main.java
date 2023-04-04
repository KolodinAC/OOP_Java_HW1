import java.util.Scanner;

public class main {
    public static void main(String[] args) throws Exception {
        Scanner iScanner = new Scanner(System.in);
        VendingMachine mart = new VendingMachine();
        mart.addProduct(new Product("Хлеб", 35, 10))
                .addProduct(new Milk("Простоквашино", 50, 2))
                .addProduct(new Product("Сыр Гауда", 130, 5))
                .addProduct(new ConcentrateMilk("Советская", 150, 1))
                .addProduct(new Chocolate("Аленка", 30, 3, "Молочный"))
                .addProduct(new Kolbasa("Швейцарская", 120, 10, "Копченая"))
                .addProduct(new Coffee("Арабика", 400, 3, "Зерновой"))
                .addProduct(new Coffee("Туфта 3 в 1", 200, 2, "Растворимый"))
                .addProduct(new Beer("Мохнатый Шмель", 150, 2, "IPA"))
                .addProduct(new Beer("Команчи", 100, 2, "APA"));

        System.out.println("\nДобро пожаловать в наш торговый автомат 'Перекуси' !");
        boolean flag = true;
        while (flag) {
            System.out.println("\nВведите доступную команду: ");
            System.out.println("1. Вывести список доступных товаров");
            System.out.println("2. Поиск товара");
            System.out.println("3. Приобрести товар");
            System.out.println("4. Выход");
            System.out.println();
            System.out.print("Команда: ");

            String usercommand = iScanner.nextLine();

            switch (usercommand) {
                case ("1") -> {
                    System.out.println("Сейчас в наличии: ");
                    System.out.println(mart);
                }
                case ("2") -> {
                    System.out.print("Введите название товара: ");
                    String usersearch = iScanner.nextLine();
                    var search = mart.searchProduct(usersearch);
                    System.out.println(String.format("Найден следующий товар в автомате: %s: ", search));
                }
                case ("3") -> {
                    System.out.print("Введите название товара для покупки: ");
                    String userbuy = iScanner.nextLine();
                    var search = mart.searchProduct(userbuy);
                    System.out.print("Внесите денежные средства в размере " + search.getPrice() + " руб.: " );
                    Double usercash = iScanner.nextDouble();
                    var res = VendingMachine.checkOut(search.getPrice(), usercash);
                    System.out.println("Спасибо, что воспользовались нашим тороговым автоматом!");
                    flag = false;
                }
                case ("4") -> {
                    System.out.println("Спасибо, что воспользовались нашим тороговым автоматом!");
                    flag = false;
                }
            }
        }
    }

    public static void PrintSell(VendingMachine machine, String nameProd) {
        try {
            System.out.println(machine.sell(nameProd));
        } catch (Exception e) {
            System.out.println("Товар не найден");
        }
    }
}

