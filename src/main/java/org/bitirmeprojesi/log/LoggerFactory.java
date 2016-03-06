/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.bitirmeprojesi.log;

import java.io.Serializable;

/**
 *
 * @author Batuhan
 */
public class LoggerFactory implements Serializable{

    public static Logger getLogger(Class clasz) {

        return new Logger(org.slf4j.LoggerFactory.getLogger(clasz));
    }
}
