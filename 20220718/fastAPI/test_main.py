from fastapi.testclient import TestClient

from .main import app

client = TestClient(app)


def test_movies():
    response = client.get("/movies")
    assert response.status_code == 200
