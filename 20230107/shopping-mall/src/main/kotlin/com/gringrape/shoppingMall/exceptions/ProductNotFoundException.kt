package com.gringrape.shoppingMall.exceptions

class ProductNotFoundException(id: Long) : Throwable("Product does not exists, ID:$id")
