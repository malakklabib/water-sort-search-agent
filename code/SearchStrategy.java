package code;

public interface SearchStrategy {
    void add(Node node);
    Node remove();
    boolean isEmpty();
}
