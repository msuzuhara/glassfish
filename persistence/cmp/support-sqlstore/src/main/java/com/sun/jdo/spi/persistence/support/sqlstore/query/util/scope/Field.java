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
 * Field.java
 *
 * Created on March 21, 2001
 */

package com.sun.jdo.spi.persistence.support.sqlstore.query.util.scope;

import org.glassfish.persistence.common.I18NHelper;

import com.sun.jdo.spi.persistence.support.sqlstore.query.util.type.Type;
import com.sun.jdo.spi.persistence.support.sqlstore.query.util.type.FieldInfo;

/**
 * An object of class Field is used if an identifier
 * denotes a field.
 *
 * @author  Michael Bouschen
 * @version 0.1
 */
public class Field
  extends Definition
{
    /**
     * The corresponding field info.
     */
    protected FieldInfo fieldInfo;

    /**
     *
     */
    public Field(FieldInfo fieldInfo)
    {
        super(fieldInfo.getType());
        this.fieldInfo = fieldInfo;
    }
	
    /**
     *
     */
	public String getName()
	{
		return I18NHelper.getMessage(messages, "scope.field.getname.name"); //NOI18N
	}

    /**
     * Returns the corresponding field info.
     */
    public FieldInfo getFieldInfo()
    {
        return fieldInfo;
    }

    /**
     *
     */
    public String toString()
    {
        StringBuffer buf = new StringBuffer();
        buf.append("Field("); //NOI18N
        buf.append(scope);
        buf.append(", "); //NOI18N
        buf.append(type);
        buf.append(")"); //NOI18N
        return buf.toString();
    }
}
