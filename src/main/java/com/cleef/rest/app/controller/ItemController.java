package com.cleef.rest.app.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cleef.rest.app.model.Item;
import com.cleef.rest.app.repository.ItemRepository;

@RestController
@RequestMapping(value = "/app", produces = "application/json")
public class ItemController {

	@Autowired
	private ItemRepository itRepository;

	@GetMapping()
	public List<Item> getAllItems() {
		return itRepository.findAll();
	}

	@PostMapping()
	public Item createItem(@Valid @RequestBody Item item) {
		return itRepository.save(item);
	}

	@DeleteMapping()
	public void deleteItem(@RequestBody Item item) {
		itRepository.delete(item);
	}
}
