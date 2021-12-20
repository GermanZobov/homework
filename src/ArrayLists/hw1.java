package ArrayLists;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.*;

public class hw1
{
    public static void main(String[] args)
    {
        Integer[] ints = {4,5,-6,4,5,3,4,2,4,5,7};
        //V1
        ArrayList<Integer> ar =  new ArrayList<>(Arrays.asList(ints));
        Collections.sort(ar);
        StringBuilder out = new StringBuilder();
        while (true){
            int first = ar.get(0);
            int count = 1;
            out.append(first);
            while (ar.lastIndexOf(first)!=0){
                count++;
                ar.remove(ar.lastIndexOf(first));
            }
            out.append(" - ");
            out.append(count);
            out.append("\n");
            ar.remove(0);
            if(ar.size()==0)break;
        }
        System.out.println(out);
//V2
        ArrayList<Integer> ar2 = new ArrayList<>(Arrays.asList(ints));
        ArrayList<Integer> check = new ArrayList<>();
        Collections.sort(ar2);
        for (int k:ar2) {
            if(check.contains(k))continue;
            System.out.println(k + " - " + Collections.frequency(ar2, k));
            check.add(k);
        }
    }



}

//Задание 1.
//Есть ArrayList<Integer> - ов. За один проход подсчитать количество повторений каждого элемента.
//Т.е., если мы имеем массив с элементами:
//4,5,-6,4,5,3,4,2,4,5,7
//То получим структуру:
//-6 – 1
//2 – 1
//3 – 1
//4 – 4
//5 – 3
//7 – 1
