SELECT BOOK_ID, date_format(PUBLISHED_DATE, '%Y-%m-%d') as PUBLISHED_DATE
from book
where published_date like '2021-%'
and
category='인문'
order by published_date desc;