package com.PutawanDE.OOP_Lab08;

import java.lang.reflect.Array;
import java.util.*;

public class SetFromHashmap<E> implements Set<E> {
    private Map<E, Object> map = new HashMap<>();

    private static final Object DUMMY = new Object();

    @Override
    public int size() {
        return map.size();
    }

    @Override
    public boolean isEmpty() {
        return map.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return map.containsKey(o);
    }

    @Override
    public Iterator iterator() {
        return map.keySet().iterator();
    }

    @Override
    public Object[] toArray() {
        return map.keySet().toArray();
    }

    @Override
    public <T> T[] toArray(T[] a) {
        int size = size();
        T[] tmp = a.length >= size ? a
                : (T[]) Array.newInstance(a.getClass().getComponentType(), size);

        Iterator it = iterator();

        for (int i = 0; i < a.length; i++) {
            if (!it.hasNext()) {
                tmp[i] = null;
            } else {
                tmp[i] = (T) it.next();
            }
        }

        System.arraycopy(tmp, 0, a, 0, tmp.length);
        return a;
    }

    @Override
    public boolean add(E e) {
        return map.put(e, DUMMY) == null;
    }

    @Override
    public boolean remove(Object o) {
        return map.remove(o) != null;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        boolean changed = false;
        for (E e : c) {
            if (add(e)) changed = true;
        }
        return changed;
    }

    @Override
    public void clear() {
        map.clear();
    }

    @Override
    public boolean removeAll(Collection c) {
        boolean changed = false;
        for (Object o : c) {
            if (remove(o)) changed = true;
        }
        return changed;
    }

    @Override
    public boolean retainAll(Collection c) {
        return map.keySet().removeIf(o -> !c.contains(o));
    }

    @Override
    public boolean containsAll(Collection c) {
        for (Object o : c) {
            if (!map.containsKey(o)) return false;
        }
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SetFromHashmap)) {
            return false;
        }

        Collection<?> c = (Collection<?>) o;
        if (size() != c.size()) {
            return false;
        } else {
            return containsAll(c);
        }
    }

    @Override
    public int hashCode() {
        return map.keySet().hashCode();
    }

    public static <E> Comparator<Set<E>> setComparator(Comparator<E> cmp) {
        // Compare set using size. Smaller set comes first. If equal size, then use cmp to compare
        return new Comparator<Set<E>>() {
            @Override
            public int compare(Set<E> o1, Set<E> o2) {

                if (o1.size() == o2.size()) {
                    int r1 = 0;
                    int r2 = 0;
                    Iterator<E> it1 = o1.iterator();
                    Iterator<E> it2 = o2.iterator();

                    while (it1.hasNext()) {
                        E e1 = it1.next();
                        E e2 = it2.next();

                        r1 = cmp.compare(e1, e2);
                        r2 = cmp.compare(e2, e1);
                    }

                    return r1 - r2;
                } else {
                    return o1.size() - o2.size();
                }
            }
        };
    }
}
