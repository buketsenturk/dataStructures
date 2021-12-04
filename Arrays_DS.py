#!/bin/python3

import math
import os
import random
import re
import sys



def reverseArray(array):
    count_of_array = len(array)
    count_of_reversed_array = 0
    reversed_array=[]
    while count_of_reversed_array < count_of_array:
        reversed_array.append(array[count_of_array-count_of_reversed_array-1])  
        count_of_reversed_array = len(reversed_array)
    return reversed_array
    

if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    arr_count = int(input().strip())

    arr = list(map(int, input().rstrip().split()))

    res = reverseArray(arr)

    fptr.write(' '.join(map(str, res)))
    fptr.write('\n')

    fptr.close()
