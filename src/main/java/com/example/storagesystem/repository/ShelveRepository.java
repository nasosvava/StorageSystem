package com.example.storagesystem.repository;

import com.example.storagesystem.domain.Shelve;
import com.example.storagesystem.repository.customrepository.CustomShelveRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ShelveRepository extends JpaRepository<Shelve ,Long> {
    @Query(value = "SELECT COUNT(id) FROM shelve WHERE storage_id= :id ;\n",nativeQuery = true)
    int countShelveByStorage(Long id);

    @Query(value = "Select * from shelve where id= :id", nativeQuery = true)
    Shelve getShelve(Long id);
}
