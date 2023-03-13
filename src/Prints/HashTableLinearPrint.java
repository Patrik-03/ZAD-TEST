package Prints;
import Tables.HashTableLinear;
public class HashTableLinearPrint
{
    public static void print()
    {
        HashTableLinear hash = new HashTableLinear();

        hash.put("Matej", 11);
        hash.put("Kiko", 12);
        hash.put("a", 13);
        hash.put("b", 14);
        hash.put("c", 15);
        hash.put("d", 16);

        //print keys with values and index
        for (int i = 0; i < hash.table.capacity; i++)
        {
            if (hash.table.keys[i] != null)
            {
                System.out.println("Index: " + i + " -> Key: " + hash.table.keys[i] + " Value: " + hash.table.values[i]);
            }
        }
        System.out.println("\n");
        System.out.println("Size: " + hash.table.size);
        System.out.println("Capacity: " + hash.table.capacity);
    }
}
