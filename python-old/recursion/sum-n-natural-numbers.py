def sumOf(x):
    if x==0:
        return 0
    return x+sumOf(x-1)
N=int(input('enter integer:'))
print(sumOf(N))