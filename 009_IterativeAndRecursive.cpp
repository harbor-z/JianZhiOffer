#include <iostream>
#include <thread>
#include <vector>
#include <stack>
#include <chrono>// std::chrono::seconds(i);
#include <cstring>
#include "sum.h"
#include <mutex>
#include <stdexcept>      // std::logic_error

using namespace std;

// 009. Fibonacci array (iterative and recursive)
// The weaks of recursive
// 1. 多次函数调用造成的时间和空间消耗：
//    内存栈中分配空间以保存参数、返回地址和临时变量，而且往栈里压数据、弹出数据都需要时间
// 2. 重复计算：
//    以Fabonacci数列为例，f(8)和f(9)都需要计算一次f(7)
// 3. 多次迭代可能造成函数调用栈溢出(每个进程的栈容量是有限的)
long long calculate(int n)
{
	if (n < 0)
	{
		printf("Invalid input! Please enter an Integer :)\n");
		exit(0);
	}
	int i = 0; 
	long long result = 0, n1 = 0, n2 = 1;// sizeof(int)=4, sizeof(long long)=8
	while (i <= n)
	{
		if (i == 0)
			result = n1;
		else if (i == 1)
			result = n2;
		else
		{
			result = n1 + n2;
			n1 = n2;
			n2 = result;
		}
		i++;
	}
	return result;
}

int main()
{
	while (true)
	{
		printf("请输入Fibonacci数列的项数：");
		int n = 0;
		cin >> n;
		printf("Fibonacci数列的第%d项为%d\n", n, calculate(n));
	}
	return 0;
}