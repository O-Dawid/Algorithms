package pl;

import java.util.Objects;

public class Node {
    String name;
    int id;

    public Node(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public Node() {
    }

    public Node(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return this.id;
    }

    public Node name(String name) {
        this.name = name;
        return this;
    }

    public Node id(int id) {
        this.id = id;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Node)) {
            return false;
        }
        Node node = (Node) o;
        return Objects.equals(name, node.name) && id == node.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, id);
    }

    @Override
    public String toString() {
        return "{" + " name='" + getName() + "'" + ", id='" + getId() + "'" + "}";
    }

    public void setId(int id) {
        this.id = id;
    }

}
