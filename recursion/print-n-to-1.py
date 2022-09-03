N=int(input('enter integer:\n'))
def nTo1(x):
    if x==0:
        return
    print(x,end=' ')
    nTo1(x-1)
(nTo1(N))