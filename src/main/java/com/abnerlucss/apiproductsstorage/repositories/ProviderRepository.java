package com.abnerlucss.apiproductsstorage.repositories;

import com.abnerlucss.apiproductsstorage.models.Provider;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ProviderRepository extends JpaRepository<Provider, UUID> {
}
