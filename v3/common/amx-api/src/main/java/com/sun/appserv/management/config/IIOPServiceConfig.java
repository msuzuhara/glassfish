/*
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER.
 * 
 * Copyright 1997-2007 Sun Microsystems, Inc. All rights reserved.
 * 
 * The contents of this file are subject to the terms of either the GNU
 * General Public License Version 2 only ("GPL") or the Common Development
 * and Distribution License("CDDL") (collectively, the "License").  You
 * may not use this file except in compliance with the License. You can obtain
 * a copy of the License at https://glassfish.dev.java.net/public/CDDL+GPL.html
 * or glassfish/bootstrap/legal/LICENSE.txt.  See the License for the specific
 * language governing permissions and limitations under the License.
 * 
 * When distributing the software, include this License Header Notice in each
 * file and include the License file at glassfish/bootstrap/legal/LICENSE.txt.
 * Sun designates this particular file as subject to the "Classpath" exception
 * as provided by Sun in the GPL Version 2 section of the License file that
 * accompanied this code.  If applicable, add the following below the License
 * Header, with the fields enclosed by brackets [] replaced by your own
 * identifying information: "Portions Copyrighted [year]
 * [name of copyright owner]"
 * 
 * Contributor(s):
 * 
 * If you wish your version of this file to be governed by only the CDDL or
 * only the GPL Version 2, indicate your decision by adding "[Contributor]
 * elects to include this software in this distribution under the [CDDL or GPL
 * Version 2] license."  If you don't indicate a single choice of license, a
 * recipient has the option to distribute your version of this file under
 * either the CDDL, the GPL Version 2 or to extend the choice of license to
 * its licensees as provided above.  However, if you add GPL Version 2 code
 * and therefore, elected the GPL Version 2 license, then the option applies
 * only if the new code is made subject to such option by the copyright
 * holder.
 */
 
/*
 * $Header: /cvs/glassfish/appserv-api/src/java/com/sun/appserv/management/config/IIOPServiceConfig.java,v 1.2 2007/05/05 05:30:33 tcfujii Exp $
 * $Revision: 1.2 $
 * $Date: 2007/05/05 05:30:33 $
 */


package com.sun.appserv.management.config;

import java.util.Map;

import com.sun.appserv.management.base.XTypes;
import com.sun.appserv.management.base.Container;






/**
	 Configuration for the &lt;iiop-service&gt; element.
 */
public interface IIOPServiceConfig
	extends ConfigElement, Container
{
/** The j2eeType as returned by {@link com.sun.appserv.management.base.AMX#getJ2EEType}. */
	public static final String	J2EE_TYPE	= XTypes.IIOP_SERVICE_CONFIG;

	/**
		Creates ssl-client-config element.

		@param params
		@return Returns a proxy to the SSLConfig MBean.
	 */
	public SSLConfig	createIIOPSSLClientConfig( Map<String,String> params );

	/**
		Removes ssl-client-config element.
	 */
	public void			removeIIOPSSLClientConfig();

	/**
		Get the SSLConfig MBean that corresponds to ssl-client-config
		element of this iiop service.
	 */
	public SSLConfig	getIIOPSSLClientConfig();

	public boolean		getClientAuthenticationRequired();

	public void		setClientAuthenticationRequired( final boolean value );



	/**
		Calls Container.getContaineeMap( XTypes.IIOP_LISTENER_CONFIG ).
		@return Map of IIOPListenerConfig MBean proxies, keyed by name.
		@see com.sun.appserv.management.base.Container#getContaineeMap
	 */
	public Map<String,IIOPListenerConfig>		getIIOPListenerConfigMap();
	
	
	/**
		Create an <iiop-listener>. Most fields will default to reasonable values.
		Caller should modify them after creation, if desired.
		
		@param name 	the name (id) of the newly created listener
		@param address	IP address of the listener
		@param optional	optional parameters
		@see IIOPListenerConfigKeys
	 */
	public IIOPListenerConfig	createIIOPListenerConfig( String name, String address, Map<String,String> optional );

	/**
		Removes an iiop listener.

		@param name the name (id) of the iiop listener to be removed.
	 */
	public void			removeIIOPListenerConfig( String name );


	/**
		Get a proxy to an ORBConfig
	 */
	ORBConfig					getORBConfig();
}







