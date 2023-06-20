
SELECT CAR_ID, CAR_TYPE, DAILY_FEE, OPTIONS
from car_rental_company_car as c
where c.options like '%네비게이션%'
order by c.car_id desc