package com.lovejazzie;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.StreamTokenizer;
import java.util.Scanner;

/**
 * Created by Administrator on 2016/3/27.
 */
public class ccc {
    public static void main(String args[]) throws IOException {

//        Scanner s = new Scanner(System.in);
        StreamTokenizer s = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        int N = 0;
        s.nextToken();
        N = (int) s.nval;
//        System.out.println(N);
        int[] a = new int[N];
        int begin_index = 0;
        int sum = 0;
        int sumMax = 0;
        boolean is = false;
        int first = 0;
        int cach = 0;
        int last = 0;

        for (int i = 0; i < N; i++) {
            //                s.nextToken();
            s.nextToken();
            a[i] = (int) s.nval;
//            s.pushBack();

//        long sta = System.nanoTime();

            if (a[i] > 0) {
                begin_index = i;
                for (int j = begin_index; j < a.length; j++) {
                    if (j + 1 < a.length) {
                        s.nextToken();
                        a[j + 1] = (int) s.nval;
                    }
//                        s.nextToken();


                    sum += a[j];
                    if (sum > sumMax) {
                        if (cach >= 0 | first == 0) first = a[j - cach];
                        last = a[j];
                        sumMax = sum;
                        cach = -1;
                    } else if (sum < 0) {
                        sum = 0;
                        if (first != 0)
                            cach = 0;

                    } else if (sum >= 0) {
                        if (first != 0 && cach >= 0) {
                            cach++;
                        }
                    }
                    if (j == a.length - 1) {
                        i = a.length;
                    }
                }
            } else if (i < a.length) {
                if (a[i] == 0)
                    is = true;
            }
            if (i == a.length - 1) {
                if (is) {
                    System.out.println(0 + " " + 0 + " " + 0);
                } else
                    System.out.println(0 + " " + a[0] + " " + a[a.length - 1]);
                return;
            }
        }


        System.out.println(sumMax + " " + first + " " + last);
//        long end = System.nanoTime();
//        System.out.println(end-sta);

    }
}
