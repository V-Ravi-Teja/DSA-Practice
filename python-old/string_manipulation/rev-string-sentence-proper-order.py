#return reversed words of string in proper order
#ex->
#i/p:this is my book
#o/p:sith si ym koob
string='this is my book'
words=string.split(' ')
print(words)
for i in range(len(words)):
    words[i]=words[i][::-1]
print(*words)
