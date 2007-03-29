/*******************************************************************************
 * Copyright (c) 2007 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     IBM Corporation - Initial API and implementation
 *******************************************************************************/
package org.eclipse.jst.server.preview.internal;

import org.eclipse.equinox.app.IApplication;
import org.eclipse.equinox.app.IApplicationContext;

public class PreviewApplication implements IApplication {
	protected PreviewStarter starter;

	public Object start(IApplicationContext appContext) throws Exception {
		starter = new PreviewStarter(null);
		starter.run();
		return EXIT_OK;
	}

	public void stop() {
		starter.stop();
	}
}