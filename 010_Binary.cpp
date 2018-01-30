#include <iostream>
#include <windows.h>
using namespace std;

// 010. 位运算

// 求二进制中1的个数

// Methord 1: 一个数减去1, 再和自己&运算, 结果就是去掉二进制位数中最后一个1
// 方法的优点: 巧妙
int numOfOneInBinary(int n) 
{
	int num = 0;
	while (n)
	{
		n &= n - 1;
		num++;
	}
	return num;
}


// Methord 2: 需要从最低位到最高位, 一步步判断.
int numOfOneInBinary2(int n)
{
	int num = 0;
	if (n & 0x80000000)// 判断最高位是否为1
	{
		n &= 0x7FFFFFFF;// 去掉最高位
		num++;
	}
	while (n)// stop when n equals zero
	{
		if (n & 1)// when last bit is 1
		{
			num++;
		}

		n = n >> 1;
	}
	return num;
}


int main()
{
	LARGE_INTEGER m_nFreq;
	LARGE_INTEGER m_nBeginTime;
	LARGE_INTEGER m_nEndTime;
	QueryPerformanceFrequency(&m_nFreq);
	QueryPerformanceCounter(&m_nBeginTime);
	printf("%d个1\n", numOfOneInBinary2(0x88800000));
	QueryPerformanceCounter(&m_nEndTime);
	cout << (double)(m_nEndTime.QuadPart - m_nBeginTime.QuadPart) * 1000 / m_nFreq.QuadPart << " s" << endl;
	return 0;
}