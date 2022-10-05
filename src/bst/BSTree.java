package bst;

import as1.BSTNode;

/**
 * @author Wei Liu 3718446
 */
public class BSTree<T extends Comparable<? super T>> {

    private  static class Node<T> {
        private T value;
        private Node<T> left;
        private Node<T> right;

        public Node(T value, Node<T> left, Node<T> right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }

    private Node<T> root;

    public BSTree (){
        root = null;
    }

    public Node<T> getRoot() {
        return root;
    }

    public void setRoot(Node<T> root) {
        this.root = root;
    }

    public void insert(T value) {
        if (this.root == null) {
            this.root = new Node<>(value, null, null);
        } else insert(this.root, value);
    }

    private void insert(Node<T> node, T value) {
        int i = value.compareTo(node.value);
        if (i < 0) {
            if (node.left == null) node.left = new Node<>(value, null, null);
            else insert(node.left, value);
        } else {
            if (node.right == null) node.right = new Node<>(value, null, null);
            else insert(node.right, value);
        }
    }

    public void inorder() {
        if (root != null)
            inorder(root);
    }

    private void inorder(Node<T> node) {
        if (node.left != null) inorder(node.left);
        System.out.print(node.value + ", ");
        if (node.right != null) inorder(node.right);

    }

    public void preorder() {
        if (root != null)
            preorder(root);
    }

    private void preorder(Node<T> node) {
        System.out.print(node.value + ", ");
        if (node.left != null) preorder(node.left);
        if (node.right != null) preorder(node.right);

    }

    public void postorder() {
        if (root != null)
            postorder(root);
    }

    private void postorder(Node<T> node) {
        if (node.left != null) postorder(node.left);
        if (node.right != null) postorder(node.right);
        System.out.print(node.value + ", ");

    }

    public void delete(T value) {
        if (root != null) root = delete(root, value);

    }

    private Node<T> delete(Node<T> node, T value) {
        int i = value.compareTo(node.value);
        if (i < 0) {
            if (node.left != null)
                node.left = delete(node.left, value);
        } else if (i > 0) {
            if (node.right != null) {
                node.right = delete(node.right, value);
            }
        } else {
            if (node.left == null)
                return node.right;
            else if (node.right == null)
                return node.left;
            else {
                node.value = min(node.right);
                node.right = delete(node.right, node.value);

            }

        }
        return node;
    }

    private T min(Node<T> node) {

        T minVal = node.value;
        while (node.left != null) {
            if (minVal.compareTo(node.left.value) > 0) {
                minVal = node.left.value;
            }
            node = node.left;
        }
        return minVal;

    }

    public static void main(String[] args) {
        BSTree<Integer> bst = new BSTree<>();
        bst.insert(30);
        bst.insert(25);
        bst.insert(35);
        bst.insert(32);
        bst.insert(33);
        bst.insert(40);
        bst.insert(36);
        bst.insert(22);
        bst.insert(23);

        //TreeOpe

        System.out.print("Inorder Traverse : ");
        bst.inorder();
        System.out.println("\n");

        System.out.print("Postorder Traverse : ");
        bst.postorder();
        System.out.println("\n");

        System.out.print("Preorder Traverse : ");
        bst.preorder();
        System.out.println("\n");


        System.out.println("Delete 35 from tree : ");
        bst.delete(35);

        System.out.print("Inorder Traverse : ");
        bst.inorder();
        System.out.println("\n");


    }

}
