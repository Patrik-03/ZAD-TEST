package Tests;
import Tables.HashTableLinear;
public class HashLinearTest
{
    public static class HashTableLinearChecker
    {
        public HashTableLinear hash;
        public HashTableLinearChecker(int capacity)
        {
            hash = new HashTableLinear(capacity);
        }
        public boolean isCollision()
        {
            for (int i = 0; i < hash.table.capacity; i++)
            {
                if (hash.table.keys[i] != null)
                {
                    for (int j = i + 1; j < hash.table.capacity; j++)
                    {
                        if (hash.table.keys[j] != null)
                        {
                            if (hash.table.keys[i].equals(hash.table.keys[j]))
                            {
                                if(i == j)
                                {
                                    return false;
                                }
                            }
                        }
                    }
                }
            }
            return true;
        }

    }
}
