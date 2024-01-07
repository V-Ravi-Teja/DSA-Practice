class node:
    def __init__(self,data):
        self.data=data
        self.next=None
class linkedlist():
    def __init__(self):
        self.head=None
likdlit=linkedlist()
head=node(1)
head.next=node(2)
head.next.next=node(3)
#-----we can make following code as method for reuse-----
node=head
while(node):
    print(node.data,end='-->')
    node=node.next
    print(None) if node==None else None