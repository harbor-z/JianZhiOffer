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
// 1. ��κ���������ɵ�ʱ��Ϳռ����ģ�
//    �ڴ�ջ�з���ռ��Ա�����������ص�ַ����ʱ������������ջ��ѹ���ݡ��������ݶ���Ҫʱ��
// 2. �ظ����㣺
//    ��Fabonacci����Ϊ����f(8)��f(9)����Ҫ����һ��f(7)
// 3. ��ε���������ɺ�������ջ���(ÿ�����̵�ջ���������޵�)
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
		printf("������Fibonacci���е�������");
		int n = 0;
		cin >> n;
		printf("Fibonacci���еĵ�%d��Ϊ%d\n", n, calculate(n));
	}
	return 0;
}