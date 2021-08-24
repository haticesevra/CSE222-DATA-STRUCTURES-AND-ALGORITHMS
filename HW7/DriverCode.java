import java.util.*;

public class DriverCode {
    public DriverCode(){
        System.out.println("HOMEWORK 7 TESTS");
        part1();
        part2();
       part3();
    }

    public void part1(){
        System.out.println("----------------PART1------------------");
        System.out.println("NAVIGABLE SET WITH SKIP LIST TEST");
        navigableSkipTest();

        System.out.println("\n\n---------------------------------------");
        System.out.println("\nNAVIGABLE SET WITH AVL TREE TEST");
        navigableAVLTest();

    }



    private void navigableSkipTest() {
        NavigableSetWithSkipList<Integer> test = new NavigableSetWithSkipList<>();

        System.out.print("\n1) Insert test ");
        test.insert(5);
        test.insert(12);
        test.insert(0);
        test.insert(7);
        test.insert(98);
        test.insert(79);
        test.insert(45);
        test.insert(13);
        test.insert(23);
        test.insert(1);

        System.out.println(" ( After Inserting 5, 12, 0, 7, 98, 79, 45, 13, 23, 1 )");
        System.out.println("Size of NavigableSet:  " + test.getSize());

        System.out.print("NavigableSet:  ");
        test.printSkipList();


        System.out.println("\n2) Delete Test");
        System.out.println("After Deleting 13 ");
        test.delete(13);
        test.printSkipList();
        System.out.println("After Deleting 98 ");
        test.delete(98);
        test.printSkipList();
        System.out.println("After Deleting 1 ");
        test.delete(1);
        test.printSkipList();

        System.out.println("\n3) Descending Iterator Test");
        test.descendingIterator();


    }

    private void navigableAVLTest() {
        NavigableSetWithAVL<Integer> test = new NavigableSetWithAVL();

        System.out.print("\n1) Insert test (After inserting 20, 10, 40, 15, 5, 7)");
        test.insert(20);
        test.insert(10);
        test.insert(40);
        test.insert(15);
        test.insert(5);
        test.insert(7);
        System.out.println("\nAVL Tree");
        test.print();


        System.out.println("2) Iterator test");
        test.iterator();


        System.out.println("\n\n3) TailSet Test (10)");
        System.out.print("10 or more : ");
        test.tailSet(10);
        System.out.println();

        System.out.println("\n4) HeadSet Test (10)");
        System.out.print("10 or less : ");

        test.headSet(10);
        System.out.println();



    }


    public void part2(){
        System.out.println("\n\n----------------PART2------------------\n");

        AVLTree<Integer> avl1 = new AVLTree<>();
        avl1.add(19);
        avl1.add(2);
        avl1.add(9);
        avl1.add(45);
        avl1.add(32);
        avl1.add(20);
        System.out.print("After sending AVL Tree named 'avl1':       ");
        typeOfBST(avl1.checkType(avl1));

        RedBlackTree<Integer> rbl1 = new RedBlackTree<>();
        rbl1.add(19);
        rbl1.add(2);
        rbl1.add(9);
        rbl1.add(45);
        rbl1.add(32);
        rbl1.add(20);
        System.out.print("After sending Red-Black Tree named 'rbl1':  ");
        typeOfBST(rbl1.checkType(rbl1));

        RedBlackTree<Integer> rbl2 = new RedBlackTree<>();
        rbl2.add(19);
        rbl2.add(2);
        rbl2.add(9);
        rbl2.add(45);
        rbl2.add(32);
        rbl2.add(20);
        System.out.print("After sending Red-Black Tree named 'rbl2':  ");
        typeOfBST(rbl2.checkType(rbl2));

        AVLTree<Integer> avl2 = new AVLTree<>();
        avl2.add(19);
        avl2.add(2);
        avl2.add(9);
        avl2.add(45);
        avl2.add(32);
        avl2.add(20);
        System.out.print("After sending AVL Tree named 'avl2':        ");
        typeOfBST(avl2.checkType(avl2));

        RedBlackTree<Integer> rbl3 = new RedBlackTree<>();
        rbl3.add(19);
        rbl3.add(2);
        rbl3.add(9);
        rbl3.add(45);
        rbl3.add(32);
        rbl3.add(20);
        System.out.print("After sending Red-Black Tree named 'rbl3':  ");
        typeOfBST(rbl3.checkType(rbl3));
    }

    private void typeOfBST(int type) {
        if(type == 1)
            System.out.println("Type of the given tree is 'AVL TREE' \n");
        else
            System.out.println("Type of the given tree is 'RED-BLACK TREE' \n");
    }

    public void part3(){
        System.out.println("\n\n----------------PART3------------------\n");

        ArrayList<Double> retBST =  bstInsert();
        ArrayList<Double> retRBT =   redBlackInsert();
        ArrayList<Double> retTTF =   twoThreeFourInsert();
        ArrayList<Double> retBT =   bTreeInsert();
        ArrayList<Double> retSL =    skipListInsert();
        ArrayList<Double> compare;
        ArrayList<Double> sorted;


        compare = new ArrayList<>();
        sorted = new ArrayList<>();
        System.out.println("\n----------------------------------\n");

        System.out.println("Average time of data structures (10,000 + 100 size)");
        System.out.printf("BSTree:     %.4f\n", retBST.get(0));
        System.out.printf("Red-Black : %.4f\n" , retRBT.get(0));
        System.out.printf("2-3-4 Tree: %.4f\n" , retTTF.get(0));
        System.out.printf("B-Tree:     %.4f\n" , retBT.get(0));
        System.out.printf("SkipList :  %.4f\n" , retSL.get(0));
        System.out.print("******** Compare running times: ");
        compare.add(retBST.get(0));
        compare.add(retRBT.get(0));
        compare.add(retTTF.get(0));
        compare.add(retBT.get(0));
        compare.add(retSL.get(0));

        for(int i=0; i<5;  i++)
            sorted.add(compare.get(i));

        Collections.sort(sorted);
        printCompareResults(sorted, compare);




        compare = new ArrayList<>();
        sorted = new ArrayList<>();
        System.out.println("\n\nAverage time of data structures (20,000 + 100 size)");
        System.out.printf("BSTree:     %.4f\n", retBST.get(1));
        System.out.printf("Red-Black : %.4f\n" , retRBT.get(1));
        System.out.printf("2-3-4 Tree: %.4f\n" , retTTF.get(1));
        System.out.printf("B-Tree:     %.4f\n" , retBT.get(1));
        System.out.printf("SkipList :  %.4f\n" , retSL.get(1));
        compare.add(retBST.get(1));
        compare.add(retRBT.get(1));
        compare.add(retTTF.get(1));
        compare.add(retBT.get(1));
        compare.add(retSL.get(1));
        for(int i=0; i<5;  i++)
            sorted.add(compare.get(i));

        System.out.print("******** Compare running times: ");
        Collections.sort(sorted);
        printCompareResults(sorted, compare);



        compare = new ArrayList<>();
        sorted = new ArrayList<>();
        System.out.println("\n\nAverage time of data structures (40,000 + 100 size)");
        System.out.printf("BSTree:     %.4f\n", retBST.get(2));
        System.out.printf("Red-Black : %.4f\n" , retRBT.get(2));
        System.out.printf("2-3-4 Tree: %.4f\n" , retTTF.get(2));
        System.out.printf("B-Tree:     %.4f\n" , retBT.get(2));
        System.out.printf("SkipList :  %.4f\n" , retSL.get(2));
        compare.add(retBST.get(2));
        compare.add(retRBT.get(2));
        compare.add(retTTF.get(2));
        compare.add(retBT.get(2));
        compare.add(retSL.get(2));
        for(int i=0; i<5;  i++)
            sorted.add(compare.get(i));

        System.out.print("******** Compare running times: ");

        Collections.sort(sorted);
        printCompareResults(sorted, compare);



        compare = new ArrayList<>();
        sorted = new ArrayList<>();
        System.out.println("\n\nAverage time of data structures (80,000 + 100 size)");
        System.out.printf("BSTree:     %.4f\n", retBST.get(3));
        System.out.printf("Red-Black : %.4f\n" , retRBT.get(3));
        System.out.printf("2-3-4 Tree: %.4f\n" , retTTF.get(3));
        System.out.printf("B-Tree:     %.4f\n" , retBT.get(3));
        System.out.printf("SkipList :  %.4f\n" , retSL.get(3));
        compare.add(retBST.get(3));
        compare.add(retRBT.get(3));
        compare.add(retTTF.get(3));
        compare.add(retBT.get(3));
        compare.add(retSL.get(3));
        for(int i=0; i<5;  i++)
            sorted.add(compare.get(i));

        System.out.print("******** Compare running times: ");
        Collections.sort(sorted);
        printCompareResults(sorted, compare);

        System.out.println("\n\n\nINCREASING RATES\n");

        System.out.println("\nBinary Search Tree vs Red Black Tree ");
        double rate = ((retBST.get(0) - retRBT.get(0))/ Math.abs(retBST.get(0)))*100;
        System.out.println("10.000 -->  %" + (int) rate );
        rate = ((retBST.get(1) - retRBT.get(1))/ Math.abs(retBST.get(1)))*100;
        System.out.println("20.000 -->  %" + (int) rate );
        rate = ((retBST.get(2) - retRBT.get(2))/ Math.abs(retBST.get(2)))*100;
        System.out.println("40.000 -->  %" + (int) rate );
        rate = ((retBST.get(3) - retRBT.get(3))/ Math.abs(retBST.get(3)))*100;
        System.out.println("80.000 -->  %" + (int) rate );

        System.out.println("\nBinary Search Tree vs 2 3 4 Tree");
        rate = ((retBST.get(0) - retTTF.get(0))/ Math.abs(retBST.get(0)))*100;
        System.out.println("10.000 -->  %" + (int) rate );
        rate = ((retBST.get(1) - retTTF.get(1))/ Math.abs(retBST.get(1)))*100;
        System.out.println("20.000 -->  %" + (int) rate );
        rate = ((retBST.get(2) - retTTF.get(2))/ Math.abs(retBST.get(2)))*100;
        System.out.println("40.000 -->  %" + (int) rate );
        rate = ((retBST.get(3) - retTTF.get(3))/ Math.abs(retBST.get(3)))*100;
        System.out.println("80.000 -->  %" + (int) rate );

        System.out.println("\nBinary Search Tree vs BTree");
        rate = ((retBST.get(0) - retBT.get(0))/ Math.abs(retBST.get(0)))*100;
        System.out.println("10.000 -->  %" + (int) rate );
        rate = ((retBST.get(1) - retBT.get(1))/ Math.abs(retBST.get(1)))*100;
        System.out.println("20.000 -->  %" + (int) rate );
        rate = ((retBST.get(2) - retBT.get(2))/ Math.abs(retBST.get(2)))*100;
        System.out.println("40.000 -->  %" + (int) rate );
        rate = ((retBST.get(3) - retBT.get(3))/ Math.abs(retBST.get(3)))*100;
        System.out.println("80.000 -->  %" + (int) rate );


        System.out.println("\nBinary Search Tree vs SkipList");
        rate = ((retBST.get(0) - retSL.get(0))/ Math.abs(retBST.get(0)))*100;
        System.out.println("10.000 -->  %" + (int) rate );
        rate = ((retBST.get(1) - retSL.get(1))/ Math.abs(retBST.get(1)))*100;
        System.out.println("20.000 -->  %" + (int) rate );
        rate = ((retBST.get(2) - retSL.get(2))/ Math.abs(retBST.get(2)))*100;
        System.out.println("40.000 -->  %" + (int) rate );
        rate = ((retBST.get(3) - retSL.get(3))/ Math.abs(retBST.get(3)))*100;
        System.out.println("80.000 -->  %" + (int) rate );



        System.out.println("\nRed Black Tree vs 2 3 4 Tree");
        rate = ((retRBT.get(0) - retTTF.get(0))/ Math.abs(retRBT.get(0)))*100;
        System.out.println("10.000 -->  %" + (int) rate );
        rate = ((retRBT.get(1) - retTTF.get(1))/ Math.abs(retRBT.get(1)))*100;
        System.out.println("20.000 -->  %" + (int) rate );
        rate = ((retRBT.get(2) - retTTF.get(2))/ Math.abs(retRBT.get(2)))*100;
        System.out.println("40.000 -->  %" + (int) rate );
        rate = ((retRBT.get(3) - retTTF.get(3))/ Math.abs(retRBT.get(3)))*100;
        System.out.println("80.000 -->  %" + (int) rate );

        System.out.println("\nRed Black Tree vs BTree");
        rate = ((retRBT.get(0) - retBT.get(0))/ Math.abs(retRBT.get(0)))*100;
        System.out.println("10.000 -->  %" + (int) rate );
        rate = ((retRBT.get(1) - retBT.get(1))/ Math.abs(retRBT.get(1)))*100;
        System.out.println("20.000 -->  %" + (int) rate );
        rate = ((retRBT.get(2) - retBT.get(2))/ Math.abs(retRBT.get(2)))*100;
        System.out.println("40.000 -->  %" + (int) rate );
        rate = ((retRBT.get(3) - retBT.get(3))/ Math.abs(retRBT.get(3)))*100;
        System.out.println("80.000 -->  %" + (int) rate );


        System.out.println("\nRed Black Tree vs SkipList");
        rate = ((retRBT.get(0) - retSL.get(0))/ Math.abs(retRBT.get(0)))*100;
        System.out.println("10.000 -->  %" + (int) rate );
        rate = ((retRBT.get(1) - retSL.get(1))/ Math.abs(retRBT.get(1)))*100;
        System.out.println("20.000 -->  %" + (int) rate );
        rate = ((retRBT.get(2) - retSL.get(2))/ Math.abs(retRBT.get(2)))*100;
        System.out.println("40.000 -->  %" + (int) rate );
        rate = ((retRBT.get(3) - retSL.get(3))/ Math.abs(retRBT.get(3)))*100;
        System.out.println("80.000 -->  %" + (int) rate );


        System.out.println("\n2-3-4 Tree vs BTree");
        rate = ((retTTF.get(0) - retBT.get(0))/ Math.abs(retTTF.get(0)))*100;
        System.out.println("10.000 -->  %" + (int) rate );
        rate = ((retTTF.get(1) - retBT.get(1))/ Math.abs(retTTF.get(1)))*100;
        System.out.println("20.000 -->  %" + (int) rate );
        rate = ((retTTF.get(2) - retBT.get(2))/ Math.abs(retTTF.get(2)))*100;
        System.out.println("40.000 -->  %" + (int) rate );
        rate = ((retTTF.get(3) - retBT.get(3))/ Math.abs(retTTF.get(3)))*100;
        System.out.println("80.000 -->  %" + (int) rate );


        System.out.println("\n2-3-4 Tree vs SkipList");
        rate = ((retTTF.get(0) - retSL.get(0))/ Math.abs(retTTF.get(0)))*100;
        System.out.println("10.000 -->  %" + (int) rate );
        rate = ((retTTF.get(1) - retSL.get(1))/ Math.abs(retTTF.get(1)))*100;
        System.out.println("20.000 -->  %" + (int) rate );
        rate = ((retTTF.get(2) - retSL.get(2))/ Math.abs(retTTF.get(2)))*100;
        System.out.println("40.000 -->  %" + (int) rate );
        rate = ((retTTF.get(3) - retSL.get(3))/ Math.abs(retTTF.get(3)))*100;
        System.out.println("80.000 -->  %" + (int) rate );



        System.out.println("\nB-Tree vs SkipList");
        rate = ((retBT.get(0) - retSL.get(0))/ Math.abs(retBT.get(0)))*100;
        System.out.println("10.000 -->  %" + (int) rate );
        rate = ((retBT.get(1) - retSL.get(1))/ Math.abs(retBT.get(1)))*100;
        System.out.println("20.000 -->  %" + (int) rate );
        rate = ((retBT.get(2) - retSL.get(2))/ Math.abs(retBT.get(2)))*100;
        System.out.println("40.000 -->  %" + (int) rate );
        rate = ((retBT.get(3) - retSL.get(3))/ Math.abs(retBT.get(3)))*100;
        System.out.println("80.000 -->  %" + (int) rate );



    }

    private void printCompareResults(ArrayList<Double> sorted, ArrayList<Double> compare) {
        for(int i=0; i<5; i++){
            for(int j=0; j<5;j++){
                if(sorted.get(i).equals(compare.get(j))){
                    if(j == 0)
                        System.out.print(" Binary Search Tree < ");
                    else if(j == 1)
                        System.out.print(" Red-Black Tree < ");
                    else if(j == 2)
                        System.out.print(" 2-3-4 Tree < ");
                    else if(j == 3)
                        System.out.print(" B-Tree < ");
                    else
                        System.out.print(" SkipList < ");
                    break;
                }
            }
        }

    }

    public Set<Integer> generateRandom(int size, int bound){
        Random randNum = new Random();
        Set<Integer> set = new LinkedHashSet<Integer>();
        while (set.size() < size)
            set.add(randNum.nextInt(bound)+1);
        return set;
    }

    public ArrayList bstInsert(){
        System.out.println("----------------------------------");
        System.out.println("BINARY SEARCH TREE");
        long startTime, totalTime, endTime;
        double seconds;
        Set<Integer> randomSet, extraRandom;
        BinarySearchTree<Integer> bst;

        ArrayList<Double> size1 = new ArrayList<>();
        ArrayList<Double> size2 = new ArrayList<>();
        ArrayList<Double> size3 = new ArrayList<>();
        ArrayList<Double> size4 = new ArrayList<>();
        ArrayList<Double> returnResults = new ArrayList<>();

        for(int x=0; x<10; x++) {
            // 10.000 insert
            randomSet = generateRandom(10000, 200000);
            bst = new BinarySearchTree<>();
            for (Integer s : randomSet)
                bst.add(s);

            extraRandom = generateRandom(100, 1000);
            startTime = System.nanoTime();
            for (Integer s : extraRandom)
                bst.add(s);
            endTime = System.nanoTime();
            totalTime = endTime - startTime;
            seconds = (double) totalTime / 1_000_000.0;
            // System.out.println("\nBST 10.000 - 100 insert time:  " + seconds + " ms");
            size1.add(seconds);

            //20.000 insert
            randomSet = generateRandom(20000, 200000);
            bst = new BinarySearchTree<>();
            for (Integer s : randomSet)
                bst.add(s);
            extraRandom = generateRandom(100, 1000);
            startTime = System.nanoTime();
            for (Integer s : extraRandom)
                bst.add(s);
            endTime = System.nanoTime();
            totalTime = endTime - startTime;
            seconds = (double) totalTime / 1_000_000.0;
            //    System.out.println("BST 20.000 - 100 insert time:  " + seconds + " ms");
            size2.add(seconds);

            //40.000 insert
            randomSet = generateRandom(40000, 200000);
            bst = new BinarySearchTree<>();
            for (Integer s : randomSet)
                bst.add(s);
            extraRandom = generateRandom(100, 1000);
            startTime = System.nanoTime();
            for (Integer s : extraRandom)
                bst.add(s);
            endTime = System.nanoTime();
            totalTime = endTime - startTime;
            seconds = (double) totalTime / 1_000_000.0;
            //   System.out.println("BST 40.000-- 100 insert time:  " + seconds + " ms");
            size3.add(seconds);

            //80.000 insert
            randomSet = generateRandom(80000, 200000);
            bst = new BinarySearchTree<>();
            for (Integer s : randomSet)
                bst.add(s);
            extraRandom = generateRandom(100, 1000);
            startTime = System.nanoTime();
            for (Integer s : extraRandom)
                bst.add(s);
            endTime = System.nanoTime();
            totalTime = endTime - startTime;
            seconds = (double) totalTime / 1_000_000.0;
            //    System.out.println("BST 80.000-  100 insert time:  " + seconds + " ms");
            size4.add(seconds);
        }

        // System.out.println("1-- " + size1);
        double sum=0, average=0;
        for(int i=0; i<size1.size(); i++)
            sum+=size1.get(i);

        average = sum/size1.size();
        returnResults.add(average);
        System.out.printf("Average of adding 100 elements to a 10.000 element array:  %.4f\n", average);

        sum=0;
        for(int i=0; i<size2.size(); i++)
            sum+=size2.get(i);

        average = sum/size2.size();
        returnResults.add(average);

        System.out.printf("Average of adding 100 elements to a 20.000 element array:  %.4f\n", average);


        //   System.out.println("3-- " + size3);
        sum=0;
        for(int i=0; i<size3.size(); i++)
            sum+=size3.get(i);

        average = sum/size3.size();
        returnResults.add(average);

        // System.out.print("sum " + sum );
        System.out.printf("Average of adding 100 elements to a 40.000 element array:  %.4f\n", average);


        //System.out.println("4-- " + size4);
        sum=0;
        for(int i=0; i<size4.size(); i++)
            sum+=size4.get(i);

        average = sum/size4.size();
        returnResults.add(average);

        // System.out.print("sum " + sum );
        System.out.printf("Average of adding 100 elements to a 80.000 element array:  %.4f\n", average);

        System.out.println("\nIncreasing rates");
        double rate = ((returnResults.get(1) - returnResults.get(0))/ Math.abs(returnResults.get(0)))*100;
        System.out.println("10.000 vs 20.000: %" + (int) rate);
        rate = ((returnResults.get(2) - returnResults.get(0))/ Math.abs(returnResults.get(0)))*100;
        System.out.println("10.000 vs 40.000: %" + (int) rate );
        rate = ((returnResults.get(3) - returnResults.get(0))/ Math.abs(returnResults.get(0)))*100;
        System.out.println("10.000 vs 80.000: %" + (int) rate);

        return returnResults;

    }

    public ArrayList redBlackInsert(){
        System.out.println("\n----------------------------------");
        System.out.println("RED BLACK TREE");
        long startTime, totalTime, endTime;
        double seconds;
        Set<Integer> randomSet, extraRandom;
        RedBlackTree<Integer> rbTree;

        ArrayList<Double> size1 = new ArrayList<>();
        ArrayList<Double> size2 = new ArrayList<>();
        ArrayList<Double> size3 = new ArrayList<>();
        ArrayList<Double> size4 = new ArrayList<>();
        ArrayList<Double> returnResults = new ArrayList<>();

        for(int x=0; x<10; x++) {
            // 10.000 insert
            randomSet = generateRandom(10000, 200000);
            rbTree = new RedBlackTree<>();
            for (Integer s : randomSet)
                rbTree.add(s);

            extraRandom = generateRandom(100, 1000);
            startTime = System.nanoTime();
            for (Integer s : extraRandom)
                rbTree.add(s);
            endTime = System.nanoTime();
            totalTime = endTime - startTime;
            seconds = (double) totalTime / 1_000_000.0;
            //     System.out.println("\nBST 10.000 - 100 insert time:  " + seconds + " ms");
            size1.add(seconds);

            //20.000 insert
            randomSet = generateRandom(20000, 200000);
            rbTree = new RedBlackTree<>();
            for (Integer s : randomSet)
                rbTree.add(s);
            extraRandom = generateRandom(100, 1000);
            startTime = System.nanoTime();
            for (Integer s : extraRandom)
                rbTree.add(s);
            endTime = System.nanoTime();
            totalTime = endTime - startTime;
            seconds = (double) totalTime / 1_000_000.0;
            //  System.out.println("BST 20.000 - 100 insert time:  " + seconds + " ms");
            size2.add(seconds);

            //40.000 insert
            randomSet = generateRandom(40000, 200000);
            rbTree = new RedBlackTree<>();
            for (Integer s : randomSet)
                rbTree.add(s);
            extraRandom = generateRandom(100, 1000);
            startTime = System.nanoTime();
            for (Integer s : extraRandom)
                rbTree.add(s);
            endTime = System.nanoTime();
            totalTime = endTime - startTime;
            seconds = (double) totalTime / 1_000_000.0;
            //     System.out.println("BST 40.000-- 100 insert time:  " + seconds + " ms");
            size3.add(seconds);

            //80.000 insert
            randomSet = generateRandom(80000, 200000);
            rbTree = new RedBlackTree<>();
            for (Integer s : randomSet)
                rbTree.add(s);
            extraRandom = generateRandom(100, 1000);
            startTime = System.nanoTime();
            for (Integer s : extraRandom)
                rbTree.add(s);
            endTime = System.nanoTime();
            totalTime = endTime - startTime;
            seconds = (double) totalTime / 1_000_000.0;
            //     System.out.println("BST 80.000-  100 insert time:  " + seconds + " ms");
            size4.add(seconds);
        }

        // System.out.println("1-- " + size1);
        double sum=0, average=0;
        for(int i=0; i<size1.size(); i++){
            sum+=size1.get(i);
        }
        average = sum/size1.size();
        returnResults.add(average);

        // System.out.print("sum " + sum );
        System.out.printf("Average of adding 100 elements to a 10.000 element array:  %.4f\n", average);

        sum=0;
        //   System.out.println("2-- " + size2);
        for(int i=0; i<size2.size(); i++){
            sum+=size2.get(i);
        }
        average = sum/size2.size();
        returnResults.add(average);
        // System.out.print("sum " + sum );
        System.out.printf("Average of adding 100 elements to a 20.000 element array:  %.4f\n", average);


        //   System.out.println("3-- " + size3);
        sum=0;
        for(int i=0; i<size3.size(); i++){
            sum+=size3.get(i);
        }
        average = sum/size3.size();
        returnResults.add(average);

        // System.out.print("sum " + sum );
        System.out.printf("Average of adding 100 elements to a 40.000 element array:  %.4f\n", average);


        //System.out.println("4-- " + size4);
        sum=0;
        for(int i=0; i<size4.size(); i++){
            sum+=size4.get(i);
        }
        average = sum/size4.size();
        returnResults.add(average);
        // System.out.print("sum " + sum );
        System.out.printf("Average of adding 100 elements to a 80.000 element array:  %.4f\n", average);


        System.out.println("\nIncreasing rates");
        double rate = ((returnResults.get(1) - returnResults.get(0))/ Math.abs(returnResults.get(0)))*100;
        System.out.println("10.000 vs 20.000: %" + (int) rate);
        rate = ((returnResults.get(2) - returnResults.get(0))/ Math.abs(returnResults.get(0)))*100;
        System.out.println("10.000 vs 40.000: %" + (int) rate );
        rate = ((returnResults.get(3) - returnResults.get(0))/ Math.abs(returnResults.get(0)))*100;
        System.out.println("10.000 vs 80.000: %" + (int) rate);

        return  returnResults;
    }


    public ArrayList twoThreeFourInsert(){
        System.out.println("\n----------------------------------");
        System.out.println("2-3-4 TREE");
        long startTime, totalTime, endTime;
        double seconds;
        Set<Integer> randomSet, extraRandom;
        TwoThreeFourTree<Integer> ttf;

        ArrayList<Double> size1 = new ArrayList<>();
        ArrayList<Double> size2 = new ArrayList<>();
        ArrayList<Double> size3 = new ArrayList<>();
        ArrayList<Double> size4 = new ArrayList<>();
        ArrayList<Double> returnResults = new ArrayList<>();


        for(int x=0; x<10; x++) {
            // 10.000 insert
            randomSet = generateRandom(10000, 200000);
            ttf= new TwoThreeFourTree<>();
            for (Integer s : randomSet)
                ttf.add(s);

            extraRandom = generateRandom(100, 1000);
            startTime = System.nanoTime();
            for (Integer s : extraRandom)
                ttf.add(s);
            endTime = System.nanoTime();
            totalTime = endTime - startTime;
            seconds = (double) totalTime / 1_000_000.0;
            //     System.out.println("\nBST 10.000 - 100 insert time:  " + seconds + " ms");
            size1.add(seconds);

            //20.000 insert
            randomSet = generateRandom(20000, 200000);
            ttf= new TwoThreeFourTree<>();
            for (Integer s : randomSet)
                ttf.add(s);
            extraRandom = generateRandom(100, 1000);
            startTime = System.nanoTime();
            for (Integer s : extraRandom)
                ttf.add(s);
            endTime = System.nanoTime();
            totalTime = endTime - startTime;
            seconds = (double) totalTime / 1_000_000.0;
            //  System.out.println("BST 20.000 - 100 insert time:  " + seconds + " ms");
            size2.add(seconds);

            //40.000 insert
            randomSet = generateRandom(40000, 200000);
            ttf= new TwoThreeFourTree<>();
            for (Integer s : randomSet)
                ttf.add(s);
            extraRandom = generateRandom(100, 1000);
            startTime = System.nanoTime();
            for (Integer s : extraRandom)
                ttf.add(s);
            endTime = System.nanoTime();
            totalTime = endTime - startTime;
            seconds = (double) totalTime / 1_000_000.0;
            //     System.out.println("BST 40.000-- 100 insert time:  " + seconds + " ms");
            size3.add(seconds);

            //80.000 insert
            randomSet = generateRandom(80000, 200000);
            ttf= new TwoThreeFourTree<>();
            for (Integer s : randomSet)
                ttf.add(s);
            extraRandom = generateRandom(100, 1000);
            startTime = System.nanoTime();
            for (Integer s : extraRandom)
                ttf.add(s);
            endTime = System.nanoTime();
            totalTime = endTime - startTime;
            seconds = (double) totalTime / 1_000_000.0;
            //     System.out.println("BST 80.000-  100 insert time:  " + seconds + " ms");
            size4.add(seconds);
        }

        // System.out.println("1-- " + size1);
        double sum=0, average=0;
        for(int i=0; i<size1.size(); i++){
            sum+=size1.get(i);
        }
        average = sum/size1.size();
        returnResults.add(average);
        // System.out.print("sum " + sum );
        System.out.printf("Average of adding 100 elements to a 10.000 element array:  %.4f\n", average);

        sum=0;
        //   System.out.println("2-- " + size2);
        for(int i=0; i<size2.size(); i++){
            sum+=size2.get(i);
        }
        average = sum/size2.size();
        returnResults.add(average);
// System.out.print("sum " + sum );
        System.out.printf("Average of adding 100 elements to a 20.000 element array:  %.4f\n", average);


        //   System.out.println("3-- " + size3);
        sum=0;
        for(int i=0; i<size3.size(); i++){
            sum+=size3.get(i);
        }
        average = sum/size3.size();
        returnResults.add(average);
// System.out.print("sum " + sum );
        System.out.printf("Average of adding 100 elements to a 40.000 element array:  %.4f\n", average);


        //System.out.println("4-- " + size4);
        sum=0;
        for(int i=0; i<size4.size(); i++){
            sum+=size4.get(i);
        }
        average = sum/size4.size();
        returnResults.add(average);
        // System.out.print("sum " + sum );
        System.out.printf("Average of adding 100 elements to a 80.000 element array:  %.4f\n", average);

        System.out.println("\nIncreasing rates");
        double rate = ((returnResults.get(1) - returnResults.get(0))/ Math.abs(returnResults.get(0)))*100;
        System.out.println("10.000 vs 20.000: %" + (int) rate);
        rate = ((returnResults.get(2) - returnResults.get(0))/ Math.abs(returnResults.get(0)))*100;
        System.out.println("10.000 vs 40.000: %" + (int) rate );
        rate = ((returnResults.get(3) - returnResults.get(0))/ Math.abs(returnResults.get(0)))*100;
        System.out.println("10.000 vs 80.000: %" + (int) rate);

        return returnResults;
    }

    public ArrayList bTreeInsert(){
        System.out.println("----------------------------------");
        System.out.println("B-TREE");
        long startTime, totalTime, endTime;
        double seconds;
        Set<Integer> randomSet, extraRandom;
        BTree<Integer> bTree;

        ArrayList<Double> size1 = new ArrayList<>();
        ArrayList<Double> size2 = new ArrayList<>();
        ArrayList<Double> size3 = new ArrayList<>();
        ArrayList<Double> size4 = new ArrayList<>();
        ArrayList<Double> retResults = new ArrayList<>();

        for(int x=0; x<10; x++) {
            // 10.000 insert
            randomSet = generateRandom(10000, 200000);
            bTree= new BTree<>(10);
            for (Integer s : randomSet)
                bTree.add(s);

            extraRandom = generateRandom(100, 1000);
            startTime = System.nanoTime();
            for (Integer s : extraRandom)
                bTree.add(s);
            endTime = System.nanoTime();
            totalTime = endTime - startTime;
            seconds = (double) totalTime / 1_000_000.0;
            //     System.out.println("\nBST 10.000 - 100 insert time:  " + seconds + " ms");
            size1.add(seconds);

            //20.000 insert
            randomSet = generateRandom(20000, 200000);
            bTree= new BTree<>(10);
            for (Integer s : randomSet)
                bTree.add(s);
            extraRandom = generateRandom(100, 1000);
            startTime = System.nanoTime();
            for (Integer s : extraRandom)
                bTree.add(s);
            endTime = System.nanoTime();
            totalTime = endTime - startTime;
            seconds = (double) totalTime / 1_000_000.0;
            //  System.out.println("BST 20.000 - 100 insert time:  " + seconds + " ms");
            size2.add(seconds);

            //40.000 insert
            randomSet = generateRandom(40000, 200000);
            bTree= new BTree<>(10);
            for (Integer s : randomSet)
                bTree.add(s);
            extraRandom = generateRandom(100, 1000);
            startTime = System.nanoTime();
            for (Integer s : extraRandom)
                bTree.add(s);
            endTime = System.nanoTime();
            totalTime = endTime - startTime;
            seconds = (double) totalTime / 1_000_000.0;
            //     System.out.println("BST 40.000-- 100 insert time:  " + seconds + " ms");
            size3.add(seconds);

            //80.000 insert
            randomSet = generateRandom(80000, 200000);
            bTree= new BTree<>(10);
            for (Integer s : randomSet)
                bTree.add(s);
            extraRandom = generateRandom(100, 1000);
            startTime = System.nanoTime();
            for (Integer s : extraRandom)
                bTree.add(s);
            endTime = System.nanoTime();
            totalTime = endTime - startTime;
            seconds = (double) totalTime / 1_000_000.0;
            //     System.out.println("BST 80.000-  100 insert time:  " + seconds + " ms");
            size4.add(seconds);
        }

        // System.out.println("1-- " + size1);
        double sum=0, average=0;
        for(int i=0; i<size1.size(); i++){
            sum+=size1.get(i);
        }
        average = sum/size1.size();
        retResults.add(average);
        // System.out.print("sum " + sum );
        System.out.printf("Average of adding 100 elements to a 10.000 element array:  %.4f\n", average);

        sum=0;
        //   System.out.println("2-- " + size2);
        for(int i=0; i<size2.size(); i++){
            sum+=size2.get(i);
        }
        average = sum/size2.size();
        retResults.add(average);
// System.out.print("sum " + sum );
        System.out.printf("Average of adding 100 elements to a 20.000 element array:  %.4f\n", average);


        //   System.out.println("3-- " + size3);
        sum=0;
        for(int i=0; i<size3.size(); i++){
            sum+=size3.get(i);
        }
        average = sum/size3.size();
        retResults.add(average);
// System.out.print("sum " + sum );
        System.out.printf("Average of adding 100 elements to a 40.000 element array:  %.4f\n", average);


        //System.out.println("4-- " + size4);
        sum=0;
        for(int i=0; i<size4.size(); i++){
            sum+=size4.get(i);
        }
        average = sum/size4.size();
        retResults.add(average);
// System.out.print("sum " + sum );
        System.out.printf("Average of adding 100 elements to a 80.000 element array:  %.4f\n", average);

        System.out.println("\nIncreasing rates (when 100 elements inserted)");
        double rate = ((retResults.get(1) - retResults.get(0))/ Math.abs(retResults.get(0)))*100;
        System.out.println("10.000 vs 20.000: %" + (int) rate);
        rate = ((retResults.get(2) - retResults.get(0))/ Math.abs(retResults.get(0)))*100;
        System.out.println("10.000 vs 40.000: %" + (int) rate );
        rate = ((retResults.get(3) - retResults.get(0))/ Math.abs(retResults.get(0)))*100;
        System.out.println("10.000 vs 80.000: %" + (int) rate);

        return retResults;
    }

    public ArrayList skipListInsert(){

        System.out.println("\n----------------------------------");
        System.out.println("SKIP LIST TREE");
        long startTime, totalTime, endTime;
        double seconds;
        Set<Integer> randomSet, extraRandom;
        SkipList<Integer> skipList;

        ArrayList<Double> size1 = new ArrayList<>();
        ArrayList<Double> size2 = new ArrayList<>();
        ArrayList<Double> size3 = new ArrayList<>();
        ArrayList<Double> size4 = new ArrayList<>();
        ArrayList<Double> retResults = new ArrayList<>();

        for(int x=0; x<10; x++) {
            // 10.000 insert
            randomSet = generateRandom(10000, 200000);
            skipList= new SkipList<>();
            for (Integer s : randomSet)
                skipList.add(s);

            extraRandom = generateRandom(100, 1000);
            startTime = System.nanoTime();
            for (Integer s : extraRandom)
                skipList.add(s);
            endTime = System.nanoTime();
            totalTime = endTime - startTime;
            seconds = (double) totalTime / 1_000_000.0;
            //     System.out.println("\nBST 10.000 - 100 insert time:  " + seconds + " ms");
            size1.add(seconds);

            //20.000 insert
            randomSet = generateRandom(20000, 200000);
            skipList= new SkipList<>();
            for (Integer s : randomSet)
                skipList.add(s);
            extraRandom = generateRandom(100, 1000);
            startTime = System.nanoTime();
            for (Integer s : extraRandom)
                skipList.add(s);
            endTime = System.nanoTime();
            totalTime = endTime - startTime;
            seconds = (double) totalTime / 1_000_000.0;
            //  System.out.println("BST 20.000 - 100 insert time:  " + seconds + " ms");
            size2.add(seconds);

            //40.000 insert
            randomSet = generateRandom(40000, 200000);
            skipList= new SkipList<>();
            for (Integer s : randomSet)
                skipList.add(s);
            extraRandom = generateRandom(100, 1000);
            startTime = System.nanoTime();
            for (Integer s : extraRandom)
                skipList.add(s);
            endTime = System.nanoTime();
            totalTime = endTime - startTime;
            seconds = (double) totalTime / 1_000_000.0;
            //     System.out.println("BST 40.000-- 100 insert time:  " + seconds + " ms");
            size3.add(seconds);

            //80.000 insert
            randomSet = generateRandom(80000, 200000);
            skipList= new SkipList<>();
            for (Integer s : randomSet)
                skipList.add(s);
            extraRandom = generateRandom(100, 1000);
            startTime = System.nanoTime();
            for (Integer s : extraRandom)
                skipList.add(s);
            endTime = System.nanoTime();
            totalTime = endTime - startTime;
            seconds = (double) totalTime / 1_000_000.0;
            //     System.out.println("BST 80.000-  100 insert time:  " + seconds + " ms");
            size4.add(seconds);
        }

        // System.out.println("1-- " + size1);
        double sum=0, average=0;
        for(int i=0; i<size1.size(); i++){
            sum+=size1.get(i);
        }
        average = sum/size1.size();
        retResults.add(average);
        // System.out.print("sum " + sum );
        System.out.printf("Average of adding 100 elements to a 10.000 element array:  %.4f\n", average);

        sum=0;
        //   System.out.println("2-- " + size2);
        for(int i=0; i<size2.size(); i++){
            sum+=size2.get(i);
        }
        average = sum/size2.size();
        retResults.add(average);
// System.out.print("sum " + sum );
        System.out.printf("Average of adding 100 elements to a 20.000 element array:  %.4f\n", average);


        //   System.out.println("3-- " + size3);
        sum=0;
        for(int i=0; i<size3.size(); i++){
            sum+=size3.get(i);
        }
        average = sum/size3.size();
        retResults.add(average);
// System.out.print("sum " + sum );
        System.out.printf("Average of adding 100 elements to a 40.000 element array:  %.4f\n", average);


        //System.out.println("4-- " + size4);
        sum=0;
        for(int i=0; i<size4.size(); i++){
            sum+=size4.get(i);
        }
        average = sum/size4.size();
        retResults.add(average);
// System.out.print("sum " + sum );
        System.out.printf("Average of adding 100 elements to a 80.000 element array:  %.4f\n", average);
        System.out.println("\nIncreasing rates");
        double rate = ((retResults.get(1) - retResults.get(0))/ Math.abs(retResults.get(0)))*100;
        System.out.println("10.000 vs 20.000: %" + (int) rate);
        rate = ((retResults.get(2) - retResults.get(0))/ Math.abs(retResults.get(0)))*100;
        System.out.println("10.000 vs 40.000: %" + (int) rate );
        rate = ((retResults.get(3) - retResults.get(0))/ Math.abs(retResults.get(0)))*100;
        System.out.println("10.000 vs 80.000: %" + (int) rate);

        return retResults;


    }



}
