package org.zapota.api.shoppingcart;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CartItem {

	@SerializedName("cart_item_id")
	@Expose
	private Integer cartItemId;
	@SerializedName("item_id")
	@Expose
	private Integer itemId;
	@SerializedName("out_of_stock")
	@Expose
	private Boolean outOfStock;
	@SerializedName("item_title")
	@Expose
	private String itemTitle;
	@SerializedName("item_url")
	@Expose
	private String itemUrl;
	@Expose
	private String currency;
	@SerializedName("item_price")
	@Expose
	private Integer itemPrice;
	@Expose
	private Integer qty;
	@SerializedName("display_attributes")
	@Expose
	private Object displayAttributes;
	@SerializedName("thumbnail_pic_url")
	@Expose
	private String thumbnailPicUrl;
	@SerializedName("short_description")
	@Expose
	private Object shortDescription;
	@SerializedName("post_free")
	@Expose
	private Boolean postFree;

	/**
	 * 
	 * @return The cartItemId
	 */
	public Integer getCartItemId() {
		return cartItemId;
	}

	/**
	 * 
	 * @param cartItemId
	 *            The cart_item_id
	 */
	public void setCartItemId(Integer cartItemId) {
		this.cartItemId = cartItemId;
	}

	/**
	 * 
	 * @return The itemId
	 */
	public Integer getItemId() {
		return itemId;
	}

	/**
	 * 
	 * @param itemId
	 *            The item_id
	 */
	public void setItemId(Integer itemId) {
		this.itemId = itemId;
	}

	/**
	 * 
	 * @return The outOfStock
	 */
	public Boolean getOutOfStock() {
		return outOfStock;
	}

	/**
	 * 
	 * @param outOfStock
	 *            The out_of_stock
	 */
	public void setOutOfStock(Boolean outOfStock) {
		this.outOfStock = outOfStock;
	}

	/**
	 * 
	 * @return The itemTitle
	 */
	public String getItemTitle() {
		return itemTitle;
	}

	/**
	 * 
	 * @param itemTitle
	 *            The item_title
	 */
	public void setItemTitle(String itemTitle) {
		this.itemTitle = itemTitle;
	}

	/**
	 * 
	 * @return The itemUrl
	 */
	public String getItemUrl() {
		return itemUrl;
	}

	/**
	 * 
	 * @param itemUrl
	 *            The item_url
	 */
	public void setItemUrl(String itemUrl) {
		this.itemUrl = itemUrl;
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
	 * @return The itemPrice
	 */
	public Integer getItemPrice() {
		return itemPrice;
	}

	/**
	 * 
	 * @param itemPrice
	 *            The item_price
	 */
	public void setItemPrice(Integer itemPrice) {
		this.itemPrice = itemPrice;
	}

	/**
	 * 
	 * @return The qty
	 */
	public Integer getQty() {
		return qty;
	}

	/**
	 * 
	 * @param qty
	 *            The qty
	 */
	public void setQty(Integer qty) {
		this.qty = qty;
	}

	/**
	 * 
	 * @return The displayAttributes
	 */
	public Object getDisplayAttributes() {
		return displayAttributes;
	}

	/**
	 * 
	 * @param displayAttributes
	 *            The display_attributes
	 */
	public void setDisplayAttributes(Object displayAttributes) {
		this.displayAttributes = displayAttributes;
	}

	/**
	 * 
	 * @return The thumbnailPicUrl
	 */
	public String getThumbnailPicUrl() {
		return thumbnailPicUrl;
	}

	/**
	 * 
	 * @param thumbnailPicUrl
	 *            The thumbnail_pic_url
	 */
	public void setThumbnailPicUrl(String thumbnailPicUrl) {
		this.thumbnailPicUrl = thumbnailPicUrl;
	}

	/**
	 * 
	 * @return The shortDescription
	 */
	public Object getShortDescription() {
		return shortDescription;
	}

	/**
	 * 
	 * @param shortDescription
	 *            The short_description
	 */
	public void setShortDescription(Object shortDescription) {
		this.shortDescription = shortDescription;
	}

	/**
	 * 
	 * @return The postFree
	 */
	public Boolean getPostFree() {
		return postFree;
	}

	/**
	 * 
	 * @param postFree
	 *            The post_free
	 */
	public void setPostFree(Boolean postFree) {
		this.postFree = postFree;
	}

}
