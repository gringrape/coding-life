# TODO
# - openai key 설정
# - 텍스트로드
# - 청킹

from langchain.document_loaders import TextLoader
from langchain.text_splitter import CharacterTextSplitter
from langchain.embeddings import OpenAIEmbeddings

from os import environ


def main():
    loader = TextLoader("data/facts.txt")

    text_splitter = CharacterTextSplitter(
        separator="\n",
        chunk_size=200,
        chunk_overlap=0,
    )

    docs = loader.load_and_split(text_splitter=text_splitter)

    embeddings = OpenAIEmbeddings()
    test_embedding = embeddings.embed_query("hello, world")
    print(test_embedding)


main()
