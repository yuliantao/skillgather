package com.ylt.skillgather.common.utils;


import com.ylt.skillgather.coreframe.entity.CoreframeMenu;
import com.ylt.skillgather.coreframe.entity.Ex.CoreframeMenuEx;

import java.util.ArrayList;
import java.util.List;

public class ListToJsonTree{

    public static List<CoreframeMenuEx> listCoreUrlMaping(List<CoreframeMenu> list)
    {
        List<CoreframeMenuEx> lists=new ArrayList<>();
        for (CoreframeMenu systemMenu: list) {
            CoreframeMenuEx systemMenuEx=entityToEx(systemMenu);
            if (systemMenuEx.getParentid()==-1)
            {
                lists.add(systemMenuEx);
            }
            for (CoreframeMenu systemMenu2: list) {
                if (systemMenu2.getParentid()==systemMenuEx.getId())
                {
                    if (systemMenuEx.getLists()==null)
                    {
                        List<CoreframeMenuEx> lis=new ArrayList<>();
                        systemMenuEx.setLists(lis);
                    }
                    systemMenuEx.getLists().add(entityToEx(systemMenu2));
                }
            }
        }
        return  lists;
    }

    public  static CoreframeMenuEx entityToEx(CoreframeMenu systemMenu)
    {
        CoreframeMenuEx systemMenuEx = new CoreframeMenuEx();
        systemMenuEx.setBadgeIco(systemMenu.getBadgeIco());
        systemMenuEx.setIco(systemMenu.getIco());
        systemMenuEx.setId(systemMenu.getId());
        systemMenuEx.setName(systemMenu.getName());
        systemMenuEx.setParentid(systemMenu.getParentid());
        systemMenuEx.setUrl(systemMenu.getUrl());
        return  systemMenuEx;
    }

}
