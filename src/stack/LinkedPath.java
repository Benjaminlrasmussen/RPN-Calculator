package stack;

import interfaces.Path;

public class LinkedPath<T> implements Path<T>
{
    private final T first;
    private final Path<T> rest;
    
    public LinkedPath(T first, Path<T> rest)
    {
        this.first = first;
        this.rest = rest;
    }
    
    @Override
    public T getFirst()
    {
        return first;
    }

    @Override
    public Path<T> getRest()
    {
        return rest;
    }
    
}
