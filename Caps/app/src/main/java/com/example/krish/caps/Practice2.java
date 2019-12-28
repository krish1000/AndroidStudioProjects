package com.example.krish.caps;

import android.graphics.Point;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.regex.*;

public class Practice2 {

    public static int largestEven(Set<Integer> set) {
        int result = 0;

        for (int i : set) {
            // System.out.println(i);
            double x = i % 2;
            //System.out.println(x);
            if (x == 0.0) {
                result = i;
            }

        }
        return result;
    }

    public static double addprice(List<String> price) {
        double sum = 0;
        for (String i : price) {
            double x = Double.parseDouble(i);
            sum += x;
        }
        return sum;
    }

    //List<String>


    public static List<String> compare1(TreeMap<String, Integer> people) {
        String x = people.lastKey();

        List<String> names = new ArrayList<String>();

        Set<String> keys = people.keySet();

        for (String k : keys) {
            int w = people.get(k);
            if (w == people.get(x)) {
                names.add(k);
            }
        }

        return names;
    }



            /* // in the for loop
            if (x == k) {
                //names.add(people.values(k));
            }
            */


    /* toy car cat, 3:3etc , krish, 5:1
     */
    public static List<Integer> addthing(Set<Integer> numbers, Integer sumnum) {
        List<Integer> twoNums = new ArrayList<Integer>();
        for (int k : numbers) {
            int x = k;
            for (int i : numbers) {
                int newSum = i + x;
                if (newSum == sumnum) {
                    twoNums.add(x);
                    twoNums.add(i);
                    return twoNums;
                }
            }

        }
        return twoNums;
    }


    /*
            Set<Integer> x = new TreeSet<Integer>();
        x.add(1);
        x.add(3);
        x.add(2);
        x.add(6);
        x.add(10);
        x.add(123123);
        x.add(86);

        System.out.println(largestEven(x));
     */

    /*
    public static boolean hasThisValue(Map<Date, Point> map, Point p) {
        boolean result = false;
        for (Iterator itr = map.keySet().iterator(); itr.hasNext() && !result; ) {
            Date k = itr.next();
            Point v = map.get(k);
            result = v.equals(p);
        }
        return result;
    }
    */

    /*
    public static boolean areDistinct(Map<Integer,String> map)
    {
        boolean result = true;

        for(int k : map.keySet())
        {
            String x = map.get(k).toLowerCase();
            for(int i : map.keySet()) {
                if (x == map.get(i).toLowerCase())
                {
                    if(x.compareTo(map.get(i)) == 1)
                    {
                        result = false;
                        return result;
                    }
                }
            }
        }
        return result;
    }
*/
    public static boolean areDistinct(Map<String, Integer> map) //ex 4
    {
        boolean result;
        Set<Integer> newset = new TreeSet<Integer>();
        for (String k : map.keySet()) {
            newset.add(map.get(k));
        }
        if (map.size() == newset.size()) {
            result = true;
        } else {
            result = false;
        }
        System.out.println(newset);

        return result;
    }

    public static List<Integer> mostOccuring(List<Integer> bag) { //Ex7
        String list1 = bag.toString();
        List<Integer> newlist = new ArrayList<Integer>();
        int most = 0;

        for (int k : bag) {
            //int x = bag.get(k);
            //System.out.println(k);
            int occuring = Collections.frequency(bag, k);
            if (occuring > most & !newlist.contains(k)) {
                newlist.clear();
                most = occuring;
                newlist.add(k);
            } else if (occuring == most & !newlist.contains(k)) {
                newlist.add(k);
            }
        }
        return newlist;
    }

    public static int largest(Set<Integer> set) // ex 2
    {
        List<Integer> newlist = new ArrayList<Integer>(set);
        int max = newlist.get(newlist.size() - 1);
        return max;
    }

    public static void allButLast(List<String> list) // ex 1
    {

        int size = list.size();
        String finalelement = list.get(size - 1);
        list.clear();
        list.add(finalelement);

        /* // lesters way
        for(int i = list.size() -2; i +1>0; i--)
        {
            list.remove(i);
        }
        */
    }

    public static void largestValue(Map<String, Double> map) //ex 4
    {
        double max = 0;
        for(String i: map.keySet())
        {

            if(map.get(i)> max)
            {
                max = map.get(i);
            }
        }
        System.out.println(max);

    }
    /*
    public static Map<String, Date> latestByWeekday(list<Date> list)
    {

    }*/

    public static double sumPrice1(List<String> list)
    {
        double sum = 0;
        int size = list.size();
        String regex = "[$]([0-9]+[.][0-9]?[0-9]?)";

        for (int i = 0; i <size ; i++)
        {
            String s = list.get(i);
            System.out.println(s);
            //String[] splitter = s.split(regex);
            Pattern pattern = Pattern.compile(regex);

            Matcher matcher = pattern.matcher(s);
            if (matcher.find())
            {
                System.out.println(matcher.group(1));
                sum += Double.parseDouble(matcher.group(1));
            }
        }
        return sum;
    }

    public static void sortByLength(List<String> list) {
        List<String> orderlist1 = new ArrayList<String>();
        Map<String, Integer> map1 = new TreeMap<String, Integer>();
        List<Integer> orderlength = new ArrayList<Integer>();


        for (String k : list) {
            map1.put(k, k.length());
        }
        for (String k : map1.keySet()) {
            orderlength.add(map1.get(k));
        }
        Collections.sort(orderlength);

        for (int k : orderlength) {
            for (String i : map1.keySet()) {
                if (i.length() == k) {
                    orderlist1.add(i);
                }
            }
        }
        System.out.println(orderlist1);
    }


    public static void main(String[] args) {
        List<String> list1 = new ArrayList<String>();
        list1.add("many");
        list1.add("Bravo");
        list1.add("December");
        list1.add("Non");
        list1.add("If");


        sortByLength(list1);



    }

    /*
     List<String> list = new ArrayList<String>();
        String[] otherlist = new String[]{"Lemon is $1.5", "Apple is $3.0", "Banana is $5.5", "Meatball is $6.5"};
        list.addAll(Arrays.asList(otherlist));

        System.out.println(sumPrice1(list));

     */


    /*

    public static List<String> oldAge(Map<String, Integer> map)
    {
        List<String> oldest = new ArrayList<String>();

        for(String k : map.keySet())
        {
            int max = 0;
            if(map.get(k) > max)
            {
                max = map.get(k)
            } else if (map.get(k) == max & notequals)
            {

            }
        }
    }

     */
}
/* /ex 4
 Map<String, Double> map1 = new TreeMap<>();
    map1.put("hello", 2.3);
    map1.put("asdf", 312.2);
    map1.put("s", -1223.3);

    largestValue(map1);
 */
/*
    List<String> newlist = new ArrayList<String>();
        String[] otherlist = new String[]{"hi", "yeet", "asdf", "finalcount"};
        newlist.addAll(Arrays.asList(otherlist));

        allButLast(newlist);
        System.out.println(newlist);
 */
/*
    Set<Integer> newset = new TreeSet<Integer>();
        newset.add(1);
        newset.add(4);
        newset.add(123);
        newset.add(-2);

        System.out.println(largest(newset));
 */

        /* //ex 7
        List<Integer> newlist = new ArrayList<Integer>();
        Integer[] otherlist = new Integer[]{1, 2, 3, 4, 5, 2, 6, 7, 8, 12, 12, 12, 2, 13};
        newlist.addAll(Arrays.asList(otherlist));

        System.out.println(mostOccuring(newlist));
        */

/* // ex 4
Map<String, Integer> newmap = new TreeMap<String, Integer>();
        newmap.put("hello",132);
        newmap.put("asdf",213);
        newmap.put("hola", 23);
        newmap.put("test", 23);

        System.out.println(areDistinct(newmap));
        //System.out.println(newmap.keySet().size());
        //System.out.println(newmap.size());
 */
/* public static void main(String[] args) {

        Set<String> set2 = new TreeSet<String>();
        set2 = null;
        System.out.println(set2);
        System.out.println("----------------------------");


        Set<Integer> s = new TreeSet<Integer>();
        s.add(2);
        s.add(5324);
        s.add(4);
        s.add(23);
        s.add(1);
        s.add(20);
        System.out.println(addthing(s, 24));

        //-------------------------------------------------
        System.out.println("----------------------------------------");
        TreeMap<String, Integer> x = new TreeMap<String, Integer>(); //for some reason Map doesnt work
        x.put("banana", 43);
        x.put("hello", 43);
        x.put("asdf", 12);
        x.put("adsfs3", 31);

        System.out.println(compare1(x));
        System.out.println("----------------------------------------");
        List<Integer> list = new ArrayList<Integer>();
        int c = 3;
        int n = 6;
        list.add(4);
        list.add(c);
        list.add(list.size() - 2, n);
        System.out.println(list.get(1));


        //------------------------------------------------------------
        //System.out.println(((TreeMap<Integer, String>) x).lastKey());

        List<String> x = new ArrayList<String>();
        x.add("1.5");
        x.add("2.14");
        x.add("2.01");

        System.out.println("$" + addprice(x));


        System.out.println("---------------------------------------");
                Map<Integer, String> dist  = new TreeMap<Integer,String>();
        dist.put(1, "pineapple");
        dist.put(2, "asdf");
        dist.put(3, "pine");
        dist.put(4, "Oof");
        dist.put(5,"Oof");
        System.out.println(areDistinct(dist));
        }

 */
