package Tests;
import Tables.HashTableLinear;
public class HashLinearTest
{
    public static class HashTableLinearChecker
    {
        public HashTableLinear hash; // hash table
        public HashTableLinearChecker(int capacity) // constructor for HashTableLinearChecker class
        {
            hash = new HashTableLinear(capacity); // initialize hash table
        }
        public boolean isCollision() // check for collisions
        {
            for (int i = 0; i < hash.table.capacity; i++) // for each index in table
            {
                if (hash.table.keys[i] != null) // if keys are not null
                {
                    for (int j = i + 1; j < hash.table.capacity; j++) // check for collisions
                    {
                        if (hash.table.keys[j] != null) // if keys are not null
                        {
                            if (hash.table.keys[i].equals(hash.table.keys[j])) // if keys are equal
                            {
                                if(i == j) // if keys are in same index
                                {
                                    return false; // collision
                                }
                            }
                        }
                    }
                }
            }
            return true; // no collision
        }
    }
}
