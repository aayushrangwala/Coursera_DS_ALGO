# Uses python3
import sys

def binary_search(a, key):
    left, right = 0, len(a)
    # write your code here
    return binary_search_util(a, left, right, key)
'''
def binary_search_util(a, l, r,key):
    while (l < r-1):
        mid = int(l + (r-l)/2)
        if (a[mid] <= key):
            l = mid
        else:
            r = mid
    if (a[l] == key):
        return l;
    return -1

'''

def binary_search_util(a, l, r,key):
    if (l < r):
        mid = int(l + (r-l)/2)
        if (a[mid] == key):
            return mid
        if (a[mid] > key):
            return binary_search_util(a, l, mid, key)
        return binary_search_util(a, mid+1, r, key)
    return -1


def linear_search(a, x):
    for i in range(len(a)):
        if a[i] == x:
            return i
    return -1

if __name__ == '__main__':
    input = sys.stdin.read()
    data = list(map(int, input.split()))
    n = data[0]
    m = data[n + 1]
    a = data[1 : n + 1]
    for x in data[n + 2:]:
        # replace with the call to binary_search when implemented
        if (x < a[0] || x > a[n]):
            print(-1, end=' ')
        else:
            print(binary_search(a, x), end = ' ')
