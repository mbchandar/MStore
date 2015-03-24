package org.zapota.api.shoppingcart;

import com.google.gson.annotations.Expose;

public class PriceInfo {

	@Expose
	private String title;
	@Expose
	private String type;
	@Expose
	private Integer price;
	@Expose
	private String currency;
	@Expose
	private Integer position;

	/**
	 * 
	 * @return The title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * 
	 * @param title
	 *            The title
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * 
	 * @return The type
	 */
	public String getType() {
		return type;
	}

	/**
	 * 
	 * @param type
	 *            The type
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * 
	 * @return The price
	 */
	public Integer getPrice() {
		return price;
	}

	/**
	 * 
	 * @param price
	 *            The price
	 */
	public void setPrice(Integer price) {
		this.price = price;
	}

	/**
	 * 
	 * @return The currency
	 */
	public String getCurrency() {
		return currency;
	}

	/**
	 * 
	 * @param currency
	 *            The currency
	 */
	public void setCurrency(String currency) {
		this.currency = currency;
	}

	/**
	 * 
	 * @return The position
	 */
	public Integer getPosition() {
		return position;
	}

	/**
	 * 
	 * @param position
	 *            The position
	 */
	public void setPosition(Integer position) {
		this.position = position;
	}

}
