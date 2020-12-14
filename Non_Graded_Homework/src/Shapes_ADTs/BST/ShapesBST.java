package Shapes_ADTs.BST;

import Shape_and_subclasses.Shape;

import java.util.*;

public class ShapesBST implements Iterable<Shape>, BSTIterators {
    public static class Node {
        public Shape data;
        public Node left;
        public Node right;
        public Node parent;

        public Node(Shape data) {
            this.data = data;
        }

        public Node(Shape data, Node parent) {
            this.data = data;
            this.parent = parent;
        }
    }

    private Node root;

    public void insert(Shape elem) {
        root = insertRec(root, elem, null);
    }

    private Node insertRec(Node node, Shape elem, Node parent) {
        if (node == null) {
            return new Node(elem, parent);
        } else if (elem.compareTo(node.data) > 0) {
            node.right = insertRec(node.right, elem, node);
        } else if (elem.compareTo(node.data) <= 0) {
            node.left = insertRec(node.left, elem, node);
        }
        return node;
    }

    public void insertNonRec(Shape elem) {
        if (root == null) {
            root = new Node(elem);
            return;
        }
        Node tmp = root;
        while (true) {
            if (tmp.data.compareTo(elem) > 0) {
                if (tmp.left == null) {
                    tmp.left = new Node(elem, tmp);
                    return;
                } else {
                    tmp = tmp.left;
                }
            }
            if (tmp.data.compareTo(elem) < 0) {
                if (tmp.right == null) {
                    tmp.right = new Node(elem, tmp);
                    return;
                } else {
                    tmp = tmp.right;
                }
            }
        }
    }

    public void remove(Shape elem) {
        if (searchFor(elem) == null) {
            return;
        }
        root = removeRec(root, elem);
    }

    private Node removeRec(Node node, Shape elem) {
        if (node.data.compareTo(elem) == 0) {
            //Case 1, if the found element does not have children
            if (node.left == null && node.right == null) {
                return null;
            }
            //Case 2, if the found element has two children
            if (node.left != null && node.right != null) {
                Node biggestOnLeft = getLargestNode(node.left);
                node.data = biggestOnLeft.data;
                node.left = removeRec(node.left, biggestOnLeft.data);
                return node;
            }
            // Case 3, we know that the found element has one child
            Node child = node.right;
            if (node.left != null) {
                child = node.left;
            }
            return child;
        } else if (node.data.compareTo(elem) > 0) {
            node.left = removeRec(node.left, elem);
        } else if (node.data.compareTo(elem) < 0) {
            node.right = removeRec(node.right, elem);
        }
        return node;
    }

    public Shape removeNonRec(Shape elem) {
        Node tmp = searchFor(elem);
        if (tmp == null) {
            return null;
        }
        //Case 1, if the found element does not have children
        if (tmp.left == null && tmp.right == null) {
            //if the element to remove is the root and it has no children
            if (tmp.parent == null) {
                root = null;
                return elem;
            }
            if (tmp.parent.left.equals(tmp)) {
                tmp.parent.left = null;
            } else {
                tmp.parent.right = null;
            }
            tmp.parent = null;
        }
        //Case 2, if the found element has two children
        else if (tmp.left != null && tmp.right != null) {
            Node tmptmp = tmp.left;
            Node largestOnLeft = getLargestNode(tmptmp);
            tmp.data = largestOnLeft.data;
            while (!(tmptmp.data.equals(largestOnLeft.data))) {
                tmptmp = tmptmp.right;
            }
            Node child = tmptmp.right;
            if (tmptmp.left != null) {
                child = tmptmp.left;
            }
            if (tmptmp.parent.left.equals(tmptmp)) {
                tmptmp.parent.left = child;
            } else {
                tmptmp.parent.right = child;
            }
            if (child != null) {
                child.parent = tmptmp.parent;
            }
            //if the element to remove is the root and it has 2 children children
            if (tmp.parent == null) {
                root = tmp;
            }
            tmptmp.parent = tmptmp.left = tmptmp.right = null;
        }
        // Case 3, we know that the found element has one child
        else {
            Node child = tmp.right;
            Node futureParent = tmp.parent;
            if (tmp.left != null) {
                child = tmp.left;
            }
            if (futureParent != null) {
                if (tmp.parent.left.equals(tmp)) {
                    tmp.parent.left = child;
                } else {
                    tmp.parent.right = child;
                }
            } else {
                root = child;
            }
            child.parent = futureParent;
            tmp.parent = tmp.left = tmp.right = null;
        }
        return elem;
    }


    public Node getLargestNode(Node node) {
        if (node.right == null) {
            return node;
        }
        return getLargestNode(node.right);
    }

    public Node getSmallestNode(Node node) {
        if (node.left == null) {
            return node;
        }
        return getSmallestNode(node.left);
    }

    public boolean contains(Shape shape) {
        return searchFor(shape) != null;
    }

    public Node searchFor(Shape value) {
        return searchForNode(root, value);
    }

    private Node searchForNode(Node root, Shape value) {
        if (root == null) {
            return null;
        }
        if (value == root.data) {
            return root;
        }
        if (value.compareTo(root.data) < 0) {
            if (root.left != null) {
                return searchForNode(root.left, value);
            }
        } else if (value.compareTo(root.data) > 0) {
            if (root.right != null) {
                return searchForNode(root.right, value);
            }
        }
        return null;
    }

    public ArrayList<Node> getAllLeaves() {
        ArrayList<Node> arrayList = new ArrayList<>();
        Iterator<Shape> itr = iterator();
        while (itr.hasNext()) {
            Node tmp = searchFor(itr.next());
            if (tmp.right == null && tmp.left == null) {
                arrayList.add(tmp);
            }
        }
        return arrayList;
    }

    public boolean isFull() {
        if (root == null) {
            return true;
        }
        return isFull(root);
    }

    private boolean isFull(Node node) {
        if (node == null) {
            return true;
        }
        if (node.left == null && node.right == null) {
            return true;
        }
        if ((node.left != null) && (node.right != null)) {
            return (isFull(node.left) && isFull(node.right));
        }
        return false;
    }

    public boolean isComplete() {
        if (root == null) {
            return false;
        }
        return isComplete(root);
    }

    private boolean isComplete(Node root) {
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(root);
        Node front;
        boolean flag = false;
        while (!queue.isEmpty()) {
            front = queue.poll();
            if (flag && (front.left != null || front.right != null)) {
                return false;
            }
            if (front.left == null && front.right != null) {
                return false;
            }
            if (front.left != null) {
                queue.add(front.left);
            } else {
                flag = true;
            }
            if (front.right != null) {
                queue.add(front.right);
            } else {
                flag = true;
            }
        }
        return true;
    }


    private String toString(List<Shape> list) {
        if (list == null) {
            return "";
        }
        return list.toString().replace("[", "").replace("]", "");
    }


    //InOrder Iterators
    @Override
    public Iterator<Shape> iterator() {
        //return new InOrderIteratorNormal();
        return new InOrderIteratorStack();
    }

    private Iterator<Shape> startingPointIterator(Node startingNode) {
        return new InOrderIteratorNormal(startingNode);
    }

    private Iterator<Shape> reverseInOrderIterator() {
        return new InOrderIteratorStackReverse(root);
    }

    private Iterator<Shape> reverseInOrderIteratorStartingPoint(Node startingNode) {
        return new InOrderIteratorStackReverse(startingNode);
    }

    private class InOrderIteratorNormal implements Iterator<Shape> {
        Node current;

        private InOrderIteratorNormal() {
            if (root == null) {
                return;
            }
            current = root;
            while (current.left != null) {
                current = current.left;
            }
        }

        private InOrderIteratorNormal(Node startingNode) {
            if (startingNode == null) {
                return;
            }
            current = startingNode;
            while (current.left != null) {
                current = current.left;
            }
        }

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Shape next() {
            Node toReturn = current;
            if (current.right != null) {
                current = current.right;
                while (current.left != null) {
                    current = current.left;
                }
                return toReturn.data;
            } else {
                while (true) {
                    if (current.parent == null) {
                        current = null;
                        return toReturn.data;
                    }
                    if (current.parent.left == current) {
                        current = current.parent;
                        return toReturn.data;
                    }
                    current = current.parent;
                }
            }
        }
    }

    private class InOrderIteratorStack implements Iterator<Shape> {
        Stack<Node> stack;

        public InOrderIteratorStack() {
            if (root == null) {
                return;
            }
            Node tmp = root;
            stack = new Stack<>();
            while (tmp != null) {
                stack.push(tmp);
                tmp = tmp.left;
            }
        }

        public boolean hasNext() {
            return !stack.isEmpty();
        }

        public Shape next() {
            Node tmp = stack.pop();
            Shape toReturn = tmp.data;
            if (tmp.right != null) {
                tmp = tmp.right;
                while (tmp != null) {
                    stack.push(tmp);
                    tmp = tmp.left;
                }
            }
            return toReturn;
        }
    }

    private class InOrderIteratorStackReverse implements Iterator<Shape> {
        Stack<Node> stack;

        public InOrderIteratorStackReverse(Node start) {
            if (start == null) {
                return;
            }
            Node tmp = start;
            stack = new Stack<>();
            while (tmp != null) {
                stack.push(tmp);
                tmp = tmp.right;
            }
        }

        public boolean hasNext() {
            return !stack.isEmpty();
        }

        public Shape next() {
            Node tmp = stack.pop();
            Shape toReturn = tmp.data;
            if (tmp.left != null) {
                tmp = tmp.left;
                while (tmp != null) {
                    stack.push(tmp);
                    tmp = tmp.right;
                }
            }
            return toReturn;
        }
    }

    //PostOrder Iterator
    @Override
    public Iterator<Shape> postOrderIterator() {
        return new PostOrderIteratorStack();
    }

    public Iterator<Shape> postOrderIteratorNormal() {
        return new PostOrderIteratorNormal();
    }

    private class PostOrderIteratorNormal implements Iterator<Shape> {
        Node current;
        boolean goingUp = false;

        private PostOrderIteratorNormal() {
            if (root == null) {
                return;
            }
            current = root;
            while (current.left != null) {
                current = current.left;
            }
        }

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Shape next() {
            Node toReturn = current;
            while (true) {
                Node top = toReturn.parent;
                if (top == null) {
                    current = null;
                    return toReturn.data;
                }
                Node cur = top.right;
                if (cur == null) {
                    current = top;
                    goingUp = true;
                    return toReturn.data;
                }
                if (!goingUp) {
                    while (cur.right != null) {
                        while (cur.left != null) {
                            cur = cur.left;
                        }
                        if (cur.right != null) {
                            cur = cur.right;
                        }
                    }
                    goingUp = false;
                }

                if (cur == toReturn) {
                    current = top;
                    goingUp = false;
                    return toReturn.data;
                }
                current = cur;
                break;
            }
            return toReturn.data;

            /*if (current.parent == null) {
                current = null;
                return toReturn.data;
            } else {
                while (true) {
                    if (current.parent.left == current) {
                        current = current.parent;
                    }
                    if (current.right != null) {
                        current = current.right;
                        while (current.left != null) {
                            current = current.left;
                        }
                        return toReturn.data;
                    }
                    if (current.parent.right == current) {
                        current = current.parent;
                    }
                    return toReturn.data;
                }
            }*/

        }
    }

    private class PostOrderIteratorStack implements Iterator<Shape> {
        Stack<Node> shapesStack;

        private PostOrderIteratorStack() {
            Node tmp = root;
            if (tmp != null) {
                shapesStack = new Stack<>();
            }
            while (tmp != null) {
                shapesStack.push(tmp);
                if (tmp.left != null) {
                    tmp = tmp.left;
                } else {
                    tmp = tmp.right;
                }
            }
        }

        @Override
        public boolean hasNext() {
            return !shapesStack.isEmpty();
        }

        @Override
        public Shape next() {
            Node toReturn = shapesStack.pop();
            if (!shapesStack.isEmpty()) {
                Node top = shapesStack.peek();
                if (toReturn.equals(top.left)) {
                    Node tmp = top.right;
                    while (tmp != null) {
                        shapesStack.push(tmp);
                        if (tmp.left != null) {
                            tmp = tmp.left;
                        } else {
                            tmp = tmp.right;
                        }
                    }
                }
            }
            return toReturn.data;
        }
    }

    private class ReversePostOrderIteratorStack implements Iterator<Shape> {
        Stack<Node> shapesStack;

        private ReversePostOrderIteratorStack() {
            Node tmp = root;
            if (tmp != null) {
                shapesStack = new Stack<>();
            }
            while (tmp != null) {
                shapesStack.push(tmp);
                if (tmp.right != null) {
                    tmp = tmp.right;
                } else {
                    tmp = tmp.left;
                }
            }
        }

        @Override
        public boolean hasNext() {
            return !shapesStack.isEmpty();
        }

        @Override
        public Shape next() {
            Node toReturn = shapesStack.pop();
            if (!shapesStack.isEmpty()) {
                Node top = shapesStack.peek();
                if (toReturn.equals(top.right)) {
                    Node tmp = top.left;
                    while (tmp != null) {
                        shapesStack.push(tmp);
                        if (tmp.right != null) {
                            tmp = tmp.right;
                        } else {
                            tmp = tmp.left;
                        }
                    }
                }
            }
            return toReturn.data;
        }
    }

    //PreOrder Iterator
    @Override
    public Iterator<Shape> preOrderIterator() {
        return new PreOrderIteratorStack();
    }

    private class PreOrderIteratorStack implements Iterator<Shape> {
        Stack<Node> shapesStack;

        public PreOrderIteratorStack() {
            if (root == null) {
                return;
            }
            shapesStack = new Stack<>();
            shapesStack.push(root);
        }


        @Override
        public boolean hasNext() {
            return !shapesStack.isEmpty();
        }

        @Override
        public Shape next() {
            Node toReturn = shapesStack.pop();
            if (toReturn.right != null) {
                shapesStack.push(toReturn.right);
            }
            if (toReturn.left != null) {
                shapesStack.push(toReturn.left);
            }
            return toReturn.data;
        }
    }
}
