import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Users {
    private int id;
    private String comingID;
    private String password;
    private String name;
    public String traderName;

    private int custCount=0;
    private int tradeCount=0;
    String userType=null;

    public Users(Products prod) throws IOException {


    }

    public void setName(String name) {
        this.name = name;
    }
    public String getName(){
        return this.name;
    }
    public void setID(String id) {
        this.comingID = id;
    }
    public String  getID(){
        return this.comingID;
    }

    public String getUserType(){
        return userType;
    }
    public void addCustomer(String name, String password, FileWriter myWriter) throws IOException {
        custCount++;
        this.id = custCount+10000000;
        this.name = name;
        this.password = password;
       //System.out.println("C: " +" " +  this.name+ " " + this.password);
       myWriter.write("Customer|" + this.id + "|" + this.password+ "|"+  this.name + "\n");
    }

    public void addTrader(FileWriter myWriter, Products products) throws IOException{

        this.password = "654321";


        for(String i: products.getTraderList()){
            tradeCount++;
            this.id = tradeCount +50000000;
            myWriter.write("Trader|" + this.id + "|" + this.password+ "|"+ i + "\n");

        }


    }



    public boolean checkInfo(String id, String password) {
        try {
            File myObj = new File("users.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String[] tokens = data.split("\\|");
                if(tokens[1].equals(id)){
                    if(tokens[2].equals(password)){
                        userType = tokens[0];
                        if(userType.equals("Trader"))
                            traderName = tokens[3];
                        return true;
                    }
                }


            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return false;
    }




    public void addProduct() throws IOException {
        System.out.println("To add a new product, enter the following information completely...");
        Scanner input = new Scanner(System.in);
        System.out.print("ID: ");
        String id = input.nextLine();
        System.out.print("Name: ");
        String name = input.nextLine();
        System.out.print("Hierarchical Category: ");
        String category = input.nextLine();
        System.out.print("Price: ");
        String price = input.nextLine();
        System.out.print("Discount amount: ");
        String discount = input.nextLine();
        System.out.print("Description: ");
        String description = input.nextLine();

        RandomAccessFile f = new RandomAccessFile("products.txt", "rw");
        long length = f.length() - 1;
        byte b;
        do {
            length -= 1;
            f.seek(length);
            b = f.readByte();
        } while (b != 10);
        f.setLength(length + 1);
        f.close();
        writeToFile(id,name, category, price, discount, description);

    }

    public void writeToFile(String id, String name, String category, String price, String discount, String description) throws IOException {
        FileWriter fr = new FileWriter("products.txt", true);
        BufferedWriter br = new BufferedWriter(fr);

        br.write(id); br.write("|");
        br.write(name); br.write("|");
        br.write("\"[\"\""); br.write(category); br.write("\"\"]\""); br.write("|");
        br.write(price); br.write("|");
        br.write(discount); br.write("|");
        br.write(description); br.write("|");
        br.write(traderName);
        br.close();
        fr.close();

    }

    public void removeProduct(String productID) throws IOException {

        String toBeRemoved = findTheLine(productID);
        if(toBeRemoved== null){
            System.out.println("\nERROR!! There is no product with given ID");
            return;
        }
        File inputFile = new File("products.txt");
        File tempFile = new File("temp.txt");

        BufferedReader reader = new BufferedReader(new FileReader(inputFile));
        BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

       // String lineToRemove = "type here the line to remove from the text";
        String currentLine;

        while((currentLine = reader.readLine()) != null) {
            String trimmedLine = currentLine.trim();
            if(trimmedLine.equals(toBeRemoved)) continue;

            writer.write(currentLine + System.getProperty("line.separator"));
        }

        writer.close();
        reader.close();

       // boolean successful = tempFile.renameTo(inputFile);
        updateFile("temp.txt", "products.txt");


    }

    private void updateFile(String sourceFile, String targetFile) throws IOException {
        var source = new File(sourceFile);
        var destination = new File(targetFile);

        try (var fin = new FileInputStream(source);
             var fout = new FileOutputStream(destination)) {
            byte[] buffer = new byte[1024];
            int length;
            while ((length = fin.read(buffer)) > 0)
                fout.write(buffer, 0, length);
        }
    }

    private String findTheLine(String productID) {
        boolean flag = true;
        try {
            File myObj = new File("products.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                flag=true;
                String data = myReader.nextLine();
                String[] tokens = data.split("\\|");
                if(myReader.hasNextLine()){
                    if(tokens[0].equals(productID))
                        return data;
                }

            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        return null;
    }

    public void editProduct(String editID, int editChoose, String newData) throws IOException {
        String oldLine = findTheLine(editID);
        String[] tokens = oldLine.split("\\|");

        if(editChoose == 2) editChoose=5;
        tokens[editChoose] = newData;


        String newLine = null;
        

        for(int i=0 ;i<tokens.length; i++) {
            //System.out.println("++ " + tokens[i]);
            if(i==0)
                newLine =tokens[i] + "|";
            else
                newLine = newLine + tokens[i] + "|";
        }
        newLine = newLine +"\n";

        //String toBeRemoved = findTheLine(productID);
        File inputFile = new File("products.txt");
        File tempFile = new File("temp.txt");

        BufferedReader reader = new BufferedReader(new FileReader(inputFile));
        BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

        // String lineToRemove = "type here the line to remove from the text";
        String currentLine;

        while((currentLine = reader.readLine()) != null) {
            String trimmedLine = currentLine.trim();
            if(trimmedLine.equals(oldLine)){
                writer.write(newLine );
            }

            writer.write(currentLine + System.getProperty("line.separator"));
        }

        writer.close();
        reader.close();

        // boolean successful = tempFile.renameTo(inputFile);
        updateFile("temp.txt", "products.txt");

    }

    public void order(ArrayList<String> list, int index, String phone, String address) throws IOException {
        FileWriter myWriter = new FileWriter("orders.txt");

            try {
                myWriter.write("not-approved");myWriter.write("|");

                myWriter.write(this.comingID);myWriter.write("|");
                myWriter.write(phone); myWriter.write("|");
              //  myWriter.write(list.get(index-5)); myWriter.write("|");
                myWriter.write(list.get(index-5)); myWriter.write("|");
                myWriter.write(list.get(index-4)); myWriter.write("|");

                // myWriter.write(list.get(index-3)); myWriter.write("|");
               // myWriter.write(list.get(index-2)); myWriter.write("|");
                myWriter.write(list.get(index-2)); myWriter.write("|"); //isim
                myWriter.write(address); myWriter.write("|");

                myWriter.write("\n");
            }
            catch (IOException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }

        myWriter.close();

    }

    public void listOrder() {
        try {
            File myObj = new File("orders.txt");
            Scanner myReader = new Scanner(myObj);
            System.out.println("\tProcess\t\t\tCustomer ID\t|Phone\t\t|Price\t|Disc.Price\t"
            +"\t|Name\t\t\t\t\t\t\t\t\t\t|Address|");
            int x=1;
            while (myReader.hasNextLine()) {

                String data = myReader.nextLine();
                String[] tokens = data.split("\\|");
                    System.out.print(x+"\t");
                    x++;
                    for(int i=0 ; i<tokens.length; i++) {
                        if(i==4)
                         System.out.print(tokens[i] + "\t\t");
                        else if(i==5)
                            System.out.print(tokens[i] + "\t\t\t");
                        else if(i==3)
                            System.out.print(tokens[i] + "\t\t\t");
                        else
                            System.out.print(tokens[i] + "\t");

                    }

                System.out.println();

            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public String listOrder(int index) {

        int ctr=0;
        String data = null;
        try {
            File myObj = new File("orders.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                data = myReader.nextLine();
            //    System.out.println("?? " + data);
                ctr++;
                if (ctr == index)
                        return data;

            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return null;
    }

    public void orderManaging(int orderIndex, int orderChoice) throws IOException {
        int editChoose=0;
        String[] tokens = new String[0];
        String oldLine = listOrder(orderIndex);
       // System.out.println("orroroor  " + oldLine);
        if(!oldLine.equals(null))
            tokens = oldLine.split("\\|");

        if(orderChoice == 1)
            tokens[editChoose] = "approved\t";
        else
            tokens[editChoose] = "canceled\t";

        String newLine = null;

        System.out.println("Situation\tCustomerID\tPhoneNumber\tPrc \tD.prc\t\tName\t\t\t\t\t\tAddress");

        for(int i=0 ;i<tokens.length; i++) {
           System.out.print( tokens[i] + "|\t");
            if(i==0)
                newLine =tokens[i] + "|";
            else
                newLine = newLine + tokens[i] + "|";
        }
        newLine = newLine +"\n";

        //System.out.println(newLine);

        //String toBeRemoved = findTheLine(productID);
        File inputFile = new File("orders.txt");
        File tempFile = new File("temp.txt");

        BufferedReader reader = new BufferedReader(new FileReader(inputFile));
        BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

        // String lineToRemove = "type here the line to remove from the text";
        String currentLine;

        while((currentLine = reader.readLine()) != null) {
            String trimmedLine = currentLine.trim();
            if(trimmedLine.equals(oldLine)){
                writer.write(newLine );
            }

            writer.write(currentLine + System.getProperty("line.separator"));
        }

        writer.close();
        reader.close();

        // boolean successful = tempFile.renameTo(inputFile);
        updateFile("temp.txt", "orders.txt");
        removeFromFile(oldLine);


    }

    private void removeFromFile(String oldLine) throws IOException {
        File inputFile = new File("orders.txt");
        File tempFile = new File("temp.txt");

        BufferedReader reader = new BufferedReader(new FileReader(inputFile));
        BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

        // String lineToRemove = "type here the line to remove from the text";
        String currentLine;

        while((currentLine = reader.readLine()) != null) {
            String trimmedLine = currentLine.trim();
            if(trimmedLine.equals(oldLine)) continue;

            writer.write(currentLine + System.getProperty("line.separator"));
        }

        writer.close();
        reader.close();

        // boolean successful = tempFile.renameTo(inputFile);
        updateFile("temp.txt", "orders.txt");
    }
}
