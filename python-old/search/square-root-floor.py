x=10
def squareRootFloor(x,low,high):
    mid=int((low+high)/2)
    midsq=mid**mid
    if low>high:
        return 'no'
    elif midsq>mid:
        squareRootFloor(x, low, mid-1)
    elif mid==midsq:
        return mid
    else :
        squareRootFloor(x, mid+1, high)
    return mid
print(squareRootFloor(x, 0, x))