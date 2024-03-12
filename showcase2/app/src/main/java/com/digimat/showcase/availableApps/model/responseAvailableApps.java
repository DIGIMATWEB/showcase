
package com.digimat.showcase.availableApps.model;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class responseAvailableApps {

    @SerializedName("resconseCode")
    @Expose
    private Integer resconseCode;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("data")
    @Expose
    private List<dataAvailableApps> data;

    public responseAvailableApps(Integer resconseCode, String message, List<dataAvailableApps> data) {
        super();
        this.resconseCode = resconseCode;
        this.message = message;
        this.data = data;
    }

    public Integer getResconseCode() {
        return resconseCode;
    }

    public void setResconseCode(Integer resconseCode) {
        this.resconseCode = resconseCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<dataAvailableApps> getData() {
        return data;
    }

    public void setData(List<dataAvailableApps> data) {
        this.data = data;
    }

}
