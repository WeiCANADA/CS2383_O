package as1;

/**
 * A Test class for BST class
 *
 * @author Wei Liu 3718446
 */
public class BSTDriver {
    public static void main(String[] args) {
        //1. Create a BST
        BST<Integer> bst = new BST<>();
        int[] intArray = { 30, 25, 35, 32, 33, 40, 36, 22, 23 };
        for (int i = 0; i < intArray.length; i++) {
            bst.insert(intArray[i]);
        }
        //a. Inorder
        bst.displayInOrder();
        System.out.println();
        //b. Preorder
        bst.displayPreOrder();
        System.out.println();
        //c. PostOrder
        bst.displayPostOrder();
        System.out.println();

    /* 3. Insert into a BST (Mark 10)
          a. Insert the value 15 into the tree*/
        System.out.println("** Insert the value 15**");
        bst.insert(15);
        bst.displayInOrder();
        System.out.println();
        /*
        * 4. Delete from a BST (Mark 15)
                a. Delete the node including value 35
        * */
        System.out.println("** delete the value 35**");
        bst.delete(35);
        bst.displayInOrder();

    }

}//End the class

