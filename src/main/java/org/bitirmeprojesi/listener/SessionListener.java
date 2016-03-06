/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.bitirmeprojesi.listener;

import java.util.Date;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import org.bitirmeprojesi.log.Logger;
import org.bitirmeprojesi.log.LoggerFactory;

public class SessionListener implements HttpSessionListener {
    
    private Logger logger = LoggerFactory.getLogger(SessionListener.class);
    
    @Override
    public void sessionCreated(HttpSessionEvent se) {
        logger.info("Session created :" + se.getSession().getId() + " Time: " + new Date());
        se.getSession().setMaxInactiveInterval(10 * 60);
        logger.info("Session timeout time : " + se.getSession().getMaxInactiveInterval());
    }
    
    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        logger.info("Session destroyed :" + se.getSession().getId() + " Time: " + new Date());
    }
    
}
