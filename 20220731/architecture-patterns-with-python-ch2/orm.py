from sqlalchemy.orm import mapper, relationship

from sqlalchemy import Table, MetaData, Column, Integer, String, Date, ForeignKey

from model import OrderLine, Batch

metadata = MetaData()

order_lines = Table(
    "order_lines",
    metadata,
    Column("id", Integer, primary_key=True, autoincrement=True),
    Column("order_id", String(255)),
    Column("sku", String(255)),
    Column("quantity", Integer, nullable=False),
)

batches = Table(
    "batches",
    metadata,
    Column("id", Integer, primary_key=True, autoincrement=True),
    Column("reference", String(255)),
    Column("sku", String(255)),
    Column("_purchased_quantity", Integer, nullable=False),
    Column("eta", Date, nullable=True),
)


def start_mappers():
    lines_mapper = mapper(OrderLine, order_lines)
    batches_mapper = mapper(Batch, batches)
