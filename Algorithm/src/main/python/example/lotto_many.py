# 로또 번호 출력기 NUMBER_LOOP 회 실행하여 제일 많이 나온 숫자 순으로 나열하여 
# 정확도를 높이는 로직을 실행 함
import random
import operator

NUNBER_LOOP = (956);

def addNumber(ns):
    n = random.randint(1,45)
    if n in ns : addNumber(ns)
    else : ns.append(n)

# 100회 실행하여 100회 번호를 획득
ns = []         
for i in range(NUNBER_LOOP) : 
    ns.append([])    
    for j in range(7): 
        addNumber(ns[i])

# 번호 출현 횟수를 기록
number_count = {}
for i in ns:
    for j in i : 
        if j in number_count : 
            tmp = number_count[j] + 1
            del number_count[j]
            number_count[j] = tmp
        else : 
            number_count[j] = 1

# 결과를 정렬. 값으로 키를 역정렬
number_count_sort = sorted(number_count.items(),key=operator.itemgetter(1),reverse=True)
print(number_count_sort)

# 7개의 리스트로 정리
final_number = []
for i in number_count_sort[:7]:
    final_number.append(i[0])

print("-------------- 결과 --------------------")
print("2등 번호 : {}".format(final_number.pop()))
print("1등 번호 : {}".format(sorted(final_number)))