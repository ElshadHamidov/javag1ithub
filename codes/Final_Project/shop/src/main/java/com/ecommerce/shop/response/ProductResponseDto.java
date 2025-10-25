package com.ecommerce.shop.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductResponseDto {
	private Integer id;
	private String name;
	private Double price;
	private String image;
	private Double rating;
	private String category;
}
