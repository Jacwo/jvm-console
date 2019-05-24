package com.yyl.jvmconsole.service.impl;

import com.yyl.jvmconsole.model.GCinfo;
import com.yyl.jvmconsole.model.Procezz;
import com.yyl.jvmconsole.service.IProcessService;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * leapstack
 * author:yangyuanliang
 * Date:2019-05-21
 * Time:17:10
 **/
@Service
public class ProcessServiceImpl implements IProcessService {

    @Override
    public List<Procezz> getAllProcess() {
        List<Procezz> procezzes=new ArrayList<>();
        try {
            Process jps = Runtime.getRuntime().exec("jps");
            BufferedReader input = new BufferedReader(new InputStreamReader(jps.getInputStream()));
           // PrintWriter output = new PrintWriter(new OutputStreamWriter(jps.getOutputStream()));
            String line;
            while ((line = input.readLine()) != null) {
                String[] s = line.split(" ");
                if(s.length==2){
                    Procezz procezz=new Procezz();
                    procezz.setPid(Integer.parseInt(s[0]));
                    procezz.setProname(s[1]);
                    procezzes.add(procezz);
                }
            }
            input.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return procezzes;
    }

    @Override
    public GCinfo getGCinfoByPid(String pid) {
        GCinfo gCinfo=new GCinfo();

        try {
            Process jps = Runtime.getRuntime().exec("jstat -gcutil "+pid);
            BufferedReader input = new BufferedReader(new InputStreamReader(jps.getInputStream()));
            String line;
            int i=1;
            while ((line = input.readLine()) != null) {
                if(i==1){
                    i++;
                    continue;
                }
                String[] s = line.split("\\s");
                List<String> list=new ArrayList<>();
                for (String ss:s){
                    if("".equals(ss)){
                        continue;
                    }
                    list.add(ss);
                }
                gCinfo.setS0(list.get(0));
                gCinfo.setS1(list.get(1));
                gCinfo.setE(list.get(2));
                gCinfo.setO(list.get(3));
                gCinfo.setM(list.get(4));
                gCinfo.setCCS(list.get(5));
                gCinfo.setYGC(list.get(6));
                gCinfo.setYGCT(list.get(7));
                gCinfo.setFGC(list.get(8));
                gCinfo.setFGCT(list.get(9));
                gCinfo.setGCT(list.get(10));
            }
            input.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return gCinfo;
    }
}
