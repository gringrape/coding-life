import sqlite3

from langchain.tools import Tool

connection = sqlite3.connect("data/db.sqlite")

def run_sqlite_query(query):
  cursor = connection.cursor()
  cursor.execute(query)
  return cursor.fetchall()

run_query_tool = Tool.from_function(
  name="run_sqlite_query",
  description="Run a sqlite query",
  func=run_sqlite_query
)
  