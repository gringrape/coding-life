# filename: extract_news.py

import requests
from bs4 import BeautifulSoup

def extract_news(url):
    response = requests.get(url)
    soup = BeautifulSoup(response.text, 'html.parser')

    news_titles = soup.find_all('h2', class_='font-bold text-xl md:text-2xl')

    for title in news_titles:
        print(title.text)

extract_news('https://news.hada.io/')