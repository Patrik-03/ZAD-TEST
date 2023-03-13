package Trees;
import Base.NodeSplay;

public class SplayTree
{
    public NodeSplay root; //root node
    NodeSplay rotateR(NodeSplay x) //right rotation
    {
        NodeSplay z = x.left;
        x.left = z.right;
        z.right = x;
        return  z;
    }
    NodeSplay rotateL(NodeSplay x) //left rotation
    {
        NodeSplay z = x.right;
        x.right = z.left;
        z.left = x;
        return z;
    }
    NodeSplay splay(NodeSplay node, int data) //splay node to root
    {
        if(node == null || node.data == data) //if node is null or node data is equal to data
        {
            return node; //return node
        }
        if(node.data > data) //if data is less than node data go left
        {
            if(node.left == null) //if node is null
            {
                return node; //return node
            }
            if (node.left.data > data) //if data is less than node data go left
            {
                node.left.left = splay(node.left.left, data); //splay the node to the root
                node = rotateR(node); //rotate right
            }
            else if (node.left.data < data) //if data is greater than node data go right
            {
                node.left.right = splay(node.left.right, data); //splay the node to the root
                if(node.left.right != null) //if node is not null
                {
                    node.left = rotateL(node.left); //rotate left
                }
            }
            if (node.left == null) //if node is null
            {
                return node; //return node
            }
            else
            {
                return rotateR(node); //rotate right
            }
        }
        else //if data is greater than node data go right
        {
            if(node.right == null) //if node is null
            {
                return node; //return node
            }
            if(node.right.data < data) //if data is less than node data go left
            {
                node.right.right = splay(node.right.right, data); //splay the node to the root
                node = rotateL(node); //rotate left
            }
            else if(node.right.data > data) //if data is greater than node data go right
            {
                node.right.left = splay(node.right.left, data); //splay the node to the root
                if (node.right.left != null) //if node is not null
                {
                    node.right = rotateR(node.right); //rotate right
                }
            }
            if(node.right == null) //if node is null
            {
                return node; //return node
            }
            else
            {
                return rotateL(node); //rotate left
            }
        }
    }
    public NodeSplay insert(NodeSplay node, int data) //insert node
    {
        if (node == null) //if node is null
        {
            return new NodeSplay(data); //create new node with data and return it
        }
        else if (data > node.data) //if data is greater than node data go right
        {
            node.right = insert(node.right, data); //recursive call to insert
        }
        else if (data < node.data) //if data is less than node data go left
        {
            node.left = insert(node.left, data); //recursive call to insert
        }
        else //if data is equal to node data
        {
            return node; //return node
        }
        return splay(node, data); //splay the node to the root and return it
    }
    public NodeSplay delete(NodeSplay node, int data) //delete node
    {
        NodeSplay temp; //create temp node to hold node data for deletion
        if(node == null) //if node is null
        {
            return null; //return null
        }
        node = splay(node, data); //splay the node to the root if it exists in the tree otherwise the last node accessed is splayed
        if(node.left == null) //if node left is null
        {
            return node.right; //return node right
        }
        else if(node.right == null) //if node right is null
        {
            return node.left; //return node left
        }
        else
        {
            temp = node;
            node = splay(node.left, data); //splay the node to the root
            node.right = temp.right; //set node right to temp right
        }
        return node; //return node
    }
    public NodeSplay search(NodeSplay node, int data) //search for node
    {
        if(node == null || node.data == data) //if node is null or node data is equal to data
        {
            return node; //return node
        }
        if(node.data > data) //if data is less than node data go left
        {
            node.left = search(node.left, data); //recursive call to search
        }
        else
        {
            node.right = search(node.right, data); //recursive call to search
        }
        return splay(node, data); //splay the node to the root and return it
    }
    public void preorder(NodeSplay node) //preorder traversal
    {
        if(node != null) //if node is not null
        {
            System.out.print(node.data + ", "); //print node data
            preorder(node.left); //recursive call to preorder
            preorder(node.right); //recursive call to preorder
        }
    }
}