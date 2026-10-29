
import java.util.Scanner;

public class dijkstra {

    static final int INF = 9999;

    public static void main(String[] args) {
        int cost[][] = new int[10][10];
        int dist[] = new int[10];
        int visited[] = new int[10];
        int i, j, n, sv;

        Scanner in = new Scanner(System.in);

        System.out.println("**** DIJKSTRA'S ALGORITHM ****");
        System.out.println("Enter the number of nodes:");
        n = in.nextInt();

        System.out.println("Enter the cost matrix:");
        for (i = 1; i <= n; i++) {
            for (j = 1; j <= n; j++) {
                cost[i][j] = in.nextInt();

                if (i != j && cost[i][j] == 0)
                    cost[i][j] = INF;
            }
        }

        System.out.println("Enter the source vertex:");
        sv = in.nextInt();

        dij(cost, dist, sv, n, visited);

        System.out.println(
            "Total Distance from Source to each Destination is:");

        for (i = 1; i <= n; i++) {
            if (dist[i] == INF)
                System.out.println("From " + sv + " to " + i
                        + " = Unreachable");
            else
                System.out.println("From " + sv + " to " + i
                        + " = " + dist[i]);
        }

        System.out.println("\n********* *************** *********");
        in.close();
    }

    static void dij(int cost[][], int dist[],
                    int v, int n, int s[]) {

        int w, u, i;

        for (i = 1; i <= n; i++) {
            s[i] = 0;
            dist[i] = cost[v][i];
        }

        s[v] = 1;
        dist[v] = 0;

        for (i = 2; i <= n; i++) {
            u = min(n, dist, s);

            if (u == 0)
                break;

            s[u] = 1;

            for (w = 1; w <= n; w++) {
                if (s[w] == 0
                        && cost[u][w] != INF
                        && dist[u] != INF
                        && dist[w] > dist[u] + cost[u][w]) {
                    dist[w] = dist[u] + cost[u][w];
                }
            }
        }
    }

    static int min(int n, int dist[], int s[]) {
        int i, p = 0, min = INF;

        for (i = 1; i <= n; i++) {
            if (min > dist[i] && s[i] == 0) {
                min = dist[i];
                p = i;
            }
        }

        return p;
    }
}
