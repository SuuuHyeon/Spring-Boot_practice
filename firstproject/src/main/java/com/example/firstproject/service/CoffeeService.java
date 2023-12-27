package com.example.firstproject.service;

import com.example.firstproject.dto.CoffeeDto;
import com.example.firstproject.entity.Article;
import com.example.firstproject.entity.Coffee;
import com.example.firstproject.repository.CoffeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CoffeeService {
    @Autowired
    private CoffeeRepository coffeeRepository;

    public List<Coffee> index() {
        return coffeeRepository.findAll();
    }

    public Coffee show(@PathVariable Long id) {
        return coffeeRepository.findById(id).orElse(null);
    }

    public Coffee update(Long id, CoffeeDto dto) {
        Coffee coffee = dto.toEntity();
        Coffee target = coffeeRepository.findById(id).orElse(null);
        if (target == null || id != coffee.getId())
            return null;
        target.patch(coffee);
        Coffee updated = coffeeRepository.save(target);
        return updated;
    }

    public Coffee create(CoffeeDto dto) {
        Coffee created = dto.toEntity();
        if (created.getId() != null) {
            return null;
        }
        return coffeeRepository.save(created);

    }

    public Coffee delete(Long id) {
        Coffee target = coffeeRepository.findById(id).orElse(null);
        if (target == null)
            return null;
        coffeeRepository.delete(target);
        return target;
    }

    public List<Coffee> createCoffees(List<CoffeeDto> dtos) {
        List<Coffee> coffeeList = dtos.stream()
                .map(dto -> dto.toEntity())
                .collect(Collectors.toList());
        coffeeList.stream().forEach(coffee -> coffeeRepository.save(coffee));
        // 강제 예외
        coffeeRepository.findById(-1L).orElseThrow(() -> new IllegalArgumentException("트랜잭션 실패"));

        return coffeeList;
    }
}
