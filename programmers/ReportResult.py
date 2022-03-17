from collections import defaultdict
'''
defaultdict 사용하면 value 타입만 지정해주면 key에 매핑되는 값을
하나하나 지정 안해줘도 됨.
'''
report = ["muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"]
id_list = ["muzi", "frodo", "apeach", "neo"]
k = 2

answer = [0] * len(id_list)
    
report = set(report)  # 중복제거
    
user_list_who_i_report = defaultdict(set) # 신고한애 : 신고당한애
num_of_reported = defaultdict(int) # 신고당한 : 신고당한 횟수
suspended = [] # 강퇴당할 유저목록

for r in report:
    do_report, be_reported = r.split()
        
    num_of_reported[be_reported] += 1 # 신고당한 : 신고당한 횟수
    user_list_who_i_report[do_report].add(be_reported)
    # 신고한애 : 신고당한애
        
    # k번 당했으면 suspended에 넣어
    if num_of_reported[be_reported] == k:
        suspended.append(be_reported)
for s in suspended:
    for i in range(len(id_list)):
        if s in user_list_who_i_report[id_list[i]]:
            # dict에서 dict[key] 하면 value를 출력함.
            # key = id_list일 때 정지먹을넘이 value에 있는지 확인
            # i는 id_list 에서의 index 역할을 하므로
            answer[i] += 1
            
print(answer)