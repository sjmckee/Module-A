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
package org.openmrs.module.modulea.request;

import javax.ws.rs.core.Form;

import org.apache.commons.lang3.StringUtils;
import org.openmrs.module.modulea.util.ModuleAConstants;

/**
 * Request information for exporting files.
 *
 * @author Steve McKee
 */
public class ExportFileRequest extends BaseRequest {
	
	private static final String CONTENT_FILE = "file";
	private static final String ACTION_EXPORT = "export";
	
	private String record;
	private String field;
	private String event;
	private Integer repeatInstance;

	/**
	 * Constructor method
	 */
	public ExportFileRequest(String token, String record, String field, String event, 
	                         Integer repeatInstance) {
		super(token, CONTENT_FILE);
		setRecord(record);
		setField(field);
		setEvent(event);
		setRepeatInstance(repeatInstance);
	}
	
	/**
	 * @return the record
	 */
	public String getRecord() {
		return record;
	}

	/**
	 * @param record the record to set
	 */
	public void setRecord(String record) {
		this.record = record;
	}
	
	/**
	 * @return the field
	 */
	public String getField() {
		return field;
	}
	
	/**
	 * @param field the field to set
	 */
	public void setField(String field) {
		this.field = field;
	}

	/**
	 * @return the event
	 */
	public String getEvent() {
		return event;
	}
	
	/**
	 * @param event the event to set
	 */
	public void setEvent(String event) {
		this.event = event;
	}
	
	/**
	 * @return the repeatInstance
	 */
	public Integer getRepeatInstance() {
		return repeatInstance;
	}
	
	/**
	 * @param repeatInstance the repeatInstance to set
	 */
	public void setRepeatInstance(Integer repeatInstance) {
		this.repeatInstance = repeatInstance;
	}

	/**
	 * @see org.openmrs.module.modulea.request.BaseRequest#createRequestForm()
	 */
	public Form createRequestForm() {
		Form form = super.createRequestForm();
		form.param(ModuleAConstants.FORM_PARAM_ACTION, ACTION_EXPORT);
		if (StringUtils.isNotBlank(getEvent())) {
			form.param(ModuleAConstants.FORM_PARAM_EVENT, getEvent());
		}
		
		if (StringUtils.isNotBlank(getField())) {
			form.param(ModuleAConstants.FORM_PARAM_FIELD, getField());
		}
		
		if (StringUtils.isNotBlank(getRecord())) {
			form.param(ModuleAConstants.FORM_PARAM_RECORD, getRecord());
		}
		
		if (getRepeatInstance() != null) {
			form.param(ModuleAConstants.FORM_PARAM_REPEAT_INSTANCE, String.valueOf(getRepeatInstance()));
		}
		
		return form;
	}

	/**
	 * @see java.lang.Object#hashCode()
	 */
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((event == null) ? 0 : event.hashCode());
		result = prime * result + ((field == null) ? 0 : field.hashCode());
		result = prime * result + ((record == null) ? 0 : record.hashCode());
		result = prime * result + ((repeatInstance == null) ? 0 : repeatInstance.hashCode());
		return result;
	}

	/**
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		ExportFileRequest other = (ExportFileRequest) obj;
		if (event == null) {
			if (other.event != null)
				return false;
		} else if (!event.equals(other.event))
			return false;
		if (field == null) {
			if (other.field != null)
				return false;
		} else if (!field.equals(other.field))
			return false;
		if (record == null) {
			if (other.record != null)
				return false;
		} else if (!record.equals(other.record))
			return false;
		if (repeatInstance == null) {
			if (other.repeatInstance != null)
				return false;
		} else if (!repeatInstance.equals(other.repeatInstance))
			return false;
		return true;
	}

	/**
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return "ExportFileRequest [record=" + record + ", field=" + field + ", event=" + event + ", repeatInstance="
		        + repeatInstance + "]";
	}
}
