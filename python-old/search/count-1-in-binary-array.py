#arr=[0,0,1,1]
#return 2

arr=[0,0,1,1,1]
# print(arr.count(1))
def binarysearch(target,arr,low,high):
    mid=int((low+high)/2)
    # print('index of mid is-->',mid,'in array',arr)
    if high < low:
        return 'not present'
    elif target >arr[mid]:
        return binarysearch(target,arr, mid+1, high)
    elif target<arr[mid]:
        return binarysearch(target,arr,low,mid-1)
    else :
        if mid==0 or arr[mid-1]!=arr[mid]:
            # return str(mid) + 'th index'  
            return mid
        else:    
            return binarysearch(target, arr, low, mid-1)
p=binarysearch(1, arr, 0, len(arr))
print('no of 1\'s is',len(arr)-p)