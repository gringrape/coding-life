package com.gringrape.shoppingMall.exceptions

class UserNotFoundException(userId: Long) : Throwable("User Not Found, User: $userId")
