package Prints;
import Tables.HashLinear;

public class HashLinearPrint
{
    public static void print()
    {
        HashLinear hashTable = new HashLinear();
        hashTable.insert("a", 1);
        hashTable.insert("b", 2);
        hashTable.insert("c", 3);
        hashTable.insert("d", 4);
        hashTable.insert("e", 5);
        hashTable.insert("f", 6);
        hashTable.insert("g", 7);
        hashTable.insert("h", 8);
        hashTable.insert("i", 9);
        hashTable.insert("j", 10);
        hashTable.insert("k", 11);
        hashTable.insert("l", 12);
        hashTable.insert("m", 13);
        hashTable.insert("n", 14);
        hashTable.insert("o", 15);
        hashTable.insert("p", 16);
        hashTable.insert("q", 17);
        hashTable.insert("r", 18);
        
        System.out.println("Hash Table: ");
        for (int i = 0; i < hashTable.table.capacity; i++)
        {
               System.out.println("Index: " + i + " Key: " + hashTable.table.keys[i] + " Value: " + hashTable.table.values[i]);
        }
        System.out.println("Hash Table Capacity: " + hashTable.table.capacity);
        System.out.println("Hash Table Size: " + hashTable.table.size);
    }
}
