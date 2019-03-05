package com.subham.assessment.utils;

public class ValidityChecker {

    public boolean isEmailValid (String email) throws StringIndexOutOfBoundsException{
        int emailLength = email.length();
        int i = 0;
        boolean prefixFlag = false;
        boolean atTheRateFlag = false;
        boolean dotFlag = false;
        boolean domainFlag = false;

        if(email.charAt(0) != '@'){
            prefixFlag = true;
        }
        for(i = 0; i < emailLength; ++i){
            if(email.charAt(i) == '@'){
                break;
            }
        }
        if(i < emailLength && email.charAt(i)  == '@'){
            atTheRateFlag = true;
        }
        for( ; i < emailLength; ++i){
            if(email.charAt(i) == '.'){
                break;
            }
        }
        if(i < emailLength && email.charAt(i) == '.'){
            dotFlag = true;
        }
        ++i;
        if(i < emailLength){
            domainFlag = true;
        }
        return (prefixFlag & atTheRateFlag & dotFlag & domainFlag);
    }

    public boolean isNameValid(String name){
        int nameLength = name.length();
        return (nameLength <= 50);
    }
}
