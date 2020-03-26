package pl;

public class App {
    public static void main(String[] args) {
        Graph BFS = new Graph(6);

        BFS.add(new Node("Dawid"));
        BFS.add(new Node("Adam"));
        BFS.add(new Node("Tomek"));
        BFS.add(new Node("Bartek"));
        BFS.add(new Node("Piotr"));
        BFS.add(new Node("Darek"));

        BFS.addRelationById(0, 1);
        BFS.addRelationById(2, 0);
        BFS.addRelationById(3, 2);
        BFS.addRelationById(3, 4);
        BFS.addRelationById(1, 5);
        BFS.addRelationById(5, 4);

        BFS.run(5);

        System.out.println(BFS.getLevelOfRelation(0));

    }

}
