#1-take string input
#2-count freq
#3-return character with max freq
string=input('enter a string: \n')
freq={}
for i in string:
    if i in freq:
        freq[i]+=1
    else:
        freq[i]=1
for i,j in freq.items():
    if j is max(freq.values()):
        print(str(i)+': '+str(j))
