package com.seaweed.identifier.login;

import jakarta.servlet.http.HttpSession;

import java.util.ArrayList;
import java.util.HashMap;

public class LoginSessionMap {
    private HashMap<Long, ArrayList<HttpSession>> loginSessionMap = new HashMap();

    public void add(long key,HttpSession session){
        if(loginSessionMap.containsKey(key)) {
            loginSessionMap.get(key).add(session);
        } else {
            var list = new ArrayList<HttpSession>();
            list.add(session);
            loginSessionMap.put(key,list);
        }
    }

    public void remove(long key, HttpSession session){
        if(loginSessionMap.containsKey(key)) {
            loginSessionMap.get(key).remove(session);
        }
    }

}