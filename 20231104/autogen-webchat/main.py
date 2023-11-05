from autogen import UserProxyAgent


import memgpt.autogen.memgpt_agent as memgpt_autogen
import memgpt.autogen.interface as autogen_interface
import memgpt.agent as agent
import memgpt.system as system
import memgpt.utils as utils
import memgpt.presets as presets
import memgpt.constants as constants
import memgpt.personas.personas as personas
import memgpt.humans.humans as humans
from memgpt.persistence_manager import (
    InMemoryStateManager,
    InMemoryStateManagerWithPreloadedArchivalMemory,
    InMemoryStateManagerWithFaiss,
)
import openai


def main():
    config_list = [
        {
            "model": "gpt-4",
            "api_key": "",
        },
    ]

    llm_config = {
        "timeout": 600,
        "seed": 42,
        "config_list": config_list,
        "temperature": 0,
    }

    interface = autogen_interface.AutoGenInterface()  # how MemGPT talks to AutoGen
    persistence_manager = InMemoryStateManager()
    persona = "I'm a 10x engineer at a FAANG tech company."
    human = "I'm a team manager at a FAANG tech company."
    memgpt_agent = presets.use_preset(
        presets.DEFAULT, "gpt-4", persona, human, interface, persistence_manager
    )

    coder = memgpt_autogen.MemGPTAgent(
        name="MemGPT_coder",
        agent=memgpt_agent,
    )

    # create a UserProxyAgent instance named "user_proxy"
    user_proxy = UserProxyAgent(
        name="user_proxy",
        human_input_mode="TERMINATE",
        max_consecutive_auto_reply=10,
        is_termination_msg=lambda x: x.get("content", "")
        .rstrip()
        .endswith("TERMINATE"),
        code_execution_config={"work_dir": "web"},
        llm_config=llm_config,
        system_message="""
        Reply TERMINATE if the task has been solved at full satisfaction.
        Otherwise, reply CONTINUE, or the reason why the task is not solved yet.
      """,
    )

    user_proxy.initiate_chat(
        assistant,
        message="""
    오늘 올라온 새로운 소식과 내용을 요약해줘 :https://news.hada.io/
    """,
    )


main()
