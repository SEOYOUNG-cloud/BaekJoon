-- 코드를 입력하세요
        SELECT first_half.flavor
        from first_half join icecream_info
        on first_half.flavor = icecream_info.flavor
        where first_half.total_order > 3000 and icecream_info.INGREDIENT_TYPE = 'fruit_based'
        order by first_half.total_order desc