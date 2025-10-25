package com.ecommerce.shop.requestDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductRequestDto {
	private Integer id;
	private String name;
	private Double price;
	private String image;
	private String category;
	private Double rating;
}
