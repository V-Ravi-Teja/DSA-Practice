def leftShift(arr):
    temp=arr[0]
    i=1
    while True:
        if i>len(arr)-1:
            break
        arr[i-1]=arr[i]
        i+=1
    arr[-1]=temp
    return arr

arr=list(map(int,input('enter array of integers:\n').split()))
# print(arr)
print(leftShift(arr))