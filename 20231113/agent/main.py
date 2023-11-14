from langchain.chat_models import ChatOpenAI
from langchain.prompts import (
    ChatPromptTemplate,
    HumanMessagePromptTemplate,
    MessagesPlaceholder,
)
from langchain.agents import OpenAIFunctionsAgent, AgentExecutor

from tools.sql import run_query_tool


def main():
    chat = ChatOpenAI()

    prompt = ChatPromptTemplate(
        messages=[
            HumanMessagePromptTemplate.from_template("{input}"),
            MessagesPlaceholder(variable_name="agent_scratchpad"),
        ]
    )

    agent = OpenAIFunctionsAgent(
        llm=chat,
        prompt=prompt,
        tools=[run_query_tool],
    )

    agent_executor = AgentExecutor(
        agent=agent,
        verbose=True,
        tools=[run_query_tool],
    )

    agent_executor("How many users are in database?")


main()
