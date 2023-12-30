package org.truluck.model;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name = "waybills")
@Getter
@Setter
public class Waybill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String number;

    @Column(name = "client_name", nullable = false)
    private String clientName;

    @Column(name = "truck_number", nullable = false)
    private String truckNumber;

    @Column(name = "date_issued")
    private Date dateIssued;

    @Column(nullable = true)
    private String status;

    @Column(name = "trip_allowance", nullable = false)
    private Integer tripAllowance;

    @Column(name = "invoice_number")
    private String invoiceNumber;

    @Column(name = "supervisor_name")
    private String supervisorName;

    // Constructors, Getters, and Setters
    // ...

/*
  number: string;
  clientName: string;
  truckNumber: string; -
  dateIssued: Date; -
  status: string; (make pending at java end)
  tripAllowance: number; -
  invoiceNumber: string; (make pending at java end)
  supervisorName: string; make nullabe*/
}
