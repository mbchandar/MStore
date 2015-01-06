
package org.zapota.api.products;


import com.google.gson.annotations.Expose;


public class BasePrice {

    @Expose
    private Integer price;

    /**
     * 
     * @return
     *     The price
     */
    public Integer getPrice() {
        return price;
    }

    /**
     * 
     * @param price
     *     The price
     */
    public void setPrice(Integer price) {
        this.price = price;
    }

    public BasePrice withPrice(Integer price) {
        this.price = price;
        return this;
    }

}
