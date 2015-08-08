package catalogue.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import catalogue.dao.IProduitRepository;
import catalogue.entities.Produit;

@RestController
public class CatalogueController {
	
	@Autowired
	private IProduitRepository produitRepository;
	
	@RequestMapping("/test")
	public String test(){
		return"test";
	}
	
	@RequestMapping("/saveProd")
	public Produit saveProd(Produit p){
		produitRepository.save(p);
		return p;
	}
	
	@RequestMapping("/produits")
	public Page<Produit> getProduits(int page){
		return produitRepository.findAll(new PageRequest(page, 5));
		
	}
	
	@RequestMapping("/allproduits")
	public List<Produit> getAll(){
		return produitRepository.findAll();
		
	}
	
	@RequestMapping("/produitsParST")
	public Page<Produit> getSearchProduit(int page ,String ST){
		return produitRepository.produitbysearchterm("%"+ST+"%", new PageRequest(page, 5));
		
	}
	
	@RequestMapping("/getProduit")
	public Produit getOne(Long ref){
		return produitRepository.findOne(ref);
		
	}
	
	@RequestMapping("/delete")
	public  boolean delete(Long ref){
		 produitRepository.delete(ref);
		 return true;
		
	}
	
	@RequestMapping("/update")
	public Produit update(Produit p){
		 produitRepository.saveAndFlush(p);
		return p;
	}
	

}
