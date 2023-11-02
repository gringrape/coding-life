import dotenv

import os

from langchain.chat_models import ChatOpenAI
from langchain.tools import BaseTool
from langchain.agents import AgentType, initialize_agent

from pydantic import BaseModel, Field
from typing import Optional, Type


dotenv.load_dotenv()

OPENAI_API_KEY = os.getenv("OPENAI_API_KEY")


class CurrentWeatherCheckInput(BaseModel):
    location: str = Field(
        ...,
        description="The name of the location for which we need to find the weather",
    )
    unit: str = Field(..., description="The unit for temparature value")


class GetCurrentWeatherTool(BaseTool):
    args_schema: Optional[Type[BaseModel]] = CurrentWeatherCheckInput
    name = "get_current_weather"
    description = "Used to find the weather for a given location in said unit"

    def _run(self, location: str, unit: str):
        weather_response = get_current_weather(location, unit)
        return weather_response

    def _arun(self, location: str, unit: str):
        raise NotImplementedError("This tool does not support async")


def get_current_weather(location, unit):
    weather_info = {
        "location": location,
        "temparature": "78",
        "unit": unit,
        "forecast": ["sunny", "with a chance of meatballs"],
    }

    return weather_info


def main():
    model_name = "gpt-3.5-turbo-0613"

    model_using_agent = ChatOpenAI(temperature=0, model=model_name)

    tools = [GetCurrentWeatherTool()]

    agent_for_function = initialize_agent(
        tools, model_using_agent, agent=AgentType.OPENAI_FUNCTIONS, verbose=True
    )

    query = "밥먹고 씻는 일을 추가해줘"

    answer = agent_for_function.run(query)

    print(answer)


main()
