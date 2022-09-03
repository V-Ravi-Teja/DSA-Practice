def secondlargest(arr):
    result=0
    largest=0
    i=0
    while True:
        if i > len(arr)-1:
            break
        if arr[i]>arr[largest]:
            result = largest
            largest=i
        elif arr[i]<arr[largest] and arr[i]>arr[result]:
            result = i
        i+=1
    return result



arr=list(map(int,input('enter integers:\n').split()))
print(arr)
print(secondlargest(arr))