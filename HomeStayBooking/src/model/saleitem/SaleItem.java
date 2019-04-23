package model.saleitem;

import java.io.Serializable;
import java.util.Date;


public class SaleItem implements Serializable {
    private static final long serialVersionUID = 6529685098267757690L;
    private String id;
    private String type;
<<<<<<< HEAD
    private double totalPrice = 0;
    private double rateType;
=======
    private double unitPrice = 0;
    private double rateType;
    private double acreage;
>>>>>>> 514485acaba8a92d2da7c95e450432b09a2c710f
    private Date updateAudit;
    private Date createdAudit;
    private Date issueAudit;
    private String address;
    private int numberOfPerson = 0;
    private String describe;
    private String hostId;

    public SaleItem() {
    }

<<<<<<< HEAD
    public SaleItem(String id, String type, double totalPrice, double rateType, Date updateAudit, Date createdAudit, Date issueAudit, String address, int numberOfPerson, String describe, String hostId) {
        this.id = id;
        this.type = type;
        this.totalPrice = totalPrice;
        this.rateType = rateType;
=======
    public SaleItem(String id, String type, double unitPrice, double rateType, double acreage, Date updateAudit, Date createdAudit, Date issueAudit, String address, int numberOfPerson, String describe, String hostId) {
        this.id = id;
        this.type = type;
        this.unitPrice = unitPrice;
        this.rateType = rateType;
        this.acreage = acreage;
>>>>>>> 514485acaba8a92d2da7c95e450432b09a2c710f
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
<<<<<<< HEAD
        this.rateType = saleItemBuilder.rateType;
=======
        this.unitPrice = saleItemBuilder.unitPrice;
>>>>>>> 514485acaba8a92d2da7c95e450432b09a2c710f
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
<<<<<<< HEAD
=======
    }

    public double getUnitPrice() {
        return unitPrice;
>>>>>>> 514485acaba8a92d2da7c95e450432b09a2c710f
    }

    public double getAcreage() {
        return acreage;
    }

<<<<<<< HEAD
=======
    public int getNumberOfPerson() {
        return numberOfPerson;
    }

    public String getAddress() {
        return address;
    }

>>>>>>> 514485acaba8a92d2da7c95e450432b09a2c710f
    public String getDescribe() {
        return describe;
    }

    public String getHostId() {
        return hostId;
    }

    public double getTotalPrice() {
<<<<<<< HEAD
        return this.totalPrice;
=======
        return this.unitPrice;
>>>>>>> 514485acaba8a92d2da7c95e450432b09a2c710f
    }

    public static class SaleItemBuilder {

<<<<<<< HEAD
        private String id="";
        private String type="";
        private double totalPrice = 0;
        private double rateType=1;
        private Date updateAudit;
        private Date createdAudit;
        private Date issueAudit;
        private String address="";
        private int numberOfPerson = 0;
        private String describe="";
        private String hostId="";


        public SaleItemBuilder(String id, String type, double rateType, String address, String hostId, int numberOfPerson,double totalPrice) {
=======
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
>>>>>>> 514485acaba8a92d2da7c95e450432b09a2c710f
            this.id = id;
            this.type = type;
            this.rateType = rateType;
            this.address = address;
            this.hostId = hostId;
<<<<<<< HEAD
            this.numberOfPerson=numberOfPerson;
            this.totalPrice=totalPrice;
=======
            this.numberOfPerson = numberOfPerson;
            this.unitPrice = unitPrice;
>>>>>>> 514485acaba8a92d2da7c95e450432b09a2c710f
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
<<<<<<< HEAD
=======
            return this;
        }

        public SaleItemBuilder setAcreage(double acreage) {
            this.acreage = acreage;
>>>>>>> 514485acaba8a92d2da7c95e450432b09a2c710f
            return this;
        }

        public SaleItem build() {
            return new SaleItem(this);
        }
    }

}

