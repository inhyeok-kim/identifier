package com.seaweed.identifier.auth

import jakarta.servlet.http.HttpSession

class LoginSessionMap {
    private val loginSessionMap : HashMap<Long, ArrayList<HttpSession>> = HashMap();

    fun add(key:Long,session: HttpSession){
        if(loginSessionMap.containsKey(key)) {
            loginSessionMap.get(key)?.add(session);
        } else {
            var list = ArrayList<HttpSession>()
            list.add(session);
            loginSessionMap.put(key,list)
        }
    }

    fun remove(key : Long, session : HttpSession){
        if(loginSessionMap.containsKey(key)) {
            loginSessionMap.get(key)?.remove(session)
        }
    }

}