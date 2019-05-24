package com.yyl.jvmconsole.service;

import com.yyl.jvmconsole.model.GCinfo;
import com.yyl.jvmconsole.model.Procezz;

import java.util.List;

/**
 * leapstack
 * author:yangyuanliang
 * Date:2019-05-21
 * Time:17:09
 **/
public interface IProcessService {
    //所有java进程
    List<Procezz> getAllProcess();
    GCinfo getGCinfoByPid(String pid);
}
