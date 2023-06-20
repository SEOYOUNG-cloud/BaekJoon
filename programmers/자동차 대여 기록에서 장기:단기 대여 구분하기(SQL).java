-- 코드를 입력하세요
        SELECT HISTORY_ID, CAR_ID,
        date_format(START_DATE, '%Y-%m-%d') as START_DATE,
        date_format(END_DATE, '%Y-%m-%d') as END_DATE,
        case when
        DATEDIFF(END_DATE, START_DATE) < 29 then '단기 대여'
        else '장기 대여'
        end as RENT_TYPE
        from car_rental_company_rental_history as c
        where START_DATE LIKE '2022-09-%'
        order by history_id desc