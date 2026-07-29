package com.bunbun.biorobotics_ops_api.utils;

public class SearchHelpers {
    public static boolean containsIgnoreCase(String source, String search){
        return source.toLowerCase().contains(search.toLowerCase());
    }
}
