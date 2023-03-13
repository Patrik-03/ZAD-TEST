package Prints;
import Trees.SplayTree;

public class SplayPrint
{
    public static void print()
    {
        System.out.print("Splay Tree preorder traversal: ");
        SplayTree splay = new SplayTree(); //initialize splay tree
        splay.root = splay.insert(splay.root, 10);
        splay.root = splay.insert(splay.root, 52);
        splay.root = splay.insert(splay.root, 3);
        splay.root = splay.insert(splay.root, 14);
        splay.root = splay.insert(splay.root, 86);
        splay.root = splay.insert(splay.root, 7);
        splay.root = splay.search(splay.root, 11);
        splay.root = splay.search(splay.root, 10);
        splay.root = splay.delete(splay.root, 3);
        splay.root = splay.delete(splay.root, 10);
        splay.root = splay.delete(splay.root, 52);
        splay.preorder(splay.root);
        System.out.println();
    }
}
