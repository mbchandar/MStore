
package org.zapota.api.products;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Item {

    @SerializedName("item_id")
    @Expose
    private String itemId;
    @SerializedName("item_title")
    @Expose
    private String itemTitle;
    @SerializedName("item_url")
    @Expose
    private String itemUrl;
    @Expose
    private String qty;
    @SerializedName("thumbnail_pic_url")
    @Expose
    private String thumbnailPicUrl;
    @SerializedName("is_virtual")
    @Expose
    private Boolean isVirtual;
    @SerializedName("allow_add_to_cart")
    @Expose
    private Boolean allowAddToCart;
    @SerializedName("item_type")
    @Expose
    private String itemType;
    @SerializedName("item_status")
    @Expose
    private String itemStatus;
    @SerializedName("rating_count")
    @Expose
    private String ratingCount;
    @SerializedName("rating_score")
    @Expose
    private Integer ratingScore;
    @Expose
    private Prices prices;

    /**
     * 
     * @return
     *     The itemId
     */
    public String getItemId() {
        return itemId;
    }

    /**
     * 
     * @param itemId
     *     The item_id
     */
    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public Item withItemId(String itemId) {
        this.itemId = itemId;
        return this;
    }

    /**
     * 
     * @return
     *     The itemTitle
     */
    public String getItemTitle() {
        return itemTitle;
    }

    /**
     * 
     * @param itemTitle
     *     The item_title
     */
    public void setItemTitle(String itemTitle) {
        this.itemTitle = itemTitle;
    }

    public Item withItemTitle(String itemTitle) {
        this.itemTitle = itemTitle;
        return this;
    }

    /**
     * 
     * @return
     *     The itemUrl
     */
    public String getItemUrl() {
        return itemUrl;
    }

    /**
     * 
     * @param itemUrl
     *     The item_url
     */
    public void setItemUrl(String itemUrl) {
        this.itemUrl = itemUrl;
    }

    public Item withItemUrl(String itemUrl) {
        this.itemUrl = itemUrl;
        return this;
    }

    /**
     * 
     * @return
     *     The qty
     */
    public String getQty() {
        return qty;
    }

    /**
     * 
     * @param qty
     *     The qty
     */
    public void setQty(String qty) {
        this.qty = qty;
    }

    public Item withQty(String qty) {
        this.qty = qty;
        return this;
    }

    /**
     * 
     * @return
     *     The thumbnailPicUrl
     */
    public String getThumbnailPicUrl() {
        return thumbnailPicUrl;
    }

    /**
     * 
     * @param thumbnailPicUrl
     *     The thumbnail_pic_url
     */
    public void setThumbnailPicUrl(String thumbnailPicUrl) {
        this.thumbnailPicUrl = thumbnailPicUrl;
    }

    public Item withThumbnailPicUrl(String thumbnailPicUrl) {
        this.thumbnailPicUrl = thumbnailPicUrl;
        return this;
    }

    /**
     * 
     * @return
     *     The isVirtual
     */
    public Boolean getIsVirtual() {
        return isVirtual;
    }

    /**
     * 
     * @param isVirtual
     *     The is_virtual
     */
    public void setIsVirtual(Boolean isVirtual) {
        this.isVirtual = isVirtual;
    }

    public Item withIsVirtual(Boolean isVirtual) {
        this.isVirtual = isVirtual;
        return this;
    }

    /**
     * 
     * @return
     *     The allowAddToCart
     */
    public Boolean getAllowAddToCart() {
        return allowAddToCart;
    }

    /**
     * 
     * @param allowAddToCart
     *     The allow_add_to_cart
     */
    public void setAllowAddToCart(Boolean allowAddToCart) {
        this.allowAddToCart = allowAddToCart;
    }

    public Item withAllowAddToCart(Boolean allowAddToCart) {
        this.allowAddToCart = allowAddToCart;
        return this;
    }

    /**
     * 
     * @return
     *     The itemType
     */
    public String getItemType() {
        return itemType;
    }

    /**
     * 
     * @param itemType
     *     The item_type
     */
    public void setItemType(String itemType) {
        this.itemType = itemType;
    }

    public Item withItemType(String itemType) {
        this.itemType = itemType;
        return this;
    }

    /**
     * 
     * @return
     *     The itemStatus
     */
    public String getItemStatus() {
        return itemStatus;
    }

    /**
     * 
     * @param itemStatus
     *     The item_status
     */
    public void setItemStatus(String itemStatus) {
        this.itemStatus = itemStatus;
    }

    public Item withItemStatus(String itemStatus) {
        this.itemStatus = itemStatus;
        return this;
    }

    /**
     * 
     * @return
     *     The ratingCount
     */
    public String getRatingCount() {
        return ratingCount;
    }

    /**
     * 
     * @param ratingCount
     *     The rating_count
     */
    public void setRatingCount(String ratingCount) {
        this.ratingCount = ratingCount;
    }

    public Item withRatingCount(String ratingCount) {
        this.ratingCount = ratingCount;
        return this;
    }

    /**
     * 
     * @return
     *     The ratingScore
     */
    public Integer getRatingScore() {
        return ratingScore;
    }

    /**
     * 
     * @param ratingScore
     *     The rating_score
     */
    public void setRatingScore(Integer ratingScore) {
        this.ratingScore = ratingScore;
    }

    public Item withRatingScore(Integer ratingScore) {
        this.ratingScore = ratingScore;
        return this;
    }

    /**
     * 
     * @return
     *     The prices
     */
    public Prices getPrices() {
        return prices;
    }

    /**
     * 
     * @param prices
     *     The prices
     */
    public void setPrices(Prices prices) {
        this.prices = prices;
    }

    public Item withPrices(Prices prices) {
        this.prices = prices;
        return this;
    }

}
