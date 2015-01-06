
package org.zapota.api.products;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Prices {

    @Expose
    private String currency;
    @SerializedName("base_price")
    @Expose
    private BasePrice basePrice;
    @SerializedName("tier_prices")
    @Expose
    private List<Object> tierPrices = new ArrayList<Object>();
    @SerializedName("display_prices")
    @Expose
    private List<DisplayPrice> displayPrices = new ArrayList<DisplayPrice>();

    /**
     * 
     * @return
     *     The currency
     */
    public String getCurrency() {
        return currency;
    }

    /**
     * 
     * @param currency
     *     The currency
     */
    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Prices withCurrency(String currency) {
        this.currency = currency;
        return this;
    }

    /**
     * 
     * @return
     *     The basePrice
     */
    public BasePrice getBasePrice() {
        return basePrice;
    }

    /**
     * 
     * @param basePrice
     *     The base_price
     */
    public void setBasePrice(BasePrice basePrice) {
        this.basePrice = basePrice;
    }

    public Prices withBasePrice(BasePrice basePrice) {
        this.basePrice = basePrice;
        return this;
    }

    /**
     * 
     * @return
     *     The tierPrices
     */
    public List<Object> getTierPrices() {
        return tierPrices;
    }

    /**
     * 
     * @param tierPrices
     *     The tier_prices
     */
    public void setTierPrices(List<Object> tierPrices) {
        this.tierPrices = tierPrices;
    }

    public Prices withTierPrices(List<Object> tierPrices) {
        this.tierPrices = tierPrices;
        return this;
    }

    /**
     * 
     * @return
     *     The displayPrices
     */
    public List<DisplayPrice> getDisplayPrices() {
        return displayPrices;
    }

    /**
     * 
     * @param displayPrices
     *     The display_prices
     */
    public void setDisplayPrices(List<DisplayPrice> displayPrices) {
        this.displayPrices = displayPrices;
    }

    public Prices withDisplayPrices(List<DisplayPrice> displayPrices) {
        this.displayPrices = displayPrices;
        return this;
    }

}
