package com.yyl.jvmconsole.service;

import java.io.*;
import java.util.Arrays;
import java.util.List;

/**
 * leapstack
 * author:yangyuanliang
 * Date:2019-05-21
 * Time:16:45
 **/
public class GcLog {
    public static  void testgc(){
        StringBuffer sb=new StringBuffer();
        try {
            Process jps = Runtime.getRuntime().exec("jstat -gcutil "+12284);
            BufferedReader input = new BufferedReader(new InputStreamReader(jps.getInputStream()));
           /* String line;
            int i=1;
            while ((line = input.readLine()) != null) {
                if(i==1){
                    i++;
                    continue;
                }
                String[] s = line.split("\\s");

                //if(s.length==1){

//                }
            }*/
            input.close();
            System.out.println(sb.toString());
            input.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        GcLog.testgc();
    }
}
