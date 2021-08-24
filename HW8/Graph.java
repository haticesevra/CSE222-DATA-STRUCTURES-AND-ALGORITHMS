import java.util.*;

// This class represents a directed graph using adjacency list representation
public class Graph {
    private int V;   // No. of vertices
    private LinkedList<Integer> adj[]; //Adjacency Lists
    private int connectCtr=0;
    private ArrayList<Integer> connections;
    private ArrayList<List<Integer>> shortestPaths;
    private ArrayList<Integer> list;
    private ArrayList<Integer> vertexList;
    private boolean[] visitVertex;


    // Constructor
    Graph(int v) {
        V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; ++i)
            adj[i] = new LinkedList();

        connections = new ArrayList<>();
        shortestPaths = new ArrayList<List<Integer>>();
        list = new ArrayList<>();
        vertexList = new ArrayList<>();
    }

    // Function to add an edge into the graph
    void addEdge(int v, int w) {
        adj[v].add(w);
    }

    void addVertex(int v){
        vertexList.add(v);
    }

    public ArrayList<Integer> getVertexList(){
        return vertexList;
    }

    public ArrayList<Integer> getList(){
        return list;
    }

    public ArrayList<Integer> BFS(int u) {
        ArrayList<Integer> ret = new ArrayList<>();
        // Mark all the vertices as not visited(By default
        // set as false)

        boolean visited[] = new boolean[V];


        // Create a queue for BFS
        LinkedList<Integer> queue = new LinkedList<Integer>();

        // Mark the current node as visited and enqueue it
        visited[u]=true;
        queue.add(u);

        while (queue.size() != 0){
            // Dequeue a vertex from queue and print it
            u = queue.poll();
            ret.add(u);
            System.out.print (u+" , ");
            list.add(u);
            // Get all adjacent vertices of the dequeued vertex s
            // If a adjacent has not been visited, then mark it
            // visited and enqueue it
            Iterator<Integer> i = adj[u].listIterator();
            while (i.hasNext())
            {
                int n = i.next();
               // System.out.print(n+ " -" + u+" , " );
                connections.add(n);
                connections.add(u);

                if (!visited[n])
                {
                    visited[n] = true;
                    queue.add(n);
                }
            }
        }
        for(int i=0; i<connections.size(); i++){
         //   System.out.println(". " + connections.get(i));
        }

        for(int i=0; i<connections.size(); i=i+2){
              if(connections.get(i).equals(u)) {

              }
        }
        return ret;
    }



    public ArrayList<Integer> connectCounterBFS(int start) {
        connectCtr=0;
        ArrayList<Integer> a = new ArrayList<>();
        boolean visited[] = new boolean[V];

        LinkedList<Integer> queue = new LinkedList<Integer>();
        queue.add(start);
        visited[start] = true;

        while (queue.size() != 0) {
            start = queue.poll();
            a.add(start);
          //  System.out.print(start + " ");

            Iterator<Integer> itr = adj[start].listIterator();



            while (itr.hasNext()) {
                int n = itr.next();
                connectCtr++;
                if (!visited[n]) {
                    visited[n] = true;
                    queue.add(n);
                }
            }
        }
        return a;
    }



    // A function used by DFS
    public ArrayList<Integer> DFSUtil(int v, boolean visited[], ArrayList<Integer> aUtil){
        visited[v] = true;
        // System.out.print(v + " ");
        aUtil.add(v);

        Iterator<Integer> itr = adj[v].listIterator();
        while (itr.hasNext()){
            int n = itr.next();
           // System.out.print("&& " + n);
            connectCtr++;
            if (!visited[n])
                DFSUtil(n, visited, aUtil);
        }
        return aUtil;
    }

    // The function to do DFS traversal.
    // It uses recursive
    // DFSUtil()
    public ArrayList<Integer> connectCounterDFS(int v) {
        ArrayList<Integer> aUtil = new ArrayList<>();
        connectCtr=0;
        boolean visited[] = new boolean[V];

        return DFSUtil(v, visited,aUtil);


    }

    public void printAllPaths(int s, int d, int v)
    {
        boolean[] isVisited = new boolean[V];
        ArrayList<Integer> pathList = new ArrayList<>();

        // add source to path[]
        pathList.add(s);

        // Call recursive utility
        printAllPathsUtil(s, d, isVisited, pathList,v);
    }

    // A recursive function to print
    // all paths from 'u' to 'd'.
    // isVisited[] keeps track of
    // vertices in current path.
    // localPathList<> stores actual
    // vertices in the current path
    private int minPathSize=100;
    private int pathCtr=0;

    public int getPathCtr(){
        return pathCtr;
    }

    public void resetPathCtr(){
        pathCtr=0;
    }

    public void resetMinPathSize(){ minPathSize=100;}

    public int getMinPathSize(){
        return minPathSize;

    }


    private void printAllPathsUtil(Integer u, Integer d,
                                   boolean[] isVisited,
                                   List<Integer> localPathList, int v)
    {
        if (u.equals(d)) {
            if(v== -1) {
                if (localPathList.size() == minPathSize) {
                    shortestPaths.add(localPathList);
                    //System.out.println("- "+localPathList);
                    pathCtr++;
                } else if (localPathList.size() < minPathSize) {
                    minPathSize = localPathList.size();
                    shortestPaths = new ArrayList<>();
                    shortestPaths.add(localPathList);
                   // System.out.println("+" + localPathList);
                    pathCtr = 1;
                } else {
                   // System.out.println("%" + localPathList);

                }

            }

            else{
                if (localPathList.size() == minPathSize) {
                    if(exist(localPathList, v)){
                        shortestPaths.add(localPathList);
                     //   System.out.println("-- " + localPathList);
                        pathCtr++;
                    }

                } else if (localPathList.size() < minPathSize) {
                    if(exist(localPathList, v)) {
                        minPathSize = localPathList.size();
                        shortestPaths = new ArrayList<>();
                        shortestPaths.add(localPathList);
                       // System.out.println("++" + localPathList);
                        pathCtr = 1;
                    }
                } else {
                  //  System.out.println("%" + localPathList);

                }
            }

            // if match found then no need to traverse more till depth
            return;
        }

        // Mark the current node
        isVisited[u] = true;

        // Recur for all the vertices
        // adjacent to current vertex
        for (Integer i : adj[u]) {
            if (!isVisited[i]) {
                // store current node
                // in path[]
                localPathList.add(i);
                printAllPathsUtil(i, d, isVisited, localPathList,v);

                // remove current node
                // in path[]
                localPathList.remove(i);
            }
        }

        // Mark the current node
        isVisited[u] = false;
    }

    public boolean exist(List<Integer> localPathList, int v) {
        for(int i=0; i<localPathList.size(); i++)
            if(localPathList.get(i).equals(v))
                return true;
            return false;
    }

}