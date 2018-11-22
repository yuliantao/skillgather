package com.ylt.skillgather.common.utils;

import com.ylt.skillgather.system.entity.CoreUrlMaping;
import com.ylt.skillgather.system.entity.CoreUrlMapingEx;

import java.util.ArrayList;
import java.util.List;

public class ListToJsonTree{

    public static List<CoreUrlMapingEx> listCoreUrlMaping(List<CoreUrlMaping> list)
    {
        List<CoreUrlMapingEx> lists=new ArrayList<>();
        List<CoreUrlMaping> temp=new ArrayList<>();
        for (CoreUrlMaping coreUrlMaping: list) {
             if (coreUrlMaping.getParentID()==-1)
             {
                 CoreUrlMapingEx coreUrlMapingEx = new CoreUrlMapingEx();
                 coreUrlMapingEx.setId(coreUrlMaping.getId());
                 coreUrlMapingEx.setParentID(-1);
                 coreUrlMapingEx.setRequestUrl(coreUrlMaping.getRequestUrl());
                 coreUrlMapingEx.setViewUrl(coreUrlMaping.getViewUrl());
                 lists.add(coreUrlMapingEx);
             }
             else
                 temp.add(coreUrlMaping);

        }
        return  lists;
    }

}
