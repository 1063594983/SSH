package com.utils;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Application Lifecycle Listener implementation class CounterListener
 *
 */
@WebListener
public class CounterListener implements HttpSessionListener {
	
	public static int count;

    /**
     * Default constructor. 
     */
    public CounterListener() {
        count = 0;
    }

	/**
     * @see HttpSessionListener#sessionCreated(HttpSessionEvent)
     * ����һ��sessionʱ����
     */
    public void sessionCreated(HttpSessionEvent se)  { 
         count++;
    }

	/**
     * @see HttpSessionListener#sessionDestroyed(HttpSessionEvent)
     * һ��sessionʧЧʱ����
     */
    public void sessionDestroyed(HttpSessionEvent se)  { 
         if(count > 0) {
        	 count--;
         }
    }
	
}
