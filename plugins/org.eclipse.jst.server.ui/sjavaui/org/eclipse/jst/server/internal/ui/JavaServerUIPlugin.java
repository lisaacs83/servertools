package org.eclipse.jst.server.internal.ui;
/**********************************************************************
 * Copyright (c) 2003 IBM Corporation and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Common Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/cpl-v10.html
 *
 * Contributors:
 *    IBM - Initial API and implementation
 **********************************************************************/
import java.text.MessageFormat;
import org.eclipse.core.runtime.*;
import org.eclipse.ui.plugin.AbstractUIPlugin;
/**
 * The main server tooling plugin class.
 */
public class JavaServerUIPlugin extends AbstractUIPlugin {
	// server java plugin id
	public static final String PLUGIN_ID = "org.eclipse.jst.server.ui";

	// singleton instance of this class
	private static JavaServerUIPlugin singleton;

	/**
	 * Create the JavaServerUIPlugin.
	 */
	public JavaServerUIPlugin() {
		super();
		singleton = this;
	}

	/**
	 * Returns the singleton instance of this plugin.
	 *
	 * @return org.eclipse.jst.server.ui.JavaServerUIPlugin
	 */
	public static JavaServerUIPlugin getInstance() {
		return singleton;
	}

	/**
	 * Returns the translated String found with the given key.
	 *
	 * @param key java.lang.String
	 * @return java.lang.String
	 */
	public static String getResource(String key) {
		try {
			return Platform.getResourceString(getInstance().getBundle(), key);
		} catch (Exception e) {
			return key;
		}
	}
	/**
	 * Returns the translated String found with the given key,
	 * and formatted with the given arguments using java.text.MessageFormat.
	 *
	 * @param key java.lang.String
	 * @param arguments java.lang.Object[]
	 * @return java.lang.String
	 */
	public static String getResource(String key, Object[] arguments) {
		try {
			String text = getResource(key);
			return MessageFormat.format(text, arguments);
		} catch (Exception e) {
			return key;
		}
	}

	/**
	 * Convenience method for logging.
	 *
	 * @param status org.eclipse.core.runtime.IStatus
	 */
	public static void log(IStatus status) {
		getInstance().getLog().log(status);
	}
}