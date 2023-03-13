package Tables;
import Base.HashChaining;

public class HashTableChaining
{
    public HashChaining[] table; // hash table array
    public int sizeT; // size of hash table
    public HashTableChaining(int capacity) // constructor for HashTableChaining class
    {
        sizeT = capacity; // set size of hash table
        table = new HashChaining[sizeT]; // create new hash table array
        for (int i = 0; i < sizeT; i++) // initialize all values to null
        {
            table[i] = null; // set all values to null
        }
    }
    public int hash(String key) // hash function
    {
        int hashVal = key.hashCode(); // get hash code
        hashVal %= sizeT; // mod hash code by size of hash table
        if (hashVal < 0) // if hash code is negative
            hashVal += sizeT; // add size of hash table to hash code
        return hashVal; // return hash code
    }
    public void put(String key, int value) // put key and value into table
    {
        int index = (hash(key) % sizeT); // get index of key in table
        if(table[index] == null) // if first node is null
        {
            table[index] = new HashChaining(key, value); // set first node to entry
        }
        else // if first node is not null
        {
            HashChaining temp = table[index]; // set temp to first node
            while(temp.next != null && !temp.key.equals(key)) // while key is not found
            {
                temp = temp.next; // set temp to next node
            }
            if(temp.key.equals(key)) // if key is found
            {
                temp.value = value; // update value
            }
            else // if key is not found
            {
                temp.next = new HashChaining(key, value); // set next node to entry
            }
        }
    }
    public void remove(String key) // remove key and value from table
    {
        int index = (hash(key) % sizeT); // get index of key in table
        if(table[index] != null) // if first node is not null
        {
            HashChaining prev = null; // set previous node to null
            HashChaining entry = table[index]; // set entry to first node
            while(entry.next != null && !entry.key.equals(key)) // while key is not found and next node is not null
            {
                prev = entry; // set previous node to entry
                entry = entry.next; // set entry to next node
            }
            if(entry.key.equals(key)) // if key is found
            {
                if(prev == null) // if previous node is null
                {
                    table[index] = entry.next; // set first node to next node
                }
                else // if previous node is not null
                    prev.next = entry.next; // set previous node to next node
            }
        }

    }
    public boolean get(String key) // get value of key
    {
        int index = (hash(key) % sizeT); // get index of key in table
        if(table[index] != null) // if first node is not null
        {
            HashChaining temp = table[index]; // set temp to first node
            while(temp.next != null && !temp.key.equals(key)) // while key is not found and next node is not null
            {
                temp = temp.next; // set temp to next node
            }
            return temp.key.equals(key); // return true if key is found
        }
        return false; // return false if key is not found
    }
}
