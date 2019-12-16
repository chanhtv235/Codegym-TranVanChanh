select *
From orders;
 
 select status
 from orders
 group by status;

select status, COUNT(*) as 'So luong status'
from orders
group by status;
select *
From orders;

select status, sum(quantityOrdered * priceEach) as amount
from orders 
inner join orderdetails on orders.ordernumber = orderdetails.ordernumber
group by status