package org.zapota.api.shoppingcart;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Info {

	@SerializedName("cart_items_count")
	@Expose
	private Integer cartItemsCount;
	@SerializedName("cart_items")
	@Expose
	private List<CartItem> cartItems = new ArrayList<CartItem>();
	@Expose
	private List<Object> messages = new ArrayList<Object>();
	@SerializedName("price_infos")
	@Expose
	private List<PriceInfo> priceInfos = new ArrayList<PriceInfo>();
	@SerializedName("payment_methods")
	@Expose
	private List<Object> paymentMethods = new ArrayList<Object>();
	@SerializedName("valid_to_checkout")
	@Expose
	private Boolean validToCheckout;
	@SerializedName("is_virtual")
	@Expose
	private Boolean isVirtual;

	/**
	 * 
	 * @return The cartItemsCount
	 */
	public Integer getCartItemsCount() {
		return cartItemsCount;
	}

	/**
	 * 
	 * @param cartItemsCount
	 *            The cart_items_count
	 */
	public void setCartItemsCount(Integer cartItemsCount) {
		this.cartItemsCount = cartItemsCount;
	}

	/**
	 * 
	 * @return The cartItems
	 */
	public List<CartItem> getCartItems() {
		return cartItems;
	}

	/**
	 * 
	 * @param cartItems
	 *            The cart_items
	 */
	public void setCartItems(List<CartItem> cartItems) {
		this.cartItems = cartItems;
	}

	/**
	 * 
	 * @return The messages
	 */
	public List<Object> getMessages() {
		return messages;
	}

	/**
	 * 
	 * @param messages
	 *            The messages
	 */
	public void setMessages(List<Object> messages) {
		this.messages = messages;
	}

	/**
	 * 
	 * @return The priceInfos
	 */
	public List<PriceInfo> getPriceInfos() {
		return priceInfos;
	}

	/**
	 * 
	 * @param priceInfos
	 *            The price_infos
	 */
	public void setPriceInfos(List<PriceInfo> priceInfos) {
		this.priceInfos = priceInfos;
	}

	/**
	 * 
	 * @return The paymentMethods
	 */
	public List<Object> getPaymentMethods() {
		return paymentMethods;
	}

	/**
	 * 
	 * @param paymentMethods
	 *            The payment_methods
	 */
	public void setPaymentMethods(List<Object> paymentMethods) {
		this.paymentMethods = paymentMethods;
	}

	/**
	 * 
	 * @return The validToCheckout
	 */
	public Boolean getValidToCheckout() {
		return validToCheckout;
	}

	/**
	 * 
	 * @param validToCheckout
	 *            The valid_to_checkout
	 */
	public void setValidToCheckout(Boolean validToCheckout) {
		this.validToCheckout = validToCheckout;
	}

	/**
	 * 
	 * @return The isVirtual
	 */
	public Boolean getIsVirtual() {
		return isVirtual;
	}

	/**
	 * 
	 * @param isVirtual
	 *            The is_virtual
	 */
	public void setIsVirtual(Boolean isVirtual) {
		this.isVirtual = isVirtual;
	}

}
