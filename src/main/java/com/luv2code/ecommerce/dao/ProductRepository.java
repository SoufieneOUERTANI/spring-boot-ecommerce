package com.luv2code.ecommerce.dao;

import com.luv2code.ecommerce.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestParam;

@CrossOrigin(origins = {"http://localhost:4200", "http://localhost:5200"})
public interface ProductRepository extends JpaRepository<Product, Long> {
    // select * from product where category_id = ?
    // http://localhost:8080/api/products/search/findByCategoryId?id=1
    Page<Product> findByCategoryId(@RequestParam("id") Long id, Pageable pageable);

    //Page<Product> findByNameContaining(@RequestParam("id") Long id, Pageable pageable);
    // http://localhost:7654/api/products/search/findByNameContaining?name=python
    Page<Product> findByNameContaining(@RequestParam("name") String name, Pageable pageable);

}
