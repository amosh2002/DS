package Utils;

import Generic_ADTs.GenericsList;
import Shape_and_subclasses.Describable;

import java.util.Iterator;

public class CustomSortingAlgorithms {
    public static <L extends GenericsList<T>, T extends Describable & Comparable<T> & Cloneable> void selectionSort(L tList) {
        Iterator<T> iterator = tList.iterator();
        int ind = 0;
        while (iterator.hasNext()) {
            Iterator<T> startIndexIterator = tList.startIndexIterator(ind);
            T smallest = startIndexIterator.next();
            T forChecking = smallest;
            while (startIndexIterator.hasNext()) {
                T cur = startIndexIterator.next();
                if (smallest.compareTo(cur) > 0) {
                    smallest = cur;
                }
            }
            if (forChecking.equals(smallest)) {
                iterator.next();
                ind++;
                continue;
            }
            int smallestsIndex = tList.indexOf(smallest);
            T cur = tList.getElementAt(ind);
            tList.changeValueAt(ind, smallest);
            tList.changeValueAt(smallestsIndex, cur);
            iterator.next();
            ind++;
        }


    }

    public static <L extends GenericsList<T>, T extends Describable & Comparable<T> & Cloneable> void insertionSort(L tList) {
        Iterator<T> iterator = tList.iterator();
        T cur;
        while (iterator.hasNext()) {
            cur = iterator.next();
            int ind = tList.indexOf(cur);
            Iterator<T> reverseEndIndexIterator = tList.reverseEndIndexIterator(ind);
            int indd = ind;
            while (reverseEndIndexIterator.hasNext()) {
                T revCur = reverseEndIndexIterator.next();
                if (revCur.compareTo(cur) > 0) {
                    int revCurIndex = tList.indexOf(revCur);
                    tList.changeValueAt(revCurIndex, cur);
                    tList.changeValueAt(indd--, revCur);
                }
            }
            tList.changeValueAt(indd, cur);

        }

    }

    public static <L extends GenericsList<T>, T extends Describable & Comparable<T> & Cloneable> void bubbleSort(L tList) {
        Iterator<T> iterator = tList.iterator();
        T cur;
        boolean swapped;
        while (iterator.hasNext()) {
            swapped = false;
            cur = iterator.next();
            int ind = tList.indexOf(cur);
            Iterator<T> endIndexIterator = tList.endIndexIterator(tList.size() - ind - 1);
            while (endIndexIterator.hasNext()) {
                T curr = endIndexIterator.next();
                int indd = tList.indexOf(curr);
                int inddd = indd + 1;
                if (curr.compareTo(tList.getElementAt(inddd)) > 0) {
                    tList.changeValueAt(indd, tList.getElementAt(inddd));
                    tList.changeValueAt(inddd, curr);
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
        }
    }

    public static <L extends GenericsList<T>, T extends Describable & Comparable<T> & Cloneable> void selectionSortRecursive(L tList) {
        helperSS(tList, 0);
    }

    public static <L extends GenericsList<T>, T extends Describable & Comparable<T> & Cloneable> void insertionSortRecursive(L tList) {
        helperIS(tList, 0);
    }

    public static <L extends GenericsList<T>, T extends Describable & Comparable<T> & Cloneable> void bubbleSortRecursive(L tList) {
        helperBS(tList, 0);
    }

    //These are the functions that actually complete the Recursive sorting algorithms process
    private static <L extends GenericsList<T>, T extends Describable & Comparable<T> & Cloneable> void helperSS(L tList, int ind) {
        if (tList.size() == ind) {
            return;
        }
        Iterator<T> startIndexIterator = tList.startIndexIterator(ind);
        T smallest = startIndexIterator.next();
        T forChecking = smallest;
        while (startIndexIterator.hasNext()) {
            T cur = startIndexIterator.next();
            if (smallest.compareTo(cur) > 0) {
                smallest = cur;
            }
        }
        if (forChecking.equals(smallest)) {
            helperSS(tList, ind + 1);
        }
        int smallestsIndex = tList.indexOf(smallest);
        T cur = tList.getElementAt(ind);
        tList.changeValueAt(ind, smallest);
        tList.changeValueAt(smallestsIndex, cur);
        helperSS(tList, ind + 1);
    }

    private static <L extends GenericsList<T>, T extends Describable & Comparable<T> & Cloneable> void helperIS(L tList, int ind) {
        if (tList.size() == ind) {
            return;
        }
        T cur = tList.getElementAt(ind);
        Iterator<T> reverseEndIndexIterator = tList.reverseEndIndexIterator(ind);
        int indd = ind;
        while (reverseEndIndexIterator.hasNext()) {
            T revCur = reverseEndIndexIterator.next();
            if (revCur.compareTo(cur) > 0) {
                int revCurIndex = tList.indexOf(revCur);
                tList.changeValueAt(revCurIndex, cur);
                tList.changeValueAt(indd--, revCur);
            }
        }
        tList.changeValueAt(indd, cur);
        helperIS(tList, ind + 1);
    }

    private static <L extends GenericsList<T>, T extends Describable & Comparable<T> & Cloneable> void helperBS(L tList, int ind) {
        if (tList.size() == ind) {
            return;
        }
        boolean swapped;
        swapped = false;
        Iterator<T> endIndexIterator = tList.endIndexIterator(tList.size() - ind - 1);
        while (endIndexIterator.hasNext()) {
            T curr = endIndexIterator.next();
            int indd = tList.indexOf(curr);
            int inddd = indd + 1;
            if (curr.compareTo(tList.getElementAt(inddd)) > 0) {
                tList.changeValueAt(indd, tList.getElementAt(inddd));
                tList.changeValueAt(inddd, curr);
                swapped = true;
            }
        }
        if (!swapped) {
            return;
        }
        helperBS(tList, ind + 1);
    }
}
