package com.comcast.GenericUtils;

import io.restassured.response.Response;
/**
 * Restassured specific generic methods
 * @author Aditya
 *
 */

public class RestAssuredUtility {
	/**
	 * retuns json data wrt json path
	 * @param response
	 * @param jsonxpath
	 */
	public String jsonPathConstant(Response response,String jsonxpath) {
		String jsondata=response.jsonPath().get(jsonxpath);
		return jsondata;
	}

}
