package Homework3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class CountriesHashMap<K, V> implements Iterable<V>, CustomIterators<V> {

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

    public CountriesHashMap() {
        countriesCount = 0;
        for (int i = 0; i < hashtable.length; i++) {
            hashtable[i] = null;
        }
    }

    private int hash(K key) {
        return key.toString().charAt(0) - 65;
    }

    public int size() {
        int count = 0;
        for (int i = 0; i < capacity; i++) {
            if (hashtable[i] != null) {
                count++;
            }
        }
        return count;

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
        hashtable[index] = new Entry<>(key, val, hashtable[index]);
        countriesCount++;
        return val;
    }

    public V getValue(K key) {
        Entry<K, V> tmp = hashtable[hash(key)];
        while (tmp != null) {
            if (tmp.key.equals(key)) {
                return tmp.value;
            }
            tmp = tmp.next;
        }
        return null;
    }

    public K getKey(V value) {
        Iterator<Entry<K, V>> itr = iteratorEntries();
        while (itr.hasNext()) {
            Entry<K, V> cur = itr.next();
            if (cur.equals(value)) {
                return cur.key;
            }
        }
        return null;
    }

    private Entry<K, V> getEntryByKey(K key) {
        int index = hash(key);
        Entry<K, V> tmp = hashtable[index];

        while (tmp != null) {
            if (tmp.key.equals(key)) {
                return tmp;
            }
            tmp = tmp.next;
        }
        return null;
    }

    private Entry<K, V> getEntryBeforeTheSpecifiedKey(K key) {
        int index = hash(key);
        Entry<K, V> tmp = hashtable[index];
        Entry<K, V> tmp2 = null;

        while (tmp != null) {
            if (tmp.key.equals(key)) {
                return tmp2;
            }
            tmp2 = tmp;
            tmp = tmp.next;
        }
        return null;
    }

    public boolean removeByKey(K key) {
        Entry<K, V> toBeRemoved = getEntryByKey(key);
        if (toBeRemoved == null) {
            return false;
        }
        Entry<K, V> beforeToBeRemoved = getEntryBeforeTheSpecifiedKey(key);
        if (beforeToBeRemoved == null) {
            int hash = hash(key);
            hashtable[hash] = null;
            return true;
        }
        beforeToBeRemoved.next = toBeRemoved.next;
        toBeRemoved.next = null;
        return true;
    }

    public boolean replaceTheValue(K key, V value) {
        Entry<K, V> toBeReplaced = getEntryByKey(key);
        if (toBeReplaced != null) {
            toBeReplaced.value = value;
            return true;
        }
        return false;
    }

    public void putIfAbsent(K key, V value) {
        if (getValue(key) != null) {
            return;
        }
        put(key, value);
    }

    public void clear() {
        Arrays.fill(hashtable, null);
    }

    public boolean isEmpty() {
        for (Entry<K, V> kvEntry : hashtable) {
            if (kvEntry != null) {
                return true;
            }
        }
        return false;
    }

    public ArrayList<V> getAllValues() {
        ArrayList<V> list = new ArrayList<>();
        for (V v : this) {
            list.add(v);
        }
        return list;
    }

    public ArrayList<K> getAllKeys() {
        ArrayList<K> arrl = new ArrayList<>();
        Iterator<K> itr = iteratorKeys();
        while (itr.hasNext()) {
            arrl.add(itr.next());
        }
        return arrl;
    }

    public boolean containsKey(K key) {
        return getValue(key) != null;
    }

    public boolean containsValue(V value) {
        return getKey(value) != null;
    }


    @Override
    public Iterator<V> iterator() {
        return new HashMapIterator();
    }

    public Iterator<K> iteratorKeys() {
        return new HashMapKeyIterator();
    }

    public Iterator<Entry<K, V>> iteratorEntries() {
        return new HashMapEntryIterator();
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

    private class HashMapKeyIterator implements Iterator<K> {
        Entry<K, V> flag;

        public HashMapKeyIterator() {
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
        public K next() {
            K flagKeyToReturn = flag.key;
            K flagKey = flag.key;
            int flagKeyHashed = hash(flagKey);
            if (flag.next != null) {
                flag = flag.next;
                return flagKeyToReturn;
            }
            for (int i = flagKeyHashed + 1; i < hashtable.length; i++) {
                if (hashtable[i] != null) {
                    flag = hashtable[i];
                    return flagKeyToReturn;
                }
            }
            flag = null;
            return flagKeyToReturn;
        }
    }

    private class HashMapEntryIterator implements Iterator<Entry<K, V>> {
        Entry<K, V> flag;

        public HashMapEntryIterator() {
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
        public Entry<K, V> next() {
            Entry<K, V> toReturn = flag;
            K flagKey = flag.key;
            int flagKeyHashed = hash(flagKey);
            if (flag.next != null) {
                flag = flag.next;
                return toReturn;
            }
            for (int i = flagKeyHashed + 1; i < hashtable.length; i++) {
                if (hashtable[i] != null) {
                    flag = hashtable[i];
                    return toReturn;
                }
            }
            flag = null;
            return toReturn;
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
