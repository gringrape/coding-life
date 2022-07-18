from typing import Union

from fastapi import FastAPI

from movies import router


app = FastAPI()

app.include_router(router)
