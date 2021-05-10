package fsm;

import fsm.domain.Node;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World");

        Node s0 = new Node("Node nummer 0");
        Node s1 = new Node("Node nummer 1");
        Node s2 = new Node("Node nummer 2");
        Node s3 = new Node("Node nummer 3");

//        Connections to different Nodes
        s0.setNextA(s2);
        s0.setNextB(s1);

//        Connections to different Nodes
        s1.setNextA(s1);
        s1.setNextB(s2);

//        Connections to different Nodes
        s2.setNextB(s3);

//        Connections to different Nodes
        s3.setNextA(s3);
        s3.setNextB(s0);

        List<Node> previousNodes = new ArrayList<>();
        previousNodes.add(s0);

        Scanner myScanner = new Scanner(System.in);
        System.out.println("Vul uw letter reeks in:");

        String letterReeks = myScanner.nextLine();

        transitions(letterReeks, previousNodes);
        System.out.println(previousNodes);
    }

    private static void transitions(String letters, List<Node> previous) {
        for (char letter : letters.toUpperCase(Locale.ROOT).toCharArray()) {
            Node current = previous.get(previous.size() - 1);
            Node next = current.getNext(letter);
            if (next == null) {
                break;
            }
            previous.add(next);
        }
    }
}
