/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.bitirmeprojesi.log;

import java.io.Serializable;
import org.slf4j.Marker;
import org.slf4j.helpers.MarkerIgnoringBase;
import org.slf4j.spi.LocationAwareLogger;

/**
 *
 * @author Batuhan
 */
public class Logger extends MarkerIgnoringBase implements LocationAwareLogger,Serializable {

    protected org.slf4j.Logger logger;

    public Logger(org.slf4j.Logger logger) {
        this.logger = logger;
    }

    @Override
    public boolean isTraceEnabled() {
        return logger.isTraceEnabled();
    }

    @Override
    public void trace(String message) {
        logger.trace(message);
    }

    @Override
    public void trace(String message, Object o) {
        logger.trace(message, o);
    }

    @Override
    public void trace(String message, Object o, Object o1) {
        logger.trace(message, o, o1);
    }

    @Override
    public void trace(String message, Object... os) {
        logger.trace(message, os);
    }

    @Override
    public void trace(String message, Throwable thrwbl) {
        logger.trace(message, thrwbl);
    }

    @Override
    public boolean isDebugEnabled() {
        return logger.isDebugEnabled();
    }

    @Override
    public void debug(String message) {
        logger.debug(message);
    }

    @Override
    public void debug(String message, Object o) {
        logger.debug(message, o);
    }

    @Override
    public void debug(String message, Object o, Object o1) {
        logger.debug(message, o, o1);
    }

    @Override
    public void debug(String message, Object... os) {
        logger.debug(message, os);
    }

    @Override
    public void debug(String message, Throwable thrwbl) {
        logger.debug(message, thrwbl);
    }

    @Override
    public boolean isInfoEnabled() {
        return logger.isInfoEnabled();
    }

    @Override
    public void info(String message) {
        logger.info(message);
    }

    @Override
    public void info(String message, Object o) {
        logger.info(message, o);
    }

    @Override
    public void info(String message, Object o, Object o1) {
        logger.info(message, o, o1);
    }

    @Override
    public void info(String message, Object... os) {
        logger.info(message, os);
    }

    @Override
    public void info(String message, Throwable thrwbl) {
        logger.info(message, thrwbl);
    }

    @Override
    public boolean isWarnEnabled() {
        return logger.isWarnEnabled();
    }

    @Override
    public void warn(String message) {
        logger.warn(message);
    }

    @Override
    public void warn(String message, Object o) {
        logger.warn(message, o);
    }

    @Override
    public void warn(String message, Object... os) {
        logger.warn(message, os);
    }

    @Override
    public void warn(String message, Object o, Object o1) {
        logger.warn(message, o, o1);
    }

    @Override
    public void warn(String message, Throwable thrwbl) {
        logger.warn(message, thrwbl);
    }

    @Override
    public boolean isErrorEnabled() {
        return logger.isErrorEnabled();
    }

    @Override
    public void error(String message) {
        logger.error(message);
    }

    @Override
    public void error(String message, Object o) {
        logger.error(message, o);
    }

    @Override
    public void error(String message, Object o, Object o1) {
        logger.error(message, o, o1);
    }

    @Override
    public void error(String message, Object... os) {
        logger.error(message, os);
    }

    @Override
    public void error(String message, Throwable thrwbl) {
        logger.error(message, thrwbl);
    }

    @Override
    public void log(Marker marker, String message, int i, String message1, Object[] os, Throwable thrwbl) {

    }
}
