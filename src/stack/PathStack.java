package stack;

import interfaces.CustomStack;
import interfaces.Path;

public class PathStack<T> implements CustomStack<T>
{
    private Path<T> linkedPath;
    
    @Override
    public void push(T item)
    {
        linkedPath = new LinkedPath(item, linkedPath);
    }

    @Override
    public T pop()
    {
        T item = linkedPath.getFirst();
        linkedPath = linkedPath.getRest();
        return item;
    }

    @Override
    public boolean isEmpty()
    {
        return linkedPath == null;
    }

    @Override
    public T[] toArray()
    {
        Path<T> path = linkedPath;
        int counter = 0;
        while (path != null)
        {
            path = path.getRest();
            counter++;
        }
        
        path = linkedPath;
        Object[] arr = new Object[counter];
        for (int i = arr.length - 1; i >= 0; i--)
        {
            arr[i] = path.getFirst();
            path = path.getRest();
        }
        
        return (T[]) arr;
    }
    
}
