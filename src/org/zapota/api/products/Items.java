
package org.zapota.api.products;

import com.google.gson.annotations.Expose;


public class Items {

    @Expose
    private String result;
    @Expose
    private String code;
    @Expose
    private Info info;

    /**
     * 
     * @return
     *     The result
     */
    public String getResult() {
        return result;
    }

    /**
     * 
     * @param result
     *     The result
     */
    public void setResult(String result) {
        this.result = result;
    }

    public Items withResult(String result) {
        this.result = result;
        return this;
    }

    /**
     * 
     * @return
     *     The code
     */
    public String getCode() {
        return code;
    }

    /**
     * 
     * @param code
     *     The code
     */
    public void setCode(String code) {
        this.code = code;
    }

    public Items withCode(String code) {
        this.code = code;
        return this;
    }

    /**
     * 
     * @return
     *     The info
     */
    public Info getInfo() {
        return info;
    }

    /**
     * 
     * @param info
     *     The info
     */
    public void setInfo(Info info) {
        this.info = info;
    }

    public Items withInfo(Info info) {
        this.info = info;
        return this;
    }

}
