import java.util.List;

public interface Search<V> {
    boolean hasPathTo(V destination);
    List<V> pathTo(V destination);
}
