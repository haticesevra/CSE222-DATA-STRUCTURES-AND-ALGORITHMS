import java.util.*;

public class DriverCode {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_CYAN = "\u001B[36m";


    public DriverCode(){
        part2();
        part3();
    }


    private void part2() {
        System.out.println("*****************************");
        System.out.println(    "********** PART2 ************");
        sample();

        Graph graph;

        ArrayList<Double> bfs_1000 = new ArrayList<>();
        ArrayList<Double> bfs_2000 = new ArrayList<>();
        ArrayList<Double> bfs_5000 = new ArrayList<>();
        ArrayList<Double> bfs_10000 = new ArrayList<>();
        ArrayList<Double> dfs_1000 = new ArrayList<>();
        ArrayList<Double> dfs_2000 = new ArrayList<>();
        ArrayList<Double> dfs_5000 = new ArrayList<>();
        ArrayList<Double> dfs_10000 = new ArrayList<>();

        System.out.print(ANSI_PURPLE);
        System.out.println("-------------------------------------- RANDOM GRAPH 1000 -------------------------------------------");
        graph = generateGraph(2001); //2000 bound oluyor, size 1000
        // System.out.println("\nALL VERTEXES IN THE GRAPH = " + graph.getVertexList().toString());
        System.out.println();
        for(int k=0; k<10; k++) {
            ArrayList<Integer> check = new ArrayList<>();
            long startTime, totalTime, endTime;
            double seconds;
            int ctr = 1;
            startTime = System.nanoTime();
            for (int i = 0; i < graph.getVertexList().size(); i++) {
                if (!graph.exist(check, graph.getVertexList().get(i))) {
                    check = graph.connectCounterBFS(graph.getVertexList().get(i));
                    graph.connectCounterBFS(graph.getVertexList().get(i));
                    ctr++;
                }
            }
            endTime = System.nanoTime();
            totalTime = endTime - startTime;
            seconds = (double) totalTime / 1_000_000.0;
            //  System.out.println("\nBFS time 2000:  " + seconds + " ms");
            bfs_1000.add(seconds);

            ctr = 1;
            startTime = System.nanoTime();
            for (int i = 0; i < graph.getVertexList().size(); i++) {
                if (!graph.exist(check, graph.getVertexList().get(i))) {
                    check = graph.connectCounterDFS(graph.getVertexList().get(i));
                    graph.connectCounterDFS(graph.getVertexList().get(i));
                    ctr++;
                }
            }
            endTime = System.nanoTime();
            totalTime = endTime - startTime;
            seconds = (double) totalTime / 1_000_000.0;
            // System.out.println("\nDFS time 2000:  " + seconds + " ms");
            dfs_1000.add(seconds);
        }
        System.out.printf("Average of 10 times BFS (size 1000) ->  %.4f ms\n" , average(bfs_1000));
        System.out.printf("Average of 10 times DFS (size 1000) ->  %.4f ms" , average(dfs_1000));
        System.out.print(ANSI_RESET);


        System.out.print(ANSI_GREEN);
        System.out.println("\n\n-------------------------------------- RANDOM GRAPH 2000 -------------------------------------------");
        graph = generateGraph(4001);
        //  System.out.println("ALL VERTEXES IN THE GRAPH = " + graph.getVertexList().toString());
        System.out.println();
        for(int k=0; k<10; k++) {
            ArrayList<Integer> check = new ArrayList<>();
            long startTime, totalTime, endTime;
            double seconds;
            int ctr = 1;
            startTime = System.nanoTime();
            for (int i = 0; i < graph.getVertexList().size(); i++) {
                if (!graph.exist(check, graph.getVertexList().get(i))) {
                    check = graph.connectCounterBFS(graph.getVertexList().get(i));
                    graph.connectCounterBFS(graph.getVertexList().get(i));
                    ctr++;
                }
            }
            endTime = System.nanoTime();
            totalTime = endTime - startTime;
            seconds = (double) totalTime / 1_000_000.0;
            //  System.out.println("\nBFS time 2000:  " + seconds + " ms");
            bfs_2000.add(seconds);

            ctr = 1;
            startTime = System.nanoTime();
            for (int i = 0; i < graph.getVertexList().size(); i++) {
                if (!graph.exist(check, graph.getVertexList().get(i))) {
                    check = graph.connectCounterDFS(graph.getVertexList().get(i));
                    graph.connectCounterDFS(graph.getVertexList().get(i));
                    ctr++;
                }
            }
            endTime = System.nanoTime();
            totalTime = endTime - startTime;
            seconds = (double) totalTime / 1_000_000.0;
            // System.out.println("\nDFS time 2000:  " + seconds + " ms");
            dfs_2000.add(seconds);
        }
        System.out.printf("Average of 10 times BFS (size 2000) ->  %.4f ms\n" , average(bfs_2000));
        System.out.printf("Average of 10 times DFS (size 2000) ->  %.4f ms" , average(dfs_2000));
        System.out.print(ANSI_RESET);

        System.out.print(ANSI_CYAN);
        System.out.println("\n\n-------------------------------------- RANDOM GRAPH 5000 -------------------------------------------");
        graph = generateGraph(10001);
        // System.out.println("ALL VERTEXES IN THE GRAPH = " + graph.getVertexList().toString());
        System.out.println();
        for(int k=0; k<10; k++) {
            ArrayList<Integer> check = new ArrayList<>();
            long startTime, totalTime, endTime;
            double seconds;
            int ctr = 1;
            startTime = System.nanoTime();
            for (int i = 0; i < graph.getVertexList().size(); i++) {
                if (!graph.exist(check, graph.getVertexList().get(i))) {
                    check = graph.connectCounterBFS(graph.getVertexList().get(i));
                    graph.connectCounterBFS(graph.getVertexList().get(i));
                    ctr++;
                }
            }
            endTime = System.nanoTime();
            totalTime = endTime - startTime;
            seconds = (double) totalTime / 1_000_000.0;
            //  System.out.println("\nBFS time 2000:  " + seconds + " ms");
            bfs_5000.add(seconds);

            ctr = 1;
            startTime = System.nanoTime();
            for (int i = 0; i < graph.getVertexList().size(); i++) {
                if (!graph.exist(check, graph.getVertexList().get(i))) {
                    check = graph.connectCounterDFS(graph.getVertexList().get(i));
                    graph.connectCounterDFS(graph.getVertexList().get(i));
                    ctr++;
                }
            }
            endTime = System.nanoTime();
            totalTime = endTime - startTime;
            seconds = (double) totalTime / 1_000_000.0;
            // System.out.println("\nDFS time 2000:  " + seconds + " ms");
            dfs_5000.add(seconds);
        }
        System.out.printf("Average of 10 times BFS (size 5000) ->  %.4f ms\n" , average(bfs_5000));
        System.out.printf("Average of 10 times DFS (size 5000) ->  %.4f ms" , average(dfs_5000));
        System.out.print(ANSI_RESET);


        System.out.print(ANSI_YELLOW);
        System.out.println("\n\n-------------------------------------- RANDOM GRAPH 10.000 -------------------------------------------");
        graph = generateGraph(20001);
        //  System.out.println("ALL VERTEXES IN THE GRAPH = " + graph.getVertexList().toString());
        System.out.println();
        for(int k=0; k<10; k++) {
            ArrayList<Integer> check = new ArrayList<>();
            long startTime, totalTime, endTime;
            double seconds;
            int ctr = 1;
            startTime = System.nanoTime();
            for (int i = 0; i < graph.getVertexList().size(); i++) {
                if (!graph.exist(check, graph.getVertexList().get(i))) {
                    check = graph.connectCounterBFS(graph.getVertexList().get(i));
                    graph.connectCounterBFS(graph.getVertexList().get(i));
                    ctr++;
                }
            }
            endTime = System.nanoTime();
            totalTime = endTime - startTime;
            seconds = (double) totalTime / 1_000_000.0;
            //  System.out.println("\nBFS time 2000:  " + seconds + " ms");
            bfs_10000.add(seconds);

            ctr = 1;
            startTime = System.nanoTime();
            for (int i = 0; i < graph.getVertexList().size(); i++) {
                if (!graph.exist(check, graph.getVertexList().get(i))) {
                    check = graph.connectCounterDFS(graph.getVertexList().get(i));
                    graph.connectCounterDFS(graph.getVertexList().get(i));
                    ctr++;
                }
            }
            endTime = System.nanoTime();
            totalTime = endTime - startTime;
            seconds = (double) totalTime / 1_000_000.0;
            // System.out.println("\nDFS time 2000:  " + seconds + " ms");
            dfs_10000.add(seconds);
        }
        System.out.printf("Average of 10 times BFS (size 10.000) ->  %.4f ms\n" , average(bfs_10000));
        System.out.printf("Average of 10 times DFS (size 10.000) ->  %.4f ms" , average(dfs_10000));
        System.out.print(ANSI_RESET);

    }

    private static double average(ArrayList<Double> arr) {
        double tot=0;
        for(int i=0; i<arr.size(); i++)
            tot += arr.get(i);

        return tot/arr.size();
    }

    private static void sample() {
        System.out.println("SAMPLE FUNCTION");

        Graph graph= new Graph(25);
        graph.addVertex(0);
        graph.addVertex(1);
        graph.addVertex(2);
        graph.addVertex(3);
        graph.addVertex(4);
        graph.addVertex(5);

        graph.addVertex(11);
        graph.addVertex(12);
        graph.addVertex(13);
        graph.addVertex(14);
        graph.addVertex(15);

        graph.addVertex(20);
        graph.addVertex(22);
        graph.addVertex(24);


        graph.addEdge(0,2);
        graph.addEdge(0,1);
        graph.addEdge(1,3);
        graph.addEdge(1,5);
        graph.addEdge(2,3);
        graph.addEdge(3,4);
        graph.addEdge(5,4);

        graph.addEdge(11, 12);
        graph.addEdge(12, 13);
        graph.addEdge(12, 14);
        graph.addEdge(14, 15);
        graph.addEdge(13, 15);

        graph.addEdge(22, 24);

        List<Integer> check = new ArrayList<>();

        System.out.println("ALL VERTEXES IN THE GRAPH = " + graph.getVertexList().toString());
        int ctr=1;
        for(int i=0; i<graph.getVertexList().size(); i++){
            if(!graph.exist(check, graph.getVertexList().get(i))) {
                check = graph.connectCounterBFS(graph.getVertexList().get(i));
                System.out.println("Connected Components Part "+ctr +ANSI_BLUE + " with BREADTH FIRST TRAVERSAL");
                System.out.println( graph.connectCounterBFS(graph.getVertexList().get(i)));
                System.out.println(ANSI_RESET+ "Number Of Connected Components: " + check.size());

                System.out.println("\nConnected Components Part "+ ctr +ANSI_PURPLE + " with DEPTH FIRST TRAVERSAL");
                System.out.println(graph.connectCounterDFS(graph.getVertexList().get(i)));
                System.out.println(ANSI_RESET +"Number Of Connected Components: " + check.size()+ "\n");
                ctr++;
            }
        }

    }

    private static Graph generateGraph(int size) {
        Graph graph = new Graph(size);

        Set<Integer> numbers = generateRandom(size/2, size-1);

        int i=0, prev = 0;
        Iterator value = numbers.iterator();
        while (value.hasNext()) {
            //   System.out.println(value.next());
            graph.addVertex((Integer) value.next());
            if(i%3 == 0)
                graph.addEdge((Integer)value.next(), prev);

            else if(i%13 == 0)
                graph.addEdge((Integer)value.next(), prev);

            else if(i%25 == 0)
                graph.addEdge((Integer)value.next(), prev);

            else if(i%34 == 0)
                graph.addEdge((Integer)value.next(), prev);

            else if(i%7 == 0)
                graph.addEdge((Integer)value.next(), prev);

            i++;
            if(value.hasNext())
                prev = (Integer) value.next();
        }
        return graph;

    }

    public static Set<Integer> generateRandom(int size, int bound){
        Random randNum = new Random();
        Set<Integer> set = new LinkedHashSet<Integer>();
        while (set.size() < size)
            set.add(randNum.nextInt(bound)+1);
        return set;
    }


    private static void part3() {
        System.out.println("\n\n\n*****************************");
        System.out.println(    "********** PART3 ************");

        Graph graph= new Graph(20);


        graph.addVertex(0);
        graph.addVertex(1);
        graph.addVertex(2);
        graph.addVertex(3);
        graph.addVertex(4);
        graph.addVertex(5);

        graph.addVertex(11);
        graph.addVertex(12);
        graph.addVertex(13);
        graph.addVertex(14);
        graph.addVertex(15);

        graph.addEdge(0,2);
        graph.addEdge(0,1);
        graph.addEdge(1,3);
        graph.addEdge(1,5);
        graph.addEdge(2,3);
        graph.addEdge(3,4);
        graph.addEdge(5,4);

        graph.addEdge(11, 12);
        graph.addEdge(12, 13);
        graph.addEdge(12, 14);
        graph.addEdge(14, 15);
        graph.addEdge(13, 15);


        List<Integer> check = new ArrayList<>();
        ArrayList<Integer> start = new ArrayList<>();

        int ctr=1;
        for(int i=0; i<graph.getVertexList().size(); i++) {
            if (!graph.exist(check, graph.getVertexList().get(i))) {
                check = graph.connectCounterBFS(graph.getVertexList().get(i));
                start.add(check.get(0));
            }
        }

        ArrayList<Integer> verList = graph.getVertexList();
        System.out.println("All vertexes = " + verList.toString());

        double total=0;

        for(int k=0; k<start.size(); k++) {
            System.out.print( ANSI_YELLOW + "\nConnected Vertices: " );
            total = 0;
            ArrayList<Integer> arr = graph.BFS(start.get(k));
            System.out.print(ANSI_RESET);
            for (int i = 0; i < arr.size(); i++) {
                total += calculateImportance(graph, arr.get(i), arr.size());
            }

            System.out.print(ANSI_BLUE);
            System.out.printf("\nTOTAL : %.4f\n", total);
            System.out.println("NUM OF CONNECTED VERTICES: " + arr.size());
            System.out.printf("FAIR IMPORTANCE VALUE :  %.4f\n\n", total / (arr.size() * arr.size()));
            System.out.print(ANSI_RESET);

        }
    }



    private static double calculateImportance(Graph graph, int v, int arrSize) {
        ArrayList<Integer> list = graph.getList();
        // int w=14;
        double tot=0;
        int numOfComp =0;
        double  sigma_uw=0; double sigma_uw_v=0;
        for(int i=0; i<list.size(); i++){
            for(int j=i; j<list.size(); j++){
                if(list.get(i) != list.get(j) && list.get(i)!=v && list.get(j)!=v) {
                    graph.resetPathCtr();
                    graph.resetMinPathSize();
                    graph.printAllPaths(list.get(i),list.get(j), -1);
                    sigma_uw = graph.getPathCtr();
                    if(sigma_uw != 0) {
                        graph.resetPathCtr();
                        graph.resetMinPathSize();
                        graph.printAllPaths(list.get(i), list.get(j), v);
                        sigma_uw_v = graph.getPathCtr();
                        if(sigma_uw_v != 0) {
                            //    System.out.println("nosp " + sigma_uw);
                            //System.out.println("nospv  " + sigma_uw_v);
                            tot += (sigma_uw_v / sigma_uw);
                            //numOfComp = g2.getMinPathSize()-1;
                            System.out.println("\nu-> " + list.get(i) + "  w-> " + list.get(j) + "  v-> " + v);
                            System.out.println("Sigma uw(v) / sigma uw:  " + sigma_uw_v / sigma_uw);
                            System.out.println("Current Total:  " + tot);
                        }
                    }

                }
            }
        }
        return tot;



    }

}
