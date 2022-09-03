""" def check(string):
    if string == string[::-1]:
        return True
    else:
        return False
string=input('enter string:')
print(check(string))"""
def check(string):
    begin=0
    end=len(string)-1
    while(begin<end):
        if string[begin]!=string[end]:
            return False
        begin+=1
        end-=1
    return True

string=input('enter string:')
print(check(string))