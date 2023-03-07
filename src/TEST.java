import Tables.HashTableLinearProbing;
import Tests.AvlTest;
import Tests.SplayTest;
import Trees.AvlTree;
import Trees.SplayTree;

import java.util.*;

public class TEST
{
    public static void tester()
    {
        AvlTree avl = new AvlTree();
        SplayTree splay = new SplayTree();
        SplayTest.SplayTreeChecker splayTreeChecker = new SplayTest.SplayTreeChecker();
        AvlTest.AvlTreeChecker avlTreeChecker = new AvlTest.AvlTreeChecker();
        HashTableLinearProbing hash = new HashTableLinearProbing();

        Runtime runtime;
        long startTime;
        long endTime;
        long memory;
        int a = 0; //TEST NUMBER COUNTER
        boolean test = true;
        int num = 10_000_000; //number of numbers to be inserted
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
            for (int j = 0; j < 2; j++)
            {
                key[i] += (char) (new Random().nextInt(26) + 'a'); //random letters for key
            }
        }
        System.out.println("\033[0;34m" + "TESTS" + "\033[0m");
        System.out.println("1. SPLAY");
        System.out.println("2. AVL");
        System.out.println("3. HASH TABLE");
        System.out.println("4. EXIT");

        while(test)
        {
            Scanner input = new Scanner(System.in);
            switch (input.nextInt()) {
                //SPLAY
                //insert
                case 1 ->
                {
                    System.out.println("\033[0;34m" + "SPLAY (Insert)" + "\033[0m");
                    for (int i = 0; i < 1; i++) //number of tests
                    {
                        runtime = Runtime.getRuntime(); //get runtime instance to get memory usage
                        startTime = System.currentTimeMillis(); //get start time of test
                        for (int x = 0; x < num; x++) //number of numbers
                        {
                            splay.root = splay.insert(splay.root, data[x]); //insert numbers
                        }
                        a++;
                        endTime = System.currentTimeMillis(); //get end time of test
                        runtime.gc(); //garbage collector to get memory usage
                        memory = runtime.totalMemory() - runtime.freeMemory(); //get memory usage

                        System.out.println("\033[0;36m" + "TEST " + a + "\033[0m");
                        System.out.println("TIME: " + (endTime - startTime) + " ms");
                        System.out.println("MEMORY: " + memory / 1024 + " KB");
                        if (splayTreeChecker.isSplayTree(splay.root)) //check if tree is splay tree
                        {
                            System.out.println("TEST: " + "\033[0;31m" + "FAILED" + "\033[0m");
                        } else {
                            System.out.println("TEST: " + "\033[0;32m" + "PASSED" + "\033[0m");
                        }
                    }
                    //insert and search
                    System.out.println("\033[0;34m" + "SPLAY (Insert + Search)" + "\033[0m");
                    a = 0;
                    for (int i = 0; i < 1; i++) {
                        runtime = Runtime.getRuntime();
                        startTime = System.currentTimeMillis();

                        for (int x = 0; x < num; x++) //number of numbers
                        {
                            splay.root = splay.insert(splay.root, data[x]); //insert numbers
                        }
                        for (int x = 0; x < num; x++) //number of numbers
                        {
                            splay.root = splay.search(splay.root, data[x]);
                        }

                        a++;
                        endTime = System.currentTimeMillis();
                        runtime.gc();
                        memory = runtime.totalMemory() - runtime.freeMemory();

                        System.out.println("\033[0;36m" + "TEST " + a + "\033[0m");
                        System.out.println("TIME: " + (endTime - startTime) + " ms");
                        System.out.println("MEMORY: " + memory / 1024 + " KB");
                        if (splayTreeChecker.isSplayTree(splay.root)) {
                            System.out.println("TEST: " + "\033[0;31m" + "FAILED" + "\033[0m");
                        } else {
                            System.out.println("TEST: " + "\033[0;32m" + "PASSED" + "\033[0m");
                        }
                    }
                    //insert and delete
                    System.out.println("\033[0;34m" + "SPLAY (Insert + Delete)" + "\033[0m");
                    a = 0;
                    for (int i = 0; i < 1; i++) {
                        runtime = Runtime.getRuntime();
                        startTime = System.currentTimeMillis();
                        for (int x = 0; x < num; x++) //number of numbers
                        {
                            splay.root = splay.insert(splay.root, data[x]); //insert numbers
                        }
                        for (int x = 0; x < num; x++) //number of numbers
                        {
                            splay.root = splay.delete(splay.root, data[x]);
                        }
                        a++;
                        endTime = System.currentTimeMillis();
                        runtime.gc();
                        memory = runtime.totalMemory() - runtime.freeMemory();

                        System.out.println("\033[0;36m" + "TEST " + a + "\033[0m");
                        System.out.println("TIME: " + (endTime - startTime) + " ms");
                        System.out.println("MEMORY: " + memory / 1024 + " KB");
                        if (splayTreeChecker.isSplayTree(splay.root)) {
                            System.out.println("TEST: " + "\033[0;31m" + "FAILED" + "\033[0m");
                        } else {
                            System.out.println("TEST: " + "\033[0;32m" + "PASSED" + "\033[0m");
                        }
                    }

                    //insert, search and delete
                    System.out.println("\033[0;34m" + "SPLAY (Insert + Search + Delete)" + "\033[0m");
                    a = 0;
                    for (int i = 0; i < 1; i++) {
                        runtime = Runtime.getRuntime();
                        startTime = System.currentTimeMillis();
                        for (int x = 0; x < num; x++) //number of numbers
                        {
                            splay.root = splay.insert(splay.root, data[x]); //insert numbers
                        }
                        for (int x = 0; x < num; x++) //number of numbers
                        {
                            splay.root = splay.search(splay.root, data[x]);
                        }
                        for (int x = 0; x < num; x++) //number of numbers
                        {
                            splay.root = splay.delete(splay.root, data[x]);
                        }
                        a++;
                        endTime = System.currentTimeMillis();
                        runtime.gc();
                        memory = runtime.totalMemory() - runtime.freeMemory();

                        System.out.println("\033[0;36m" + "TEST " + a + "\033[0m");
                        System.out.println("TIME: " + (endTime - startTime) + " ms");
                        System.out.println("MEMORY: " + memory / 1024 + " KB");
                        if (splayTreeChecker.isSplayTree(splay.root)) {
                            System.out.println("TEST: " + "\033[0;31m" + "FAILED" + "\033[0m");
                        } else {
                            System.out.println("TEST: " + "\033[0;32m" + "PASSED" + "\033[0m");
                        }
                    }
                    System.out.println("---------------------------------");
                }
                case 2 ->
                {
                    //AVL
                    //insert
                    System.out.println("\033[0;34m" + "AVL (Insert)" + "\033[0m");
                    a = 0;
                    for (int i = 0; i < 1; i++) {
                        runtime = Runtime.getRuntime();
                        startTime = System.currentTimeMillis();

                        for (int x = 0; x < num; x++) //number of numbers
                        {
                            avl.root = avl.insert(avl.root, data[x]); //insert numbers
                        }
                        a++;
                        endTime = System.currentTimeMillis();
                        runtime.gc();
                        memory = runtime.totalMemory() - runtime.freeMemory();

                        System.out.println("\033[0;36m" + "TEST " + a + "\033[0m");
                        System.out.println("TIME: " + (endTime - startTime) + " ms");
                        System.out.println("MEMORY: " + memory / 1024 + " KB");
                        if (!avlTreeChecker.isBalanced(avl.root)) {
                            System.out.println("TEST: " + "\033[0;31m" + "FAILED" + "\033[0m");
                        } else {
                            System.out.println("TEST: " + "\033[0;32m" + "PASSED" + "\033[0m");
                        }
                    }
                    //insert and search
                    System.out.println("\033[0;34m" + "AVL (Insert + Search)" + "\033[0m");
                    a = 0;
                    for (int i = 0; i < 1; i++) {
                        runtime = Runtime.getRuntime();
                        startTime = System.currentTimeMillis();
                        for (int x = 0; x < num; x++) //number of numbers
                        {
                            avl.root = avl.insert(avl.root, data[x]); //insert numbers
                        }
                        for (int x = 0; x < num; x++) //number of numbers
                        {
                            avl.root = avl.search(avl.root, data[x]);
                        }
                        a++;
                        endTime = System.currentTimeMillis();
                        runtime.gc();
                        memory = runtime.totalMemory() - runtime.freeMemory();

                        System.out.println("\033[0;36m" + "TEST " + a + "\033[0m");
                        System.out.println("TIME: " + (endTime - startTime) + " ms");
                        System.out.println("MEMORY: " + memory / 1024 + " KB");
                        if (!avlTreeChecker.isBalanced(avl.root)) {
                            System.out.println("TEST: " + "\033[0;31m" + "FAILED" + "\033[0m");
                        } else {
                            System.out.println("TEST: " + "\033[0;32m" + "PASSED" + "\033[0m");
                        }
                    }
                    //insert and delete
                    System.out.println("\033[0;34m" + "AVL (Insert + Delete)" + "\033[0m");
                    a = 0;
                    for (int i = 0; i < 1; i++) {
                        runtime = Runtime.getRuntime();
                        startTime = System.currentTimeMillis();
                        for (int x = 0; x < num; x++) //number of numbers
                        {
                            avl.root = avl.insert(avl.root, data[x]); //insert numbers
                        }
                        for (int x = 0; x < num; x++) //number of numbers
                        {
                            avl.root = avl.delete(avl.root, data[x]);
                        }

                        a++;
                        endTime = System.currentTimeMillis();
                        runtime.gc();
                        memory = runtime.totalMemory() - runtime.freeMemory();

                        System.out.println("\033[0;36m" + "TEST " + a + "\033[0m");
                        System.out.println("TIME: " + (endTime - startTime) + " ms");
                        System.out.println("MEMORY: " + memory / 1024 + " KB");
                        if (!avlTreeChecker.isBalanced(avl.root)) {
                            System.out.println("TEST: " + "\033[0;31m" + "FAILED" + "\033[0m");
                        } else {
                            System.out.println("TEST: " + "\033[0;32m" + "PASSED" + "\033[0m");
                        }
                    }
                    //insert, search and delete
                    System.out.println("\033[0;34m" + "AVL (Insert + Search + Delete)" + "\033[0m");
                    a = 0;
                    for (int i = 0; i < 1; i++) {
                        startTime = System.currentTimeMillis();
                        runtime = Runtime.getRuntime();
                        for (int x = 0; x < num; x++) //number of numbers
                        {
                            avl.root = avl.insert(avl.root, data[x]); //insert numbers
                        }
                        for (int x = 0; x < num; x++) //number of numbers
                        {
                            avl.root = avl.search(avl.root, data[x]);
                        }
                        for (int x = 0; x < num; x++) //number of numbers
                        {
                            avl.root = avl.delete(avl.root, data[x]);
                        }
                        a++;
                        endTime = System.currentTimeMillis();
                        runtime.gc();
                        memory = runtime.totalMemory() - runtime.freeMemory();

                        System.out.println("\033[0;36m" + "TEST " + a + "\033[0m");
                        System.out.println("TIME: " + (endTime - startTime) + " ms");
                        System.out.println("MEMORY: " + memory / 1024 + " KB");
                        if (!avlTreeChecker.isBalanced(avl.root)) {
                            System.out.println("TEST: " + "\033[0;31m" + "FAILED" + "\033[0m");
                        } else {
                            System.out.println("TEST: " + "\033[0;32m" + "PASSED" + "\033[0m");
                        }
                    }
                    System.out.println("---------------------------------");
                }
                case 3 ->
                {
                    //Hashtable open addressing linear probing
                    System.out.println("\033[0;34m" + "Hashtable Open Addressing Linear Probing (Insert)" + "\033[0m");
                    a = 0;
                    for (int i = 0; i < 1; i++) {
                        runtime = Runtime.getRuntime();
                        startTime = System.currentTimeMillis();
                        for (int x = 0; x < num; x++) //number of numbers
                        {
                            hash.put(key[x], value[x]); //insert numbers
                        }
                        a++;
                        endTime = System.currentTimeMillis();
                        runtime.gc();
                        memory = runtime.totalMemory() - runtime.freeMemory();

                        System.out.println("\033[0;36m" + "TEST " + a + "\033[0m");
                        System.out.println("TIME: " + (endTime - startTime) + " ms");
                        System.out.println("MEMORY: " + memory / 1024 + " KB");
                    }
                }
                case 4 ->
                {
                    test = false;
                    System.out.println("\033[0;37mTest ended \033[0m");
                }
                default -> System.out.println("Invalid input");
            }
        }
    }
}