method1:

I use dfs to generate the list first. And then check the list is in ascending order or not. 
If the list is LinkedList, the run time will be huge. If you use ArrayList instead, it will be much faster. 


method2:

It is a good method. But we need to pay attention to this case: [2147483647], that's Integer.MAX_VALUE. 
That's why int is replaced by Long to pass this test case. 
