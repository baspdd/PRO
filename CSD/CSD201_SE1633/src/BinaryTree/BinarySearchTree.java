/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BinaryTree;

/**
 *
 * @author Admin
 */
public class BinarySearchTree<T extends Comparable> {

    private BinaryTree<T> tree;

    public BinarySearchTree() {
        tree = new BinaryTree<>();
    }

    public boolean isEmpty() {
        return tree.isEmpty();
    }

    public void clear() {
        tree.clear();
    }

    public void bfsTraverse() {
        tree.BFS();
    }

    public void inOrderTraverse() {
        tree.inOrderTraverse();
    }

    public void preOrderTraverse() {
        tree.preOrderTraverse();
    }

    public void postOrderTraverse() {
        tree.postOrderTraverse();;
    }

    public void addNode(T data) {
        //ngoai le
        if (isEmpty()) {
            BinaryNode<T> n = new BinaryNode<>(data);
            tree.setRoot(n);
            return;
        }

        BinaryNode<T> node = tree.getRoot();
        while (true) {
            if (node.getData().compareTo(data) < 0) //re phai
            {
                if (node.getRight() != null) //re phai dc
                {
                    node = node.getRight();
                } else//ko re phai dc -> dua luon x vao node ben phai cua f
                {
                    tree.addNode(node, false, data);
                    return;
                }
            } else //re trai
            if (node.getLeft() != null) //re trai dc
            {
                node = node.getLeft();
            } else//ko re trai dc -> dua luon x vao node ben trai cua f
            {
                tree.addNode(node, true, data);
                return;
            }
        }
    }

    public void buildTree(T[] list) {
        for (T item : list) {
            addNode(item);
        }
    }

    public BinaryNode<T> search(T x) {
        //ngoai le
        if (isEmpty()) {
            return null;
        }

        BinaryNode<T> f = tree.getRoot();
        while (true) {
            if (f.getData().compareTo(x) < 0) {
                f = f.getRight();
            } else if (f.getData().compareTo(x) > 0) {
                f = f.getLeft();
            } else {
                return f;
            }
            if (f == null) {
                return null;
            }
        }
    }

    public BinaryNode<T> findFather(BinaryNode<T> n) {
        if (isEmpty() || n == null || n == tree.getRoot()) {
            return null;
        }
        BinaryNode<T> f = tree.getRoot();
        while (true) {
            if (f.getData().compareTo(n.getData()) < 0) //re phai
            {
                if (f.getRight() == n) {
                    return f;
                } else {
                    f = f.getRight();
                }
            } else if (f.getData().compareTo(n.getData()) > 0) //re trai
            {
                if (f.getLeft() == n) {
                    return f;
                } else {
                    f = f.getLeft();
                }
            }
            if (f == null) {
                return null;
            }
        }
    }
// delete node is leaf 

    private boolean isLeaf(BinaryNode<T> n) {
        return (n.getLeft() == null && n.getRight() == null);
    }

    private void deleteLeaf(BinaryNode<T> n) {
        if (!isLeaf(n)) {
            return;
        }
        if (n == tree.getRoot()) {
            clear();
        }
        BinaryNode<T> f = findFather(n);
        if (f == null) {
            return;
        }
        if (f.getLeft() == n)// n la con trai cua f
        {
            f.setLeft(null);
        } else {
            f.setRight(null);
        }
    }

//delete node has 1 child
    private boolean hasOneChild(BinaryNode<T> n) {
        return !isLeaf(n) && !hasTwoChild(n);

    }

    private BinaryNode<T> getChildOfNodeHasOneChild(BinaryNode<T> n) {

        if (n.getLeft() != null) {
            return n.getLeft();
        } else {
            return n.getRight();
        }
    }

    private void deleteNodeHasOneChild(BinaryNode<T> n) {
        if (!hasOneChild(n)) {
            return;
        }
        BinaryNode<T> f = findFather(n);
        if (n == tree.getRoot()) {
            tree.setRoot(getChildOfNodeHasOneChild(n));
        }
        if (f == null) {
            return;
        }
        if (f.getLeft() == n)//n la con trai cua f -> gan lai f.left
        {
            f.setLeft(getChildOfNodeHasOneChild(n));
        } else //n la con phai cua f -> gan lai f.right
        {
            f.setRight(getChildOfNodeHasOneChild(n));
        }

    }

// delete node has 2 childs    
    private boolean hasTwoChild(BinaryNode<T> n) {
        return (n.getLeft() != null && n.getRight() != null);
    }

    //tim node con ben trai nhat cua cay con goc n
    private BinaryNode<T> getLeftMost(BinaryNode<T> n) {
        if (n == null) {
            return null;
        }
        while (n.getLeft() != null) {
            n = n.getLeft();
        }
        return n;
    }

    //tim node con ben phai nhat cua cay con goc n
    private BinaryNode<T> getRightMost(BinaryNode<T> n) {
        if (n == null) {
            return null;
        }
        while (n.getRight() != null) {
            n = n.getRight();
        }
        return n;
    }

    private void deleteNodeHasTwoChildByCopy(BinaryNode<T> n) {
        if (!hasTwoChild(n)) {
            return;
        }
        //1. tim leftmost trong cay con phai cua n
        BinaryNode<T> leftmost = getLeftMost(n.getRight());
        T save = leftmost.getData();
        //2. Xoa leftmost
        if (isLeaf(leftmost)) {
            deleteLeaf(leftmost);
        } else {
            deleteNodeHasOneChild(leftmost);
        }
        //3. dem gia tri cua leftmost (da luu lai vao bien save) len thay cho n
        n.setData(save);
    }

    private void deleteNodeHasTwoChildByMerge(BinaryNode<T> n) {
        if (!hasTwoChild(n)) {
            return;
        }
        //1. tim f la cha cua n
        BinaryNode<T> f = findFather(n);
        //2. Dem n.getLeft() thay n
        if (n == tree.getRoot()) {
            tree.setRoot(n.getLeft());
        } else if (f == null) {
            return;
        } else if (f.getLeft() == n) {
            f.setLeft(n.getLeft());
        } else {
            f.setRight(n.getLeft());
        }
        //3. Tim rightmost cua n.getleft
        BinaryNode<T> rightmost = getRightMost(n.getLeft());
        //4. Dem n.right lam con phai cua rightmost
        rightmost.setRight(n.getRight());
    }

    public void delete(T x) {
        BinaryNode<T> n = search(x);
        if (n == null) {
            return;
        }
        if (isLeaf(n)) {
            deleteLeaf(n);
        } else if (hasOneChild(n)) {
            deleteNodeHasOneChild(n);
        } else {
            deleteNodeHasTwoChildByCopy(n);
        }
    }
    
    //dem node n lam con cua f thay cho p
    private void setChild(BinaryNode<T> f, BinaryNode<T> p, BinaryNode<T> n)
    {
        if (p==f.getLeft()) f.setLeft(n);
        else if (p==f.getRight()) f.setRight(n);
    }

    //xoay don sang phai tai p, voi dieu kien p co cha la fp.
    //neu fp==null -> p la root
    public void SingleRotateRight(BinaryNode<T> p, BinaryNode<T> fp) {
        BinaryNode<T> q = p.getLeft();
        //1. Dem p.left len thay cho p
        if (fp == null) //p la root
        {
            tree.setRoot(p.getLeft());
        } else //p ko la goc, not fp != null
        {
            setChild(fp, p, p.getLeft());
        }
        //2. Dem q.right lam con trai cua p
        p.setLeft(p.getLeft().getRight());

        //3. Dem p lam con phai cua q
        q.setRight(p);
    }

    //xoay don sang trai tai p, voi dieu kien p co cha la fp.
    //neu fp==null -> p la root
    public void SingleRotateLeft(BinaryNode<T> p, BinaryNode<T> fp) {
        BinaryNode<T> q = p.getRight();
        //1. Dem q len thay p
        if (fp == null) {
            tree.setRoot(q);
        } else {
            setChild(fp, p, q);
        }

        //2. Dem q.left dua vao con phai cua p
        p.setRight(q.getLeft());

        //3. Dem p lam con trai cua q
        q.setLeft(p);
    }

    public void DoubleRotateLeftRight(BinaryNode<T> p, BinaryNode<T> fp) {
        //xoay trai tai con trai cua p
        SingleRotateLeft(p.getLeft(), p);
        //xoay phai tai p
        SingleRotateRight(p, fp);
    }

    public void DoubleRotateRightLeft(BinaryNode<T> p, BinaryNode<T> fp) {
        //xoay phai tai con phai cua p
        SingleRotateRight(p.getRight(), p);
        //xoay trai tai p
        SingleRotateLeft(p, fp);
    }
}
