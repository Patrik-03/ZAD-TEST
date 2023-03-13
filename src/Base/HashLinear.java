package Base;
public class HashLinear
{
    public int size;
    public int capacity;
    public int[] values;
    public String[] keys;

    public HashLinear(int capacity)
    {
        this.capacity = capacity;
        this.values = new int[capacity];
        this.keys = new String[capacity];
    }
}
