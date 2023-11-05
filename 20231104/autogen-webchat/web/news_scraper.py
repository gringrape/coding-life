# filename: news_scraper.py

import requests
from bs4 import BeautifulSoup

def get_news(url):
    response = requests.get(url)
    soup = BeautifulSoup(response.text, 'html.parser')

    # Find all news items. This may need to be adjusted depending on the structure of the webpage.
    news_items = soup.find_all('div', class_='issue-item')

    summaries = []
    for news in news_items:
        title = news.find('h2').text
        summary = news.find('p').text
        summaries.append((title, summary))

    return summaries

def print_news(summaries):
    for title, summary in summaries:
        print(f"Title: {title}\nSummary: {summary}\n")

url = "https://javascriptweekly.com/"
news_summaries = get_news(url)
print_news(news_summaries)