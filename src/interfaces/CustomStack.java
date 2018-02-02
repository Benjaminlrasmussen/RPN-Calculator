package interfaces;

public interface CustomStack<T>
{
    public void push(T item);
    public T pop();
    public boolean isEmpty();
    public T[] toArray();
}
