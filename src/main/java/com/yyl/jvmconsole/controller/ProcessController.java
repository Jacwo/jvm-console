package com.yyl.jvmconsole.controller;

import com.yyl.jvmconsole.model.GCinfo;
import com.yyl.jvmconsole.model.Procezz;
import com.yyl.jvmconsole.service.IProcessService;
import com.yyl.jvmconsole.utils.ResultMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * leapstack
 * author:yangyuanliang
 * Date:2019-05-21
 * Time:17:02
 **/
@Controller
@RequestMapping("/process")
public class ProcessController {

    @Autowired
    public IProcessService processService;

    @RequestMapping("/getAllProcess")
    @ResponseBody
    public ResultMap<List<Procezz>> selectAllProcess(){
        ResultMap<List<Procezz>> resultMap=new ResultMap<>();
        List<Procezz> allProcess = processService.getAllProcess();
        resultMap.setData(allProcess);
        return resultMap;
    }

    @RequestMapping("/getGCinfo/{pid}")
    @ResponseBody
    public ResultMap<GCinfo> getGCinfoByPid(@PathVariable String pid){
        ResultMap<GCinfo> resultMap=new ResultMap<GCinfo>();
        GCinfo gCinfoByPid = processService.getGCinfoByPid(pid);
        resultMap.setData(gCinfoByPid);
        return resultMap;

    }
}
