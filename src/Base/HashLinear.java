package Base;
public class HashLinear
{
    public int size;
    public int capacity;
    public int[] values;
    public String[] keys;

    public HashLinear(int capacity) // constructor for HashLinear class
    {
        this.capacity = capacity; // set capacity
        this.values = new int[capacity]; // initialize values array to capacity size
        this.keys = new String[capacity]; // initialize keys array to capacity size
    }
}
