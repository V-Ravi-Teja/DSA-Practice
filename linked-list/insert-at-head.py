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
l.out()
# ------insert temp at begin----
temp=0
temp=node(temp)
temp.next=head
head=temp
l.out()