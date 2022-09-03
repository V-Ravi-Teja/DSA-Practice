def findlargest(arr):
    # arr=[1,2,1,3]
    res=0
    for i in range(len(arr)):
        if arr[i]>arr[res]:
            res=i
    return res
arr=list(map(int,input('enter integers:\n').split()))
print(findlargest(arr))
print(arr)
        