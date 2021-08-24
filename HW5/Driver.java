import java.util.*;

public class Driver {

    public Driver(){
        testPart1();
        testPart2_1();
        testPart2_2();
        testPart2_3();
        comparePart2();

    }



    private static void testPart1() {
        System.out.println("PART 1 TEST");
        SevraHashMap<Integer,String> hashInt = new SevraHashMap<Integer,String>();

        hashInt.add(5, "five");
        hashInt.add(25, "twenty-five");
        hashInt.add(27, "twenty-seven");
        hashInt.add(1, "one");
        hashInt.add(44,"forty-four");
        hashInt.add(46,"forty-six");

        System.out.println("All HashMap =  " + hashInt);
        System.out.println("Keys = " + hashInt.keySet());
        System.out.println("Values = " + hashInt.values());

        System.out.println("\nIterate from first key test       ( also next() and hasNext() methods tested ) ");
        hashInt.iterator(1);

        System.out.println("\n\nIterate from last key test         ( also next() and hasNext() methods tested )");
        hashInt.iterator(46);

        System.out.println("\n\nIterate from key in the middle test        ( also next() and hasNext() methods tested )");
        hashInt.iterator(27);

        System.out.println("\n\nIterate with non-exist key test        ( also next() and hasNext() methods tested )");
        hashInt.iterator(0);

        System.out.println("\n\nIterate with no parameter        ( also next() and hasNext() methods tested )");
        hashInt.MapIterator();

        System.out.println("\n\nprev() method test with first key");
        hashInt.findPrev(1);

        System.out.println("\nprev() method test with last key");
        hashInt.findPrev(46);

        System.out.println("\nprev() method test with key in the middle");
        hashInt.findPrev(11);
    }

    public void testPart2_1(){
        System.out.println("\n---------------------------------------\n");
        System.out.println("PART 2.1 CHAINING WITH LINKED LIST TEST");
        ChainLinked<Integer, Integer> chainLinked = new ChainLinked<>();

        chainLinked.put(1, 33);
        chainLinked.put(2, 32);
        chainLinked.put(3, 31);
        chainLinked.put(11, 30);
        chainLinked.put(8, 29);
        chainLinked.put(18, 27);
        chainLinked.put(12, 26);
        chainLinked.put(58, 28);
     //   chainLinked.print();

        System.out.println( "\nTest collision at 8 (must be 3) (a problem occured after performance tests)");
        chainLinked.get(8);
        System.out.println( "\nTest collision at 1 (must be 2)");
        chainLinked.get(1);
        System.out.println( "\nTest collision at 5 (must be none)");
        chainLinked.get(5);

        System.out.println("\nCollision before remove");
        chainLinked.get(2);

        chainLinked.remove(12);
        System.out.println("\nCollision after remove 12");
        chainLinked.get(2);
    }

    public void testPart2_2(){
        System.out.println("\n\n---------------------------------------\n");
        System.out.println("PART 2.2 CHAINING WITH TREE SET TEST");
        ChainTree<Integer, Integer> chainTree = new ChainTree<>();

        chainTree.put(1, 33);
        chainTree.put(2, 32);
        chainTree.put(3  , 31);
        chainTree.put(11, 30);
        chainTree.put(8, 29);
        chainTree.put(18, 27);
        chainTree.put(12, 26);
        chainTree.put(58, 28);

        System.out.println( "\nTest collision at 8 (must be 3)");
        chainTree.get(58);
        System.out.println( "\nTest collision at 1 (must be 2)");
        chainTree.get(11);
        System.out.println( "\nTest collision at 5 (must be none)");
        chainTree.get(5);

        System.out.println("\nCollision before remove");
        chainTree.get(12);

        chainTree.remove(2);
        System.out.println("\nCollision after remove 2");
        chainTree.get(12);

    }

    public void testPart2_3(){

        System.out.println("\n---------------------------------------\n");
        System.out.println("PART 2.3 COALESCED HASHING TEST");
        Coalesced<Integer, Integer> coal = new Coalesced<>();

        coal.add(3, 33);
        coal.add(12, 32);
        coal.add(13  , 31);
        coal.add(25, 30);
        coal.add(23, 29);
        coal.add(51, 27);
        coal.add(42, 26);
        coal.print();


    }

    public void comparePart2(){
        System.out.println("\n---------------------------------------\n");
        System.out.println("PART2 COMPARE PERFORMANCE TEST");
        Random r = new Random();
        int low = 1;
        int high = 5000;
        int key, value;
        long startTime, endTime, totalTime;
        double seconds;

        startTime = System.nanoTime();
        ChainLinked<Integer, Integer> x = new ChainLinked<>();
        low=0;
        high=20;
        x.put(11,23);
        x.put(22, 12);
        x.put(33, 45);
        for(int i=0; i<10; i++){
            key = r.nextInt(high-low) + low;
            value = r.nextInt(high-low) + low;
            x.put(key, value);
        }

        endTime   = System.nanoTime();
        totalTime = endTime - startTime;
        seconds = (double)totalTime / 1000000;
        System.out.println("\nChainLinked add(10) time -> " +seconds + " ms");


        startTime = System.nanoTime();
        ChainTree<Integer, Integer> y = new ChainTree<>();

        y.put(11,23);
        y.put(22,12);
        y.put(33,45);
        for(int i=0; i<10; i++){
            key = r.nextInt(high-low) + low;
            value = r.nextInt(high-low) + low;
            y.put(key, value);
        }
        endTime   = System.nanoTime();
        totalTime = endTime - startTime;
        seconds = (double)totalTime / 1000000;
        System.out.println("ChainTree add(10) time -> " +seconds + " ms");



        startTime = System.nanoTime();
        Coalesced<Integer, Integer> z = new Coalesced<>();

        z.add(11, 23);
        z.add(22, 12);
        z.add(33, 45);
        for(int i=0; i<6; i++){
            key = r.nextInt(high-low) + low;
            value = r.nextInt(high-low) + low;
            z.add(key, value);
        }
        endTime   = System.nanoTime();
        totalTime = endTime - startTime;
        seconds = (double)totalTime / 1000000;
        System.out.println("Coalesced add(10) time -> " +seconds + " ms\n\n\n");

//-----------------------------------------------------------------------------------
        startTime = System.nanoTime();
        x.get(11);
        x.get(22);
        x.get(33);
        endTime   = System.nanoTime();
        totalTime = endTime - startTime;
        seconds = (double)totalTime / 1000000;
        System.out.println("ChainLinked search(3) time -> " +seconds + " ms");


        startTime = System.nanoTime();
        y.get(11);
        y.get(22);
        y.get(33);
        endTime   = System.nanoTime();
        totalTime = endTime - startTime;
        seconds = (double)totalTime / 1000000;
        System.out.println("ChainTree search(3) time -> " +seconds + " ms");

        startTime = System.nanoTime();
        z.get(11);
        z.get(22);
        z.get(33);
        endTime   = System.nanoTime();
        totalTime = endTime - startTime;
        seconds = (double)totalTime / 1000000;
        System.out.println("Coalesced search(3) time -> " +seconds + " ms\n\n\n");

//-----------------------------------------------------------------------------------

        startTime = System.nanoTime();
        x.remove(11);
        x.remove(22);
        x.remove(33);
        endTime   = System.nanoTime();
        totalTime = endTime - startTime;
        seconds = (double)totalTime / 1000000;
        System.out.println("Coalesced remove(3) time -> " +seconds + " ms");


        startTime = System.nanoTime();
        y.remove(11);
        y.remove(22);
        y.remove(33);
        endTime   = System.nanoTime();
        totalTime = endTime - startTime;
        seconds = (double)totalTime / 1000000;
        System.out.println("Coalesced remove(3) time -> " +seconds + " ms");        

        startTime = System.nanoTime();
        z.remove(11);
        z.remove(22);
        z.remove(33);
        endTime   = System.nanoTime();
        totalTime = endTime - startTime;
        seconds = (double)totalTime / 1000000;
        System.out.println("Coalesced remove(3) time -> " +seconds + " ms\n\n\n");

//-----------------------------------------------------------------------------------
        System.out.println("There are problems from here\n");


        startTime = System.nanoTime();
        ChainLinked<Integer, Integer> a = new ChainLinked<>();
        low=0;
        high=200;
        for(int i=0; i<100; i++){
            key = r.nextInt(high-low) + low;
            value = r.nextInt(high-low) + low;
            a.put(key, value);
        }
        endTime   = System.nanoTime();
        totalTime = endTime - startTime;
        seconds = (double)totalTime / 1000000;
        System.out.println("ChainLinked add(100) time -> " +seconds + " ms");


        startTime = System.nanoTime();
        ChainTree<Integer, Integer> b = new ChainTree<>();
        for(int i=0; i<100; i++){
            key = r.nextInt(high-low) + low;
            value = r.nextInt(high-low) + low;
           // b.put(key, value);
        }
        endTime   = System.nanoTime();
        totalTime = endTime - startTime;
        seconds = (double)totalTime / 1000000;
        System.out.println("ChainTree add(100) time -> " +seconds + " ms");



        startTime = System.nanoTime();
        Coalesced<Integer, Integer> c = new Coalesced<>();
        for(int i=0; i<10; i++){
            key = r.nextInt(high-low) + low;
            value = r.nextInt(high-low) + low;
           // c.add(key, value);
        }
        endTime   = System.nanoTime();
        totalTime = endTime - startTime;
        seconds = (double)totalTime / 1000000;
        System.out.println("Coalesced add(100) time -> " +seconds + " ms\n\n\n");

//-----------------------------------------------------------------------------------
        


        startTime = System.nanoTime();
        ChainLinked<Integer, Integer> d = new ChainLinked<>();
        low=0;
        high=2000;
        for(int i=0; i<1000; i++){
            key = r.nextInt(high-low) + low;
            value = r.nextInt(high-low) + low;
            d.put(key, value);
        }
        endTime   = System.nanoTime();
        totalTime = endTime - startTime;
        seconds = (double)totalTime / 1000000;
        System.out.println("ChainLinked add(100) time -> " +seconds + " ms");


        startTime = System.nanoTime();
        ChainTree<Integer, Integer> e = new ChainTree<>();
        for(int i=0; i<1000; i++){
            key = r.nextInt(high-low) + low;
            value = r.nextInt(high-low) + low;
           // e.put(key, value);
        }
        endTime   = System.nanoTime();
        totalTime = endTime - startTime;
        seconds = (double)totalTime / 1000000;
        System.out.println("ChainTree add(100) time -> " +seconds + " ms");



        startTime = System.nanoTime();
        Coalesced<Integer, Integer> f = new Coalesced<>();
        for(int i=0; i<1000; i++){
            key = r.nextInt(high-low) + low;
            value = r.nextInt(high-low) + low;
          //  f.add(key, value);
        }
        endTime   = System.nanoTime();
        totalTime = endTime - startTime;
        seconds = (double)totalTime / 1000000;
        System.out.println("Coalesced add(100) time -> " +seconds + " ms");


//******************************************************************


    }




}
