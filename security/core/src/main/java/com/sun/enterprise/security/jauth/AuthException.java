/*
 * The contents of this file are subject to the terms 
 * of the Common Development and Distribution License 
 * (the License).  You may not use this file except in
 * compliance with the License.
 * 
 * You can obtain a copy of the license at 
 * https://glassfish.dev.java.net/public/CDDLv1.0.html or
 * glassfish/bootstrap/legal/CDDLv1.0.txt.
 * See the License for the specific language governing 
 * permissions and limitations under the License.
 * 
 * When distributing Covered Code, include this CDDL 
 * Header Notice in each file and include the License file 
 * at glassfish/bootstrap/legal/CDDLv1.0.txt.  
 * If applicable, add the following below the CDDL Header, 
 * with the fields enclosed by brackets [] replaced by
 * you own identifying information: 
 * "Portions Copyrighted [year] [name of copyright owner]"
 * 
 * Copyright 2006 Sun Microsystems, Inc. All rights reserved.
 */

package com.sun.enterprise.security.jauth;

/**
 * A generic authentication exception.
 *
 * @version %I%, %G%
 */
public class AuthException extends javax.security.auth.message.AuthException {

    private static final long serialVersionUID = -1156951780670243758L;

    /**
     * Constructs a AuthException with no detail message. A detail
     * message is a String that describes this particular exception.
     */
    public AuthException() {
	super();
    }

    /**
     * Constructs a AuthException with the specified detail message.
     * A detail message is a String that describes this particular
     * exception.
     *
     * <p>
     *
     * @param msg the detail message.
     */
    public AuthException(String msg) {
	super(msg);
    }
}

