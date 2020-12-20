package Generic_ADTs.HashMap;

import java.util.ArrayList;
import java.util.Iterator;

public class GenericsHashMap<K, V> implements Iterable<V>, CustomIterators<V> {

    public static class Entry<K, V> {
        K key;
        V value;
        Entry<K, V> next;

        public Entry(K key, V value, Entry<K, V> next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    private final int capacity = 26;
    private int countriesCount;
    private final Entry<K, V>[] hashtable = new Entry[capacity];

    public GenericsHashMap() {
        countriesCount = 0;
        for (int i = 0; i < hashtable.length; i++) {
            hashtable[i] = null;
        }
    }

    private int hash(K key) {
        return key.toString().charAt(0) - 65;
    }

    public V put(K key, V val) {
        int index = hash(key);
        Entry<K, V> tmp = hashtable[index];

        while (tmp != null) {
            if (tmp.key.equals(key)) {
                V oldVal = tmp.value;
                tmp.value = val;
                return oldVal;
            }
            tmp = tmp.next;
        }
        hashtable[index] = new Entry(key, val, hashtable[index]);
        countriesCount++;
        return null;
    }

    public V get(K key) {
        int index = hash(key);
        Entry<K, V> tmp = hashtable[index];

        while (tmp != null) {
            if (tmp.key.equals(key)) {
                return tmp.value;
            }
            tmp = tmp.next;
        }
        return null;
    }

    public ArrayList<V> getValues() {
        ArrayList<V> arrl = new ArrayList<>();
        Iterator<V> itr = iterator();
        while (itr.hasNext()) {
            arrl.add(itr.next());
        }
        return arrl;
    }



    @Override
    public Iterator<V> iterator() {
        return new HashMapIterator();
    }

    private class HashMapIterator implements Iterator<V> {
        Entry<K, V> flag;

        public HashMapIterator() {
            flag = null;
            for (int i = 0; i < hashtable.length; i++) {
                if (hashtable[i] != null) {
                    flag = hashtable[i];
                    return;
                }
            }
        }

        @Override
        public boolean hasNext() {
            return flag != null;
        }

        @Override
        public V next() {
            V flagValue = flag.value;
            K flagKey = flag.key;
            int flagKeyHashed = hash(flagKey);
            if (flag.next != null) {
                flag = flag.next;
                return flagValue;
            }
            for (int i = flagKeyHashed + 1; i < hashtable.length; i++) {
                if (hashtable[i] != null) {
                    flag = hashtable[i];
                    return flagValue;
                }
            }
            flag = null;
            return flagValue;
        }
    }

    @Override
    public Iterator<V> levelOrderIterator() {
        return new LevelOrderIterator();
    }

    private class LevelOrderIterator implements Iterator<V> {
        Entry<K, V> flag;
        int stepIndex, cycleNumber;

        public LevelOrderIterator() {
            flag = null;
            for (int i = 0; i < hashtable.length; i++) {
                if (hashtable[i] != null) {
                    flag = hashtable[i];
                    stepIndex = cycleNumber = 0;
                    return;
                }
            }
        }

        @Override
        public boolean hasNext() {
            return flag != null;
            //return cycleNumber < countriesCount; This could work as well
        }

        @Override
        public V next() {
            //Check if it's the last element, then don't search for the next one, just return the current and exit
            if (cycleNumber == countriesCount - 1) {
                Entry<K, V> tmp = flag;
                flag = null;
                return tmp.value;
            }
            V flagValue = flag.value;
            K flagKey = flag.key;
            Entry<K, V> kvEntry;
            int index = hash(flagKey);
            for (int i = (index + 1) % hashtable.length; i < hashtable.length; i = (i + 1) % hashtable.length) {
                if (i == 0) {
                    stepIndex++;
                }
                if (hashtable[i] != null) {
                    kvEntry = hashtable[i];
                    for (int j = 0; j < stepIndex; j++) {
                        if (kvEntry == null) {
                            break;
                        }
                        kvEntry = kvEntry.next;
                    }
                    if (kvEntry != null) {
                        flag = kvEntry;
                        break;
                    }
                }
            }
            cycleNumber++;
            return flagValue;
        }
    }

}
