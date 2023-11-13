# TODO
## 1. chroma 설치

from langchain.document_loaders import TextLoader
from langchain.text_splitter import CharacterTextSplitter
from langchain.embeddings import OpenAIEmbeddings
from langchain.vectorstores.chroma import Chroma
from langchain.chains import RetrievalQA
from langchain.chat_models import ChatOpenAI

from redundant_filter_retriever import RedundantFilterRetriever


def main():
    embeddings = OpenAIEmbeddings()

    loader = TextLoader("data/facts.txt")

    text_splitter = CharacterTextSplitter(
        separator="\n",
        chunk_size=200,
        chunk_overlap=0,
    )

    docs = loader.load_and_split(text_splitter=text_splitter)

    db = Chroma.from_documents(
        docs,
        embedding=embeddings,
        persist_directory="emb",
    )

    retriever = RedundantFilterRetriever(
        chroma=db,
        embeddings=embeddings,
    )

    chat = ChatOpenAI()

    chain = RetrievalQA.from_chain_type(
        llm=chat, retriever=retriever, chain_type="stuff"
    )

    results = chain.run("what is an interesting fact about english language?")

    print(results)


main()
