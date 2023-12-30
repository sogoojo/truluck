package org.truluck.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.truluck.model.Waybill;
import org.truluck.service.WaybillService;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/waybills")
public class WaybillController {


  @Autowired
  private WaybillService waybillService;

  @GetMapping("/")
  public List<Waybill> defaultAllWaybills()
  { System.out.println("Default search hit");
    return waybillService.getAllWaybills();
  }
/*  @GetMapping("/search")
  public List<Waybill> getAllWaybills(String waybillNumber, String supervisorName, String startDate, String endDate) {
    System.out.print("Search method hit");
    return waybillService.getAllWaybills();
  }*/

  @GetMapping("/search")
  public ResponseEntity<List<Waybill>> searchWaybills(
    @RequestParam(required = false) String waybillNumber,
    @RequestParam(required = false) String supervisorName,
    @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
    @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate) {

    List<Waybill> waybills = waybillService.searchWaybills(waybillNumber, supervisorName, startDate, endDate);
    return ResponseEntity.ok(waybills);
  }



  @PostMapping("/commission")
  public ResponseEntity<Waybill> commissionNewJob(@RequestBody Waybill newWaybill) {
    Waybill savedWaybill = waybillService.commissionNewJob(newWaybill);
    return ResponseEntity.ok(savedWaybill);
  }
}
