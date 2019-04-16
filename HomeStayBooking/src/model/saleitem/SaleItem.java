package model.saleitem;

import java.io.Serializable;
import java.util.Date;


public class SaleItem implements Serializable {
    private static final long serialVersionUID = 6529685098267757690L;
    private String id;
    private String type;
    private double unitPrice = 0;
    private double rateType;
    private double acreage;
    private Date updateAudit;
    private Date createdAudit;
    private Date issueAudit;
    private String address;
    private int numberOfPerson = 0;
    private String describe;
    private String hostId;

    public SaleItem() {
    }

    public SaleItem(String id, String type, double unitPrice, double rateType, double acreage, Date updateAudit, Date createdAudit, Date issueAudit, String address, int numberOfPerson, String describe, String hostId) {
        this.id = id;
        this.type = type;
        this.unitPrice = unitPrice;
        this.rateType = rateType;
        this.acreage = acreage;
        this.updateAudit = updateAudit;
        this.createdAudit = createdAudit;
        this.issueAudit = issueAudit;
        this.address = address;
        this.numberOfPerson = numberOfPerson;
        this.describe = describe;
        this.hostId = hostId;
    }

    public SaleItem(SaleItemBuilder saleItemBuilder) {
        this.id = saleItemBuilder.id;
        this.type = saleItemBuilder.type;
        this.unitPrice = saleItemBuilder.unitPrice;
        this.updateAudit = saleItemBuilder.updateAudit;
        this.createdAudit = saleItemBuilder.createdAudit;
        this.issueAudit = saleItemBuilder.issueAudit;
        this.address = saleItemBuilder.address;
        this.numberOfPerson = saleItemBuilder.numberOfPerson;
        this.describe = saleItemBuilder.describe;
        this.hostId = saleItemBuilder.hostId;
    }

    public String getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public double getRateType() {
        return rateType;
    }

    public Date getUpdateAudit() {
        return updateAudit;
    }

    public Date getCreatedAudit() {
        return createdAudit;
    }

    public Date getIssueAudit() {
        return issueAudit;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public double getAcreage() {
        return acreage;
    }

    public int getNumberOfPerson() {
        return numberOfPerson;
    }

    public String getAddress() {
        return address;
    }

    public String getDescribe() {
        return describe;
    }

    public String getHostId() {
        return hostId;
    }

    public double getTotalPrice() {
        return this.unitPrice;
    }

    public static class SaleItemBuilder {

        private String id = "";
        private String type = "";
        private double unitPrice = 0;
        private double acreage = 0;
        private double rateType = 1;
        private Date updateAudit;
        private Date createdAudit;
        private Date issueAudit;
        private String address = "";
        private int numberOfPerson = 0;
        private String describe = "";
        private String hostId = "";


        public SaleItemBuilder(String id, String type, double rateType, String address, String hostId, int numberOfPerson, double unitPrice) {
            this.id = id;
            this.type = type;
            this.rateType = rateType;
            this.address = address;
            this.hostId = hostId;
            this.numberOfPerson = numberOfPerson;
            this.unitPrice = unitPrice;
        }

        public SaleItemBuilder setNumberOfPerson(int numberOfPerson) {
            this.numberOfPerson = numberOfPerson;
            return this;
        }

        public SaleItemBuilder setDescribe(String describe) {
            this.describe = describe;
            return this;
        }

        public SaleItemBuilder setUpdateAudit(Date updateAudit) {
            this.updateAudit = updateAudit;
            return this;
        }

        public SaleItemBuilder setCreatedAudit(Date createdAudit) {
            this.createdAudit = createdAudit;
            return this;
        }

        public SaleItemBuilder setIssueAudit(Date issueAudit) {
            this.issueAudit = issueAudit;
            return this;
        }

        public SaleItemBuilder setAcreage(double acreage) {
            this.acreage = acreage;
            return this;
        }

        public SaleItem build() {
            return new SaleItem(this);
        }
    }

}

