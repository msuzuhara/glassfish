/*
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER.
 *
 * Copyright 1997-2008 Sun Microsystems, Inc. All rights reserved.
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
 *
 *
 * This file incorporates work covered by the following copyright and
 * permission notice:
 *
 * Copyright 2004 The Apache Software Foundation
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */


package org.apache.tomcat.util.digester;


import org.xml.sax.Attributes;


/**
 * Concrete implementations of this class implement actions to be taken when
 * a corresponding nested pattern of XML elements has been matched.
 */

public abstract class Rule {


    // ----------------------------------------------------------- Constructors


    /**
     * Constructor sets the associated Digester.
     *
     * @param digester The digester with which this rule is associated
     * @deprecated The digester instance is now set in the {@link Digester#addRule} method. Use {@link #Rule()} instead.
     */
    public Rule(Digester digester) {

        super();
        setDigester(digester);

    }
    
    /**
     * <p>Base constructor.
     * Now the digester will be set when the rule is added.</p>
     */
    public Rule() {}


    // ----------------------------------------------------- Instance Variables


    /**
     * The Digester with which this Rule is associated.
     */
    protected Digester digester = null;


    /**
     * The namespace URI for which this Rule is relevant, if any.
     */
    protected String namespaceURI = null;


    // ------------------------------------------------------------- Properties


    /**
     * Return the Digester with which this Rule is associated.
     */
    public Digester getDigester() {

        return (this.digester);

    }
    
    /**
     * Set the <code>Digester</code> with which this <code>Rule</code> is associated.
     */
    public void setDigester(Digester digester) {
        
        this.digester = digester;
        
    }

    /**
     * Return the namespace URI for which this Rule is relevant, if any.
     */
    public String getNamespaceURI() {

        return (this.namespaceURI);

    }


    /**
     * Set the namespace URI for which this Rule is relevant, if any.
     *
     * @param namespaceURI Namespace URI for which this Rule is relevant,
     *  or <code>null</code> to match independent of namespace.
     */
    public void setNamespaceURI(String namespaceURI) {

        this.namespaceURI = namespaceURI;

    }


    // --------------------------------------------------------- Public Methods


    /**
     * This method is called when the beginning of a matching XML element
     * is encountered.
     *
     * @param attributes The attribute list of this element
     * @deprecated Use the {@link #begin(String,String,Attributes) begin}
     *   method with <code>namespace</code> and <code>name</code>
     *   parameters instead.
     */
    public void begin(Attributes attributes) throws Exception {

        ;	// The default implementation does nothing

    }


    /**
     * This method is called when the beginning of a matching XML element
     * is encountered. The default implementation delegates to the deprecated
     * method {@link #begin(Attributes) begin} without the 
     * <code>namespace</code> and <code>name</code> parameters, to retain 
     * backwards compatibility.
     *
     * @param namespace the namespace URI of the matching element, or an 
     *   empty string if the parser is not namespace aware or the element has
     *   no namespace
     * @param name the local name if the parser is namespace aware, or just 
     *   the element name otherwise
     * @param attributes The attribute list of this element
     * @since Digester 1.4
     */
    public void begin(String namespace, String name, Attributes attributes)
        throws Exception {

        begin(attributes);

    }


    /**
     * This method is called when the body of a matching XML element
     * is encountered.  If the element has no body, this method is
     * not called at all.
     *
     * @param text The text of the body of this element
     * @deprecated Use the {@link #body(String,String,String) body} method
     *   with <code>namespace</code> and <code>name</code> parameters
     *   instead.
     */
    public void body(String text) throws Exception {

        ;	// The default implementation does nothing

    }


    /**
     * This method is called when the body of a matching XML element is 
     * encountered.  If the element has no body, this method is not called at 
     * all. The default implementation delegates to the deprecated method 
     * {@link #body(String) body} without the <code>namespace</code> and
     * <code>name</code> parameters, to retain backwards compatibility.
     *
     * @param namespace the namespace URI of the matching element, or an 
     *   empty string if the parser is not namespace aware or the element has
     *   no namespace
     * @param name the local name if the parser is namespace aware, or just 
     *   the element name otherwise
     * @param text The text of the body of this element
     * @since Digester 1.4
     */
    public void body(String namespace, String name, String text)
        throws Exception {

        body(text);

    }


    /**
     * This method is called when the end of a matching XML element
     * is encountered.
     * 
     * @deprecated Use the {@link #end(String,String) end} method with 
     *   <code>namespace</code> and <code>name</code> parameters instead.
     */
    public void end() throws Exception {

        ;	// The default implementation does nothing

    }


    /**
     * This method is called when the end of a matching XML element
     * is encountered. The default implementation delegates to the deprecated
     * method {@link #end end} without the 
     * <code>namespace</code> and <code>name</code> parameters, to retain 
     * backwards compatibility.
     *
     * @param namespace the namespace URI of the matching element, or an 
     *   empty string if the parser is not namespace aware or the element has
     *   no namespace
     * @param name the local name if the parser is namespace aware, or just 
     *   the element name otherwise
     * @since Digester 1.4
     */
    public void end(String namespace, String name)
        throws Exception {

        end();

    }


    /**
     * This method is called after all parsing methods have been
     * called, to allow Rules to remove temporary data.
     */
    public void finish() throws Exception {

        ;	// The default implementation does nothing

    }


}
