/**********************************************************************
 * Copyright (c) 2004 IBM Corporation and others.
 * All rights reserved.   This program and the accompanying materials
 * are made available under the terms of the Common Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/cpl-v10.html
 *
 * Contributors:
 *    IBM - Initial API and implementation
 **********************************************************************/
package org.eclipse.wst.server.core;

import java.beans.PropertyChangeListener;
import java.util.List;
import java.util.Map;
/**
 * Provides additional methods common to working copies of an element.
 * <p>
 * This interface is not intended to be implemented by clients.
 * </p>
 * 
 * @since 1.0
 */
public interface IElementWorkingCopy extends IElement {
	
	/**
	 * Sets the value of the specified integer-valued attribute of this
	 * element.
	 * 
	 * @param id the attribute id
	 * @param value the value of the specified attribute
	 * @see IElement#getAttribute(String, int)
	 */
	public void setAttribute(String id, int value);

	/**
	 * Sets the value of the specified boolean-valued attribute of this
	 * element.
	 * 
	 * @param id the attribute id
	 * @param value the value of the specified attribute
	 * @see IElement#getAttribute(String, boolean)
	 */
	public void setAttribute(String id, boolean value);

	/**
	 * Sets the value of the specified string-valued attribute of this
	 * element.
	 * 
	 * @param id the attribute id
	 * @param value the value of the specified attribute
	 * @see IElement#getAttribute(String, String)
	 */
	public void setAttribute(String id, String value);

	/**
	 * Sets the value of the specified list-valued attribute of this
	 * element.
	 * <p>
	 * [issue: Serialization/deserialization]
	 * </p>
	 * 
	 * @param id the attribute id
	 * @param value the value of the specified attribute
	 * @see IElement#getAttribute(String, List)
	 */
	public void setAttribute(String id, List value);

	/**
	 * Sets the value of the specified map-valued attribute of this
	 * element.
	 * <p>
	 * [issue: Serialization/deserialization]
	 * </p>
	 * 
	 * @param id the attribute id
	 * @param value the value of the specified attribute
	 * @see IElement#getAttribute(String, Map)
	 */
	public void setAttribute(String id, Map value);

	/**
	 * Sets the displayable name for this element.
	 * <p>
	 * The name should be appropriate for the current locale.
	 * </p>
	 *
	 * @param name a displayable name
	 * @see IElement#getName()
	 */
	public void setName(String name);
	
	/**
	 * Sets whether this element is locked.
	 * When an element is locked, the user cannot make changes to it.
	 * <p>
	 * [issue: See issue on IElement.isLocked.]
	 * </p>
	 *
	 * @param b <code>true</code> if this element is locked,
	 * and <code>false</code> otherwise
	 * @see IElement#isLocked()
	 */
	public void setLocked(boolean b);
	
	/**
	 * Sets whether this element is private.
	 * Generally speaking, elements marked private are internal ones
	 * that should not be shown to users (because they won't know
	 * anything about them).
	 * 
	 * @param b <code>true</code> if this element is private,
	 * and <code>false</code> otherwise
	 * @see IElement#isPrivate()
	 */
	public void setPrivate(boolean b);
	
	/**
	 * Returns whether this working copy has unsaved changes.
	 * <p>
	 * [issue: It unfortunate that working copy creation and saving
	 * are nowhere represented in the IElement and IElementWorkingCopy
	 * (everything is on the particular subinterfaces).]
	 * </p>
	 * 
	 * @return <code>true</code> if this working copy has unsaved
	 * changes, and <code>false</code> otherwise
	 */
	public boolean isDirty();
	
	/**
	 * Releases this working copy.
	 * <p>
	 * Element implementations retain internal references to
	 * extant working copies. Calling this method drop that reference.
	 * </p>
	 */
	public void release();

	/**
	 * Adds a property change listener to this server.
	 *
	 * @param listener java.beans.PropertyChangeListener
	 */
	public void addPropertyChangeListener(PropertyChangeListener listener);

	/**
	 * Removes a property change listener from this server.
	 *
	 * @param listener java.beans.PropertyChangeListener
	 */
	public void removePropertyChangeListener(PropertyChangeListener listener);
	
	/**
	 * Fires a property change event.
	 */
	public void firePropertyChangeEvent(String propertyName, Object oldValue, Object newValue);
}