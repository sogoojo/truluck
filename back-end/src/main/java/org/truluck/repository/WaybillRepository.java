package org.truluck.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.truluck.model.Waybill;

public interface WaybillRepository extends JpaRepository<Waybill, Long> {
}
