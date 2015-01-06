
package org.zapota.api.products;


import com.google.gson.annotations.Expose;


public class DisplayPrice {

    @Expose
    private String title;
    @Expose
    private Integer price;
    @Expose
    private String style;

    /**
     * 
     * @return
     *     The title
     */
    public String getTitle() {
        return title;
    }

    /**
     * 
     * @param title
     *     The title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    public DisplayPrice withTitle(String title) {
        this.title = title;
        return this;
    }

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

    public DisplayPrice withPrice(Integer price) {
        this.price = price;
        return this;
    }

    /**
     * 
     * @return
     *     The style
     */
    public String getStyle() {
        return style;
    }

    /**
     * 
     * @param style
     *     The style
     */
    public void setStyle(String style) {
        this.style = style;
    }

    public DisplayPrice withStyle(String style) {
        this.style = style;
        return this;
    }

}
