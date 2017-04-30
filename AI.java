import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;

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
            if (obj == this) {
                return true;
            }

            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }

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

    static LinkedList<Character> findPath() {
        HashSet<Node> open = new HashSet<>();
        HashSet<Node> closed = new HashSet<>();

        Node start = new Node(Labyrinthe.player.getX(), Labyrinthe.player.getY());
        Node goal = new Node(Labyrinthe.width - 0.5f, Labyrinthe.exitPos + 0.5f);

        start.gScore = 0;
        start.fScore = costDistance(start, goal);
        open.add(start);

        while (!open.isEmpty()) {
            Node current = null;

            for (Node node : open) {
                if (current == null || node.fScore < current.fScore) {
                    current = node;
                }
            }

            if (current.equals(goal)) {
                LinkedList<Character> path = new LinkedList<>();

                Node node = current;
                while (node.cameFrom != null) {
                    if (node.x - node.cameFrom.x > 0) {
                        path.addFirst('D');
                    } else if (node.x - node.cameFrom.x < 0) {
                        path.addFirst('G');
                    } else if (node.y - node.cameFrom.y > 0) {
                        path.addFirst('B');
                    } else if (node.y - node.cameFrom.y < 0) {
                        path.addFirst('H');
                    }

                    node = node.cameFrom;
                }

                return path;
            }

            open.remove(current);
            closed.add(current);

            for (Node neighbor : getNeighbors(current)) {
                if (closed.contains(neighbor)) {
                    continue;
                }

                int nextGScore = current.gScore + 1;
                if (!open.contains(neighbor)) {
                    open.add(neighbor);
                } else if (nextGScore >= neighbor.gScore) {
                    continue;
                }

                neighbor.cameFrom = current;
                neighbor.gScore = nextGScore;
                neighbor.fScore = neighbor.gScore + costDistance(neighbor, goal);
            }
        }

        return null;
    }
}
