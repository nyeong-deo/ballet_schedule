import requests
from bs4 import BeautifulSoup
import pymysql

titles = []
dates = []
places = []

for i in range(2):
    response = requests.get(f"https://www.korean-national-ballet.kr/ko/performance/list?perf_year=2024&perf_type=PERF_TYPE_REGULAR&perf_type=PERF_TYPE_LOCAL&page={i+1}")
    html = response.text

    soup = BeautifulSoup(html,'html.parser')
    titles.extend(soup.select(".tumbnail-type > ul > li > h4"))
    dates.extend(soup.select(".date"))
    places.extend(soup.select(".tumbnail-type > ul > li > h5"))


# for title in titles:
#     print(title.text)

# for date in dates:
#     print(date.text)

# for place in places:
#     print(place.text)
    
conn = pymysql.connect(host='localhost', user='root', password='sys9121@@', db='ballet', charset='utf8')
cursor = conn.cursor()

sql = "INSERT INTO schedule (group_name, performance_title, performance_date, performance_place) VALUES (%s, %s, %s, %s)" 

for i in range(len(titles)):
    cursor.execute(sql,('국립발레단', titles[i].text, dates[i].text, places[i].text)) 

conn.commit()
conn.close() 
