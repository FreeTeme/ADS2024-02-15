package by.it.group351001.pavlov.lesson09;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;


public class ListA<E> implements List<E> {

    private static int incrrementSize = 10;
    private int currSize = 0;
    private E[] mas = (E[])new Object[0];

    //Создайте аналог списка БЕЗ использования других классов СТАНДАРТНОЙ БИБЛИОТЕКИ

    /////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////
    //////               Обязательные к реализации методы             ///////
    /////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////

    public String toString() {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < currSize; i++) {
            str.append(mas[i] + ", ");
        }

        String ans = str.toString();

        if (ans.length() > 0)
        {
            ans = ans.substring(0,ans.length() - 2);
        }

        return "[" + ans + "]";
    }

    @Override
    public boolean add(E e) {
        int index = currSize;
        if (currSize == mas.length)
        {
            var tempMas = mas;
            mas = (E[]) new  Object[currSize + incrrementSize];

            for (int i = 0; i < currSize; i++) {
                mas[i] = tempMas[i];
            }

        }

        mas[index] = e;
        currSize++;

        return 1 == 1;
    }

    @Override
    public E remove(int index) {
        if (index >= currSize || index < 0) return null;

        var tempMas = mas;

        E result = mas[index];

        for (int i = index + 1; i < currSize; i++) {
            mas[i - 1] = tempMas[i];
        }

        currSize--;
        return  result;
    }

    @Override
    public int size() {
        return  currSize;
    }

    /////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////
    //////               Опциональные к реализации методы             ///////
    /////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////

    @Override
    public void add(int index, E element) {

    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public E set(int index, E element) {
        return null;
    }


    @Override
    public boolean isEmpty() {
        return false;
    }


    @Override
    public void clear() {

    }

    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public E get(int index) {
        return null;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }


    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        return null;
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        return null;
    }

    @Override
    public ListIterator<E> listIterator() {
        return null;
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    /////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////
    ////////        Эти методы имплементировать необязательно    ////////////
    ////////        но они будут нужны для корректной отладки    ////////////
    /////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////
    @Override
    public Iterator<E> iterator() {
        return null;
    }

}
