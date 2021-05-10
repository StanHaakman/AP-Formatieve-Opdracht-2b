package fsm.domain;

public class Node {
    public String name;
    public Node nextA;
    public Node nextB;

    public Node(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Node " +
                "name: " + name;
    }

    public Node getNext(char letter) {
        return switch (letter) {
            case 'A' -> nextA;
            case 'B' -> nextB;
            default -> null;
        };
    }

    public void setNextA(Node nextA) {
        this.nextA = nextA;
    }

    public void setNextB(Node nextB) {
        this.nextB = nextB;
    }
}
