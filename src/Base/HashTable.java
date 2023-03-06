package Base;
public class HashTable
{
    public int size;
    public int capacity;
    public int[] values;
    public String[] keys;

    public HashTable(int capacity)
    {
        this.capacity = capacity;
        this.values = new int[capacity];
        this.keys = new String[capacity];
    }
}
