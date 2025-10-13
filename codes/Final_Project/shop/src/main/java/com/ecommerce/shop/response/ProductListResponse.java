package com.ecommerce.shop.response;

import java.util.List;

import com.ecommerce.shop.entity.Product;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductListResponse {

	private List<Product> products;
}
