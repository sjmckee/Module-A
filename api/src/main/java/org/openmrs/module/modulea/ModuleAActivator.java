/**
 * The contents of this file are subject to the OpenMRS Public License
 * Version 1.0 (the "License"); you may not use this file except in
 * compliance with the License. You may obtain a copy of the License at
 * http://license.openmrs.org
 *
 * Software distributed under the License is distributed on an "AS IS"
 * basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
 * License for the specific language governing rights and limitations
 * under the License.
 *
 * Copyright (C) OpenMRS, LLC.  All Rights Reserved.
 */
package org.openmrs.module.modulea;

import java.util.Iterator;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openmrs.GlobalProperty;
import org.openmrs.api.AdministrationService;
import org.openmrs.api.context.Context;
import org.openmrs.module.BaseModuleActivator;

/**
 * Activator class for the Module A module.
 *
 * @author Steve McKee
 */
public class ModuleAActivator extends BaseModuleActivator {
	
	private Log log = LogFactory.getLog(this.getClass());
	
	/**
	 * @see org.openmrs.module.BaseModuleActivator#started()
	 */
	public void started() {
		this.log.info("Starting Module A");
		
		//check that all the required global properties are set
		checkGlobalProperties();
	}
	
	/**
	 * Checks to see if the global properties for Module A are populated.
	 */
	private void checkGlobalProperties() {
		try {
			AdministrationService adminService = Context.getAdministrationService();
			
			Iterator<GlobalProperty> properties = adminService.getAllGlobalProperties().iterator();
			GlobalProperty currProperty = null;
			String currValue = null;
			String currName = null;
			
			while (properties.hasNext()) {
				currProperty = properties.next();
				currName = currProperty.getProperty();
				if (currName.startsWith("modulea")) {
					currValue = currProperty.getPropertyValue();
					if (StringUtils.isBlank(currValue)) {
						this.log.error("You must set a value for global property: " + currName);
					}
				}
			}
		}
		catch (Exception e) {
			this.log.error("Error checking global properties for the Module A module", e);
		}
	}
	
	/**
	 * @see org.openmrs.module.BaseModuleActivator#stopped()
	 */
	public void stopped() {
		this.log.info("Shutting down Module A");
	}
	
}