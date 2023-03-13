package Base;

public class HashChaining
{
    public String key;
    public int value;
    public HashChaining next;

    public HashChaining(String key, int value)
    {
        this.key = key;
        this.value = value;
        this.next = null;
    }
}
