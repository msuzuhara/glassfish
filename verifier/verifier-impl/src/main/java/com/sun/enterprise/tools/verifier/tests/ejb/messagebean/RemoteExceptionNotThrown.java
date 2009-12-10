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
package com.sun.enterprise.tools.verifier.tests.ejb.messagebean;

import com.sun.enterprise.tools.verifier.Result;
import com.sun.enterprise.tools.verifier.Verifier;
import com.sun.enterprise.tools.verifier.tests.ComponentNameConstructor;
import com.sun.enterprise.deployment.EjbMessageBeanDescriptor;

import java.lang.reflect.Method;

/**
 * Message listener methods should not throw java.rmi.RemoteException.
 * @author Vikas Awasthi
 */
public class RemoteExceptionNotThrown extends MessageBeanTest {

    public Result check(EjbMessageBeanDescriptor descriptor) {
        Result result = getInitializedResult();
        ComponentNameConstructor compName = getVerifierContext().getComponentNameConstructor();
        ClassLoader cl = getVerifierContext().getClassLoader();
        try {
            Method[] methods = descriptor.getMessageListenerInterfaceMethods(cl);
            for (int i = 0; i < methods.length; i++) {
                if(containsRemote(methods[i].getExceptionTypes())) {
                    addErrorDetails(result, compName);
                    result.failed(smh.getLocalString
                                    (getClass().getName()+".failed",
                                    "Method [ {0} ] throws RemoteException",
                                    new Object[] {methods[i]}));
                }
            }
        } catch (NoSuchMethodException e) {
            Verifier.debug(e);
            addErrorDetails(result, compName);
            result.failed(smh.getLocalString
                            (getClass().getName()+".failed1",
                            "[ {0} ]", new Object[]{e.getMessage()}));
        }
        
        if(result.getStatus() != Result.FAILED) {
            addGoodDetails(result, compName);
            result.passed(smh.getLocalString
                            (getClass().getName() + ".passed",
                            "Valid message listener method(s)."));
        }
        return result;
    }
    
    /** returns true if one of the exceptions is RemoteException*/
    private boolean containsRemote(Class[] exceptions) {
        for (int i = 0; i < exceptions.length; i++) 
            if(exceptions[i].getName().equals("java.rmi.RemoteException"))
                return true;
        
        return false;
    }
}
