package com.example.storagesystem.repository;

import com.example.storagesystem.domain.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface StockRepository  extends JpaRepository<Stock,Long> {


    @Query(value = "select SUM(CASE when pf.form_category=\"IMPORT_FORMS\" then s.quantity else -s.quantity end) from product_form pf inner join stock s on pf.id = s.product_form_id inner join products p on p.id = s.product_id where s.product_id = ?1 and pf.import_date <= ?2 ;\n",nativeQuery = true)
    double findProductQuantityForSpecificDate(Long productId,Date date);

    Stock findByProduct_Id(Long productId);
}
