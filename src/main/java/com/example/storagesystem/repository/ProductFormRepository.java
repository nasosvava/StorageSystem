package com.example.storagesystem.repository;

import com.example.storagesystem.domain.ProductForm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface ProductFormRepository extends JpaRepository<ProductForm,Long> {

    @Query(value = "select SUM(CASE when pf.form_category=\"IMPORT_FORMS\" then s.quantity else -s.quantity end) from product_form pf inner join stock s on pf.id = s.product_form_id\n" +
            "inner join products p on p.id = s.product_id\n" +
            "where s.product_id =: productId  and pf.import_date <=:dateIE;",nativeQuery = true)
    double findProductQuantityForSpecificDate(@Param("productId")Long productID,@Param("dateIE") Date date);
}
