package labyrinth;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * @author Abdelhakim Qbaich
 * @author André Lalonde
 */
public class AI {

    public static class Node {

        float x, y;
        Node cameFrom;
        int gScore, fScore;

        public Node(float x, float y) {
            this.x = x;
            this.y = y;

            gScore = Integer.MAX_VALUE;
            fScore = Integer.MAX_VALUE;
        }
        
        @Override
        public boolean equals(Object obj) {
            Node node = (Node) obj;
            return x == node.x && y == node.y;
        }

        @Override
        public int hashCode() {
            int hash = 7;
            hash = 37 * hash + Float.floatToIntBits(this.x);
            hash = 37 * hash + Float.floatToIntBits(this.y);
            return hash;
        }
    }

    public static int costDistance(Node node1, Node node2) {
        return (int) (Math.abs(node1.x - node2.x) + Math.abs(node1.y - node2.y));
    }

    private static ArrayList<Node> getNeighbors(Node node) {
        ArrayList<Node> neighbors = new ArrayList<>();

        // Top
        if (Labyrinthe.walls.chercheMuret(new Muret((int) node.x, (int) node.y, true, true)) == null
                && (node.y - 1) > 0) {
            neighbors.add(new Node(node.x, node.y - 1));
        }

        // Left
        if (Labyrinthe.walls.chercheMuret(new Muret((int) node.x, (int) node.y, false, true)) == null
                && (node.x - 1) > 0) {
            neighbors.add(new Node(node.x - 1, node.y));
        }

        // Bottom
        if (Labyrinthe.walls.chercheMuret(new Muret((int) node.x, (int) (node.y + .5), true, true)) == null
                && (node.y + 1) < Labyrinthe.height) {
            neighbors.add(new Node(node.x, node.y + 1));
        }

        // Right
        if (Labyrinthe.walls.chercheMuret(new Muret((int) (node.x + .5), (int) node.y, false, true)) == null
                && (node.x + 1) < Labyrinthe.width) {
            neighbors.add(new Node(node.x + 1, node.y));
        }

        return neighbors;
    }

    static ArrayList<Node> findPath() {
        HashSet<Node> open = new HashSet<>();
        HashSet<Node> closed = new HashSet<>();

        Node start = new Node(Labyrinthe.player.getX(), Labyrinthe.player.getY());
        Node goal = new Node(Labyrinthe.width - 0.5f, Labyrinthe.exitPos + 0.5f);

        start.gScore = 0;
        start.fScore = costDistance(start, goal);
        open.add(start);

        while (!open.isEmpty()) {
            Node current = open.iterator().next();

            for (Node node : open) {
                if (node.fScore < current.fScore) {
                    current = node;
                }
            }
            
            // System.out.println("Current: " + current.x + " " + current.y);
            // System.out.println("Goal: " + goal.x + " " + goal.y);

            if (current == goal) {
                System.out.println("The end");
                // ArrayList<Node> path = new ArrayList<>();
                // System.out.println(current);
                // System.out.println(current.cameFrom);
                // TODO return reconstruct_path(cameFrom, current)

                // System.out.println(path);
                return null;// path;
            }

            open.remove(current);
            closed.add(current);

            for (Node neighbor : getNeighbors(current)) {
                // System.out.println(open.size());
                // System.out.println(closed.size());

                if (closed.contains(neighbor)) {
                    continue;
                }
                
                int nextGScore = current.gScore + 1;
                if (!open.contains(neighbor)) {
                    open.add(neighbor);
                    // System.out.println(open.size());
                } else if (nextGScore >= neighbor.gScore) {
                    continue;
                }

                neighbor.cameFrom = current;
                neighbor.gScore = nextGScore;
                neighbor.fScore = neighbor.gScore + costDistance(neighbor, goal);
            }
        }
        
        System.out.println("null");

        return null;
    }
}
