package Tables;
import Base.HashTable;
public class HashLinear
{
    public HashTable table = new HashTable(10); // Initialize the table with a capacity of
    public int hash(String key, int capacity)
    {
        int hash = 0; // Initialize the hash
        for (int i = 0; i < key.length(); i++)
        {
            hash += key.charAt(i); // Add the ASCII value of the character to the hash
        }
        return hash % capacity; // Return the index of the key in the table after hashing
    }
    public void insert(String key, int value)
    {
        int index = hash(key, table.capacity);
        while (table.keys[index] != null)
        {
            index = (index + 1) % table.capacity; // Linear probing to find the key in the table
        }
        table.keys[index] = key;
        table.values[index] = value;
        table.size++;
        if(table.size >= table.capacity * 0.75) // If the table is full
        {
            resize(table.capacity * 2); // Resize the table
        }
        else if(table.size <= table.capacity * 0.25) // If the table is empty
        {
            resize(table.capacity / 2); // Resize the table
        }
    }
    public void delete(String key)
    {
        int index = hash(key, table.capacity); // Get the index of the key in the table
        while (table.keys[index] != null) // Loop until the key is found
        {
            if (table.keys[index].equals(key)) // If the key is found
            {
                table.keys[index] = null;
                table.values[index] = 0;
                table.size--;
                if(table.size <= table.capacity * 0.25) // If the table is empty
                {
                    resize(table.capacity / 2); // Resize the table
                }
            }
            index = (index + 1) % table.capacity; // Linear probing to find the key in the table
        }
    }
    public void search(String key)
    {
        int index = hash(key, table.capacity); // Get the index of the key in the table
        while (table.keys[index] != null) // Loop until the key is found
        {
            if (table.keys[index].equals(key)) // If the key is found
            {
                System.out.println("Found Key:" + key);
                return;
            }
            index = (index + 1) % table.capacity; // Linear probing to find the key in the table
        }
        System.out.println("Not Found Key:" + key);
    }
    public void resize(int newCapacity)
    {
        HashTable newTable = new HashTable(newCapacity);
        for (int i = 0; i < table.capacity; i++)
        {
            if (table.keys[i] != null)
            {
                int newIndex = hash(table.keys[i],newCapacity); // Get the index of the key in the table after resizing
                while (newTable.keys[newIndex] != null) // Loop until the key is found
                {
                    newIndex = (newIndex + 1) % newTable.capacity; // Linear probing to find the key in the table after resizing
                }
                newTable.keys[newIndex] = table.keys[i]; // Insert the key in the new table
                newTable.values[newIndex] = table.values[i]; // Insert the value in the new table
                newTable.size = table.size; // Set the size of the new table
            }
        }
        table = newTable; // Set the new table as the table
    }
}
