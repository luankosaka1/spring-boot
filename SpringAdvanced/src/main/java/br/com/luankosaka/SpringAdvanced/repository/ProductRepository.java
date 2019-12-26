package br.com.luankosaka.SpringAdvanced.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.luankosaka.SpringAdvanced.models.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}
