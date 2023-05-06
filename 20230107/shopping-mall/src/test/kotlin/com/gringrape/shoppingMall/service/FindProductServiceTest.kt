package com.gringrape.shoppingMall.service

import com.gringrape.shoppingMall.domain.Product
import com.gringrape.shoppingMall.domain.ProductRepository
import com.gringrape.shoppingMall.exceptions.ProductNotFoundException
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe
import io.mockk.every
import io.mockk.mockk

class FindProductServiceTest : DescribeSpec({

    lateinit var findProductService: FindProductService
    lateinit var productRepository: ProductRepository

    beforeEach {
        productRepository = mockk()
        findProductService = FindProductService(productRepository)
    }

    describe("list") {
        val products = listOf<Product>()

        beforeEach {
            every { productRepository.findAll() } returns products
        }

        it("returns products") {
            findProductService.list() shouldBe products
        }
    }

    describe("findOne") {
        val id = 1L
        val product = Product.fake()

        context("when product found") {
            beforeEach {
                every { productRepository.findById(id) } returns product
            }

            it("returns product") {
                findProductService.findOne(id) shouldBe product
            }
        }

        context("when product not found") {
            beforeEach {
                every { productRepository.findById(id) } returns null
            }

            it("should throw exception") {
                shouldThrow<ProductNotFoundException> {
                    findProductService.findOne(id)
                }
            }
        }
    }

})
