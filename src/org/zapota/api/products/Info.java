
package org.zapota.api.products;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Info {

    @Expose
    private List<Item> items = new ArrayList<Item>();
    @SerializedName("total_results")
    @Expose
    private Integer totalResults;

    /**
     * 
     * @return
     *     The items
     */
    public List<Item> getItems() {
        return items;
    }

    /**
     * 
     * @param items
     *     The items
     */
    public void setItems(List<Item> items) {
        this.items = items;
    }

    public Info withItems(List<Item> items) {
        this.items = items;
        return this;
    }

    /**
     * 
     * @return
     *     The totalResults
     */
    public Integer getTotalResults() {
        return totalResults;
    }

    /**
     * 
     * @param totalResults
     *     The total_results
     */
    public void setTotalResults(Integer totalResults) {
        this.totalResults = totalResults;
    }

    public Info withTotalResults(Integer totalResults) {
        this.totalResults = totalResults;
        return this;
    }

}
