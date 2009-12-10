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
package com.sun.gjc.spi.jdbc30;

import com.sun.gjc.spi.base.CallableStatementWrapper;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;


/**
 * Wrapper for JDBC 3.0 CallableStatement
 */
public class CallableStatementWrapper30 extends CallableStatementWrapper {

    /**
     * Creates a new instance of CallableStatement wrapper for JDBC 3.0<br>
     *
     * @param con       ConnectionWrapper<br>
     * @param statement CallableStatement that is wrapped<br>
     */
    public CallableStatementWrapper30(Connection con, CallableStatement statement,
                                      boolean enableCaching)  throws SQLException{
        super(con, statement, enableCaching);
    }

    /**
     * Executes the SQL query in this <code>PreparedStatement</code> object
     * and returns the <code>ResultSet</code> object generated by the query.
     *
     * @return a <code>ResultSet</code> object that contains the data produced by the
     *         query; never <code>null</code>
     * @throws java.sql.SQLException if a database access error occurs or the SQL
     *                               statement does not return a <code>ResultSet</code> object
     */
    public java.sql.ResultSet executeQuery() throws java.sql.SQLException {
        ResultSet rs = callableStatement.executeQuery();
        if (rs == null)
            return null;
        return new ResultSetWrapper30(this, rs);
    }

    /**
     * Executes the given SQL statement, which returns a single
     * <code>ResultSet</code> object.
     *
     * @param sql an SQL statement to be sent to the database, typically a
     *            static SQL <code>SELECT</code> statement
     * @return a <code>ResultSet</code> object that contains the data produced
     *         by the given query; never <code>null</code>
     * @throws SQLException if a database access error occurs or the given
     *                      SQL statement produces anything other than a single
     *                      <code>ResultSet</code> object
     */
    public java.sql.ResultSet executeQuery(String sql) throws
            java.sql.SQLException {
        ResultSet rs = callableStatement.executeQuery(sql);
        if (rs == null)
            return null;
        return new ResultSetWrapper30(this, rs);
    }

    /**
     * Retrieves any auto-generated keys created as a result of executing this
     * <code>Statement</code> object. If this <code>Statement</code> object did
     * not generate any keys, an empty <code>ResultSet</code>
     * object is returned.
     *
     * @return a <code>ResultSet</code> object containing the auto-generated key(s)
     *         generated by the execution of this <code>Statement</code> object
     * @throws SQLException if a database access error occurs
     * @since 1.4
     */
    public java.sql.ResultSet getGeneratedKeys() throws java.sql.SQLException {
        ResultSet rs = callableStatement.getGeneratedKeys();
        if (rs == null)
            return null;
        return new ResultSetWrapper30(this, rs);
    }

    /**
     * Retrieves the current result as a <code>ResultSet</code> object.
     * This method should be called only once per result.
     *
     * @return the current result as a <code>ResultSet</code> object or
     *         <code>null</code> if the result is an update count or there are no more results
     * @throws SQLException if a database access error occurs
     * @see #execute
     */
    public java.sql.ResultSet getResultSet() throws java.sql.SQLException {
        ResultSet rs = callableStatement.getResultSet();
        if (rs == null)
            return null;
        return new ResultSetWrapper30(this, rs);
    }


}


