package Generic_ADTs.Treemap;

import java.util.*;

public class GenericsTreeMap<K extends Comparable<K>, V> implements Iterable<V> {

    public class Entry {
        public K key;
        public V value;
        public Entry left;
        public Entry right;
        public Entry parent;

        public Entry() {
            this.key = null;
            this.value = null;
            this.parent = null;
        }

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
            this.parent = null;
        }

        public Entry(K key, V value, Entry parent) {
            this.key = key;
            this.value = value;
            this.parent = parent;
        }
    }

    private Entry root;

    public V get(K key) {
        return get(root, key) == null ? null : get(root, key).value;
    }

    private Entry get(Entry root, K key) {
        if (root == null) {
            return null;
        }
        if (key.compareTo(root.key) == 0) {
            return root;
        }
        if (key.compareTo(root.key) <= 0) {
            if (root.left != null) {
                return get(root.left, key);
            }
        } else if (key.compareTo(root.key) > 0) {
            if (root.right != null) {
                return get(root.right, key);
            }
        }
        return null;
    }

    public void put(K key, V value) {
        if (root == null) {
            root = new Entry(key, value);
            return;
        }
        Entry tmp = root;
        while (true) {
            if (tmp.key.compareTo(key) >= 0) {
                if (tmp.left == null) {
                    tmp.left = new Entry(key, value, tmp);
                    return;
                } else {
                    tmp = tmp.left;
                }
            }
            if (tmp.key.compareTo(key) < 0) {
                if (tmp.right == null) {
                    tmp.right = new Entry(key, value, tmp);
                    return;
                } else {
                    tmp = tmp.right;
                }
            }
        }
    }

    public V remove(K key) {
        Entry tmp = get(root, key);
        if (tmp == null) {
            return null;
        }
        //Case 1, if the found element does not have children
        if (tmp.left == null && tmp.right == null) {
            //if the element to remove is the root and it has no children
            if (tmp.parent == null) {
                root = null;
                return tmp.value;
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
            Entry tmptmp = tmp.left;
            Entry largestOnLeft = getLargestEntry(tmptmp);
            tmp.key = largestOnLeft.key;
            tmp.value = largestOnLeft.value;
            while (!(tmptmp.key.equals(largestOnLeft.key))) {
                tmptmp = tmptmp.right;
            }
            Entry child = tmptmp.right;
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
            Entry child = tmp.right;
            Entry futureParent = tmp.parent;
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
        return tmp.value;
    }

    public V mostConfirmedCases() {
        return getLargestEntry(root).value;
    }

    private Entry getLargestEntry(Entry entry) {
        if (entry.right == null) {
            return entry;
        }
        return getLargestEntry(entry.right);
    }

    public V lowestConfirmedCases() {
        return getLowestEntry(root).value;
    }

    private Entry getLowestEntry(Entry entry) {
        if (entry.left == null) {
            return entry;
        }
        return getLowestEntry(entry.left);
    }

    public boolean hasKey(K k) {
        return get(k) != null;
    }

    public V ceilingEntry(K key) {
        return ceiling(root, key).value;
    }

    private Entry ceiling(Entry root, K coming) {
        Entry ceil = null;
        while (root != null) {
            if (root.key.compareTo(coming) == 0) {
                ceil = root;
                return ceil;
            }

            if (coming.compareTo(root.key) > 0) {
                root = root.right;
            } else {
                ceil = root;
                root = root.left;
            }
        }
        return ceil;
    }

    public V flooringEntry(K key) {
        return flooring(root, key).value;
    }

    private Entry flooring(Entry root, K coming) {
        Entry floor = null;
        while (root != null) {
            if (root.key.compareTo(coming) == 0) {
                floor = root;
                return floor;
            }
            if (coming.compareTo(root.key) > 0) {
                floor = root;
                root = root.right;
            } else {
                root = root.left;
            }
        }
        return floor;
    }

    public ArrayList<V> getCountriesWithCasesHigherThan(K cases) {
        ArrayList<V> arrayList = new ArrayList<>();
        Iterator<K> iterator = new LevelOrderKeyIteratorStack();
        while (iterator.hasNext()) {
            K tmp = iterator.next();
            if (cases.compareTo(tmp) < 0) {
                arrayList.add(get(tmp));
            }
        }
        return arrayList;
    }

    @Override
    public Iterator<V> iterator() {
        return new LevelOrderIteratorStack();
    }

    private class LevelOrderIteratorStack implements Iterator<V> {
        Deque<Entry> shapesDeque;

        public LevelOrderIteratorStack() {
            if (root == null) {
                return;
            }
            shapesDeque = new ArrayDeque<>();
            shapesDeque.addFirst(root);
        }


        @Override
        public boolean hasNext() {
            return !shapesDeque.isEmpty();
        }

        @Override
        public V next() {
            Entry toReturn = shapesDeque.getFirst();
            shapesDeque.removeFirst();
            if (toReturn.left != null) {
                shapesDeque.addLast(toReturn.left);
            }
            if (toReturn.right != null) {
                shapesDeque.addLast(toReturn.right);
            }
            return toReturn.value;
        }
    }

    private class LevelOrderKeyIteratorStack implements Iterator<K> {
        Stack<Entry> shapesDeque;

        public LevelOrderKeyIteratorStack() {
            if (root == null) {
                return;
            }
            shapesDeque = new Stack<>();
            shapesDeque.push(root);
        }


        @Override
        public boolean hasNext() {
            return !shapesDeque.isEmpty();
        }

        @Override
        public K next() {
            Entry toReturn = shapesDeque.pop();
            if (toReturn.right != null) {
                shapesDeque.push(toReturn.right);
            }
            if (toReturn.left != null) {
                shapesDeque.push(toReturn.left);
            }
            return toReturn.key;
        }
    }
}
