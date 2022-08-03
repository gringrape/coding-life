from model import OrderLine


def test_orderline_mapper_can_load_lines(session):
    session.execute(
        "INSERT INTO order_lines (order_id, sku, quantity) VALUES"
        '("order1", "RED-CHAIR", 12)'
    )

    line = [OrderLine(order_id="order1", sku="RED-CHAIR", quantity=12)]

    assert session.query(OrderLine).all() == line


def test_orderline_mapper_can_save_lines(session):
    new_line = OrderLine(order_id="order1", sku="SPOON", quantity=10)

    session.add(new_line)
    session.commit()

    rows = list(session.execute('SELECT order_id, sku, quantity from "order_lines"'))
    assert rows == [("order1", "SPOON", 10)]
