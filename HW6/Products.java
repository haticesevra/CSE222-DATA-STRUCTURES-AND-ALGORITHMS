import java.io.File;
import java.util.*;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;


public class Products {
    public ArrayList<String> traderList;
    public ArrayList<String > list;
    private int numOfTraders=0;
    private TreeNode root;
    private LinkedList<String> printed;

    public Products(){
        traderList = new ArrayList<>();
        printed = new LinkedList<>();
    }

    public ArrayList<String> getTraderList(){
        return traderList;
    }

    public int getNumOfTraders(){
        return numOfTraders;
    }

    public void readCSV_writeTXT() throws IOException {
        Scanner sc = new Scanner(new File("e-commerce-samples.csv"));
        sc.useDelimiter(";");
        FileWriter myWriter = new FileWriter("products.txt");
        while (sc.hasNext()){
            try {
                myWriter.write(sc.next());
                myWriter.write("|");
            }
            catch (IOException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }
        }
        myWriter.close();
        sc.close();
    }


    public void readTXT(){
        boolean flag = true;
        try {
            File myObj = new File("products.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                flag=true;
                String data = myReader.nextLine();
                String[] tokens = data.split("\\|");
                if(myReader.hasNextLine()){
                    for(String i : traderList)
                        if(tokens[6].equals(i)){
                            flag=false;
                            break;
                        }
                    if(flag){
                        traderList.add(tokens[6]);
                        numOfTraders++;
                    }
                }

            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }


    public void categorize(){
        root = new TreeNode("Categories");
        try {
            int max=0;
            File myObj = new File("products.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String[] tokens = data.split("\\|");
                if(myReader.hasNextLine()) {
                    String[] tokens2 = tokens[2].split("\\>>");
                    addCategory(tokens2);
                    for(int i=0; i<tokens2.length; i++) {
                        System.out.println("&& " + tokens2[i]);
                    }

                }
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

    }


    private int i1=0, i2=0, indexBefore;
    public void addCategory(String[] category) {
        int flag = 0;
        TreeNode currentNode = null;
        for (int i = 0; i < category.length; i++) {
            if (i == 0) {
                System.out.println("i1  " + category[0]);
                if (!find(category[0])) {
                    root.children.add(new TreeNode(category[0]));
                   currentNode=root;
                }
            } else if (i == 1) {
                System.out.println("i2   " + category[i]);
                if (!find(category[i])) {
                    System.out.println("i222");
                 //   currentNode.children.add(new TreeNode(category[i]));

                    if(flag==0)
                        root.children.add(new TreeNode(category[i]));
                    i2++;
                    break;
                }
            }
        }

       // printCategories(root);

        printNAryTree(root);
    }


    private static void printNAryTree(TreeNode root){
        if(root == null) return;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()) {
            int len = queue.size();
            for(int i=0;i<len;i++) { // so that we can reach each level
                TreeNode node = queue.poll();
                System.out.print(node.val + " ");
                for (TreeNode item : node.children) { // for-Each loop to iterate over all childrens
                    queue.offer(item);
                }
            }
            System.out.println();
        }
    }
    public void printCategories(TreeNode root) {
        System.out.println("prprprprpprpr");
        if (root == null) return;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                TreeNode node = queue.poll();
                assert node != null;
                System.out.print(node.val + " ");
                for (TreeNode item : node.children) {
                    queue.offer(item);
                }
            }
            System.out.println();
        }
    }

    private boolean find(String value){
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                TreeNode node = queue.poll();
                assert node != null;
               // System.out.print(node.val + " ");
                if(node.val == value)
                    return true;
                for (TreeNode item : node.children) {
                    queue.offer(item);
                }
            }
            System.out.println();
        }
        return false;
    }



    public void findName(String pName) throws FileNotFoundException {
        list = new ArrayList<>();
        //System.out.println("ss " + pName);
        File myObj = new File("products.txt");
        Scanner myReader = new Scanner(myObj);
        int found;
        Queue<String> temp= new LinkedList<>();
        while (myReader.hasNextLine()) {
            String data = myReader.nextLine();
            String[] tokens = data.split("\\|");
            found=0;
            if (myReader.hasNextLine()) {
                // System.out.println("name " + tokens[1]);
                //   System.out.println("desc " + tokens[5]);
                if(myReader.hasNextLine()) {
                    String[] tokens2 = tokens[1].split("\\ ");
                    for(int i=0; i<tokens2.length; i++){
                        //  System.out.println("tok2 " + tokens2[i]);
                        if(tokens2[i].equals(pName)) {
                            //   System.out.println("bulundu "  );
                            list.add(tokens[0]);
                            list.add(tokens[1]);
                            list.add(tokens[5]);
                            list.add(tokens[6]);
                            list.add(tokens[3]);
                            list.add(tokens[4]);
                            found=1;
                            break;
                        }
                    }
                    if(found==0) {
                        String[] tokens3 = tokens[5].split("\\ ");
                        for (int i = 0; i < tokens3.length; i++) {
                            //  System.out.println("tok2 " + tokens2[i]);
                            if (tokens3[i].equals(pName)) {
                                list.add(tokens[0]);
                                list.add(tokens[1]);
                                list.add(tokens[5]);
                                list.add(tokens[6]);
                                list.add(tokens[3]);
                                list.add(tokens[4]);

                                break;
                            }
                        }
                    }
                }
            }


        }
        myReader.close();
    }

    public int searchWithName(String pName, int sortType) throws FileNotFoundException {
        findName(pName);
        /*
        System.out.println("çokkkkk");

       for(int i=0; i<list.size(); i++){
          System.out.println(list.get(i));
       }
        System.out.println("koççççç");
        */

        Iterator iterator = list.iterator();


       ArrayList<Integer> prices = new ArrayList<>();
       // ArrayList<Integer> discPrices = new ArrayList<>();

        ArrayList<ArrayList<ArrayList<Integer>>> discPerc =  new ArrayList<>(list.size());

        for (int i = 0; i < list.size(); i++) {
            discPerc.add(new ArrayList<ArrayList<Integer>>(list.size()));
            for (int j = 0; j < list.size(); j++) {
                discPerc.get(i).add(new ArrayList<Integer>(list.size()));
            }
        }
        System.out.println();


        if(sortType == -1){ //default
            int ctr=1;
            printed = new LinkedList<>();
            for(int i=0; i<list.size(); i++){

                if(i%6 == 0 && !prt(printed,list.get(i))){
                    System.out.println("[" + ctr +"]");
                    System.out.println("Product ID: " + list.get(i));
                    ctr++;
                    printed.add(list.get(i));
                }
                else if(i%6 == 1)
                    System.out.println("Product Name: " + list.get(i));
                else if(i%6 == 2)
                    System.out.println("Product Description: " + list.get(i));
                else if(i%6 == 3)
                    System.out.println("Product Trader: " + list.get(i));
                else if(i%6 == 4)
                    System.out.println("Product Price: " + list.get(i));
                else
                    System.out.println("Product Discounted Price: " + list.get(i) + "\n");

            }

        }
        else if(sortType == 1){ //decreasing name
            int x=0, ctr=1;
            Hashtable<Integer, String> hash = new Hashtable<>();
            for(int i=0; i<list.size(); i++){
                if(i%6 == 1)  {
                  //  System.out.println(": "+ list.get(i));
                    hash.put(x, list.get(i));
                    x++;
                }
            }
           // System.out.println("Mappings of ht1 : " + hash.get(27));
            x=0;
            for(int i=0; i<hash.size(); i++){
                for(int j=0; j<list.size(); j++){

                    if(x==1){
                       // System.out.println("son "+ list.get(j));

                        if(list.get(j).equals(hash.get(i))
                                && !prt(printed,list.get(j-1))){
                            System.out.println("[" + ctr +"]");
                            System.out.println("Product ID:" + list.get(j-1));
                            printed.add(list.get(j-1));
                            System.out.println("Product Name:" + list.get(j));
                            System.out.println("Product Description:" + list.get(j+1));
                            System.out.println("Product Trader:" + list.get(j+1));
                            System.out.println("Product Price:" + list.get(j+3));
                            System.out.println("Product Discounted Price:" + list.get(j+4));
                            System.out.println();
                            ctr++;
                        }
                        x=-1;
                    }
                    else
                        x++;

                }
            }



        }
        else if(sortType == 2){ //decreasing price
            int x=0;
            for(int i=0; i<list.size(); i++){
                if(x==4){
                    //  System.out.println(list.get(i));
                    prices.add(Integer.valueOf(list.get(i)));
                    x=-1;
                }
                else
                    x++;

            }
            selectionSort(prices);
            x=0;
            int ctr=1;
            printed = new LinkedList<>();
            for(int i=0; i<prices.size(); i++){
                //  System.out.println("son");
                for(int j=0; j<list.size(); j++){
                    if(x==4){
                        if(Integer.valueOf(list.get(j)).equals(prices.get(i))
                                && !prt(printed,list.get(j-4))){
                            System.out.println("[" + ctr +"]");
                            System.out.println("Product ID:" + list.get(j-4));
                            printed.add(list.get(j-4));
                            System.out.println("Product Name:" + list.get(j-3));
                            System.out.println("Product Description:" + list.get(j-2));
                            System.out.println("Product Trader:" + list.get(j-1));
                            System.out.println("Product Price:" + list.get(j));
                            System.out.println("Product Discounted Price:" + list.get(j+1));
                            System.out.println();
                            ctr++;

                        }
                        x=-1;
                    }
                    else
                        x++;

                }
            }
        }
        else if(sortType == 3){ //increaisng price
            printed = new LinkedList<>();
            int x=0;
            for(int i=0; i<list.size(); i++){
                if(x==4){
                  //  System.out.println(list.get(i));
                    prices.add(Integer.valueOf(list.get(i)));
                    x=-1;
                }
                else
                    x++;

            }
            insertionSort(prices, prices.size());
            x=0; int ctr=1;
            for(int i=0; i<prices.size(); i++){
                //  System.out.println("son");
                for(int j=0; j<list.size(); j++){
                    if(x==4){
                        if(Integer.valueOf(list.get(j)).equals(prices.get(i))
                                && !prt(printed,list.get(j-4))){
                            System.out.println("[" + ctr +"]");
                            System.out.println("Product ID:" + list.get(j-4));
                            printed.add(list.get(j-4));
                            System.out.println("Product Name:" + list.get(j-3));
                            System.out.println("Product Description:" + list.get(j-2));
                            System.out.println("Product Trader:" + list.get(j-1));
                            System.out.println("Product Price:" + list.get(j));
                            System.out.println("Product Discounted Price:" + list.get(j+1));
                            System.out.println();
                            ctr++;
                        }
                        x=-1;
                    }
                    else
                        x++;

                }
            }
        }

        else if(sortType == 4 || sortType == 5){ //decreasing discount
            ArrayList<String> copyList = new ArrayList<>();
            ArrayList<Integer> per = new ArrayList<>();

            for(int i=0; i<list.size(); i++)
                copyList.add(list.get(i));
            int x=0, z=0;

            for(int i=0; i<copyList.size(); i++){
                if(x==6){
                  //  System.out.println("== " + copyList.get(i));
                    int price = Integer.valueOf(copyList.get(i-2));
                    int discounted =  Integer.valueOf(copyList.get(i-1));
                    int percentage = calculatePercentage(price, discounted);
                    per.add(percentage);
                    copyList.add(i, String.valueOf(percentage));
                    x=0;
                }
                else
                    x++;

            }

           // for(int i=0; i<list.size(); i++)
         //       System.out.println(copyList.get(i));

            if(sortType == 4)
                insertionSort(per, per.size());
            else
                selectionSort(per);

           // System.out.println("45 " + per);
            printWithDiscount(per, copyList);



        }


        return list.size();
    }

    private void printWithDiscount(ArrayList<Integer> per, ArrayList<String> copyList) {
        int ctr=1;
        for(int i=0; i<per.size(); i++){
          //  System.out.println("lelelelel");
           int x=0;
            for(int j=0; j<copyList.size(); j++){
                if(x==6){
                    if(Integer.valueOf(copyList.get(j)).equals(per.get(i))
                            && !prt(printed,copyList.get(j-6) )){
                        System.out.println("[" + ctr +"]");
                        System.out.println("Discount Percentage:" + copyList.get(j));
                        System.out.println("Product ID:" + copyList.get(j-6));
                        printed.add(copyList.get(j-6));

                        System.out.println("Product Name:" + copyList.get(j-5));
                        System.out.println("Product Description:" + copyList.get(j-4));
                        System.out.println("Product Trader:" + copyList.get(j-3));
                        System.out.println("Product Price:" + copyList.get(j-2));
                        System.out.println("Product Discounted Price:" + copyList.get(j-1));

                        System.out.println();
                        ctr++;
                    }
                    x=0;
                }
                else
                    x++;

            }
        }

    }

    private boolean prt(LinkedList<String> printed, String s) {
        for(String i : printed){
            if(i.equals(s))
                return true;
        }
        return false;
    }

    public int calculatePercentage(int price, int discountedPrice){
        return ((price-discountedPrice)*100)/price;
    }


    public void insertionSort(ArrayList<Integer> arr, int size){
            if (size <= 1)
                return;
            insertionSort( arr, size-1 );
            int last = arr.get(size-1);
            int j = size-2;

            while (j >= 0 && arr.get(j) > last){
                arr.set(j+1, arr.get(j));
                j--;
            }
            arr.set(j+1, last);
        }


        public void selectionSort(ArrayList<Integer> arr){
                for (int i = 0; i < arr.size() - 1; i++) {
                    int maxElementIndex = i;
                    for (int j = i + 1; j < arr.size(); j++) {
                        if (arr.get(maxElementIndex) < arr.get(j)) {
                            maxElementIndex = j;
                        }
                    }

                    if (maxElementIndex != i) {
                        int temp = arr.get(i);
                        arr.set(i, arr.get(maxElementIndex));
                        arr.set(maxElementIndex,  temp);
                    }
                }
            }



    public void thresholds(String pName, int lower, int upper) throws FileNotFoundException {
            findName(pName);
            int x=0, ctr=1;

            for(int j=0; j<list.size(); j++){
                if(x==4){
                    if(Integer.valueOf(list.get(j)).compareTo(lower)>=0
                            && Integer.valueOf(list.get(j)).compareTo(upper)<=0){
                        System.out.println("[" + ctr +"]");
                        System.out.println("Product ID:" + list.get(j-4));
                        System.out.println("Product Name:" + list.get(j-3));
                        System.out.println("Product Description:" + list.get(j-2));
                        System.out.println("Product Trader:" + list.get(j-1));
                        System.out.println("Product Price:" + list.get(j));
                        System.out.println("Product Discounted Price:" + list.get(j+1));
                        System.out.println();
                        ctr++;
                    }
                    x=-1;
                }
                else
                    x++;
            }


    }

    public Products searchWithTraderName(String tradName) throws FileNotFoundException {
        findName(tradName);
        System.out.println();
        System.out.println("-------All Products of " + tradName+ " Store------");
        int ctr=1;
        for(int i=0; i<list.size(); i++){
            if(i%6 == 0){
                System.out.println("[" + ctr +"]");
                System.out.println("Product ID:" + list.get(i));
                ctr++;
            }

            else if(i%6 == 1)
                System.out.println("Product Name:" + list.get(i));
            else if(i%6 == 2)
                System.out.println("Product Description:" + list.get(i));
            else if(i%6 == 3)
                System.out.println("Product Trader:" + list.get(i));
            else if(i%6 == 4)
            System.out.println("Product Price:" + list.get(i));
            else if(i%6 == 5) {
                System.out.println("Product Discounted Price:" + list.get(i));
                System.out.println();
            }
        }
        return this;
    }

}

