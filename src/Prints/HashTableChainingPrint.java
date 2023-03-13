package Prints;
import Base.HashChaining;
import Tables.HashTableChaining;

public class HashTableChainingPrint
{
    public static void print() {
        int capacity = 10;
        int hashSize = 0;
        HashTableChaining hash = new HashTableChaining(capacity);

        hash.put("Matej", 11);
        hash.put("Kiko", 12);
        hash.put("a", 13);
        hash.put("b", 14);
        hash.put("c", 15);
        hash.put("d", 16);

        for (int i = 0; i < capacity; i++)
        {
            System.out.print("\nIndex "+ i +" : ");
            HashChaining entry = hash.table[i];
            while (entry != null)
            {
                System.out.print(entry.key + " = " + entry.value +" | ");
                entry = entry.next;
                hashSize++;
            }
        }
        System.out.println("\n");
        System.out.println("SIZE: " + hashSize);
        System.out.println("CAPACITY: " + capacity);
    }
}
