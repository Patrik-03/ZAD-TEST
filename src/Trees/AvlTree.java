package Trees;
import Base.NodeAvl;
public class AvlTree
{
    public NodeAvl root; //root of tree (public for testing purposes)
    int height(NodeAvl node) //get height of node
    {
        if (node == null) //if node is null
        {
            return 0; //return 0
        }
        return node.height; //return height of node
    }
    NodeAvl min(NodeAvl node)
    {
        if (node.left == null) //if left child is null
        {
            return node; //return node
        }
        else //if left child is not null
        {
            return min(node.left); //recursive call
        }
    }
    int max(int a, int b) //get max of two integers
    {
        return Math.max(a, b);
    }
    NodeAvl rotateR(NodeAvl node) //right rotation
    {
        NodeAvl x = node.left;
        NodeAvl z = x.right;
        x.right = node;
        node.left = z;
        node.height = 1 + max(height(node.left), height(node.right));
        x.height = 1 + max(height(x.left), height(x.right));

        return x; //return x (new root)
    }
    NodeAvl rotateL(NodeAvl node) //left rotation
    {
        NodeAvl x = node.right; //x is right child of base
        NodeAvl z = x.left; //y is left child of parent
        x.left = node;
        node.right = z;
        node.height = 1 + max(height(node.left), height(node.right)); //update height of node
        x.height = 1 + max(height(x.left), height(x.right)); //update height of node

        return x; //return x (new root)
    }
    public int BF(NodeAvl N) //balance factor of node
    {
        if (N == null) //if node is null
        {
            return 0; //return 0
        }

        return height(N.left) - height(N.right); //return height of left child - height of right child (balance factor)
    }
    public NodeAvl insert(NodeAvl node, int data) //insert node into tree
    {
        if (node == null) //if node is null
        {
            return new NodeAvl(data); //create new node with data and return it
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

        node.height = 1 + Math.max(height(node.left), height(node.right)); //update height of node
        int bal = BF(node); //balance factor of node (height of left child - height of right child)
        if(bal < -1) //if balance factor is greater than 1
        {
            if (node.right.data < data) //if data is greater than or equal to node data
            {
                return rotateL(node); //rotate right
            }
            else if(node.right.data > data) //if data is less than node data
            {
                node.right = rotateR(node.right); //rotate left
                return rotateL(node); //rotate right
            }
        }
        else if (bal > 1) //if balance factor is less than -1
        {
            if (node.left.data > data)
            {
                return rotateR(node); //rotate left
            }
            else if(node.left.data < data)
            {
                node.left = rotateL(node.left); //rotate right
                return rotateR(node); //rotate left
            }
        }
        return node;
    }
    public NodeAvl delete(NodeAvl node, int data) //delete node from tree
    {
        if (node == null) //if node is null
        {
            return null; //return node
        }
        else if (node.data > data) //if data is less than node data go left
        {
            node.left = delete(node.left, data); //recursive call
        }
        else if (node.data < data) //if data is greater than node data go right
        {
            node.right = delete(node.right, data); //recursive call
        }
        else //if data is equal to node data (node to be deleted)
        {
            if (node.left == null || node.right == null) //if node has one child
            {
                if (node.left == null) //if left child is null
                {
                    return node.right; //temp is right child
                }
                else //if right child is null
                {
                    return node.left; //temp is left child
                }
            }
            else //if node has two children
            {
                NodeAvl temp = min(node.right); //temp is minimum value in right subtree
                node.data = temp.data; //replace node data with temp data (minimum value in right subtree)
                node.right = delete(node.right, temp.data); //delete temp node (minimum value in right subtree)
            }
        }
        node.height = 1 + Math.max(height(node.left), height(node.right)); //update height of node
        int balance = BF(node);
        // Left Left Case
        if (balance > 1 && BF(node.left) >= 0)
            return rotateR(node);

        // Left Right Case
        if (balance > 1 && BF(node.left) < 0){
            node.left = rotateL(node.left);
            return rotateR(node);
        }

        // Right Right Case
        if (balance < -1 && BF(node.right) <= 0)
            return rotateL(node);
        // Right Left Case
        if (balance < -1 && BF(node.right) > 0){
            node.right = rotateR(node.right);
            return rotateL(node);
        }

        return node;
    }
    public NodeAvl search(NodeAvl node, int data) //search for node in tree
    {
        if(node != null) //if node is not null (found)
        {

            if (node.data > data) //if node data is greater than data
            {
                search(node.left, data); //recursive call
            }
            else //if node data is less than data
            {
                search(node.right, data); //recursive call
            }
        }
        return node;
    }
    public void preorder(NodeAvl node) //preorder traversal
    {
        if (node != null) //if node is not null
        {
            System.out.print(node.data + ", "); //print node data
            preorder(node.left); //recursive call
            preorder(node.right); //recursive call
        }
    }
}