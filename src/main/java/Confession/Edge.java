package Confession;

/**
 *
 * @author Marvin Chin Yi Kai
 */

public class Edge<T extends Comparable<T>, N extends Comparable <N>> {
    Vertex<T,N> toVertex;
    N weight;
    Edge<T,N> nextEdge;
    
    public Edge() {
        this(null, null, null);
    }
    
    public Edge(Vertex<T,N> toVertex, N weight, Edge<T,N> nextEdge) {
        this.toVertex = toVertex;
        this.weight = weight;
        this.nextEdge = nextEdge;
    }
}
