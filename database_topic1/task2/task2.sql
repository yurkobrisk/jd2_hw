select listexpenses.expenses.num, listexpenses.expenses.paydate, listexpenses.receivers.name, listexpenses.expenses.value
 from listexpenses.expenses, listexpenses.receivers
 where listexpenses.expenses.receiver=listexpenses.receivers.num AND listexpenses.expenses.value > 10000;