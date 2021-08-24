import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class Driver {
    private Users users;
    private Products prod;

    public Driver() throws IOException {
            prod = new Products();
            prod.readCSV_writeTXT();
            prod.readTXT();
            FileWriter myWriter = new FileWriter("users.txt");

            users = new Users(prod);
            users.addCustomer("Sevra",  "123456", myWriter);
            users.addCustomer("Hatice",  "123456", myWriter);
            users.addCustomer("Ayşe",  "123456", myWriter);
            users.addCustomer("Elif",  "123456", myWriter);
            users.addCustomer("Burak",  "123456", myWriter);
            users.addCustomer("Mehmet",  "123456", myWriter);
            users.addCustomer("Kerem",  "123456", myWriter);
            users.addCustomer("Selin",  "123456", myWriter);
            users.addCustomer("Leyla",  "123456", myWriter);
            users.addCustomer("Ahmet",  "123456", myWriter);
            users.addCustomer("Mustafa",  "123456", myWriter);
            users.addCustomer("Esma",  "123456", myWriter);
            users.addCustomer("Betül",  "123456", myWriter);
            users.addCustomer("Ceyda",  "123456", myWriter);
            users.addTrader(myWriter, prod);
            myWriter.close();
            prod.readTXT();
        users.traderName = "Alisha";

            traderTest();
            customerTest();

        }


        public void customerTest() throws IOException {
            System.out.println("\n---------------filter the price with lower threshold(2000)-------------------");
            prod.thresholds("Cycling", 2000, 9999999);

            System.out.println("\n---------------filter the price with upper threshold(1000)-------------------");
            prod.thresholds("Cycling",0, 1000);

            System.out.println("\n---------------filter the price with lower(1000) and upper(1500) threshold-------------------");
            prod.thresholds("Cycling",1000, 1500);





            System.out.println("\n---------------decreasing order of the product name-------------------");
            prod.searchWithName("Cycling",1);
            System.out.println("\n---------------decreasing order of the price-------------------");
            prod.searchWithName("Cycling",2);
            System.out.println("\n---------------increasing order of the price-------------------");
            prod.searchWithName("Cycling",3);

            System.out.println("\n---------------show all products of 999store-------------------");
            prod.searchWithTraderName("999store");


        }


        public void traderTest() throws IOException {
            System.out.println("\n----------------List previous orders-------------------");
            users.listOrder();

            System.out.println("\n\n----------------Cancel 2. order-------------------");
            users.orderManaging(2, 2);

            System.out.println("\n\n----------------Updated order list after cancelling-------------------");
            users.listOrder();

            System.out.println("\n\n----------------Approve 5. order-------------------");
            users.orderManaging(5, 1);

            System.out.println("\n\n----------------Updated order list after approving-------------------");
            users.listOrder();

            System.out.println("\n\n----------------Add Product-------------------");
            System.out.println("\"TESTID11111\", \"Blue GTU Sweatshirt\", \"Clothes>>Sportswear>>Sweatshirts\", \"120\", \"90\" New Gebze Technical University Sweatshirt. Sky Blue. %100 cotton.\" added");
            System.out.println("\nCheck from the product file ");

            users.writeToFile("TESTID11111", "Blue GTU Sweatshirt", "Clothes>>Sportswear>>Sweatshirts", "120", "90",
                    "New Gebze Technical University Sweatshirt. Sky Blue. %100 cotton.");

            System.out.println("\n\n----------------Remove Product -------------------");
            System.out.println("PWTEB7H2E4KCYUE3  - ID of the product to be removed");

            users.removeProduct("PWTEB7H2E4KCYUE3");
            System.out.println("Check from the product file ");




            System.out.println("\n\n----------------Edit Name of the Product-------------------");
            System.out.println("SRTEH2F6HUZMQ6SJ  - ID of the product to be edited");
            users.editProduct("SRTEH2F6HUZMQ6SJ", 3, "111111");
            System.out.println("Check from the product file ");


        }
}
