package Prints;
import Trees.AvlTree;

public class AvlPrint
{
    public static void print()
    {
        System.out.print("AVL Tree preorder traversal: ");
        AvlTree avl = new AvlTree(); //initialize avl tree
        avl.root = avl.insert(avl.root, 10);
        avl.root = avl.insert(avl.root, 52);
        avl.root = avl.insert(avl.root, 3);
        avl.root = avl.insert(avl.root, 14);
        avl.root = avl.insert(avl.root, 86);
        avl.root = avl.insert(avl.root, 7);
        avl.root = avl.insert(avl.root, 11);
        avl.root = avl.insert(avl.root, 66);
        avl.root = avl.search(avl.root, 11);
        avl.root = avl.search(avl.root, 10);
        avl.root = avl.search(avl.root, 50);
        avl.root = avl.delete(avl.root, 3);
        avl.root = avl.delete(avl.root, 10);
        avl.root = avl.delete(avl.root, 52);
        avl.preorder(avl.root);
        System.out.println();
    }
}
