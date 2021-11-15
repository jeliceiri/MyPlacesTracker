package com.jilleliceiri.mptr.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.util.*;

/**
 * Project 1 Advanced Java
 * PropertiesLoaderInterface
 * The interface that loads the properties file
 * @author Paula Waite
 */

public interface PropertiesLoaderInterface {

    /**
     *  This default method will load the properties using the properties file to be read
     *  @param propertiesFilePath the properties file path
     *  @return properties the properties object
     */


    default Properties loadProperties(String propertiesFilePath)  {
        final Logger logger = LogManager.getLogger(this.getClass());
        Properties properties = new Properties();
        try {
            properties.load(this.getClass().getResourceAsStream(propertiesFilePath));

        } catch(IOException ioException) {
            logger.error("Cannot load properties..." + ioException.getMessage(), ioException);
            return null;
        } catch(Exception e) {
            logger.error("Error loading properties" + e.getMessage(), e);
            return null;
        }
        return properties;
    }
}