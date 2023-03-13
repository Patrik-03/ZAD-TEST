package Base;

public class HashChaining
{
    public String key;
    public int value;
    public HashChaining next;

    public HashChaining(String key, int value) // constructor for HashChaining
    {
        this.key = key; // set key
        this.value = value; // set value
        this.next = null; // set next node to null
    }
}
