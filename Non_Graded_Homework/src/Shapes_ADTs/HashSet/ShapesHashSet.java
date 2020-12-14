package Shapes_ADTs.HashSet;

import Shape_and_subclasses.Shape;

import java.util.ArrayList;
import java.util.Iterator;

public class ShapesHashSet implements Iterable<Shape> {
    //TODO
    public static class Node {
        Shape data;
        Node next;

        public Node(Shape data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    int capacity = 100;
    Node[] hashtable = new Node[capacity];

    public ShapesHashSet() {
        for (int i = 0; i < hashtable.length; i++) {
            hashtable[i] = null;
        }
    }

    private int hash(Shape e) {
        return (int) ((e.getHeight() + e.getArea()) * 32) % 100;
    }

    public void add(Shape e) {
        int index = hash(e);
        System.out.println("Element added under hash index " + index);
        if (contains(e)) {
            return;
        }
        if (hashtable[index] == null) {
            hashtable[index] = new Node(e, null);
        } else {
            Node n = new Node(e, hashtable[index]);
            hashtable[index] = n;
        }
    }

    public boolean contains(Shape e) {
        int index = hash(e);
        Node tmp = hashtable[index];
        while (tmp != null) {
            if (tmp.data.equals(e)) {
                return true;
            } else {
                tmp = tmp.next;
            }
        }
        return false;
    }

    public Shape remove(Shape e) {
        int index = hash(e);
        Node tmp = hashtable[index];
        Node prev = null;
        while (tmp != null) {
            if (tmp.data.equals(e)) {
                if (prev == null) {
                    hashtable[index] = tmp.next;
                } else {
                    prev.next = tmp.next;
                }
                tmp.next = null;
                return tmp.data;
            } else {
                prev = tmp;
                tmp = tmp.next;
            }
        }
        return null;
    }

    public ShapesHashSet getIntersection(ShapesHashSet s) {
        ShapesHashSet newSet = new ShapesHashSet();
        Iterator<Shape> it = iterator();
        while (it.hasNext()) {
            Shape e = it.next();
            if (s.contains(e)) {
                newSet.add(e);
            }
        }
        return newSet;
    }

    @Override
    public Iterator<Shape> iterator() {
        return new SetIterator();
    }

    public Iterator<Shape> reverseIterator() {
        return new reverseHashSetIterator();
    }

    public class SetIterator implements Iterator<Shape> {
        Node elem;

        public SetIterator() {
            elem = null;
            for (int i = 0; i < hashtable.length; i++) {
                if (hashtable[i] != null) {
                    elem = hashtable[i];
                    return;
                }
            }


        }

        @Override
        public boolean hasNext() {
            return elem != null;
        }

        @Override
        public Shape next() {
            Shape tmp = elem.data;
            if (elem.next != null) {
                elem = elem.next;
            } else {
                int index = hash(elem.data);
                elem = null;
                for (int i = index + 1; i < hashtable.length; i++) {
                    if (hashtable[i] != null) {
                        elem = hashtable[i];
                        break;
                    }
                }
            }
            return tmp;
        }

    }

    public class reverseHashSetIterator implements Iterator<Shape> {
        Node elem;
        ArrayList<Node> arrayList;

        public reverseHashSetIterator() {
            arrayList = new ArrayList<>();
            for (int i = hashtable.length - 1; i >= 0; i--) {
                if (hashtable[i] != null) {
                    Node n = hashtable[i];
                    while (n != null) {
                        elem = n;
                        arrayList.add(elem);
                        n = n.next;
                    }
                    return;
                }
            }

        }

        @Override
        public boolean hasNext() {
            return elem != null;
        }

        @Override
        public Shape next() {
            Shape tmp = elem.data;
            arrayList.remove(arrayList.size() - 1);
            if (arrayList.isEmpty()) {
                elem = null;
                int whereWeAre = hash(tmp);
                for (int i = whereWeAre - 1; i >= 0; i--) {
                    if (hashtable[i] != null) {
                        Node n = hashtable[i];
                        while (n != null) {
                            elem = n;
                            arrayList.add(elem);
                            n = n.next;
                        }
                        return tmp;
                    }
                }
            }
            elem = arrayList.get(arrayList.size() - 1);
            return tmp;
        }

    }

}
