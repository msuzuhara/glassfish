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
 * CheckAdminObjectSerializable.java
 *
 * Created on August 29, 2002
 */

package com.sun.enterprise.tools.verifier.tests.connector.admin;

import com.sun.enterprise.tools.verifier.tests.connector.ConnectorTest;
import com.sun.enterprise.tools.verifier.tests.connector.ConnectorCheck;
import com.sun.enterprise.tools.verifier.Result;
import com.sun.enterprise.tools.verifier.*;
import com.sun.enterprise.deployment.ConnectorDescriptor;
import com.sun.enterprise.deployment.AdminObject;
import com.sun.enterprise.tools.verifier.tests.*;
import java.util.Iterator;
import java.util.Set;

/**
 * Test for each adminobject, that "adminobject-class"
 * implements "java.io.Serializable".
 *
 * @author Anisha Malhotra 
 * @version 
 */
public class CheckAdminObjectSerializable
    extends ConnectorTest 
    implements ConnectorCheck 
{

  /** <p>
   * Test for each adminobject, that "adminobject-class"
   * implements "java.io.Serializable".
   * </p>
   *
   * @param descriptor deployment descriptor for the rar file
   * @return result object containing the result of the individual test
   * performed
   */
  public Result check(ConnectorDescriptor descriptor) {

    Result result = getInitializedResult();
    ComponentNameConstructor compName = 
      getVerifierContext().getComponentNameConstructor();
    if(!descriptor.hasAdminObjects())
    {
      result.addNaDetails(smh.getLocalString
          ("tests.componentNameConstructor",
           "For [ {0} ]",
           new Object[] {compName.toString()}));
      result.notApplicable(smh.getLocalString
          ("com.sun.enterprise.tools.verifier.tests.connector.admin.notApp",
           "Resource Adapter does not define any administered objects"));
      return result;
    }
    Set adminObjects = descriptor.getAdminObjects();
    boolean oneFailed = false;
    Iterator iter = adminObjects.iterator();
    while(iter.hasNext()) 
    {
      AdminObject adminObj = (AdminObject) iter.next();
      String impl = adminObj.getAdminObjectClass();
      Class implClass = null;
      try
      {
        implClass = Class.forName(impl, false, getVerifierContext().getClassLoader());
      }
      catch(ClassNotFoundException e)
      {
        result.addErrorDetails(smh.getLocalString
            ("tests.componentNameConstructor",
             "For [ {0} ]",
             new Object[] {compName.toString()}));
        result.failed(smh.getLocalString
            ("com.sun.enterprise.tools.verifier.tests.connector.admin.nonexist",
             "Error: The class [ {0} ] as defined under adminobject-class in the deployment descriptor does not exist",
             new Object[] {impl}));
        return result;
      }
      if(!isImplementorOf(implClass, "java.io.Serializable"))
      {
        oneFailed = true;
        result.addErrorDetails(smh.getLocalString
            ("tests.componentNameConstructor",
             "For [ {0} ]",
             new Object[] {compName.toString()}));
        result.failed(smh.getLocalString(getClass().getName() + ".failed",
              "Error: adminobject-class [ {0} ] does not implement java.io.Serializable",
              new Object[] {impl}));
        return result;                
      }
    }
    if(!oneFailed)
    {
      result.addGoodDetails(smh.getLocalString
          ("tests.componentNameConstructor",
           "For [ {0} ]",
           new Object[] {compName.toString()}));	
      result.passed(smh.getLocalString(getClass().getName() + ".passed",
            "Success: all adminobject-class implement java.io.Serializable"));                     
    }
    return result;
  }
}
