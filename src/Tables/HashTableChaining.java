package Tables;
import Base.HashChaining;

public class HashTableChaining
{
    public HashChaining[] table;
    public int sizeT;
    public HashTableChaining(int capacity) // constructor for HashTableChaining class
    {
        sizeT = capacity;
        table = new HashChaining[sizeT];
        for (int i = 0; i < sizeT; i++) // initialize all values to null
        {
            table[i] = null;
        }
    }
    public int hash(String key) // hash function
    {
        int hashVal = key.hashCode();
        hashVal %= sizeT;
        if (hashVal < 0)
            hashVal += sizeT;
        return hashVal;
    }
    public void put(String key, int value)
    {
        int index = (hash(key) % sizeT);
        if(table[index] == null)
        {
            table[index] = new HashChaining(key, value); // set first node to entry
        }
        else // if first node is not null
        {
            HashChaining temp = table[index];
            while(temp.next != null && !temp.key.equals(key)) // while key is not found
            {
                temp = temp.next; // set temp to next node
            }
            if(temp.key.equals(key)) // if key is found
            {
                temp.value = value; // update value
            }
            else
            {
                temp.next = new HashChaining(key, value); // set next node to entry
            }
        }
    }
    public void remove(String key)
    {
        int hash = (hash(key) % sizeT);
        if(table[hash] != null)
        {
            HashChaining prev = null;
            HashChaining entry = table[hash];
            while(entry.next != null && !entry.key.equals(key))
            {
                prev = entry;
                entry = entry.next;
            }
            if(entry.key.equals(key))
            {
                if(prev == null)
                {
                    table[hash] = entry.next;
                }
                else
                    prev.next = entry.next;
            }
        }

    }
    public void get(String key)
    {
        int index = (hash(key) % sizeT);
        if(table[index] != null)
        {
            HashChaining temp = table[index];
            while(temp.next != null && !temp.key.equals(key))
            {
                temp = temp.next;
            }
            if(temp.key.equals(key))
            {
                return;
            }
        }
    }
}
