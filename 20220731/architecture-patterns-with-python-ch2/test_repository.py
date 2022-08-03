from model import Batch

from repository import SqlAlchemyRepository


def test_repository_can_save_a_batch(session):
    batch = Batch(reference="batch1", sku="SPOON", quantity=10, eta=None)

    repository = SqlAlchemyRepository(session)
    repository.add(batch)
    session.commit()

    rows = list(session.execute('SELECT reference, sku FROM "batches"'))

    assert rows[0] == ("batch1", "SPOON")
