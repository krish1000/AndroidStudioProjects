package com.example.krish.caps;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Practice {

    // Given a list of n-1 _distinct_ integers all of them are
    // in [1,n]. Which integer in [1,n] is missing?
    // Complexity (N^2)
    public static int missing1(List<Integer> list)
    {
        int result = 0;
        int n = list.size() + 1;
        for (int i = 1; (i <= n) && (result==0); i++)
        {
            if (!list.contains(i))
            {
                result = i;
            }
        }
        return result;
    }

    // Same but sort first to benefit from order.
    // Complexity O(NlgN)
    public static int missing2(List<Integer> list)
    {
        Collections.sort(list);
        int result = 0;
        int count = 0;
        for (int i : list)
        {
            count++;
            if (count != i)
            {
                result = count;
            }
        }
        // check if missing is n (see forum at:
        // https://moodle.yorku.ca/moodle/mod/forum/discuss.php?d=1173252
        return result;
    }

    // Same but benefit from aithmetic series sum
    // This works as-is for sets and lists
    // Complexity O(N)
    public static int missing3(List<Integer> list)
    {
        int n = list.size() + 1;
        int math = n*(n+1) / 2;
        int sum = 0;
        for (int k : list)
        {
            sum += k;
        }
        int result = math - sum;
        return result;
    }

    public static void main(String[] args) {
        /*
        List<String> list123 = new ArrayList<String>();
        list123.add("hello");
        System.out.println(missing1(list123));
        System.out.println(missing1(12));
        System.out.println(missing1(12));
        */

        //List mylist = new ArrayList();
        List<String> mylist = new ArrayList<String>();

        mylist.add("oppai");
        mylist.add("daiski");
        mylist.add("hola");

        //mylist.add(new Integer(3));
        mylist.remove(2);
        //mylist.clear();

        //Object o mylist.get(0);
        //String o mylist.get(0);
        //String firstObject = (String) mylist.get(0);
        //System.out.println((int) mylist.get(2));
        String firstObject = mylist.get(0);

        int size = mylist.size();

       // System.out.println(firstObject);

        //Iterator iterator1 = mylist.iterator();
        Iterator<String> iterator1 = mylist.iterator();
        while(iterator1.hasNext()){
            //Object next = iterator1.next();
            String next = iterator1.next();
            System.out.println(next);
        }

        //for(Object next : mylist) {
        for (String next : mylist)
        {
            System.out.println(next);
        }

        for (int i=0; i < mylist.size(); i++){
            //Object next = mylist.get(i);
            String next = mylist.get(i);

            System.out.println(next);
        }

        System.out.println("--------------------------------------");

        List<String> bag = new ArrayList<String>();
        bag.add("yeeetyaw");
        bag.add("yeetyawdab2");
        bag.add("noodles");
        System.out.println(bag.get(2) + " hola");
        bag.remove(2);
        for(int position = 0; position < bag.size(); position++)
        {
            String e = bag.get(position);
            System.out.println(e);
        }
        System.out.println("--------------------------------------");
        //fast boi loop n^2
        for(String asdfads: bag)
        {
            System.out.println(asdfads);
        }
        System.out.println("--------------------------------------");
        boolean x = addIfNew(bag, "OOF");
        System.out.println(x); //if true then it adds
        System.out.println(bag.get(bag.size() - 1));
        System.out.println(addIfNew(bag, "yeeetyaw"));

        System.out.println("--------------------------------------");
        //List<String> bag = new ArrayList<String>();
        List<Integer> bagnum1 = new ArrayList<>();
        bagnum1.add(1);

    }
    public static boolean addIfNew(List<String> bag, String s)
    {
        //boolean x = true;
        boolean result = !bag.contains(s);
        if (result)
        {
            bag.add(s);
        }
        return result;
    }

    public static Set<Integer> removeDUP(List<Integer> listofDOOM)
    {
        Set<Integer> result = new TreeSet<Integer>();
        for(Integer asdf : listofDOOM)
        {
            result.add(asdf);
        }
        return result;
    }



}
