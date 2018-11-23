package com.ylt.skillgather.common.utils;

import com.ylt.skillgather.system.entity.Ex.SystemMenuEx;
import com.ylt.skillgather.system.entity.SystemMenu;

import java.util.ArrayList;
import java.util.List;

public class ListToJsonTree{

    public static List<SystemMenuEx> listCoreUrlMaping(List<SystemMenu> list)
    {
        List<SystemMenuEx> lists=new ArrayList<>();
        for (SystemMenu systemMenu: list) {
            SystemMenuEx systemMenuEx=entityToEx(systemMenu);
            if (systemMenuEx.getParentid()==-1)
            {
                lists.add(systemMenuEx);
            }
            for (SystemMenu systemMenu2: list) {
                if (systemMenu2.getParentid()==systemMenuEx.getId())
                {
                    if (systemMenuEx.getLists()==null)
                    {
                        List<SystemMenuEx> lis=new ArrayList<>();
                        systemMenuEx.setLists(lis);
                    }
                    systemMenuEx.getLists().add(entityToEx(systemMenu2));
                }
            }
        }
        return  lists;
    }

    public  static SystemMenuEx entityToEx(SystemMenu systemMenu)
    {
        SystemMenuEx systemMenuEx = new SystemMenuEx();
        systemMenuEx.setBadgeIco(systemMenu.getBadgeIco());
        systemMenuEx.setIco(systemMenu.getIco());
        systemMenuEx.setId(systemMenu.getId());
        systemMenuEx.setName(systemMenu.getName());
        systemMenuEx.setParentid(systemMenu.getParentid());
        systemMenuEx.setUrl(systemMenu.getUrl());
        return  systemMenuEx;
    }

}
