package com.megagao.production.ssm.util;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by megagao on 2017/12/29.
 */
public class CollectionsFactory {
    public static <K,V> HashMap<K,V> newHashMap(){
        return new HashMap<K,V>();
    }

    public static <K,V> LinkedHashMap<K,V> newLinkedHashMap(){
        return new LinkedHashMap<K,V>();
    }

    public static <K,V> ConcurrentHashMap<K,V> newConcurrentHashMap(){
        return new ConcurrentHashMap<K,V>();
    }

    public static <T> ArrayList<T> newArrayList(){
        return new ArrayList<T>();
    }

    public static <T> LinkedList<T> newLinkedList(){
        return new LinkedList<T>();
    }

    public static <T> HashSet<T> newHashSet(){
        return new HashSet<T>();
    }

    public static <T> LinkedHashSet<T> newLinkedHashSet(){
        return new LinkedHashSet<T>();
    }
}
