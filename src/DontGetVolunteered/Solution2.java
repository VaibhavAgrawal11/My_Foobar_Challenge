package DontGetVolunteered;

import java.util.Scanner;
import java.util.Vector;


public class Solution2 {
    public static int solution(int src, int dest) {
        //Your code here
        class cell {
            int n;
            int dis;

            public cell(int n, int dis) {
                this.n = n;
                this.dis = dis;
            }
        }
        int dx[] = {-2, -1, 1, 2, -2, -1, 1, 2};
        int dy[] = {-8, -16, -16, -8, 8, 16, 16, 8};
        if (src <= 63 && src >= 0 && dest <= 63 && dest >= 0) {
            Vector<cell> q = new Vector<>();
            q.add(new cell(src, 0));
            cell temp;
            int n;
            Boolean visit[] = new Boolean[64];
            for (int i = 0; i < visit.length; i++) {
                visit[i] = false;
            }
            visit[src] = true;
            while (!q.isEmpty()) {
                temp = q.firstElement();
                q.remove(0);
                // if current cell is equal to target cell,
                // return its distance
                for (cell c : q) {
                    if(c.n==dest)
                        return c.dis;
                }
                // loop for all reachable states
                for (int i = 0; i < 8; i++) {
                    n = temp.n + dx[i] + dy[i];
                    if (n >= 0)
                    // If reachable state is not yet visited and
                    // inside board, push that state into queue
                    if (isInside(n) && !visit[n]) {
                        visit[n] = true;
                        q.add(new cell(n, temp.dis + 1));
                    }
                }
            }
        }
        return -1;
    }

    private static boolean isInside(int n) {
        if (n >= 0 && n <= 63)
            return true;
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int src = sc.nextInt();
        int dest = sc.nextInt();
        System.out.println(solution(src, dest));
    }
}
