package Prints;
import Tables.HashTableLinear;
public class HashTableLinearPrint
{
    public static void print()
    {
        HashTableLinear hash = new HashTableLinear(10); //initialize hash table

        hash.put("Matej", 11); //add entries to hash table
        hash.put("Kiko", 12); //add entries to hash table
        hash.put("a", 13); //add entries to hash table
        hash.put("b", 14); //add entries to hash table
        hash.put("c", 15); //add entries to hash table
        hash.put("d", 16); //add entries to hash table

        for (int i = 0; i < hash.table.capacity; i++) //print hash table
        {
            if (hash.table.keys[i] != null) //if keys are not null
            {
                System.out.println("Index: " + i + " -> Key: " + hash.table.keys[i] + " Value: " + hash.table.values[i]); //print index, key, and value
            }
        }
        System.out.println("\n");
        System.out.println("Size: " + hash.table.size);
        System.out.println("Capacity: " + hash.table.capacity);
    }
}
