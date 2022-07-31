from datetime import date

from dataclasses import dataclass

from model import Batch, OrderLine


def make_batch_and_line(sku, line_quantity, batch_quantity):
    return (
        Batch(id="batch-001", sku=sku, quantity=batch_quantity, eta=date.today()),
        OrderLine(order_id="order-123", sku=sku, quantity=line_quantity),
    )


def test_allocating_to_a_batch_reduces_the_available_quantity():
    batch_quantity = 20
    line_quantity = 2

    batch, line = make_batch_and_line(
        sku="SMALL-TABLE",
        batch_quantity=batch_quantity,
        line_quantity=line_quantity,
    )

    batch.allocate(line)

    assert batch.available_quantity == 18


def test_can_allocate_if_available_greater_than_required():
    large_batch, small_line = make_batch_and_line(
        sku="ELEGANT-LAMP",
        batch_quantity=20,
        line_quantity=2,
    )

    assert large_batch.can_allocate(small_line)


def test_can_allocate_if_available_equal_to_required():
    large_batch, small_line = make_batch_and_line(
        sku="ELEGANT-LAMP",
        batch_quantity=10,
        line_quantity=10,
    )

    assert large_batch.can_allocate(small_line)


def test_cannnot_allocate_if_available_smaller_than_required():
    small_batch, large_line = make_batch_and_line(
        sku="ELEGANT-LAMP",
        batch_quantity=10,
        line_quantity=15,
    )

    assert small_batch.can_allocate(large_line) is False


def test_cannot_allocate_if_skus_do_not_match():
    batch = Batch(id="batch-001", sku="TOASTER", quantity=20, eta=date.today())
    line = OrderLine(order_id="order-123", sku="EXPENSIVE-TOASTER", quantity=2)

    assert batch.can_allocate(line) is False


def test_can_only_deallocate_allocated_lines():
    batch, unallocated_line = make_batch_and_line(
        sku="DECORATIVE_TRINCATE",
        batch_quantity=20,
        line_quantity=2,
    )

    batch.deallocate(unallocated_line)

    assert batch.available_quantity == 20


def test_deallocation_increase_available_quantity():
    batch, line = make_batch_and_line(
        sku="DECORATIVE_TRINCATE",
        batch_quantity=20,
        line_quantity=2,
    )

    batch.allocate(line)

    assert batch.available_quantity == 18

    batch.deallocate(line)

    assert batch.available_quantity == 20
