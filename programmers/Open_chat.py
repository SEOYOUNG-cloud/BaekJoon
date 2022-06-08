record = ["Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"]

answer = []
command = []
change_nick = {}

for i in record:
    in_record = i.split()
    command.append(in_record)
    if in_record[0] == 'Enter' or in_record[0] == 'Change':
        change_nick[in_record[1]] = in_record[2]
        

for i in command:
    if i[0] == 'Enter':
        answer.append(f"{change_nick[i[1]]}님이 들어왔습니다.")
    elif i[0] == 'Leave':
        answer.append(f"{change_nick[i[1]]}님이 나갔습니다.")
        
print(answer)