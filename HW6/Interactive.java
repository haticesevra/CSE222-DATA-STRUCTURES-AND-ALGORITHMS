
import java.util.Scanner;
import java.io.IOException;
import java.io.*;

public class Interactive {
    private Users users;
    private Products prod;
    private Products currentProd;
    private int currentSize=0;

    public Interactive() throws IOException {
        prod = new Products();
        prod.readCSV_writeTXT();
        prod.readTXT();
        currentProd = new Products();
        FileWriter myWriter = new FileWriter("users.txt");

        users = new Users(prod);
        users.addCustomer("Sevra",  "123456", myWriter);
        users.addCustomer("Hatice",  "123456", myWriter);
        users.addCustomer("Ayşe",  "123456", myWriter);
        users.addCustomer("Elif",  "123456", myWriter);
        users.addCustomer("Ali",  "123456", myWriter);
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
        mainMenu();
    }

    public void mainMenu() throws IOException {
        System.out.println("\n------WELCOME-----");
        System.out.println("1- LOGIN");
        System.out.println("2- EXIT");
        Scanner input = new Scanner(System.in);
        System.out.print("Choose...  ");
        int choice = input.nextInt();
        if(choice==1)
            logIn();
        else if(choice==2){/*Intentionally empty*/        }
        else
            System.out.println("ERROR - Invalid choose");
    }


    public void logIn() throws IOException {
        Scanner input = new Scanner(System.in);
        String id, password;
        do {
            System.out.print("Enter ID: ");
            id = input.nextLine();
            if (id.length() != 8)
                System.out.println("ERROR - ID must be 8 character!");
        }while(id.length() != 8);
        users.setID(id);
        do {
            System.out.print("Enter PASSWORD: ");
            password = input.nextLine();
            if (password.length() != 6)
                System.out.println("ERROR - PASSWORD must be 6 character!");
        }while(password.length()!=6);

        if (users.checkInfo(id, password)) {
            System.out.println("Log in successful.");
            if(users.getUserType().equals("Customer"))
                customerMenu();
            else
                traderMenu();
        } else {
            System.out.println("Login failed. Check the informations.");
            mainMenu();
        }
    }

    public void traderMenu() throws IOException {
        System.out.println("\nMENU FOR TRADERS");
        System.out.println("1- Add Product");
        System.out.println("2- Remove Product");
        System.out.println("3- Edit Product");
        System.out.println("4- List of Orders");
        System.out.println("5- Manage Orders"); //meet or cancel
        Scanner input = new Scanner(System.in);
        int choice = input.nextInt();
        switch (choice){
            case 1:
                users.addProduct();
                break;
            case 2:
                System.out.print("Enter the ID of the product to be removed: ");
                input.nextLine();
                String prodID = input.nextLine();
                users.removeProduct(prodID);
                break;
            case 3:
                System.out.print("Enter the ID of the product to be edited: "); input.nextLine();
                String editID = input.nextLine();

                System.out.println("\n1- Edit Name");
                System.out.println("2- Edit Description");
                System.out.println("3- Edit Price");
                System.out.println("4- Edit Discounted Price");
                System.out.print("Choose... ");
                int editChoose = input.nextInt();
                System.out.print("Enter the updated data: ");input.nextLine();
                String newData = input.nextLine();
                users.editProduct(editID, editChoose, newData);
                break;
            case 4:
                users.listOrder();
                break;
            case 5:
                users.listOrder();
                System.out.println("Enter the index of order you wanted to process... ");
                int orderIndex = input.nextInt();
                System.out.println("1- Meet the Order");
                System.out.println("2- Cancel the Order");
                int orderChoice = input.nextInt();
                users.orderManaging(orderIndex, orderChoice);
                break;

        }

    }

    public void customerMenu() throws IOException {
        System.out.println("\nMENU FOR CUSTOMERS");
        System.out.println("1- Search products with name");
        System.out.println("2- Show all products of a trader"); //ok
        Scanner input = new Scanner(System.in);
        int choice = input.nextInt();

        if(choice == 1){
            System.out.print("Enter the product name you wanted to search...");
            Scanner entry = new Scanner(System.in);
            String pName = entry.nextLine();
            System.out.println("\n1- Select sorting type");
            System.out.println("2- Sort default"); //ok
            System.out.println("3- Narrow the search by price range"); //ok
            System.out.println("4- Narrow the search by entering category");
            System.out.print("Choose...");
            int sort = input.nextInt();

            if(sort==1){ //select sorting type
                System.out.println("1- Show in decreasing order of the product name");
                System.out.println("2- Show in decreasing order of the price"); //ok
                System.out.println("3- Show in increasing order of the price"); //ok
                System.out.println("4- Show in increasing order of the discount percentage"); //ok
                System.out.println("5- Show in decreasing order of the discount percentage"); //ok
                int sortType = input.nextInt();
                currentSize = prod.searchWithName(pName, sortType);
            }
            else if(sort==2)    //sort default
                currentSize = prod.searchWithName(pName, -1);
            else if(sort==3){ // Narrow the search by price range
                System.out.println("1- Lower threshold"); //ok
                System.out.println("2- Upper threshold");  //ok
                System.out.println("3- Upper and Lower threshold"); //ok
                int hold = input.nextInt();
                if(hold==1){ //lower
                    System.out.print("Enter the lower threshold... ");
                    int lower = input.nextInt();
                    prod.thresholds(pName, lower, 9999999);
                }
                else if(hold==2){
                    System.out.print("Enter the upper threshold... ");
                    int upper = input.nextInt();
                    prod.thresholds(pName,0, upper);
                }
                else if(hold==3){
                    System.out.print("Enter the lower threshold... ");
                    int lower = input.nextInt();
                    System.out.print("Enter the upper threshold... ");
                    int upper = input.nextInt();
                    prod.thresholds(pName, lower, upper);
                }
                else
                    System.out.println("Invalid choose");
            }
            else if(sort == 4){ //Narrow the search by entering category
                prod.categorize();

            }
            else
                System.out.println("Invalid Choose");

            buyInformations();
        }
        else if(choice==2){  //show all products of a trader
            System.out.print("Enter the name of the trader... ");
            String tradName = input.nextLine();
            tradName = input.nextLine();
            currentProd = prod.searchWithTraderName(tradName);
            currentSize = prod.list.size();
            buyInformations();
        }
        else
            System.out.println("ERROR - Invalid choice");
    }

    private void buyInformations() throws IOException {
        System.out.print("\nEnter the index of the product you wanted to buy... ");
        Scanner input = new Scanner(System.in);
        int index = input.nextInt();

        if(currentSize>=index && index>0){
            System.out.print("Enter the delivery address:  ");
            input.nextLine();
            String  address = input.nextLine();
            System.out.print("Enter the phone number:  ");
            String  phone = input.nextLine();
            users.order(prod.list, index, phone, address );
        }
        else
            System.out.println("Invalid index");
    }
}
