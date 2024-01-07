#1-take string input
#2-count freq
#3-return as ex->a:2
string=input('enter a string: \n')
freq={}
for i in string:
    if i in freq:
        freq[i]+=1
    else:
        freq[i]=1
for i,j in freq.items():
    print(str(i) + ': ' + str(j))
#-----------(or)--------------
f={}
for i in string:
    if i not in f:
        f[i]=string.count(i)
for i,j in f.items():
    print(str(i)+ ': ' + str(j))