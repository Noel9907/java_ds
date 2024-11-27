import java.util.Scanner;

class BinarySearchTree {

    static class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
            left = right = null;
        }
    }

    private Node root;

    public void insert(int value) {
        root = insertRec(root, value);
    }

    private Node insertRec(Node root, int value) {
        if (root == null) {
            root = new Node(value);
            return root;
        }

        if (value < root.data) {
            root.left = insertRec(root.left, value);
        } else if (value > root.data) {
            root.right = insertRec(root.right, value);
        }

        return root;
    }

    public boolean search(int value) {
        return searchRec(root, value);
    }

    private boolean searchRec(Node root, int value) {
        if (root == null) {
            return false;
        }
        if (root.data == value) {
            return true;
        }

        if (value < root.data) {
            return searchRec(root.left, value);
        }

        return searchRec(root.right, value);
    }

    public void inOrder() {
        inOrderRec(root);
    }

    private void inOrderRec(Node root) {
        if (root != null) {
            inOrderRec(root.left);
            System.out.print(root.data + " ");
            inOrderRec(root.right);
        }
    }

    public void preOrder() {
        preOrderRec(root);
    }

    private void preOrderRec(Node root) {
        if (root != null) {
            System.out.print(root.data + " ");
            preOrderRec(root.left);
            preOrderRec(root.right);
        }
    }

    public void postOrder() {
        postOrderRec(root);
    }

    private void postOrderRec(Node root) {
        if (root != null) {
            postOrderRec(root.left);
            postOrderRec(root.right);
            System.out.print(root.data + " ");
        }
    }

    public void delete(int value) {
        root = deleteRec(root, value);
    }

    private Node deleteRec(Node root, int value) {
        if (root == null) {
            return root;
        }

        if (value < root.data) {
            root.left = deleteRec(root.left, value);
        } else if (value > root.data) {
            root.right = deleteRec(root.right, value);
        } else {

            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }

            root.data = minValue(root.right);

            root.right = deleteRec(root.right, root.data);
        }

        return root;
    }

    private int minValue(Node root) {
        int minValue = root.data;
        while (root.left != null) {
            minValue = root.left.data;
            root = root.left;
        }
        return minValue;
    }

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        Scanner sc = new Scanner(System.in);
        int choice, value;
        System.out.println("\nBinary Search Tree Operations:");
        System.out.println("1. Insert a Node");
        System.out.println("2. Search for a Node");
        System.out.println("3. In-order Traversal");
        System.out.println("4. Pre-order Traversal");
        System.out.println("5. Post-order Traversal");
        System.out.println("6. Delete a Node");
        System.out.println("7. Exit");
        System.out.print("Enter your choice: ");

        do {
           
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter value to insert: ");
                    value = sc.nextInt();
                    bst.insert(value);
                    System.out.println(value + " inserted into the tree.");
                    break;

                case 2:
                    System.out.print("Enter value to search: ");
                    value = sc.nextInt();
                    boolean found = bst.search(value);
                    if (found) {
                        System.out.println(value + " found in the tree.");
                    } else {
                        System.out.println(value + " not found in the tree.");
                    }
                    break;

                case 3:
                    System.out.print("In-order Traversal: ");
                    bst.inOrder();
                    System.out.println();break;

                case 4:
                    System.out.print("Pre-order Traversal: ");
                    bst.preOrder();
                    System.out.println(); 
                    break;

                case 5:
                    System.out.print("Post-order Traversal: ");
                    bst.postOrder();
                    System.out.println(); 
                    break;

                case 6:
                    System.out.print("Enter value to delete: ");
                    value = sc.nextInt();
                    bst.delete(value);
                    System.out.println(value + " deleted from the tree.");
                    break;

                case 7:
                    System.out.println("Exiting program. Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        } while (choice != 7);

        sc.close();
    }
}
