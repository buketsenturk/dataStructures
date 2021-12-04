#!/bin/python3

import math
import os
import random
import re
import sys


def hourglassSum(arr):
    sum_indexes_list = []
    item = 0
    while item<4:
        item_index = 0
        while item_index<4:
            sum_indexes = arr[item][item_index] + arr[item][item_index+1] +arr[item][item_index+2]
            sum_indexes = sum_indexes + arr[item+1][item_index+1]
            sum_indexes = sum_indexes + arr[item+2][item_index] + arr[item+2][item_index+1] +arr[item+2][item_index+2]
            sum_indexes_list.append(sum_indexes)
            item_index = item_index +1
        item=item+1
    return find_max(sum_indexes_list)
    

def find_max(arr):
    max_item = arr[0]
    for item in arr:
        if item > max_item:
            max_item = item
    return max_item
    
    
if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    arr = []

    for _ in range(6):
        arr.append(list(map(int, input().rstrip().split())))

    result = hourglassSum(arr)

    fptr.write(str(result) + '\n')

    fptr.close()
