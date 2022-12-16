package xyz.andrasfindt.loafshredding;

import com.google.gson.Gson;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import xyz.andrasfindt.loafshredding.gson.DateAdapter;

import java.util.Date;

public class ScheduleEvent {
    @SerializedName("Id")
    private String id;
    @SerializedName("Title")
    private String title;
    @SerializedName("SubBlock")
    private String subBlock;
    @SerializedName("EndDate")
    @JsonAdapter(DateAdapter.class)
    private Date endDate;
    @SerializedName("Description")
    private String description;
    @SerializedName("Reason")
    private String reason;
    @SerializedName("StartDate")
    @JsonAdapter(DateAdapter.class)
    private Date startDate;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubBlock() {
        return subBlock;
    }

    public void setSubBlock(String subBlock) {
        this.subBlock = subBlock;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}
