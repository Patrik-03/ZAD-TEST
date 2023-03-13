package Prints;
import Base.HashChaining;
import Tables.HashTableChaining;

public class HashTableChainingPrint
{
    public static void print()
    {
        int capacity = 10; // capacity of hash table
        int hashSize = 0; // size of hash table
        HashTableChaining hash = new HashTableChaining(capacity); // initialize hash table

        hash.put("Matej", 11); // add entries to hash table
        hash.put("Kiko", 12); // add entries to hash table
        hash.put("a", 13); // add entries to hash table
        hash.put("b", 14); // add entries to hash table
        hash.put("c", 15); // add entries to hash table
        hash.put("d", 16); // add entries to hash table

        for (int i = 0; i < capacity; i++) // print hash table
        {
            System.out.print("\nIndex "+ i +" : "); // print index
            HashChaining entry = hash.table[i]; // set entry to first node
            while (entry != null) // while entry is not null
            {
                System.out.print(entry.key + " = " + entry.value +" | "); // print key and value
                entry = entry.next; // set entry to next node
                hashSize++; // increment hash size
            }
        }
        System.out.println("\n");
        System.out.println("SIZE: " + hashSize);
        System.out.println("CAPACITY: " + capacity);
    }
}
