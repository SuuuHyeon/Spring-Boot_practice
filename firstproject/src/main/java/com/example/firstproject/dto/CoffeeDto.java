package com.example.firstproject.dto;

import com.example.firstproject.entity.Coffee;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
public class CoffeeDto {
    private Long id;
    private String name;
    private int price;

    public Coffee toEntity() {
        return new Coffee(id, name, price);
    }
}


