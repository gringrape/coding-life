from fastapi import APIRouter

router = APIRouter(prefix="/movies")

from movie_fetcher import find_all


@router.get("/")
async def list():
    return findAll()
