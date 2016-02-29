/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.bitirmeprojesi.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author ilkaygunel
 */
public class LoggerUtils {
    
    public Logger getLogger(Class clasz)
    {
        Logger logger = LoggerFactory.getLogger(clasz);
        return logger;
    }
    
    public void infoLog(String message,Class clasz)
    {
       if(!StringUtil.isNullOrEmpty(message))
       {
           getLogger(clasz).info("");
           
       }
    }
    
    public void debugLog(String message,Class clasz)
    {
       if(!StringUtil.isNullOrEmpty(message))
       {
           getLogger(clasz).debug(message);
           
       }
    }
    
    public void errorLog(String message,Class clasz)
    {
       if(!StringUtil.isNullOrEmpty(message))
       {
           getLogger(clasz).error(message);
           
       }
    }
    
    public void warnLog(String message,Class clasz)
    {
       if(!StringUtil.isNullOrEmpty(message))
       {
           getLogger(clasz).warn(message);
           
       }
    }
}
