import pytest

from model import Batch, OrderLine, allocate

from exceptions import OutOfStock

import datetime

date = datetime.date


def today():
    return date.today()


def tomorrow():
    return date.today() + datetime.timedelta(days=1)


def later():
    return date.today() + datetime.timedelta(days=10)


def test_prefers_current_stock_batches_to_shipments():
    in_stock_batch = Batch(
        id="in-stock-batch",
        sku="RETRO-CLOCK",
        quantity=100,
        eta=None,
    )
    shipment_batch = Batch(
        id="shipment-batch",
        sku="RETRO-CLOCK",
        quantity=100,
        eta=tomorrow(),
    )

    line = OrderLine(order_id="oref", sku="RETRO-CLOCK", quantity=10)

    allocate(orderline=line, batches=[in_stock_batch, shipment_batch])

    assert in_stock_batch.available_quantity == 90
    assert shipment_batch.available_quantity == 100


def test_prefers_earlier_batch():
    earliest = Batch(id="batch1", sku="SPOON", quantity=100, eta=today())
    medium = Batch(id="batch2", sku="SPOON", quantity=100, eta=tomorrow())
    latest = Batch(id="batch3", sku="SPOON", quantity=100, eta=later())

    line = OrderLine(order_id="order1", sku="SPOON", quantity=10)

    allocate(line, [medium, earliest, latest])

    assert earliest.available_quantity == 90
    assert medium.available_quantity == 100
    assert latest.available_quantity == 100


def test_raises_out_of_stock_exception_if_cannot_allocate():
    batch = Batch(id="batch-1", sku="PORK", quantity=10, eta=tomorrow())
    orderline = OrderLine(order_id="order-1", sku="PORK", quantity=10)

    allocate(orderline=orderline, batches=[batch])

    with pytest.raises(OutOfStock):
        allocate(
            orderline=OrderLine(order_id="order-2", sku="PORK", quantity=1),
            batches=[batch],
        )
