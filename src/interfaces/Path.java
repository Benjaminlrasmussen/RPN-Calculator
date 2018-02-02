package interfaces;

public interface Path<T>
{
    public T getFirst();
    public Path<T> getRest();
}
