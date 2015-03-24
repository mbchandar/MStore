package org.zapota.api.shoppingcart;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import com.google.gson.annotations.Expose;

public class ShoppingCart {

	@Expose
	private String result;
	@Expose
	private String code;
	@Expose
	private Info info;

	/**
	 * 
	 * @return The result
	 */
	public String getResult() {
		return result;
	}

	/**
	 * 
	 * @param result
	 *            The result
	 */
	public void setResult(String result) {
		this.result = result;
	}

	/**
	 * 
	 * @return The code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * 
	 * @param code
	 *            The code
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * 
	 * @return The info
	 */
	public Info getInfo() {
		return info;
	}

	/**
	 * 
	 * @param info
	 *            The info
	 */
	public void setInfo(Info info) {
		this.info = info;
	}

}