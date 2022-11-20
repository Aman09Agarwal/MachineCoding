package com.vm;

import lombok.Data;

@Data
public class ItemShelf {
    Item item;
    int code;
    boolean soldOut;
}
