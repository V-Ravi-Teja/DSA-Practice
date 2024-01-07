a='1.25636'
print(list(a.split('.'))[1])
#-------------(or)------------------
temp=a.index('.')
print(a[temp+1:])