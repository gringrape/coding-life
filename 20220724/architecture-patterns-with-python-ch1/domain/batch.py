from .order_line import OrderLine


class Batch:
    def __init__(self, id, sku, quantity, eta):
        self.id = id
        self.sku = sku
        self.eta = eta
        self._purchased_quantity = quantity
        self._allocations = set()

    def allocate(self, line: OrderLine):
        if self.can_allocate(line):
            self._allocations.add(line)

    def can_allocate(self, line: OrderLine):
        return (self.sku == line.sku) and (self.available_quantity >= line.quantity)

    def deallocate(self, line: OrderLine):
        if line not in self._allocations:
            return
        self._allocations.remove(line)

    @property
    def available_quantity(self) -> int:
        return self._purchased_quantity - sum(
            line.quantity for line in self._allocations
        )
