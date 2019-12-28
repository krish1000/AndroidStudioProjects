package com.example.krish.kryptonote;

public class Crypto {

    private String key;
    public static final String ALPHABET = " ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public Crypto(String k)
    {
        this.key = k;
    }

    private String makePad(String note) {
        String pad = this.key;
        for (; pad.length() < note.length(); ) {
            pad += this.key;
        }
        return pad;
    }

    public String encrypt(String note) {
        String pad = makePad(note); // calls method makePad
        String result = ""; // intializes result
        for (int i = 0; i < note.length(); i++) // for loop
        {
            String c = note.substring(i, i + 1);
            int position = ALPHABET.indexOf(c);
            int shift = Integer.parseInt(pad.substring(i, i + 1));
            int newPosition = (position + shift) % ALPHABET.length();
            result = result + ALPHABET.substring(newPosition, newPosition + 1);
        }
        return result;
    }
    // decrypt would be the opposite

    public String decrypt(String note) {
        String pad = makePad(note); // calls method makePad
        String result = ""; // intializes result
        for (int i = 0; i < note.length(); i++) // for loop
        {
            String c = note.substring(i, i + 1); // changed
            int position = ALPHABET.indexOf(c);
            int shift = Integer.parseInt(pad.substring(i, i + 1)); // changed dis
            int newPosition = (position - shift) % ALPHABET.length();
            result = result + ALPHABET.substring(newPosition, newPosition + 1); // changed
        }
        return result;

        /*
              String pad=makePad(note);  //12341234
       String result="";         //empty encryption

       for(int i=0;i<note.length();i++)
       {
           String c=note.substring(i, i+1);

           int position=ALPHABET.indexOf(c); //

           int shift=Integer.parseInt(pad.substring(i, i+1));

           int newPosition = (position-shift);

           if(newPosition > ALPHABET.length())
           {
               newPosition -= ALPHABET.length();
           }
           else if(newPosition<0) {
               newPosition += ALPHABET.length();
           }
           result = result+ALPHABET.substring(newPosition, newPosition+1);
           }
           return result;
       }

         */
    }
}

/*
 /*
    public int calc(String m)
    {
        m = "ta";
        String s = "Toronto-Capital-Of-Ontario-Canada";
        String x = s.substring(3,s.length());
        return x.indexOf(m);
        //System.out.println(x.indexOf(m));
    }

    public static int palindroCount(int n) {
        int pAddition = 0;
        boolean isPal = false;
        do {
            String number = String.format("%d", n);
            for (int x = 0l x < number.length() / 2; x++) {
                if (number.charAt(x) != number.charAt(number.length() - (x + 1))) {
                    isPal = false;
                    break;
                } else {
                    isPal true;
                }
            }
            if (!isPal) // inverse number n
            {
                String inverse = "";
                for (int i = 0; i < number.length(); i++) {
                    inverse += number.charAt(number.length() - (i + 1));
                }
                n += Integer.parseInt(inverse);
                System.out.println(n);
                pAddition++;
            }
        } while (!isPal && pAddition <= 10);
        if (pAddition == 11) {
            pAddition = -1;
        }
        return pAddition;
    }



            }



        }





    }

    //public static int asdf = calc("ta");


    public static int pow3(int a, int b)
    {
        int result = -1;
        for (int i = a; i <= b && result == -1; i++)
        {
            int m = i;
            while (m % 3 == 0 && m > 1)
            {
                m = m /3;
                System.out.println("m");// sssssssssss
                if (m == 1){
                    result = i;}
            }

        }
    }


    public static int pow3(int a, int b)


    public static int pow3(int a, int b)
    {
        for(int i = al i <= b; i++)
        {
            double num = i;
            while(num>3){
                num = num/3;
                System.out.println(num);
            }
            if((int)num == 3){
                return i;
            }
        }
        return -1;

    }

    public static int triangle1(int a){


    }


    public static void main(String[] args) {

    String s = "Hello my name";
    System.out.println(s.substring(0,3));
    System.out.println(s.indexOf("my"));




         // use public static int calc, with this
        int asdf = calc("ta");
        System.out.println(asdf);



        String m = "ta";
        String s = "Toronto-Capital-Of-Ontario-Canada";
        String x = s.substring(3,s.length());
        System.out.println(x.indexOf(m));

        /////////////////////////////////////////////////////////////////
         QUESTION 4
        int m = 2;
        final int TOP = 3;
        int result = 10 + m;
        for (int i = 0; i < TOP; i++)
        {
            result++;
        }
        System.out.println(result);

        /////////////////////////////////////////////////////////////////

 */