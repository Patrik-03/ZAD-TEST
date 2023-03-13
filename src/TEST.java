import Tables.*;
import Tests.*;
import Trees.*;
import Prints.*;
import java.util.*;

public class TEST
{
    public static void tester()
    {
        Runtime runtime; //runtime
        long startTime; //time
        long endTime; //time
        long memory; //memory used
        boolean test = true; //set to false to skip tests
        int num; //number of numbers to be inserted
        int capacity; //capacity of hash table

        Scanner inp = new Scanner(System.in);
        System.out.print("Enter number of numbers to be inserted: ");
        num = inp.nextInt();
        Scanner in = new Scanner(System.in);
        System.out.print("Enter capacity: ");
        capacity = in.nextInt();

        AvlTree avl = new AvlTree(); //create new avl tree
        SplayTree splay = new SplayTree(); //create new splay tree
        HashTableLinear hash = new HashTableLinear(capacity); //create new hash table
        HashTableChaining hashChaining = new HashTableChaining(capacity); //create new hash table
        AvlTest.AvlTreeChecker avlChecker = new AvlTest.AvlTreeChecker(); //create new avl tree checker
        SplayTest.SplayTreeChecker splayChecker = new SplayTest.SplayTreeChecker(); //create new splay tree checker
        HashLinearTest.HashTableLinearChecker hashChecker = new HashLinearTest.HashTableLinearChecker(capacity); //create new hash table checker

        String alphabet = "abcdefghijklmnopqrstuvwxyz0123456789"; //alphabet for random letters

        int[] data = new int[num]; //number of numbers to be inserted
        String[] key = new String[num]; //number of numbers to be inserted
        int[] value = new int[num]; //number of numbers to be inserted

        for (int i = 0; i < num; i++) //fill arrays with random numbers
        {
            data[i] = new Random().nextInt(1_000_000); //random numbers for data
            value[i] = new Random().nextInt(1_000_000); //random numbers for value
        }
        for (int i = 0; i < num; i++) //fill arrays with random letters
        {
            for (int j = 0; j < 15; j++) //random letters for key with length 15
            {
                key[i] += alphabet.charAt((int) Math.floor((Math.random() * alphabet.length()))); //random letters for key
            }
        }
        for (int i = 0; i< num; i++) //insert numbers into trees and hash tables
        {
            avl.root = avl.insert(avl.root, data[i]); //insert numbers into avl tree
            splay.root = splay.insert(splay.root, data[i]); //insert numbers into splay tree
            hash.put(key[i], value[i]); //insert numbers and words into hash table
            hashChaining.put(key[i], value[i]); //insert numbers and words into hash table
        }

        System.out.println("========================================");
        System.out.println("\033[0;34m" + "TESTS" + "\033[0m");
        System.out.println("1. SPLAY");
        System.out.println("2. AVL");
        System.out.println("3. HASH LINEAR");
        System.out.println("4. HASH CHAINING");
        System.out.println("5. COMPARISON");
        System.out.println("6. PRINT");
        System.out.println("7. EXIT");
        System.out.println("========================================");

        while(test) //test loop
        {
            System.out.print("Enter type of Data structure: ");
            Scanner input = new Scanner(System.in); //data structure
            switch (input.nextInt())
            {
                //SPLAY
                case 1 ->
                {
                    System.out.println("    \033[0;34m" + "SPLAY" + "\033[0m");
                    System.out.println("    1. INSERT");
                    System.out.println("    2. SEARCH");
                    System.out.println("    3. DELETE");

                    boolean type = true;
                    while(type)
                    {
                        System.out.print("    \033[0;33m" + "Enter type of test: " + "\033[0m");
                        Scanner input2 = new Scanner(System.in); //type of test
                        switch (input2.nextInt())
                        {
                            //SPLAY INSERT
                            case 1 ->
                            {
                                System.out.println("    \033[0;35m" + "Insert" + "\033[0m");
                                System.out.print("    Enter number to be inserted: ");
                                Scanner input3 = new Scanner(System.in); //number to be inserted
                                int insert = input3.nextInt(); //number to be inserted
                                runtime = Runtime.getRuntime(); //runtime for memory
                                startTime = System.nanoTime(); //start time
                                splay.root = splay.insert(splay.root, insert); //insert number into splay tree
                                endTime = System.nanoTime(); //end time
                                runtime.gc(); //garbage collector
                                memory = runtime.totalMemory() - runtime.freeMemory(); //memory used
                                System.out.println("    Time(insert): " + (endTime - startTime) + " ns");
                                System.out.println("    Memory(insert): " + memory/1024 + " kb");
                                if (splayChecker.isSplayTree(splay.root)) //check if splay tree is valid
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
                                Scanner input3 = new Scanner(System.in); //number to be searched
                                int search = input3.nextInt(); //number to be searched
                                runtime = Runtime.getRuntime(); //runtime for memory
                                startTime = System.nanoTime(); //start time
                                splay.root = splay.search(splay.root, search); //search number in splay tree
                                endTime = System.nanoTime(); //end time
                                runtime.gc(); //garbage collector
                                memory = runtime.totalMemory() - runtime.freeMemory(); //memory used
                                System.out.println("    Time(search): " + (endTime - startTime) + " ns");
                                System.out.println("    Memory(search): " + memory/1024 + " kb");
                                if(splay.search(splay.root, search) != null && splay.search(splay.root, search).data == search) //check if number is found
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
                                Scanner input3 = new Scanner(System.in); //number to be deleted
                                int delete = input3.nextInt(); //number to be deleted
                                runtime = Runtime.getRuntime(); //runtime for memory
                                startTime = System.nanoTime(); //start time
                                splay.root = splay.delete(splay.root, delete); //delete number from splay tree
                                endTime = System.nanoTime(); //end time
                                runtime.gc(); //garbage collector
                                memory = runtime.totalMemory() - runtime.freeMemory(); //memory used
                                System.out.println("    Time(delete): " + (endTime - startTime) + " ns");
                                System.out.println("    Memory(delete): " + memory/1024 + " kb");
                                if (splayChecker.isSplayTree(splay.root)) //check if splay tree is valid
                                {
                                    System.out.println("    \033[0;32m" + "PASSED" + "\033[0m");
                                }
                                else
                                {
                                    System.out.println("    \033[0;31m" + "FAILED" + "\033[0m");
                                }
                                System.out.println("    ----------------------------------------");
                            }
                            //step back
                            case 7 -> type = false;
                            default -> System.out.println("    \033[0;31m" + "INVALID INPUT" + "\033[0m");
                        }
                    }
                    System.out.println("=========================================");
                }
                //AVL
                case 2 ->
                {
                    System.out.println("    \033[0;34m" + "AVL" + "\033[0m");
                    System.out.println("    1. INSERT");
                    System.out.println("    2. SEARCH");
                    System.out.println("    3. DELETE");

                    boolean type = true;
                    while(type)
                    {
                        System.out.print("    \033[0;33m" + "Enter type of test: " + "\033[0m");
                        Scanner input2 = new Scanner(System.in); //type of test
                        switch (input2.nextInt())
                        {
                            //AVL INSERT
                            case 1 ->
                            {
                                System.out.println("    \033[0;35m" + "Insert" + "\033[0m");
                                System.out.print("    Enter number to be inserted: ");
                                Scanner input3 = new Scanner(System.in); //number to be inserted
                                int insert = input3.nextInt(); //number to be inserted
                                runtime = Runtime.getRuntime(); //runtime for memory
                                startTime = System.nanoTime(); //start time
                                avl.root = avl.insert(avl.root, insert); //insert number into avl tree
                                endTime = System.nanoTime(); //end time
                                runtime.gc(); //garbage collector
                                memory = runtime.totalMemory() - runtime.freeMemory(); //memory used
                                System.out.println("    Time(insert): " + (endTime - startTime) + " ns");
                                System.out.println("    Memory(insert): " + memory/1024 + " kb");
                                if (avlChecker.isBalanced(avl.root)) //check if avl tree is valid
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
                                Scanner input3 = new Scanner(System.in); //number to be searched
                                int search = input3.nextInt(); //number to be searched
                                runtime = Runtime.getRuntime(); //runtime for memory
                                startTime = System.nanoTime(); //start time
                                avl.search(avl.root, search); //search number in avl tree
                                endTime = System.nanoTime(); //end time
                                runtime.gc(); //garbage collector
                                memory = runtime.totalMemory() - runtime.freeMemory(); //memory used
                                System.out.println("    Time(search): " + (endTime - startTime) + " ns");
                                System.out.println("    Memory(search): " + memory/1024 + " kb");
                                if(avl.search(avl.root, search) != null && avl.search(avl.root, search).data == search) //check if number is found
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
                                Scanner input3 = new Scanner(System.in); //number to be deleted
                                int delete = input3.nextInt(); //number to be deleted
                                runtime = Runtime.getRuntime(); //runtime for memory
                                startTime = System.nanoTime(); //start time
                                avl.root = avl.delete(avl.root, delete); //delete number from avl tree
                                endTime = System.nanoTime(); //end time
                                runtime.gc(); //garbage collector
                                memory = runtime.totalMemory() - runtime.freeMemory(); //memory used
                                System.out.println("    Time(delete): " + (endTime - startTime) + " ns");
                                System.out.println("    Memory(delete): " + memory/1024 + " kb");
                                if (avlChecker.isBalanced(avl.root)) //check if avl tree is valid
                                {
                                    System.out.println("    \033[0;32m" + "PASSED" + "\033[0m");
                                }
                                else
                                {
                                    System.out.println("    \033[0;31m" + "FAILED" + "\033[0m");
                                }
                                System.out.println("    ----------------------------------------");
                            }
                            //step back
                            case 7 -> type = false;
                            default -> System.out.println("    \033[0;31m" + "INVALID INPUT" + "\033[0m");
                        }
                    }
                    System.out.println("=========================================");
                }
                //HASH LINEAR
                case 3 ->
                {
                    System.out.println("    \033[0;34m" + "HASH LINEAR" + "\033[0m");
                    System.out.println("    1. INSERT");
                    System.out.println("    2. SEARCH");
                    System.out.println("    3. DELETE");

                    boolean type = true;
                    while(type)
                    {
                        System.out.print("    \033[0;33m" + "Enter type of test: " + "\033[0m");
                        Scanner input2 = new Scanner(System.in); //type of test
                        switch (input2.nextInt())
                        {
                            //HASH LINEAR INSERT
                            case 1 ->
                            {
                                System.out.println("    \033[0;35m" + "Insert" + "\033[0m");
                                System.out.print("    Enter string to be inserted: ");
                                Scanner input4 = new Scanner(System.in); //string to be inserted
                                String insert1 = input4.nextLine(); //string to be inserted
                                System.out.print("    Enter number to be inserted: ");
                                Scanner input3 = new Scanner(System.in); //number to be inserted
                                int insert = input3.nextInt(); //number to be inserted
                                runtime = Runtime.getRuntime(); //runtime for memory
                                startTime = System.nanoTime(); //start time
                                hash.put(insert1, insert); //insert string and number into hash table
                                endTime = System.nanoTime(); //end time
                                runtime.gc(); //garbage collector
                                memory = runtime.totalMemory() - runtime.freeMemory(); //memory used
                                System.out.println("    Time(insert): " + (endTime - startTime) + " ns");
                                System.out.println("    Memory(insert): " + memory/1024 + " kb");
                                System.out.println("    Index: " + hash.hash(insert1));
                                if(hashChecker.isCollision()) //check if hash table is valid
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
                                Scanner input3 = new Scanner(System.in); //string to be searched
                                String search = input3.nextLine(); //string to be searched
                                runtime = Runtime.getRuntime(); //runtime for memory
                                startTime = System.nanoTime(); //start time
                                hash.get(search); //search string in hash table
                                endTime = System.nanoTime(); //end time
                                runtime.gc(); //garbage collector
                                memory = runtime.totalMemory() - runtime.freeMemory(); //memory used
                                System.out.println("    Time(search): " + (endTime - startTime) + " ns");
                                System.out.println("    Memory(search): " + memory/1024 + " kb");
                                if(hash.get(search)) //check if string is found
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
                                Scanner input3 = new Scanner(System.in); //number to be deleted
                                String search = input3.nextLine(); //number to be deleted
                                runtime = Runtime.getRuntime(); //runtime for memory
                                startTime = System.nanoTime(); //start time
                                hash.remove(search); //delete number from hash table
                                endTime = System.nanoTime(); //end time
                                runtime.gc(); //garbage collector
                                memory = runtime.totalMemory() - runtime.freeMemory(); //memory used
                                System.out.println("    Time(delete): " + (endTime - startTime) + " ns");
                                System.out.println("    Memory(delete): " + memory/1024 + " kb");
                                if(hashChecker.isCollision()) //check if hash table is valid
                                {
                                    System.out.println("    \033[0;32m" + "PASSED" + "\033[0m");
                                }
                                else
                                {
                                    System.out.println("    \033[0;31m" + "FAILED" + "\033[0m");
                                }
                                System.out.println("    ----------------------------------------");
                            }
                            //step back
                            case 7 -> type = false;
                            default -> System.out.println("    \033[0;31m" + "INVALID INPUT" + "\033[0m");
                        }
                    }
                    System.out.println("=========================================");
                }
                //HASH CHAINING
                case 4 ->
                {
                    System.out.println("    \033[0;34m" + "HASH CHAINING" + "\033[0m");
                    System.out.println("    1. INSERT");
                    System.out.println("    2. SEARCH");
                    System.out.println("    3. DELETE");

                    boolean type = true;
                    while(type)
                    {
                        System.out.print("    \033[0;33m" + "Enter type of test: " + "\033[0m");
                        Scanner input2 = new Scanner(System.in); //type of test
                        switch (input2.nextInt())
                        {
                            //HASH CHAINING INSERT
                            case 1 ->
                            {
                                System.out.println("    \033[0;35m" + "Insert" + "\033[0m");
                                System.out.print("    Enter string to be inserted: ");
                                Scanner input4 = new Scanner(System.in); //string to be inserted
                                String insert1 = input4.nextLine(); //string to be inserted
                                System.out.print("\n    Enter number to be inserted: ");
                                Scanner input3 = new Scanner(System.in); //number to be inserted
                                int insert = input3.nextInt(); //number to be inserted
                                runtime = Runtime.getRuntime(); //runtime for memory
                                startTime = System.nanoTime(); //start time
                                hashChaining.put(insert1, insert); //insert string and number into hash table
                                endTime = System.nanoTime(); //end time
                                runtime.gc(); //garbage collector
                                memory = runtime.totalMemory() - runtime.freeMemory(); //memory used
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
                                Scanner input3 = new Scanner(System.in); //string to be searched
                                String search = input3.nextLine(); //string to be searched
                                runtime = Runtime.getRuntime(); //runtime for memory
                                startTime = System.nanoTime(); //start time
                                hashChaining.get(search); //search string in hash table
                                endTime = System.nanoTime(); //end time
                                runtime.gc(); //garbage collector
                                memory = runtime.totalMemory() - runtime.freeMemory(); //memory used
                                System.out.println("    Time(search): " + (endTime - startTime) + " ns");
                                System.out.println("    Memory(search): " + memory/1024 + " kb");
                                if(hashChaining.get(search)) //check if string is found
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
                                Scanner input3 = new Scanner(System.in); //number to be deleted
                                String search = input3.nextLine(); //number to be deleted
                                runtime = Runtime.getRuntime(); //runtime for memory
                                startTime = System.nanoTime(); //start time
                                hashChaining.remove(search); //delete number from hash table
                                endTime = System.nanoTime(); //end time
                                runtime.gc();
                                memory = runtime.totalMemory() - runtime.freeMemory(); //memory used
                                System.out.println("    Time(delete): " + (endTime - startTime) + " ns");
                                System.out.println("    Memory(delete): " + memory/1024 + " kb");
                                System.out.println("    ----------------------------------------");
                            }
                            //step back
                            case 7 -> type = false;
                            default -> System.out.println("    \033[0;31m" + "INVALID INPUT" + "\033[0m");

                        }
                    }
                    System.out.println("=========================================");
                }
                //COMPARISON
                case 5 ->
                {
                    System.out.println("    \033[0;34m" + "COMPARISON" + "\033[0m");
                    System.out.println("    1. TREES");
                    System.out.println("    2. HASH TABLES");

                    boolean type = true;
                    while(type)
                    {
                        System.out.print("    \033[0;33m" + "Enter type of comparison: " + "\033[0m");
                        Scanner input2 = new Scanner(System.in); //type of comparison
                        switch (input2.nextInt())
                        {
                            //TREES
                            case 1 ->
                            {
                                System.out.println("        \033[0;36m" + "TREES" + "\033[0m");
                                System.out.println("        1. INSERT");
                                System.out.println("        2. SEARCH");
                                System.out.println("        3. DELETE");

                                boolean type2 = true;

                                while (type2)
                                {
                                    System.out.print("        \033[0;33m" + "Enter type of comparison: " + "\033[0m");
                                    Scanner input3 = new Scanner(System.in); //type of comparison
                                    switch (input3.nextInt())
                                    {
                                        //insert
                                        case 1 ->
                                        {
                                            //AVL INSERT
                                            System.out.println("        \033[0;35m" + "Insert" + "\033[0m");
                                            System.out.print("        Enter number to be inserted: ");
                                            Scanner input4 = new Scanner(System.in); //number to be inserted
                                            int insert = input4.nextInt(); //number to be inserted
                                            runtime = Runtime.getRuntime(); //runtime for memory
                                            startTime = System.nanoTime(); //start time
                                            avl.root = avl.insert(avl.root, insert); //insert string and number into avl tree
                                            endTime = System.nanoTime(); //end time
                                            runtime.gc(); //garbage collector
                                            memory = runtime.totalMemory() - runtime.freeMemory(); //memory used
                                            System.out.println("        Time(insert avl): " + (endTime - startTime) + " ns");
                                            System.out.println("        Memory(insert avl): " + memory/1024 + " kb");
                                            if (avlChecker.isBalanced(avl.root)) //check if avl tree is valid
                                            {
                                                System.out.println("        \033[0;32m" + "PASSED" + "\033[0m");
                                            }
                                            else
                                            {
                                                System.out.println("        \033[0;31m" + "FAILED" + "\033[0m");
                                            }
                                            System.out.println("        ----------------------------------------");

                                            //SPLAY INSERT
                                            runtime = Runtime.getRuntime(); //runtime for memory
                                            startTime = System.nanoTime(); //start time
                                            splay.root = splay.insert(splay.root, insert); //insert string and number into splay tree
                                            endTime = System.nanoTime(); //end time
                                            runtime.gc(); //garbage collector
                                            memory = runtime.totalMemory() - runtime.freeMemory(); //memory used
                                            System.out.println("        Time(insert splay): " + (endTime - startTime) + " ns");
                                            System.out.println("        Memory(insert splay): " + memory/1024 + " kb");
                                            if (splayChecker.isSplayTree(splay.root)) //check if splay tree is valid
                                            {
                                                System.out.println("        \033[0;32m" + "PASSED" + "\033[0m");
                                            }
                                            else
                                            {
                                                System.out.println("        \033[0;31m" + "FAILED" + "\033[0m");
                                            }
                                            System.out.println("        ----------------------------------------");
                                        }
                                        //search
                                        case 2 ->
                                        {
                                            //AVL SEARCH
                                            System.out.println("        \033[0;35m" + "Search" + "\033[0m");
                                            System.out.print("        Enter number to be searched: ");
                                            Scanner input4 = new Scanner(System.in); //number to be searched
                                            int search = input4.nextInt(); //number to be searched
                                            runtime = Runtime.getRuntime(); //runtime for memory
                                            startTime = System.nanoTime(); //start time
                                            avl.root = avl.search(avl.root, search); //search number in avl tree
                                            endTime = System.nanoTime(); //end time
                                            runtime.gc(); //garbage collector
                                            memory = runtime.totalMemory() - runtime.freeMemory(); //memory used
                                            System.out.println("        Time(search avl): " + (endTime - startTime) + " ns");
                                            System.out.println("        Memory(search avl): " + memory / 1024 + " kb");
                                            if(avl.search(avl.root, search) != null && avl.search(avl.root, search).data == search) //check if number is found
                                            {
                                                System.out.println("        \033[0;32m" + "FOUND" + "\033[0m");
                                            }
                                            else
                                            {
                                                System.out.println("        \033[0;31m" + "NOT FOUND" + "\033[0m");
                                            }
                                            System.out.println("        ----------------------------------------");

                                            //SPLAY SEARCH
                                            runtime = Runtime.getRuntime(); //runtime for memory
                                            startTime = System.nanoTime(); //start time
                                            splay.root = splay.search(splay.root, search); //search number in splay tree
                                            endTime = System.nanoTime(); //end time
                                            runtime.gc(); //garbage collector
                                            memory = runtime.totalMemory() - runtime.freeMemory(); //memory used
                                            System.out.println("        Time(search splay): " + (endTime - startTime) + " ns");
                                            System.out.println("        Memory(search splay): " + memory / 1024 + " kb");
                                            if(splay.search(splay.root, search) != null && splay.search(splay.root, search).data == search) //check if number is found
                                            {
                                                System.out.println("        \033[0;32m" + "FOUND" + "\033[0m");
                                            }
                                            else
                                            {
                                                System.out.println("        \033[0;31m" + "NOT FOUND" + "\033[0m");
                                            }
                                            System.out.println("        ----------------------------------------");
                                        }
                                        //delete
                                        case 3 ->
                                        {
                                            //AVL DELETE
                                            System.out.println("        \033[0;35m" + "Delete" + "\033[0m");
                                            System.out.print("        Enter number to be deleted: ");
                                            Scanner input4 = new Scanner(System.in); //number to be deleted
                                            int delete = input4.nextInt(); //number to be deleted
                                            runtime = Runtime.getRuntime(); //runtime for memory
                                            startTime = System.nanoTime(); //start time
                                            avl.root = avl.delete(avl.root, delete); //delete number in avl tree
                                            endTime = System.nanoTime(); //end time
                                            runtime.gc(); //garbage collector
                                            memory = runtime.totalMemory() - runtime.freeMemory(); //memory used
                                            System.out.println("        Time(delete avl): " + (endTime - startTime) + " ns");
                                            System.out.println("        Memory(delete avl): " + memory / 1024 + " kb");
                                            if(avl.search(avl.root, delete) == null) //check if number is deleted
                                            {
                                                System.out.println("        \033[0;32m" + "PASSED" + "\033[0m");
                                            }
                                            else
                                            {
                                                System.out.println("        \033[0;31m" + "FAILED" + "\033[0m");
                                            }
                                            System.out.println("        ----------------------------------------");

                                            //SPLAY DELETE
                                            runtime = Runtime.getRuntime(); //runtime for memory
                                            startTime = System.nanoTime(); //start time
                                            splay.root = splay.delete(splay.root, delete); //delete number in splay tree
                                            endTime = System.nanoTime(); //end time
                                            runtime.gc(); //garbage collector
                                            memory = runtime.totalMemory() - runtime.freeMemory(); //memory used
                                            System.out.println("        Time(delete splay): " + (endTime - startTime) + " ns");
                                            System.out.println("        Memory(delete splay): " + memory / 1024 + " kb");
                                            if(splay.search(splay.root, delete) == null) //check if number is deleted
                                            {
                                                System.out.println("        \033[0;32m" + "PASSED" + "\033[0m");
                                            }
                                            else
                                            {
                                                System.out.println("        \033[0;31m" + "FAILED" + "\033[0m");
                                            }
                                            System.out.println("        ----------------------------------------");
                                        }
                                        //step back
                                        case 7 -> type2 = false;
                                        default -> System.out.println("        \033[0;31m" + "INVALID INPUT" + "\033[0m");
                                    }
                                }
                            }
                            //HASH TABLES
                            case 2 ->
                            {
                                System.out.println("        \033[0;36m" + "HASH TABLES" + "\033[0m");
                                System.out.println("        1. INSERT");
                                System.out.println("        2. SEARCH");
                                System.out.println("        3. DELETE");

                                boolean type2 = true;

                                while (type2)
                                {
                                    System.out.print("        \033[0;33m" + "Enter type of operation: " + "\033[0m");
                                    Scanner input3 = new Scanner(System.in); //type of operation

                                    switch (input3.nextInt())
                                    {
                                        //insert
                                        case 1 ->
                                        {
                                            //HASH LINEAR INSERT
                                            System.out.println("        \033[0;35m" + "Insert" + "\033[0m");
                                            System.out.print("        Enter string to be inserted: ");
                                            Scanner input4 = new Scanner(System.in); //string to be inserted
                                            String insert = input4.nextLine(); //string to be inserted
                                            System.out.print("        Enter number to be inserted: ");
                                            Scanner input5 = new Scanner(System.in); //number to be inserted
                                            int insert2 = input5.nextInt(); //number to be inserted
                                            runtime = Runtime.getRuntime(); //runtime for memory
                                            startTime = System.nanoTime(); //start time
                                            hash.put(insert, insert2); //insert string and number in hash table
                                            endTime = System.nanoTime(); //end time
                                            runtime.gc(); //garbage collector
                                            memory = runtime.totalMemory() - runtime.freeMemory(); //memory used
                                            System.out.println("        Time(insert hash): " + (endTime - startTime) + " ns");
                                            System.out.println("        Memory(insert hash): " + memory / 1024 + " kb");
                                            if(hashChecker.isCollision()) //check if hash table is valid
                                            {
                                                System.out.println("        \033[0;32m" + "PASSED" + "\033[0m");
                                            }
                                            else
                                            {
                                                System.out.println("        \033[0;31m" + "FAILED" + "\033[0m");
                                            }
                                            System.out.println("        ----------------------------------------");

                                            //HASH CHAINING INSERT
                                            runtime = Runtime.getRuntime(); //runtime for memory
                                            startTime = System.nanoTime();
                                            hashChaining.put(insert, insert2); //insert string and number in hash table
                                            endTime = System.nanoTime(); //end time
                                            runtime.gc(); //garbage collector
                                            memory = runtime.totalMemory() - runtime.freeMemory(); //memory used
                                            System.out.println("        Time(insert hash chaining): " + (endTime - startTime) + " ns");
                                            System.out.println("        Memory(insert hash chaining): " + memory / 1024 + " kb");
                                            System.out.println("        ----------------------------------------");
                                        }
                                        //search string in hash table
                                        case 2 ->
                                        {
                                            //HASH LINEAR SEARCH
                                            System.out.println("        \033[0;35m" + "Search" + "\033[0m");
                                            System.out.print("        Enter string to be searched: ");
                                            Scanner input4 = new Scanner(System.in); //string to be searched
                                            String search = input4.nextLine(); //string to be searched
                                            runtime = Runtime.getRuntime(); //runtime for memory
                                            startTime = System.nanoTime(); //start time
                                            hash.get(search); //search string in hash table
                                            endTime = System.nanoTime(); //end time
                                            runtime.gc(); //garbage collector
                                            memory = runtime.totalMemory() - runtime.freeMemory(); //memory used
                                            System.out.println("        Time(search hash): " + (endTime - startTime) + " ns");
                                            System.out.println("        Memory(search hash): " + memory / 1024 + " kb");
                                            if(hash.get(search)) //check if string is found
                                            {
                                                System.out.println("        \033[0;32m" + "FOUND" + "\033[0m");
                                            }
                                            else
                                            {
                                                System.out.println("        \033[0;31m" + "NOT FOUND" + "\033[0m");
                                            }
                                            System.out.println("        ----------------------------------------");

                                            //HASH CHAINING SEARCH
                                            runtime = Runtime.getRuntime(); //runtime for memory
                                            startTime = System.nanoTime();
                                            hashChaining.get(search); //search string in hash table
                                            endTime = System.nanoTime(); //end time
                                            runtime.gc(); //garbage collector
                                            memory = runtime.totalMemory() - runtime.freeMemory(); //memory used
                                            System.out.println("        Time(search hash chaining): " + (endTime - startTime) + " ns");
                                            System.out.println("        Memory(search hash chaining): " + memory / 1024 + " kb");
                                            if (hashChaining.get(search)) //check if string is found
                                            {
                                                System.out.println("        \033[0;32m" + "FOUND" + "\033[0m");
                                            }
                                            else
                                            {
                                                System.out.println("            \033[0;31m" + "NOT FOUND" + "\033[0m");
                                            }
                                            System.out.println("            ----------------------------------------");
                                        }
                                        //delete string in hash table
                                        case 3 ->
                                        {
                                            //HASH LINEAR DELETE
                                            System.out.println("        \033[0;35m" + "Delete" + "\033[0m");
                                            System.out.print("         Enter string to be deleted: ");
                                            Scanner input4 = new Scanner(System.in); //string to be deleted
                                            String delete = input4.nextLine(); //string to be deleted
                                            runtime = Runtime.getRuntime(); //runtime for memory
                                            startTime = System.nanoTime(); //start time
                                            hash.remove(delete); //delete string in hash table
                                            endTime = System.nanoTime(); //end time
                                            runtime.gc(); //garbage collector
                                            memory = runtime.totalMemory() - runtime.freeMemory(); //memory used
                                            System.out.println("        Time(delete hash): " + (endTime - startTime) + " ns");
                                            System.out.println("        Memory(delete hash): " + memory / 1024 + " kb");
                                            if(hashChecker.isCollision()) //check if hash table is valid
                                            {
                                                System.out.println("        \033[0;32m" + "PASSED" + "\033[0m");
                                            }
                                            else
                                            {
                                                System.out.println("        \033[0;31m" + "FAILED" + "\033[0m");
                                            }
                                            System.out.println("        ----------------------------------------");

                                            //HASH CHAINING DELETE
                                            runtime = Runtime.getRuntime(); //runtime for memory
                                            startTime = System.nanoTime();
                                            hashChaining.remove(delete); //delete string in hash table
                                            endTime = System.nanoTime(); //end time
                                            runtime.gc(); //garbage collector
                                            memory = runtime.totalMemory() - runtime.freeMemory(); //memory used
                                            System.out.println("        Time(delete hash chaining): " + (endTime - startTime) + " ns");
                                            System.out.println("        Memory(delete hash chaining): " + memory / 1024 + " kb");
                                            System.out.println("        ----------------------------------------");
                                        }
                                        //step back
                                        case 7 -> type2 = false;
                                        default -> System.out.println("        \033[0;31m" + "Invalid input" + "\033[0m");
                                    }
                                }
                            }
                            //step back
                            case 7 -> type = false;
                            default -> System.out.println("    \033[0;31m" + "Invalid input" + "\033[0m");
                        }
                    }
                    System.out.println("=========================================");
                }
                //PRINT
                case 6 ->
                {
                    System.out.println("    \033[0;34m" + "PRINT" + "\033[0m");
                    System.out.println("    1. AVL");
                    System.out.println("    2. SPLAY");
                    System.out.println("    3. HASH LINEAR");
                    System.out.println("    4. HASH CHAINING");

                    boolean type = true;
                    while(type)
                    {
                        System.out.print("    \033[0;33m" + "Enter type of print: " + "\033[0m");
                        Scanner input2 = new Scanner(System.in); //type of print
                        switch (input2.nextInt())
                        {
                            case 1 -> AvlPrint.print(); //print avl tree with preorder traversal
                            case 2 -> SplayPrint.print(); //print splay tree with preorder traversal
                            case 3 -> HashTableLinearPrint.print(); //print hash table with linear probing
                            case 4 -> HashTableChainingPrint.print(); //print hash table with chaining
                            case 7 -> type = false;
                            default -> System.out.println("    \033[0;31m" + "Invalid input" + "\033[0m");
                        }
                    }
                    System.out.println("=========================================");
                }
                //Exit
                case 7 ->
                {
                    test = false;
                    System.out.println("\033[0;37mTest ended \033[0m");
                }
                default -> System.out.println("\033[0;31m" + "INVALID INPUT" + "\033[0m"); //invalid input
            }
        }
    }
}