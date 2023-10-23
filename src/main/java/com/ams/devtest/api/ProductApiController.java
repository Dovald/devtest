package com.ams.devtest.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.ams.devtest.model.SimilarProducts;
import com.ams.devtest.service.ProductService;

import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Schema;

@RestController
public class ProductApiController implements ProductApi {
	
	@Autowired
    private ProductService productService;

    public ResponseEntity<SimilarProducts> getProductSimilar(@Parameter(in = ParameterIn.PATH, description = "", required=true, schema=@Schema()) @PathVariable("productId") String productId) {
        return ResponseEntity.ok(productService.getProductSimilar(productId));
    }

}
