#panagram=contains all alphabets a to z, 
#can include other characters like space
import string
s1='abc xyz defghijk lmnopqrst uvw'
test=string.ascii_lowercase
print('True') if set(s1.lower())>=set(test) else print('False')