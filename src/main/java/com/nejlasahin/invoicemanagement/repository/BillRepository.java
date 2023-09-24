package com.nejlasahin.invoicemanagement.repository;

import com.nejlasahin.invoicemanagement.entity.Bill;
import com.nejlasahin.invoicemanagement.enumeration.BillStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.math.BigDecimal;
import java.util.List;

public interface BillRepository extends JpaRepository<Bill, Long> {

    @Query("SELECT sum(b.billAmount) FROM Bill b JOIN b.user u WHERE u.id=:userId and b.status=:status")
    BigDecimal sumByStatusAndUser(Long userId, BillStatus status);

    List<Bill> findAllByStatus(BillStatus status);
}
