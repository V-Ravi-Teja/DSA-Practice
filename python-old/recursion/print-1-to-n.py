N=int(input('enter integer:\n'))
def nTo1(x):
    if x==0:
        return
    # print(N-x+1,end=' ')
    nTo1(x-1)
    print(x,end=' ')

(nTo1(N))