package Prints;
import Tables.HashTableLinearProbing;
public class HashTableLinearPrint
{
    public static void print()
    {
        HashTableLinearProbing hash = new HashTableLinearProbing();

        hash.put("a", 1);
        hash.put("b", 2);
        hash.put("c", 3);
        hash.put("d", 4);
        hash.put("e", 5);
        hash.put("f", 6);
        hash.put("g", 7);
        hash.put("h", 8);
        hash.put("i", 9);
        hash.put("j", 10);
        hash.get("a");
        hash.get("b");
        hash.remove("a");
        hash.remove("b");
        hash.remove("c");

        //print keys with values and index
        for (int i = 0; i < hash.table.capacity; i++)
        {
            if (hash.table.keys[i] != null)
            {
                System.out.println("Index: " + i + " -> Key: " + hash.table.keys[i] + " Value: " + hash.table.values[i]);
            }
        }
        System.out.println("Size: " + hash.table.size);
        System.out.println("Capacity: " + hash.table.capacity);
    }
}
