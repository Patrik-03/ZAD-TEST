import Tests.AvlTest;
import Tests.SplayTest;
import Trees.AvlTree;
import Trees.SplayTree;
import java.util.Random;

public class TEST
{
    public static void tester()
    {
        AvlTree avl = new AvlTree();
        SplayTree splay = new SplayTree();
        SplayTest.SplayTreeChecker splayTreeChecker = new SplayTest.SplayTreeChecker();
        AvlTest.AvlTreeChecker avlTreeChecker = new AvlTest.AvlTreeChecker();
        Runtime runtime;
        long startTime;
        long endTime;
        long memory;
        int a = 0; //TEST NUMBER COUNTER
        //SPLAY
        //insert
        System.out.println("\033[0;34m" + "SPLAY (Insert)" + "\033[0m");
        for (int i = 0; i < 1; i++) //number of tests
        {
            runtime = Runtime.getRuntime(); //get runtime instance to get memory usage
            startTime = System.currentTimeMillis(); //get start time of test
            for (int x = 0; x < 10_000_000; x++) //number of numbers
            {
                int data = new Random().nextInt(1_000_000); //random number in range
                splay.root = splay.insert(splay.root, data); //insert random number
            }
            a++;
            endTime = System.currentTimeMillis(); //get end time of test
            runtime.gc(); //garbage collector to get memory usage
            memory = runtime.totalMemory() - runtime.freeMemory(); //get memory usage

            System.out.println("\033[0;36m" + "TEST " + a + "\033[0m");
            System.out.println("TIME: " + (endTime - startTime) / 1000 + " s");
            System.out.println("MEMORY: " + memory / 1024 + " KB");
            if (splayTreeChecker.isSplayTree(splay.root)) //check if tree is splay tree
            {
                System.out.println("TEST: " + "\033[0;31m" + "FAILED" + "\033[0m");
            }
            else
            {
                System.out.println("TEST: " + "\033[0;32m" + "PASSED" + "\033[0m");
            }
        }
        //insert and search
        System.out.println("\033[0;34m" + "SPLAY (Insert + Search)" + "\033[0m");
        a = 0;
        for (int i = 0; i < 1; i++)
        {
            runtime = Runtime.getRuntime();
            startTime = System.currentTimeMillis();
            for (int x = 0; x < 10_000_000; x++)
            {
                int data = new Random().nextInt(1_000_000);
                splay.root = splay.insert(splay.root, data);
            }
            for (int x = 0; x < 10_000_000; x++)
            {
                int data = new Random().nextInt(1_000_000);
                splay.root = splay.search(splay.root, data);
            }
            a++;
            endTime = System.currentTimeMillis();
            runtime.gc();
            memory = runtime.totalMemory() - runtime.freeMemory();

            System.out.println("\033[0;36m" + "TEST " + a + "\033[0m");
            System.out.println("TIME: " + (endTime - startTime)/1_000 + " s");
            System.out.println("MEMORY: " + memory/1024 + " KB");
            if (splayTreeChecker.isSplayTree(splay.root))
            {
                System.out.println("TEST: " + "\033[0;31m" + "FAILED" + "\033[0m");
            }
            else
            {
                System.out.println("TEST: " + "\033[0;32m" + "PASSED" + "\033[0m");
            }
        }
        //insert and delete
        System.out.println("\033[0;34m" + "SPLAY (Insert + Delete)" + "\033[0m");
        a = 0;
        for (int i = 0; i < 1; i++)
        {
            runtime = Runtime.getRuntime();
            startTime = System.currentTimeMillis();
            for (int x = 0; x < 10_000_000; x++)
            {
                int data = new Random().nextInt(1_000_000);
                splay.root = splay.insert(splay.root, data);
            }
            for (int x = 0; x < 10_000_000; x++)
            {
                int data = new Random().nextInt(1_000_000);
                splay.root = splay.delete(splay.root, data);
            }
            a++;
            endTime = System.currentTimeMillis();
            runtime.gc();
            memory = runtime.totalMemory() - runtime.freeMemory();

            System.out.println("\033[0;36m" + "TEST " + a + "\033[0m");
            System.out.println("TIME: " + (endTime - startTime)/1_000 + " s");
            System.out.println("MEMORY: " + memory/1024 + " KB");
            if (splayTreeChecker.isSplayTree(splay.root))
            {
                System.out.println("TEST: " + "\033[0;31m" + "FAILED" + "\033[0m");
            }
            else
            {
                System.out.println("TEST: " + "\033[0;32m" + "PASSED" + "\033[0m");
            }
        }

        //insert, search and delete
        System.out.println("\033[0;34m" + "SPLAY (Insert + Search + Delete)" + "\033[0m");
        a = 0;
        for (int i = 0; i < 1; i++)
        {
            runtime = Runtime.getRuntime();
            startTime = System.currentTimeMillis();
            for (int x = 0; x < 10_000_000; x++)
            {
                int data = new Random().nextInt(1_000_000);
                splay.root = splay.insert(splay.root, data);
            }
            for (int x = 0; x < 10_000_000; x++)
            {
                int data = new Random().nextInt(1_000_000);
                splay.root = splay.search(splay.root, data);
            }
            for (int x = 0; x < 10_000_000; x++)
            {
                int data = new Random().nextInt(1_000_000);
                splay.root = splay.delete(splay.root, data);
            }
            a++;
            endTime = System.currentTimeMillis();
            runtime.gc();
            memory = runtime.totalMemory() - runtime.freeMemory();

            System.out.println("\033[0;36m" + "TEST " + a + "\033[0m");
            System.out.println("TIME: " + (endTime - startTime)/1_000 + " s");
            System.out.println("MEMORY: " + memory/1024 + " KB");
            if (splayTreeChecker.isSplayTree(splay.root))
            {
                System.out.println("TEST: " + "\033[0;31m" + "FAILED" + "\033[0m");
            }
            else
            {
                System.out.println("TEST: " + "\033[0;32m" + "PASSED" + "\033[0m");
            }
        }
        System.out.println("---------------------------------");
        //AVL
        //insert
        System.out.println("\033[0;34m" + "AVL (Insert)" + "\033[0m");
        a = 0;
        for (int i = 0; i < 1; i++)
        {
            runtime = Runtime.getRuntime();
            startTime = System.currentTimeMillis();
            for (int x = 0; x < 10_000_000; x++)
            {
                int data = new Random().nextInt(1_000_000);
                avl.root = avl.insert(avl.root, data);
            }
            a++;
            endTime = System.currentTimeMillis();
            runtime.gc();
            memory = runtime.totalMemory() - runtime.freeMemory();

            System.out.println("\033[0;36m" + "TEST " + a + "\033[0m");
            System.out.println("TIME: " + (endTime - startTime)/1_000 + " s");
            System.out.println("MEMORY: " + memory/1024 + " KB");
            if (!avlTreeChecker.isBalanced(avl.root))
            {
                System.out.println("TEST: " + "\033[0;31m" + "FAILED" + "\033[0m");
            }
            else
            {
                System.out.println("TEST: " + "\033[0;32m" + "PASSED" + "\033[0m");
            }
        }
        //insert and search
        System.out.println("\033[0;34m" + "AVL (Insert + Search)" + "\033[0m");
        a = 0;
        for (int i = 0; i < 1; i++)
        {
            runtime = Runtime.getRuntime();
            startTime = System.currentTimeMillis();
            for (int x = 0; x < 10_000_000; x++)
            {
                int data = new Random().nextInt(1_000_000);
                avl.root = avl.insert(avl.root, data);
            }
            for (int x = 0; x < 10_000_000; x++)
            {
                int data = new Random().nextInt(1_000_000);
                avl.root = avl.search(avl.root, data);
            }
            a++;
            endTime = System.currentTimeMillis();
            runtime.gc();
            memory = runtime.totalMemory() - runtime.freeMemory();

            System.out.println("\033[0;36m" + "TEST " + a + "\033[0m");
            System.out.println("TIME: " + (endTime - startTime)/1_000 + " s");
            System.out.println("MEMORY: " + memory/1024 + " KB");
            if (!avlTreeChecker.isBalanced(avl.root))
            {
                System.out.println("TEST: " + "\033[0;31m" + "FAILED" + "\033[0m");
            }
            else
            {
                System.out.println("TEST: " + "\033[0;32m" + "PASSED" + "\033[0m");
            }
        }
        //insert and delete
        System.out.println("\033[0;34m" + "AVL (Insert + Delete)" + "\033[0m");
        a = 0;
        for (int i = 0; i < 1; i++)
        {
            runtime = Runtime.getRuntime();
            startTime = System.currentTimeMillis();
            for (int x = 0; x < 10_000_000; x++)
            {
                int data = new Random().nextInt(1_000_000);
                avl.root = avl.insert(avl.root, data);
            }
            for (int x = 0; x < 10_000_000; x++)
            {
                int data = new Random().nextInt(1_000_000);
                avl.root = avl.delete(avl.root, data);
            }
            a++;
            endTime = System.currentTimeMillis();
            runtime.gc();
            memory = runtime.totalMemory() - runtime.freeMemory();

            System.out.println("\033[0;36m" + "TEST " + a + "\033[0m");
            System.out.println("TIME: " + (endTime - startTime)/1_000 + " s");
            System.out.println("MEMORY: " + memory/1024 + " KB");
            if (!avlTreeChecker.isBalanced(avl.root))
            {
                System.out.println("TEST: " + "\033[0;31m" + "FAILED" + "\033[0m");
            }
            else
            {
                System.out.println("TEST: " + "\033[0;32m" + "PASSED" + "\033[0m");
            }
        }
        //insert, search and delete
        System.out.println("\033[0;34m" + "AVL (Insert + Search + Delete)" + "\033[0m");
        a = 0;
        for (int i = 0; i < 1; i++)
        {
            startTime = System.currentTimeMillis();
            runtime = Runtime.getRuntime();
            for (int x = 0; x < 10_000_000; x++)
            {
                int data = new Random().nextInt(1_000_000);
                avl.root = avl.insert(avl.root, data);
            }
            for (int x = 0; x < 10_000_000; x++)
            {
                int data = new Random().nextInt(1_000_000);
                avl.root = avl.search(avl.root, data);
            }
            for (int x = 0; x < 10_000_000; x++)
            {
                int data = new Random().nextInt(1_000_000);
                avl.root = avl.delete(avl.root, data);
            }
            a++;
            endTime = System.currentTimeMillis();
            runtime.gc();
            memory = runtime.totalMemory() - runtime.freeMemory();

            System.out.println("\033[0;36m" + "TEST " + a + "\033[0m");
            System.out.println("TIME: " + (endTime - startTime)/1_000 + " s");
            System.out.println("MEMORY: " + memory/1024 + " KB");
            if (!avlTreeChecker.isBalanced(avl.root))
            {
                System.out.println("TEST: " + "\033[0;31m" + "FAILED" + "\033[0m");
            }
            else
            {
                System.out.println("TEST: " + "\033[0;32m" + "PASSED" + "\033[0m");
            }
        }
        System.out.println("---------------------------------");
    }
}
