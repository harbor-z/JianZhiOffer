/*
给定一个有序（不降序）数组a，求最大的i使得a[i]等于v，不存在则返回-1
*/
int binarySearch(int[] a, int v){
	if(a == null || a.length == 0){
		return -1;
	}
	
	int lo = 0, hi = a.length - 1, mid;
	while(lo < hi - 1){ // 不采用lo < hi，防止mid == lo时无限循环
		mid = lo + (hi - lo)/2; // 不采用mid = (lo + hi)/2，防止整数和溢出
		if(a[mid] <= v){
			lo = mid;
		} else{
			hi = mid - 1;
		}
	}
	
	if(a[hi] == v){
		return hi;
	} else if(a[lo] == v){
		return lo;
	} else {
		return -1;
	}
}

/*
给定一个有序（不降序）数组a，求最小的i使得a[i]等于v，不存在则返回-1
*/
int binarySearch2(int[] a, int v){
	if(a == null || a.length == 0){
		return -1;
	}
	
	int lo = 0, hi = a.length - 1, mid;
	while(lo < hi){ // 相邻元素不会无限循环，因为mid总是小于hi
		mid = lo + (hi - lo)/2;
		if(a[mid] >= v){
			hi = mid;
		} else {
			lo = mid + 1;// 必须加1，否则可能循环
		}
	}
	
	if(a[lo] == v){
		return lo;
	} else{
		return -1;
	}
}

/*
给定一个有序（不降序）数组a，求最大的i使得a[i]小于v，不存在则返回-1
*/
int binarySearch3(int[] a, int v){
	if(a == null || a.length == 0){
		return -1;
	}
	
	int lo = 0, hi = a.length - 1, mid;
	while(lo < hi - 1){ // 保证mid大于lo
		mid = lo + (hi - lo)/2;
		if(a[mid] < v){
			lo = mid;
		} else{
			hi = mid - 1;
		}
	}
	
	if(a[hi] < v){
		return hi;
	} else if(a[lo] < v){
		return lo;
	} else{
		return -1;
	}
}

/*
给定一个有序（不降序）数组a，求最小的i使得a[i]大于v，不存在则返回-1
*/
int binarySearch4(int[] a, int v){
	if(a == null || a.length == 0){
		return -1;
	}
	
	int lo = 0, hi = a.length - 1, mid;
	while(lo < hi){
		mid = lo + (hi - lo)/2;
		if(a[mid] > v){
			hi = mid;
		} else{
			lo = mid + 1; // 必须加1，否则可能循环
		}
	}
	
	if(a[lo] > v){
		return lo;
	} else{
		return -1;
	}
}