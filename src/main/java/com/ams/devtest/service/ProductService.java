package com.ams.devtest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.ams.devtest.exception.ProductNotFoundException;
import com.ams.devtest.exception.ThirdPartyException;
import com.ams.devtest.model.ProductDetail;
import com.ams.devtest.model.SimilarIds;
import com.ams.devtest.model.SimilarProducts;

@Service
public class ProductService {
	
	@Autowired
    private RestTemplate restTemplate;
	
	private String url_similarIds = "http://simulado:80/product/{productId}/similarids";
	private String url_product = "http://simulado:80/product/{productId}";

	@Cacheable("productCache")
	public SimilarProducts getProductSimilar(String productId) {
		
		SimilarProducts similarProducts = new SimilarProducts();
		
		try {
			SimilarIds similarIds = restTemplate.getForObject(url_similarIds.replace("{productId}", productId), SimilarIds.class);		
			
			for(String id : similarIds) {
				ProductDetail productDetail = restTemplate.getForObject(url_product.replace("{productId}", id), ProductDetail.class);
				similarProducts.add(productDetail);
			}
		} catch (HttpClientErrorException.NotFound ex) {
		    throw new ProductNotFoundException("Product Not found");
		} catch (Exception ex) {
		    throw new ThirdPartyException("Sorry, we're currently experiencing technical difficulties. Please try again later");
		}
		
		return similarProducts;
	}
	
	

}
