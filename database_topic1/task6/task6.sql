  -- вывести список получателей платежей, и сумму платежей по каждому из них
 select name, sum(value) 
 from listexpenses.receivers, listexpenses.expenses  
 where listexpenses.expenses.receiver=listexpenses.receivers.num group by name;
 
  -- вывести сумму платежей за тот день, когда был наибольший платеж
 select sum(value) 
 from listexpenses.expenses 
 where paydate=(select paydate 
				from listexpenses.expenses 
                where value=(select max(value) 
							 from listexpenses.expenses));
							 
  -- вывести наибольший платеж за тот день, когда сумма платежей была наибольшей
 select paydate, value 
 from listexpenses.expenses 
 where paydate=(select paydate 
				from listexpenses.expenses 
                group by paydate order by sum(value) desc limit 1) 
 order by value desc limit 1;