Recommender Systems Project 
COMP30490
Author: Vsevolods Caka
St.Number: 13340321

!!!---THIS IS A README FILE---!!!
Read this file carefully, before trying to run the code. 

There are 2 ways in which you can run the code. 

1) In Main class, main function, uncomment functions with 'test' prefix. 
   These functions have to be run to generate tests for different numbers of neighbours and 
   produce .csv files with predefined neighbourhood sizes.
   Careful, because test_resnicks will run for over an hour. 
   Individual tests run 10 times faster, than the average of 10 runs in the row. 
   test_user/item_stat functions display the statistics for all users/items. 

2) In Main class, main function:
   Call functions directly from Prediction class. 
   Parser and prediction classes are predefined. 
   Create an instance of Output class and set it to null. (Call it 'out' for future reference)
   	a) To call a naive function write:
		a.1) out = pred_naive.leave_one_out_naive(); //creates a csv file and returns Output
		a.3) out.getRmse()
		a.4) out.getCoverage() 
  	b) To call a nearest neighbour function (Part 3)
      		b.1) Change value n do a desired number of neighbours
      		b.2) out = pred_nn.leave_one_out_knn(); //creates a csv file and returns Output
		b.3) out.getRmse()
		b.4) out.getCoverage() 
   	c) To call a resnick's function (Part 4)
      		c.1) Change value n do a desired number of neighbours
      		c.2) out = pred_nn.leave_one_out_resnick(); //creates a csv file and returns Output
		c.3) out.getRmse()
		c.4) out.getCoverage() 

Also, to generate a file with basic statistics for each user/item, uncomment test_user_stat(parser), test_item_stat(parser);

All functions mentioned are generating .csv files with results into csv_out folder
Also, statistics is displayed in the console - NN size,RMSE, Coverage, Avg.Runtime

Report is stored in the parent directory. Also the results are stored in the csv_out folder.
   