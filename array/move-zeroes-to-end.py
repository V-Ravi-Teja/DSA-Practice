def zeroesToEnd(arr):
    count=0
    i=0
    while True:
        if i>len(arr)-1:
            break
        if arr[i]!=0:
            # print(arr)
            arr[i],arr[count]=arr[count],arr[i]
            # print(arr)
            count+=1
        i+=1
    return arr


arr=list(map(int,input('enter array of integers:\n').split()))
# print(arr)
print(zeroesToEnd(arr))
