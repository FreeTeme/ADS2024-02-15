package by.it.group351003.zhuravski.lesson05;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.LinkedList;
import java.util.Scanner;

/*
Видеорегистраторы и площадь.
На площади установлена одна или несколько камер.
Известны данные о том, когда каждая из них включалась и выключалась (отрезки работы)
Известен список событий на площади (время начала каждого события).
Вам необходимо определить для каждого события сколько камер его записали.

В первой строке задано два целых числа:
    число включений камер (отрезки) 1<=n<=50000
    число событий (точки) 1<=m<=50000.

Следующие n строк содержат по два целых числа ai и bi (ai<=bi) -
координаты концов отрезков (время работы одной какой-то камеры).
Последняя строка содержит m целых чисел - координаты точек.
Все координаты не превышают 10E8 по модулю (!).

Точка считается принадлежащей отрезку, если она находится внутри него или на границе.

Для каждой точки в порядке их появления во вводе выведите,
скольким отрезкам она принадлежит.
    Sample Input:
    2 3
    0 5
    7 10
    1 6 11
    Sample Output:
    1 0 0

*/

public class A_QSort {

    //отрезок
    private class Segment  implements Comparable<Segment>{
        int start;
        int stop;

        Segment(int start, int stop){
            this.start = start;
            this.stop = stop;
            //тут вообще-то лучше доделать конструктор на случай если
            //концы отрезков придут в обратном порядке
        }

        @Override
        public int compareTo(Segment o) {
            //подумайте, что должен возвращать компаратор отрезков

            return start - o.start;
        }
    }
    void sortElems(LinkedList<Segment> arr) {
        if (arr.size() > 1) {
            LinkedList<Segment> equal = new LinkedList<>();
            LinkedList<Segment> bigger = new LinkedList<>();
            LinkedList<Segment> smaller = new LinkedList<>();
            equal.add(arr.removeFirst());
            Segment compSegm = equal.getFirst();
            while (!arr.isEmpty()) {
                int diff = compSegm.compareTo(arr.getFirst());
                if (diff > 0) {
                    smaller.add(arr.removeFirst());
                }
                else if (diff < 0) {
                    bigger.add(arr.removeFirst());
                }
                else {
                    equal.add(arr.removeFirst());
                }
            }
            sortElems(bigger);
            sortElems(smaller);
            arr.addAll(smaller);
            arr.addAll(equal);
            arr.addAll(bigger);
        }
    }

    int[] getAccessory(InputStream stream) throws FileNotFoundException {
        //подготовка к чтению данных
        Scanner scanner = new Scanner(stream);
        //!!!!!!!!!!!!!!!!!!!!!!!!!     НАЧАЛО ЗАДАЧИ     !!!!!!!!!!!!!!!!!!!!!!!!!
        //число отрезков отсортированного массива
        int n = scanner.nextInt();
        Segment[] segments=new Segment[n];
        //число точек
        int m = scanner.nextInt();
        int[] points=new int[m];
        int[] result=new int[m];//

        //читаем сами отрезки
        LinkedList<Segment> arr = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            //читаем начало и конец каждого отрезка
            //segments[i]=new Segment(scanner.nextInt(),scanner.nextInt());
            arr.add(new Segment(scanner.nextInt(), scanner.nextInt()));
        }
        //читаем точки
        for (int i = 0; i < m; i++) {
            points[i]=scanner.nextInt();
        }
        //тут реализуйте логику задачи с применением быстрой сортировки
        //в классе отрезка Segment реализуйте нужный для этой задачи компаратор
        sortElems(arr);
        for (int i = 0; i < m; i++) {
            int freq = 0;
            for (int j = 0; (j < n) && (arr.get(j).start <= points[i]); j++) {
                if (arr.get(j).stop >= points[i]) {
                    freq++;
                }
            }
            result[i]=freq;
        }



        //!!!!!!!!!!!!!!!!!!!!!!!!!     КОНЕЦ ЗАДАЧИ     !!!!!!!!!!!!!!!!!!!!!!!!!
        return result;
    }


    public static void main(String[] args) throws FileNotFoundException {
        String root = System.getProperty("user.dir") + "/src/";
        InputStream stream = new FileInputStream(root + "by/it/a_khmelev/lesson05/dataA.txt");
        A_QSort instance = new A_QSort();
        int[] result=instance.getAccessory(stream);
        for (int index:result){
            System.out.print(index+" ");
        }
    }

}