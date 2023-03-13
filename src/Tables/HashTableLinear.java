package Tables;
import Base.HashLinear;
public class HashTableLinear
{
    public HashLinear table; // HashLinear object

    public HashTableLinear(int capacity) // constructor for HashTableLinear class
    {
        table = new HashLinear(capacity); // create new HashLinear object
    }

    public int hash(String key) // hash function
    {
        int hashValue = 0; // initialize hashValue to 0
        for (int i = 0; i < key.length(); i++) // for each character in key
        {
            hashValue = (hashValue * 31 + key.charAt(i)); // multiply hashValue by 31 and add character
        }
        return Math.abs(hashValue % table.capacity); // return absolute value of hashValue mod capacity
    }

    public void put(String key, int value) // put key and value into table
    {
        int index = hash(key); // get index of key in table
        while (table.keys[index] != null) // if key is not null
        {
            if (table.keys[index].equals(key)) // key already exists in table
            {
                table.values[index] = value; // update value if key already exists
                return;
            }
            index = (index + 1) % table.capacity; // linear probing
        }
        table.keys[index] = key; // set key
        table.values[index] = value; // set value
        table.size++; // increment size
        if (table.size >= table.capacity * 0.75) // if size is greater than 75% of capacity
        {
            resize(table.capacity * 2); // resize table to double capacity
        }
    }
    public boolean get(String key) // get value of key
    {
        int index = hash(key); // get index of key in table
        while (table.keys[index] != null)  //if key is not null
        {
            if (table.keys[index].equals(key)) // if key is found
            {
                return true;
            }
            index = (index + 1) % table.capacity; // linear probing
        }
        return false; // if key is not found
    }

    public void remove(String key) // remove key and value from table
    {
        int index = hash(key); // get index of key in table
        while (table.keys[index] != null) // if key is not null
        {
            if (table.keys[index].equals(key)) // if key is found
            {
                table.keys[index] = null; // set key to null
                table.values[index] = 0; // set value to 0
                table.size--; // decrement size
                return;
            }
            index = (index + 1) % table.capacity; // linear probing
        }
        if (table.size <= table.capacity * 0.25) // if size is less than 25% of capacity
        {
            resize(table.capacity / 2); // resize table to half capacity
        }
    }
    private void resize(int newCapacity) // resize table
    {
        String[] newKeys = new String[newCapacity]; // create new array for keys
        int[] newValues = new int[newCapacity]; // create new array for values
        for (int i = 0; i < table.capacity; i++) // copy old array to new array
        {
            if (table.keys[i] != null) // if key is not null
            {
                int index = hash(table.keys[i]); // hash the key
                while (newKeys[index] != null) // if the new key is not null
                {
                    index = (index + 1) % newCapacity; // linear probing
                }
                newKeys[index] = table.keys[i]; // set new key
                newValues[index] = table.values[i]; // set new value
            }
        }
        table.keys = newKeys; // set old array to new array
        table.values = newValues; // set old array to new array
        table.capacity = newCapacity; // set old capacity to new capacity
    }
}
