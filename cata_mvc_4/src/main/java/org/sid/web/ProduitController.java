package org.sid.web;

import org.sid.dao.ProduitRepository;
import org.sid.entities.Produit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ProduitController {
    @Autowired
    private ProduitRepository produitRepository;
    @RequestMapping(value = "/index")
    public String index(Model model,
                        @RequestParam(name = "page", defaultValue = "0")int p,
                        @RequestParam(name = "size", defaultValue = "3")int s,
                        @RequestParam(name = "mc", defaultValue = "") String mc){
        Page<Produit> Pageproduits = produitRepository.chercher("%"+mc+"%",PageRequest.of(p, s));
        model.addAttribute( "listProduits",Pageproduits.getContent());
        int [] pages = new int[Pageproduits.getTotalPages()];
        model.addAttribute("pages", pages);
        model.addAttribute("size", s);
        model.addAttribute("pageCourante",p);
        model.addAttribute("mc",mc);

        return "produits";
    }
 @RequestMapping(value = "/delete", method = RequestMethod.GET)
        public String delete(Long id, int page, int size, String mc){
        Produit p = produitRepository.getById(id);
        produitRepository.delete(p);
        return "redirect:/index?page="+page+"&size="+size+"&mc="+mc;
    }

}
