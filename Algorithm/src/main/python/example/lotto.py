import random

def addNumber(ns):
    n = random.randint(1,45)
    if n in ns : addNumber(ns)
    else : ns.append(n)

ns = []
for i in range(7): addNumber(ns)

print("2등 번호 : {}".format(ns.pop()))
print("1등 번호 : {}".format(ns))