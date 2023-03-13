import Tables.*;
import Tests.*;
import Trees.*;
import Prints.*;
import java.util.*;

public class TEST
{
    public static void tester()
    {
        Runtime runtime;
        long startTime;
        long endTime;
        long memory;
        boolean test = true;
        int num; //number of numbers to be inserted
        int capacity;
        Scanner inp = new Scanner(System.in);
        System.out.print("Enter number of numbers to be inserted: ");
        num = inp.nextInt();
        Scanner in = new Scanner(System.in);
        System.out.print("Enter capacity: ");
        capacity = in.nextInt();

        AvlTree avl = new AvlTree();
        SplayTree splay = new SplayTree();
        HashTableLinear hash = new HashTableLinear(capacity);
        HashTableChaining hashChaining = new HashTableChaining(capacity);
        AvlTest.AvlTreeChecker avlChecker = new AvlTest.AvlTreeChecker();
        SplayTest.SplayTreeChecker splayChecker = new SplayTest.SplayTreeChecker();
        HashLinearTest.HashTableLinearChecker hashChecker = new HashLinearTest.HashTableLinearChecker(capacity);

        String alphabet = "abcdefghijklmnopqrstuvwxyz0123456789"; //alphabet for random letters

        int[] data = new int[num]; //number of numbers to be inserted
        String[] key = new String[num]; //number of numbers to be inserted
        int[] value = new int[num]; //number of numbers to be inserted

        //fill arrays with random numbers
        for (int i = 0; i < num; i++)
        {
            data[i] = new Random().nextInt(1_000_000);
            value[i] = new Random().nextInt(1_000_000);
        }
        for (int i = 0; i < num; i++)
        {
            for (int j = 0; j < 5; j++)
            {
                key[i] += alphabet.charAt((int) Math.floor((Math.random() * alphabet.length()))); //random letters for key
            }
        }
        for (int i = 0; i< num; i++)
        {
            avl.root = avl.insert(avl.root, data[i]);
            splay.root = splay.insert(splay.root, data[i]);
            hash.put(key[i], value[i]);
            hashChaining.put(key[i], value[i]);
        }

        System.out.println("========================================");
        System.out.println("\033[0;34m" + "TESTS" + "\033[0m");
        System.out.println("1. SPLAY");
        System.out.println("2. AVL");
        System.out.println("3. HASH LINEAR");
        System.out.println("4. HASH CHAINING");
        System.out.println("5. AVL PRINT");
        System.out.println("6. SPLAY PRINT");
        System.out.println("7. HASH LINEAR PRINT");
        System.out.println("8. HASH CHAINING PRINT");
        System.out.println("9. EXIT");
        System.out.println("========================================");

        while(test)
        {
            System.out.print("Enter number of test: ");
            Scanner input = new Scanner(System.in);
            switch (input.nextInt())
            {
                //SPlAY
                case 1 ->
                {
                    System.out.println("\033[0;34m" + "SPLAY" + "\033[0m");
                    System.out.println("1. INSERT");
                    System.out.println("2. SEARCH");
                    System.out.println("3. DELETE");

                    boolean type = true;
                    while(type)
                    {
                        System.out.print("Enter type of test: ");
                        Scanner input2 = new Scanner(System.in);
                        switch (input2.nextInt())
                        {
                            //SPLAY INSERT
                            case 1 ->
                            {
                                System.out.println("    \033[0;35m" + "Insert" + "\033[0m");
                                System.out.print("    Enter number to be inserted: ");
                                Scanner input3 = new Scanner(System.in);
                                int insert = input3.nextInt();
                                runtime = Runtime.getRuntime();
                                startTime = System.nanoTime();
                                splay.root = splay.insert(splay.root, insert);
                                endTime = System.nanoTime();
                                memory = runtime.totalMemory() - runtime.freeMemory();
                                System.out.println("    Time(insert): " + (endTime - startTime) + " ns");
                                System.out.println("    Memory(insert): " + memory/1024 + " kb");
                                if (splayChecker.isSplayTree(splay.root))
                                {
                                    System.out.println("    \033[0;32m" + "PASSED" + "\033[0m");
                                }
                                else
                                {
                                    System.out.println("    \033[0;31m" + "FAILED" + "\033[0m");
                                }
                                System.out.println("    ----------------------------------------");
                            }
                            //SPLAY SEARCH
                            case 2 ->
                            {
                                System.out.println("    \033[0;35m" + "Search" + "\033[0m");
                                System.out.print("    Enter number to be searched: ");
                                Scanner input3 = new Scanner(System.in);
                                int search = input3.nextInt();
                                runtime = Runtime.getRuntime();
                                startTime = System.nanoTime();
                                splay.root = splay.search(splay.root, search);
                                endTime = System.nanoTime();
                                memory = runtime.totalMemory() - runtime.freeMemory();
                                System.out.println("    Time(search): " + (endTime - startTime) + " ns");
                                System.out.println("    Memory(search): " + memory/1024 + " kb");
                                if(splay.search(splay.root, search) != null && splay.search(splay.root, search).data == search)
                                {
                                    System.out.println("    \033[0;32m" + "FOUND" + "\033[0m");
                                }
                                else
                                {
                                    System.out.println("    \033[0;31m" + "NOT FOUND" + "\033[0m");
                                }
                                System.out.println("    ----------------------------------------");
                            }
                            //SPLAY DELETE
                            case 3 ->
                            {
                                System.out.println("    \033[0;35m" + "Delete" + "\033[0m");
                                System.out.print("    Enter number to be deleted: ");
                                Scanner input3 = new Scanner(System.in);
                                int delete = input3.nextInt();
                                runtime = Runtime.getRuntime();
                                startTime = System.nanoTime();
                                splay.root = splay.delete(splay.root, delete);
                                endTime = System.nanoTime();
                                memory = runtime.totalMemory() - runtime.freeMemory();
                                System.out.println("    Time(delete): " + (endTime - startTime) + " ns");
                                System.out.println("    Memory(delete): " + memory/1024 + " kb");
                                if (splayChecker.isSplayTree(splay.root))
                                {
                                    System.out.println("    \033[0;32m" + "PASSED" + "\033[0m");
                                }
                                else
                                {
                                    System.out.println("    \033[0;31m" + "FAILED" + "\033[0m");
                                }
                                System.out.println("    ----------------------------------------");
                            }
                            default ->
                            {
                                type = false;
                                test = false;
                                System.out.println("\033[0;37mTest ended \033[0m");
                            }
                        }
                    }
                    System.out.println("=========================================");
                }
                //AVL
                case 2 ->
                {
                    System.out.println("\033[0;34m" + "AVL" + "\033[0m");
                    System.out.println("1. INSERT");
                    System.out.println("2. SEARCH");
                    System.out.println("3. DELETE");

                    boolean type = true;
                    while(type)
                    {
                        System.out.print("\033[0;33m" + "Enter type of test: " + "\033[0m");
                        Scanner input2 = new Scanner(System.in);
                        switch (input2.nextInt())
                        {
                            //AVL INSERT
                            case 1 ->
                            {
                                System.out.println("    \033[0;35m" + "Insert" + "\033[0m");
                                System.out.print("    Enter number to be inserted: ");
                                Scanner input3 = new Scanner(System.in);
                                int insert = input3.nextInt();
                                runtime = Runtime.getRuntime();
                                startTime = System.nanoTime();
                                avl.root = avl.insert(avl.root, insert);
                                endTime = System.nanoTime();
                                memory = runtime.totalMemory() - runtime.freeMemory();
                                System.out.println("    Time(insert): " + (endTime - startTime) + " ns");
                                System.out.println("    Memory(insert): " + memory/1024 + " kb");
                                if (avlChecker.isBalanced(avl.root))
                                {
                                    System.out.println("    \033[0;32m" + "PASSED" + "\033[0m");
                                }
                                else
                                {
                                    System.out.println("    \033[0;31m" + "FAILED" + "\033[0m");
                                }
                                System.out.println("    ----------------------------------------");
                            }
                            //AVL SEARCH
                            case 2 ->
                            {
                                System.out.println("    \033[0;35m" + "Search" + "\033[0m");
                                System.out.print("    Enter number to be searched: ");
                                Scanner input3 = new Scanner(System.in);
                                int search = input3.nextInt();
                                runtime = Runtime.getRuntime();
                                startTime = System.nanoTime();
                                avl.search(avl.root, search);
                                endTime = System.nanoTime();
                                memory = runtime.totalMemory() - runtime.freeMemory();
                                System.out.println("    Time(search): " + (endTime - startTime) + " ns");
                                System.out.println("    Memory(search): " + memory/1024 + " kb");
                                if(avl.search(avl.root, search) != null && avl.search(avl.root, search).data == search)
                                {
                                    System.out.println("    \033[0;32m" + "FOUND" + "\033[0m");
                                }
                                else
                                {
                                    System.out.println("    \033[0;31m" + "NOT FOUND" + "\033[0m");
                                }
                                System.out.println("    ----------------------------------------");
                            }
                            //AVL DELETE
                            case 3 ->
                            {
                                System.out.println("    \033[0;35m" + "Delete" + "\033[0m");
                                System.out.print("    Enter number to be deleted: ");
                                Scanner input3 = new Scanner(System.in);
                                int delete = input3.nextInt();
                                runtime = Runtime.getRuntime();
                                startTime = System.nanoTime();
                                avl.root = avl.delete(avl.root, delete);
                                endTime = System.nanoTime();
                                memory = runtime.totalMemory() - runtime.freeMemory();
                                System.out.println("    Time(delete): " + (endTime - startTime) + " ns");
                                System.out.println("    Memory(delete): " + memory/1024 + " kb");
                                if (avlChecker.isBalanced(avl.root))
                                {
                                    System.out.println("    \033[0;32m" + "PASSED" + "\033[0m");
                                }
                                else
                                {
                                    System.out.println("    \033[0;31m" + "FAILED" + "\033[0m");
                                }
                                System.out.println("    ----------------------------------------");
                            }
                            default ->
                            {
                                type = false;
                                test = false;
                                System.out.println("\033[0;37mTest ended \033[0m");
                            }
                        }
                    }
                    System.out.println("=========================================");
                }
                //HASH LINEAR
                case 3 ->
                {
                    System.out.println("\033[0;34m" + "HASH LINEAR" + "\033[0m");
                    System.out.println("1. INSERT");
                    System.out.println("2. SEARCH");
                    System.out.println("3. DELETE");

                    boolean type = true;
                    while(type)
                    {
                        System.out.print("\033[0;33m" + "Enter type of test: " + "\033[0m");
                        Scanner input2 = new Scanner(System.in);
                        switch (input2.nextInt())
                        {
                            //HASH LINEAR INSERT
                            case 1 ->
                            {
                                System.out.println("    \033[0;35m" + "Insert" + "\033[0m");
                                System.out.print("    Enter string to be inserted: ");
                                Scanner input4 = new Scanner(System.in);
                                String insert1 = input4.nextLine();
                                System.out.print("    Enter number to be inserted: ");
                                Scanner input3 = new Scanner(System.in);
                                int insert = input3.nextInt();
                                runtime = Runtime.getRuntime();
                                startTime = System.nanoTime();
                                hash.put(insert1, insert);
                                endTime = System.nanoTime();
                                memory = runtime.totalMemory() - runtime.freeMemory();
                                System.out.println("    Time(insert): " + (endTime - startTime) + " ns");
                                System.out.println("    Memory(insert): " + memory/1024 + " kb");
                                System.out.println("    Index: " + hash.hash(insert1));
                                if(hashChecker.isCollision())
                                {
                                    System.out.println("    \033[0;32m" + "PASSED" + "\033[0m");
                                }
                                else
                                {
                                    System.out.println("    \033[0;31m" + "FAILED" + "\033[0m");
                                }
                                System.out.println("    ----------------------------------------");
                            }
                            //HASH LINEAR SEARCH
                            case 2 ->
                            {
                                System.out.println("    \033[0;35m" + "Search" + "\033[0m");
                                System.out.print("    Enter string to be searched: ");
                                Scanner input3 = new Scanner(System.in);
                                String search = input3.nextLine();
                                runtime = Runtime.getRuntime();
                                startTime = System.nanoTime();
                                hash.get(search);
                                endTime = System.nanoTime();
                                memory = runtime.totalMemory() - runtime.freeMemory();
                                System.out.println("    Time(search): " + (endTime - startTime) + " ns");
                                System.out.println("    Memory(search): " + memory/1024 + " kb");
                                if(hash.get(search))
                                {
                                    System.out.println("    \033[0;32m" + "FOUND" + "\033[0m");
                                }
                                else
                                {
                                    System.out.println("    \033[0;31m" + "NOT FOUND" + "\033[0m");
                                }
                                System.out.println("    ----------------------------------------");
                            }
                            //HASH LINEAR DELETE
                            case 3 ->
                            {
                                System.out.println("    \033[0;35m" + "Delete" + "\033[0m");
                                System.out.print("    Enter number to be deleted: ");
                                Scanner input3 = new Scanner(System.in);
                                String search = input3.nextLine();
                                runtime = Runtime.getRuntime();
                                startTime = System.nanoTime();
                                hash.remove(search);
                                endTime = System.nanoTime();
                                memory = runtime.totalMemory() - runtime.freeMemory();
                                System.out.println("    Time(delete): " + (endTime - startTime) + " ns");
                                System.out.println("    Memory(delete): " + memory/1024 + " kb");
                                if(hashChecker.isCollision())
                                {
                                    System.out.println("    \033[0;32m" + "PASSED" + "\033[0m");
                                }
                                else
                                {
                                    System.out.println("    \033[0;31m" + "FAILED" + "\033[0m");
                                }
                                System.out.println("    ----------------------------------------");
                            }
                            default ->
                            {
                                type = false;
                                test = false;
                                System.out.println("\033[0;37mTest ended \033[0m");
                            }
                        }
                    }
                    System.out.println("=========================================");
                }
                //HASH CHAINING
                case 4 ->
                {
                    System.out.println("\033[0;34m" + "HASH CHAINING" + "\033[0m");
                    System.out.println("1. INSERT");
                    System.out.println("2. SEARCH");
                    System.out.println("3. DELETE");

                    boolean type = true;
                    while(type)
                    {
                        System.out.print("\033[0;33m" + "Enter type of test: " + "\033[0m");
                        Scanner input2 = new Scanner(System.in);
                        switch (input2.nextInt())
                        {
                            //HASH CHAINING INSERT
                            case 1 ->
                            {
                                System.out.println("    \033[0;35m" + "Insert" + "\033[0m");
                                System.out.print("    Enter string to be inserted: ");
                                Scanner input4 = new Scanner(System.in);
                                String insert1 = input4.nextLine();
                                System.out.print("\n    Enter number to be inserted: ");
                                Scanner input3 = new Scanner(System.in);
                                int insert = input3.nextInt();
                                runtime = Runtime.getRuntime();
                                startTime = System.nanoTime();
                                hashChaining.put(insert1, insert);
                                endTime = System.nanoTime();
                                memory = runtime.totalMemory() - runtime.freeMemory();
                                System.out.println("    Time(insert): " + (endTime - startTime) + " ns");
                                System.out.println("    Memory(insert): " + memory/1024 + " kb");
                                System.out.println("    Index: " + hashChaining.hash(insert1));
                                System.out.println("    ----------------------------------------");
                            }
                            //HASH CHAINING SEARCH
                            case 2 ->
                            {
                                System.out.println("    \033[0;35m" + "Search" + "\033[0m");
                                System.out.print("    Enter string to be searched: ");
                                Scanner input3 = new Scanner(System.in);
                                String search = input3.nextLine();
                                runtime = Runtime.getRuntime();
                                startTime = System.nanoTime();
                                hashChaining.get(search);
                                endTime = System.nanoTime();
                                memory = runtime.totalMemory() - runtime.freeMemory();
                                System.out.println("    Time(search): " + (endTime - startTime) + " ns");
                                System.out.println("    Memory(search): " + memory/1024 + " kb");
                                if(hashChaining.get(search))
                                {
                                    System.out.println("    \033[0;32m" + "FOUND" + "\033[0m");
                                }
                                else
                                {
                                    System.out.println("    \033[0;31m" + "NOT FOUND" + "\033[0m");
                                }
                                System.out.println("    ----------------------------------------");
                            }
                            //HASH CHAINING DELETE
                            case 3 ->
                            {
                                System.out.println("    \033[0;35m" + "Delete" + "\033[0m");
                                System.out.print("  Enter number to be deleted: ");
                                Scanner input3 = new Scanner(System.in);
                                String search = input3.nextLine();
                                runtime = Runtime.getRuntime();
                                startTime = System.nanoTime();
                                hashChaining.remove(search);
                                endTime = System.nanoTime();
                                memory = runtime.totalMemory() - runtime.freeMemory();
                                System.out.println("    Time(delete): " + (endTime - startTime) + " ns");
                                System.out.println("    Memory(delete): " + memory/1024 + " kb");
                                System.out.println("    ----------------------------------------");
                            }
                            default ->
                            {
                                type = false;
                                test = false;
                                System.out.println("\033[0;37mTest ended \033[0m");
                            }
                        }
                    }
                    System.out.println("=========================================");
                }
                //Avl print
                case 5 -> AvlPrint.print();
                //Splay print
                case 6 -> SplayPrint.print();
                //Hashtable linear print
                case 7 -> HashTableLinearPrint.print();
                //Hashtable chaining print
                case 8 -> HashTableChainingPrint.print();
                //Exit
                case 9 ->
                {
                    test = false;
                    System.out.println("\033[0;37mTest ended \033[0m");
                }
                default -> System.out.println("Invalid input");
            }
        }
    }
}