select *
from order_info
where status="completed" and date >= "2025-10-15" and (product_name="Python" or product_name="C++" or product_name="Java")
order by id;