package learn3;

public class Node implements Comparable<Node> {
    int weight;
    Node leftNode;
    Node rightNode;
    Byte data;

    public Node(Byte data, int weight) {
        this.data = data;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "[" + data + "," + weight + "]";
    }

    @Override
    public int compareTo(Node o) {
        return o.weight - this.weight;
    }
}
