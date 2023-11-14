from langchain.chat_models import ChatOpenAI
from langchain.prompts import (
    ChatPromptTemplate,
    HumanMessagePromptTemplate,
    MessagesPlaceholder,
)
from langchain.schema import SystemMessage  # 얘는 왜 schema 에 들어가 있는지 모르겠다
from langchain.agents import OpenAIFunctionsAgent, AgentExecutor

from tools.sql import (
    run_query_tool,
    list_tables,
    describe_table_tool,
    write_report_tool,
)


def main():
    chat = ChatOpenAI()

    tables = list_tables()

    prompt = ChatPromptTemplate(
        messages=[
            SystemMessage(
                content=(
                    f"You are an AI that has access to a SQLite database. Belows are tables of the database. \n {tables}"
                    "Do not make any assumption about what table or column exists"
                )
            ),
            HumanMessagePromptTemplate.from_template("{input}"),
            MessagesPlaceholder(variable_name="agent_scratchpad"),
        ]
    )

    agent = OpenAIFunctionsAgent(
        llm=chat,
        prompt=prompt,
        tools=[run_query_tool, describe_table_tool, write_report_tool],
    )

    agent_executor = AgentExecutor(
        agent=agent,
        verbose=True,
        tools=[run_query_tool, describe_table_tool, write_report_tool],
    )

    # agent_executor("How many users are in database?")
    agent_executor(
        "How many users have provided a shipping address? Write report about the result"
    )


main()
