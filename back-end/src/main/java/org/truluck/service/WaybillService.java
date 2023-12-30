package org.truluck.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.truluck.model.Waybill;
//import org.truluck.model.Waybill;
import org.truluck.repository.WaybillRepository;

import java.util.Date;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.Date;
import java.util.List;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.stream.Collectors;


@Service
public class WaybillService {

  private static final Logger LOGGER = Logger.getLogger(WaybillService.class.getName());


  @Autowired
  private WaybillRepository waybillRepository;

  public List<Waybill> searchWaybills(String waybillNumber, String supervisorName, LocalDate startDate, LocalDate endDate) {
    // Log inputs
    LOGGER.info("searchWaybills called with waybillNumber: '" + waybillNumber +
      "', supervisorName: '" + supervisorName +
      "', startDate: " + startDate +
      ", endDate: " + endDate);

    // Create new variables for the potentially modified values
    final String finalWaybillNumber = (waybillNumber != null && !waybillNumber.trim().isEmpty()) ? waybillNumber.trim() : null;
    final String finalSupervisorName = (supervisorName != null && !supervisorName.trim().isEmpty()) ? supervisorName.trim() : null;

    // Convert LocalDate to Date
    Date start = startDate != null ? Date.from(startDate.atStartOfDay(ZoneId.systemDefault()).toInstant()) : null;
    Date end = endDate != null ? Date.from(endDate.plusDays(1).atStartOfDay(ZoneId.systemDefault()).toInstant()) : null;

    // Fetch all waybills
    List<Waybill> allWaybills = waybillRepository.findAll();
    LOGGER.info("Number of waybills retrieved from the database: " + allWaybills.size());

    // Apply filters
    List<Waybill> filteredWaybills = allWaybills.stream()
      .filter(wb ->
        (finalWaybillNumber == null || wb.getNumber() != null && wb.getNumber().equalsIgnoreCase(finalWaybillNumber)) &&
          (finalSupervisorName == null || wb.getSupervisorName() != null && wb.getSupervisorName().equalsIgnoreCase(finalSupervisorName)) &&
          (start == null || wb.getDateIssued() != null && !wb.getDateIssued().before(start)) &&
          (end == null || wb.getDateIssued() != null && !wb.getDateIssued().after(end))
      )
      .collect(Collectors.toList());

    LOGGER.info("Number of waybills after filtering: " + filteredWaybills.size());
    if (filteredWaybills.isEmpty()) {
      LOGGER.info("No waybills found matching the criteria.");
    }

    return filteredWaybills;
  }

/*  public List<Waybill> searchWaybills(String waybillNumber, String supervisorName, LocalDate startDate, LocalDate endDate) {
    LOGGER.info("searchWaybills called with waybillNumber: '" + waybillNumber +
      "', supervisorName: '" + supervisorName +
      "', startDate: " + startDate +
      ", endDate: " + endDate);

    // Create new variables for the potentially modified values
    final String finalWaybillNumber = (waybillNumber != null && !waybillNumber.trim().isEmpty()) ? waybillNumber.trim() : null;
    final String finalSupervisorName = (supervisorName != null && !supervisorName.trim().isEmpty()) ? supervisorName.trim() : null;

    List<Waybill> allWaybills = waybillRepository.findAll();
    LOGGER.info("Number of waybills retrieved from the database: " + allWaybills.size());

    // Apply the filters using the final variables
    List<Waybill> filteredWaybills = allWaybills.stream()
      .filter(wb ->
        // Check if waybillNumber matches (if provided)
        (finalWaybillNumber == null || wb.getNumber() != null && wb.getNumber().equalsIgnoreCase(finalWaybillNumber)) &&
          // Check if supervisorName matches (if provided)
          (finalSupervisorName == null || wb.getSupervisorName() != null && wb.getSupervisorName().equalsIgnoreCase(finalSupervisorName))
      )
      .collect(Collectors.toList());

    LOGGER.info("Number of waybills after filtering: " + filteredWaybills.size());
    if (filteredWaybills.isEmpty()) {
      LOGGER.info("No waybills found matching the criteria.");
    }

    return filteredWaybills;
  }*/

/*  public List<Waybill> searchWaybills(String waybillNumber, String supervisorName, LocalDate startDate, LocalDate endDate) {
    LOGGER.info("searchWaybills called with waybillNumber: '" + waybillNumber +
      "', supervisorName: '" + supervisorName +
      "', startDate: " + startDate +
      ", endDate: " + endDate);

    List<Waybill> allWaybills = waybillRepository.findAll();
    LOGGER.info("Number of waybills retrieved from the database: " + allWaybills.size());

    // Confirm the value of supervisorName being used in the filter
    LOGGER.info("Supervisor name for filtering: '" + supervisorName + "'");

    // Apply the supervisor name filter
    List<Waybill> filteredWaybills = allWaybills.stream()
      .filter(wb -> supervisorName == null ||
        (wb.getSupervisorName() != null && wb.getSupervisorName().trim().equalsIgnoreCase(supervisorName.trim())))
      .collect(Collectors.toList());

    LOGGER.info("Number of waybills after filtering by supervisor name: " + filteredWaybills.size());

    return filteredWaybills;
  }*/

  private LocalDate convertToLocalDateViaInstant(Date dateToConvert) {
    return dateToConvert.toInstant()
      .atZone(ZoneId.systemDefault())
      .toLocalDate();
  }

/*  public List<Waybill> searchWaybills(String waybillNumber, String supervisorName, LocalDate startDate, LocalDate endDate) {
    // Add your search logic here, filtering based on the provided criteria
    // This is an example and should be adapted based on your actual search needs
    return waybillRepository.findAll().stream()
      .filter(wb -> (waybillNumber == null || wb.getNumber().equals(waybillNumber)) &&
        (supervisorName == null || wb.getSupervisorName().equals(supervisorName)) &&
        // Check dates if provided, otherwise ignore
        (startDate == null || wb.getDateIssued().toLocalDate().isAfter(startDate.minusDays(1))) &&
        (endDate == null || wb.getDateIssued().toLocalDate().isBefore(endDate.plusDays(1))))
      .collect(Collectors.toList());
  }*/

/*  public List<Waybill> getMockWaybills() {
      List<Waybill> mockWaybills = new ArrayList<>();
      mockWaybills.add(new Waybill("WB001", "Client A", "TX1234", new Date(), "Delivered", 4000, "", "Sogo"));
      mockWaybills.add(new Waybill("WB002", "Client B", "TX1235", new Date(), "In Transit", 2000, "", "Kola"));
      // Add more mock waybills as needed
      return mockWaybills;
    }*/
  public List<Waybill> getAllWaybills() {
    return waybillRepository.findAll();
  }

  public Waybill commissionNewJob(Waybill newWaybill) {
    // Here you would add any business logic if necessary
    return waybillRepository.save(newWaybill); // Save the waybill to the database
  }
}
