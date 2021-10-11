package com.example.storagesystem.service;

import com.example.storagesystem.domain.Item;

import java.util.List;

public interface ItemService {

    Item saveItem(Item item);

    List<Item> items();

    Item updateItem(Item item);

    void deleteItem(String barcode);
}
