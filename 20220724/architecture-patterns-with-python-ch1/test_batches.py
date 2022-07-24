from datetime import date


class OrderLine:
    def __init__(self, order_id, sku, quantity):
        self.order_id = order_id
        self.sku = sku
        self.quantity = quantity


class Batch:
    def __init__(self, id, sku, quantity, eta):
        self.id = id
        self.sku = sku
        self.available_quantity = quantity
        self.eta = eta

    def allocate(self, line: OrderLine):
        self.available_quantity -= line.quantity


def test_allocating_to_a_batch_reduces_the_available_quantity():
    batch = Batch(id="batch-001", sku="SMALL-TABLE", quantity=20, eta=date.today())

    line = OrderLine(order_id="order-ref", sku="SMALL_TABLE", quantity=2)

    batch.allocate(line)

    assert batch.available_quantity == 1
