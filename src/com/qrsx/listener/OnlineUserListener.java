package com.qrsx.listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionActivationListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Application Lifecycle Listener implementation class OnlineUserListener
 * 
 */
@WebListener
public class OnlineUserListener implements HttpSessionListener,
		HttpSessionAttributeListener, HttpSessionActivationListener,
		HttpSessionBindingListener {

	private int userCount = 0;

	/**
	 * Default constructor.
	 */
	public OnlineUserListener() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpSessionAttributeListener#attributeRemoved(HttpSessionBindingEvent)
	 */
	@Override
	public void attributeRemoved(HttpSessionBindingEvent arg0) {
		// userCount--;
	}

	/**
	 * @see HttpSessionAttributeListener#attributeAdded(HttpSessionBindingEvent)
	 */
	@Override
	public void attributeAdded(HttpSessionBindingEvent arg0) {
		// 代表session.addAttribute
		// userCount++;
	}

	/**
	 * @see HttpSessionBindingListener#valueUnbound(HttpSessionBindingEvent)
	 */
	@Override
	public void valueUnbound(HttpSessionBindingEvent arg0) {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpSessionActivationListener#sessionDidActivate(HttpSessionEvent)
	 */
	@Override
	public void sessionDidActivate(HttpSessionEvent arg0) {
		userCount--;
	}

	/**
	 * @see HttpSessionActivationListener#sessionWillPassivate(HttpSessionEvent)
	 */
	@Override
	public void sessionWillPassivate(HttpSessionEvent arg0) {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpSessionBindingListener#valueBound(HttpSessionBindingEvent)
	 */
	@Override
	public void valueBound(HttpSessionBindingEvent arg0) {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpSessionAttributeListener#attributeReplaced(HttpSessionBindingEvent)
	 */
	@Override
	public void attributeReplaced(HttpSessionBindingEvent arg0) {
		// TODO Auto-generated method stub
	}

	@Override
	public void sessionCreated(HttpSessionEvent httpSessionEvent) {
		userCount++;
		httpSessionEvent.getSession().setAttribute("onlineUser", userCount);

	}

	@Override
	public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
		userCount--;
		httpSessionEvent.getSession().setAttribute("onlineUser", userCount);
	}

}
