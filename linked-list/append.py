class node:
    def __init__(self,data):
        self.data=data
        self.next=None
class linkdlist:
    def __init__(self):
        self.head=None
    def out(self):
        node=head
        while(node):
            print(node.data,end='-->')
            node=node.next
            print(None) if node==None else None
l=linkdlist()
head=node(1)
head.next=node(2)
head.next.next=node(3)
head.next.next.next=node(4)
l.out()
# -----insert temp=5 at end----
temp=5
temp=node(temp)
current=head
while(current):
    if current.next==None:
        current.next=temp
        temp.next=None
        break
    current=current.next
l.out()