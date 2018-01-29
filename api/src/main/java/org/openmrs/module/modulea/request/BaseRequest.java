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

import org.openmrs.module.modulea.util.ModuleAConstants;

/**
 * Common request information for Module A.
 * 
 * @author Steve McKee
 */
public class BaseRequest {
	
	private String token;
	private String content;
	private String format = ModuleAConstants.FORMAT_JSON;
	private String returnFormat = ModuleAConstants.FORMAT_JSON;
	
	/**
	 * Constructor method
	 */
	public BaseRequest(String token, String content) {
		setToken(token);
		setContent(content);
	}
	
	/**
	 * @return the token
	 */
	public String getToken() {
		return token;
	}
	
	/**
	 * @param token the token to set
	 */
	public void setToken(String token) {
		this.token = token;
	}
	
	/**
	 * @return the content
	 */
	public String getContent() {
		return content;
	}

	/**
	 * @param content the content to set
	 */
	public void setContent(String content) {
		this.content = content;
	}
	
	/**
	 * @return the format
	 */
	public String getFormat() {
		return format;
	}
	
	/**
	 * @param format the format to set
	 */
	public void setFormat(String format) {
		this.format = format;
	}
	
	/**
	 * @return the returnFormat
	 */
	public String getReturnFormat() {
		return returnFormat;
	}
	
	/**
	 * @param returnFormat the returnFormat to set
	 */
	public void setReturnFormat(String returnFormat) {
		this.returnFormat = returnFormat;
	}

	/**
	 * Create the form used to POST the request to the service.
	 * 
	 * @return Form object containing the information to be posted.
	 */
	public Form createRequestForm() {
		Form form = new Form();
		form.param(ModuleAConstants.FORM_PARAM_TOKEN, getToken());
		form.param(ModuleAConstants.FORM_PARAM_CONTENT, getContent());
		form.param(ModuleAConstants.FORM_PARAM_FORMAT, getFormat());
		form.param(ModuleAConstants.FORM_PARAM_RETURN_FORMAT, getReturnFormat());
		
		return form;
	}

	/**
	 * @see java.lang.Object#hashCode()
	 */
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((content == null) ? 0 : content.hashCode());
		result = prime * result + ((format == null) ? 0 : format.hashCode());
		result = prime * result + ((returnFormat == null) ? 0 : returnFormat.hashCode());
		result = prime * result + ((token == null) ? 0 : token.hashCode());
		return result;
	}

	/**
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BaseRequest other = (BaseRequest) obj;
		if (content == null) {
			if (other.content != null)
				return false;
		} else if (!content.equals(other.content))
			return false;
		if (format == null) {
			if (other.format != null)
				return false;
		} else if (!format.equals(other.format))
			return false;
		if (returnFormat == null) {
			if (other.returnFormat != null)
				return false;
		} else if (!returnFormat.equals(other.returnFormat))
			return false;
		if (token == null) {
			if (other.token != null)
				return false;
		} else if (!token.equals(other.token))
			return false;
		return true;
	}

	/**
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return "BaseRequest [token=" + token + ", content=" + content + ", format=" + format + ", returnFormat="
		        + returnFormat + "]";
	}
}
