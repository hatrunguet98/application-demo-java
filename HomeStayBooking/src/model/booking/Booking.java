package model.booking;

public class Booking {
    private String id;
    private String totalPrice;
    private String idHost;
    private String idHomeRender;

    public Booking(String id, String totalPrice, String idHost, String idHomeRender) {
        this.id = id;
        this.totalPrice = totalPrice;
        this.idHost = idHost;
        this.idHomeRender = idHomeRender;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(String totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getIdHost() {
        return idHost;
    }

    public void setIdHost(String idHost) {
        this.idHost = idHost;
    }

    public String getIdHomeRender() {
        return idHomeRender;
    }

    public void setIdHomeRender(String idHomeRender) {
        this.idHomeRender = idHomeRender;
    }
}
