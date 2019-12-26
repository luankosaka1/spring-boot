package br.com.luankosaka.SpringAdvanced.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.luankosaka.SpringAdvanced.models.Product;
import br.com.luankosaka.SpringAdvanced.repository.ProductRepository;

public class ProductServiceImpl implements ProductService {
	@Autowired
	private ProductRepository productRepository;

	public ProductServiceImpl(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}
	
	@Override
	public List<Product> findAll() {
		return this.productRepository.findAll();
	}

	@Override
	public Product find(Long id) {
		Optional<Product> productExist = this.productRepository.findById(id);
		if (productExist.isPresent()) {
			return productExist.get();
		}
		return null;
	}

	@Override
	public Product create(Product product) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Product update(Long id, Product product) {
		Optional<Product> productExist = this.productRepository.findById(id);
		
		if (productExist.isPresent()) {
			product.setId(productExist.get().getId());
			this.productRepository.save(product);
		}
		
		return null;
	}

	@Override
	public void delete(Long id) {
		Optional<Product> product = this.productRepository.findById(id);
		
		if (product.isPresent()) {
			this.productRepository.delete(product.get());
		}
	}

}
