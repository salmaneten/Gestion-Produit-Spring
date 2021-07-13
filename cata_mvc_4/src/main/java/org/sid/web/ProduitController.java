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
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
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

        @RequestMapping(value ="/form", method = RequestMethod.GET)
        public String formProduit(Model model){
            model.addAttribute("produit",new Produit());
            return "formProduit";
    }
        @RequestMapping(value = "/save", method = RequestMethod.POST)
        public String save(Model model ,@Valid @ModelAttribute("produit") Produit produit, BindingResult bindingResult){
            if(bindingResult.hasErrors())
            {

                return "formProduit";
            }
            else
            {
                produitRepository.save(produit);
                return "confirmation";
            }
    }
    @RequestMapping(value ="/edit", method = RequestMethod.GET)
    public String editProduit(Model model, Long id){
        Produit p = produitRepository.getById(id);
        model.addAttribute("produit",p);
        return "editProduit";
    }

}
