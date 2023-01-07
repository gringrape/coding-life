package com.gringrape.board.exceptions

class PostNotFoundException(id: Long) : Throwable(message = "Post ID Not Found, id=$id")
