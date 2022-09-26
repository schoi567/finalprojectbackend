/*

insert IGNORE into customers(id, username, password, email, phonenumber,firstname,lastname, primaryaccountnumber, savingsaccountnumber, block )
values (1,'abc','abc','abc@gmail.com',1234567891,'Ryan','Haugland',11111111,11112222,'no'); 

insert IGNORE into customers(id, username, password, email, phonenumber,firstname,lastname, primaryaccountnumber, savingsaccountnumber, block )
values (2,'bcd','bcd','bcd@gmail.com',2345678912,'Dipen','Patel',22222222,22223333,'no'); 

insert IGNORE into checkbookreq(id,username,date,accounttype,description,accept)
values (1,'abc',CURDATE(),'primaryaccount','Apartment Check',false); 

insert IGNORE into checkbookreq(id,username,date,accounttype,description,accept)
values (2,'bcd',CURDATE(),'savingsaccount','School Tuition',false); 

insert IGNORE into transfer (id,amount,date,fromaccounttype,fromusername,receiverusename,toaccounttype,transfer)
values (1,101,CURDATE(),'primaryaccount','abc','bcd','savingsaccountnumber','pending'); 
 



insert IGNORE into depositwithdrawmoney (id,username,date,account,amount,approved)
values (1,'abc',CURDATE(),'savingsaccountnumber',100.25,'pending');

insert IGNORE into depositwithdrawmoney (id,username,date,account,amount,approved)
values (2,'bcd',CURDATE(),'savingsaccountnumber',100.25,'pending');

insert IGNORE into customeraccount(id, savingsaccountnumber, primaryaccountnumber, username)
values (1, 0, 0, 'abc'); 

insert IGNORE into customeraccount(id, savingsaccountnumber, primaryaccountnumber, username)
values (2, 0, 0, 'bcd'); 
 */ 
