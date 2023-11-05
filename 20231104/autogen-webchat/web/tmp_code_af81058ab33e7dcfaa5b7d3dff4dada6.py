import requests
from bs4 import BeautifulSoup

def fetch_news(url):
    response = requests.get(url)
    soup = BeautifulSoup(response.text, 'html.parser')

    # Assuming the news headlines are in 'h2' HTML tags
    news_headlines = soup.find_all('h2')

    for headline in news_headlines:
        print(headline.text)

fetch_news('https://news.hada.io/')