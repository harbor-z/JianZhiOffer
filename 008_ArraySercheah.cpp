#include <iostream>
#include <chrono>// std::chrono::seconds(i);
#include <windows.h>
#include <stdexcept>      // std::logic_error

using namespace std;

// 008.旋转数组的最小数

// Methord1: Iterative 效率更高
int minInOrder_Iterative(int *data, int start, int end)
{
	int minData = data[end];
	int i = start;
	while (data[i] >= minData && i < end)// 因为这是旋转数组，所以第一个小于minData的就是最小值
	{
		i++;
	}
	minData = data[i];
	return minData;
}

int min_Iterative(int* data, int length)
{
	if (data == NULL || length <= 0)
	{
		printf("min(int* data, int length): Invalid input");
		exit(0);
	}

	int start = 0, end = length - 1;
	int mid = 0;
	while (true)
	{
		if (data[start] < data[end])
		{
			printf("min(int* data, int length): Invalid input");
			exit(0);
		}

		if (end == start || end - start == 1)
			return data[end];

		mid = (start + end) / 2;
		if (data[start] == data[mid] && data[mid] == data[end])
		{
			return minInOrder_Iterative(data, start, end);
		}

		if (data[start] <= data[mid])// Due to above "if", when "==" happens here, mid must bigger than end
		{
			start = mid;
			continue;
		}

		if (data[start] > data[mid])
		{
			end = mid;
			continue;
		}
	}
}


// Method2: Recursive
int minInOrder_Recursive(int *data, int start, int end)
{
	int mid;
	while (true)
	{
		if (data[start] < data[end])
		{
			printf("minInOrder_Recursive(int* data, int length): Invalid input");
			exit(0);
		}

		if (end == start || end - start == 1)
			return data[end];

		mid = (start + end) / 2;

		if (data[start] == data[mid] && data[mid] == data[end])// Special occassion. o(log n)
		{
			int value1 = minInOrder_Recursive(data, start, mid);
			int value2 = minInOrder_Recursive(data, mid, end);
			if (value2 < value1)
				return value2;
			else
				return value1;
		}

		if (data[start] <= data[mid])// Due to the above "if", when "==" happens here, mid must bigger than end
		{
			start = mid;
			continue;
		}

		if (data[start] > data[mid])
		{
			end = mid;
			continue;
		}
	}
}

int min_Recursive(int* data, int length)
{
	if (data == NULL || length <= 0)
	{
		printf("min_Recursive(int* data, int length): Invalid input");
		exit(0);
	}

	return minInOrder_Recursive(data, 0, length - 1);
}

int main()
{
	LARGE_INTEGER m_nFreq;
	LARGE_INTEGER m_nBeginTime;
	LARGE_INTEGER m_nEndTime;
	QueryPerformanceFrequency(&m_nFreq);
	
 	int num = 100000;
	int data[100000] = {0};
	for (int i = 0; i < num;i++)
	{
		data[i] = 1;
	}
	data[(num - 1) / 2 - 1] = 0;

	QueryPerformanceCounter(&m_nBeginTime);
	printf("%d\n", min_Recursive(data, num));
	QueryPerformanceCounter(&m_nEndTime);

	cout << (double)(m_nEndTime.QuadPart - m_nBeginTime.QuadPart) * 1000 / m_nFreq.QuadPart <<" s"<< endl;

	return 0;
}