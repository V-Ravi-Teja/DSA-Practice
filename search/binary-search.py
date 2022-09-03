#binary tree recursive

def binarysearch(target,arr,low,high):
    mid=int((low+high)/2)
    print('index of mid is-->',mid,'in array',arr)
    if high < low:
        return 'not present'
    elif target >arr[mid]:
        return binarysearch(target,arr, mid+1, high)
    elif target<arr[mid]:
        return binarysearch(target,arr,low,mid-1)
    else :
        if mid==0 or arr[mid-1]!=arr[mid]:
            return str(mid) + 'th index'  
        else:    
            return binarysearch(target, arr, low, mid-1)

arr=[1,2,3,3,4,4,4,4]
print(binarysearch(4, arr,0,len(arr)-1))