package org.sid;

import org.sid.dao.ProduitRepository;
import org.sid.entities.Produit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class CataMvc4Application {

    public static void main(String[] args) {

       ApplicationContext ctx =  SpringApplication.run(CataMvc4Application.class, args);
        ProduitRepository produitRepository = ctx.getBean(ProduitRepository.class);
       /* produitRepository.save(new Produit("HP Laptop 65", 30, 5000));
        produitRepository.save(new Produit("HP pavilion 65", 10, 7000));
        produitRepository.save(new Produit("HP i7 3350", 60, 8500));
        produitRepository.save(new Produit("HP Laptop 65", 30, 5000));
        produitRepository.save(new Produit("HP pavilion 65", 10, 7000));
        produitRepository.save(new Produit("HP i7 3350", 60, 8500));
        produitRepository.save(new Produit("HP Laptop 65", 30, 5000));
        produitRepository.save(new Produit("HP pavilion 65", 10, 7000));
        produitRepository.save(new Produit("HP i7 3350", 60, 8500));
        produitRepository.save(new Produit("HP Laptop 65", 30, 5000));
        produitRepository.save(new Produit("HP pavilion 65", 10, 7000));
        produitRepository.save(new Produit("HP i7 3350", 60, 8500));*/


        produitRepository.findAll().forEach(p -> System.out.println(p.getDesignation()));

    }

}
