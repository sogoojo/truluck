package org.truluck.model;

import java.util.Date;
public class Waybill_old {
  private String number;
  private String client;
  private String truck;
  private Date date;
  private String status;
  private int trip;
  private String invoice;
  private String supervisor;

  // Constructor
  public Waybill_old(String number, String client, String truck, Date date, String status, int trip, String invoice, String supervisor) {
    this.number = number;
    this.client = client;
    this.truck = truck;
    this.date = date;
    this.status = status;
    this.trip = trip;
    this.invoice = invoice;
    this.supervisor = supervisor;
  }

  // Getters
  public String getNumber() {
    return number;
  }

  public String getClient() {
    return client;
  }

  public String getTruck() {
    return truck;
  }

  public Date getDate() {
    return date;
  }

  public String getStatus() {
    return status;
  }

  public int getTrip() {
    return trip;
  }

  public String getInvoice() {
    return invoice;
  }

  public String getSupervisor() {
    return supervisor;
  }

  // Setters (if you need to update properties)
  // ...

  // toString() method for debugging
  @Override
  public String toString() {
    return "Waybill{" +
      "number='" + number + '\'' +
      ", client='" + client + '\'' +
      ", truck='" + truck + '\'' +
      ", date=" + date +
      ", status='" + status + '\'' +
      ", trip=" + trip +
      ", invoice='" + invoice + '\'' +
      ", supervisor='" + supervisor + '\'' +
      '}';
  }

}
