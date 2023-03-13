package Tables;
import Base.HashLinear;
public class HashTableLinear
{
    public HashLinear table = new HashLinear(10_000_000);

    public int hash(String key)
    {
        int hashValue = 0;
        for (int i = 0; i < key.length(); i++) {
            hashValue = (hashValue * 31 + key.charAt(i));
        }
        return hashValue % table.capacity;
    }

    public void put(String key, int value)
    {
        int index = hash(key); // get index of key in table
        while (table.keys[index] != null) // if key is not null
        {
            if (table.keys[index].equals(key)) // key already exists in table
            {
                table.values[index] = value; // update value if key already exists
                return;
            }
            index = (index + 1) % table.capacity;
        }
        table.keys[index] = key;
        table.values[index] = value;
        table.size++;
        if (table.size >= table.capacity * 0.75)
        {
            resize(table.capacity * 2);
        }
    }

    public void get(String key)
    {
        int index = hash(key);
        while (table.keys[index] != null)
        {
            if (table.keys[index].equals(key))
            {
                return;
            }
            index = (index + 1) % table.capacity;
        }
    }

    public void remove(String key)
    {
        int index = hash(key);
        while (table.keys[index] != null)
        {
            if (table.keys[index].equals(key))
            {
                table.keys[index] = null;
                table.values[index] = 0;
                table.size--;
                return;
            }
            index = (index + 1) % table.capacity;
        }
    }
    private void resize(int newCapacity)
    {
        String[] newKeys = new String[newCapacity]; // create new arrays
        int[] newValues = new int[newCapacity]; // create new arrays
        for (int i = 0; i < table.capacity; i++) // copy old arrays to new arrays
        {
            if (table.keys[i] != null) // if key is not null
            {
                int index = hash(table.keys[i]); // hash the key
                while (newKeys[index] != null) // if the new key is not null
                {
                    index = (index + 1) % newCapacity; // increment index
                }
                newKeys[index] = table.keys[i];
                newValues[index] = table.values[i];
            }
        }
        table.keys = newKeys;
        table.values = newValues;
        table.capacity = newCapacity;
    }

}
