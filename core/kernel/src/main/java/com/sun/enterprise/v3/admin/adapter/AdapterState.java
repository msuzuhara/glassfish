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

package com.sun.enterprise.v3.admin.adapter;

/** A package-private class that holds the state of the admin adapter.
 *  It also acts as a lock that needs to be synchronized externally.
 *  Note that this class is not thread-safe on its own.
 * @author &#2325;&#2375;&#2342;&#2366;&#2352 (km@dev.java.net)
 * @since GlassFish V3
 */
enum AdapterState {
    
    UNINITIAZED("state.uninitialized", "The Admin Console Adapter is not yet initialized."),
    AUTHENTICATING("state.authenticating", "Authentication required before the Admin Console can be installed."),
    PERMISSION_NEEDED("state.permissionNeeded", "The Admin Console requires your permission before it can be downloaded or installed."),
    PERMISSION_GRANTED("state.permissionGranted", "The Admin Console has your permission to downloaded and install."),
    CANCELED("state.canceled", "The Admin Console installation has been canceled."),
    DOWNLOADING("state.downloading", "The Admin Console Web Application is downloading..."),
    DOWNLOADED("state.downloaded", "The Admin Console Web Application has been downloaded."),
    EXPANDING("state.expanding", "The Admin Console war file is expanding..."),
    EXPANDED("state.expanded", "The Admin Console war file has been expanded."),
    INSTALLING("state.installing", "The Admin Console is installing..."),
    APPLICATION_INSTALLED_BUT_NOT_LOADED("state.installedNotLoaded", "The Admin Console is already installed, but not yet loaded."),
    APPLICATION_LOADING("state.loading", "The Admin Console is loading..."),
    APPLICATION_LOADED("state.loaded", "The Admin Console application is loaded."),
    APPLICATION_NOT_INSTALLED("state.notInstalled", "The Admin Console Application is not yet installed."),
    APPLICATION_PREPARE_UPGRADE("state.prepareRedeploy", "Preparing to upgrade Admin Console Application..."),
    APPLICATION_BACKUP_FALED("state.backupFailed", "Cannot backup previous version of __admingui"),
    APPLICATION_CLEANUP_FALED("state.cleanupFailed", "Exception while cleaning previous instance of admin GUI"),
    APPLICATION_BACKUP_CLEANING("state.cleaningBackup", "Cleaning up temperory backup file..."),
    APPLICATION_BACKUP_CLEANED("state.cleanupFailed", "Temperory backup file removed"),
    APPLICATION_RESTORE("state.restore", "Restoring previously deployed Admin Console..."),
    APPLICATION_UPGRADE_FALED("state.upgradeFailed", "Cannot upgrade Admin Console.");
    
    
    private final String desc;
    private final String i18nKey;
    
    private AdapterState(String i18nKey, String desc) {
	this.i18nKey = i18nKey;
        this.desc = desc;
    }

    /**
     *	This is the key that should be used to retrieve the localized message from a properties file.
     */
    public String getI18NKey() {
	return i18nKey;
    }
    
    @Override
    public String toString() {
        return (desc);
    }
}
