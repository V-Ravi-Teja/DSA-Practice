string1='abab'
string2='abba'
# string1+string1-->abababab
# string1='abcd'
# string2='cdab'
# string1+string1-->abcdabcd
print(True) if string2 in string1+string1 else print(False)